package br.com.william.fernandes.lsp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.william.fernandes.lsp.domain.model.ChefeDeCozinha

class CozinheiroViewModel : ViewModel() {

    // Define o LiveData que será observado na Fragment
    private val _resultadoCozinhar = MutableLiveData<String>()
    val resultadoCozinhar: LiveData<String>
        get() = _resultadoCozinhar

    // Objeto ChefeDeCozinha que será usado para a ação de cozinhar
    private val cozinheiro = ChefeDeCozinha()

    fun comecarCozinhar() {
        // Realiza a ação de cozinhar
        cozinheiro.cozinhar()

        // Atualiza o LiveData com o resultado
        _resultadoCozinhar.value = "Prato cozido com sucesso!"
    }
}
