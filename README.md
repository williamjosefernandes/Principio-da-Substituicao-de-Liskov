# SOLID: Princípio da Substituição de Liskov

O Princípio da Substituição de Liskov (LSP) é uma diretriz fundamental da programação orientada a objetos (POO) que estabelece que as subclasses devem ser substituíveis por suas classes base. Para ilustrar como esse princípio pode ser aplicado em um contexto de desenvolvimento Android e arquitetura MVVM, vou criar um exemplo hipotético com um Chefe de Cozinha.

Suponha que temos uma classe base chamada Cozinheiro e uma subclasse chamada ChefeDeCozinha. A classe Cozinheiro possui um método chamado cozinhar, que realiza uma ação genérica de cozimento. A classe ChefeDeCozinha herda dessa classe base e implementa seu próprio método cozinhar, que realiza uma ação mais específica de chefia de cozinha.

Para seguir o princípio LSP, a subclasse ChefeDeCozinha deve ser substituível pela classe base Cozinheiro, ou seja, ela deve ser capaz de executar todas as ações que a classe base é capaz de executar e não deve alterar seu comportamento de forma inesperada. Para garantir isso, podemos implementar a interface CozinheiroInterface que define um contrato comum para todas as classes que realizam a ação de cozinhar.

Aqui está o código em Kotlin que implementa essa estrutura:



Cozinheiro.kt

open class Cozinheiro : CozinheiroInterface {
    override fun cozinhar() {
        // Lógica genérica de cozimento
        println("Cozinhando algo gostoso...")
    }
}
CozinheiroInterface.kt

interface CozinheiroInterface {
    fun cozinhar()
}
ChefeDeCozinha.kt

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
CozinheiroViewModel.kt

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
MainActivity.kt

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
Nesse exemplo, a classe Cozinheiro implementa a interface CozinheiroInterface que define o método cozinhar. A classe ChefeDeCozinha herda da classe base Cozinheiro e também implementa a interface CozinheiroInterface. Ela substitui o método cozinhar da classe base com sua própria implementação específica de chefia de cozinha, mas ainda é capaz de executar a lógica genérica de cozimento da classe base. A classe CozinheiroViewModel utiliza um objeto da classe ChefeDeCozinha para realizar a ação de cozinhar.

Com essa estrutura, podemos garantir que a subclasse ChefeDeCozinha é substituível pela classe base Cozinheiro, pois ela implementa todos os métodos definidos na interface CozinheiroInterface e não altera o comportamento do método cozinhar de forma inesperada. Isso significa que podemos usar um objeto da classe ChefeDeCozinha onde quer que um objeto da classe Cozinheiro seja esperado, sem medo de quebrar o comportamento esperado da aplicação.

Além disso, ao utilizar a arquitetura MVVM, separamos a lógica de negócio do código da interface do usuário, o que nos permite testar e modificar a lógica de forma mais fácil e independente da interface do usuário. No exemplo acima, a classe CozinheiroViewModel é responsável por manipular o objeto ChefeDeCozinha e expor um método cozinhar para a interface do usuário. Se quisermos modificar a lógica de negócio, podemos simplesmente modificar a implementação do método cozinhar na classe ChefeDeCozinha ou mesmo substituir o objeto ChefeDeCozinha por uma outra classe que implemente a interface CozinheiroInterface.

Em resumo, ao aplicar o princípio da substituição de Liskov (LSP) em Kotlin Android e arquitetura MVVM, podemos criar um código mais modular, extensível e testável, que garante que as sub-classes são substituíveis pelas classes base, sem alterar o comportamento esperado do código.

<a href="https://www.buymeacoffee.com/williamjf"><img src="https://img.buymeacoffee.com/button-api/?text=Compre-me um café&emoji=&slug=williamjf&button_colour=FFDD00&font_colour=000000&font_family=Cookie&outline_colour=000000&coffee_colour=ffffff" /></a>
