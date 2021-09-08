package com.safaricom.composeserverdrivenui.sdui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.safaricom.composeserverdrivenui.R


object ButtonCard {
    @Composable
    fun Display(buttonTitle: String, horizontalPadding: Int, verticalPadding: Int) {
        Column(
            Modifier
                .padding(horizontal = horizontalPadding.dp)
                .padding(vertical = verticalPadding.dp)
        ) {
            Card(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
                    .clickable {

                    },
                elevation = 4.dp,

                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_card_giftcard_24),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        tint = MaterialTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = buttonTitle, style = TextStyle(fontWeight = FontWeight.Bold))
                }
            }
        }
    }

    data class ButtonCardData(val title: String)
}