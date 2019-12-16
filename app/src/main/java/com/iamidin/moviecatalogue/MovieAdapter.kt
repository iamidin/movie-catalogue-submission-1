package com.iamidin.moviecatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var movies = arrayListOf<Movie>()

    override fun getCount(): Int = movies.size

    override fun getItem(i: Int): Any = movies[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return itemView
    }

    private inner class ViewHolder internal constructor(val view: View) {
        internal fun bind(movie: Movie) {
            with(view) {
                tv_name.text = movie.name
                tv_directed.text = movie.directed
                tv_genre.text = movie.genre
                rb_rating.rating = movie.rating
                tv_description.text = movie.description
                img_photo.setImageResource(movie.photo)
            }
        }
    }
}