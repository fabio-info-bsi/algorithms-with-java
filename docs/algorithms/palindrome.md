# Verificador de Palíndromo

## Descrição
Este algoritmo implementa diferentes métodos para verificar se uma palavra é um palíndromo (palavra que pode ser lida da mesma forma da esquerda para a direita e da direita para a esquerda).

## Implementações

### 1. Verificação Iterativa com String
```java
private boolean checkWordPalindrome(String word)
```
- Recebe uma String como entrada
- Converte para array de caracteres
- Chama a implementação baseada em array
- Trata casos nulos e vazios

### 2. Verificação Iterativa com Array
```java
private boolean checkWordPalindrome(char[] word)
```
- Implementação principal usando loop
- Compara caracteres das extremidades até o meio
- Complexidade de tempo: O(n/2)
- Complexidade de espaço: O(1)

### 3. Verificação Recursiva
```java
private boolean checkWordPalindromeRecursive(char[] word)
```
- Implementação recursiva
- Usa um índice para controlar a recursão
- Compara caracteres recursivamente
- Complexidade de tempo: O(n/2)
- Complexidade de espaço: O(n/2) devido à pilha de recursão

## Características

### Tratamento de Casos Especiais
- Strings nulas
- Strings vazias
- Strings de um único caractere
- Arrays nulos
- Arrays vazios

### Comparação das Implementações

#### Versão Iterativa
- Mais eficiente em termos de memória
- Performance previsível
- Código mais simples de entender

#### Versão Recursiva
- Código mais elegante
- Usa mais memória devido à pilha de recursão
- Útil para fins educacionais

## Uso

```java
Main verificador = new Main();

// Usando a versão com String
boolean isPalindrome1 = verificador.checkWordPalindrome("ababa");     // true
boolean isPalindrome2 = verificador.checkWordPalindrome("xbba");      // false

// Usando a versão com array de caracteres
boolean isPalindrome3 = verificador.checkWordPalindrome("radar".toCharArray());  // true

// Usando a versão recursiva
boolean isPalindrome4 = verificador.checkWordPalindromeRecursive("aaAAbAAaa".toCharArray()); // true
```

## Exemplos de Palíndromos

### Verdadeiros
- "ababa"
- "radar"
- "aaAAbAAaa"
- "xxx"
- "a" (único caractere)

### Falsos
- "xbba"
- "lollipop"
- "xbxx"

## Considerações de Performance

### Vantagens
- Algoritmo simples e eficiente
- Baixo uso de memória (versão iterativa)
- Fácil de implementar e manter

### Limitações
- Sensível a maiúsculas/minúsculas
- Não ignora espaços ou pontuação
- Versão recursiva pode ter problemas com strings muito grandes

## Possíveis Melhorias

1. Adicionar suporte para ignorar:
   - Espaços em branco
   - Pontuação
   - Diferenças entre maiúsculas e minúsculas

2. Otimizações:
   - Verificação prévia de comprimento par/ímpar
   - Cache de resultados para strings frequentes
   - Versão paralela para strings muito grandes

## Aplicações Práticas

- Verificação de palíndromos em textos
- Jogos de palavras
- Processamento de linguagem natural
- Validação de sequências biológicas
- Exercícios educacionais de programação