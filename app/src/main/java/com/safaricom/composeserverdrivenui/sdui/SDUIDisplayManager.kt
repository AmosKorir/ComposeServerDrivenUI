package com.safaricom.composeserverdrivenui.sdui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.safaricom.composeserverdrivenui.data.apiresponse.Content
import com.safaricom.composeserverdrivenui.data.apiresponse.MainViewApiResponse
import com.safaricom.composeserverdrivenui.sdui.components.BigCard
import com.safaricom.composeserverdrivenui.sdui.components.ButtonCard
import com.safaricom.composeserverdrivenui.sdui.layoutcontainers.HorizontalScrollable
import com.safaricom.composeserverdrivenui.sdui.layoutcontainers.VerticalScrollable

object SDUIDisplayManager {
    @Composable
    fun Display(data: Any) {
        when (data) {
            is Content -> {
                Display(key = data.view_type, data)
            }

        }

    }

    @Composable
    fun Display(key: String, data: Any) = when (key) {
        "buttonCard" -> {
            val dataContent = data as Content
            val title = dataContent.data.title ?: ""
            ButtonCard.Display(
                title,
                dataContent.horizontal_padding ?: 0,
                dataContent.vertical_padding ?: 0
            )
        }
        "bigCard" -> {
            val dataContent = data as Content
            val title = dataContent.data.title ?: ""
            val description = dataContent.data.description ?: ""
            BigCard.Display(
                title,
                description,
                dataContent.horizontal_padding ?: 0,
                dataContent.vertical_padding ?: 0
            )
        }
        "row" -> {
            val dataContent = data as Content
            dataContent.content?.let {
                HorizontalScrollable.Display(it)
            }
        }

        else -> Unit
    }

    @Composable
    fun RootDisplay(data: List<Any>) {
        HorizontalScrollable.Display(data)
        VerticalScrollable.Display(data)
    }

    @Composable
    fun RootDisplay(viewApiResponse: MainViewApiResponse) {
        when (viewApiResponse.view_type) {
            "column" -> {
                VerticalScrollable.Display(viewApiResponse.content)
            }

            "row" -> {
                HorizontalScrollable.Display(viewApiResponse.content)
            }
        }
        val list = viewApiResponse.content


    }

}