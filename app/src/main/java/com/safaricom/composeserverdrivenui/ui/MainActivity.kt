package com.safaricom.composeserverdrivenui.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import com.safaricom.composeserverdrivenui.sdui.SDUIDisplayManager
import com.safaricom.composeserverdrivenui.ui.theme.ComposeServerDrivenUITheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposeServerDrivenUITheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainContent()
                }
            }
        }
        init()
    }

    fun init() {

        mainViewModel.error.observe(this, Observer {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        })
        mainViewModel.getViewData()
    }


// initialize data load


    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Composable
    fun MainContent() {

        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "ComposeSDUI") })
            }
        ) {
            Column() {
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                ) {
                    item {
//                        BigCard.Display(
//                            buttonTitle = "Good","bsdbgib b qdwdbkjbkjasd"
//                        )
                        mainViewModel.mainPageData.value?.let { it1 ->
                            SDUIDisplayManager.RootDisplay(
                                it1
                            )
                        }
                    }

                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeServerDrivenUITheme {
            MainContent()
        }
    }
}