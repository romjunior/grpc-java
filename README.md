# Grpc Java
>Projeto de aprendizado do protocolo GRPC

## Para executar o projeto: 

1. Gere o código GRPC no projeto
```
./gradlew generateProto
```

2. Execute as classes do Server e Client que desejar.

## Executando com TLS ativado

Só descomentar o seguinte trecho de código do ServerMain e comentar o comum:
```java
ServerCredentials creds = TlsServerCredentials.create(new File("ssl/server.crt"), new File("ssl/server.pem"));
        Server server = Grpc.newServerBuilderForPort(50051, creds)
                .addService(new GreetServiceImpl())
                .addService(new SumServiceImpl())
                .addService(ProtoReflectionService.newInstance())
                .build();
        server.start();
```

No GreetingClientMain decomentar o seguinte trecho e comentar o do client:
```java
ChannelCredentials creds = TlsChannelCredentials.newBuilder()
                .trustManager(new File("ssl/ca.crt"))
                .build();

        ManagedChannel channel = Grpc.newChannelBuilder("localhost:50051",  creds)
                .build();
```
### Erro de certificação inválido ou expirado 

Se der erro de certificado inválido ou expirado, pode se criar um novo utilizando os seguintes comandos na pasta ssl:
```bash
openssl genrsa -passout pass:1111 -des3 --out ca.key 4096

openssl req -passin pass:1111 -new -x509 -days 1100 -key ca.key -out ca.crt --subj "/CN=localhost"

openssl genrsa --passout pass:1111 -des3 -out server.key 4096

openssl req -passin pass:1111 -new -key server.key -out server.csr -subj "/CN=localhost"

openssl x509 -req -passin pass:1111 -days 1100 -in server.csr -CA ca.crt -CAkey ca.key -set_serial 01 -out server.crt

openssl pkcs8 -topk8 -nocrypt -passin pass:1111 -in server.key -out server.pem
```

## Mongodb

A configuração do banco está no docker-compose.yml na raiz do projeto, é necessário a instalação do docker/docker compose:

1. Criação do caminho `/data/db` por que essa config faz o bind do container com o host
2. executar o `docker compose up` para subir o container e `docker compose down` para baixar. 

## Ferramentas

* Java 17.0.2
* GRPC 1.5.2
* MongoDB 5.0.11