package pat.project.coursework.productsdetailes.ui.tabrow

sealed class TabItems() {
    abstract val tabItemTitle: String

    class Shop : TabItems() {
        override val tabItemTitle: String
            get() = "Shop"
    }

    class Details : TabItems() {
        override val tabItemTitle: String
            get() = "Details"
    }

    class Features : TabItems() {
        override val tabItemTitle: String
            get() = "Details"
    }
}