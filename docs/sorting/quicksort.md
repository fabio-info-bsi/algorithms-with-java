# QuickSort

## Descrição
O QuickSort é um algoritmo de ordenação eficiente que utiliza a estratégia "dividir para conquistar". Ele seleciona um elemento como pivô e particiona o array ao redor deste pivô, colocando elementos menores à esquerda e maiores à direita. Esta implementação inclui tanto a versão clássica quanto uma versão randomizada para melhor performance em diferentes cenários.

## Implementação

A implementação presente neste projeto possui duas variantes principais:

### Versão Clássica

#### Métodos Principais

##### `sort(int[] array)`
- Método público principal que inicia a ordenação
- Utiliza o último elemento como pivô

##### `sort(int[] array, int startIndex, int endIndex)`
- Permite ordenar uma parte específica do array
- Mantém os elementos fora do intervalo inalterados

##### `partition(int[] array, int startIndex, int pivotIndex)`
- Reorganiza os elementos ao redor do pivô
- Retorna a posição final do pivô

### Versão Randomizada

#### Métodos Principais

##### `sortRandomized(int[] array)`
- Versão que escolhe o pivô aleatoriamente
- Melhor performance em arrays já parcialmente ordenados

##### `partitionRandomized(int[] array, int startIndex, int endIndex)`
- Seleciona um pivô aleatório
- Troca o pivô com o último elemento
- Chama o partition normal

## Complexidade

### Caso Médio e Melhor Caso
- Tempo: O(n log n)
- Espaço: O(log n) para a pilha de recursão

### Pior Caso
- Tempo: O(n²) - quando o array está ordenado ou reversamente ordenado
- A versão randomizada reduz a probabilidade do pior caso

## Características

- In-place (requer apenas O(log n) de espaço adicional)
- Não estável (não mantém a ordem relativa de elementos iguais)
- Muito eficiente na prática
- Adaptável através da escolha do pivô

## Uso

```java
// Ordenação clássica
int[] array = {4, 10, 3, 5, 1};
QuickSort.sort(array);

// Ordenação randomizada
int[] array2 = {4, 10, 3, 5, 1};
QuickSort.sortRandomized(array2);

// Ordenação de um intervalo específico
QuickSort.sort(array, 1, 4); // Ordena do índice 1 ao 3
```

## Aplicações Práticas

- Ordenação de arrays em memória
- Implementação padrão em muitas bibliotecas
- Boa performance em dados aleatórios
- Eficiente para arrays pequenos e médios

## Vantagens e Desvantagens

### Vantagens
- Muito eficiente na prática
- In-place
- Cache-friendly
- Baixo overhead

### Desvantagens
- Não estável
- Vulnerável a arrays ordenados (versão clássica)
- Performance pode variar dependendo da escolha do pivô

## Otimizações Implementadas

- Versão randomizada para melhor performance em casos adversos
- Particionamento eficiente
- Possibilidade de ordenar intervalos específicos