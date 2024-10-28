package com.example.expenseapidevelopment

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ExpenseApi {

    @FormUrlEncoded
    @POST("insert.php")
    fun insertStudent(
        @Field("name") name: String,
        @Field("email") email: String,
    ) : Call<Response>

    @FormUrlEncoded
    @POST("update.php")
    fun updateStudent(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("email") email: String,
    ) : Call<Response>

    @FormUrlEncoded
    @POST("delete.php")
    fun deleteStudent(
        @Field("id") id: String,
    ) : Call<Response>

    @GET("read.php")
    fun getStudents() : Call<ExpenseResponse>


}