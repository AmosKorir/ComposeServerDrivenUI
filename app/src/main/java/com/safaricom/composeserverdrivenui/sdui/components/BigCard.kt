package com.safaricom.composeserverdrivenui.sdui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.safaricom.composeserverdrivenui.R

object BigCard {
    @Composable
    fun Display(
        buttonTitle: String,
        description: String,
        horizontalPadding: Int,
        verticalPadding: Int
    ) {
        Column(
            Modifier
                .padding(horizontal = horizontalPadding.dp)
                .padding(vertical = verticalPadding.dp)
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {

                    },
                elevation = 4.dp,

                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(horizontal = 32.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = buttonTitle,
                        style = TextStyle(fontSize = 18.sp)
                    )
                    Divider()

                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_burst_mode_24),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp),
                        tint = MaterialTheme.colors.primary
                    )

                    Text(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .fillMaxWidth(),
                        text = description,
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }


}