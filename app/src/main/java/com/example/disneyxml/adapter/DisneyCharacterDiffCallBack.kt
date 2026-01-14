package com.example.disneyxml.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.disneyxml.data.model.DisneyCharacterModel

class DisneyCharacterDiffCallBack: DiffUtil.ItemCallback<DisneyCharacterModel>()  {
    override fun areItemsTheSame(
        oldItem: DisneyCharacterModel,
        newItem: DisneyCharacterModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: DisneyCharacterModel,
        newItem: DisneyCharacterModel
    ): Boolean {
        return oldItem.id == newItem.id
    }
}