package com.has.sam.cej.railtest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RailwayAPI {

    @GET("v2/pnr-status/pnr/{pnrno}/apikey/af9h4f4eho/")
    fun getPnrStatus(@Path("pnrno") s:String) : Call<PnrStatusPOJO>//from retrofit2 select call
}