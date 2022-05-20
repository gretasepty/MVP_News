package binar.greta.mvp_news.presenter

import binar.greta.mvp_news.model.GetAllNewsItem
import binar.greta.mvp_news.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPresenter(val viewnews : NewsView ) {
    fun getDataNews(){
        ApiClient.instance.getAllNews()
            .enqueue(object : Callback<List<GetAllNewsItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsItem>>,
                    response: Response<List<GetAllNewsItem>>
                ) {
                    if (response.isSuccessful){
                        viewnews.onSuccess(response.message(), response.body()!!)
                    }else{
                        viewnews.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsItem>>, t: Throwable) {
                    viewnews.onError(t.message!!)
                }
            })
    }

}