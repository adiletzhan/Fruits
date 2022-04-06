package com.example.fruits.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fruits.databinding.ItemFruitBinding
import com.example.fruits.domain.models.Fruit

class FruitAdapter: RecyclerView.Adapter<FruitsViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<Fruit>() {
        override fun areItemsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    var fruits: List<Fruit>
        get() = differ.currentList
        set(value) {differ.submitList(value)}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        return FruitsViewHolder(
            ItemFruitBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.binding.apply {
            val fruit = fruits[position]
            tvName.text = fruit.name
            tvFat.text = fruit.nutritions.fat.toString()
            tvProtein.text = fruit.nutritions.protein.toString()
            tvSugar.text = fruit.nutritions.sugar.toString()
        }
    }

    override fun getItemCount(): Int = fruits.size

}