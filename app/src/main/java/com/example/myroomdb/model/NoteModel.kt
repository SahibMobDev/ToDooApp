package com.example.myroomdb.model

import androidx.room.*
import java.io.Serializable


@Entity(tableName = "note_table")
class NoteModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    var title: String = "",

    @ColumnInfo
    var description: String = ""
        ) : Serializable