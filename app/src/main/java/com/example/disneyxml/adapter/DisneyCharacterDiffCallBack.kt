package com.example.disneyxml.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.disneyxml.data.model.DisneyCharacterData

class DisneyCharacterDiffCallBack: DiffUtil.ItemCallback<DisneyCharacterData>()  {
    override fun areItemsTheSame(
        oldItem: DisneyCharacterData,
        newItem: DisneyCharacterData
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: DisneyCharacterData,
        newItem: DisneyCharacterData
    ): Boolean {
        return oldItem.id == newItem.id
    }
}