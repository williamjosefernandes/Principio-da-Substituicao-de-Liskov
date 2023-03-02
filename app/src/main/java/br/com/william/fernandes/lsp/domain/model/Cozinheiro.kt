package br.com.william.fernandes.lsp.domain.model

open class Cozinheiro : CozinheiroInterface {
    override fun cozinhar() {
        // Lógica genérica de cozimento
        println("Cozinhando algo gostoso...")
    }
}
