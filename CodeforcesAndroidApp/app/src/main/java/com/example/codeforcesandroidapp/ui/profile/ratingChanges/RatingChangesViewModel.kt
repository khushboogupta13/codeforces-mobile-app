package com.example.codeforcesandroidapp.ui.profile.ratingChanges

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codeforcesandroidapp.model.profile.RatingChangeBusinessModel
import com.example.codeforcesandroidapp.repository.profile.RatingChangesRepository
import kotlinx.coroutines.launch

class RatingChangesViewModel(private val ratingChangesRepo : RatingChangesRepository) : ViewModel() {

    var ratingList = MutableLiveData<List<RatingChangeBusinessModel>>()
    var isLoading : MutableLiveData<Boolean> = MutableLiveData(false)

    fun fetchRating(){
        isLoading.value = true

        viewModelScope.launch {
            ratingChangesRepo.fetchratingchanges {
                ratingList.value = it
                isLoading.value = false
            }
        }
    }
}