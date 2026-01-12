package com.example.disneyxml.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.disneyxml.R
import com.example.disneyxml.adapter.DisneyCharactersAdapter
import com.example.disneyxml.data.model.DisneyCharacterData
import com.example.disneyxml.databinding.CharactersFragmentBinding
import com.example.disneyxml.viewModel.DisneyCharacterViewModel
import org.koin.android.ext.android.inject
import kotlin.getValue

class CharacterFragment : Fragment(R.layout.characters_fragment) {

    private var viewModel by inject<DisneyCharacterViewModel>()
    private lateinit var binding: CharactersFragmentBinding

    private val disneyCharactersAdapter = DisneyCharactersAdapter()

    private val observerCharacters = Observer<List<DisneyCharacterData>> {
            disneyCharactersAdapter.update(it.toMutableList())
            binding.progressBar.visibility = View.GONE
            binding.disneyCharacterRecyclerView.visibility = View.VISIBLE
        }

    private val observerPage = Observer<Int> {
        viewModel.getCharacterList(page = it)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CharactersFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this)[DisneyCharacterViewModel::class.java]
        viewModel.characters.observe(viewLifecycleOwner, observerCharacters)
        viewModel.page.observe(viewLifecycleOwner, observerPage)

        setupRecyclerView()
        viewModel.getCharacterList(1)
    }

    private fun setupRecyclerView() = with(binding.disneyCharacterRecyclerView) {
        adapter = disneyCharactersAdapter
        layoutManager = LinearLayoutManager(requireContext())
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    viewModel.nextPage()
                }
                hideSoftInput()
            }
        })
    }

    fun View.hideSoftInput() {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }


}