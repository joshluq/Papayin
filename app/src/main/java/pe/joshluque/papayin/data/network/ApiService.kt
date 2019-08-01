package pe.joshluque.papayin.data.network

import kotlinx.coroutines.Deferred
import pe.joshluque.papayin.data.entity.MovieList
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("movie/popular?api_key=752cd23fdb3336557bf3d8724e115570&language=en-US")
    fun getMovieListAsync(@Query("page") page: Int): Deferred<MovieList>
}