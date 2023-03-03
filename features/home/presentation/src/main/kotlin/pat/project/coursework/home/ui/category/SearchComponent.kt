package pat.project.coursework.home.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pat.project.coursework.ui.themes.AppResources
import pat.project.coursework.features.home.presentation.R

@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    value: String,
    placeHolder: String = stringResource(id = R.string.search),
    onTextChanged: (String) -> Unit,
    searchIsFocused: Boolean = false,
    onFocusChange: (Boolean) -> Unit = {},
    onClearSearchText: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .size(40.dp)
            .background(
                color = AppResources.colors.White,
                shape = RoundedCornerShape(size = 16.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            value = value,
            textStyle = AppResources.typography.medium.sp12.copy(
                color = AppResources.colors.Blue
            ),

            onValueChange = { newValue ->
                onTextChanged(newValue)
            },
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .onFocusChanged { isFocused ->
                    onFocusChange(isFocused.isFocused)
                },
            decorationBox = { innerTextBox ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(id = R.string.icon_clean),
                        tint = AppResources.colors.Orange,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .size(24.dp)
                    )
                    if (!searchIsFocused && value.isEmpty()) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = placeHolder,
                            style = AppResources.typography.medium.sp12.copy(
                                color = AppResources.colors.Blue
                            )
                        )
                    } else {
                        innerTextBox()
                    }
                }
            },
            cursorBrush = Brush.verticalGradient(
                listOf(
                    AppResources.colors.Blue,
                    AppResources.colors.Blue
                )
            )
        )
        if (value.isNotEmpty()) {
            IconButton(onClick = {
                onClearSearchText()
            }) {
                Icon(
                    imageVector = Icons.Filled.Cancel,
                    contentDescription = stringResource(id = R.string.icon_clean),
                    tint = AppResources.colors.GreyMedium,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
    }
}
