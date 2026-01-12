package com.example.disneyxml.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyxml.data.model.DisneyCharacterData
import com.example.disneyxml.repository.IDisneyCharacterRepository
import kotlinx.coroutines.launch

class DisneyCharacterViewModel(
    private val character: IDisneyCharacterRepository
): ViewModel() {

    private val _characters = MutableLiveData<List<DisneyCharacterData>>()
    val characters : LiveData<List<DisneyCharacterData>> = _characters

    private val _page = MutableLiveData<Int>()
    val page: LiveData<Int> = _page

    fun getCharacterList(page: Int) {
        viewModelScope.launch {
            val returnedCharacters =
                character.getCharacters()
            returnedCharacters.let {
                _characters.value = it
            }
        }
    }


    fun nextPage() {
        _page.value = (_page.value ?: 1) + 1
    }
}