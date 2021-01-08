# Framework de Teste Automatizado com Selenium WebDriver, Java, JUnit 5 e Maven

<p align="justify"> Com o objetivo de consolidar os conhecimentos que venho adquirindo sobre o tema, criei esse exemplo prático
de framework de teste web automatizado construído com SeleniumWebdriver + Java. </p>

<p align="justify"> Utilizei o site de testes http://the-internet.herokuapp.com/login para simular os seguintes cenários: </p>

1. Login realizado com sucesso
2. Tentativa de login com usuário inválido
3. Tentativa de login com senha inválida
4. Tentativa de login sem passar nenhuma das credenciais

<p align="justify"> Criei 2 classes de teste com os mesmos cenários: sendo uma com
uso de design pattern Page Object e a outra não. Utilizei a abordagem de Data-driven testing para
popular um arquivo .csv com a massa de dados. Além de poder rodar os testes via linha de comando com ajuda do plugin
Surfire, foi possível verificar os resultados com auxílio do Allure Report, um framework de relatório de testes. </p> 

# Requisitos

Ferramentas:
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download)
- [Java SE Development Kit 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
- [Allure](https://github.com/allure-framework/allure2/releases/tag/2.13.8)

Dependências:
- [JUnit 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.7.0)
- [Selenium Webdriver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59)

# Estrutura de diretórios

```
./projeto
├─ src/
    ├─ main
    └─ test/
       └─ java/
           ├─ pages/
           ├─ suporte/
           └─ test/
                ├─ LoginTest
                └─ LoginPageObjectTest
       └─ resources/
```


- src: diretório principal
- main: diretório com código fonte da aplicação
- test: diretório onde será construído o script de teste inicial
- java: diretório padrão criada assim que iniciamos um projeto
- pages: pacote contendo as classes voltadas para PageObject
- suporte: pacote contendo as classes que auxiliam em scripts básicos
- test: pacote contendo as classes de teste criadas
- LoginTest: classe de teste contendo o primeiro script de teste de forma básica
- LoginPageObjectTest: classe de teste contendo o mesmo script de teste mas com design pattern Page Object
- resources: diretório com os arquivos .csv com massa de dados

#Executando via linha de comando
<p align="justify"> Para executar os testes via linha de comando de todas as classes de teste do projeto: </p>

` mvn surfire:test`

<p align="justify"> Assim que executados os testes será criada uma pasta dentro do diretório "target", chamada "surefire-reports". </p>

#Relatório
<p align="justify"> Para abrir o relatório de testes Allure via linha de comando: </p>

`allure serve /PATH`*

<p align="justify"> *O path deve ser alterado para o caminho da pasta "surefire-reports" criada no passo anterior. </p>
