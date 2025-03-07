package com.yw_kim.ourhome

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MypageFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)

        auth = Firebase.auth

        view.findViewById<TextView>(R.id.logout_button).setOnClickListener {
            auth.signOut()

            val intent = Intent(requireActivity(), LoginActivity::class.java)
            startActivity(intent)
        }


        view.findViewById<ImageButton>(R.id.main_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_to_mainFragment)
        }

        view.findViewById<ImageButton>(R.id.add_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_to_addFragment)
        }

        view.findViewById<ImageButton>(R.id.mypage_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_self)
        }

        return view
    }
}