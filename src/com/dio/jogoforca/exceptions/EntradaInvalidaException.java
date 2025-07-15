package com.dio.jogoforca.exceptions;

/**
 * Exceção lançada quando uma entrada inválida é fornecida
 */
public class EntradaInvalidaException extends Exception {
    
    /**
     * Construtor com mensagem padrão
     */
    public EntradaInvalidaException() {
        super("Entrada inválida! Digite apenas uma letra.");
    }
    
    /**
     * Construtor com mensagem personalizada
     * @param mensagem Mensagem da exceção
     */
    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }
    
    /**
     * Construtor com mensagem e causa
     * @param mensagem Mensagem da exceção
     * @param causa Causa da exceção
     */
    public EntradaInvalidaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
