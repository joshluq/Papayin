package pe.joshluque.papayin.data.entity

enum class Gender(val id: Int, val value: String) {
    ACTION(28, "Action"),
    ADVENTURE(12, "Adventure"),
    ANIMATION(16, "Animation"),
    COMEDY(35, "Comedy"),
    CRIME(80, "Crime"),
    DOCUMENTARY(99, "Documentary"),
    DRAMA(18, "Drama"),
    FAMILY(10751, "Family"),
    FANTASY(14, "Fantasy"),
    HISTORY(36, "History"),
    HORROR(27, "Horror"),
    MUSIC(10402, "Music"),
    MISTERY(9648, "Mystery"),
    ROMANCE(10749, "Romance"),
    SCIENCE_FICTION(878, "Science Fiction"),
    TV_MOVIE(10770, "TV Movie"),
    THILLER(53, "Thriller"),
    WAR(10752, "war"),
    WESTERN(37, "Western"),
    NONE(0, "none");


    companion object {
        fun getGenders(ids: List<Int>): List<Gender> {
            return ids.map {
                getGender(it)
            }
        }
        private fun getGender(id: Int): Gender {
            return values().firstOrNull { id == it.id } ?: NONE
        }
    }

}