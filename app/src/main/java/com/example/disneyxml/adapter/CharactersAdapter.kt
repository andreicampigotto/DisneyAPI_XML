package com.example.disneyxml.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.disneyxml.model.CharacterData

class CharactersAdapter():
        ListAdapter<CharacterData, CharacterViewHolder>(CharacterDiffCallBack()){

    private val characters = mutableListOf<CharacterData>()

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): CharacterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position).let {
            character -> holder.bind(character)
        }
    }

}

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    //private val binding: ItemCharacterBinding = ItemCharacterBinding.bind(itemView)

    fun bind(character: CharacterData) {

    }
}