package com.ikxguru.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val userId: Int = -1,
    val id: Int = -1,
    @field:Json(name = "title")
    private val _title: String = "",
    val body: String = ""
) : Parcelable {

    val title
        get() = "$id. $_title"
}