package com.example.myroomdb.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myroomdb.REPOSITORY
import com.example.myroomdb.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    fun delete(noteModel: NoteModel, onSuccess:() -> Unit) = viewModelScope.launch(Dispatchers.IO) {
        REPOSITORY.deleteNote(noteModel) {
            onSuccess()
        }
    }
}