package com.b21dccn216.makeyourowndrink.model.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.b21dccn216.makeyourowndrink.model.Ingredient
import kotlinx.coroutines.flow.Flow


@Dao
interface IngredientDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ingredient: Ingredient): Long

    @Update
    suspend fun update(ingredient: Ingredient)

    @Delete
    suspend fun delete(ingredient: Ingredient)

    @Query("SELECT * FROM ingredient")
     fun getAllIngredients(): Flow<List<Ingredient>>

    @Query("SELECT * FROM ingredient WHERE ingredientId = :id")
     fun getIngredientById(id: Long): Flow<List<Ingredient>>

    @Query("DELETE FROM Drink")
    suspend fun deleteAll()

    @Query("SELECT ingredientId FROM ingredient WHERE name = :name")
    suspend fun getIdByName(name: String): Long
}