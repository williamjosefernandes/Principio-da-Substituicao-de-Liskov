package br.com.william.fernandes.lsp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.william.fernandes.lsp.CozinheiroViewModel
import br.com.william.fernandes.lsp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var cozinheiroViewModel: CozinheiroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cozinheiroViewModel = ViewModelProvider(this)[CozinheiroViewModel::class.java]

        cozinheiroViewModel.resultadoCozinhar.observe(
            this,
            Observer { resultado ->
                binding.resultadoTextView.text = resultado
            },
        )

        // Define o comportamento do botão de cozinhar
        binding.cozinharButton.setOnClickListener {
            cozinheiroViewModel.comecarCozinhar()
        }
    }
}
