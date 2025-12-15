# Árvore Rubro-Negra (Red-Black Tree)

## Visão Geral

A Árvore Rubro-Negra é uma árvore binária de busca auto-balanceada onde cada nó possui uma cor (vermelho ou preto) e segue propriedades específicas que garantem balanceamento, mantendo operações eficientes mesmo no pior caso.

## Propriedades da Árvore Rubro-Negra

1. **Propriedade da Cor**: Cada nó é vermelho ou preto
2. **Propriedade da Raiz**: A raiz é sempre preta
3. **Propriedade das Folhas**: Todas as folhas (NIL) são pretas
4. **Propriedade Vermelha**: Se um nó é vermelho, seus filhos são pretos
5. **Propriedade do Caminho Preto**: Todos os caminhos de um nó até suas folhas contêm o mesmo número de nós pretos

## Implementação

### Classes Principais

- **`AbstractRedBlackTree<T>`**: Classe abstrata que define a interface
- **`RedBlackTreeImpl<T>`**: Implementação concreta da árvore rubro-negra
- **`RedBlackNode<T>`**: Representa um nó da árvore com cor
- **`Color`**: Enum que define as cores (RED, BLACK)

### Operações Implementadas

#### Percursos da Árvore
- **In-Order**: Percorre em ordem crescente
- **Pre-Order**: Percorre raiz primeiro
- **Post-Order**: Percorre raiz por último
- **Breadth-First**: Percorre por níveis

#### Operações de Busca
- **`treeSearch()`**: Busca recursiva por um elemento
- **`treeMinimum()`**: Encontra o menor elemento
- **`treeMaximum()`**: Encontra o maior elemento
- **`treeSuccessor()`**: Encontra o próximo elemento em ordem
- **`treePredecessor()`**: Encontra o elemento anterior em ordem

#### Operações de Modificação
- **`treeInsert()`**: Insere um novo elemento com rebalanceamento
- **`treeDelete()`**: Remove um elemento com rebalanceamento

#### Operações de Balanceamento
- **`leftRotation()`**: Rotação à esquerda
- **`rightRotation()`**: Rotação à direita
- **`insertRecolorization()`**: Recoloração após inserção
- **`deleteRecolorization()`**: Recoloração após remoção

## Complexidade

| Operação | Melhor Caso | Caso Médio | Pior Caso |
|----------|-------------|------------|-----------|
| Busca    | O(log n)    | O(log n)   | O(log n)  |
| Inserção | O(log n)    | O(log n)   | O(log n)  |
| Remoção  | O(log n)    | O(log n)   | O(log n)  |

## Exemplo de Uso

```java
// Criando uma árvore rubro-negra
RedBlackTreeImpl<Integer> rbt = new RedBlackTreeImpl<>();

// Inserindo elementos (balanceamento automático)
rbt.treeInsert(new RedBlackNode<>(10));
rbt.treeInsert(new RedBlackNode<>(20));
rbt.treeInsert(new RedBlackNode<>(30));
rbt.treeInsert(new RedBlackNode<>(15));
rbt.treeInsert(new RedBlackNode<>(25));

// Buscando um elemento
RedBlackNode<Integer> node = rbt.treeSearch(rbt.getRoot(), 20);

// Encontrando mínimo e máximo
RedBlackNode<Integer> min = rbt.treeMinimum(rbt.getRoot());
RedBlackNode<Integer> max = rbt.treeMaximum(rbt.getRoot());

// Percorrendo a árvore
rbt.inOrderTreeWalk(rbt.getRoot());

// Removendo um elemento (rebalanceamento automático)
RedBlackNode<Integer> nodeToDelete = rbt.treeSearch(rbt.getRoot(), 15);
rbt.treeDelete(nodeToDelete);
```

## Características

### Vantagens
- **Balanceamento Garantido**: Altura sempre O(log n)
- **Performance Consistente**: Operações sempre eficientes
- **Auto-Balanceamento**: Mantém propriedades automaticamente
- **Amplamente Utilizada**: Base para muitas implementações (TreeMap, TreeSet)

### Desvantagens
- **Complexidade de Implementação**: Mais complexa que BST simples
- **Overhead de Memória**: Armazena cor adicional em cada nó
- **Constantes Maiores**: Mais operações que BST simples

## Algoritmos de Balanceamento

### Inserção
1. Inserir como em BST normal
2. Colorir o novo nó de vermelho
3. Aplicar correções se violações ocorrerem:
   - Recoloração de nós
   - Rotações (esquerda/direita)

### Remoção
1. Remover como em BST normal
2. Se nó removido era preto, aplicar correções:
   - Recoloração de nós
   - Rotações para manter propriedades

## Casos de Uso

- **Estruturas de Dados de Bibliotecas**: TreeMap, TreeSet em Java
- **Sistemas de Banco de Dados**: Índices B-tree baseados em RB-tree
- **Sistemas Operacionais**: Escalonamento de processos
- **Compiladores**: Tabelas de símbolos
- **Algoritmos Geométricos**: Estruturas de dados espaciais

## Comparação com BST

| Aspecto | BST Simples | Árvore Rubro-Negra |
|---------|-------------|-------------------|
| Balanceamento | Manual | Automático |
| Pior Caso | O(n) | O(log n) |
| Complexidade | Simples | Complexa |
| Uso de Memória | Menor | Maior (cor) |
| Garantias | Nenhuma | Altura balanceada |

## Localização no Projeto

```
src/main/java/br/com/fabex/dataofstructs/trees/rbt/
├── AbstractRedBlackTree.java
├── RedBlackTreeImpl.java
├── RedBlackNode.java
└── Color.java
```

## Testes

Os testes estão localizados em:
```
src/test/java/br/com/fabex/dataofstructs/trees/rbt/RedBlackTreeImplTest.java
```

Cobrem cenários como:
- Inserção com rebalanceamento
- Remoção com diferentes casos
- Manutenção das propriedades rubro-negras
- Operações de busca e percurso
- Casos complexos de recoloração e rotação