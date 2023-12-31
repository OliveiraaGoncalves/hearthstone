package com.hearthstone.feature_home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hearthstone.feature.home.databinding.FragmentCardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModel()

    private var binding: FragmentCardBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCardBinding.inflate(inflater, container, false).apply {
        binding = this
        visibleOrGone(View.VISIBLE)
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.itemsCardBackLiveData.observe(viewLifecycleOwner) {
            binding?.recyclerViewHome?.layoutManager = LinearLayoutManager(requireContext())
            binding?.recyclerViewHome?.setHasFixedSize(true)
            binding?.recyclerViewHome?.adapter = CardAdapter(it) { cardBack ->
                findNavController().navigate(
                    CardFragmentDirections.actionCardBackFragmentToDetailCardBackFragment(
                        cardBack
                    )
                )
            }
            visibleOrGone(View.GONE)
        }
    }

    private fun visibleOrGone(visibility: Int) {
        binding?.progressBar?.visibility = visibility
        binding?.txtWait?.visibility = visibility
    }
}