package com.example.expenseapidevelopment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expenseapidevelopment.databinding.ItemBinding

class CustomAdapter(val context: Context, val mList: ArrayList<Expense>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(ItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val expense = mList[position]
        holder.binding.apply {
            id.text = expense.id
            name.text = expense.name
            email.text = expense.email
            date.text = expense.date
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(context, UpdateActivity::class.java)
            intent.putExtra("id", expense.id)
            intent.putExtra("name", expense.name)
            intent.putExtra("email", expense.email)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class MyViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

}