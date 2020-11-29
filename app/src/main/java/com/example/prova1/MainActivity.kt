package com.example.prova1

import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import com.example.prova1.dominio.DadosGeograficos

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buscarTempo(latitude: Double, longitude: Double) {
        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.consulta(latitude, longitude)?.enqueue(object : Callback<DadosGeograficos?> {
            override fun onResponse(call: Call<DadosGeograficos?>, response: Response<DadosGeograficos?>) {
                val resultado = response?.body()?.currently?.icon.toString();
                if (resultado == "clear-day") {
                    imageContainer.setBackgroundResource(R.drawable.clear_day)
                } else if (resultado == "clear-night") {
                    imageContainer.setBackgroundResource(R.drawable.clear_night)
                } else if (resultado == "partly-cloudy-day"){
                    imageContainer.setBackgroundResource(R.drawable.partly_cloudy_day)
                } else if (resultado == "partly-cloudy-night") {
                    imageContainer.setBackgroundResource(R.drawable.partly_cloudy_night)
                } else if (resultado == "cloudy") {
                    imageContainer.setBackgroundResource(R.drawable.cloudy)
                } else if (resultado == "fog") {
                    imageContainer.setBackgroundResource(R.drawable.fog)
                } else if (resultado == "rain") {
                    imageContainer.setBackgroundResource(R.drawable.rain)
                } else if (resultado == "sleet") {
                    imageContainer.setBackgroundResource(R.drawable.sleet)
                } else if (resultado == "snow") {
                    imageContainer.setBackgroundResource(R.drawable.snow)
                } else if (resultado == "wind") {
                    imageContainer.setBackgroundResource(R.drawable.wind)
                }
                Log.d("Resposta", resultado)
            }
            override fun onFailure(call: Call<DadosGeograficos?>, t: Throwable) {
                Log.e ("Erro", "Ocorreu um erro na sua pesquisa   "+t.message.toString());
            }
        })
    }

    fun handleClick(view: View) {
        val lat = latitude.text.toString().toDouble()
        val long = longitude.text.toString().toDouble()
        buscarTempo(lat, long)
    }
}