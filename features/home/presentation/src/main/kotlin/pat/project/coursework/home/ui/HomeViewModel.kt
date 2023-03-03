package pat.project.coursework.home.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pat.project.coursework.home.ui.category.model.CategoriesMock
import pat.project.coursework.home.ui.category.model.Category
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    private val _categories = MutableStateFlow(emptyList<Category>())
    val categories get() = _categories.asStateFlow()

    init {
        _categories.value = CategoriesMock.categories
    }
}