package com.example.myroomdb.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myroomdb.R
import com.example.myroomdb.databinding.FragmentAddNoteBinding
import com.example.myroomdb.model.NoteModel

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {

        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)

        binding.btnAddNote.setOnClickListener {

            val title = binding.etTitle.text.toString()
            val desc = binding.etDescription.text.toString()
            viewModel.insert(NoteModel(title = title, description = desc)){}
            findNavController().navigate(R.id.action_addNoteFragment_to_startFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }

}