package com.explorer.features.userlist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.explorer.databinding.ActivityUserListBinding
import com.explorer.features.projectlist.ui.viewmodel.ProjectListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListActivity: AppCompatActivity() {

    private val viewModel: UserListViewModel by viewModel()
    private lateinit var binding: ActivityUserListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupObservers()
        setupListeners()
    }

    private fun setupView(){

    }

    private fun setupObservers(){

    }

    private fun setupListeners(){

    }

}