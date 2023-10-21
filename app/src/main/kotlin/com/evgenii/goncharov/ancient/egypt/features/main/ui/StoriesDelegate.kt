package com.evgenii.goncharov.ancient.egypt.features.main.ui

import com.bumptech.glide.Glide
import com.evgenii.goncharov.ancient.egypt.databinding.ItemStoriesBinding
import com.evgenii.goncharov.ancient.egypt.features.main.mappers.StoriesModelToSelectedStoriesModelMapper
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.SelectedStoriesModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.MainStoriesModel
import com.hannesdorfmann.adapterdelegates4.AbsDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun storiesDelegate(
    storiesClick: (SelectedStoriesModel) -> Unit,
) =
    adapterDelegateViewBinding<MainStoriesModel, MainStoriesModel, ItemStoriesBinding>(
        { layoutInflater, root -> ItemStoriesBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            val adapter = bindingAdapter as AbsDelegationAdapter<*>
            val items = adapter.items as List<*>
            Glide.with(context)
                .load(item.storiesImage)
                .into(binding.imvImageStories)
            if (item.storiesTitle.isNotEmpty()) {
                binding.txvStoriesTitle.text = item.storiesTitle
            }
            binding.root.setOnClickListener {
                storiesClick(
                    StoriesModelToSelectedStoriesModelMapper.mapStoriesModelToSelectedStoriesModel(
                        selectedItem = item,
                        items = items
                    )
                )
            }
        }
    }