package br.com.adalbertofjr.habittrainer.db

import android.provider.BaseColumns

/**
 * Contracts
 * Created by Adalberto Fernandes Júnior on 22/04/2018.
 * Copyright © 2018. All rights reserved.
 */

val DATABASE_NAME = "habittrainer.db"
val DATABASE_VERSION = 1

object HabitEntry : BaseColumns{
    val TABLE_NAME = "habit"
    val _ID = "id"
    val TABLE_TITLE_COL = "title"
    val TABLE_DESCRIPTION_COL = "description"
    val TABLE_IMAGE_COL = "image"
}