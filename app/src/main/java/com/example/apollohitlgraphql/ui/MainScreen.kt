package com.example.apollohitlgraphql.ui

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.apollohitlgraphql.viewmodel.PeopleViewModel
import com.example.apollohitlgraphql.viewmodel.PlanetsViewModel
import com.example.apollohitlgraphql.viewmodel.StarShipsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel





@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavScreen() {
    val viewModelPlanets: PlanetsViewModel = viewModel()
    val planetsState by viewModelPlanets.state.collectAsState()

    val viewModelStarShips: StarShipsViewModel = viewModel()
    val starShipsState by viewModelStarShips.state.collectAsState()


    val peopleViewModel: PeopleViewModel = viewModel()
    val peopleState by peopleViewModel.state.collectAsState()

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    selected = navController.currentDestination?.route == "planets",
                    onClick = {
                        navController.navigate("planets") {
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(
                            Icons.Filled.Home,
                            contentDescription = "Planets"
                        )
                    },
                    label = { Text("Planets") }
                )
                BottomNavigationItem(
                    selected = navController.currentDestination?.route == "starShips",
                    onClick = {
                        navController.navigate("starShips") {
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Starships"
                        )
                    },
                    label = { Text("Starships") }
                )


                BottomNavigationItem(
                    selected = navController.currentDestination?.route == "People",
                    onClick = {
                        navController.navigate("People") {
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "People"
                        )
                    },
                    label = { Text("People") }
                )
            }
        }
    ) {
        NavHost(navController = navController, startDestination = "planets") {
            composable("planets") {
                PlanetsScreen(
                    state = planetsState,
                    onSelectedPlanet = viewModelPlanets::selectedPlanet,
                    onDisplayPlanetDialog = viewModelPlanets::displyPlanetDialog
                )
            }
            composable("starShips") {
                StarShipsScreen(
                    state = starShipsState,
                    onSelectedStarShip = viewModelStarShips::selectedStarShip,
                    onDisplayStarShipDialog = viewModelStarShips::displyStarShipDialog
                )
            }


            composable("People") {
                PeopleScreen(
                    state = peopleState,
                    onSelectedPeople = peopleViewModel::selectedPeople,
                    onDisplayPeopleDialog = peopleViewModel::displyPeopleDialog
                )
            }
        }
    }
}







