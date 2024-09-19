package com.example.kotlinenjoyerstemplate.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlinenjoyerstemplate.contract_details.presentation.compose.ContractDetails
import com.example.kotlinenjoyerstemplate.contract_details.presentation.viewmodel.ContractDetailsViewModel
import com.example.kotlinenjoyerstemplate.navigation.ObjectDetailsNavDestination.ContractDetailsScreen.CONTRACT_ID_KEY
import com.example.kotlinenjoyerstemplate.navigation.ObjectDetailsNavDestination.PlanDetailsScreen.PLAN_ID_KEY
import com.example.kotlinenjoyerstemplate.object_details.presentation.compose.ObjectDetails
import com.example.kotlinenjoyerstemplate.object_details.presentation.viewmodel.ObjectDetailsViewModel
import com.example.kotlinenjoyerstemplate.plan_details.compose.PlanDetails
import com.example.kotlinenjoyerstemplate.plan_details.viewmodel.PlanDetailsViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

sealed interface ObjectDetailsNavDestination : NavDestination {

    data object ObjectDetailsScreen : RootNavDestination("ObjectDetailsScreen")

    data object PlanDetailsScreen : RootNavDestination("PlanDetailsScreen") {

        const val PLAN_ID_KEY = "PLAN_ID_KEY"

        override val arguments = listOf(PLAN_ID_KEY)
    }

    data object ContractDetailsScreen : RootNavDestination("ContractDetailsScreen") {

        const val CONTRACT_ID_KEY = "CONTRACT_ID_KEY"

        override val arguments = listOf(CONTRACT_ID_KEY)
    }
}

@Composable
fun ObjectDetailsNavigation(navController: NavHostController, objectId: Long) {
    NavHost(
        modifier = Modifier.fillMaxHeight(),
        navController = navController,
        startDestination = ObjectDetailsNavDestination.ObjectDetailsScreen.getDestination(),
    ) {
        composable(route = ObjectDetailsNavDestination.ObjectDetailsScreen.getDestination()) { backStackEntry ->
            val viewModel: ObjectDetailsViewModel = koinViewModel(parameters = { parametersOf(objectId) })

            ObjectDetails(
                viewModel = viewModel,
                onPlanClick = { plan ->
                    navController.navigate(ObjectDetailsNavDestination.PlanDetailsScreen.getNavigationRoute(plan.id))
                }
            )
        }

        composable(route = ObjectDetailsNavDestination.PlanDetailsScreen.getDestination()) { backStackEntry ->
            val planId = backStackEntry.arguments?.getLong(PLAN_ID_KEY)
            val viewModel: PlanDetailsViewModel = koinViewModel(parameters = { parametersOf(planId) })

            PlanDetails(
                viewModel = viewModel,
                onContractClick = { contract ->
                    navController.navigate(ObjectDetailsNavDestination.ContractDetailsScreen.getNavigationRoute(contract.id))
                },
                onBack = {
                    navController.popBackStack()
                },
            )
        }

        composable(route = ObjectDetailsNavDestination.ContractDetailsScreen.getDestination()) { backStackEntry ->
            val contractId = backStackEntry.arguments?.getLong(CONTRACT_ID_KEY)
            val viewModel: ContractDetailsViewModel = koinViewModel(parameters = { parametersOf(contractId) })

            ContractDetails(
                viewModel = viewModel,
                onStageButtonClick = viewModel::onChooseStage,
                onBack = {
                    navController.popBackStack()
                },
            )
        }
    }
}