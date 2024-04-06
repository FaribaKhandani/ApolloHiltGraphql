package com.example.apollohitlgraphql.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apollohitlgraphql.model.StarShip
import com.example.apollohitlgraphql.model.StarShipDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StarShipsViewModel @Inject constructor
    (private val getStarShipRepo: GetStarShipRepo,private val getStarShipsRepo: GetStarShipsRepo) :ViewModel(){


    private val _state = MutableStateFlow(StarShipsState())
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
                    starships = getStarShipsRepo.execute(), isLoading = false
                )
            }
        }
    }





    fun selectedStarShip(code:String){
        viewModelScope.launch {
            _state.update {
                it.copy(
                    detail = getStarShipRepo.execute(code)
                )
            }
        }
    }


    fun displyStarShipDialog(){
        _state.update {
            it.copy(detail = null)
        }
    }


    data class StarShipsState(
        val starships:List<StarShip> = emptyList()
        , val isLoading:Boolean =false
        ,val detail: StarShipDetail? = null
    )

}