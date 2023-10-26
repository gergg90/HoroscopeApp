package com.gergg.horoscopeapp.domain.model

import com.gergg.horoscopeapp.R

sealed class HoroscopeInfo(val name: Int, val img: Int) {
    
    object Aries : HoroscopeInfo(R.string.aries, R.drawable.aries)
    object Tauro : HoroscopeInfo(R.string.tauro, R.drawable.tauro)
    object Geminis : HoroscopeInfo(R.string.geminis, R.drawable.geminis)
    object Cancer : HoroscopeInfo(R.string.cancer, R.drawable.cancer)
    object Leo : HoroscopeInfo(R.string.leo, R.drawable.leo)
    object Virgo : HoroscopeInfo(R.string.virgo, R.drawable.virgo)
    object Libra : HoroscopeInfo(R.string.libra, R.drawable.libra)
    object Escorpio : HoroscopeInfo(R.string.escorpio, R.drawable.escorpio)
    object Sagitario : HoroscopeInfo(R.string.sagitario, R.drawable.sagitario)
    object Capricornio : HoroscopeInfo(R.string.capricornio, R.drawable.capricornio)
    object Acuario : HoroscopeInfo(R.string.acuario, R.drawable.acuario)
    object Piscis : HoroscopeInfo(R.string.piscis, R.drawable.piscis)


}