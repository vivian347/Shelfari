package com.example.shelfari.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shelfari.R
import com.example.shelfari.presentation.components.BottomBar
import com.example.shelfari.presentation.components.NavDrawer
import com.example.shelfari.ui.theme.ShelfariTheme
import com.example.shelfari.ui.theme.yellow
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(

) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val hazeState = remember{ HazeState() }

    val categoryList = listOf<Categories>(
        Categories(
            image = painterResource(id = R.drawable.dollar),
            title = "Finance"
        ),
        Categories(
            image = painterResource(id = R.drawable.education_removebg_preview__1_),
            title = "Education"
        ),
        Categories(
            image = painterResource(id = R.drawable.philosophy),
            title = "Philosophy"
        ),
        Categories(
            image = painterResource(id = R.drawable.food),
            title = "Food"
        ),
        Categories(
            image = painterResource(id = R.drawable.tech),
            title = "Technology"
        ),
        Categories(
            image = painterResource(id = R.drawable.space),
            title = "Space"
        ),
        Categories(
            image = painterResource(id = R.drawable.games),
            title = "Games"
        ),
    )

    NavDrawer(
        drawerState = drawerState,
        scope = scope,
        content = {
            Scaffold(
                modifier = Modifier.background(Color.White),
                topBar = {
                    Surface(
                        shadowElevation = 0.dp
                    ) {
                        HomeScreenTopBar(
                            onMenuButtonClicked = {
                                scope.launch {
                                    drawerState.open()
                                }

                            },
                            onSearchButtonClicked = {}
                        )
                    }
                },
                bottomBar = {
                    BottomBar(
                        modifier = Modifier.hazeChild(state = hazeState)
                    )
                }
            ) { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),

                ) {
                    Column(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize()
                            .padding(vertical = 8.dp, horizontal = 16.dp)

                        ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(bottom = 16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.track),
                                contentScale = ContentScale.Crop,
                                contentDescription = "BG image",
                                alpha = 0.5f,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(26.dp))

                            )
                            Column {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(), // Make the inner Box take up all available space
                                    contentAlignment = Alignment.Center // Center the content inside this Box
                                ) {
                                    Text(
                                        text = "Track your\nreading activity",
                                        style = MaterialTheme.typography.headlineMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                                        textAlign = TextAlign.Center // Center align the text itself
                                    )


                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Box(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(12.dp))
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .background(color = Color(0xFFFFDE59))
                                            .fillMaxWidth()
                                            .height(86.dp)

                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.girl_removebg_preview),
                                            contentDescription = "girl",
                                            modifier = Modifier.padding(8.dp)
                                        )
                                    }
                                }
                            }

                        }

                        Text(
                            text = "Categories",
                            style = MaterialTheme.typography.headlineSmall,
                            fontSize = 21.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(12.dp))

                        LazyRow(
                            modifier = Modifier.padding(horizontal = 8.dp) // Optional padding for LazyRow
                        ) {
                            items(categoryList) { category ->
                                Column(
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .wrapContentHeight()
                                        .padding(horizontal = 8.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = category.image,
                                        contentDescription = category.title,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(45.dp)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = category.title,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "My Reading List",
                            style = MaterialTheme.typography.headlineSmall,
                            fontSize = 21.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Box(
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.girl_removebg_preview),
                                    contentDescription = "girl",
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .size(80.dp)
                                )
                            }
                            Text(
                                text = "Uh oh, you have no current reads!",
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Explore books and add them to reading now shelf to show them here",
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(
    onMenuButtonClicked: () -> Unit,
    onSearchButtonClicked: () -> Unit
){
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onMenuButtonClicked) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        actions = {
            IconButton(
                onClick = onSearchButtonClicked,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Gray, shape = CircleShape)
                    .clip(CircleShape)
            ){
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}

data class Categories(
    val image: Painter,
    val title: String
)

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ShelfariTheme {
        HomeScreen()
    }
}