package com.dicoding.ternakku.ui.history

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.ternakku.data.retrofit.response.HistoryItem
import com.dicoding.ternakku.data.retrofit.response.HistoryPredictItem
import com.dicoding.ternakku.databinding.ListHistoryBinding
import com.dicoding.ternakku.ui.result.ResultActivity

class HistoryAdapter(private val listHistory: List<HistoryPredictItem>) : RecyclerView.Adapter<HistoryAdapter.HistoryHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryHolder {
        val historyBinding = ListHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryHolder(historyBinding)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val getHistory = listHistory[position]
        holder.hisBind(getHistory)

        holder.itemView.setOnClickListener {
            val result = Intent(holder.itemView.context, ResultActivity::class.java)
            result.putExtra("disease", getHistory.diseaseName)
            result.putExtra("img", getHistory.timestamp)
            holder.itemView.context.startActivity(result)
        }
    }

    override fun getItemCount(): Int = listHistory.size

    class HistoryHolder(private val viewBinding: ListHistoryBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun hisBind(itemHistory: HistoryPredictItem){
            viewBinding.tvHistoryName.text = itemHistory.diseaseName
            Glide.with(itemView.context)
                .load(itemHistory.timestamp)
                .into(viewBinding.ivHistory)
        }
    }
}