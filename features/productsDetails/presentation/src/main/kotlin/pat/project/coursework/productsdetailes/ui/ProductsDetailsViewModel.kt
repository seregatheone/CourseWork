package pat.project.coursework.productsdetailes.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pat.project.coursework.entity.home.PhoneDetailedData
import javax.inject.Inject

class ProductsDetailsViewModel @Inject constructor() : ViewModel() {

    private var _phoneDetailedData = MutableStateFlow<PhoneDetailedData?>(null)
    val phoneDetailedData get() = _phoneDetailedData.asStateFlow()

    fun requestData() {
        viewModelScope.launch(Dispatchers.IO) {
            _phoneDetailedData.value = PhoneDetailedData(
                cPU = "Exynos 990",
                camera = "108 + 12 mp",
                capacity = listOf(),
                color = listOf(),
                id = "3",
                images = listOf(),
                isFavorites = true,
                price = 1500,
                rating = 4.5f,
                sd = "256 GB",
                ssd = "8 GB",
                title = " Galaxy Note 20 Ultra"
            )
        }
    }
}