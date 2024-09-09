package com.b21dccn216.makeyourowndrink.model

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.b21dccn216.makeyourowndrink.model.DAO.CategoryDAO
import com.b21dccn216.makeyourowndrink.model.DAO.DrinkDAO
import com.b21dccn216.makeyourowndrink.model.DAO.IngredientDAO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(
    entities = [
        Drink::class,
        Category::class,
        Ingredient::class,
        DrinkIngredientCrossRef::class,
        DrinkCategoryCrossRef::class],
    exportSchema = false,
    version = 1
)
abstract class DrinkAppDatabase: RoomDatabase(){

    abstract fun drinkDAO(): DrinkDAO
    abstract fun categoryDAO(): CategoryDAO
    abstract fun ingredientDAO(): IngredientDAO

    companion object{
        @Volatile
        private var INSTANCE : DrinkAppDatabase? = null

        fun getDatabase(context: Context): DrinkAppDatabase {
            Log.i("Database", "Database created 2")
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    DrinkAppDatabase::class.java,
                    "drink_database"
                )
                    .addCallback(object : Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase){
                            super.onCreate(db)
                            Log.i("Database", "Database created 1")
                            GlobalScope.launch {
                                val drinkDAO: DrinkDAO = INSTANCE!!.drinkDAO()
                                val categoryDao: CategoryDAO = INSTANCE!!.categoryDAO()
                                val ingredientDAO: IngredientDAO = INSTANCE!!.ingredientDAO()

                                for(i in listIngredient){
                                    ingredientDAO.insert(i)
                                }
                                for(i in listCategoryX){
                                    categoryDao.insert(i)
                                }
                                listDrinkW.forEach {
                                    val categoryId = categoryDao.getIdByName(it.drink.categoryName)

                                    it.ingredients.map { item ->
                                        item.ingredient.ingredientId = ingredientDAO.getIdByName(item.ingredient.name)
                                    }
                                    val id = drinkDAO.insert(it.drink)
                                    for(i in it.ingredients){
                                        drinkDAO.addIngredient(id, i.ingredient.ingredientId, i.quantity)
                                    }

                                    categoryDao.addCategory(id, categoryId)
                                }
                                Log.i("Database", "Database created")
                            }
                        }
                    })
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }

}