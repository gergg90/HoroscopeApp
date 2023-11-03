package com.gergg.horoscopeapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gergg.horoscopeapp.databinding.FragmentHoroscopeBinding
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
import com.gergg.horoscopeapp.domain.model.HoroscopeModel
import com.gergg.horoscopeapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initRecyclerView()
        initUIState()
    }

    private fun initRecyclerView() {
        horoscopeAdapter = HoroscopeAdapter() {
            val type = when (it) {
                Acuario -> HoroscopeModel.Acuario
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricornio -> HoroscopeModel.Capricornio
                Escorpio -> HoroscopeModel.Escorpio
                Geminis -> HoroscopeModel.Geminis
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Piscis -> HoroscopeModel.Piscis
                Sagitario -> HoroscopeModel.Sagitario
                Tauro -> HoroscopeModel.Tauro
                Virgo -> HoroscopeModel.Virgo
            }

            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
            )
        }

        binding.recyclerViewHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}