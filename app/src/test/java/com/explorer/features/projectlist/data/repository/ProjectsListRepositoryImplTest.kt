package com.explorer.features.projectlist.data.repository

import app.cash.turbine.test
import com.explorer.features.projectlist.ProjectListStubs.generateProjectsFirstPageResponse
import com.explorer.features.projectlist.data.ProjectListMapper
import com.explorer.features.projectlist.data.service.ProjectsListService
import com.explorer.utils.CoroutineTestRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class ProjectsListRepositoryImplTest {

    @get:Rule
    val rule = CoroutineTestRule()

    private val mockedService = mockk<ProjectsListService>(relaxed = true)
    private val repository = ProjectsListRepositoryImpl(mockedService, ProjectListMapper())

    @Test
    fun `load should call service and return project list`() = runTest(rule.testDispatcher) {
        coEvery { mockedService.requestProjectList(any()) } returns generateProjectsFirstPageResponse()

        repository.getProjectsList()
            .test {
                awaitEvent()
            }
    }
}