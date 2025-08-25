import kotlin.random.Random

class Atributos(nome: String, idade: Int) : Personagem(nome, idade) {
    var forca = 0
    var destreza = 0
    var constituicao = 0
    var inteligencia = 0
    var sabedoria = 0
    var carisma = 0

    //forma q será rolada os dados
    companion object {
        private fun rolarD6() = Random.nextInt(1,7)
        private fun rolar3d6() = rolarD6() + rolarD6() + rolarD6()
        private fun rolar4d6DropLowest(): Int {
            val dados = listOf(rolarD6(), rolarD6(), rolarD6(), rolarD6())
            return dados.sortedDescending().take(3).sum()
        }

        fun descreverAtributo(valor: Int, tipo: String) = when(tipo.lowercase()) {
            "forca","força" -> when(valor){ in 3..8->"Fraco"; in 9..12->"Mediano"; in 13..16->"Forte"; in 17..18->"Muito Forte"; else->"Indefinido"}
            "destreza" -> when(valor){ in 3..8->"Letárgico"; in 9..12->"Mediano"; in 13..16->"Ágil"; in 17..18->"Preciso"; else->"Indefinido"}
            "constituicao","constituição" -> when(valor){ in 3..8->"Frágil"; in 9..12->"Mediano"; in 13..16->"Resistente"; in 17..18->"Vigoroso"; else->"Indefinido"}
            "inteligencia","inteligência" -> when(valor){ in 3..8->"Inepto"; in 9..12->"Mediano"; in 13..16->"Inteligente"; in 17..18->"Gênio"; else->"Indefinido"}
            "sabedoria" -> when(valor){ in 3..8->"Tolo"; in 9..12->"Mediano"; in 13..16->"Intuitivo"; in 17..18->"Presciente"; else->"Indefinido"}
            "carisma" -> when(valor){ in 3..8->"Descortês"; in 9..12->"Mediano"; in 13..16->"Influente"; in 17..18->"Ídolo"; else->"Indefinido"}
            else -> "Desconhecido"
        }
    }

//dependendo do estilo escolhido, a rolagem de dados será diferente
    fun rolarAtributosPorSorte(estilo: Int) {
        val rolagem = when(estilo){
            1,2 -> ::rolar3d6
            3 -> ::rolar4d6DropLowest
            else -> ::rolar3d6
        }

        println("\nModo de Atributos: digite 'Sorte' para rolar cada atributo.")

        forca        = solicitarRolar("Força", rolagem)
        destreza     = solicitarRolar("Destreza", rolagem)
        constituicao = solicitarRolar("Constituição", rolagem)
        inteligencia = solicitarRolar("Inteligência", rolagem)
        sabedoria    = solicitarRolar("Sabedoria", rolagem)
        carisma      = solicitarRolar("Carisma", rolagem)
    }

    private fun solicitarRolar(nomeAtributo: String, rolar: () -> Int): Int {
        while (true) {
            print("Digite 'Sorte' para rolar $nomeAtributo: ")
            val input = readLine()?.trim()?.lowercase()
            if (input == "sorte") break
            println("Comando inválido, digite 'Sorte'.")
        }
        val valor = rolar()
        println("$nomeAtributo: $valor (${descreverAtributo(valor,nomeAtributo)})\n")
        return valor
    }


    override fun mostrarResumo() {
        super.mostrarResumo()
        println("Atributos:")
        println("Força: $forca (${descreverAtributo(forca,"forca")})")
        println("Destreza: $destreza (${descreverAtributo(destreza,"destreza")})")
        println("Constituição: $constituicao (${descreverAtributo(constituicao,"constituicao")})")
        println("Inteligência: $inteligencia (${descreverAtributo(inteligencia,"inteligencia")})")
        println("Sabedoria: $sabedoria (${descreverAtributo(sabedoria,"sabedoria")})")
        println("Carisma: $carisma (${descreverAtributo(carisma,"carisma")})")

        // Saída mística final
        println("\nQue a sorte esteja sempre ao seu favor, bravo ${raca.name}!")
        println("Que esta aventura, ${if (classe.name.isNotEmpty()) classe.name else ""},seja lendária!")
    }
}
