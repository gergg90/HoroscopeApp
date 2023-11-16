package com.gergg.horoscopeapp.data

import android.util.Log
import com.gergg.horoscopeapp.data.network.HoroscopeApiService
import com.gergg.horoscopeapp.domain.Repository
import com.gergg.horoscopeapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("gergg", "RepositoryImpl -->> ${it.message}") }

        return null
    }

}