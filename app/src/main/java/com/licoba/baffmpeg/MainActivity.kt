package com.licoba.baffmpeg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.licoba.baffmpeg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
        binding.sampleText.text = ffmpegInfo()
    }

    /**
     * A native method that is implemented by the 'baffmpeg' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun ffmpegInfo(): String

    companion object {
        // Used to load the 'baffmpeg' library on application startup.
        init {
            System.loadLibrary("baffmpeg")
        }
    }
}