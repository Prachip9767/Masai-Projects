package com.app.pr.repo

import com.app.pr.api.ApiClient
import com.app.pr.api.ResponseDTO
import com.app.pr.di.AppModule
import com.app.pr.di.Resource
import com.app.pr.di.ResponseHandler
import javax.inject.Inject

class repository @Inject constructor(private val apiClient: ApiClient){

//        suspend fun getResponse():List<Result>{
//            return apiClient.getApiResponse().results
//    }


    private val responseHandler: ResponseHandler = ResponseHandler()

    suspend fun getApiData(): Resource<ResponseDTO> {
        return try {
            val responseDTO: ResponseDTO = AppModule.ApiService().getApiResponse()
            responseHandler.handleSuccess(responseDTO)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}