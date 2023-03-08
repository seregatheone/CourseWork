package pat.project.coursework.productsdetailes.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pat.project.coursework.common.domain.entity.Entity
import pat.project.coursework.entity.home.ProductDetailedData
import pat.project.coursework.interactor.ProductDetailedInteractor
import javax.inject.Inject

class ProductsDetailsViewModel @Inject constructor(
    private val productDetailedInteractor: ProductDetailedInteractor
) : ViewModel() {

    private var _productDetailedData = MutableStateFlow(
        ProductDetailedData(
            cPU = "",
            camera = "",
            capacity = listOf(),
            color = listOf(),
            id = "",
            images = listOf(),
            isFavorites = true,
            price = 0,
            rating = 0f,
            sd = "",
            ssd = "",
            title = ""
        )
    )
    val phoneDetailedData get() = _productDetailedData.asStateFlow()

    fun requestData() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val request = productDetailedInteractor.getProductDetailedInfo()) {
                is Entity.Success -> {
                    val productDetailedData = request.data
                    _productDetailedData.value = productDetailedData
                }
                is Entity.Error -> {

                }
            }
        }
    }
}