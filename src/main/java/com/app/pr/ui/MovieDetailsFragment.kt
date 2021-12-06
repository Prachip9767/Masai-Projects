package com.app.pr.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentResultListener
import com.app.pr.R
import com.app.pr.databinding.FragmentMovieDetailsBinding
import com.bumptech.glide.Glide


class MovieDetailsFragment : Fragment() {
    private lateinit var movieDetailsBinding: FragmentMovieDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false)
        return movieDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingDetails()
    }
    private fun settingDetails() {
        parentFragmentManager.setFragmentResultListener(
            "movie", this, FragmentResultListener() { s: String, bundle: Bundle ->
                val ReleaseDAte = bundle.getString("author")
                movieDetailsBinding.Releasedate.text = "Release Date:$ReleaseDAte "
                val Language = bundle.getString("content")
                movieDetailsBinding.language.text = "Language:$Language "
                val Popularity = bundle.getString("description")
                movieDetailsBinding.popularity.text = "Popularity:$Popularity"
                val Revenue = bundle.getString("publishedAt")
                movieDetailsBinding.revenue.text = "Revenue:$Revenue"
                val Overview = bundle.getString("title")
                movieDetailsBinding.overView.text = "Overview:$Overview"
                val urlToImage = bundle.getString("urlToImage")
                Glide.with(movieDetailsBinding.ivImage).load(urlToImage)
                    .into(movieDetailsBinding.ivImage)
            }
        )
    }

}