package com.dio.jogoforca;

import com.dio.jogoforca.enums.StatusJogo;
import com.dio.jogoforca.enums.NivelDificuldade;
import com.dio.jogoforca.exceptions.LetraJaTentadaException;
import com.dio.jogoforca.modelo.Forca;
import com.dio.jogoforca.modelo.Palavra;
import com.dio.jogoforca.util.BancoPalavras;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal que controla a lógica do jogo da forca
 */
public class Jogo {
    private Palavra palavraAtual;
    private Forca forca;
    private StatusJogo status;
    private List<Character> letrasJaTentadas;
    private NivelDificuldade nivelDificuldade;
    private int pontuacao;
    private int jogosVencidos;
    private int jogosPerdidos;
    
    /**
     * Construtor da classe Jogo
     */
    public Jogo() {
        this.status = StatusJogo.EM_ANDAMENTO;
        this.letrasJaTentadas = new ArrayList<>();
        this.nivelDificuldade = NivelDificuldade.MEDIO; // Padrão
        this.pontuacao = 0;
        this.jogosVencidos = 0;
        this.jogosPerdidos = 0;
    }
    
    /**
     * Inicia um novo jogo
     */
    public void iniciarJogo() {
        reiniciarJogo();
        this.palavraAtual = BancoPalavras.obterPalavraAleatoria();
        this.forca = new Forca(nivelDificuldade.getMaxTentativas());
        this.status = StatusJogo.EM_ANDAMENTO;
        
        System.out.println("Novo jogo iniciado!");
        System.out.println("Nivel de dificuldade: " + nivelDificuldade.getDescricao());
        System.out.println("Categoria: " + palavraAtual.getCategoria());
        System.out.println("Dica: " + palavraAtual.getDica());
        System.out.println();
    }
    
    /**
     * Processa uma tentativa de letra
     * @param letra Letra tentada pelo jogador
     * @throws LetraJaTentadaException Se a letra já foi tentada
     */
    public void tentarLetra(char letra) throws LetraJaTentadaException {
        char letraUpper = Character.toUpperCase(letra);
        
        // Verifica se a letra já foi tentada
        if (letrasJaTentadas.contains(letraUpper)) {
            throw new LetraJaTentadaException("A letra '" + letraUpper + "' ja foi tentada!");
        }
        
        // Adiciona a letra à lista de tentativas
        letrasJaTentadas.add(letraUpper);
        
        // Verifica se a letra está na palavra
        if (palavraAtual.contemLetra(letraUpper)) {
            palavraAtual.revelarLetra(letraUpper);
            System.out.println("[OK] Muito bem! A letra '" + letraUpper + "' esta na palavra!");
            
            // Verifica se o jogador venceu
            if (palavraAtual.estahCompleta()) {
                status = StatusJogo.VITORIA;
                jogosVencidos++;
                calcularPontuacao(true);
            }
        } else {
            forca.adicionarTentativaErrada();
            System.out.println("[X] Que pena! A letra '" + letraUpper + "' nao esta na palavra.");
            
            // Verifica se o jogador perdeu
            if (forca.jogoAcabou()) {
                status = StatusJogo.DERROTA;
                jogosPerdidos++;
                calcularPontuacao(false);
            }
        }
    }
    
    /**
     * Calcula a pontuacao baseada no desempenho
     * @param venceu Se o jogador venceu ou perdeu
     */
    private void calcularPontuacao(boolean venceu) {
        if (venceu) {
            int pontos = 100; // Pontuacao base
            pontos += (forca.getTentativasRestantes() * 10); // Bonus por tentativas restantes
            pontos += (palavraAtual.getTamanho() * 5); // Bonus por tamanho da palavra
            
            // Bonus por dificuldade
            switch (nivelDificuldade) {
                case FACIL:
                    pontos += 10;
                    break;
                case MEDIO:
                    pontos += 20;
                    break;
                case DIFICIL:
                    pontos += 50;
                    break;
            }
            
            this.pontuacao += pontos;
            System.out.println("Voce ganhou " + pontos + " pontos!");
        }
    }
    
    /**
     * Exibe o estado atual do jogo
     */
    public void exibirEstadoJogo() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(forca.getDesenhoForca());
        System.out.println("Palavra: " + palavraAtual.getPalavraRevelada());
        System.out.println("Categoria: " + palavraAtual.getCategoria());
        System.out.println("Dica: " + palavraAtual.getDica());
        System.out.println(forca.getInfoTentativas());
        
        if (!letrasJaTentadas.isEmpty()) {
            System.out.println("Letras ja tentadas: " + letrasJaTentadas);
        }
        
        System.out.println("Pontuacao: " + pontuacao);
        System.out.println("=".repeat(50) + "\n");
    }
    
    /**
     * Exibe o resultado final do jogo
     */
    public void exibirResultadoFinal() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           " + status.getMensagem());
        System.out.println("=".repeat(50));
        
        if (status == StatusJogo.VITORIA) {
            System.out.println("[WIN] Parabens! Voce descobriu a palavra!");
        } else {
            System.out.println("[LOSE] A palavra era: " + palavraAtual.getPalavraSecreta());
        }
        
        System.out.println("\nEstatisticas da partida:");
        System.out.println("- Palavra: " + palavraAtual.getPalavraSecreta());
        System.out.println("- Categoria: " + palavraAtual.getCategoria());
        System.out.println("- Tentativas usadas: " + forca.getTentativasErradas() + "/" + forca.getMaxTentativas());
        System.out.println("- Letras tentadas: " + letrasJaTentadas.size());
        System.out.println("- Pontuacao desta partida: " + (status == StatusJogo.VITORIA ? "+" : "0"));
        
        System.out.println("\nEstatisticas gerais:");
        System.out.println("- Pontuacao total: " + pontuacao);
        System.out.println("- Jogos vencidos: " + jogosVencidos);
        System.out.println("- Jogos perdidos: " + jogosPerdidos);
        
        if (jogosVencidos + jogosPerdidos > 0) {
            double percentualVitorias = (double) jogosVencidos / (jogosVencidos + jogosPerdidos) * 100;
            System.out.printf("- Taxa de vitoria: %.1f%%\n", percentualVitorias);
        }
        
        System.out.println("=".repeat(50));
    }
    
    /**
     * Reinicia o jogo atual
     */
    public void reiniciarJogo() {
        this.letrasJaTentadas.clear();
        this.status = StatusJogo.EM_ANDAMENTO;
    }
    
    /**
     * Define o nivel de dificuldade
     * @param nivel Nivel de dificuldade
     */
    public void definirNivelDificuldade(NivelDificuldade nivel) {
        this.nivelDificuldade = nivel;
    }
    
    // Getters
    public StatusJogo getStatus() {
        return status;
    }
    
    public boolean jogoTerminou() {
        return status == StatusJogo.VITORIA || status == StatusJogo.DERROTA;
    }
    
    public Palavra getPalavraAtual() {
        return palavraAtual;
    }
    
    public Forca getForca() {
        return forca;
    }
    
    public List<Character> getLetrasJaTentadas() {
        return new ArrayList<>(letrasJaTentadas);
    }
    
    public NivelDificuldade getNivelDificuldade() {
        return nivelDificuldade;
    }
    
    public int getPontuacao() {
        return pontuacao;
    }
    
    public int getJogosVencidos() {
        return jogosVencidos;
    }
    
    public int getJogosPerdidos() {
        return jogosPerdidos;
    }
}
