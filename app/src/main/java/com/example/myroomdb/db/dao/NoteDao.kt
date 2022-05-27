package com.example.myroomdb.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myroomdb.model.NoteModel

@Dao
interface NoteDao {
    @Query("SELECT * from note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (noteModel: NoteModel)

    @Delete
    suspend fun delete (noteModel: NoteModel)

}