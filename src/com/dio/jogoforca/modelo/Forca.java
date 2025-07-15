package com.dio.jogoforca.modelo;

/**
 * Classe que representa a forca gráfica do jogo
 */
public class Forca {
    private int tentativasErradas;
    private final int maxTentativas;
    
    /**
     * Construtor da classe Forca
     * @param maxTentativas Número máximo de tentativas
     */
    public Forca(int maxTentativas) {
        this.maxTentativas = maxTentativas;
        this.tentativasErradas = 0;
    }
    
    /**
     * Incrementa o número de tentativas erradas
     */
    public void adicionarTentativaErrada() {
        if (tentativasErradas < maxTentativas) {
            tentativasErradas++;
        }
    }
    
    /**
     * Verifica se o jogador perdeu (forca completa)
     * @return true se o jogo acabou, false caso contrário
     */
    public boolean jogoAcabou() {
        return tentativasErradas >= maxTentativas;
    }
    
    /**
     * Obtém a representação gráfica da forca
     * @return String com o desenho da forca
     */
    public String getDesenhoForca() {
        StringBuilder desenho = new StringBuilder();
        
        desenho.append("  +---+\n");
        desenho.append("  |   |\n");
        
        // Cabeça
        if (tentativasErradas >= 1) {
            desenho.append("  |   O\n");
        } else {
            desenho.append("  |    \n");
        }
        
        // Corpo
        if (tentativasErradas >= 2) {
            if (tentativasErradas >= 3) {
                // Braço esquerdo
                desenho.append("  |  /");
            } else {
                desenho.append("  |   ");
            }
            
            desenho.append("|");
            
            if (tentativasErradas >= 4) {
                // Braço direito
                desenho.append("\\\n");
            } else {
                desenho.append(" \n");
            }
        } else {
            desenho.append("  |    \n");
        }
        
        // Pernas
        if (tentativasErradas >= 5) {
            desenho.append("  |  /");
            if (tentativasErradas >= 6) {
                desenho.append(" \\\n");
            } else {
                desenho.append("  \n");
            }
        } else {
            desenho.append("  |    \n");
        }
        
        desenho.append("  |\n");
        desenho.append("-----\n");
        
        return desenho.toString();
    }
    
    /**
     * Obtém informações sobre as tentativas
     * @return String com informações das tentativas
     */
    public String getInfoTentativas() {
        int restantes = maxTentativas - tentativasErradas;
        return String.format("Tentativas restantes: %d/%d", restantes, maxTentativas);
    }
    
    /**
     * Reinicia a forca
     */
    public void reiniciar() {
        this.tentativasErradas = 0;
    }
    
    // Getters
    public int getTentativasErradas() {
        return tentativasErradas;
    }
    
    public int getTentativasRestantes() {
        return maxTentativas - tentativasErradas;
    }
    
    public int getMaxTentativas() {
        return maxTentativas;
    }
}
