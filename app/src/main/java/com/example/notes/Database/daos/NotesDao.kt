package com.example.notes.Database.daos

import androidx.room.*
import com.example.notes.Database.Model.Note

@Dao
interface NotesDao {
    @Insert
    fun isertNote(note:Note)
    @Delete
    fun deleteNote(note: Note)
    @Query("select * from Note where id=:id")
    fun deleteNoteById(id:Int)
    @Update
    fun updateNote(note: Note)
    @Query("select *from Note")
    fun getAllNotes():List<Note>
    @Query("select * from Note where description like:word")
    fun searchNotesByDescription(word:String):List<Note>
}