package pe.joshluque.papayin.movielist.domain

import pe.joshluque.papayin.data.entity.MovieList
import pe.joshluque.papayin.data.network.ApiService

class Repository(private val apiService: ApiService) {

    suspend fun getMovieListRequest(page: Int): MovieList {
        return apiService.getMovieListAsync(page).await()
    }

}