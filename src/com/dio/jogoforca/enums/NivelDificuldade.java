package com.dio.jogoforca.enums;

/**
 * Enum que representa os níveis de dificuldade do jogo
 */
public enum NivelDificuldade {
    /**
     * Nível fácil - 8 tentativas
     */
    FACIL(8, "Facil"),
    
    /**
     * Nível médio - 6 tentativas
     */
    MEDIO(6, "Medio"),
    
    /**
     * Nível difícil - 4 tentativas
     */
    DIFICIL(4, "Dificil");
    
    private final int maxTentativas;
    private final String descricao;
    
    /**
     * Construtor do enum
     * @param maxTentativas Número máximo de tentativas
     * @param descricao Descrição do nível
     */
    NivelDificuldade(int maxTentativas, String descricao) {
        this.maxTentativas = maxTentativas;
        this.descricao = descricao;
    }
    
    /**
     * Obtém o número máximo de tentativas
     * @return Número máximo de tentativas
     */
    public int getMaxTentativas() {
        return maxTentativas;
    }
    
    /**
     * Obtém a descrição do nível
     * @return Descrição do nível
     */
    public String getDescricao() {
        return descricao;
    }
}
