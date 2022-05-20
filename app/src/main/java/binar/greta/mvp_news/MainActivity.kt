package binar.greta.mvp_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import binar.greta.mvp_news.model.GetAllNewsItem
import binar.greta.mvp_news.presenter.NewsPresenter
import binar.greta.mvp_news.presenter.NewsView
import binar.greta.mvp_news.view.AdapterNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsView {

    private lateinit var presenternews : NewsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenternews = NewsPresenter(this)
        presenternews.getDataNews()
    }

    override fun onSuccess(pesan: String, news: List<GetAllNewsItem>) {
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = AdapterNews(news)

    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }
}