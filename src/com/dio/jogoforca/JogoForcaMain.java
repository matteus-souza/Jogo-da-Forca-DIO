package com.dio.jogoforca;

import com.dio.jogoforca.enums.NivelDificuldade;
import com.dio.jogoforca.exceptions.EntradaInvalidaException;
import com.dio.jogoforca.exceptions.LetraJaTentadaException;
import com.dio.jogoforca.util.EntradaUtil;

/**
 * Classe principal que contém o menu e controla o fluxo do jogo
 */
public class JogoForcaMain {
    private static Jogo jogo = new Jogo();
    
    /**
     * Método principal
     * @param args Argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("     BEM-VINDO AO JOGO DA FORCA!");
        System.out.println("   Desenvolvido para o Desafio DIO");
        System.out.println("========================================");
        System.out.println();
        
        boolean continuar = true;
        
        while (continuar) {
            try {
                exibirMenuPrincipal();
                int opcao = EntradaUtil.lerOpcaoMenu();
                
                switch (opcao) {
                    case 1:
                        iniciarNovoJogo();
                        break;
                    case 2:
                        configurarDificuldade();
                        break;
                    case 3:
                        exibirEstatisticas();
                        break;
                    case 4:
                        exibirInstrucoes();
                        break;
                    case 5:
                        exibirCreditos();
                        break;
                    case 0:
                        continuar = false;
                        System.out.println("Obrigado por jogar! Ate a proxima!");
                        break;
                    default:
                        System.out.println("Opcao invalida! Tente novamente.");
                        EntradaUtil.pausar();
                }
                
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                EntradaUtil.pausar();
            }
        }
    }
    
    /**
     * Exibe o menu principal
     */
    private static void exibirMenuPrincipal() {
        EntradaUtil.limparTela();
        System.out.println("==========================================");
        System.out.println("              MENU PRINCIPAL              ");
        System.out.println("==========================================");
        System.out.println("  1. " + (char)127918 + " Iniciar Novo Jogo             ");
        System.out.println("  2. " + (char)9881 + "  Configurar Dificuldade       ");
        System.out.println("  3. " + (char)128202 + " Ver Estatisticas             ");
        System.out.println("  4. " + (char)128214 + " Instrucoes                   ");
        System.out.println("  5. " + (char)8505 + "  Creditos                     ");
        System.out.println("  0. " + (char)128682 + " Sair                         ");
        System.out.println("==========================================");
        System.out.println();
        System.out.println("Nivel atual: " + jogo.getNivelDificuldade().getDescricao());
        System.out.println("Pontuacao: " + jogo.getPontuacao());
        System.out.println();
    }
    
    /**
     * Inicia um novo jogo
     */
    private static void iniciarNovoJogo() {
        EntradaUtil.limparTela();
        System.out.println("[*] Iniciando novo jogo...\n");
        
        jogo.iniciarJogo();
        
        // Loop principal do jogo
        while (!jogo.jogoTerminou()) {
            jogo.exibirEstadoJogo();
            
            try {
                char letra = EntradaUtil.lerLetra();
                jogo.tentarLetra(letra);
                
            } catch (EntradaInvalidaException e) {
                System.out.println("[X] " + e.getMessage());
            } catch (LetraJaTentadaException e) {
                System.out.println("[!] " + e.getMessage());
            }
            
            System.out.println();
            
            // Pequena pausa para o jogador ver o resultado
            if (!jogo.jogoTerminou()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        
        // Exibe resultado final
        jogo.exibirResultadoFinal();
        
        // Pergunta se quer jogar novamente
        if (EntradaUtil.perguntarSimNao("Deseja jogar novamente?")) {
            iniciarNovoJogo();
        }
    }
    
    /**
     * Configura a dificuldade do jogo
     */
    private static void configurarDificuldade() {
        EntradaUtil.limparTela();
        System.out.println("[CONFIG] CONFIGURAR DIFICULDADE\n");
        
        System.out.println("Escolha o nivel de dificuldade:");
        System.out.println("1. [FACIL]   (" + NivelDificuldade.FACIL.getMaxTentativas() + " tentativas)");
        System.out.println("2. [MEDIO]   (" + NivelDificuldade.MEDIO.getMaxTentativas() + " tentativas)");
        System.out.println("3. [DIFICIL] (" + NivelDificuldade.DIFICIL.getMaxTentativas() + " tentativas)");
        System.out.println("0. [VOLTAR]");
        System.out.println();
        
        int opcao = EntradaUtil.lerOpcaoMenu();
        
        switch (opcao) {
            case 1:
                jogo.definirNivelDificuldade(NivelDificuldade.FACIL);
                System.out.println("[OK] Dificuldade alterada para: Facil");
                break;
            case 2:
                jogo.definirNivelDificuldade(NivelDificuldade.MEDIO);
                System.out.println("[OK] Dificuldade alterada para: Medio");
                break;
            case 3:
                jogo.definirNivelDificuldade(NivelDificuldade.DIFICIL);
                System.out.println("[OK] Dificuldade alterada para: Dificil");
                break;
            case 0:
                return;
            default:
                System.out.println("[ERRO] Opcao invalida!");
        }
        
        EntradaUtil.pausar();
    }
    
    /**
     * Exibe estatisticas do jogador
     */
    private static void exibirEstatisticas() {
        EntradaUtil.limparTela();
        System.out.println("[STATS] SUAS ESTATISTICAS\n");
        
        System.out.println("[PONTOS] Pontuacao Total: " + jogo.getPontuacao());
        System.out.println("[WIN] Jogos Vencidos: " + jogo.getJogosVencidos());
        System.out.println("[LOSE] Jogos Perdidos: " + jogo.getJogosPerdidos());
        
        int totalJogos = jogo.getJogosVencidos() + jogo.getJogosPerdidos();
        if (totalJogos > 0) {
            double percentualVitorias = (double) jogo.getJogosVencidos() / totalJogos * 100;
            System.out.printf("[RATE] Taxa de Vitoria: %.1f%%\n", percentualVitorias);
        } else {
            System.out.println("[INFO] Nenhum jogo jogado ainda!");
        }
        
        System.out.println("[CONFIG] Dificuldade Atual: " + jogo.getNivelDificuldade().getDescricao());
        
        System.out.println();
        EntradaUtil.pausar();
    }
    
    /**
     * Exibe as instrucoes do jogo
     */
    private static void exibirInstrucoes() {
        EntradaUtil.limparTela();
        System.out.println("[HELP] COMO JOGAR\n");
        
        System.out.println("OBJETIVO:");
        System.out.println("   Descobrir a palavra secreta antes que o boneco seja enforcado!\n");
        
        System.out.println("COMO JOGAR:");
        System.out.println("   1. Uma palavra secreta sera escolhida aleatoriamente");
        System.out.println("   2. Voce vera a categoria e uma dica da palavra");
        System.out.println("   3. Digite uma letra por vez para tentar descobrir a palavra");
        System.out.println("   4. Cada letra errada adiciona uma parte ao boneco na forca");
        System.out.println("   5. Ganhe descobrindo toda a palavra antes do boneco ser completado");
        System.out.println("   6. Perca se o boneco for completamente desenhado\n");
        
        System.out.println("PONTUACAO:");
        System.out.println("   • Pontuacao base: 100 pontos por vitoria");
        System.out.println("   • Bonus por tentativas restantes: 10 pontos cada");
        System.out.println("   • Bonus por tamanho da palavra: 5 pontos por letra");
        System.out.println("   • Bonus por dificuldade: Facil +10, Medio +20, Dificil +50\n");
        
        System.out.println("NIVEIS DE DIFICULDADE:");
        System.out.println("   Facil:   8 tentativas");
        System.out.println("   Medio:   6 tentativas");
        System.out.println("   Dificil: 4 tentativas\n");
        
        System.out.println("DICAS:");
        System.out.println("   • Comece com vogais (A, E, I, O, U)");
        System.out.println("   • Use consoantes comuns (R, S, T, N, L)");
        System.out.println("   • Preste atencao na categoria e dica");
        System.out.println("   • Pense no tamanho da palavra\n");
        
        EntradaUtil.pausar();
    }
    
    /**
     * Exibe os creditos do jogo
     */
    private static void exibirCreditos() {
        EntradaUtil.limparTela();
        System.out.println("[INFO] CREDITOS\n");
        
        System.out.println("JOGO DA FORCA");
        System.out.println("   Versao: 1.0");
        System.out.println("   Desenvolvido em: Java");
        System.out.println();
        
        System.out.println("DESENVOLVIMENTO:");
        System.out.println("   Projeto criado para o Desafio DIO");
        System.out.println("   Foco em Programacao Orientada a Objetos");
        System.out.println();
        
        System.out.println("CONCEITOS APLICADOS:");
        System.out.println("   [OK] Classes e Objetos");
        System.out.println("   [OK] Encapsulamento");
        System.out.println("   [OK] Heranca (Exception)");
        System.out.println("   [OK] Enumeracoes");
        System.out.println("   [OK] Tratamento de Excecoes");
        System.out.println("   [OK] Manipulacao de Strings");
        System.out.println("   [OK] Estruturas de Dados (Lists)");
        System.out.println("   [OK] Separacao de Responsabilidades");
        System.out.println();
        
        System.out.println("TECNOLOGIAS:");
        System.out.println("   • Java SE");
        System.out.println("   • VS Code");
        System.out.println("   • Git/GitHub");
        System.out.println();
        
        System.out.println("OBJETIVO EDUCACIONAL:");
        System.out.println("   Demonstrar conhecimentos em POO atraves de");
        System.out.println("   um projeto pratico e interativo.");
        System.out.println();
        
        System.out.println("Obrigado por jogar!");
        System.out.println();
        
        EntradaUtil.pausar();
    }
}
