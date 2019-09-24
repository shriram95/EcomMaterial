package com.example.ecommaterial.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommaterial.network.EcomApi
import com.example.ecommaterial.network.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getProductsList()
    }

    private fun getProductsList() {
        EcomApi.retrofitService.getProductList().enqueue(
            object: Callback<List<Product>> {
                override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                    _response.value = "Success: ${response.body()?.size} Mars properties retrieved"
                }

                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                    _response.value = "Failure: " + t.message
                }
            })
    }
}
