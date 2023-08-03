package com.hearthstone.core_networking.adapter

import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class NetworkResponseAdapter(
    private val responseType: Type,
    private val moshi: Moshi
): CallAdapter<Type, Any> {

    override fun responseType(): Type = responseType
    override fun adapt(call: Call<Type>) = NetworkResponseCall(call,moshi)
}