package com.app.pr.repo
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.app.pr.api.ResponseDTO
import com.app.pr.di.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
@HiltViewModel
class ViewModel @Inject constructor(var repository: repository) : ViewModel() {

    fun getDataFromApi(): LiveData<Resource<ResponseDTO>>{
        return liveData(Dispatchers.IO) {
            emit(repository.getApiData())
        }
    }
}