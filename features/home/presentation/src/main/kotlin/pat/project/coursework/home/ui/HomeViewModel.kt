package pat.project.coursework.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pat.project.coursework.entity.home.BestSellerDataModel
import pat.project.coursework.entity.home.HotSalesDataModel
import pat.project.coursework.home.ui.model.*
import pat.project.coursework.interactor.HomeInteractor
import pat.project.coursework.common.domain.entity.Entity
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val homeInteractor: HomeInteractor
) : ViewModel() {
    private val _categories = MutableStateFlow(emptyList<Category>())
    val categories get() = _categories.asStateFlow()

    private val _hotSales = MutableStateFlow(emptyList<HotSalesDataModel>())
    val hotSales get() = _hotSales.asStateFlow()

    private val _bestSellers = MutableStateFlow(emptyList<BestSellerDataModel>())
    val bestSellers get() = _bestSellers.asStateFlow()

    fun makeRequestForData() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val request = homeInteractor.getHomeInfo()) {
                is Entity.Success -> {
                    val homeData = request.data
                    _hotSales.value = homeData.hotSalesDataModelList
                    _bestSellers.value = homeData.bestSellerDataModelList
                }
                is Entity.Error -> {

                }
            }
        }

    }

    init {
        _categories.value = CategoriesMock.categories
    }
}