package com.example.phntrangtrongrcy.view.adapter

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.phntrangtrongrcy.model.entity.User
import com.example.phntrangtrongrcy.presenter.MainActivityPresenter
import kotlinx.coroutines.flow.Flow
import pagingSource

class UserRepository(private val postApi: MainActivityPresenter) {
    fun getUser(): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { pagingSource(postApi) }
        ).flow
    }
}
