package com.safaricom.composeserverdrivenui.sdui.layoutcontainers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.safaricom.composeserverdrivenui.sdui.SDUIDisplayManager

object VerticalScrollable {
    @Composable
    fun Display(data:List<Any>) {
        Column(content = {
               data.map { SDUIDisplayManager.Display(data = it) }
        })

    }
}