package com.dio.jogoforca.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma palavra no jogo da forca
 */
public class Palavra {
    private String palavraSecreta;
    private List<Character> letrasReveladas;
    private String categoria;
    private String dica;
    
    /**
     * Construtor da classe Palavra
     * @param palavraSecreta A palavra secreta do jogo
     * @param categoria Categoria da palavra
     * @param dica Dica sobre a palavra
     */
    public Palavra(String palavraSecreta, String categoria, String dica) {
        this.palavraSecreta = palavraSecreta.toUpperCase();
        this.categoria = categoria;
        this.dica = dica;
        this.letrasReveladas = new ArrayList<>();
    }
    
    /**
     * Construtor da classe Palavra (sem categoria e dica)
     * @param palavraSecreta A palavra secreta do jogo
     */
    public Palavra(String palavraSecreta) {
        this(palavraSecreta, "Geral", "Sem dica disponivel");
    }
    
    /**
     * Verifica se a letra está presente na palavra
     * @param letra Letra a ser verificada
     * @return true se a letra estiver presente, false caso contrario
     */
    public boolean contemLetra(char letra) {
        return palavraSecreta.contains(String.valueOf(Character.toUpperCase(letra)));
    }
    
    /**
     * Revela uma letra na palavra
     * @param letra Letra a ser revelada
     */
    public void revelarLetra(char letra) {
        char letraUpper = Character.toUpperCase(letra);
        if (!letrasReveladas.contains(letraUpper)) {
            letrasReveladas.add(letraUpper);
        }
    }
    
    /**
     * Obtém a representação atual da palavra com letras reveladas
     * @return String com a palavra parcialmente revelada
     */
    public String getPalavraRevelada() {
        StringBuilder resultado = new StringBuilder();
        
        for (char c : palavraSecreta.toCharArray()) {
            if (letrasReveladas.contains(c) || c == ' ') {
                resultado.append(c);
            } else {
                resultado.append('_');
            }
            resultado.append(' ');
        }
        
        return resultado.toString().trim();
    }
    
    /**
     * Verifica se a palavra foi completamente revelada
     * @return true se todas as letras foram reveladas, false caso contrario
     */
    public boolean estahCompleta() {
        for (char c : palavraSecreta.toCharArray()) {
            if (c != ' ' && !letrasReveladas.contains(c)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Obtém o tamanho da palavra
     * @return Tamanho da palavra
     */
    public int getTamanho() {
        return palavraSecreta.length();
    }
    
    // Getters e Setters
    public String getPalavraSecreta() {
        return palavraSecreta;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getDica() {
        return dica;
    }
    
    public void setDica(String dica) {
        this.dica = dica;
    }
    
    public List<Character> getLetrasReveladas() {
        return new ArrayList<>(letrasReveladas);
    }
}
