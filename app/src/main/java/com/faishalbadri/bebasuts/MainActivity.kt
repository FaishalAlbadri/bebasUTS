package com.faishalbadri.bebasuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.faishalbadri.bebasuts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pesan: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // untuk hilangkan action bar.. ditulis diatas binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pesan = intent.getStringExtra("pesan").toString() // untuk terima pesan

        if (!pesan.equals("null")) { // cek apakah pesan ada atau tidak.. jika ada maka menampilkan pesan
            binding.txtPesan.text = pesan // untuk menampilkan pesan
        }

        binding.btnKirim.setOnClickListener {
            if (binding.edtPesan.text.toString().length > 0) { // cek apakah pesan sudah di tulis
                startActivity(Intent(applicationContext, BacaActivity::class.java) // pindah ke activity baca
                    .putExtra("pesan", binding.edtPesan.text.toString()) // untuk kirim data pesan
                )
                finish()
            } else { // jika pesan masih kosong
                Toast.makeText(this, "Masukkan Pesan", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnProfil.setOnClickListener {
            startActivity(Intent(applicationContext, ProfileActivity::class.java))
            finish()
        }
    }
}