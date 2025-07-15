package com.dio.jogoforca.enums;

/**
 * Enum que representa os possíveis status do jogo da forca
 */
public enum StatusJogo {
    /**
     * Jogo em andamento
     */
    EM_ANDAMENTO("Jogo em andamento"),
    
    /**
     * Jogador venceu o jogo
     */
    VITORIA("Você venceu! Parabéns!"),
    
    /**
     * Jogador perdeu o jogo
     */
    DERROTA("Você perdeu! Tente novamente!"),
    
    /**
     * Jogo pausado
     */
    PAUSADO("Jogo pausado");
    
    private final String mensagem;
    
    /**
     * Construtor do enum
     * @param mensagem Mensagem associada ao status
     */
    StatusJogo(String mensagem) {
        this.mensagem = mensagem;
    }
    
    /**
     * Obtém a mensagem do status
     * @return Mensagem do status
     */
    public String getMensagem() {
        return mensagem;
    }
}
