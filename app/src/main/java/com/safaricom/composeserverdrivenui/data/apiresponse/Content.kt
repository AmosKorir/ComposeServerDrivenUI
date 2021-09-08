package com.safaricom.composeserverdrivenui.data.apiresponse

data class Content(
    val `data`: Data,
    val view_type: String,
    val vertical_padding: Int?,
    val horizontal_padding: Int?,
    val content: List<Content>?
)