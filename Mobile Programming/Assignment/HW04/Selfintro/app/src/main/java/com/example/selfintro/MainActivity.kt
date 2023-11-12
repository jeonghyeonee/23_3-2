package com.example.selfintro

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.selfintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // "Go to Profile" 버튼 클릭 시
        binding.btnGoToProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // "Go to Projects" 버튼 클릭 시
        binding.btnGoToProjects.setOnClickListener {
            startActivity(Intent(this, ProjectsActivity::class.java))
        }

        binding.btnContact.setOnClickListener {
            showContactPopup()
        }
    }

    private fun showContactPopup() {
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.contact_popup, null)

        // 팝업에 메일과 링크드인 연결 버튼 추가
        view.findViewById<Button>(R.id.btnEmail).setOnClickListener {
            sendEmail()
        }

        view.findViewById<Button>(R.id.btnLinkedIn).setOnClickListener {
            openLinkedInProfile()
        }

        // 팝업 빌더 생성
        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        // 팝업 생성 및 표시
        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun sendEmail() {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:workhappyj@gmail.com")
        startActivity(emailIntent)
    }

    private fun openLinkedInProfile() {
        val linkedInIntent = Intent(Intent.ACTION_VIEW)
        linkedInIntent.data = Uri.parse("https://www.linkedin.com/in/jeonghyeon-lee-9b6380223/")
        startActivity(linkedInIntent)
    }

}