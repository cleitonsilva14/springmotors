# springmotors


A anotação @ElementCollection em Java é usada para mapear coleções de elementos embutidos em uma entidade, o que significa que esses elementos não possuem identidade própria e são armazenados na mesma tabela ou em uma tabela separada. No seu exemplo específico, você está mapeando uma lista de URLs de fotos (List<String> fotos_url) como uma coleção de elementos.

```java
@ElementCollection
@CollectionTable(
        name = "tb_fotos_carro",
        joinColumns = @JoinColumn(name = "foto_id")
)
@Column(name = "fotos_url")
private List<String> fotos_url;
```