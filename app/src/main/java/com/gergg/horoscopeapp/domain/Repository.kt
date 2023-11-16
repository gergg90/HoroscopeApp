package com.gergg.horoscopeapp.domain

import com.gergg.horoscopeapp.domain.model.PredictionModel

interface Repository {

    suspend fun getPrediction(sign: String): PredictionModel?

}