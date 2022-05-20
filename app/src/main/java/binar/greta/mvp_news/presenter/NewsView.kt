package binar.greta.mvp_news.presenter

import binar.greta.mvp_news.model.GetAllNewsItem

interface NewsView {

    fun onSuccess(pesan : String, news : List<GetAllNewsItem>)
    fun onError(pesan : String)
}