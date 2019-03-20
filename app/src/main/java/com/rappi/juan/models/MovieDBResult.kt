package com.rappi.juan.models

import java.io.Serializable

class MovieDBResult : Serializable {

    var page: Int? = null
    var total_results: Int? = null
    var total_pages: Int? = null
    var results: List<Result>? = null
}
