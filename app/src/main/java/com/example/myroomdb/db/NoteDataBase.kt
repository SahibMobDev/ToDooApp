package com.example.myroomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myroomdb.db.dao.NoteDao
import com.example.myroomdb.model.NoteModel


@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {
       private var database: NoteDataBase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDataBase {
            return if (database == null) {
                database = Room.databaseBuilder(context, NoteDataBase::class.java, "db").build()
                database as NoteDataBase
            } else {
                database as  NoteDataBase
            }
        }
    }
}