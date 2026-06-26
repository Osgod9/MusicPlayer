package com.example.musicplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplayer.databinding.ActivityMainBinding
import android.widget.Toast
import android.media.MediaPlayer

class MainActivity : AppCompatActivity() {

    // Variable para acceder a los componentes de la interfaz
    private lateinit var binding: ActivityMainBinding

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos el ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Mostramos la interfaz
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.mi_cancion)
        binding.txtTitulo.text = "🎵 Mi Primer Music Player"

        binding.btnPlay.setOnClickListener {

            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }

        }

        binding.btnPause.setOnClickListener {

            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }

        }
        binding.btnStop.setOnClickListener {

            if (::mediaPlayer.isInitialized) {

                mediaPlayer.stop()

                mediaPlayer = MediaPlayer.create(this, R.raw.mi_cancion)

            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}