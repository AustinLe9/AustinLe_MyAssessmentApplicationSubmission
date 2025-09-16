package com.example.myassssmentapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DashboardActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EntityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = EntityAdapter { selectedEntity ->
            Log.e("EntityClick", "Clicked entity: $selectedEntity")
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("name", selectedEntity.name)
            intent.putExtra("culture", selectedEntity.culture)
            intent.putExtra("description", selectedEntity.description)
            intent.putExtra("domain", selectedEntity.domain)
            intent.putExtra("symbol", selectedEntity.symbol)
            intent.putExtra("parentage", selectedEntity.parentage)
            intent.putExtra("romanEquivalent", selectedEntity.romanEquivalent)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        Log.e("DataFetch", "Check 1")
        val keypass = intent.getStringExtra("KEYPASS") ?: return
        Log.e("DataFetch", "Check 2")
        fetchEntities(keypass)
    }

    private fun fetchEntities(keypass: String) {
        RetrofitClient.instance.getDashboard(keypass)
            .enqueue(object : Callback<DashboardResponse> {
                override fun onResponse(
                    call: Call<DashboardResponse>,
                    response: Response<DashboardResponse>
                ) {
                    if (response.isSuccessful) {
                        val entities = response.body()?.entities ?: emptyList()
                        Log.e("DataFetch", response.body().toString())
                        adapter.setData(entities)
                    }
                }

                override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                    // Handle error
                }
            })
    }
}
