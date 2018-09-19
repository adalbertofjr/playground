package br.com.adalbertofjr.habittrainer.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import br.com.adalbertofjr.habittrainer.Habit
import br.com.adalbertofjr.habittrainer.db.HabitEntry.TABLE_DESCRIPTION_COL
import br.com.adalbertofjr.habittrainer.db.HabitEntry.TABLE_IMAGE_COL
import br.com.adalbertofjr.habittrainer.db.HabitEntry.TABLE_NAME
import br.com.adalbertofjr.habittrainer.db.HabitEntry.TABLE_TITLE_COL
import br.com.adalbertofjr.habittrainer.db.HabitEntry._ID
import java.io.ByteArrayOutputStream

/**
 * HabitDbTable
 * Created by Adalberto Fernandes Júnior on 22/04/2018.
 * Copyright © 2018. All rights reserved.
 */
class HabitDbTable(context: Context) {
    private val LOG_TAG = HabitDbTable::class.java.simpleName

    private val dbHelper = HabitTrainerDb(context)

    fun store(habit: Habit): Long {
        val db = dbHelper.writableDatabase


        val values = ContentValues()
        with(values) {
            put(TABLE_TITLE_COL, habit.title)
            put(TABLE_DESCRIPTION_COL, habit.description)
            put(TABLE_IMAGE_COL, toByteArray(habit.image))
        }

        val id = db.transaction {
            insert(TABLE_NAME, null, values)
        }

        Log.d(LOG_TAG, "Stored new habit to the DB ${habit}")

        return id
    }

    fun readAllHabits(): List<Habit> {
        val db = dbHelper.readableDatabase

        val columns = arrayOf(_ID, TABLE_TITLE_COL, TABLE_DESCRIPTION_COL, TABLE_IMAGE_COL)
        val order = "$_ID ASC"

        val cursor = db.dbQuery(table = TABLE_NAME, columns = columns, orderBy = order)

        return parseHabitsFrom(cursor)

    }

    private fun parseHabitsFrom(cursor: Cursor): MutableList<Habit> {
        val habits = mutableListOf<Habit>()

        while (cursor.moveToNext()) {
            with(cursor) {
                val title = getString(TABLE_TITLE_COL)
                val desc = getString(TABLE_DESCRIPTION_COL)
                val bitmap = getBlob(TABLE_IMAGE_COL)

                habits.add(Habit(title, desc, bitmap))
            }
        }

        cursor.close()
        return habits
    }

    private fun toByteArray(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream)
        return stream.toByteArray()
    }
}


private fun Cursor.getString(columnName: String) = getString(getColumnIndex(columnName))

private fun Cursor.getBlob(columnName: String): Bitmap {
    val byte = getBlob(getColumnIndex(columnName))
    return BitmapFactory.decodeByteArray(byte, 0, byte.size)
}

private fun SQLiteDatabase.dbQuery(table: String, columns: Array<String>, selection: String? = null,
                                   selectionArgs: Array<String>? = null, groupBy: String? = null, having: String? = null,
                                   orderBy: String? = null, limit: String? = null): Cursor {
    return query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit)
}


private inline fun <T> SQLiteDatabase.transaction(function: SQLiteDatabase.() -> T): T {
    beginTransaction()
    val result = try {
        val returnValue = function()
        setTransactionSuccessful()

        returnValue
    } finally {
        endTransaction()
    }
    close()

    return result
}