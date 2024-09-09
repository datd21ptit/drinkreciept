package com.b21dccn216.makeyourowndrink

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.b21dccn216.makeyourowndrink.model.Category
import com.b21dccn216.makeyourowndrink.model.Drink
import com.b21dccn216.makeyourowndrink.model.DrinkAppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DrinkViewmodel(
    private val repository: DrinkAppRepository
) : ViewModel()
{
    private var _uiState = MutableStateFlow(DrinkUiState())
    val uiState: StateFlow<DrinkUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val list = repository.getAllCategoryWithCount()
            _uiState.update { value ->
                value.copy(categorie = list)
            }
            repository.drinkRepository.getAll().collect{ it ->
                _uiState.update { value ->
                    value.copy(recentDrinkList = it, isLoading = false)
                }
            }
        }
    }

    suspend fun getDrinkWithIngredients(drinkId: Long) = repository.getDrinkWithIngredients(drinkId)

}


data class DrinkUiState(
    val isLoading: Boolean = true,
    val recentDrinkList: List<Drink> = listOf(),
    val categorie: List<Pair<Category, Int>> = listOf(),
)