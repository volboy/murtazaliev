package com.murtazaliev.labtinkoff.common

import com.murtazaliev.labtinkoff.`interface`.RetrofitServieces
import com.murtazaliev.labtinkoff.retrofit.RetrofitClient

object Common {
    private const val LATEST_URL = "https://developerslife.ru/"
    private const val HOT_URL = "https://developerslife.ru/hot/"
    private const val TOP_URL = "https://developerslife.ru/top/"
    val retrofitService: RetrofitServieces
        get() = RetrofitClient.getClient(LATEST_URL).create(RetrofitServieces::class.java)
}