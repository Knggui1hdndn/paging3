package com.example.phntrangtrongrcy.contract

import com.example.phntrangtrongrcy.model.entity.ApiResponse
import com.example.phntrangtrongrcy.model.entity.User

interface MainActivityContract {
    interface View {
        fun onSuccess(listData: List<User>)
        fun onError(message: String)
    }

    interface Presenter {
        fun getData(page: Int, callback: (List<User>) -> Unit)
    }
}