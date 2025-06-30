# Algoritmos de Ordenação Linear

Este documento descreve os algoritmos de ordenação linear implementados no projeto, que incluem InsertionSort, SelectionSort e BubbleSort, além de suas variantes.

## Insertion Sort

### Descrição
O Insertion Sort é um algoritmo de ordenação que constrói o array final inserindo um elemento por vez na posição correta.

### Implementações

#### `insertionSort(int[] array)`
- Ordenação completa do array
- Algoritmo estável
- Complexidade: O(n²)

#### `insertionSort(int[] array, int startIndex, int endIndex)`
- Permite ordenar uma parte específica do array
- Mantém a estabilidade
- Útil para ordenações parciais

#### `insertionSort(int[] array, int endIndex, UnaryOperator<Integer> operator)`
- Versão com operador personalizado
- Permite ordenar baseado em critérios específicos

## Selection Sort

### Descrição
O Selection Sort é um algoritmo que divide o array em uma parte ordenada e outra não ordenada, selecionando sempre o menor elemento da parte não ordenada.

### Implementações

#### `selectionSort(int[] array)`
- Ordenação completa do array
- Algoritmo não estável
- Complexidade: O(n²)

#### `selectionSort(int[] array, int startIndex, int endIndex)`
- Permite ordenar uma parte específica do array
- Mantém as características do algoritmo original

#### `selectionSort(int[] array, int endIndex, UnaryOperator<Integer> operator)`
- Versão com operador personalizado
- Permite ordenação baseada em critérios específicos

## Bubble Sort

### Descrição
O Bubble Sort é um algoritmo simples que percorre repetidamente o array, comparando elementos adjacentes e os trocando se estiverem na ordem errada.

### Implementações

#### Versão Estável
##### `bubbleSort(int[] array)`
- Ordenação completa do array
- Mantém a ordem relativa de elementos iguais
- Complexidade: O(n²)

##### `bubbleSort(int[] array, int startIndex, int endIndex)`
- Permite ordenar uma parte específica do array
- Mantém a estabilidade

#### Versão Não Estável
##### `bubbleSortNotStable(int[] array)`
- Implementação alternativa
- Não mantém a ordem relativa de elementos iguais
- Pode ser mais eficiente em alguns casos

## Características Gerais

### Complexidade
- Tempo: O(n²) para todos os algoritmos
- Espaço: O(1) - todos são in-place

### Uso

```java
int[] array = {5, 2, 8, 1, 9};

// Insertion Sort
LinearSorting.insertionSort(array);

// Selection Sort
LinearSorting.selectionSort(array);

// Bubble Sort (estável)
LinearSorting.bubbleSort(array);

// Bubble Sort (não estável)
LinearSorting.bubbleSortNotStable(array);

// Ordenação com operador personalizado
UnaryOperator<Integer> operator = x -> x % 10; // ordena pelo último dígito
LinearSorting.insertionSort(array, array.length, operator);
```

## Aplicações Práticas

### Insertion Sort
- Melhor para arrays pequenos
- Eficiente para arrays quase ordenados
- Útil como parte de algoritmos híbridos

### Selection Sort
- Minimiza o número de trocas
- Bom para ordenar arrays com elementos grandes
- Útil quando a memória de escrita é limitada

### Bubble Sort
- Fácil de implementar e entender
- Útil para fins educacionais
- Bom para detectar se um array já está ordenado

## Comparação entre os Algoritmos

### Insertion Sort
- **Vantagens**: Estável, adaptativo, bom para arrays pequenos
- **Desvantagens**: O(n²) no pior caso

### Selection Sort
- **Vantagens**: Número mínimo de trocas, in-place
- **Desvantagens**: Não estável, sempre O(n²)

### Bubble Sort
- **Vantagens**: Fácil implementação, detecta ordenação
- **Desvantagens**: Geralmente o mais lento dos três