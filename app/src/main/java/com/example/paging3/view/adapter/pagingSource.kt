import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.phntrangtrongrcy.model.entity.ApiResponse
import com.example.phntrangtrongrcy.model.entity.User
import com.example.phntrangtrongrcy.presenter.MainActivityPresenter

class pagingSource(val API: MainActivityPresenter) : PagingSource<Int, User>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        var position = params.key ?: 1
        var list = emptyList<User>()
        API.getData(position) {
            list = it
        }
        return LoadResult.Page(
            data = list,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (list.isEmpty()) null else position + 1
        )

    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}