package com.dicoding.ternakku

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.ternakku.data.retrofit.Disease
import com.dicoding.ternakku.databinding.ActivityMainBinding
import com.dicoding.ternakku.preference.LoginPreference
import com.dicoding.ternakku.ui.detail.DetailActivity
import com.dicoding.ternakku.ui.favorite.FavoriteActivity
import com.dicoding.ternakku.ui.history.HistoryActivity
import com.dicoding.ternakku.ui.login.LoginActivity
import com.dicoding.ternakku.ui.scan.ScanActivity
import com.dicoding.ternakku.viewmodelfactory.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "dataSetting")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    private lateinit var rView: RecyclerView
    private val list = ArrayList<Disease>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewModel()

        rView = findViewById(R.id.rV_list)
        rView.setHasFixedSize(true)

        list.addAll(getListPenyakit())
        showRecyclerList()

        binding.efbScan.setOnClickListener {
            val intent = Intent(this@MainActivity, ScanActivity::class.java)
            startActivity(intent)
        }

        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                return true
            }

        })

        binding.icLogout.setOnClickListener {
            mainViewModel.logout()
        }

        binding.icFav.setOnClickListener {
            startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))
        }

        binding.icHistory.setOnClickListener {
            startActivity(Intent(this@MainActivity, HistoryActivity::class.java))
        }
        setUpFloatingActionButton()
    }

    private fun setViewModel(){
        val pref = LoginPreference.getInstance(dataStore)
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(pref)
        )[MainViewModel::class.java]

        mainViewModel.getLoginUser().observe(this) { user ->
            if (user.isLogin) {

            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }

        }
    }

    private fun getListPenyakit(): ArrayList<Disease> {
        val dataId = resources.getIntArray(R.array.id_penyakit)
        val dataName = resources.getStringArray(R.array.nama_penyakit)
        val dataDescription = resources.getStringArray(R.array.detail_penyakit)
        val dataHeandle = resources.getStringArray(R.array.cara_mengatasi)
        val listPenyakit = ArrayList<Disease>()
        for (i in dataName.indices) {
            val penyakit = Disease(dataId[i],dataName[i], dataDescription[i], dataHeandle[i])
            listPenyakit.add(penyakit)
        }
        return listPenyakit
    }

    private fun showRecyclerList() {
        rView.layoutManager = LinearLayoutManager(this)
        val listPenyakit = ListPenyakitAdapter(list)
        rView.adapter = listPenyakit

        listPenyakit.setOnItemClickCallback(object : ListPenyakitAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Disease) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra(EXTRA_NAME, data)
                intentToDetail.putExtra(EXTRA_ID, data.id)
                intentToDetail.putExtra(EXTRA_NAMED, data.name)
                intentToDetail.putExtra(EXTRA_DETAIL, data.detail)
                startActivity(intentToDetail)
            }
        })
    }

    private fun showLoading(isLoading: Boolean){
        if (isLoading){
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun setUpFloatingActionButton() {
        binding.efbScan.setOnClickListener {
            startActivity(Intent(this@MainActivity, ScanActivity::class.java))
        }
        // Detect a scroll and respond based on the direction
        binding.rVList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0){ // Scrolling down
                    binding.efbScan.extend()
                }else{ // Scrolling up
                    binding.efbScan.shrink()
                }
            }
        })
    }

    companion object{
        const val EXTRA_ID = "extra_id"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_NAMED = "extra_named"
        const val EXTRA_DETAIL = "extra_detail"
    }


}