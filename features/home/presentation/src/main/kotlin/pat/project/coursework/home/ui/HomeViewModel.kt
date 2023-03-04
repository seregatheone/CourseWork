package pat.project.coursework.home.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pat.project.coursework.home.ui.model.*
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    private val _categories = MutableStateFlow(emptyList<Category>())
    val categories get() = _categories.asStateFlow()

    private val _hotSales = MutableStateFlow(emptyList<HotSalesDataModel>())
    val hotSales get() = _hotSales.asStateFlow()

    private val _bestSellers = MutableStateFlow(emptyList<BestSellerDataModel>())
    val bestSellers get() = _bestSellers.asStateFlow()

    init {
        _categories.value = CategoriesMock.categories
        _hotSales.value = HotSalesMock.hotSales
        _bestSellers.value = BestSellersMock.bestSellers
    }
}