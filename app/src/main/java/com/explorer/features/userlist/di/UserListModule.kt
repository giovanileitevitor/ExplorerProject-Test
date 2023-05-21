package com.explorer.features.userlist.di

import com.explorer.features.projectlist.domain.usecase.GetProjectListUseCase
import com.explorer.features.projectlist.ui.viewmodel.ProjectListViewModel
import com.explorer.features.userlist.ui.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userListModule = module {

    //ViewModel Injector
    viewModel {
        UserListViewModel(
            //userListUseCase = GetUserListUseCase(repository = get())
        )
    }


    //UseCase Injector

    //Data Source / Repository Injector

    //Api Injector

    //Retrofit Injector


}