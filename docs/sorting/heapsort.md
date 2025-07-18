# HeapSort

## Descrição
O HeapSort é um algoritmo de ordenação baseado em comparação que utiliza uma estrutura de dados chamada Heap (uma árvore binária especial). Este algoritmo tem complexidade O(n log n) e ordena os elementos in-place.

## Implementação

A implementação presente neste projeto possui as seguintes características:

### Estrutura Principal
- Utiliza um array interno para representar o heap
- Mantém controle do tamanho do heap através da variável `heapSizeInternal`

### Métodos Principais

#### `buildHeap(int[] heap)`
- Constrói um heap máximo a partir de um array desordenado
- Complexidade: O(n)

#### `heapify(int[] heap, int index)`
- Mantém a propriedade de heap máximo
- Garante que o nó em `index` e seus filhos satisfazem a propriedade de heap
- Complexidade: O(log n)

#### `sort()`
- Método principal de ordenação
- Utiliza o buildHeap e depois extrai repetidamente o máximo
- Complexidade: O(n log n)

### Operações Auxiliares
- `parentIndex(int index)`: Retorna o índice do pai de um nó
- `leftIndex(int index)`: Retorna o índice do filho esquerdo
- `rightIndex(int index)`: Retorna o índice do filho direito
- `heapInsert(int key)`: Insere um novo elemento no heap
- `heapExtractMax`: Extrai o maior elemento do heap

## Complexidade

- Tempo: O(n log n) em todos os casos
- Espaço: O(1) - ordenação in-place

## Características

- Não é estável (não mantém a ordem relativa de elementos iguais)
- In-place (não requer memória adicional significativa)
- Eficiente para grandes conjuntos de dados
- Útil quando o espaço é uma preocupação

## Uso

```java
// Ordenação direta de um array
int[] array = {4, 10, 3, 5, 1};
HeapSort.sort(array);

// Ou usando a classe
HeapSort heapSort = new HeapSort(array);
int[] sorted = heapSort.sort();
```

## Aplicações Práticas

- Ordenação de grandes volumes de dados
- Implementação de filas de prioridade
- Encontrar os k maiores/menores elementos em um conjunto de dados