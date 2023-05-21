package com.githubexplorer.features.projectlist.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.githubexplorer.R
import com.githubexplorer.databinding.ActivityProjectListBinding
import com.githubexplorer.features.projectlist.ui.adapter.ProjectListLoadingAdapter
import com.githubexplorer.features.projectlist.ui.adapter.ProjectListPagingAdapter
import com.githubexplorer.features.projectlist.ui.state.ProjectListViewState
import com.githubexplorer.features.projectlist.ui.viewmodel.ProjectListViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val FIRST_ITEM_INDEX = 0
private const val SECOND_ITEM_INDEX = 1

class ProjectListActivity : AppCompatActivity() {

    private val viewModel: ProjectListViewModel by viewModel()
    private val adapter = ProjectListPagingAdapter()
    private lateinit var binding: ActivityProjectListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupStateListener()
        setupCollapsingToolbar()
        setupRecyclerView()
        setupButtons()
        setupAdapterState()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_users -> {
                val emoji = "\uD83D\uDE0A"
                val message = String.format("Função disponivel apenas na versão paga %s. \nPara mais informações entre em contato através do email \ngiovanileitevitor@gmail.com", emoji)
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_repository -> {
                viewModel.loadProjectList()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setupAdapterState() = lifecycleScope.launch {
        adapter.loadStateFlow.collect { loadState ->
            binding.loadingView.isVisible = loadState.refresh is LoadState.Loading
            binding.errorViewGroup.isVisible = loadState.refresh is LoadState.Error
        }
    }

    private fun setupStateListener() {
        viewModel.viewState.observe(this) { state ->
            with(state) {
                onLoadingState()
                onErrorState()
                onSuccessState()
            }
        }
    }

    private fun ProjectListViewState.onSuccessState() = with(binding) {
        projects?.let { data ->
            recyclerView.isVisible = true
            lifecycleScope.launch {
                adapter.submitData(data)
            }
        }
    }

    private fun ProjectListViewState.onLoadingState() {
        binding.loadingView.isVisible = isLoading
    }

    private fun ProjectListViewState.onErrorState() {
        binding.errorViewGroup.isVisible = isErrorVisible
    }

    private fun setupCollapsingToolbar() = with(binding) {
        setSupportActionBar(toolbar)
        collapsingToolbar.setContentScrimColor(Color.TRANSPARENT)
    }

    private fun setupRecyclerView() = with(binding) {
        recyclerView.adapter = adapter.withLoadStateFooter(ProjectListLoadingAdapter())
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (recyclerView.isFirstItemVisible()) {
                    scrollToTopButton.show()
                } else {
                    scrollToTopButton.hide()
                }
            }
        })
    }

    private fun RecyclerView.isFirstItemVisible(): Boolean {
        return (layoutManager as LinearLayoutManager)
            .findFirstCompletelyVisibleItemPosition() > SECOND_ITEM_INDEX
    }

    private fun setupButtons() = with(binding) {
        reloadButton.setOnClickListener {
            viewModel.loadProjectList()
        }
        scrollToTopButton.setOnClickListener {
            recyclerView.smoothScrollToPosition(FIRST_ITEM_INDEX)
        }
    }
}