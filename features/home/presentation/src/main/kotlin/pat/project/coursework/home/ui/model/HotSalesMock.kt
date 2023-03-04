package pat.project.coursework.home.ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*

object HotSalesMock {
    val hotSales = listOf(
        HotSalesDataModel(
            id = 1,
            isNew  = true,
            title = "Iphone 12",
            subtitle = "Súper. Mega. Rápido.",
            pictureUrl = "https://img.ibxk.com.br/2020/09/23/23104013057475.jpg?w=1120&h=420&mode=crop&scale=both",
            isBought = true
        ),
        HotSalesDataModel(
            id = 2,
            isNew  = false,
            title = "Samsung Galaxy A71",
            subtitle = "Súper. Mega. Rápido.",
            pictureUrl = "https://cdn-2.tstatic.net/kupang/foto/bank/images/pre-order-samsung-galaxy-a71-laris-manis-inilah-rekomendasi-ponsel-harga-rp-6-jutaan.jpg",
            isBought = true
        )
    )
}