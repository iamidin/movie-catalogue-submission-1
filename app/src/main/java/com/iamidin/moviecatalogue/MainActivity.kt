package com.iamidin.moviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    private lateinit var adapter: MovieAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDirected: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataRating: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            setDisplayUseLogoEnabled(true)
            setDisplayShowHomeEnabled(true)
            setIcon(R.drawable.muka_transparent)
        }

        adapter = MovieAdapter(this)
        lv_list.adapter = adapter
        prepare()
        addItem()

        lv_list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val moveWithObjectIntent = Intent(this, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MOVIE, movies[position])
            startActivity(moveWithObjectIntent)
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDirected = resources.getStringArray(R.array.data_directed)
        dataGenre = resources.getStringArray(R.array.data_genre)
        dataRating = resources.getStringArray(R.array.data_rating)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val movie = Movie(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDirected[position],
                dataGenre[position],
                dataRating[position].toFloat(),
                dataDescription[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }
}
