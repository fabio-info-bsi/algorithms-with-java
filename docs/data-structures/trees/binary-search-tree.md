# Árvore Binária de Busca (BST)

## Visão Geral

A Árvore Binária de Busca é uma estrutura de dados hierárquica que mantém os elementos organizados de forma que, para cada nó:
- Todos os elementos na subárvore esquerda são menores que o nó
- Todos os elementos na subárvore direita são maiores que o nó

## Implementação

### Classes Principais

- **`AbstractBinarySearchTree<T>`**: Classe abstrata que define a interface
- **`BinarySearchTreeImpl<T>`**: Implementação concreta da árvore
- **`BinarySearchNode<T>`**: Representa um nó da árvore

### Operações Implementadas

#### Percursos da Árvore
- **In-Order**: Percorre em ordem crescente (esquerda → raiz → direita)
- **Pre-Order**: Percorre raiz primeiro (raiz → esquerda → direita)
- **Post-Order**: Percorre raiz por último (esquerda → direita → raiz)
- **Breadth-First**: Percorre por níveis (busca em largura)

#### Operações de Busca
- **`treeSearch()`**: Busca recursiva por um elemento
- **`iterativeTreeSearch()`**: Busca iterativa por um elemento
- **`treeMinimum()`**: Encontra o menor elemento
- **`treeMaximum()`**: Encontra o maior elemento
- **`treeSuccessor()`**: Encontra o próximo elemento em ordem
- **`treePredecessor()`**: Encontra o elemento anterior em ordem

#### Operações de Modificação
- **`treeInsert()`**: Insere um novo elemento
- **`treeDelete()`**: Remove um elemento

## Complexidade

| Operação | Melhor Caso | Caso Médio | Pior Caso |
|----------|-------------|------------|-----------|
| Busca    | O(log n)    | O(log n)   | O(n)      |
| Inserção | O(log n)    | O(log n)   | O(n)      |
| Remoção  | O(log n)    | O(log n)   | O(n)      |

## Exemplo de Uso

```java
// Criando uma árvore binária de busca
BinarySearchTreeImpl<Integer> bst = new BinarySearchTreeImpl<>();

// Inserindo elementos
bst.treeInsert(new BinarySearchNode<>(15));
bst.treeInsert(new BinarySearchNode<>(6));
bst.treeInsert(new BinarySearchNode<>(18));
bst.treeInsert(new BinarySearchNode<>(3));
bst.treeInsert(new BinarySearchNode<>(7));

// Buscando um elemento
BinarySearchNode<Integer> node = bst.treeSearch(bst.getRoot(), 7);

// Encontrando mínimo e máximo
BinarySearchNode<Integer> min = bst.treeMinimum(bst.getRoot());
BinarySearchNode<Integer> max = bst.treeMaximum(bst.getRoot());

// Percorrendo a árvore em ordem
bst.inOrderTreeWalk(bst.getRoot());

// Removendo um elemento
BinarySearchNode<Integer> nodeToDelete = bst.treeSearch(bst.getRoot(), 6);
bst.treeDelete(nodeToDelete);
```

## Características

### Vantagens
- Busca eficiente em árvores balanceadas
- Inserção e remoção dinâmicas
- Percurso em ordem fornece elementos ordenados
- Estrutura simples e intuitiva

### Desvantagens
- Pode degenerar em lista ligada (pior caso O(n))
- Não garante balanceamento automático
- Performance dependente da ordem de inserção

## Casos de Uso

- Implementação de dicionários e mapas
- Sistemas de indexação
- Algoritmos de ordenação
- Estruturas de dados auxiliares em compiladores

## Localização no Projeto

```
src/main/java/br/com/fabex/dataofstructs/trees/bst/
├── AbstractBinarySearchTree.java
├── BinarySearchTreeImpl.java
└── BinarySearchNode.java
```

## Testes

Os testes estão localizados em:
```
src/test/java/br/com/fabex/dataofstructs/trees/bst/BinarySearchTreeImplTest.java
```

Cobrem cenários como:
- Inserção e busca de elementos
- Operações de mínimo e máximo
- Sucessor e predecessor
- Remoção em diferentes casos
- Percursos da árvore