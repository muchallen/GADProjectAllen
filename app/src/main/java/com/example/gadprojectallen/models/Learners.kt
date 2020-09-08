package com.example.gadprojectallen.models

typealias Learners = ArrayList<Learner>

data class Learner (
    val name: String,
    val hours: Long,
    val country: String,
    val badgeURL: String
)
