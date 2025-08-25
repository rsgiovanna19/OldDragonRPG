fun main() {
    println("Bem vindo ao Old Dragon! Vamos se aventurar?")

    print("Digite o nome do personagem: ")
    val nome = readLine() ?: ""

    print("Digite a idade do personagem: ")
    val idade = readLine()?.toIntOrNull() ?: 0

    val personagem = Atributos(nome, idade)
    personagem.interacaoIdade()

    println(
        """
        Escolha o estilo da aventura:
        1 - Clássico
        2 - Aventureiro
        3 - Heróico
        """.trimIndent()
    )
    val estilo = when(readLine()?.trim()?.lowercase()) {
        "1","classico","clássico" -> 1
        "2","aventureiro" -> 2
        "3","heroico","heróico" -> 3
        else -> { println("Valor inválido. Usando Clássico."); 1 }
    }

    println("\nEscolha a raça do personagem:")
    println("1 - Humano\n2 - Elfo\n3 - Anão\n4 - Halfling")
    personagem.raca = when(readLine()?.trim()?.lowercase()) {
        "1","humano" -> Raca.HUMANO
        "2","elfo" -> Raca.ELFO
        "3","anao","anão" -> Raca.ANAO
        "4","halfling" -> Raca.HALFLING
        else -> { println("Raça inválida. Usando Humano."); Raca.HUMANO }
    }

    println("\nEste é o Old Dragon, ${personagem.nome}\nVamos decidir os seus atributos!")
    personagem.rolarAtributosPorSorte(estilo)

    println("\nEscolha a classe do personagem:")
    println("1 - Guerreiro\n2 - Ladrão\n3 - Mago")
    personagem.classe = when(readLine()?.trim()?.lowercase()) {
        "1","guerreiro" -> Classe.GUERREIRO
        "2","ladrao","ladrão" -> Classe.LADRAO
        "3","mago" -> Classe.MAGO
        else -> { println("Classe inválida. Usando Guerreiro."); Classe.GUERREIRO }
    }

    personagem.mostrarResumo()
}
