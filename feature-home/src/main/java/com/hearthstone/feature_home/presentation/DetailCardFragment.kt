package com.hearthstone.feature_home.presentation

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.hearthstone.feature.home.databinding.FragmentDetailCardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailCardFragment : Fragment() {
    private val viewModel: DetailViewModel by viewModel()
    private val arguments by navArgs<DetailCardFragmentArgs>()
    private var binding: FragmentDetailCardBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailCardBinding.inflate(inflater, container, false).apply {
        binding = this
        visibleOrGone(View.VISIBLE)
        viewModel.getCard(arguments.cardBackArg.name)
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.toolbar?.title = arguments.cardBackArg.name
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.cardBackLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is DetailState.Success -> {
                    showInformationCard(state)
                }

                is DetailState.Error -> {
                    binding?.loadingFailure?.visibility = View.VISIBLE
                    binding?.ctContainer?.visibility = View.GONE
                    binding?.loadingFailure?.text = state.message
                }
            }
        }
    }

    private fun showInformationCard(state: DetailState.Success) {
        binding?.imgDetail?.let {
            Glide.with(this)
                .load(state.card.img)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        p0: GlideException?,
                        p1: Any?,
                        p2: Target<Drawable>?,
                        p3: Boolean
                    ): Boolean {
                        visibleOrGone(View.GONE)
                        return false
                    }

                    override fun onResourceReady(
                        p0: Drawable?,
                        p1: Any?,
                        p2: Target<Drawable>?,
                        p3: DataSource?,
                        p4: Boolean
                    ): Boolean {
                        visibleOrGone(View.GONE)
                        return false
                    }
                })
                .into(it)
        }
        binding?.txtFlavor?.text = state.card.flavor
        binding?.txtSet?.text = state.card.cardSet
        binding?.txtType?.text = state.card.type
        binding?.txtFaction?.text = state.card.faction
        binding?.txtRarity?.text = state.card.rarity
        binding?.txtAttack?.text = state.card.attack
        binding?.txtCost?.text = state.card.cost
        binding?.txtHealth?.text = state.card.health
        binding?.txtName?.text = arguments.cardBackArg.text
    }

    private fun visibleOrGone(visibility: Int) {
        binding?.progressBar?.visibility = visibility
    }
}