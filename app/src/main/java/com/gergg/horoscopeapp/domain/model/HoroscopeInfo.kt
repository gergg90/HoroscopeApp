package com.gergg.horoscopeapp.domain.model

import com.gergg.horoscopeapp.R

sealed class HoroscopeInfo(val img: Int, val name: Int) {

    data object Aries : HoroscopeInfo(R.drawable.aries, R.string.Aries)
    data object Taurus : HoroscopeInfo(R.drawable.taurus, R.string.Taurus)
    data object Gemini : HoroscopeInfo(R.drawable.gemini, R.string.Gemini)
    data object Cancer : HoroscopeInfo(R.drawable.cancer, R.string.Cancer)
    data object Leo : HoroscopeInfo(R.drawable.leo, R.string.Leo)
    data object Virgo : HoroscopeInfo(R.drawable.virgo, R.string.Virgo)
    data object Libra : HoroscopeInfo(R.drawable.libra, R.string.Libra)
    data object Scorpio : HoroscopeInfo(R.drawable.scorpio, R.string.Scorpio)
    data object Sagittarius : HoroscopeInfo(R.drawable.sagittarius, R.string.Sagittarius)
    data object Capricorn : HoroscopeInfo(R.drawable.capricorn, R.string.Capricorn)
    data object Aquarius : HoroscopeInfo(R.drawable.aquarius, R.string.Aquarius)
    data object Pisces : HoroscopeInfo(R.drawable.pisces, R.string.Pisces)


}