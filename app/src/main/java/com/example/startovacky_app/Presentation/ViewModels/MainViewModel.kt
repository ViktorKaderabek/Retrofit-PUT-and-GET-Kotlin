package com.example.startovacky_app.Presentation.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.startovacky_app.Data.Api.ApiInterface
import com.example.startovacky_app.Data.Modules.StartovackyDataClassItem
import com.example.startovacky_app.Presentation.Adapter.StartovackyFastAdapter
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainViewModel : ViewModel() {

    val itemAdapter =
        ItemAdapter<StartovackyFastAdapter>()

    val fastAdapter =
        FastAdapter.with(itemAdapter)


     suspend fun loadItems() {

        val apiInterface = ApiInterface.create().getData()

        apiInterface.enqueue(object : Callback<List<StartovackyDataClassItem>> {
            override fun onResponse(
                call: Call<List<StartovackyDataClassItem>>?,
                response: Response<List<StartovackyDataClassItem>>?
            ) {

                val responseBody = response?.body()!!
                var myTitleBuilder: String = ""

                for (myData in responseBody) {

                    myTitleBuilder = myData.name.toString()

                    itemAdapter.add(
                        StartovackyFastAdapter(
                            StartovackyDataClassItem(
                                name = myTitleBuilder,
                                id = null
                            )
                        )
                    )

                    Log.e("message", myData.name.toString())

                }
            }


            override fun onFailure(call: Call<List<StartovackyDataClassItem>>?, t: Throwable?) {

            }
        })
    }

    suspend fun createData(){

        val apiInterface = ApiInterface.create().createData(name = "namee")

        apiInterface.enqueue(object : Callback<StartovackyDataClassItem?> {
            override fun onResponse(
                call: Call<StartovackyDataClassItem?>,
                response: Response<StartovackyDataClassItem?>
            ) {

            }

            override fun onFailure(call: Call<StartovackyDataClassItem?>, t: Throwable) {

            }
        })

    }
}