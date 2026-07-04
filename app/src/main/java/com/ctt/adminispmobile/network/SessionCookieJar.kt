package com.ctt.adminispmobile.network

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class SessionCookieJar : CookieJar {

    private val cookies = mutableListOf<Cookie>()

    override fun saveFromResponse(
        url: HttpUrl,
        cookies: List<Cookie>
    ) {
        this.cookies.clear()
        this.cookies.addAll(cookies)
    }

    override fun loadForRequest(
        url: HttpUrl
    ): List<Cookie> = cookies

    fun getCookies(): List<Cookie> = cookies
}