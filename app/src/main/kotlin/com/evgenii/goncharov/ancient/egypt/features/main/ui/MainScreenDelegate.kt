package com.evgenii.goncharov.ancient.egypt.features.main.ui

import com.evgenii.goncharov.ancient.egypt.databinding.ItemBannerBinding
import com.evgenii.goncharov.ancient.egypt.databinding.ItemGoToMapButtonBinding
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BannerModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.BaseContentModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MapButtonModel
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun mapButtonDelegate(mapClickListener: () -> Unit) =
    adapterDelegateViewBinding<MapButtonModel, BaseContentModel, ItemGoToMapButtonBinding>(
        { layoutInflater, root -> ItemGoToMapButtonBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.btnGoToMap.setOnClickListener {
                mapClickListener()
            }
        }
    }

fun bannerDelegate() =
    adapterDelegateViewBinding<BannerModel, BaseContentModel, ItemBannerBinding>(
        { layoutInflater, root -> ItemBannerBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.root.title = item.title
            binding.root.description = item.description
            binding.root.bannerUri = item.bannerUri
            binding.root.initView()
        }
    }
