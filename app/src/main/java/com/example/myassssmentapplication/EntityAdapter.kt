package com.example.myassssmentapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EntityAdapter(
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityAdapter.ViewHolder>() {

    private var entityList = listOf<Entity>()

    fun setData(newData: List<Entity>) {
        entityList = newData
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public val tvProperty1: TextView = itemView.findViewById(R.id.tvProperty1)
        public val tvProperty2: TextView = itemView.findViewById(R.id.tvProperty2)
        public val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)


        fun bind(entity: Entity) {
            tvProperty1.text = entity.name
            tvProperty2.text = entity.culture
            tvDescription.text = entity.description

            itemView.setOnClickListener {
                onItemClick(entity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(entityList[position])
    }

    override fun getItemCount() = entityList.size
}

