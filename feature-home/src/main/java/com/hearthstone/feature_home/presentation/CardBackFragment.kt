package com.hearthstone.feature_home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hearthstone.feature.home.R
import com.hearthstone.feature.home.databinding.FragmentCardBackBinding

class CardBackFragment : Fragment() {
    private var _binding: FragmentCardBackBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardBackBinding.inflate(inflater, container, false)
        return binding.root
    }
}