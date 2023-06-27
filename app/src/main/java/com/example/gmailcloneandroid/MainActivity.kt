package com.example.gmailcloneandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailcloneandroid.components.GmailDrawerMenu
import com.example.gmailcloneandroid.components.HomeAppBar
import com.example.gmailcloneandroid.components.HomeBottomMenu
import com.example.gmailcloneandroid.ui.theme.GmailCloneAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailCloneAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GmailApp()
                }
            }
        }
    }
}

@Composable
fun GmailApp() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    Scaffold(scaffoldState = scaffoldState,
        topBar ={
            HomeAppBar(scaffoldState,coroutineScope)
        },
        drawerContent = {
            GmailDrawerMenu(scrollState = scrollState)
        },
        //Todo 1 add a bottomBar with empty lambda
        bottomBar = {
            //Todo 3: call home bottom menu composable
            HomeBottomMenu()
        })
    {
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailCloneAndroidTheme {
        GmailApp()
    }
}