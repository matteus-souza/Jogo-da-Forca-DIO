package com.dio.jogoforca.util;

import com.dio.jogoforca.modelo.Palavra;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe utilitária para gerenciar banco de palavras
 */
public class BancoPalavras {
    private static final List<Palavra> palavras = new ArrayList<>();
    private static final Random random = new Random();
    
    // Bloco estático para inicializar as palavras
    static {
        inicializarPalavras();
    }
    
    /**
     * Inicializa o banco de palavras com palavras pré-definidas
     */
    private static void inicializarPalavras() {
        // Animais
        palavras.add(new Palavra("ELEFANTE", "Animais", "Maior mamífero terrestre"));
        palavras.add(new Palavra("GIRAFA", "Animais", "Animal mais alto do mundo"));
        palavras.add(new Palavra("TIGRE", "Animais", "Felino listrado"));
        palavras.add(new Palavra("BALEIA", "Animais", "Maior mamífero do oceano"));
        palavras.add(new Palavra("PINGUIM", "Animais", "Ave que não voa mas nada muito bem"));
        
        // Frutas
        palavras.add(new Palavra("ABACAXI", "Frutas", "Fruta tropical espinhosa"));
        palavras.add(new Palavra("MORANGO", "Frutas", "Fruta vermelha pequena"));
        palavras.add(new Palavra("MELANCIA", "Frutas", "Fruta grande e verde por fora"));
        palavras.add(new Palavra("MANGA", "Frutas", "Fruta tropical amarela"));
        palavras.add(new Palavra("PESSEGO", "Frutas", "Fruta aveludada e doce"));
        
        // Países
        palavras.add(new Palavra("BRASIL", "Países", "Maior país da América do Sul"));
        palavras.add(new Palavra("JAPAO", "Países", "País do sol nascente"));
        palavras.add(new Palavra("FRANCA", "Países", "País da torre Eiffel"));
        palavras.add(new Palavra("AUSTRALIA", "Países", "País-continente"));
        palavras.add(new Palavra("EGIPTO", "Países", "País das pirâmides"));
        
        // Profissões
        palavras.add(new Palavra("MEDICO", "Profissões", "Cuida da saúde das pessoas"));
        palavras.add(new Palavra("PROFESSOR", "Profissões", "Ensina conhecimento"));
        palavras.add(new Palavra("ENGENHEIRO", "Profissões", "Projeta e constrói"));
        palavras.add(new Palavra("BOMBEIRO", "Profissões", "Combate incêndios"));
        palavras.add(new Palavra("POLICIAL", "Profissões", "Mantém a ordem pública"));
        
        // Objetos
        palavras.add(new Palavra("COMPUTADOR", "Objetos", "Máquina para processar dados"));
        palavras.add(new Palavra("TELEVISAO", "Objetos", "Aparelho para ver programas"));
        palavras.add(new Palavra("GELADEIRA", "Objetos", "Conserva alimentos gelados"));
        palavras.add(new Palavra("BICICLETA", "Objetos", "Meio de transporte com duas rodas"));
        palavras.add(new Palavra("LIVRO", "Objetos", "Objeto para leitura"));
    }
    
    /**
     * Obtém uma palavra aleatória do banco
     * @return Palavra aleatória
     */
    public static Palavra obterPalavraAleatoria() {
        if (palavras.isEmpty()) {
            throw new IllegalStateException("Banco de palavras está vazio!");
        }
        
        int indice = random.nextInt(palavras.size());
        return palavras.get(indice);
    }
    
    /**
     * Obtém uma palavra aleatória de uma categoria específica
     * @param categoria Categoria desejada
     * @return Palavra aleatória da categoria ou null se não encontrar
     */
    public static Palavra obterPalavraPorCategoria(String categoria) {
        List<Palavra> palavrasDaCategoria = new ArrayList<>();
        
        for (Palavra palavra : palavras) {
            if (palavra.getCategoria().equalsIgnoreCase(categoria)) {
                palavrasDaCategoria.add(palavra);
            }
        }
        
        if (palavrasDaCategoria.isEmpty()) {
            return null;
        }
        
        int indice = random.nextInt(palavrasDaCategoria.size());
        return palavrasDaCategoria.get(indice);
    }
    
    /**
     * Adiciona uma nova palavra ao banco
     * @param palavra Palavra a ser adicionada
     */
    public static void adicionarPalavra(Palavra palavra) {
        if (palavra != null && !palavra.getPalavraSecreta().trim().isEmpty()) {
            palavras.add(palavra);
        }
    }
    
    /**
     * Obtém todas as categorias disponíveis
     * @return Lista de categorias
     */
    public static List<String> obterCategorias() {
        List<String> categorias = new ArrayList<>();
        
        for (Palavra palavra : palavras) {
            String categoria = palavra.getCategoria();
            if (!categorias.contains(categoria)) {
                categorias.add(categoria);
            }
        }
        
        return categorias;
    }
    
    /**
     * Obtém o número total de palavras no banco
     * @return Número de palavras
     */
    public static int getTotalPalavras() {
        return palavras.size();
    }
}
