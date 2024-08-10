package com.rifkydelta.suitmedia

import ApiClient
import ApiResponse
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUser : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val btnBack: ImageButton = findViewById(R.id.btnBack3)

        fetchUsers()

        val pageText: TextView = findViewById(R.id.pageNumber3)
        pageText.text = "Third Screen"

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun fetchUsers() {
        ApiClient.instance.getUsers(page = 1, perPage = 10).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val users = response.body()?.data.orEmpty()
                    userAdapter = UserAdapter(users)
                    recyclerView.adapter = userAdapter
                } else {
                    Toast.makeText(this@ListUser, "Failed to get users", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("ListUser", "Error fetching users", t)
                Toast.makeText(this@ListUser, "Error fetching users", Toast.LENGTH_SHORT).show()
            }
        })
    }

}

