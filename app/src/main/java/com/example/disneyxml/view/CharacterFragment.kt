package com.example.disneyxml.view

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.disneyxml.R
import com.example.disneyxml.adapter.DisneyCharactersAdapter
import com.example.disneyxml.databinding.CharactersFragmentBinding
import com.example.disneyxml.viewModel.DisneyCharacterViewModel
import org.w3c.dom.CharacterData


class CharacterFragment : Fragment(R.layout.characters_fragment) {

    private lateinit var viewModel: DisneyCharacterViewModel
    private lateinit var binding: CharactersFragmentBinding

    private val disneyCharactersAdapter = DisneyCharactersAdapter()

    private val observerCharacters =
        Observer<List<CharacterData>> {
//            disneyCharactersAdapter.update(it.toMutableList())
            binding.progressBar.visibility = View.GONE
            binding.disneyCharacterRecyclerView.visibility = View.VISIBLE
        }

    private val observerPage = Observer<Int> {
        viewModel.getCharacterList(page = it)
    }


}