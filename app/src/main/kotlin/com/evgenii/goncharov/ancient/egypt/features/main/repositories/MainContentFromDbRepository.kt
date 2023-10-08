package com.evgenii.goncharov.ancient.egypt.features.main.repositories

import com.evgenii.goncharov.ancient.egypt.base.models.model.FromDbBaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel

interface MainContentFromDbRepository {

    suspend operator fun invoke(): FromDbBaseModel<ContentModel>
}