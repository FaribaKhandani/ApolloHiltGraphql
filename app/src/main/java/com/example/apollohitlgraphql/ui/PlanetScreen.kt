package com.example.apollohitlgraphql.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.apollohitlgraphql.viewmodel.PlanetsViewModel
import com.example.apollohitlgraphql.model.Planet
import com.example.apollohitlgraphql.model.PlanetDetail

@Composable
fun PlanetsScreen(
    state: PlanetsViewModel.PlanetsState,
    onSelectedPlanet: (code: String) -> Unit,
    onDisplayPlanetDialog: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.planets) { planet ->
                    PlanetItem(
                        planet = planet,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelectedPlanet(planet.id) }
                    )
                }
            }
        }

        if (state.detail != null) {
            PlanetDisplay(
                planetDetail = state.detail,
                onDisplayPlanetDialog = onDisplayPlanetDialog,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.White)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
private fun PlanetItem(planet: Planet, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = planet.name ?: "No Data",
            color = Color.Blue,
            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = 10.dp,bottom = 4.dp)
        )
        Text(
            text = "Film references: ${planet.filmConnection ?: 0}",
            style = MaterialTheme.typography.body2.copy(color = Color.Blue),
            modifier = Modifier.padding(start = 10.dp, bottom = 8.dp)
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        )
    }
}

@Composable
private fun PlanetDisplay(
    planetDetail: PlanetDetail,
    onDisplayPlanetDialog: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onDisplayPlanetDialog) {
        Box(
            modifier = Modifier
                .size(width = 300.dp, height = 300.dp)
                .background(Color.Blue, RoundedCornerShape(16.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = planetDetail.name ?: "No Data",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Gravity: ${planetDetail.gravity ?: "No Data"}",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Created: ${planetDetail.created ?: "No Data"}",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "RotationPeriod: ${planetDetail.rotationPeriod ?: "No Data"}",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Population: ${planetDetail.population ?: "No Data"}",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Edited: ${planetDetail.edited ?: "No Data"}",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}