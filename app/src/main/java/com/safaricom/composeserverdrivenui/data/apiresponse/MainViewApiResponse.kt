package com.safaricom.composeserverdrivenui.data.apiresponse

data class MainViewApiResponse(
    val content: List<Content>,
    val view_type: String,
    val vertical_padding: Int?,
    val horizontal_padding: Int?
)