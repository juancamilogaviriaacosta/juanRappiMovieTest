package com.rappi.juan.models

import java.io.Serializable

class Result : Serializable {

    var vote_count: Int? = null
    var id: Int? = null
    var video: Boolean? = null
    var vote_average: Double? = null
    var title: String? = null
    var popularity: Double? = null
    var poster_path: String? = null
    var original_language: String? = null
    var original_title: String? = null
    var genre_ids: List<Int>? = null
    var backdrop_path: String? = null
    var adult: Boolean? = null
    var overview: String? = null
    var release_date: String? = null
}