package com.example.shelfari.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.shelfari.R
import com.example.shelfari.ui.theme.yellow

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    val bottomBarItems = listOf(
        BottomBarItem(
            title = "Home",
            icon = painterResource(id = R.drawable.home),
            isSelected = true
        ),
        BottomBarItem(
            title = "Shelves",
            icon = painterResource(id = R.drawable.shelves),
            isSelected = false
        ),
        BottomBarItem(
            title = "Favourites",
            icon = painterResource(id = R.drawable.favs),
            isSelected = false
        ),
        BottomBarItem(
            title = "Reviews",
            icon = painterResource(id = R.drawable.review),
            isSelected = false
        )
    )

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(26.dp))
            .padding(vertical = 14.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        bottomBarItems.forEach {
            if (it.isSelected) {
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = it.icon,
                        contentDescription = it.title,
                        tint = yellow,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = it.title,
                        color = yellow.copy(alpha = 2f),
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            } else {
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = it.icon,
                        contentDescription = it.title,
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = it.title,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

data class BottomBarItem(
    val title: String,
    val icon: Painter,
    val isSelected: Boolean
    )

