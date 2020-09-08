package com.example.gadprojectallen.`interface`

import com.example.gadprojectallen.models.Learners
import com.example.gadprojectallen.models.Skill
import com.example.gadprojectallen.models.Skills
import com.example.gadprojectallen.models.Submit
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface GAD {
    @GET("api/skilliq")
   fun getSkills(): Call<Skills>

    @GET("api/hours")
    fun getLearners (): Call<Learners>

    @POST("formResponse")
    fun submitData(@Body data:Submit):Call<Submit>



}