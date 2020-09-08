package com.example.gadprojectallen.`interface`

import com.example.gadprojectallen.models.Learners
import com.example.gadprojectallen.models.Skill
import com.example.gadprojectallen.models.Skills
import com.example.gadprojectallen.models.Submit
import retrofit2.Call
import retrofit2.http.*


interface GAD {
    @GET("api/skilliq")
   fun getSkills(): Call<Skills>

    @GET("api/hours")
    fun getLearners (): Call<Learners>

    @POST("formResponse")
    @FormUrlEncoded
    fun submitData(
        @Field("entry.1877115667")Name:String,
        @Field("entry.2006916086")lastName:String,
        @Field(" entry.1824927963")EmailAddress:String,
        @Field("entry.284483984")linkToProject:String

    ):Call<Submit>



}