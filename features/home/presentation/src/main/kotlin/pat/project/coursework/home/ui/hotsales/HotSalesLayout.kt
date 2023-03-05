package pat.project.coursework.home.ui.hotsales

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import pat.project.coursework.entity.home.HotSalesDataModel
import pat.project.coursework.features.home.presentation.R
import pat.project.coursework.ui.themes.AppResources

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HotSales(
    modifier: Modifier = Modifier,
    hotSalesList: List<HotSalesDataModel>,
    navigateToProductsDetails: () -> Unit
) {
    Column(
        modifier = modifier
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

        HorizontalPager(
            modifier = Modifier
                .padding(top = 4.dp)
                .clickable(true, onClick = navigateToProductsDetails),
            count = hotSalesList.size,
            itemSpacing = 12.dp
        ) { currentPage ->
            HotSalesItem(hotSalesDataModel = hotSalesList[currentPage])
        }

    }
}