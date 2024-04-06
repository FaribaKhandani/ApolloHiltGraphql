package com.example.apollohitlgraphql.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apollohitlgraphql.model.People
import com.example.apollohitlgraphql.model.PeopleDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PeopleViewModel @Inject constructor
    (private val getPeopleRepo: GetPeopleRepo, private val getPersonRepo: GetPersonRepo) :
    ViewModel(){


    private val _state = MutableStateFlow(PeopleState())
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
                    people = getPeopleRepo.execute(), isLoading = false
                )
            }
        }
    }





    fun selectedPeople(code:String){
        viewModelScope.launch {
            _state.update {
                it.copy(
                    detail = getPersonRepo.execute(code)
                )
            }
        }
    }


    fun displyPeopleDialog(){
        _state.update {
            it.copy(detail = null)
        }
    }


    data class PeopleState(
        val people:List<People> = emptyList()
        , val isLoading:Boolean =false
        ,val detail: PeopleDetail? = null
    )

}