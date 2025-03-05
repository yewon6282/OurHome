package com.yw_kim.ourhome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController

class MypageFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)

        view.findViewById<ImageButton>(R.id.main_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_to_mainFragment)
        }

        view.findViewById<ImageButton>(R.id.un_button).setOnClickListener {

        }

        view.findViewById<ImageButton>(R.id.mypage_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_self)
        }

        return view
    }
}