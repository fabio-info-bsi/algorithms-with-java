# Pilhas (Stacks)

## Descrição
Este projeto implementa duas versões de pilhas (estrutura de dados LIFO - Last In, First Out): uma implementação básica (`Stack`) e uma versão melhorada (`StackImprove`). Ambas as implementações usam arrays para armazenamento.

## Implementações

### 1. Pilha Básica (Stack)

```java
public class Stack {
    private int size;        // Contador de elementos
    private int indexTop;    // Índice do topo
    private int[] stack;     // Array de armazenamento
}
```

#### Características
- Mantém contador explícito de elementos
- Controle de índice do topo
- Tamanho fixo definido na criação
- Tratamento de overflow/underflow

### 2. Pilha Melhorada (StackImprove)

```java
public class StackImprove {
    private int indexTop;    // Índice do topo
    private int[] stack;     // Array de armazenamento
}
```

#### Melhorias
- Simplificação do controle de elementos
- Uso do indexTop como contador
- Código mais enxuto
- Mesma funcionalidade com menos variáveis

## Operações Comuns

### Push (Inserção)
```java
public void push(int element)
```
- Adiciona elemento no topo
- Verifica overflow
- Complexidade: O(1)

### Pop (Remoção)
```java
public int pop()
```
- Remove e retorna elemento do topo
- Verifica underflow
- Complexidade: O(1)

### Top (Consulta)
```java
public int top()
```
- Retorna elemento do topo sem remover
- Verifica underflow
- Complexidade: O(1)

### Operações de Verificação
```java
public boolean isEmpty()     // Verifica se está vazia
public int getSize()        // Retorna capacidade total
public int getCount()       // Retorna quantidade de elementos
```

## Uso

### Exemplo Básico
```java
Stack pilha = new Stack(5);  // Cria pilha com capacidade 5

// Inserção
pilha.push(10);
pilha.push(20);

// Consulta
int topo = pilha.top();     // Retorna 20

// Remoção
int elemento = pilha.pop(); // Remove e retorna 20

// Verificações
boolean vazia = pilha.isEmpty();
int tamanho = pilha.getSize();
int quantidade = pilha.getCount();
```

### Exemplo com StackImprove
```java
StackImprove pilha = new StackImprove(5);

pilha.push(10);
pilha.push(20);

int topo = pilha.top();
int elemento = pilha.pop();

boolean vazia = pilha.isEmpty();
int quantidade = pilha.getCount();
```

## Complexidade das Operações

### Tempo
- Push: O(1)
- Pop: O(1)
- Top: O(1)
- isEmpty: O(1)
- getSize: O(1)
- getCount: O(1)

### Espaço
- O(n) onde n é o tamanho máximo da pilha

## Tratamento de Erros

### Overflow
```java
if (indexTop == stack.length) {
    throw new RuntimeException("Stack Overflow!");
}
```

### Underflow
```java
if (isEmpty()) {
    throw new RuntimeException("Stack Underflow!");
}
```

## Aplicações Práticas

1. **Processamento de Dados**
   - Avaliação de expressões
   - Parsing de sintaxe
   - Desfazer/Refazer operações

2. **Algoritmos**
   - Busca em profundidade (DFS)
   - Backtracking
   - Conversão de notações

3. **Sistemas**
   - Gerenciamento de memória
   - Chamadas de função
   - Histórico de navegação

## Possíveis Melhorias

### 1. Funcionalidade
- Implementação genérica (com generics)
- Redimensionamento dinâmico
- Iterador
- Métodos de busca

### 2. Robustez
- Exceções personalizadas
- Validações adicionais
- Thread-safety

### 3. Performance
- Otimização de memória
- Cache de operações
- Versão lock-free

## Boas Práticas de Uso

### 1. Inicialização
- Escolha um tamanho adequado
- Considere o caso de uso
- Inicialize com valores padrão se necessário

### 2. Operações
- Sempre verifique isEmpty antes de pop/top
- Trate as exceções adequadamente
- Mantenha controle do tamanho

### 3. Manutenção
- Monitore o uso de memória
- Limpe referências não utilizadas
- Documente comportamentos específicos

## Comparação das Implementações

### Stack (Básica)
- **Vantagens**
  - Controle explícito de tamanho
  - Fácil de entender
  - Mais flexível para extensões

- **Desvantagens**
  - Redundância no controle de elementos
  - Mais variáveis para manter
  - Maior consumo de memória

### StackImprove (Melhorada)
- **Vantagens**
  - Código mais conciso
  - Menos variáveis
  - Mesma funcionalidade

- **Desvantagens**
  - Menos flexível para extensões
  - Menos explícito
  - Pode ser mais difícil de debugar