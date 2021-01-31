package com.murtazaliev.labtinkoff.model

import android.icu.util.Calendar
import java.net.URL
import java.util.*

data class Article(
    var id: Int? = null,
    var description: String? = null,
    var votes: Int? = null,
    var author: String? = null,
    var date: Date? = null,
    var gifURL: URL? = null,
    var gifSize: Int? = null,
    var previewURL: URL? = null,
    var videoURL: URL? = null,
    var videoPath: String? = null,
    var videoSize: Int? = null,
    var type: String? = null,
    var width: Int? = null,
    var height: Int? = null,
    var commentsCount: Int? = null,
    var fileSize: Int? = null,
    var canVote: Boolean? = null
)


