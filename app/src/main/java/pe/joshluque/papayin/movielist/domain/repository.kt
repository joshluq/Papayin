package pe.joshluque.papayin.movielist.domain

import pe.joshluque.papayin.data.network.ApiService

class Repository(apiService: ApiService) {

    val request = apiService.getMovieListAsync(1)


}