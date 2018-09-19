package br.com.adalbertofjr.habittrainer.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * HabitTrainerDb
 * Created by Adalberto Fernandes Júnior on 22/04/2018.
 * Copyright © 2018. All rights reserved.
 */
class HabitTrainerDb(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    private val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${HabitEntry.TABLE_NAME} (" +
                    "${HabitEntry._ID} INTEGER PRIMARY KEY, " +
                    "${HabitEntry.TABLE_TITLE_COL} TEXT, " +
                    "${HabitEntry.TABLE_DESCRIPTION_COL} TEXT, " +
                    "${HabitEntry.TABLE_IMAGE_COL} BLOB " +
                    ")"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${HabitEntry.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)

    }
}