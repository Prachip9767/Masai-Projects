package com.app.pr.ui
import android.content.Context
import com.app.pr.api.Result
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.pr.R
import com.app.pr.databinding.ItemLayoutBinding
import com.bumptech.glide.Glide

class MovieAdapter(private val movielist: List<Result>, homeFragment: Context?):
    RecyclerView.Adapter<BlogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val itemLayoutBinding:ItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_layout, parent, false
        )
        return BlogViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val bloglist = movielist[position]
        holder.onBind(bloglist)


    }

    override fun getItemCount(): Int {
        return movielist.lastIndex
    }

}
class BlogViewHolder(private val itemLayoutBinding: ItemLayoutBinding):
    RecyclerView.ViewHolder(itemLayoutBinding.root)
{

    fun onBind(result: Result) {

        itemLayoutBinding.movie=result
        Glide.with(itemLayoutBinding.ivBack).load("https://image.tmdb.org/t/p/w500/").into(itemLayoutBinding.ivBack)

    }

}