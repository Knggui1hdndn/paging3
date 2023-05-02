package com.example.phntrangtrongrcy.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3.R
 import com.example.phntrangtrongrcy.presenter.MainActivityPresenter
import com.example.phntrangtrongrcy.view.adapter.MainAdapter
import com.example.phntrangtrongrcy.view.adapter.UserRepository

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity()  {
    private lateinit var rcy: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcy = findViewById(R.id.rcy)
        val adapter = MainAdapter()
        rcy.layoutManager = LinearLayoutManager(this)
        rcy.adapter = adapter
        val presenter= MainActivityPresenter()
        // để lắng nghe sự thay đổi của PagingData được phát ra bởi MyPagingSource.
//         sử dụng lifecycleScope giúp đảm bảo rằng coroutine được thực thi trên vòng
//         đời của thành phần Android và tự động hủy bỏ khi thành phần bị hủy bỏ.
        lifecycleScope.launch {
            UserRepository(presenter).getUser().collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }


}