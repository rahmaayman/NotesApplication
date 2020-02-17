package com.example.notes.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.Database.Model.Note
import com.example.notes.Database.daos.NotesDao

@Database(entities = arrayOf(Note::class),exportSchema = false,version = 1)
abstract class MyDataBase:RoomDatabase() {
    abstract fun notesDao():NotesDao
    companion object{
        private var myBataBaseInstance:MyDataBase?=null
        fun getInstance(context:Context):MyDataBase?{
            if (myBataBaseInstance==null){
                myBataBaseInstance=
                        Room.databaseBuilder(context,
                            MyDataBase::class.java,"NotesDataBase")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build()
            }
            return myBataBaseInstance
        }
    }
}