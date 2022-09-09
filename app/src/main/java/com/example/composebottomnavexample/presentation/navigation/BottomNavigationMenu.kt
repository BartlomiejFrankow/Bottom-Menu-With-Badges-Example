package com.example.composebottomnavexample.presentation.navigation

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composebottomnavexample.R
import com.example.composebottomnavexample.presentation.navigation.Navigation.*

@Composable
fun BottomNavigationMenu(
    modifier: Modifier = Modifier,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Gray,
        elevation = 6.dp
    ) {
        getBottomNavigationItems(LocalContext.current).forEach { item ->
            val isSelected = item.route == backStackEntry.value?.destination?.route

            BottomNavigationItem(
                selected = isSelected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Yellow,
                unselectedContentColor = Color.LightGray,
                icon = { NavigationIcon(item, isSelected) }
            )
        }
    }
}

@Composable
private fun NavigationIcon(item: BottomNavItem, isSelected: Boolean) {
    Column(horizontalAlignment = CenterHorizontally) {
        if (item.badgeCount > 0) {
            BadgedBox(badge = { Badge { Text(item.badgeCount.toString()) } }) {
                Icon(item.icon, contentDescription = item.name)
            }
        } else {
            Icon(imageVector = item.icon, contentDescription = item.name)
        }

        if (isSelected) Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
    }
}

fun getBottomNavigationItems(context: Context) = listOf(
    BottomNavItem(
        name = context.getString(R.string.home),
        route = HOME.value,
        icon = Icons.Default.Home
    ),
    BottomNavItem(
        name = context.getString(R.string.chat),
        route = CHAT.value,
        icon = Icons.Default.Notifications,
        badgeCount = 7
    ),
    BottomNavItem(
        name = context.getString(R.string.settings),
        route = SETTINGS.value,
        icon = Icons.Default.Settings
    )
)
