package com.example.shelfari.presentation.shelves

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shelfari.R
import com.example.shelfari.presentation.components.BottomBar
import com.example.shelfari.presentation.shelves.have_read.HaveReadScreen
import com.example.shelfari.presentation.shelves.reading.ReadingScreen
import com.example.shelfari.presentation.shelves.to_read.ToReadScreen
import com.example.shelfari.ui.theme.ShelfariTheme
import com.example.shelfari.ui.theme.yellow

@Composable
fun ShelvesScreen(
    modifier: Modifier = Modifier,
    viewModel: ShelvesViewModel = hiltViewModel()
) {
    val tabIndex = viewModel.tabIndex.observeAsState()

    Scaffold(
        topBar = {
            ShelevesScreenTopBar()
        },
        bottomBar = {
            BottomBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TabRow(selectedTabIndex = tabIndex.value!!) {
                viewModel.tabs.forEachIndexed { index, title ->
                    LeadingIconTab(
                        selected = tabIndex.value!! == index,
                        onClick = { viewModel.updateTabIndex(index) },
                        text = {
                            Text(text = title)
                        },
                        icon = {
                            when(index) {
                                1 -> Image(
                                    painter = painterResource(id = R.drawable.pin),
                                    contentDescription = "pin to read",
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        },
                        selectedContentColor = yellow,
                        unselectedContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }
            }

            when(tabIndex.value){
                0 -> ReadingScreen()
                1 -> ToReadScreen()
                2 -> HaveReadScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShelevesScreenTopBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Shelves",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,

                    )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    ShelfariTheme {
        ShelvesScreen()
    }
}