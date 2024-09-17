package com.example.kotlinenjoyerstemplate.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.kotlinenjoyerstemplate.R

object BottomNavButtons {

    val buttons = listOf(
        BottomNavButton(
            labelId = R.string.bottomNavName1,
            iconId = R.drawable.ic_home_24dp,
            route = BottomNavDestination.Destination1,
        ),
        BottomNavButton(
            labelId = R.string.bottomNavName2,
            iconId = R.drawable.ic_home_24dp,
            route = BottomNavDestination.Destination2,
        ),
        BottomNavButton(
            labelId = R.string.bottomNavName3,
            iconId = R.drawable.ic_home_24dp,
            route = BottomNavDestination.Destination3,
        ),
        BottomNavButton(
            labelId = R.string.bottomNavName4,
            iconId = R.drawable.ic_home_24dp,
            route = BottomNavDestination.Destination4,
        ),
        BottomNavButton(
            labelId = R.string.demo,
            iconId = R.drawable.ic_brush_24dp,
            route = BottomNavDestination.DemoScreen,
        ),
    )
}

data class BottomNavButton(
    @StringRes val labelId: Int,
    @DrawableRes val iconId: Int,
    val route: NavDestination,
)
