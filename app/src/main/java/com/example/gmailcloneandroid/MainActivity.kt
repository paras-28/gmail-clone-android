package com.example.gmailcloneandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailcloneandroid.components.*
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
    val openDialog = remember {
        mutableStateOf(false)
    }
    Scaffold(scaffoldState = scaffoldState,
        topBar = {
            //Todo 7:add openDialog as an argument to homeAppBar
            HomeAppBar(scaffoldState,coroutineScope,openDialog)
        },
        drawerContent = {
            GmailDrawerMenu(scrollState = scrollState)
        },
        bottomBar = {
            HomeBottomMenu()
        },
        floatingActionButton = {
            GmailFab(scrollState)
        }){
        MailList(it,scrollState)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailCloneAndroidTheme {
        GmailApp()
    }
}