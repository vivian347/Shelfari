package com.example.shelfari.presentation.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.shelfari.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class NavigationItems(
    val title: String,
    val selectedIcon: Painter,
    val route: String
)

data class NavigationItems2(
    val icon: ImageVector,
    val title: String,
    val route: String
)



@Composable
fun NavDrawer(
//    centerName: String,
    drawerState: DrawerState,
    scope: CoroutineScope,
//    selectedItem: MutableState<Int>,
    modifier: Modifier = Modifier.width(300.dp),
//    navController: NavController,
    content: @Composable () -> Unit,
//    viewModel: UserViewModel = hiltViewModel()
){

//    val state by viewModel.state.collectAsState()
//    val user = state.user
    val items = listOf<NavigationItems>(
        NavigationItems(
            title = "Log Out",
            selectedIcon = painterResource(id = R.drawable.logout),
            route = "",
        ),
        NavigationItems(
            title = "Delete Account",
            selectedIcon = painterResource(id = R.drawable.trash),
            route = ""
        ),
    )

    val context = LocalContext.current
//    LaunchedEffect(viewModel, context){
//        viewModel.logoutResult.collect{ result ->
//            when(result) {
//                is Resource.Error -> {
//                    Toast.makeText(
//                        context,
//                        "An error occurred. Try again later",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//                is Resource.Loading -> TODO()
//                is Resource.Success -> {
//                    Toast.makeText(
//                        context,
//                        "Logout Successful!",
//                        Toast.LENGTH_LONG
//                    ).show()
//                    navController.navigate(Routes.LoginScreen.route){
//                        popUpTo(navController.graph.startDestinationId) {
//                            inclusive = true
//                        }
//                    }
//
//                }
//                else -> {}
//            }
//        }
//    }

    val bottomItems = listOf<NavigationItems2>(

    )

//    if(!state.isAuthorized){
//        Toast.makeText(LocalContext.current, "You are not authorized", Toast.LENGTH_LONG).show()
//    }

    ModalNavigationDrawer(
        gesturesEnabled = true,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = modifier
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .width(300.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Row(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(top = 16.dp, start = 16.dp, bottom = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                //                            if (user?.profilePhoto != null){
                                //                                AsyncImage(
                                //                                    model = state.user!!.profilePhoto,
                                //                                    contentDescription = "Profile photo",
                                //                                    contentScale = ContentScale.Crop,
                                //                                    modifier = Modifier
                                //                                        .size(60.dp)
                                //                                        .clip(CircleShape)
                                //                                )
                                //                            } else{
                                Image(
                                    painter = painterResource(id = R.drawable.account),
                                    contentDescription = "Avatar",
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(CircleShape)
                                )
                                //                            }
                                Column(
                                    modifier = Modifier
                                        .padding(horizontal = 16.dp),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "Hi, me!",
                                        style = MaterialTheme.typography.headlineSmall,
                                        color = DarkGray,
                                        modifier = Modifier.padding(bottom = 0.dp)
                                    )

                                }

                            }
                            Row(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(top = 10.dp, start = 16.dp, bottom = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Text(
                                    text = "0 books in your reading list",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = DarkGray,
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                            }
                            Divider(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                thickness = 1.dp,
                                color = DarkGray
                            )
                        }
                    }
                    items.forEachIndexed { index, it ->
                        NavigationDrawerItem(
                            label = { Text(text = it.title) },
                            selected = false,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                }
//                                when (it.title) {
//                                    "Collection Center" -> navController.navigate(route = KethaScreens.CenterListingScreen.route)
//                                    "Bluetooth" -> navController.navigate(route = KethaScreens.BluetoothScreen.route)
//
//                                }
                            },
                            modifier = Modifier.padding(horizontal = 16.dp),
                            icon = {
                                Icon(
                                    painter = it.selectedIcon,
                                    contentDescription = it.title,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(28.dp)
                                )
                            },
                        )

                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column(

                    ) {
                        Text(
                            text = "Developer: Vivian ",
                            color = DarkGray,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(16.dp)
                        )
                    }
                    bottomItems.forEach { it ->

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.Start
                        ) {

                            NavigationDrawerItem(

                                label = { Text(text = it.title) },
                                selected = false,
                                onClick = {


                                },
                                modifier = Modifier.padding(horizontal = 16.dp),
                                icon = {
                                    Icon(
                                        imageVector = it.icon,
                                        contentDescription = it.title,
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            )
                        }
                    }

                }
            }
        },
        content = content
    )
}