package com.explorer.features.projectlist.domain.repository

import androidx.paging.PagingData
import com.explorer.features.projectlist.domain.model.ProjectItem
import kotlinx.coroutines.flow.Flow

interface ProjectsListRepository {
    fun getProjectsList(): Flow<PagingData<ProjectItem>>
}