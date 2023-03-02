package br.com.william.fernandes.lsp.domain.model

class ChefeDeCozinha : Cozinheiro() {
    fun criarNovoPrato() {
        // Lógica específica de chefia de cozinha
        println("Criando um novo prato delicioso...")
    }

    override fun cozinhar() {
        // Lógica específica de chefia de cozinha para cozinhar
        println("Cozinhando algo ainda mais delicioso...")
    }
}
