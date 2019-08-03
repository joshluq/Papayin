package pe.joshluque.papayin.data.network

import kotlinx.coroutines.Deferred
import pe.joshluque.papayin.data.entity.MovieDetail
import pe.joshluque.papayin.data.entity.MovieList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular?api_key=752cd23fdb3336557bf3d8724e115570&language=en-US")
    fun getMovieListAsync(@Query("page") page: Int): Deferred<MovieList>

    @GET("movie/{movie_id}?api_key=752cd23fdb3336557bf3d8724e115570&language=en-US&append_to_response=videos")
    fun getMovieDetailAsync(@Path("movie_id") id: Long): Deferred<MovieDetail>
}