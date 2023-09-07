package com.example.metflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.metflix.image.ImageSource
import com.example.metflix.scroll.scroll
import com.example.metflix.ui.theme.MetflixTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetflixTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Image(
                                        painter = painterResource(id = R.drawable.netflix),
                                        contentDescription = "logo",
                                        modifier = Modifier
                                            .size(50.dp)
                                    )
                                },
                                navigationIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Menu Bar"
                                    )
                                },
                                actions = {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = ""
                                    )
                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                    containerColor = Color.Transparent
                                )
                            )
                        }
                    ) { padding ->
                        val state = rememberScrollState()
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                                .verticalScroll(
                                    state = state,
                                    enabled = true,
                                )
                        ) {
                            Text(
                                text = "Spider Man No way home",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(10.dp)
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                                    .clip(RoundedCornerShape(15.dp))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.noway),
                                    contentDescription = "Spider no way"
                                )
                            }

                            Text(
                                text = "Cast >",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(10.dp)
                            )
                            val allData = ImageSource().getAll()
                            LazyRow {
                                items(allData.shuffled()) { item ->
                                    ImageCard(item)
                                }
                            }
                            LazyRow {
                                items(allData.shuffled()) { item ->
                                    ImageCard(item)
                                }
                            }
                            LazyRow {
                                items(allData.shuffled()) { item ->
                                    ImageCard(item)
                                }
                            }
                            LazyRow {
                                items(allData.shuffled()) { item ->
                                    ImageCard(item)
                                }
                            }
                            LazyRow {
                                items(allData.shuffled()) { item ->
                                    ImageCard(item)
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    @Composable
    fun ImageCard(item: scroll) {
        Card(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(id = item.imageRedId),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()

                )
            }
        }
    }
}



