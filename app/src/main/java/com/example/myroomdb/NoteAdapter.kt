package com.example.myroomdb

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myroomdb.databinding.ItemNoteBinding
import com.example.myroomdb.model.NoteModel
import com.example.myroomdb.screens.start.StartFragment

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var noteList = emptyList<NoteModel>()

    class NoteViewHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = ItemNoteBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.tvTitleItem.text = noteList[position].title
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

   @SuppressLint("NotifyDataSetChanged")
   fun  setList(list: List<NoteModel>) {
       noteList = list
       notifyDataSetChanged()
   }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickNote(noteList[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

}