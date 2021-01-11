package krasnikov.project.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import krasnikov.project.basicview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val handler by lazy {
        Handler(Looper.getMainLooper()) {
            updateText(++n)
            hideProgress()
            showViews()
            true
        }
    }

    private var n = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        updateText(n)
        setupListeners()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.btnGo.setOnClickListener {
            startTask()
        }
    }

    private fun startTask() {
        hideViews()
        showProgress()
        handler.sendEmptyMessageDelayed(0, 100L * (n + 1))
    }

    private fun updateText(n: Int) {
        binding.tvText.text = getString(R.string.tv_text, n)
    }

    private fun showViews() {
        binding.tvText.setVisibility(true)
        binding.btnGo.setVisibility(true)
    }

    private fun hideViews() {
        binding.tvText.setVisibility(false)
        binding.btnGo.setVisibility(false)
    }

    private fun showProgress() {
        binding.progress.setVisibility(true)
    }

    private fun hideProgress() {
        binding.progress.setVisibility(false)
    }

}