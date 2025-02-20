# springmotors


```java
@ElementCollection
@CollectionTable(
        name = "tb_fotos_carro",
        joinColumns = @JoinColumn(name = "foto_id")
)
@Column(name = "fotos_url")
private List<String> fotos_url;
```