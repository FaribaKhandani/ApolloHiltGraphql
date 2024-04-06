package com.example.apollohitlgraphql.ui

import android.app.Person
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
import com.example.apollohitlgraphql.model.People
import com.example.apollohitlgraphql.model.PeopleDetail
import com.example.apollohitlgraphql.viewmodel.PeopleViewModel


@Composable
fun PeopleScreen(
    state: PeopleViewModel.PeopleState,
    onSelectedPeople: (code: String) -> Unit,
    onDisplayPeopleDialog: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.people) { people ->
                    PeopleItem(
                        people = people,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelectedPeople(people.id) }
                    )
                }
            }
        }

        if (state.detail != null) {
            PeopleDisplay(
                peopleDetail = state.detail,
                onDisplayPeopleDialog = onDisplayPeopleDialog,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.White)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
private fun PeopleItem(people: People, modifier: Modifier = Modifier) {
    Column( modifier = modifier) {
        Text(
            text = people.name ?: "No Data",
            color = Color.Blue,
            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start  =10.dp ,bottom = 4.dp)
        )
        Text(
            text = "Film references: ${people.filmConnection ?: 0}",
            style = MaterialTheme.typography.body2.copy(color = Color.Blue),
            modifier = Modifier.padding(start = 10.dp, bottom = 8.dp)
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical =6.dp)
        )
    }
}

@Composable
private fun PeopleDisplay(
    peopleDetail: PeopleDetail,
    onDisplayPeopleDialog: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onDisplayPeopleDialog) {
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
                    text = peopleDetail.name ?: "No Data",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "HairColor : ${peopleDetail.hairColor ?: "No Data"}",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 4.dp) ,

                )

                Text(
                    text = "Gender : ${peopleDetail.gender ?: "No Data"}",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Created: ${peopleDetail.created?: "No Data"}",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "EyeColor : ${peopleDetail.eyeColor ?: "No Data"}",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "BirthYear: ${peopleDetail.birthYear ?: "No Data"}",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}