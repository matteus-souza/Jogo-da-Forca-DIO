@echo off
echo Compilando o Jogo da Forca...
javac -d bin -cp src src\com\dio\jogoforca\JogoForcaMain.java src\com\dio\jogoforca\Jogo.java src\com\dio\jogoforca\enums\*.java src\com\dio\jogoforca\exceptions\*.java src\com\dio\jogoforca\modelo\*.java src\com\dio\jogoforca\util\*.java

if %errorlevel% == 0 (
    echo.
    echo Compilacao bem-sucedida! Iniciando o jogo...
    echo.
    java -cp bin com.dio.jogoforca.JogoForcaMain
) else (
    echo.
    echo Erro na compilacao!
    pause
)
