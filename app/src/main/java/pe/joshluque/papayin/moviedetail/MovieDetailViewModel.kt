package pe.joshluque.papayin.moviedetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import pe.joshluque.papayin.data.entity.Movie
import pe.joshluque.papayin.data.network.Api
import pe.joshluque.papayin.data.network.ApiStatus
import pe.joshluque.papayin.movielist.domain.Repository

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie>
        get() = _movie


    fun setMovie(movie: Movie) {
        _movie.value = movie
    }

}