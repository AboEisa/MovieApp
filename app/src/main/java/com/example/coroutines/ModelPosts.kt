package com.example.coroutines

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ModelPosts(

    val userId: Int ?= null,
    @PrimaryKey
    val id: Int?= null,
    val title: String?= null,
    val body: String?= null
)
{





}