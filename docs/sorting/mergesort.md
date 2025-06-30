# MergeSort

## Descrição
O MergeSort é um algoritmo de ordenação que utiliza a estratégia "dividir para conquistar". Ele divide o array em duas metades, ordena cada metade recursivamente e depois combina (merge) as duas metades ordenadas para produzir o array final ordenado.

## Implementação

A implementação presente neste projeto possui as seguintes características:

### Métodos Principais

#### `sort(int[] array)`
- Método público principal que inicia a ordenação
- Chama o método de implementação interno com os índices inicial e final

#### `sort(int[] array, int start, int end)`
- Versão sobrecarregada que permite ordenar apenas uma parte do array
- Mantém os elementos fora do intervalo inalterados

#### `sortImpl(int[] array, int start, int end)`
- Implementação recursiva do algoritmo
- Divide o array ao meio e ordena cada metade
- Chama o método merge para combinar as partes ordenadas

#### `merge(int[] array1, int[] array2)`
- Combina dois arrays ordenados em um único array ordenado
- Utiliza comparações para manter a ordem dos elementos

## Complexidade

- Tempo: O(n log n) em todos os casos
- Espaço: O(n) - requer espaço adicional proporcional ao tamanho do array

## Características

- Estável (mantém a ordem relativa de elementos iguais)
- Não é in-place (requer memória adicional)
- Previsível (sempre O(n log n))
- Bom para ordenação de listas ligadas

## Uso

```java
// Ordenação completa do array
int[] array = {4, 10, 3, 5, 1};
int[] sorted = MergeSort.sort(array);

// Ordenação de um intervalo específico
int[] partialSorted = MergeSort.sort(array, 1, 4); // Ordena do índice 1 ao 3
```

## Aplicações Práticas

- Ordenação de grandes conjuntos de dados
- Ordenação de dados em memória externa
- Ordenação de listas ligadas
- Quando a estabilidade é importante
- Quando o tempo de execução previsível é necessário

## Vantagens e Desvantagens

### Vantagens
- Tempo de execução garantido O(n log n)
- Estável
- Bom para paralelização

### Desvantagens
- Requer espaço adicional O(n)
- Pode ser mais lento que outros algoritmos para arrays pequenos
- Não é in-place