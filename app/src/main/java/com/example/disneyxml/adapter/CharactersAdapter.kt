package com.example.disneyxml.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.disneyxml.R
import com.example.disneyxml.databinding.ItemCharacterBinding
import com.example.disneyxml.model.CharacterData

class CharactersAdapter():
        ListAdapter<CharacterData, CharacterViewHolder>(CharacterDiffCallBack()){

    private val characters = mutableListOf<CharacterData>()

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): CharacterViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false).apply {
            return CharacterViewHolder(this)
        }
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position).let {
            character -> holder.bind(character)
        }
    }
}

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
     val binding: ItemCharacterBinding = ItemCharacterBinding.bind(itemView)

    fun bind(character: CharacterData) {
        binding.textViewCharacterName.text = character.name
        binding.textViewFilms.text = character.films.toString()
        binding.textViewTvShows.text = character.tvShows.joinToString(separator = "\n")
        binding.textViewParkAttractions.text = character.parkAttractions.toString()

        character.let {
            Glide.with(itemView.context).load(it.imageUrl)
                .into(binding.imageViewCharacterImage)
        }
    }
}