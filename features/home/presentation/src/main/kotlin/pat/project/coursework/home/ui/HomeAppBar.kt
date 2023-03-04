package pat.project.coursework.home.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pat.project.coursework.features.home.presentation.R
import pat.project.coursework.ui.themes.AppResources


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(
    openFilterBottomSheet: () -> Unit
) =
    CenterAlignedTopAppBar(
        modifier = Modifier.padding(bottom = 0.dp),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(
                            width = 18.dp,
                            height = 24.dp
                        ),
                    imageVector = Icons.Outlined.Place,
                    contentDescription = stringResource(id = R.string.location_icon),
                    tint = AppResources.colors.Orange
                )
                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = stringResource(id = R.string.current_location),
                    color = AppResources.colors.Blue,
                    style = AppResources.typography.medium.sp15
                )
                Icon(
                    modifier = Modifier.size(
                        width = 20.dp,
                        height = 18.dp
                    ),
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = stringResource(id = R.string.location_icon),
                    tint = AppResources.colors.GreyLight
                )
            }
        },
        actions = {
            IconButton(onClick = { openFilterBottomSheet() }) {
                Icon(
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .size(
                            width = 18.dp,
                            height = 22.dp
                        ),
                    imageVector = Icons.Outlined.FilterAlt,
                    contentDescription = stringResource(id = R.string.filter_icon),
                    tint = AppResources.colors.Blue
                )
            }

        },
        scrollBehavior = null
    )
