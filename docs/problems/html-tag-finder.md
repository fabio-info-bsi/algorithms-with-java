# Analisador de Profundidade de Tags HTML

## Descrição
Este algoritmo analisa um documento HTML para encontrar a tag mais profunda na estrutura do documento. Ele utiliza expressões regulares e recursão para construir uma árvore de tags e determinar qual tag está no nível mais profundo da hierarquia.

## Estrutura de Dados

### Classe Tag
```java
static class Tag {
    String name;      // Nome da tag
    String val;       // Conteúdo da tag
    int level;        // Nível de profundidade
    List<Tag> childrenTag;  // Tags filhas
}
```

## Componentes Principais

### 1. Leitura de HTML
```java
private static String requestByUrl(String url)
```
- Faz requisição HTTP para obter o conteúdo HTML
- Lê a resposta usando BufferedReader
- Retorna o conteúdo como string

### 2. Parsing de HTML
```java
private static List<Tag> readStringHtml(final String html)
```
- Usa expressão regular para identificar tags
- Constrói a árvore de tags recursivamente
- Mantém controle do nível de profundidade
- Regex utilizada: `<(\\w+)[^>]*>(.*?)</?\\1>`

### 3. Busca da Tag Mais Profunda
```java
private static Tag findTagMoreDeep(Tag root)
```
- Percorre a árvore de tags recursivamente
- Compara níveis de profundidade
- Retorna a tag mais profunda encontrada

## Funcionamento

1. **Requisição do HTML**
   - Faz download do conteúdo HTML da URL
   - Remove espaços e quebras de linha

2. **Construção da Árvore**
   - Identifica tags usando regex
   - Cria objetos Tag para cada tag encontrada
   - Estabelece relacionamentos pai-filho
   - Atribui níveis de profundidade

3. **Busca da Tag Mais Profunda**
   - Percorre a árvore recursivamente
   - Mantém registro da tag mais profunda
   - Compara níveis durante a travessia

## Uso

```java
// Exemplo de uso básico
String url = "http://exemplo.com/pagina.html";
String response = requestByUrl(url);
response = response.replaceAll("\\r\\n|\\r|\\n", "");
Tag rootTag = readStringHtmltoTag(response);
Tag tagMaisProfunda = findTagMoreDeep(rootTag);

// Acessando informações da tag
System.out.println("Tag: " + tagMaisProfunda.name);
System.out.println("Nível: " + tagMaisProfunda.level);
System.out.println("Valor: " + tagMaisProfunda.val);
```

## Características

### Vantagens
- Análise recursiva eficiente
- Mantém estrutura hierárquica completa
- Suporte a tags aninhadas
- Fácil extensão para análises adicionais

### Limitações
- Sensível à formatação do HTML
- Pode ter problemas com HTML mal formado
- Uso de memória proporcional à profundidade

## Complexidade

- **Tempo**: O(n), onde n é o número de tags
- **Espaço**: O(d), onde d é a profundidade máxima da árvore

## Possíveis Melhorias

1. **Robustez**
   - Melhor tratamento de HTML mal formado
   - Suporte a comentários HTML
   - Tratamento de tags auto-fecháveis

2. **Performance**
   - Cache de resultados
   - Parsing paralelo para documentos grandes
   - Otimização da expressão regular

3. **Funcionalidades**
   - Busca por atributos específicos
   - Filtros de tags
   - Estatísticas de profundidade

## Aplicações Práticas

- Análise de estrutura de documentos HTML
- Validação de hierarquia de tags
- Identificação de problemas de formatação
- Extração de conteúdo estruturado
- Análise de SEO