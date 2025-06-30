# Filas (Queues)

## Descrição
Este projeto implementa diferentes versões de filas (estrutura de dados FIFO - First In, First Out) com arrays circulares. São fornecidas duas implementações principais: uma básica (`Queue`) e uma melhorada (`QueueImprove`).

## Implementações

### 1. Fila Básica (Queue)

```java
public class Queue {
    private int indexHead = 1;
    private int indexTail = 1;
    private int size;
    private int[] queue;
}
```

#### Características
- Implementação com array circular
- Índices começando em 1
- Controle de tamanho explícito
- Tratamento de overflow/underflow

#### Operações
- `enqueue(int element)`: Adiciona elemento ao final
- `dequeue()`: Remove e retorna o primeiro elemento
- `isEmpty()`: Verifica se está vazia
- `isFull()`: Verifica se está cheia

### 2. Fila Melhorada (QueueImprove)

```java
public class QueueImprove {
    private int indexHead = 0;
    private int indexTail = 0;
    private int[] queue;
}
```

#### Melhorias
- Índices começando em 0
- Uso de operador módulo para circularidade
- Exceções personalizadas
- Cálculo otimizado de tamanho
- Método adicional para contagem de elementos

## Uso

### Fila Básica
```java
Queue fila = new Queue(5); // Cria fila com capacidade 5

// Inserção
fila.enqueue(10);
fila.enqueue(20);

// Remoção
int primeiro = fila.dequeue(); // Retorna 10

// Verificações
boolean vazia = fila.isEmpty();
boolean cheia = fila.isFull();
```

### Fila Melhorada
```java
QueueImprove fila = new QueueImprove(5);

// Inserção
fila.enqueue(10);
fila.enqueue(20);

// Remoção
int primeiro = fila.dequeue();

// Verificações
boolean vazia = fila.isEmpty();
boolean cheia = fila.isFull();
int quantidade = fila.getCountElements();
```

## Complexidade das Operações

### Tempo
- Enqueue: O(1)
- Dequeue: O(1)
- isEmpty: O(1)
- isFull: O(1)
- getCountElements: O(1)

### Espaço
- O(n) onde n é o tamanho máximo da fila

## Características Técnicas

### Fila Básica
1. **Vantagens**
   - Implementação simples
   - Controle direto de tamanho
   - Fácil de entender

2. **Limitações**
   - Exceções genéricas
   - Índices começando em 1
   - Sem método de contagem

### Fila Melhorada
1. **Vantagens**
   - Exceções específicas
   - Índices começando em 0
   - Uso eficiente do operador módulo
   - Método de contagem de elementos

2. **Limitações**
   - Ligeiramente mais complexa
   - Overhead do cálculo módulo

## Tratamento de Erros

### Fila Básica
```java
if (isFull()) throw new RuntimeException("Queue Overflow!");
if (isEmpty()) throw new RuntimeException("Queue Underflow!");
```

### Fila Melhorada
```java
if (isFull()) throw new QueueException("Queue Overflow!");
if (isEmpty()) throw new QueueException("Queue Underflow!");
```

## Aplicações Práticas

- Processamento de tarefas em ordem
- Buffers de dados
- Gerenciamento de recursos
- Escalonamento de processos
- Implementação de BFS (Busca em Largura)

## Possíveis Melhorias

1. **Funcionalidade**
   - Implementação genérica (com generics)
   - Iterador
   - Métodos de peek
   - Redimensionamento dinâmico

2. **Performance**
   - Cache de tamanho
   - Otimização de operações módulo
   - Versão thread-safe

3. **Usabilidade**
   - Mais métodos utilitários
   - Melhor feedback de erros
   - Serialização/Deserialização

## Boas Práticas de Uso

1. **Inicialização**
   - Escolha um tamanho adequado
   - Considere o caso de uso

2. **Operações**
   - Verifique isEmpty antes de dequeue
   - Verifique isFull antes de enqueue
   - Trate as exceções apropriadamente

3. **Manutenção**
   - Monitore o uso de memória
   - Evite overflow/underflow
   - Considere limpar elementos removidos