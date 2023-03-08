package pat.project.coursework.cart.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pat.project.coursework.common.domain.entity.Entity
import pat.project.coursework.entity.CartData
import pat.project.coursework.interactor.CartInteractor
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val cartInteractor: CartInteractor
) : ViewModel() {

    private val _cartData = MutableStateFlow(CartData(emptyList(), "", "", 0))
    val cartData get() = _cartData.asStateFlow()

    fun makeRequestForData() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val request = cartInteractor.getCartInfo()) {
                is Entity.Success -> {
                    val homeData = request.data
                    _cartData.value = homeData
                }
                is Entity.Error -> {

                }
            }
        }

    }
}