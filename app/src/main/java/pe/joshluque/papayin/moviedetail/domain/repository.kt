package pe.joshluque.papayin.moviedetail.domain

import pe.joshluque.papayin.data.entity.MovieDetail
import pe.joshluque.papayin.data.network.ApiService

class Repository(private val apiService: ApiService) {

    suspend fun getMovieDetailRequest(id: Long): MovieDetail {
        return apiService.getMovieDetailAsync(id).await()
    }

}