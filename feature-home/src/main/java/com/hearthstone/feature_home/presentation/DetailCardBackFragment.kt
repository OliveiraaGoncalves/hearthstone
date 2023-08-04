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
import com.hearthstone.feature.home.databinding.FragmentDetailCardBackBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailCardBackFragment : Fragment() {
    private val viewModel: DetailViewModel by viewModel()
    private val arguments by navArgs<DetailCardBackFragmentArgs>()
    private var binding: FragmentDetailCardBackBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailCardBackBinding.inflate(inflater, container, false).apply {
        binding = this
        visibleOrGone(View.VISIBLE)
        viewModel.getCard(arguments.cardBackArg.name)
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.toolbar?.title = arguments.cardBackArg.name
        viewModel.cardBackLiveData.observe(viewLifecycleOwner) { card ->
            binding?.imgDetail?.let {
                Glide.with(this)
                    .load(card.img)
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
            binding?.txtFlavor?.text = card.flavor
            binding?.txtSet?.text = card.cardSet
            binding?.txtType?.text = card.type
            binding?.txtFaction?.text = card.faction
            binding?.txtRarity?.text = card.rarity
            binding?.txtAttack?.text = card.attack
            binding?.txtCost?.text = card.cost
            binding?.txtHealth?.text = card.health

        }
        binding?.txtName?.text = arguments.cardBackArg.text

    }

    private fun visibleOrGone(visibility: Int) {
        binding?.progressBar?.visibility = visibility
    }
}