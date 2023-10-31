package com.gergg.horoscopeapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.gergg.horoscopeapp.databinding.ItemHoroscopeBinding
import com.gergg.horoscopeapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        // binding.tvTitle.text = context.getString(horoscopeInfo.name) -> Opcion Recomendada por el curso
        binding.tvTitle.setText(horoscopeInfo.name)

        binding.itemHoroscope.setOnClickListener {
            startRotation(binding.ivHoroscope, newLambda = { onItemSelected(horoscopeInfo) })
            // onItemSelected(horoscopeInfo)
        }

    }


    private fun startRotation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 400
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction() { newLambda() }
            start()
        }
    }


}