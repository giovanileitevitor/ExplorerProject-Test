package com.explorer.features.userlist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.explorer.databinding.ActivityUserListBinding

class UserListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityUserListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}