package com.gergg.horoscopeapp.data.providers

import com.gergg.horoscopeapp.domain.model.HoroscopeInfo
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Aquarius
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Aries
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Cancer
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Capricorn
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Gemini
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Leo
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Libra
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Pisces
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Sagittarius
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Scorpio
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Taurus
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo.Virgo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}