package br.com.adalbertofjr.hotel.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.adalbertofjr.hotel.model.Hotel
import br.com.adalbertofjr.hotel.repository.HotelRepository


class HotelDetailsViewModel(
    private val repository: HotelRepository
) : ViewModel() {
    fun loadHotelDetails(id: Long): LiveData<Hotel> = repository.hotelById(id)
}