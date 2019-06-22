package br.com.adalbertofjr.hotel.di

import br.com.adalbertofjr.hotel.details.HotelDetailsViewModel
import br.com.adalbertofjr.hotel.form.HotelFormViewModel
import br.com.adalbertofjr.hotel.list.HotelListViewModel
import br.com.adalbertofjr.hotel.repository.HotelRepository
import br.com.adalbertofjr.hotel.repository.room.HotelDatabase
import br.com.adalbertofjr.hotel.repository.room.RoomRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {

    single { this }
    single {
        RoomRepository(HotelDatabase.getDatabase(context = get())) as HotelRepository
    }

    viewModel {
        HotelListViewModel(repository = get())
    }

    viewModel {
        HotelDetailsViewModel(repository = get())
    }

    viewModel {
        HotelFormViewModel(repository = get())
    }
}