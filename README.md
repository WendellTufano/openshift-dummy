
# DummyJSON Client - Java 17 e Spring Boot 3.2.5

## Execução do projeto com docker

- Para criar a docker image do projeto:
```docker build -t "dummyjson-client-henriquew" .```

- Para executar a imagem:
```docker run -p 8080:8080 "dummyjson-client-henriquew"```

- Para exportar a imagem em arquivo tar:
```docker save -o "dummyjson-client-container-henriquew" "dummyjson-client-henriquew"```

## Apis
- localhost:8080/actuator/health
- localhost:8080/api/products
- localhost:8080/api/products/1
