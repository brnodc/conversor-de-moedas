# Conversor (Moedas e Temperatura)

Projeto simples em **Java + Swing (JOptionPane)** para converter **moedas** e **temperaturas**, organizado em camadas e com estrutura **Maven**.

## O que foi melhorado neste refactor

- Estrutura padrão Maven: `src/main/java`
- Pacotes em padrão Java: `com.github.ernandes.conversor...`
- Separação de responsabilidades:
  - `ui` (interface Swing)
  - `service` (regras de conversão)
  - `domain` (enums do domínio)
  - `util` (formatação e parsing)
- Conversão com `BigDecimal` (evita erros comuns de ponto flutuante)
- Validação de entrada:
  - aceita `10`, `10,5`, `10.5`, `1.234,56`
  - trata **cancelamento** sem quebrar o app
- Implementado também o conversor de **temperatura** (opção já existia no menu)

> **Nota sobre taxas de câmbio:** neste projeto as taxas são **fixas** (para manter simples). Para produção, Futuramente irei integrar uma API de câmbio e cachear as taxas.

## Requisitos

- Java **17+**
- Maven **3.8+**

## Como rodar

### Opção 1: Maven (recomendado)

Na raiz do projeto:

```bash
mvn clean package
java -jar target/conversor-de-moedas-1.0.0.jar
```

### Opção 2: Rodar pela IDE

Abra o projeto na IDE (IntelliJ/Eclipse) como projeto Maven e execute:

- `com.github.ernandes.conversor.App`

## Estrutura de pastas

```
src/
  main/
    java/
      com/github/ernandes/conversor/
        App.java
        domain/
          Currency.java
          TemperatureUnit.java
        service/
          CurrencyConverter.java
          TemperatureConverter.java
        ui/
          SwingMenu.java
        util/
          Formatters.java
          Parsers.java
```

## Onde alterar as taxas

As taxas estão centralizadas em:

- `src/main/java/com/github/ernandes/conversor/service/CurrencyConverter.java`

Procure pelo bloco `BRL_TO` e ajuste os valores.

## Próximos passos (ideias)

- Buscar câmbio em API (ex.: exchangerate) e salvar em cache
- Testes unitários com JUnit
- Substituir `JOptionPane` por UI mais completa (JavaFX) ou CLI

## Licença

Uso livre para estudo e evolução.
