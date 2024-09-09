package com.b21dccn216.makeyourowndrink.model

import com.b21dccn216.makeyourowndrink.R




val listIngredient = listOf(
    Ingredient(name = "Mint Leaves", unit = null, icon = R.drawable.leave_five),
    Ingredient(name = "Lemon Wedges", unit = null, icon = R.drawable.lemon_slice),
    Ingredient(name = "Lemon Juice", unit = "ml", icon = R.drawable.lemon_juice),
    Ingredient(name = "Ice Cubes", unit = null, icon = R.drawable.ice_cube),
    Ingredient(name = "Sugar", unit = "tbsp", icon = R.drawable.sugar),
    Ingredient(name = "Club Soda", unit = "ml", icon = R.drawable.soda),
    Ingredient(name = "Kiwi Juice", unit = "ml", icon = R.drawable.kiwi_juice),
    Ingredient(name = "Leave one", unit = null, icon = R.drawable.leave_one),
    Ingredient(name = "Leave two", unit = null, icon = R.drawable.leave_two),
    Ingredient(name = "Leave three", unit = null, icon = R.drawable.leave_three),
    Ingredient(name = "Leave four", unit = null, icon = R.drawable.leave_four),
    Ingredient(name = "Orange Juice", unit = null, icon = R.drawable.orange_juice),
    Ingredient(name = "Strawberry Juice", unit = null, icon = R.drawable.strawberry_juice)
)

val listCategoryX = listOf(
    Category(name = "Cocktails", icon =  R.drawable.negroni),
    Category(name = "Mocktails",icon =  R.drawable.moxito),
    Category(name = "Shakes", icon = R.drawable.baileys),
    Category(name = "Long", icon = R.drawable.pina_cola)
)

val listDrinkW = listOf(
    DrinkWithIngredients(
        drink = Drink(
            name = "Virgin Mojito",
            img = R.drawable.moxito,
            description = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
            time = 25,
            difficulty = "Medium",
            categoryName = "Cocktails",
            serves = 2,
            like = 534,
            rate = 3
        ),
        ingredients = listOf(
            IngredientWithQuantity(listIngredient[0], 8),
            IngredientWithQuantity(listIngredient[1], 2),
            IngredientWithQuantity(listIngredient[2], 30),
            IngredientWithQuantity(listIngredient[3], 6),
            IngredientWithQuantity(listIngredient[4], 2),
            IngredientWithQuantity(listIngredient[5], 30)
        )
    ),
    DrinkWithIngredients(
        drink = Drink(
            name = "Blue moon",
            img = R.drawable.blue_lagoon,
            description = "Blue moon cocktails are a fun, frozen martini featuring blue curaçao, vanilla syrup, and fresh orange juice.",
            time = 17,
            difficulty = "Easy",
            categoryName = "Cocktails",
            serves = 1,
            like = 534,
            rate = 3
        ),
        ingredients = listOf(
            IngredientWithQuantity(listIngredient[6], 80),
            IngredientWithQuantity(listIngredient[7], 2),
            IngredientWithQuantity(listIngredient[11], 30),
            IngredientWithQuantity(listIngredient[3], 6),
            IngredientWithQuantity(listIngredient[4], 2),
            IngredientWithQuantity(listIngredient[5], 30)
        )
    ),
    DrinkWithIngredients(
        drink = Drink(
            name = "Italy Negroni",
            img = R.drawable.negroni,
            description = "Easy to make and refreshingly bitter, the Negroni is said to have been invented in Florence by the dauntless Italian Count Camillo Negroni in the early 20th century.",
            time = 20,
            difficulty = "Hard",
            categoryName = "Cocktails",
            serves = 2,
            like = 125,
            rate = 4
        ),
        ingredients = listOf(
            IngredientWithQuantity(listIngredient[9], 2),
            IngredientWithQuantity(listIngredient[11], 30),
            IngredientWithQuantity(listIngredient[3], 6),
            IngredientWithQuantity(listIngredient[4], 2),
            IngredientWithQuantity(listIngredient[5], 30)
        )
    ),
    DrinkWithIngredients(
        drink = Drink(
            name = "Martini Vermouth",
            img = R.drawable.maritni,
            description = "A blend of dry gin (or vodka) with a hint of dry vermouth and perhaps orange bitters is one of the quickest and simplest cocktails to make.",
            time = 15,
            difficulty = "Easy",
            categoryName = "Cocktails",
            serves = 2,
            like = 754,
            rate = 4
        ),
        ingredients = listOf(
            IngredientWithQuantity(listIngredient[5], 8),
            IngredientWithQuantity(listIngredient[4], 2),
            IngredientWithQuantity(listIngredient[3], 30),
            IngredientWithQuantity(listIngredient[7], 6),
            IngredientWithQuantity(listIngredient[6], 2),
            IngredientWithQuantity(listIngredient[12], 30)
        )
    ),
    DrinkWithIngredients(
        drink = Drink(
            name = "Baileys Irish",
            img = R.drawable.baileys,
            description = "Baileys is a popular cream liqueur that was first introduced in 1974 by Gilbeys of Ireland.",
            time = 20,
            difficulty = "Hard",
            categoryName = "Mocktails",
            serves = 2,
            like = 235,
            rate = 4
        ),
        ingredients = listOf(
            IngredientWithQuantity(listIngredient[12], 8),
            IngredientWithQuantity(listIngredient[9], 2),
            IngredientWithQuantity(listIngredient[3], 30),
            IngredientWithQuantity(listIngredient[5], 6),
            IngredientWithQuantity(listIngredient[8], 2),
            IngredientWithQuantity(listIngredient[10], 30)
        )
    ),
    DrinkWithIngredients(
        drink = Drink(
            name = "Pina cola",
            img = R.drawable.pina_cola,
            description = "Piña Colada is a classic tropical cocktail that originated in Puerto Rico.",
            time = 20,
            difficulty = "Easy",
            categoryName = "Mocktails",
            serves = 2,
            like = 250,
            rate = 3
        ),
        ingredients = listOf(
            IngredientWithQuantity(listIngredient[0], 8),
            IngredientWithQuantity(listIngredient[1], 2),
            IngredientWithQuantity(listIngredient[2], 30),
            IngredientWithQuantity(listIngredient[3], 6),
            IngredientWithQuantity(listIngredient[4], 2),
            IngredientWithQuantity(listIngredient[5], 30)
        )
    ),
    DrinkWithIngredients(
        drink = Drink(
            name = "Aperol Spritz",
            img = R.drawable.aperol_spritz,
            description = "A refreshing Italian cocktail that’s perfect for warm weather. It’s known for its vibrant orange color and bittersweet taste.",
            time = 20,
            difficulty = "Easy",
            categoryName = "Shakes",
            serves = 2,
            like = 754,
            rate = 4
        ),
        ingredients = listOf(
            IngredientWithQuantity(listIngredient[12], 8),
            IngredientWithQuantity(listIngredient[9], 2),
            IngredientWithQuantity(listIngredient[3], 30),
            IngredientWithQuantity(listIngredient[5], 6),
            IngredientWithQuantity(listIngredient[8], 2),
            IngredientWithQuantity(listIngredient[10], 30)
        )
    ),
    DrinkWithIngredients(
        drink = Drink(
            name = "Cuba Libre",
            img = R.drawable.cuba_libre,
            description = "A simple yet refreshing drink that combines rum, Coca-Cola, and lime juice.",
            time = 20,
            difficulty = "Easy",
            categoryName = "Shakes",
            serves = 2,
            like = 49,
            rate = 1
        ),
        ingredients = listOf(
            IngredientWithQuantity(listIngredient[1], 8),
            IngredientWithQuantity(listIngredient[3], 2),
            IngredientWithQuantity(listIngredient[5], 30),
            IngredientWithQuantity(listIngredient[7], 6),
            IngredientWithQuantity(listIngredient[9], 2),
            IngredientWithQuantity(listIngredient[12], 30)
        )
    ),
    DrinkWithIngredients(
        drink = Drink(
            name = "Strawberry Daiquiri",
            img = R.drawable.strawberry_baiquiri,
            description = "The Strawberry Daiquiri is a delightful and refreshing cocktail, perfect for warm weather.",
            time = 20,
            difficulty = "Easy",
            categoryName = "Long",
            serves = 2,
            like = 534,
            rate = 4
        ),
        ingredients = listOf(
            IngredientWithQuantity(listIngredient[0], 8),
            IngredientWithQuantity(listIngredient[3], 2),
            IngredientWithQuantity(listIngredient[4], 30),
            IngredientWithQuantity(listIngredient[5], 6),
            IngredientWithQuantity(listIngredient[10], 2),
            IngredientWithQuantity(listIngredient[12], 30)
        )
    )
)

//class CategoryDrink(
//    var name: String,
//    var mixes: Int,
//    @DrawableRes var icon: Int
//)

//val listCategoryDrink = listOf(
//    CategoryDrink("Cocktails", 50, R.drawable.negroni),
//    CategoryDrink("Mocktails", 39, R.drawable.moxito),
//    CategoryDrink("Shakes", 48, R.drawable.baileys),
//    CategoryDrink("Long", 21, R.drawable.pina_cola),
//    CategoryDrink("Cocktails", 50, R.drawable.negroni),
//    CategoryDrink("Mocktails", 39, R.drawable.moxito),
//    CategoryDrink("Shakes", 48, R.drawable.baileys),
//    CategoryDrink("Long", 21, R.drawable.pina_cola),
//)

// list of mixes
//val listRecipe = listOf(
//    Recipe(
//        name = "Virgin Mojito",
//        img = R.drawable.moxito,
//        description = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
//        time = 25,
//        difficulty = "Medium",
//        category = "Sweet",
//        serves = 2,
//        listItem = listItem,
//        like = 534,
//        rate = 3,
//        id = 0
//    ),
//    Recipe(
//        name = "Blue moon",
//        time = 20,
//        category = "Mocktail",
//        serves = 2,
//        difficulty = "Easy",
//        description = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
//        img = R.drawable.blue_lagoon,
//        listItem = listItem,
//        like = 534,
//        rate = 0,
//        id = 1
//    ),
//    Recipe(
//        name = "Negroni Dat",
//        time = 20,
//        category = "Mocktail",
//        serves = 2,
//        difficulty = "Hard",
//        description = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
//        img = R.drawable.negroni,
//        listItem = listItem,
//        like = 125,
//        rate = 2,
//        id = 2
//    ),
//    Recipe(
//        name = "Martini Dat",
//        time = 15,
//        category = "Mocktail",
//        serves = 2,
//        difficulty = "Easy",
//        description = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
//        img = R.drawable.maritni,
//        listItem = listItem,
//        like = 754,
//        rate = 4,
//        id = 3
//    ),
//    Recipe(
//        name = "Baileys Dat",
//        time = 20,
//        category = "Mocktail",
//        serves = 2,
//        difficulty = "Easy",
//        description = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
//        img = R.drawable.baileys,
//        listItem = listItem,
//        like = 235,
//        rate = 3,
//        id = 4
//    ),
//    Recipe(
//        name = "Pina cola",
//        time = 20,
//        category = "Mocktail",
//        serves = 2,
//        difficulty = "Easy",
//        description = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
//        img = R.drawable.pina_cola,
//        listItem = listItem,
//        like = 534,
//        rate = 4,
//        id = 5
//    ),
//    Recipe(
//        name = "Aperol Spritz",
//        time = 20,
//        category = "Mocktail",
//        serves = 2,
//        difficulty = "Easy",
//        description = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
//        img = R.drawable.aperol_spritz,
//        listItem = listItem,
//        like = 534,
//        rate = 4,
//        id = 6
//    ),
//    Recipe(
//        name = "Cuba Libre",
//        time = 20,
//        category = "Mocktail",
//        serves = 2,
//        difficulty = "Easy",
//        description = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
//        img = R.drawable.cuba_libre,
//        listItem = listItem,
//        like = 534,
//        rate = 4,
//        id = 7
//    ),
//    Recipe(
//        name = "Strawberry Baiquiry",
//        time = 20,
//        category = "Mocktail",
//        serves = 2,
//        difficulty = "Easy",
//        description = "A Mojito without alcohol, its combination of sweet and citrusy flavors makes it the summers go to.",
//        img = R.drawable.strawberry_baiquiri,
//        listItem = listItem,
//        like = 534,
//        rate = 4,
//        id = 8
//    )
//    )
