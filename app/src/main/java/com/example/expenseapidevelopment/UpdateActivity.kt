package com.example.expenseapidevelopment

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.expenseapidevelopment.databinding.ActivityUpdateBinding
import retrofit2.Call
import retrofit2.Callback

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.studentName.setText(intent.getStringExtra("name"))
        binding.studentEmail.setText(intent.getStringExtra("email"))

        binding.updateStudent.setOnClickListener{
            ExpenseRetrofitClient.expenseApi.updateStudent(
                intent.getStringExtra("id").toString(),
                binding.studentName.text.toString(),
                binding.studentEmail.text.toString()
                ).enqueue(object : Callback<Response>{
                override fun onResponse(
                    call: Call<Response?>,
                    response: retrofit2.Response<Response?>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(applicationContext, "Student Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }

                override fun onFailure(
                    call: Call<Response?>,
                    t: Throwable
                ) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }

            })
        }

        binding.deleteStudent.setOnClickListener{
            ExpenseRetrofitClient.expenseApi.deleteStudent(intent.getStringExtra("id").toString()).enqueue(object : Callback<Response>{
                override fun onResponse(
                    call: Call<Response?>,
                    response: retrofit2.Response<Response?>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(applicationContext, "Student Deleted", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }

                override fun onFailure(
                    call: Call<Response?>,
                    t: Throwable
                ) {
                    Toast.makeText(applicationContext, "Student Not Deleted", Toast.LENGTH_SHORT).show()
                    finish()
                }

            })
        }


    }
}