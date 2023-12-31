package com.example.retrofitmodelview.presentation.main


import androidx.lifecycle.ViewModel
import com.example.retrofitmodelview.domain.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DealerFinderViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private var currentPage = 1
    var isLastPage = false

    suspend fun fetchEvents(page: Int, perPage: Int): List<com.example.retrofitmodelview.data.model.Event?>? {
        if (isLastPage) {
            return null
        }

        val response = mainRepository.fetchEvents(page, perPage)

        if (response.events.isNullOrEmpty()) {
            isLastPage = true
        } else {
            currentPage++
        }

        return response.events
    }

    fun getCurrentPage(): Int {
        return currentPage
    }
}


//@HiltViewModel
//class DealerFinderViewModel  @Inject constructor(private val repository: Repository) : ViewModel() {
//
//    private val apiService = RetrofitClient.eventsApiService
//    private var currentPage = 1
//    var isLastPage = false
//
//    suspend fun fetchEvents(page: Int, perPage: Int): List<Event?>? {
//        if (isLastPage) {
//            return null
//        }
//        val response = apiService.getEvents(page, perPage)
//        if (response.events.isNullOrEmpty()) {
//            isLastPage = true
//        } else {
//                currentPage++
//
//        }
//        return response.events
//    }
//
//    fun getCurrentPage(): Int {
//        return currentPage
//    }
//
//}
