package com.dio.jogoforca.exceptions;

/**
 * Exceção lançada quando uma letra já foi tentada anteriormente
 */
public class LetraJaTentadaException extends Exception {
    
    /**
     * Construtor com mensagem padrão
     */
    public LetraJaTentadaException() {
        super("Esta letra já foi tentada anteriormente!");
    }
    
    /**
     * Construtor com mensagem personalizada
     * @param mensagem Mensagem da exceção
     */
    public LetraJaTentadaException(String mensagem) {
        super(mensagem);
    }
    
    /**
     * Construtor com mensagem e causa
     * @param mensagem Mensagem da exceção
     * @param causa Causa da exceção
     */
    public LetraJaTentadaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
