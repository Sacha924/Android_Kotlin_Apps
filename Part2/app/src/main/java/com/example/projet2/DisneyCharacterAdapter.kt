package com.example.projet2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DisneyCharacterAdapter(private val characters: List<DisneyCharacter>) :
    RecyclerView.Adapter<DisneyCharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.character_image)
        val nameView: TextView = view.findViewById(R.id.character_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        Glide.with(holder.imageView.context)
            .load(character.imageUrl)
            .into(holder.imageView)
        holder.nameView.text = character.name
    }

    override fun getItemCount() = characters.size
}