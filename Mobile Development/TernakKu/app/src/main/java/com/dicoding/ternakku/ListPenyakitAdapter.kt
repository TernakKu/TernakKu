package com.dicoding.ternakku

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.ternakku.data.retrofit.response.DiseasesItem
import com.dicoding.ternakku.databinding.ListPenyakitBinding
import com.dicoding.ternakku.ui.detail.DetailActivity

class ListPenyakitAdapter (private var listPenyakit : List<DiseasesItem>)  : RecyclerView.Adapter<ListPenyakitAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListPenyakitBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(listPenyakit: DiseasesItem){
            binding.tvName.text =listPenyakit.diseaseName
            binding.tvDescription.text=listPenyakit.diseaseDetails
        }
    }
    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ListPenyakitBinding.inflate(LayoutInflater.from(view.context), view, false)
        return ViewHolder(itemBinding)
    }
    override fun getItemCount(): Int {
        return listPenyakit.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val getListPenyakit = listPenyakit[position]
        holder.bind(getListPenyakit)

        holder.itemView.setOnClickListener {
            val moveToDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            moveToDetail.putExtra(MainActivity.EXTRA_ID, getListPenyakit.id)
            moveToDetail.putExtra(MainActivity.EXTRA_NAMED, getListPenyakit.diseaseName)
            moveToDetail.putExtra(MainActivity.EXTRA_DETAIL, getListPenyakit.diseaseDetails)
            moveToDetail.putExtra(MainActivity.EXTRA_HANDLE, getListPenyakit.handlingMethod)
            holder.itemView.context.startActivity(moveToDetail)
        }
    }

}