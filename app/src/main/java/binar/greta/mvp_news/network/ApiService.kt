package binar.greta.mvp_news.network

import binar.greta.mvp_news.model.GetAllNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsItem>>
}