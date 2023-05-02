package com.example.phntrangtrongrcy.presenter

import com.example.phntrangtrongrcy.contract.MainActivityContract
import com.example.phntrangtrongrcy.model.api.ApiInterface
import com.example.phntrangtrongrcy.model.entity.User
import kotlinx.coroutines.*

class MainActivityPresenter  : MainActivityContract.Presenter {
    @OptIn(DelicateCoroutinesApi::class)
    override fun getData(page: Int, callback: (List<User>) -> Unit) {
        GlobalScope.launch(Dispatchers.Main) {
            val apiService = ApiInterface.apiInterface
            try {
                val users = apiService.getDataAsync(page).await()
                callback(users.data)
            } catch (e: Exception) {
                callback(emptyList())
            }
        }
    }
}