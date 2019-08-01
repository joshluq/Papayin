package pe.joshluque.papayin.data.network

import kotlinx.coroutines.Deferred
import pe.joshluque.papayin.data.entity.MovieList
import retrofit2.http.POST

interface ApiService {
    @POST("movie/popular")
    fun getMovieList(): Deferred<MovieList>
}