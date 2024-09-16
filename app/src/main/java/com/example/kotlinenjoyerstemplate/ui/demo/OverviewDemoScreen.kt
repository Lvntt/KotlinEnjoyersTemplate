package com.example.kotlinenjoyerstemplate.ui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlinenjoyerstemplate.R
import com.example.kotlinenjoyerstemplate.ui.DemoNavDestination
import com.example.kotlinenjoyerstemplate.ui.theme.HackathonTheme

@Composable
fun OverviewDemoScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HackathonTheme.colors.background.grey)
            .padding(horizontal = 16.dp, vertical = 32.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        OverviewElement(
            elementName = "Button",
            onClick = {
                navController.navigate(DemoNavDestination.ButtonDemo.baseRoute)
            },
        )
        OverviewElement(
            elementName = "LoaderButton",
            onClick = {
                navController.navigate(DemoNavDestination.LoaderButtonDemo.baseRoute)
            },
        )
        OverviewElement(
            elementName = "Block",
            onClick = {
                navController.navigate(DemoNavDestination.BlockDemo.baseRoute)
            },
        )
        OverviewElement(
            elementName = "HeaderBlock",
            onClick = {
                navController.navigate(DemoNavDestination.HeaderBlockDemo.baseRoute)
            },
        )
        OverviewElement(
            elementName = "Checkbox",
            onClick = {
                navController.navigate(DemoNavDestination.CheckboxDemo.baseRoute)
            },
        )
        OverviewElement(
            elementName = "Switch",
            onClick = {
                navController.navigate(DemoNavDestination.SwitchDemo.baseRoute)
            },
        )
        OverviewElement(
            elementName = "AlertDialog",
            onClick = {
                navController.navigate(DemoNavDestination.AlertDialogDemo.baseRoute)
            },
        )
        OverviewElement(
            elementName = "ErrorScreen",
            onClick = {
                navController.navigate(DemoNavDestination.ErrorScreenDemo.baseRoute)
            },
        )
    }
}

@Composable
private fun OverviewElement(
    elementName: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .sizeIn(
                minWidth = 150.dp,
                minHeight = 75.dp,
            )
            .clip(RoundedCornerShape(12.dp))
            .background(HackathonTheme.colors.common.staticWhite)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(),
                onClick = onClick,
            ),
        contentAlignment = Alignment.CenterStart,
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 16.dp
            )
        ) {
            Text(
                text = elementName,
                style = HackathonTheme.typography.titles.titleL,
            )
            Row(
                modifier = Modifier.align(Alignment.Start),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "View",
                    style = HackathonTheme.typography.titles.titleM,
                    color = HackathonTheme.colors.text.secondary.default,
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_forward_24dp),
                    contentDescription = null,
                    tint = HackathonTheme.colors.icons.secondary,
                )
            }
        }
    }
}

@Preview
@Composable
private fun OverviewDemoScreenPreview() = HackathonTheme {
    OverviewDemoScreen(rememberNavController())
}
