package com.example.myroomdb.db.repasitory

import androidx.lifecycle.LiveData
import com.example.myroomdb.model.NoteModel


interface NoteRepository {

    val allNotes: LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess:() -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)

}