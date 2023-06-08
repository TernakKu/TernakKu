package com.dicoding.ternakku.preference

data class AuthorizeModel (
    val token: String,
    val userId: String,
    val isLogin: Boolean
)