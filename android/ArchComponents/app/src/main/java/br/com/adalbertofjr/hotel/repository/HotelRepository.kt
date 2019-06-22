package br.com.adalbertofjr.hotel.repository

import androidx.lifecycle.LiveData
import br.com.adalbertofjr.hotel.model.Hotel

interface HotelRepository {
    fun save(hotel: Hotel)
    fun remove(vararg hotels: Hotel)
    fun hotelById(id: Long) : LiveData<Hotel>
    fun search(term:String) : LiveData<List<Hotel>>

}