package com.app.pr.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.app.pr.api.Result
import com.app.pr.R
import com.app.pr.api.OnCardClicked
import com.app.pr.databinding.FragmentHomeBinding
import com.app.pr.repo.ViewModel
import com.app.pr.di.Status
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) ,OnCardClicked{
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var adapter: MovieAdapter
    var movieList = mutableListOf<Result>()
    private val viewModel :ViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        viewModel.getDataFromApi().observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.ERROR->{
                    Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS->{
                    movieList.clear()

                    it.data?.results.let {
                        if (it!=null){
                            movieList.addAll(it)
                            adapter.notifyDataSetChanged()
                        }
                    }

                }
            }
    })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return homeBinding.root
    }

    private fun setRecyclerView() {
        adapter = MovieAdapter(movieList,context)
        homeBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
        }
    }

    override fun onCardClicked(result: Result) {
        val bundle = Bundle()
        bundle.putString("img",result.posterPath)
        bundle.putString("date",result.releaseDate)
        bundle.putString("language",result.originalLanguage)
        bundle.putString("popularity",result.popularity.toString())
        bundle.putString("revenue",result.voteAverage.toString())
        bundle.putString("overview", result.overview)
        parentFragmentManager.setFragmentResult("movie",bundle)

        //navigating
        Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_movieDetailsFragment)
    }
}