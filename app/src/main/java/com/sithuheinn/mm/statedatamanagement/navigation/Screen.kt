package com.sithuheinn.mm.statedatamanagement.navigation

sealed class OnboardScreen(val route: String) {

    object GettingStarted: OnboardScreen(route = "getting_started_screen")
    object HealthConcerns: OnboardScreen(route = "health_concerns_screen")
    object Diets: OnboardScreen(route = "diets_screen")
    object SingleChoiceQuestion: OnboardScreen(route = "single_choice_question_screen")
    object Allergies: OnboardScreen(route = "allergies_screen")
}