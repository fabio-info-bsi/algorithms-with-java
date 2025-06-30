# Listas Encadeadas

## Descrição
Este projeto implementa diferentes tipos de listas encadeadas, incluindo lista circular duplamente encadeada com sentinela. A implementação é genérica, permitindo o uso com qualquer tipo de dado.

## Lista Circular Duplamente Encadeada

### Estrutura
```java
public class CircularLinkedList<T> {
    private final CircularElement<T> sentinel;
    private int countElements;
}

public class CircularElement<T> {
    T key;
    CircularElement<T> prev;
    CircularElement<T> next;
}
```

### Características
- Usa elemento sentinela para simplificar operações
- Mantém contagem de elementos
- Implementação genérica (type-safe)
- Duplamente encadeada (referências para próximo e anterior)
- Circular (último elemento aponta para o primeiro)

### Operações Principais

#### Inserção
```java
public void prepend(CircularElement<T> element)
```
- Insere no início da lista
- Complexidade: O(1)

```java
public void insert(CircularElement<T> pointer, CircularElement<T> element)
```
- Insere após um elemento específico
- Complexidade: O(1)

#### Remoção
```java
public void delete(CircularElement<T> element)
```
- Remove um elemento específico
- Complexidade: O(1)

#### Busca
```java
public CircularElement<T> search(CircularElement<T> element)
```
- Busca um elemento na lista
- Complexidade: O(n)

#### Outras Operações
```java
public boolean isEmpty()
public CircularElement<T> getHead()
public int getCountElements()
```

## Uso

```java
// Criando uma lista
CircularLinkedList<Integer> lista = new CircularLinkedList<>();

// Criando elementos
CircularElement<Integer> elem1 = new CircularElement<>(1);
CircularElement<Integer> elem2 = new CircularElement<>(2);

// Inserindo elementos
lista.prepend(elem1);
lista.insert(elem1, elem2);

// Verificando se está vazia
boolean vazia = lista.isEmpty();

// Obtendo o primeiro elemento
CircularElement<Integer> primeiro = lista.getHead();

// Removendo elementos
lista.delete(elem1);
```

## Complexidade das Operações

### Tempo
- Inserção: O(1)
- Remoção: O(1)
- Busca: O(n)
- Verificação de vazio: O(1)
- Acesso ao primeiro elemento: O(1)

### Espaço
- O(n) para n elementos
- Overhead constante por elemento (referências prev e next)

## Vantagens

1. **Flexibilidade**
   - Suporte a qualquer tipo de dado
   - Inserção e remoção eficientes
   - Navegação bidirecional

2. **Robustez**
   - Uso de sentinela simplifica operações
   - Evita casos especiais
   - Mantém contagem precisa de elementos

3. **Performance**
   - Operações de inserção e remoção em O(1)
   - Sem necessidade de realocação

## Limitações

1. **Uso de Memória**
   - Overhead por elemento (referências)
   - Não contíguo em memória

2. **Acesso Aleatório**
   - Sem indexação direta
   - Necessário percorrer a lista

## Aplicações Práticas

- Implementação de filas e pilhas
- Gerenciamento de tarefas circulares
- Cache circular
- Jogos (turnos de jogadores)
- Escalonamento de processos

## Possíveis Melhorias

1. **Funcionalidade**
   - Iteradores
   - Ordenação
   - Métodos de conveniência
   - Serialização

2. **Performance**
   - Cache de último acesso
   - Otimização de busca
   - Operações em lote

3. **Segurança**
   - Validações adicionais
   - Thread-safety
   - Imutabilidade opcional