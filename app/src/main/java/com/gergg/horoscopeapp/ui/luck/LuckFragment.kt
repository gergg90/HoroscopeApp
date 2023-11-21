package com.gergg.horoscopeapp.ui.luck

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.gergg.horoscopeapp.R
import com.gergg.horoscopeapp.databinding.FragmentLuckBinding
import com.gergg.horoscopeapp.ui.core.listeners.OnSwipeTouchListener
import com.gergg.horoscopeapp.ui.providers.RandomCardProvider
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject

@AndroidEntryPoint
class LuckFragment : Fragment() {

    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var randomCardProvider: RandomCardProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        preparePrediction()
        initListener()
    }

    private fun preparePrediction() {
        val luck = randomCardProvider.getLucky()
        luck?.let { luckIt ->
            binding.tvLucky.setText(luckIt.text)
            binding.ivLuckyCard.setImageResource(luckIt.img)
            binding.tvShare.setOnClickListener {
                shareResult("Hola " + getString(luckIt.text))
            }
        }
    }

    private fun shareResult(prediction: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, prediction)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListener() {
        // binding.ivRoulette.setOnClickListener { spinRoulette() }

        binding.ivRoulette.setOnTouchListener(object : OnSwipeTouchListener(requireContext()) {
            override fun onSwipeLeft() {
                spinRoulette()
            }

            override fun onSwipeRight() {
                spinRoulette()
            }

        })

        binding.ivOnBackPressedLuck.setOnClickListener {
            backToRoulette()
        }
    }

    private fun backToRoulette() {
        binding.preview.isVisible = true
        binding.prediction.isVisible = false
    }

    private fun spinRoulette() {
        val random = Random()
        val degrees = random.nextInt(1440) + 360
        val animator =
            ObjectAnimator.ofFloat(binding.ivRoulette, View.ROTATION, 0f, degrees.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()
    }

    private fun slideCard() {

        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation?) {
                binding.ivReverse.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        binding.ivReverse.startAnimation(slideUpAnimation)
    }

    private fun growCard() {

        val growAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.grow_card)

        growAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.ivReverse.isVisible = false
                showPremonitionView()
            }

            override fun onAnimationRepeat(animation: Animation?) {
                showPreviewView()
            }

        })

        binding.ivReverse.startAnimation(growAnimation)

    }


    private fun showPremonitionView() {
        val disappearAnimation = AlphaAnimation(1.0f, 0.0f)
        disappearAnimation.duration = 200

        val appearAnimation = AlphaAnimation(0.0f, 1.0f)
        appearAnimation.duration = 1000

        disappearAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.preview.isVisible = false
                binding.prediction.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })

        binding.preview.startAnimation(disappearAnimation)
        binding.prediction.startAnimation(appearAnimation)

    }

    private fun showPreviewView() {

        val disappearAnimation = AlphaAnimation(1.0f, 0.0f)
        disappearAnimation.duration = 200

        val appearAnimation = AlphaAnimation(0.0f, 1.0f)
        appearAnimation.duration = 1000

        disappearAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.preview.isVisible = false
                binding.prediction.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })

        binding.preview.startAnimation(disappearAnimation)
        binding.prediction.startAnimation(appearAnimation)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}