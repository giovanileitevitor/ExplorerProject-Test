package com.explorer.features.projectlist.ui.state

import androidx.paging.PagingData
import com.explorer.features.projectlist.domain.model.ProjectItem

data class ProjectListViewState(
    val isLoading: Boolean = false,
    val isErrorVisible: Boolean = false,
    val projects: PagingData<ProjectItem>? = null
)