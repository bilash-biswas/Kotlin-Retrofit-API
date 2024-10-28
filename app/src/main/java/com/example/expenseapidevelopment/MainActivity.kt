package com.example.expenseapidevelopment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expenseapidevelopment.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CustomAdapter
    private lateinit var mList: ArrayList<Expense>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addStudent.setOnClickListener{
            startActivity(Intent(this, AddNewStudent::class.java))
        }

        mList = ArrayList()
        getStudent()
        binding.allStudent.layoutManager = LinearLayoutManager(this)
        binding.allStudent.setHasFixedSize(true)
        adapter = CustomAdapter(applicationContext, mList)

        binding.allStudent.adapter = adapter

    }

    private fun getStudent(){
        ExpenseRetrofitClient.expenseApi.getStudents().enqueue(object : Callback<ExpenseResponse>{
            override fun onResponse(
                call: Call<ExpenseResponse?>,
                response: Response<ExpenseResponse?>
            ) {
                mList.clear()
                mList.addAll(response.body()!!.data)
            }

            override fun onFailure(
                call: Call<ExpenseResponse?>,
                t: Throwable
            ) {
                TODO("Not yet implemented")
            }

        })
    }

}