package com.hearthstone.feature_home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.hearthstone.feature.home.databinding.FragmentCardBackBinding

class CardBackFragment : Fragment() {
    private val viewModel: CardBackViewModel by viewModel()

    private var binding: FragmentCardBackBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCardBackBinding.inflate(inflater, container, false).apply {
        lifecycle.addObserver(viewModel)
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.itemsCardBackLiveData.observe(viewLifecycleOwner) {
            binding?.recyclerViewHome?.layoutManager = LinearLayoutManager(requireContext())
            binding?.recyclerViewHome?.setHasFixedSize(true)
            binding?.recyclerViewHome?.adapter = CardBackAdapter(it){
                //chamar tela de detalhes
            }
        }
    }
}