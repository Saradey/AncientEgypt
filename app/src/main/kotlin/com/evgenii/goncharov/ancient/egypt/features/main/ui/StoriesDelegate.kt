package com.evgenii.goncharov.ancient.egypt.features.main.ui

import com.bumptech.glide.Glide
import com.evgenii.goncharov.ancient.egypt.databinding.ItemStoriesBinding
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.StoriesModel
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun storiesDelegate() = adapterDelegateViewBinding<StoriesModel, StoriesModel, ItemStoriesBinding>(
    { layoutInflater, root -> ItemStoriesBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        Glide.with(context)
            .load(item.storiesImage)
            .into(binding.imvImageStories)
        if (item.storiesTitle.isNotEmpty()) {
            binding.txvStoriesTitle.text = item.storiesTitle
        }
    }
}