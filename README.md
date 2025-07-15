# 🎮 Jogo da Forca - Desafio DIO

![Java](https://img.shields.io/badge/Java-SE-red?style=for-the-badge&logo=java)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completo-green?style=for-the-badge)

## 📋 Sobre o Projeto

Este projeto é um **Jogo da Forca** desenvolvido em Java console, criado como parte do Desafio DIO com foco na aplicação de conceitos de **Programação Orientada a Objetos (POO)**. O jogo implementa uma estrutura completa e interativa, demonstrando boas práticas de desenvolvimento em Java.

## 🎯 Objetivos de Aprendizagem

- ✅ **Aplicar conceitos de POO**: Classes, objetos, métodos e encapsulamento
- ✅ **Trabalhar com estruturas de dados**: Listas, enums e manipulação de strings
- ✅ **Implementar controle de fluxo**: Lógica de jogo com controle de estado
- ✅ **Praticar separação de responsabilidades**: Projeto estruturado e organizado
- ✅ **Desenvolver tratamento de exceções**: Exceções personalizadas
- ✅ **Documentar processos técnicos**: README detalhado e código comentado

## 🏗️ Arquitetura do Projeto

```
src/com/dio/jogoforca/
├── 📁 enums/
│   ├── StatusJogo.java          # Estados do jogo
│   └── NivelDificuldade.java    # Níveis de dificuldade
├── 📁 exceptions/
│   ├── LetraJaTentadaException.java    # Exceção para letra repetida
│   └── EntradaInvalidaException.java   # Exceção para entrada inválida
├── 📁 modelo/
│   ├── Palavra.java             # Encapsula palavra secreta
│   └── Forca.java              # Representação gráfica da forca
├── 📁 util/
│   ├── BancoPalavras.java      # Gerencia banco de palavras
│   └── EntradaUtil.java        # Utilitários para entrada de dados
├── Jogo.java                   # Lógica principal do jogo
└── JogoForcaMain.java         # Interface principal e menu
```

## 🎲 Funcionalidades

### 🎮 **Gameplay**
- Sistema de tentativas baseado em dificuldade
- Representação gráfica da forca
- Sistema de pontuação inteligente
- Múltiplas categorias de palavras com dicas

### ⚙️ **Configurações**
- **3 níveis de dificuldade:**
  - 😊 **Fácil**: 8 tentativas
  - 😐 **Médio**: 6 tentativas  
  - 😰 **Difícil**: 4 tentativas

### 📊 **Sistema de Pontuação**
- **Pontuação base**: 100 pontos por vitória
- **Bônus por tentativas restantes**: 10 pontos cada
- **Bônus por tamanho da palavra**: 5 pontos por letra
- **Bônus por dificuldade**: Fácil +10, Médio +20, Difícil +50

### 📈 **Estatísticas**
- Pontuação total acumulada
- Contador de vitórias e derrotas
- Taxa de vitória percentual
- Histórico de desempenho

## 🏛️ Conceitos de POO Aplicados

### 1. **Encapsulamento**
```java
public class Palavra {
    private String palavraSecreta;    // Atributo privado
    private List<Character> letrasReveladas;
    
    public String getPalavraRevelada() {  // Método público
        // Lógica protegida internamente
    }
}
```

### 2. **Enumerações**
```java
public enum StatusJogo {
    EM_ANDAMENTO("Jogo em andamento"),
    VITORIA("Você venceu!"),
    DERROTA("Você perdeu!");
}
```

### 3. **Herança e Exceções Personalizadas**
```java
public class LetraJaTentadaException extends Exception {
    public LetraJaTentadaException(String mensagem) {
        super(mensagem);
    }
}
```

### 4. **Composição**
```java
public class Jogo {
    private Palavra palavraAtual;    // Composição
    private Forca forca;             // Composição
    private StatusJogo status;       // Uso de enum
}
```

## 🚀 Como Executar

### **Pré-requisitos**
- Java JDK 8 ou superior
- VS Code com Extension Pack for Java (opcional)

### **Passos para execução**

1. **Clone o repositório:**
```bash
git clone <url-do-repositorio>
cd JOGO-FORCA
```

2. **Compile o projeto:**
```bash
# Windows
javac -d bin -cp src src\com\dio\jogoforca\JogoForcaMain.java src\com\dio\jogoforca\Jogo.java src\com\dio\jogoforca\enums\*.java src\com\dio\jogoforca\exceptions\*.java src\com\dio\jogoforca\modelo\*.java src\com\dio\jogoforca\util\*.java

# Linux/Mac
javac -d bin -cp src src/com/dio/jogoforca/JogoForcaMain.java src/com/dio/jogoforca/Jogo.java src/com/dio/jogoforca/enums/*.java src/com/dio/jogoforca/exceptions/*.java src/com/dio/jogoforca/modelo/*.java src/com/dio/jogoforca/util/*.java
```

3. **Execute o jogo:**
```bash
java -cp bin com.dio.jogoforca.JogoForcaMain
```

### **Ou use o arquivo batch (Windows):**
```bash
# Execute o arquivo batch que compila e executa automaticamente
executar_jogo.bat
```

### **Ou usando VS Code:**
1. Abra a pasta do projeto no VS Code
2. Execute com `F5` ou `Ctrl+F5`
3. Use o terminal integrado para interagir com o jogo

## 🎯 Como Jogar

1. **Inicie o jogo** escolhendo "Iniciar Novo Jogo" no menu
2. **Observe** a categoria, dica e quantidade de letras
3. **Digite uma letra** por vez para descobrir a palavra
4. **Ganhe** descobrindo toda a palavra antes que a forca seja completada
5. **Acumule pontos** e melhore suas estatísticas!

### 💡 **Dicas Estratégicas**
- Comece com **vogais** (A, E, I, O, U)
- Use **consoantes comuns** (R, S, T, N, L)
- Preste atenção na **categoria** e **dica**
- Considere o **tamanho** da palavra

## 📊 Banco de Palavras

O jogo inclui **25 palavras** organizadas em **5 categorias**:

| Categoria | Exemplos | Quantidade |
|-----------|----------|------------|
| 🐾 **Animais** | Elefante, Girafa, Tigre | 5 palavras |
| 🍎 **Frutas** | Abacaxi, Morango, Manga | 5 palavras |
| 🌍 **Países** | Brasil, Japão, França | 5 palavras |
| 👨‍⚕️ **Profissões** | Médico, Professor, Engenheiro | 5 palavras |
| 📱 **Objetos** | Computador, Televisão, Livro | 5 palavras |

## 🛠️ Estrutura Técnica

### **Design Patterns Utilizados**
- **Singleton Pattern**: BancoPalavras (acesso estático)
- **Utility Classes**: EntradaUtil (métodos estáticos)
- **Enum Pattern**: StatusJogo, NivelDificuldade

### **Tratamento de Exceções**
- `LetraJaTentadaException`: Para letras já tentadas
- `EntradaInvalidaException`: Para entradas inválidas
- Tratamento robusto de erros de entrada

### **Estruturas de Dados**
- `ArrayList<Character>`: Para letras tentadas e reveladas
- `String`: Manipulação avançada para exibição
- `Enum`: Para estados e configurações

## 📸 Capturas de Tela

> *Adicione aqui capturas de tela do jogo funcionando*

## 🧪 Testes e Validação

### **Cenários Testados**
- ✅ Entrada de letras válidas e inválidas
- ✅ Tentativas de letras repetidas
- ✅ Vitória e derrota em todos os níveis
- ✅ Cálculo correto de pontuação
- ✅ Navegação completa do menu
- ✅ Persistência de estatísticas durante a sessão

## 📚 Aprendizados e Desafios

### **Principais Aprendizados**
1. **Estruturação de projeto** com separação clara de responsabilidades
2. **Aplicação prática de POO** em um contexto real
3. **Tratamento robusto de exceções** e validação de entrada
4. **Design de interface console** amigável e intuitiva
5. **Gerenciamento de estado** em aplicações interativas

### **Desafios Superados**
- Implementação da lógica de revelação de letras
- Criação do desenho ASCII da forca dinâmico
- Balanceamento do sistema de pontuação
- Tratamento elegante de exceções personalizadas

## 🔄 Possíveis Melhorias Futuras

- [ ] **Persistência de dados**: Salvar estatísticas em arquivo
- [ ] **Multiplayer**: Modo para dois jogadores
- [ ] **Interface gráfica**: Migração para JavaFX ou Swing
- [ ] **API externa**: Integração com dicionário online
- [ ] **Níveis temáticos**: Palavras por temas específicos
- [ ] **Sistema de ranking**: Comparação entre jogadores
- [ ] **Modo cronometrado**: Pressão adicional de tempo

## 🤝 Contribuição

Este projeto foi desenvolvido como parte de um desafio educacional. Sugestões e melhorias são bem-vindas!

### **Como contribuir:**
1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto é distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

## 🎓 Sobre o Desafio DIO

Este projeto foi desenvolvido como parte do desafio **"Aplicando Conceitos de POO com Java"** da Digital Innovation One (DIO), demonstrando:

- ✅ Domínio de conceitos fundamentais de POO
- ✅ Capacidade de estruturar projetos Java
- ✅ Aplicação de boas práticas de desenvolvimento
- ✅ Documentação técnica clara e detalhada
- ✅ Uso do GitHub para versionamento e compartilhamento

## 🔧 Correções de Gramática e Compatibilidade

Durante o desenvolvimento, foram identificados e corrigidos problemas de codificação para garantir compatibilidade com console Windows:

### ✅ Correções Realizadas:
- **Acentos removidos**: "pontuação" → "pontuacao", "instruções" → "instrucoes"
- **Cedilhas padronizadas**: "opção" → "opcao", "função" → "funcao"  
- **Caracteres especiais**: Emojis substituídos por caracteres ASCII seguros
- **Mensagens de erro**: Padronizadas sem acentos para evitar problemas de encoding
- **Comentários JavaDoc**: Revisados para manter consistência

### 🎯 Motivo das Alterações:
As correções garantem que o jogo funcione perfeitamente em qualquer ambiente Windows console, evitando problemas de exibição de caracteres UTF-8 e erros de compilação.

---

<div align="center">

**Desenvolvido com ❤️ para o Desafio DIO**

[⬆ Voltar ao topo](#-jogo-da-forca---desafio-dio)

</div>
