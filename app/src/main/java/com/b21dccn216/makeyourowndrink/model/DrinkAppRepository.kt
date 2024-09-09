package com.b21dccn216.makeyourowndrink.model

import com.b21dccn216.makeyourowndrink.model.DAO.CategoryDAO
import com.b21dccn216.makeyourowndrink.model.DAO.DrinkDAO
import com.b21dccn216.makeyourowndrink.model.DAO.IngredientDAO
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first


interface ItemRepository <T:Any>{
     fun getAll(): Flow<List<T>>

     fun getById(id: Long): Flow<List<T>>

     suspend fun insert(item: T): Long

     suspend fun delete(item: T)

     suspend fun update(item: T)
}

class DrinkRepository(private val drinkDao: DrinkDAO) : ItemRepository<Drink> {
    override fun getAll(): Flow<List<Drink>> = drinkDao.getAll()

    override fun getById(id: Long): Flow<List<Drink>> = drinkDao.getById(id)

    override suspend fun update(item: Drink) = drinkDao.update(item)

    override suspend fun delete(item: Drink) = drinkDao.delete(item)

    override suspend fun insert(item: Drink) = drinkDao.insert(item)

    suspend fun addIngredient(drinkId: Long, ingredientId: Long, quantity: Int) = drinkDao.addIngredient(drinkId, ingredientId, quantity)

    suspend fun insert(item: DrinkWithIngredients){
        val id = insert(item.drink)
        for(i in item.ingredients){
            addIngredient(id, i.ingredient.ingredientId, i.quantity)
        }
    }

    suspend fun countCategory(id: Long) = drinkDao.countCategory(id)

    suspend fun getIngredientOfId(id: Long) = drinkDao.getIngredientOfId(id)

    suspend fun deleteAll() = drinkDao.deleteAll()
}

class IngredientRepository(private val ingredientDAO: IngredientDAO): ItemRepository<Ingredient>{
    override fun getAll(): Flow<List<Ingredient>> = ingredientDAO.getAllIngredients()

    override fun getById(id: Long): Flow<List<Ingredient>> = ingredientDAO.getIngredientById(id)

    override suspend fun update(item: Ingredient) = ingredientDAO.update(item)

    override suspend fun delete(item: Ingredient) = ingredientDAO.delete(item)

    override suspend fun insert(item: Ingredient) = ingredientDAO.insert(item)

    suspend fun deleteAll() = ingredientDAO.deleteAll()

    suspend fun getIdByName(name: String) = ingredientDAO.getIdByName(name)
}

class CategoryRepository(private val categoryDAO: CategoryDAO): ItemRepository<Category>{
    override fun getAll(): Flow<List<Category>> = categoryDAO.getAllCategory()

    override fun getById(id: Long): Flow<List<Category>> = categoryDAO.getCategoryById(id)

    override suspend fun insert(item: Category): Long = categoryDAO.insert(item)

    override suspend fun delete(item: Category) = categoryDAO.delete(item)

    override suspend fun update(item: Category) = categoryDAO.update(item)

    suspend fun deleteAll() = categoryDAO.deleteAll()
}





class DrinkAppRepository(
    database: DrinkAppDatabase
){
     val drinkRepository: DrinkRepository by lazy { DrinkRepository(database.drinkDAO()) }
     val ingredientRepository: IngredientRepository by lazy { IngredientRepository(database.ingredientDAO()) }
     val categoryRepository: CategoryRepository by lazy { CategoryRepository(database.categoryDAO()) }

    suspend fun getDrinkWithIngredients(id: Long): DrinkWithIngredients{
        return coroutineScope {
            val drink = async { drinkRepository.getById(id).first()[0] }
            val listIngredientCrossRef = async { drinkRepository.getIngredientOfId(id) }
            val listIngredient = async {
                listIngredientCrossRef.await().map{ crossRef ->
                    val ingredient = async { ingredientRepository.getById(crossRef.ingredientId).first()[0] }
                    IngredientWithQuantity(ingredient.await(), crossRef.quantity)
                }
            }
            DrinkWithIngredients(drink.await(), listIngredient.await())
        }
    }

    suspend fun getAllCategoryWithCount(): List<Pair<Category, Int>>{
        return coroutineScope {
            val listCategory = async {categoryRepository.getAll().first() }
            listCategory.await().map { category ->
                val count = async { drinkRepository.countCategory(id = category.categoryId) }
                Pair(category, count.await())
            }
        }
    }
}