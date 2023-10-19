Server Sent Events(SSE)

Server Sent Events(SSE) é uma tecnologia, que permite enviar notificação de um servidor para um cliente via conexão HTTP. 
O trafego de notificações é unidirecional ou seja somente o servidor podem enviar notificações. 
É uma boa alternativa para evitar overhead de pollings, pois cliente recebe atualização da notificação quando ocorre mudança do seu estado. Com isso é possível evitar processamento desnecessários. 

quarkus-sse-producer-sample: exemplo de uma aplicação produtora de eventos (SSE). 
quarkus-sse-consumer-sample: exemplo de uma aplicação consumidora de eventos (SSE).
