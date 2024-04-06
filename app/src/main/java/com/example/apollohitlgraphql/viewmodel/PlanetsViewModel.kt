package com.example.apollohitlgraphql.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apollohitlgraphql.model.Planet
import com.example.apollohitlgraphql.model.PlanetDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PlanetsViewModel @Inject constructor
    (private val  GetPlanetsRepo: GetPlanetsRepo
,private val getPlanetRepo: GetPlanetRepo
):ViewModel() {


    private val _state = MutableStateFlow(PlanetsState())
    val state =_state.asStateFlow()


    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            _state.update {
                it.copy(
                    planets = GetPlanetsRepo.execute(), isLoading = false
                )
            }
        }
    }


    fun selectedPlanet(code:String){
        viewModelScope.launch {
            _state.update {
                it.copy(
                    detail = getPlanetRepo.execute(code)
                )
            }
        }
    }


    fun displyPlanetDialog(){
        _state.update {
            it.copy(detail = null)
        }
    }


    data class PlanetsState(
        val planets:List<Planet> = emptyList()
    , val isLoading:Boolean =false
    ,val detail: PlanetDetail? = null
    )

}