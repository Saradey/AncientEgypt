package com.evgenii.goncharov.ancient.egypt.features.main.use.cases

import com.evgenii.goncharov.ancient.egypt.base.models.model.FromDbBaseModel
import com.evgenii.goncharov.ancient.egypt.features.main.models.models.ContentModel

interface MainContentFromDbUseCase {

    suspend operator fun invoke() : FromDbBaseModel<ContentModel>
}