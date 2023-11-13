package com.sithuheinn.mm.statedatamanagement.navigation

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sithuheinn.mm.statedatamanagement.feature.onboarding.AllergiesScreen
import com.sithuheinn.mm.statedatamanagement.feature.onboarding.DietScreen
import com.sithuheinn.mm.statedatamanagement.feature.onboarding.GettingStartedScreen
import com.sithuheinn.mm.statedatamanagement.feature.onboarding.HealthConcernScreen
import com.sithuheinn.mm.statedatamanagement.feature.onboarding.OnboardSharedViewModel
import com.sithuheinn.mm.statedatamanagement.feature.onboarding.SingleChoiceQuestionScreen
import com.sithuheinn.mm.statedatamanagement.feature.util.sharedViewModel

@ExperimentalLayoutApi
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = "onboard_nav"
    ) {

        navigation(
            startDestination = OnboardScreen.GettingStarted.route,
            route = "onboard_nav"
        ) {
            composable(route = OnboardScreen.GettingStarted.route) { entry ->
                GettingStartedScreen {
                    navController.navigate(OnboardScreen.HealthConcerns.route)
                }
            }

            composable(route = OnboardScreen.HealthConcerns.route) { entry ->
                val viewModel =
                    entry.sharedViewModel<OnboardSharedViewModel>(navController = navController)
                HealthConcernScreen(
                    healthConcernItems = viewModel.healthConcernViewItem.value,
                    viewModel::onSelectHealthConcernViewItem,
                    onNext = { navController.navigate(OnboardScreen.Diets.route) },
                    onBack = { navController.popBackStack() }
                )
            }

            composable(route = OnboardScreen.SingleChoiceQuestion.route) { entry ->
                val viewModel =
                    entry.sharedViewModel<OnboardSharedViewModel>(navController = navController)
                SingleChoiceQuestionScreen(
                    questions = viewModel.singleChoiceQuestions.value,
                    onAnswered = viewModel::onSingleChoiceAnswerSelected,
                    onFinished = viewModel::onFinish
                )
            }

            composable(route = OnboardScreen.Diets.route) { entry ->
                val viewModel =
                    entry.sharedViewModel<OnboardSharedViewModel>(navController = navController)
                DietScreen(
                    dietViewItems = viewModel.dietViewItem.value,
                    checkedNone = viewModel.checkedNone,
                    onChecked =  viewModel::onCheckChangedDietItem,
                    onCheckedNone = viewModel::onCheckNoneDietItem,
                    onBack = { navController.popBackStack() },
                    onNext = { navController.navigate(OnboardScreen.Allergies.route) }
                )
            }

            composable(route = OnboardScreen.Allergies.route) { entry ->
                val viewModel = entry.sharedViewModel<OnboardSharedViewModel>(navController = navController)
                AllergiesScreen(
                    allergiesItems = viewModel.allergiesItems.value,
                    selectedItems = viewModel.selectedAllergiesItem.value,
                    onSelectedItem = viewModel::onSelectAllergiesItem,
                    onRemoveItem = viewModel::onRemoveAllergiesItem,
                    onBack = { navController.popBackStack() },
                    onNext = { navController.navigate(OnboardScreen.SingleChoiceQuestion.route) }
                )
            }
        }
    }
}