package com.has.sam.cej.railtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var et1:EditText?=null
    var lview:ListView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1=findViewById(R.id.et1)
        lview=findViewById(R.id.lview)
    }

    fun getPnr(v: View)
    {

        var r =Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.railwayapi.com/").build()
        var api=r.create(RailwayAPI::class.java)

        var call:Call<PnrStatusPOJO> = api.getPnrStatus(et1?.text.toString())

        call.enqueue(object : retrofit2.Callback<PnrStatusPOJO> {
            override fun onFailure(call: Call<PnrStatusPOJO>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<PnrStatusPOJO>?, response: Response<PnrStatusPOJO>?) {
                var pnr_status =response?.body()

                var list= mutableListOf<String>()
                list.add("Pnr no:"+pnr_status?.pnr)
                list.add("Train no:"+pnr_status?.train?.number)
                list.add("Train Name:"+pnr_status?.train?.name)
                list.add("From station:"+pnr_status?.fromStation?.name)
                list.add("To station:"+pnr_status?.toStation?.name)
                list.add("Chart Prepared:"+pnr_status?.chartPrepared)
                list.add("Total Passengers:"+pnr_status?.totalPassengers)

                var adapter =ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_dropdown_item_1line,list)

                lview?.adapter=adapter
            }
        })

    }
}
