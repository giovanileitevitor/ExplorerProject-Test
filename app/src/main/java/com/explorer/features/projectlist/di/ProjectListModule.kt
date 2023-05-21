package com.explorer.features.projectlist.di

import androidx.paging.PagingSource
import com.explorer.core.utils.data.remote.RemoteBuilder
import com.explorer.core.utils.data.remote.RetrofitBuilderImpl
import com.explorer.features.projectlist.data.ProjectListMapper
import com.explorer.features.projectlist.data.model.ProjectItemResponse
import com.explorer.features.projectlist.data.pagingsource.ProjectsListPagingSource
import com.explorer.features.projectlist.data.repository.ProjectsListRepositoryImpl
import com.explorer.features.projectlist.data.service.ProjectsListService
import com.explorer.features.projectlist.domain.usecase.GetProjectListUseCase
import com.explorer.features.projectlist.domain.repository.ProjectsListRepository
import com.explorer.features.projectlist.ui.viewmodel.ProjectListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val projectListModule = module {

    //ViewModel Injector
    viewModel {
        ProjectListViewModel(
            projectListUseCase = GetProjectListUseCase(
                repository = get()
            )
        )
    }

    //Paging Source Injector
    factory<PagingSource<Int, ProjectItemResponse>> {
        ProjectsListPagingSource(service = get())
    }

    //Data Source / Repository Injector
    factory<ProjectsListRepository> {
        ProjectsListRepositoryImpl(
            service = get(),
            mapper = ProjectListMapper()
        )
    }

    //Api Injector
    factory<ProjectsListService> {
        get<RemoteBuilder>().build().create(ProjectsListService::class.java)
    }

    //Retrofit Injector
    factory<RemoteBuilder> {
        RetrofitBuilderImpl()
    }

}