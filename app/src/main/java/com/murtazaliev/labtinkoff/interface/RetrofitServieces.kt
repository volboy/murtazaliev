package com.murtazaliev.labtinkoff.`interface`

import com.murtazaliev.labtinkoff.model.Article
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServieces {
    @GET("random?json=true")
    fun getArticleList(): Call<Article>

}