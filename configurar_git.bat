@echo off
echo ============================================
echo     CONFIGURANDO REPOSITORIO GIT
echo ============================================

echo.
echo [1/7] Inicializando repositorio Git...
git init

echo.
echo [2/7] Adicionando todos os arquivos...
git add .

echo.
echo [3/7] Fazendo commit inicial...
git commit -m "feat: Implementacao completa do Jogo da Forca

- Aplicacao de conceitos de POO (classes, objetos, encapsulamento)
- Sistema de niveis de dificuldade com enums
- Tratamento de excecoes personalizadas
- Banco de palavras com 25 palavras em 5 categorias
- Sistema de pontuacao inteligente
- Interface console interativa com menu completo
- Documentacao tecnica detalhada

Projeto desenvolvido para o Desafio DIO de Programacao Orientada a Objetos"

echo.
echo [4/7] Configurando branch principal...
git branch -M main

echo.
echo ============================================
echo     PROXIMO PASSO: CRIAR REPOSITORIO
echo ============================================
echo.
echo 1. Acesse: https://github.com
echo 2. Clique em "New repository"
echo 3. Nome: jogo-da-forca-dio
echo 4. Descricao: Jogo da Forca em Java - Desafio DIO aplicando conceitos de POO
echo 5. Marque como PUBLIC
echo 6. NAO inicialize com README
echo 7. Clique "Create repository"
echo.
echo Apos criar o repositorio, execute:
echo git remote add origin https://github.com/SEU_USUARIO/jogo-da-forca-dio.git
echo git push -u origin main
echo.
pause
