package com.b21dccn216.makeyourowndrink.model.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.b21dccn216.makeyourowndrink.model.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(category: Category): Long

    @Update
    suspend fun update(category: Category)

    @Delete
    suspend fun delete(category: Category)

    @Transaction
    @Query("SELECT * FROM Category")
     fun getAllCategory(): Flow<List<Category>>

    @Transaction
    @Query("SELECT * FROM Category WHERE categoryId = :categoryId")
     fun getCategoryById(categoryId: Long): Flow<List<Category>>

    @Query("DELETE FROM Category")
    suspend fun deleteAll()

    @Query("SELECT categoryId FROM Category WHERE name = :name")
    fun getIdByName(name: String): Long

    @Query("INSERT INTO drink_category_cross_ref VALUES (:drinkId, :categoryId)")
    suspend fun addCategory(drinkId: Long, categoryId: Long)
}