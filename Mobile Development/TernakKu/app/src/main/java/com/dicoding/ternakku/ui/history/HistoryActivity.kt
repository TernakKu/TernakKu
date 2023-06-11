package com.dicoding.ternakku.ui.history

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.ternakku.data.retrofit.ApiConfig
import com.dicoding.ternakku.data.retrofit.response.HistoryNewResponse
import com.dicoding.ternakku.data.retrofit.response.HistoryPredictItem
import com.dicoding.ternakku.databinding.ActivityHistoryBinding
import com.dicoding.ternakku.preference.LoginPreference
import com.dicoding.ternakku.viewmodelfactory.ViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "dataSetting")
class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var historyViewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.rvHistory.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvHistory.addItemDecoration(itemDecoration)

        setupView()
        setupViewModel()
        getHistory()

    }

    private fun getHistory(){
        historyViewModel.getUserData().observe(this){history ->
            val token = history.token
            val userId = history.userId

            val service = ApiConfig.getApiService().getHistory("Bearer $token", userId)
            service.enqueue(object : Callback<HistoryNewResponse>{
                override fun onResponse(
                    call: Call<HistoryNewResponse>,
                    response: Response<HistoryNewResponse>
                ) {
                    if (response.isSuccessful){
                        showLoading(false)
                        val responseBody = response.body()
                        if (responseBody!= null){
                            getHistoryData(responseBody.historyPredict)

                        }
                    }
                }

                override fun onFailure(call: Call<HistoryNewResponse>, t: Throwable) {
                    Log.e("HistoryActivity", "onFailure: ${t.message.toString()}")
                    Toast.makeText(this@HistoryActivity, "Gagal instance Retrofit", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

    private fun getHistoryData(listHistory: List<HistoryPredictItem>){
        val adapter = HistoryAdapter(listHistory)
        binding.rvHistory.adapter = adapter
    }

    private fun setupViewModel(){
        historyViewModel = ViewModelProvider(
            this,
            ViewModelFactory(LoginPreference.getInstance(dataStore))
        )[HistoryViewModel::class.java]
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.title = "Riwayat Pemindaian"
    }

    private fun showLoading(isLoading: Boolean){
        if (isLoading){
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}