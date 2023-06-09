package com.explorer.features.projectlist.domain.usecase

import androidx.paging.PagingData
import com.explorer.features.projectlist.domain.model.ProjectItem
import com.explorer.features.projectlist.domain.repository.ProjectsListRepository
import kotlinx.coroutines.flow.Flow

class GetProjectListUseCase(
    private val repository: ProjectsListRepository
) {
    operator fun invoke(): Flow<PagingData<ProjectItem>> {
        return repository.getProjectsList()
    }
}