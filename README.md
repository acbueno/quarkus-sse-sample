## Exemplo de Server-Sent Events (SSE) com Quarkus

O Server-Sent Events (SSE) é uma tecnologia de comunicação web que permite que o servidor envie dados de forma assíncrona para o cliente. É uma alternativa ao uso de WebSockets quando a comunicação bidirecional não é necessária e o servidor precisa apenas enviar dados para o cliente.

No contexto do Quarkus, um framework Java para aplicações nativas da nuvem, podemos implementar tanto o lado do servidor (producer) quanto o lado do cliente (consumer) para lidar com eventos SSE.

O projeto `quarkus-sse-sample` contém dois módulos:

1. `quarkus-sse-consumer-sample`: Demonstração de um cliente SSE que consome eventos SSE de um servidor. Este cliente se conecta a um endpoint SSE (`/events/stream`) e exibe os eventos recebidos no console.

2. `quarkus-sse-producer-sample`: Demonstração de um servidor SSE que produz eventos SSE para clientes. Este servidor possui um endpoint SSE (`/events/stream`) que emite eventos periodicamente para os clientes conectados.

Você pode encontrar os códigos-fonte e instruções de uso nos links abaixo:

- Cliente SSE (consumer): [quarkus-sse-consumer-sample](https://github.com/acbueno/quarkus-sse-sample/tree/main/quarkus-sse-consumer-sample)
- Servidor SSE (producer): [quarkus-sse-producer-sample](https://github.com/acbueno/quarkus-sse-sample/tree/main/quarkus-sse-producer-sample)

Esses projetos são exemplos práticos de como implementar comunicação SSE em aplicações Quarkus. Você pode usá-los como referência para criar seus próprios clientes e servidores SSE.
