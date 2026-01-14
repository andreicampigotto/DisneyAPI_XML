package com.example.disneyxml.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.disneyxml.R
import com.example.disneyxml.databinding.ItemCharacterBinding
import com.example.disneyxml.data.model.DisneyCharacterModel
import org.w3c.dom.CharacterData

class DisneyCharactersAdapter():
        ListAdapter<DisneyCharacterModel, DisneyCharacterViewHolder>(DisneyCharacterDiffCallBack()){

    private val characters = mutableListOf<DisneyCharacterModel>()

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): DisneyCharacterViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false).apply {
            return DisneyCharacterViewHolder(this)
        }
    }


    override fun onBindViewHolder(holder: DisneyCharacterViewHolder, position: Int) {
        getItem(position).let {
            characters -> holder.bind(characters)
        }
    }

    fun update(newList: MutableList<DisneyCharacterModel>) {
        characters.addAll(newList)
        notifyDataSetChanged()
    }

}

class DisneyCharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
     val binding: ItemCharacterBinding = ItemCharacterBinding.bind(itemView)

    fun bind(character: DisneyCharacterModel) {
        binding.textViewCharacterName.text = character.name
//        binding.textViewFilms.text = character.films.toString()
//        binding.textViewTvShows.text = character.tvShows.joinToString(separator = "\n")
//        binding.textViewParkAttractions.text = character.parkAttractions.toString()

        character.let {
            Glide.with(itemView.context).load(it.imageUrl)
                .into(binding.imageViewCharacterImage)
        }
    }
}