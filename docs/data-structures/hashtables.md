# Tabelas Hash (Hash Tables)

## Descrição
Este projeto implementa diferentes estratégias de tabelas hash, incluindo endereçamento fechado (closed addressing) com encadeamento e endereçamento aberto (open addressing) com sondagem linear e quadrática. As implementações suportam diferentes funções hash e estratégias de resolução de colisões.

## Arquitetura Geral

### Interface Principal
```java
public interface HashTable<T> {
    boolean isEmpty();
    boolean isFull();
    int capacity();
    int size();
    void insert(T element);
    void delete(T element);
    T search(T element);
    int indexOf(T element);
}
```

### Classe Base Abstrata
```java
public abstract class AbstractHashTable<T> implements HashTable<T> {
    protected Object[] table;
    protected int elements = 0;
    protected int collisions = 0;
    protected HashFunction<T> hashFunction;
}
```

## Estratégias de Endereçamento

### 1. Endereçamento Fechado (Closed Addressing)

#### Características
- Usa listas duplamente encadeadas para resolver colisões
- Cada posição da tabela contém uma lista encadeada
- Não há limite rígido de elementos por posição
- Suporte a funções hash por divisão e multiplicação

#### Estrutura
```java
public class HashTableClosedAddressImpl<T> extends AbstractHashTableClosedAddress<T> {
    // Tabela de listas encadeadas
    private DoublyLinkedList<T>[] table;
}
```

#### Operações Principais

**Inserção**
```java
public void insert(T element)
```
- Calcula o índice hash do elemento
- Se a posição estiver vazia, cria nova lista encadeada
- Se existir lista, verifica se elemento já existe (atualiza) ou adiciona no início
- Complexidade: O(1) caso médio, O(n) pior caso

**Busca**
```java
public T search(T element)
```
- Calcula o índice hash e busca na lista correspondente
- Complexidade: O(1) caso médio, O(n) pior caso

**Remoção**
```java
public void delete(T element)
```
- Localiza e remove da lista encadeada correspondente
- Remove a lista se ficar vazia
- Complexidade: O(1) caso médio, O(n) pior caso

### 2. Endereçamento Aberto - Sondagem Linear

#### Características
- Todos os elementos ficam na própria tabela
- Usa sondagem linear para resolver colisões: h(k,i) = (h'(k) + i) mod m
- Suporte a redimensionamento automático
- Marcação de elementos deletados

#### Estrutura
```java
public class HashTableOpenAddressLinearProbingImpl<T extends Storable> 
    extends AbstractHashTableOpenAddress<T> {
    // Tabela de elementos Storable
    private Storable[] table;
}
```

#### Operações Principais

**Inserção**
```java
public void insert(T element)
```
- Sondagem linear até encontrar posição vazia ou elemento igual
- Redimensiona tabela se necessário (dobra o tamanho)
- Complexidade: O(1) caso médio, O(n) pior caso

**Busca**
```java
public T search(T element)
```
- Sondagem linear até encontrar elemento ou posição vazia
- Complexidade: O(1) caso médio, O(n) pior caso

### 3. Endereçamento Aberto - Sondagem Quadrática

#### Características
- Usa sondagem quadrática: h(k,i) = (h'(k) + c1*i + c2*i²) mod m
- Reduz clustering primário comparado à sondagem linear
- Constantes c1 e c2 configuráveis (padrão: c1=1, c2=1)
- Suporte a redimensionamento automático

#### Estrutura
```java
public class HashTableOpenAddressQuadraticProbingImpl<T extends Storable> 
    extends AbstractHashTableOpenAddress<T> {
    private final int c1; // Constante linear
    private final int c2; // Constante quadrática
}
```

#### Operações Principais
- Similares à sondagem linear, mas com função de sondagem quadrática
- Pode falhar em encontrar posição mesmo com espaços disponíveis
- Lança `ProbingFailedException` quando não consegue inserir

## Funções Hash Suportadas

### 1. Método da Divisão
```java
public class HashFunctionDivision<T> {
    public int hash(T element) {
        return Math.abs(element.hashCode() % tableSize);
    }
}
```

### 2. Método da Multiplicação
```java
public class HashFunctionMultiplication<T> {
    public int hash(T element) {
        // Implementa método da multiplicação com constante A
    }
}
```

## Uso Prático

### Endereçamento Fechado
```java
// Criando hashtable com endereçamento fechado
HashTableClosedAddressImpl<String> hashTable = 
    new HashTableClosedAddressImpl<>(
        HashFunctionClosedAddressMethodEnum.DIVISION, 
        10
    );

// Inserindo elementos
hashTable.insert("elemento1");
hashTable.insert("elemento2");

// Buscando
String resultado = hashTable.search("elemento1");

// Removendo
hashTable.delete("elemento1");
```

### Endereçamento Aberto - Linear
```java
// Criando hashtable com sondagem linear
HashTableOpenAddressLinearProbingImpl<CustomStorable> hashTable = 
    new HashTableOpenAddressLinearProbingImpl<>(
        10, 
        HashFunctionClosedAddressMethodEnum.DIVISION,
        true // habilita redimensionamento
    );

// Operações similares ao endereçamento fechado
```

### Endereçamento Aberto - Quadrático
```java
// Criando hashtable com sondagem quadrática
HashTableOpenAddressQuadraticProbingImpl<CustomStorable> hashTable = 
    new HashTableOpenAddressQuadraticProbingImpl<>(
        10,
        HashFunctionClosedAddressMethodEnum.DIVISION,
        1, // c1
        1, // c2
        true // habilita redimensionamento
    );
```

## Complexidade das Operações

### Endereçamento Fechado
| Operação | Caso Médio | Pior Caso |
|----------|------------|-----------|
| Inserção | O(1)       | O(n)      |
| Busca    | O(1)       | O(n)      |
| Remoção  | O(1)       | O(n)      |

### Endereçamento Aberto
| Operação | Caso Médio | Pior Caso |
|----------|------------|-----------|
| Inserção | O(1)       | O(n)      |
| Busca    | O(1)       | O(n)      |
| Remoção  | O(1)       | O(n)      |

## Vantagens e Desvantagens

### Endereçamento Fechado
**Vantagens:**
- Nunca fica "cheio" (pode sempre inserir)
- Remoção simples
- Performance estável com alta taxa de ocupação

**Desvantagens:**
- Overhead de memória das listas encadeadas
- Cache locality ruim
- Fragmentação de memória

### Endereçamento Aberto - Linear
**Vantagens:**
- Boa cache locality
- Uso eficiente de memória
- Implementação simples

**Desvantagens:**
- Clustering primário
- Performance degrada com alta ocupação
- Remoção complexa (lazy deletion)

### Endereçamento Aberto - Quadrático
**Vantagens:**
- Reduz clustering primário
- Melhor distribuição que sondagem linear
- Boa cache locality

**Desvantagens:**
- Pode não encontrar posição mesmo com espaços livres
- Clustering secundário
- Implementação mais complexa

## Aplicações Práticas

- **Caches**: Armazenamento rápido de dados frequentemente acessados
- **Índices de Banco de Dados**: Acesso rápido a registros
- **Compiladores**: Tabelas de símbolos
- **Sistemas Distribuídos**: Consistent hashing
- **Estruturas de Dados**: Implementação de sets e maps

## Considerações de Performance

1. **Fator de Carga**: Manter α < 0.75 para boa performance
2. **Função Hash**: Escolher função que distribua uniformemente
3. **Redimensionamento**: Implementar estratégia adequada de crescimento
4. **Resolução de Colisões**: Escolher estratégia baseada no padrão de uso

## Possíveis Melhorias

1. **Robin Hood Hashing**: Minimizar variância nos tempos de busca
2. **Cuckoo Hashing**: Garantir O(1) no pior caso para busca
3. **Consistent Hashing**: Para sistemas distribuídos
4. **Thread Safety**: Implementações concorrentes
5. **Funções Hash Criptográficas**: Para aplicações sensíveis à segurança