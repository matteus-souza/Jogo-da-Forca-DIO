package com.dio.jogoforca.util;

import com.dio.jogoforca.exceptions.EntradaInvalidaException;
import java.util.Scanner;

/**
 * Classe utilitária para entrada de dados do usuário
 */
public class EntradaUtil {
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * Lê uma letra do usuário
     * @return Letra digitada pelo usuário
     * @throws EntradaInvalidaException Se a entrada for inválida
     */
    public static char lerLetra() throws EntradaInvalidaException {
        System.out.print("Digite uma letra: ");
        String entrada = scanner.nextLine().trim();
        
        if (entrada.isEmpty()) {
            throw new EntradaInvalidaException("Você deve digitar alguma coisa!");
        }
        
        if (entrada.length() != 1) {
            throw new EntradaInvalidaException("Digite apenas uma letra!");
        }
        
        char letra = entrada.charAt(0);
        
        if (!Character.isLetter(letra)) {
            throw new EntradaInvalidaException("Digite apenas letras, nao numeros ou simbolos!");
        }
        
        return Character.toUpperCase(letra);
    }
    
    /**
     * Lê uma opção do menu
     * @return Opção escolhida pelo usuário
     */
    public static int lerOpcaoMenu() {
        System.out.print("Escolha uma opção: ");
        try {
            String entrada = scanner.nextLine().trim();
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            return -1; // Indica entrada inválida
        }
    }
    
    /**
     * Lê uma string do usuário
     * @param mensagem Mensagem a ser exibida
     * @return String digitada pelo usuário
     */
    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }
    
    /**
     * Pergunta se o usuário quer continuar (S/N)
     * @param mensagem Mensagem da pergunta
     * @return true se sim, false se não
     */
    public static boolean perguntarSimNao(String mensagem) {
        while (true) {
            System.out.print(mensagem + " (S/N): ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            
            if (resposta.equals("S") || resposta.equals("SIM")) {
                return true;
            } else if (resposta.equals("N") || resposta.equals("NAO") || resposta.equals("NÃO")) {
                return false;
            } else {
                System.out.println("Resposta invalida! Digite S para sim ou N para nao.");
            }
        }
    }
    
    /**
     * Pausa a execução até o usuário pressionar Enter
     */
    public static void pausar() {
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Limpa a tela do console (simulação)
     */
    public static void limparTela() {
        // Em ambiente console real, pode usar:
        // System.out.print("\033[2J\033[H");
        
        // Para demonstração, apenas adiciona linhas em branco
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("========================================");
        System.out.println("           JOGO DA FORCA - DIO");
        System.out.println("========================================");
        System.out.println();
    }
}
