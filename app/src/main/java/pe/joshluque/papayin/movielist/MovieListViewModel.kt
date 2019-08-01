package pe.joshluque.papayin.movielist

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

class MovieListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(Api.retrofitService)

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies


    init {
        getMovies()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


    private fun getMovies() {
        coroutineScope.launch {
            val getMoviesDeferred = repository.request
            try {
                _status.value = ApiStatus.LOADING
                val listResult = getMoviesDeferred.await()
                _status.value = ApiStatus.DONE
                _movies.value = listResult.movies
            } catch (e: Exception) {
                _status.value = ApiStatus.DEFAULT_ERROR
                _movies.value = emptyList()
            }
        }
    }
}