package br.com.adalbertofjr.hotel.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.adalbertofjr.hotel.model.Hotel
import br.com.adalbertofjr.hotel.repository.sqlite.DATABASE_NAME
import br.com.adalbertofjr.hotel.repository.sqlite.DATABASE_VERSION

@Database(entities = [Hotel::class], version = DATABASE_VERSION)
abstract class HotelDatabase : RoomDatabase() {

    abstract fun hotelDao(): HotelDao

    companion object {
        private var instance: HotelDatabase? = null

        fun getDatabase(context: Context): HotelDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    HotelDatabase::class.java,
                    DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return instance as HotelDatabase
        }

        fun destroyInstance() {
            instance = null
        }
    }
}