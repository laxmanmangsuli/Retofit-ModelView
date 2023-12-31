package com.example.retrofitmodelview.data.model


import com.google.gson.annotations.SerializedName

data class PlutoCarouselPost(
    @SerializedName("filesize")
    var filesize: Int?,
    @SerializedName("height")
    var height: Int?,
    @SerializedName("mime-type")
    var mimeType: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("width")
    var width: Int?
)