package com.githubexplorer.features.projectlist

import androidx.paging.PagingData
import com.githubexplorer.features.projectlist.data.model.ProjectItemResponse
import com.githubexplorer.features.projectlist.data.model.ProjectListResponse
import com.githubexplorer.features.projectlist.data.model.ProjectOwner
import com.githubexplorer.features.projectlist.domain.model.ProjectItem

object ProjectListStubs {

    fun generateProjectsFirstPage() = listOf(
        ProjectItem(
            id = 1,
            name = "okhttp",
            fullName = "square/okhttp",
            isPrivate = false,
            starsCount = 11111,
            forksCount = 99999,
            ownerAvatarUrl = "url"
        ),
        ProjectItem(
            id = 2,
            name = "kotlin",
            fullName = "JetBrains/kotlin",
            isPrivate = false,
            starsCount = 666333,
            forksCount = 111222,
            ownerAvatarUrl = "url"
        )
    )

    fun generateProjectsFirstPageResponse() = ProjectListResponse(
        projects = listOf(
            ProjectItemResponse(
                id = 1,
                name = "okhttp",
                fullName = "square/okhttp",
                isPrivate = false,
                starsCount = 12345,
                forksCount = 54321,
                owner = ProjectOwner(
                    avatarUrl = "url"
                )
            ),
            ProjectItemResponse(
                id = 2,
                name = "kotlin",
                fullName = "JetBrains/kotlin",
                isPrivate = false,
                starsCount = 223344,
                forksCount = 443322,
                owner = ProjectOwner(
                    avatarUrl = "url"
                )
            )
        )
    )

    fun generateProjectsSecondPageResponse() = ProjectListResponse(
        projects = listOf(
            ProjectItemResponse(
                id = 3,
                name = "architecture-samples",
                fullName = "android/architecture-samples",
                isPrivate = false,
                starsCount = 49999,
                forksCount = 74844,
                owner = ProjectOwner(
                    avatarUrl = "url"
                )
            )
        )
    )

    fun generatePagingData() = PagingData.empty<ProjectItem>()
}