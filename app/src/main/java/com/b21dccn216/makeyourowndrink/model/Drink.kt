package com.b21dccn216.makeyourowndrink.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Ingredient(
    @PrimaryKey(autoGenerate = true)
    var ingredientId: Long = 0,
    val name: String,
    val  unit: String?,
    @DrawableRes var icon: Int
)

@Entity
class Drink(
    @PrimaryKey(autoGenerate = true)
    var drinkId: Long = 0,
    var name: String,
    @DrawableRes var img: Int,
    var description: String,
    var time: Int,
    var difficulty: String,
    var categoryName: String,
    var serves: Int,
    var like: Int,
    var rate: Int,
)

data class IngredientWithQuantity(
        //    @Embedded
    val ingredient: Ingredient,
    val quantity: Int
)

data class DrinkWithIngredients(
        //    @Embedded
    val drink: Drink,
        //    @Relation(
        //        parentColumn = "drinkId",
        //        entityColumn = "ingredientId",
        //        associateBy = Junction(DrinkIngredientCrossRef::class)
        //    )
    val ingredients: List<IngredientWithQuantity>
)


@Entity(
    tableName = "drink_ingredient_cross_ref",
    primaryKeys = ["drinkId", "ingredientId"])
class DrinkIngredientCrossRef(
    val drinkId: Long,
    val ingredientId: Long,
    val quantity: Int
)