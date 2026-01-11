package com.example.disneyxml.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.disneyxml.data.model.CharacterData

class CharacterDiffCallBack: DiffUtil.ItemCallback<CharacterData>()  {
    override fun areItemsTheSame(
        oldItem: CharacterData,
        newItem: CharacterData
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: CharacterData,
        newItem: CharacterData
    ): Boolean {
        return oldItem.id == newItem.id
    }
}