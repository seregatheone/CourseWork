package pat.project.coursework.cart.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material.icons.outlined.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pat.project.coursework.entity.CartItems
import pat.project.coursework.features.cart.presentation.R
import pat.project.coursework.ui.components.buttons.ButtonBackgroundColors
import pat.project.coursework.ui.components.buttons.ButtonStyles
import pat.project.coursework.ui.components.buttons.CustomButton
import pat.project.coursework.ui.themes.AppResources

@Composable
fun CartScreen(
    cartViewModel: CartViewModel,
    cartItems: List<CartItems>,
    navigateBack: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(AppResources.colors.BackgroundWhite),
        bottomBar = { BottomCartAppBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())

        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 24.dp, horizontal = 32.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomButton(
                    onClick = { navigateBack() },
                    buttonStyle = ButtonStyles.CustomIconButton(
                        buttonBackgroundColors = ButtonBackgroundColors.BLUE,
                        buttonIcon = Icons.Outlined.ArrowBackIos
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(end = 4.dp),
                        text = stringResource(id = R.string.add_address),
                        style = AppResources.typography.medium.sp15.copy(color = AppResources.colors.Blue)
                    )
                    CustomButton(
                        onClick = {},
                        buttonStyle = ButtonStyles.CustomIconButton(
                            buttonBackgroundColors = ButtonBackgroundColors.Orange,
                            buttonIcon = Icons.Outlined.Place
                        )
                    )

                }
            }
            Text(
                modifier = Modifier.padding(top = 12.dp, start = 24.dp),
                text = stringResource(id = R.string.my_cart),
                style = AppResources.typography.bold.sp35.copy(color = AppResources.colors.Blue)
            )

            Surface(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                color = AppResources.colors.Blue,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            ) {
                Column {
                    LazyColumn(
                        modifier = Modifier
                            .padding(24.dp)
                            .weight(1f)
                            .sizeIn(maxHeight = 600.dp)
                    ) {
                        items(cartItems.size) { currentItemId ->
                            cartItems[currentItemId]
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(AppResources.colors.WhiteTransparent25)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 40.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                        ) {
                            Text(
                                text = stringResource(id = R.string.total),
                                style = AppResources.typography.regular.sp15.copy(color = AppResources.colors.White)
                            )
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = stringResource(id = R.string.total),
                                style = AppResources.typography.regular.sp15.copy(color = AppResources.colors.White)
                            )
                        }
                        Column(
                        ) {
                            Text(
                                text = stringResource(id = R.string.total),
                                style = AppResources.typography.regular.sp15.copy(color = AppResources.colors.White)
                            )
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = stringResource(id = R.string.total),
                                style = AppResources.typography.regular.sp15.copy(color = AppResources.colors.White)
                            )
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(AppResources.colors.WhiteTransparent25)
                    )
                }


            }
        }

    }


}