package com.explorer.features.projectlist.ui.viewholder

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.explorer.databinding.ItemProjectListLoadingBinding

class ProjectListLoadingViewHolder(
    private val binding: ItemProjectListLoadingBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        binding.footerLoadingView.isVisible = true
    }
}