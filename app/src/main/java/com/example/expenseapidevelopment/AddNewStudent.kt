package com.example.expenseapidevelopment

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.expenseapidevelopment.databinding.ActivityAddNewStudentBinding
import retrofit2.Call
import retrofit2.Callback

class AddNewStudent : AppCompatActivity() {
    private lateinit var binding: ActivityAddNewStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addStudent.setOnClickListener{
            ExpenseRetrofitClient.expenseApi.insertStudent(binding.studentName.text.toString(), binding.studentEmail.text.toString()).enqueue(object : Callback<Response>{
                override fun onResponse(
                    call: Call<Response?>,
                    response: retrofit2.Response<Response?>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(applicationContext, "Student added successfully", Toast.LENGTH_SHORT).show()
                    }
                    finish()
                }

                override fun onFailure(
                    call: Call<Response?>,
                    t: Throwable
                ) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }

            })
        }

    }
}