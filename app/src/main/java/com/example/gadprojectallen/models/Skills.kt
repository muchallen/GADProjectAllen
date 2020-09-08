package com.example.gadprojectallen.models

    typealias Skills = ArrayList<Skill>

    data class Skill (
        val name: String,
        val score: Long,
        val country: String,
        val badgeURL: String
    )
