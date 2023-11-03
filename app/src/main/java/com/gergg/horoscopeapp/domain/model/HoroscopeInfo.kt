package com.gergg.horoscopeapp.domain.model

import com.gergg.horoscopeapp.R

sealed class HoroscopeInfo(val name: Int, val img: Int) {

    data object Aries : HoroscopeInfo(R.string.aries, R.drawable.aries)
    data object Tauro : HoroscopeInfo(R.string.tauro, R.drawable.tauro)
    data object Geminis : HoroscopeInfo(R.string.geminis, R.drawable.geminis)
    data object Cancer : HoroscopeInfo(R.string.cancer, R.drawable.cancer)
    data object Leo : HoroscopeInfo(R.string.leo, R.drawable.leo)
    data object Virgo : HoroscopeInfo(R.string.virgo, R.drawable.virgo)
    data object Libra : HoroscopeInfo(R.string.libra, R.drawable.libra)
    data object Escorpio : HoroscopeInfo(R.string.escorpio, R.drawable.escorpio)
    data object Sagitario : HoroscopeInfo(R.string.sagitario, R.drawable.sagitario)
    data object Capricornio : HoroscopeInfo(R.string.capricornio, R.drawable.capricornio)
    data object Acuario : HoroscopeInfo(R.string.acuario, R.drawable.acuario)
    data object Piscis : HoroscopeInfo(R.string.piscis, R.drawable.piscis)


}