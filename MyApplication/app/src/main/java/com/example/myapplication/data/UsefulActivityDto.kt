package com.example.myapplication.data

import com.example.myapplication.entity.UsefulActivity

data class UsefulActivityDto(
    override val activity: String,
    override val type: String,
    override val participants: Int,
    override val price: Double,
    override val link: String,
    override val key: String,
    override val accessibility: Double
) : UsefulActivity {

}
