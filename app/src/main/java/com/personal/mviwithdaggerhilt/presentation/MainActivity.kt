package com.personal.mviwithdaggerhilt.presentation

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.personal.mviwithdaggerhilt.R
import com.personal.mviwithdaggerhilt.domain.Blog
import com.personal.mviwithdaggerhilt.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogEvents)

    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this) { dataState ->
            when(dataState) {
                is DataState.Success -> {
                    isProgressBarVisible(false)
                    displayResponse(dataState.data)
                }
                is DataState.Error -> {
                    isProgressBarVisible(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    isProgressBarVisible(true)
                }
            }
        }
    }

    private fun displayResponse(data: List<Blog>) {
        val message = data.joinToString(separator = "\n") { it.title }
        text_message.text = message
    }

    private fun displayError(error: String?) {
        Toast.makeText(this, error ?: "", Toast.LENGTH_SHORT).show()
    }

    private fun isProgressBarVisible(bool: Boolean) {
        if(bool) {
            progressbar.visibility = View.VISIBLE
            return
        }
        progressbar.visibility = View.INVISIBLE
    }
}