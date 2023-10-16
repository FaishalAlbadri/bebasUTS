package com.faishalbadri.bebasuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.faishalbadri.bebasuts.databinding.ActivityBacaBinding

class BacaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBacaBinding
    private lateinit var pesan: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityBacaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pesan = intent.getStringExtra("pesan").toString()
        binding.txtPesan.text = pesan

        binding.btnKirim.setOnClickListener {
            if (binding.edtPesan.text.toString().length > 0) { // cek apakah pesan sudah di tulis
                startActivity(
                    Intent(applicationContext, MainActivity::class.java) // pindah ke activity baca
                    .putExtra("pesan", binding.edtPesan.text.toString()) // untuk kirim data pesan
                )
                finish()
            } else { // jika pesan masih kosong
                Toast.makeText(this, "Masukkan Pesan", Toast.LENGTH_SHORT).show()
            }
        }
    }
}