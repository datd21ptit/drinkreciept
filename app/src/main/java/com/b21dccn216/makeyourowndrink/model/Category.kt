package com.b21dccn216.makeyourowndrink.model

import androidx.annotation.DrawableRes
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryId: Long = 0,
    val name: String,
    @DrawableRes var icon: Int,
)

@Entity(
    tableName = "drink_category_cross_ref",
    primaryKeys = ["drinkId", "categoryId"])
class DrinkCategoryCrossRef(
    val drinkId: Long,
    val categoryId: Long,
)