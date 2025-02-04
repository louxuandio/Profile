package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.ui.theme.ProfileTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.launch
//reference: HK artist Joey Yung's Instagram Page


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileTheme {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ){
                    Text("yungchoyee",
                        style = TextStyle(fontSize = 16.sp,
                        fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 8.dp))
                    Row (
                        modifier = Modifier
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                        ) {
                            Image(
                                painter = painterResource(com.example.profile.R.drawable.joeyphoto),
                                contentDescription = "Profile Photo",
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(CircleShape), //by ChatGPT
                                contentScale = ContentScale.FillBounds
                            )
                        }
                        Column (
                            modifier = Modifier.padding(24.dp),
                            verticalArrangement = Arrangement.Center
                        ){
                            Text("Joey Yung 容祖兒",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold),
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .padding(vertical = 16.dp)
                            )
                            Row (
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ){
                                Text("posts", style = TextStyle(fontSize = 16.sp))
                                Text("followers", style = TextStyle(fontSize = 16.sp))
                                Text("following", style = TextStyle(fontSize = 16.sp))
                            }
                        }
                    }
                    //bio
                    Text("Musician/band",
                        color = Color.Gray,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(24.dp)
                    )
                    Text("The best and most beautiful things in the world can not be seen or even touched. They must be felt with the heart.",
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(24.dp))
                    //TODO:Follow button
                    val scope = rememberCoroutineScope()
                    var following = remember { mutableStateOf(false) }
                    val snackbarHostState = remember { SnackbarHostState() }

                    Button(
                        onClick = {
                            //snackbar written by ChatGPT
                            scope.launch {
                                snackbarHostState.showSnackbar("You are now following!")
                            }
                            following.value = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            //color code by ChatGPT
                            containerColor = if (following.value) Color.Transparent else Color(0xFF6200EE),
                            contentColor = if (following.value) Color.Gray else Color.White
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(if (following.value) "Following" else "Follow")
                    }

                    //snackbar written by ChatGPT
                    SnackbarHost(hostState = snackbarHostState)
                }
            }
        }
    }
}

