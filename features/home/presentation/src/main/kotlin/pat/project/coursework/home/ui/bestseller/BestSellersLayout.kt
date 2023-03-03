package pat.project.coursework.home.ui.bestseller

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pat.project.coursework.features.home.presentation.R
import pat.project.coursework.home.ui.model.BestSellerDataModel
import pat.project.coursework.ui.themes.AppResources

@Composable
fun BestSellersLayout(
    bestSellerList: List<BestSellerDataModel>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.hot_sales),
                style = AppResources.typography.bold.sp25,
                color = AppResources.colors.Blue
            )
            Text(
                modifier = Modifier.padding(end = 12.dp),
                text = stringResource(id = R.string.see_more),
                style = AppResources.typography.regular.sp15,
                color = AppResources.colors.Orange
            )
        }
        LazyVerticalGrid(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .sizeIn(
                    maxHeight = 600.dp
                ),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(bestSellerList.size) { currentBestSellerId ->
                BestSellerItem(bestSellerList[currentBestSellerId])
            }
        }
    }
}