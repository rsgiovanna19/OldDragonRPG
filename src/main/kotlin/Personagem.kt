open class Personagem(var nome: String, var idade: Int) {
    lateinit var raca: Raca
    lateinit var classe: Classe

    fun interacaoIdade() {
        when {
            idade > 100 -> println("\nTalvez você seja mesmo deste mundo... Seja bem-vindo novamente!")
            idade in 81..100 -> println("\nVejo que você, por enquanto, é um ser humano comum...")
            else -> println("\nVejo que você, por enquanto, é um ser humano jovem comum...")
        }
    }

    //resumo do personagem
    open fun mostrarResumo() {
        println("\n=== Resumo do Personagem ===")
        println("Nome: $nome")
        println("Idade: $idade anos")
        println("Raça: ${raca.name}")
        println("Classe: ${classe.name} - ${classe.descricao}")
        println("Movimento: ${raca.movimento}")
        println("Infravisão: ${raca.infraviso}")
        println("Alinhamento: ${raca.alinhamento}")
        println("Habilidades: ${raca.habilidades.joinToString(", ")}")
    }
}