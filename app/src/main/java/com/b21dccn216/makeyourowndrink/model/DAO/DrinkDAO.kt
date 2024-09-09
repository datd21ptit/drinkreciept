package com.b21dccn216.makeyourowndrink.model.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.b21dccn216.makeyourowndrink.model.Drink
import com.b21dccn216.makeyourowndrink.model.DrinkIngredientCrossRef
import com.b21dccn216.makeyourowndrink.model.DrinkWithIngredients
import kotlinx.coroutines.flow.Flow


@Dao
interface DrinkDAO{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(drink: Drink): Long

    @Update
    suspend fun update(drink: Drink)

    @Delete
    suspend fun delete(drink: Drink)

    @Transaction
    @Query("SELECT * FROM Drink")
    fun getAll(): Flow<List<Drink>>

    @Transaction
    @Query("SELECT * FROM Drink WHERE drinkId = :drinkId")
    fun getById(drinkId: Long): Flow<List<Drink>>

    @Transaction
    @Query("INSERT INTO drink_ingredient_cross_ref VALUES (:drinkId, :ingredientId, :quantity)")
    suspend fun addIngredient(drinkId: Long, ingredientId: Long, quantity: Int)

    @Query("DELETE FROM Drink")
    suspend fun deleteAll()

    @Query("SELECT * FROM drink_ingredient_cross_ref WHERE drinkId = :id")
    suspend fun getIngredientOfId(id: Long) : List<DrinkIngredientCrossRef>

    @Query("SELECT COUNT(*) FROM drink_category_cross_ref WHERE categoryId = :id")
    suspend fun countCategory(id: Long): Int
}

