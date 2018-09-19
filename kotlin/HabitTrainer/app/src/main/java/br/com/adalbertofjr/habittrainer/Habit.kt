package br.com.adalbertofjr.habittrainer

import android.graphics.Bitmap

/**
 * Habit
 * Created by Adalberto Fernandes Júnior on 21/04/2018.
 * Copyright © 2018. All rights reserved.
 */
data class Habit(val title: String, val description: String, val image: Bitmap)

//fun getSampleHabits(): List<Habit> {
//
//    return listOf(
//            Habit(" Walk",
//                    "Caminhando por ae...",
//                    R.drawable.walk),
//            Habit("Water",
//                    "Bebendo a água",
//                    R.drawable.water)
//    )
//}