package pat.project.coursework.home.ui.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import pat.project.coursework.ui.themes.AppResources

@Composable
fun FilterOptionsItem(
    modifier: Modifier = Modifier,
    filterOption: FilterOptions
) {

    var expandedState by remember {
        mutableStateOf(false)
    }

    val icon = if (expandedState)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    var filterText by remember {
        mutableStateOf("")
    }

    var filterTextSize by remember { mutableStateOf(Size.Zero) }

    Column(modifier = modifier.padding(top = 20.dp)) {
        Text(
            text = filterOption.stateTitle,
            style = AppResources.typography.medium.sp18,
            color = AppResources.colors.Blue
        )
        Row(
            modifier = Modifier
                .padding(top = 4.dp, end = 6.dp)
                .border(
                    width = 1.dp,
                    color = AppResources.colors.GreyDustLight,
                    shape = RoundedCornerShape(5.dp)
                )
                .background(
                    color = AppResources.colors.White,
                    shape = RoundedCornerShape(5.dp)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = filterText,
                onValueChange = { filterText = it },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 7.dp, horizontal = 14.dp)
                    .focusable(false)
                    .weight(1f)
                    .onGloballyPositioned { coordinates ->
                        filterTextSize = coordinates.size.toSize()
                    },
                textStyle = AppResources.typography.regular.sp18.copy(color = AppResources.colors.Blue),
                decorationBox = { innerTextBox ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (filterText.isEmpty()) {
                            Text(
                                modifier = Modifier.weight(1f),
                                text = filterOption.stateTitle,
                                style = AppResources.typography.regular.sp18.copy(color = AppResources.colors.GreyLight),
                            )
                        } else {
                            innerTextBox()
                        }
                    }
                }
            )
            Icon(
                imageVector = icon,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(30.dp)
                    .clickable { expandedState = !expandedState },
                contentDescription = null
            )
        }



        DropdownMenu(
            modifier = Modifier.width(with(LocalDensity.current) { filterTextSize.width.toDp() }),
            expanded = expandedState,
            onDismissRequest = { expandedState = false }
        ) {
            filterOption.variants.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        filterText = label
                        expandedState = false
                    },
                    text = {
                        Text(
                            text = label,
                            style = AppResources.typography.regular.sp18,
                            color = AppResources.colors.Blue
                        )
                    }

                )
            }
        }
    }
}