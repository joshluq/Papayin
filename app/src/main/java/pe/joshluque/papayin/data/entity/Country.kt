package pe.joshluque.papayin.data.entity

import com.squareup.moshi.Json

data class Country(
    @Json(name = "name")
    val name: String
)