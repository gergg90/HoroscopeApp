package com.gergg.horoscopeapp.data.providers

import com.gergg.horoscopeapp.domain.model.HoroscopeInfo
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Acuario
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Aries
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Cancer
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Capricornio
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Escorpio
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Geminis
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Leo
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Libra
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Piscis
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Sagitario
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Tauro
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Virgo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Tauro,
            Geminis,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Escorpio,
            Sagitario,
            Capricornio,
            Acuario,
            Piscis,
        )
    }
}