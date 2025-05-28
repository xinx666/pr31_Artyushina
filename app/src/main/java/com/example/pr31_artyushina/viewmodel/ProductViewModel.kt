package com.example.pr31_artyushina.viewmodel

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).productDao()
    private val repo = ProductRepository(dao)

    var allProducts by mutableStateOf<List<Product>>(emptyList())
        private set

    var cartItems = mutableStateListOf<CartItem>()

    var searchQuery by mutableStateOf("")
    var filteredProducts by mutableStateOf<List<Product>>(emptyList())

    fun loadProducts() {
        viewModelScope.launch {
            allProducts = repo.getAll()
        }
    }

    fun searchProducts(query: String) {
        viewModelScope.launch {
            searchQuery = query
            filteredProducts = repo.search(query)
        }
    }

    fun addToCart(product: Product) {
        val existing = cartItems.find { it.product.id == product.id }
        if (existing != null) {
            existing.quantity++
        } else {
            cartItems.add(CartItem(product, 1))
        }
    }

    fun increaseQuantity(item: CartItem) {
        item.quantity++
    }

    fun decreaseQuantity(item: CartItem) {
        if (item.quantity > 1) item.quantity--
    }

    fun removeFromCart(item: CartItem) {
        cartItems.remove(item)
    }

}