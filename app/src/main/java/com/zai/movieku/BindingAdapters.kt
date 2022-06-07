package com.zai.movieku

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zai.movieku.network.Movie
import com.zai.movieku.network.Tv
import com.zai.movieku.ui.movies.MovieAdapter
import com.zai.movieku.ui.movies.MoviesApiStatus
import com.zai.movieku.ui.tv.TvAdapter
import com.zai.movieku.ui.tv.TvApiStatus

private const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/original/"

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?){
    val adapter = recyclerView.adapter as MovieAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDatas")
fun bindRecyclerViews(recyclerView: RecyclerView, data: List<Tv>?){
    val adapter = recyclerView.adapter as TvAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let{
        Glide.with(imgView.context)
            .load(BASE_URL_IMAGE + it)
            .apply(
                RequestOptions())
            .into(imgView)
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: MoviesApiStatus?) {
    when (status) {
        MoviesApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
        }
        MoviesApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        MoviesApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiStatuss")
fun bindStatus(statusImageView: ImageView, status: TvApiStatus?) {
    when (status) {
        TvApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
        }
        TvApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        TvApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}