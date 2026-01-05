# REST-API-Banking-Challenge-with-Java-Spring-Boot
Este projeto consiste no desenvolvimento evolutivo de um sistema bancário, originado a partir de um desafio técnico para gestão de transações financeiras. O objetivo central é a implementação de uma API REST de alta performance, utilizando o ecossistema moderno do Java e Spring Boot.

# Sobre o Projeto - Bank Transaction API (Simulação Bancária)

A aplicação foi inicialmente concebida como uma solução para um desafio técnico focado em processamento de estatísticas e transações em tempo real.
Identificando o potencial de expansão,
o projeto evoluirá para uma arquitetura mais robusta,
indo além do escopo inicial para implementar padrões rigorosos de Clean Code,
segurança na manipulação de dados e regras de negócio complexas,
alinhadas às exigências atuais do mercado financeiro.

# Detalhes sobre o desafio técnico (Desenvolvido inicialmente)

Na fase inicial do desafio, a aplicação foi desenvolvida sob premissas específicas para testar a lógica de gerenciamento de dados:
    **Persistência:** Implementação de banco de dados simulado em memória (In-memory storage).
    **Arquitetura:** Estrutura simplificada focada em lógica de serviço, evoluindo gradualmente para padrões com Entidades e Mappers e testes.
    **Estatísticas em Tempo Real:** Processamento ágil de dados para geração de métricas instantâneas por periodo de tempo.


## Contexto Original (Desafio Técnico)
Este projeto iniciou-se como base para a resolução de um desafio técnico de mercado.

**Objetivo do Desafio:**
Desenvolver uma API REST que recebe Transações e retorna Estatísticas sobre transações por periodo de tempo:
1. A API deve ser desenvolvida em Java ou Kotlin usando Spring boot.
2. A API não deve conter banco de dados como MySql e afins e simulação de banco de dados como o H2.
3. A API deve ter três end points que são: POST /transacao, DELETE /transacao e GET /estatistica.
4. A API deve aceitar e responder com JSON.
5. A API deve ter um tempo para processar as estatisticas

*Para ver o escopo completo e original do desafio, consulte o arquivo [docs/escopo-do-desafio-Itau.md](./docs/escopo-do-desafio-Itau.md).*


## Status do Projeto
**Versão Atual:** 1.0.0 (MVP)
> Como menciondao antes a versão 1.0.0 se trata ainda da aplicação seguindo o escopo disposto em [docs/escopo-do-desafio-Itau.md](./docs/escopo-do-desafio-Itau.md) 
> onde se trata de uma versão ainda limitada e focada apenas na lógica de serviço,
> em cada commit terá uma nova funcionalidade e descrição do que foi feito e preparo para avnçar mais com o tempo.

---

## Evolução e Melhorias (Portfólio)
*Esta seção descreve as melhorias implementadas ALÉM do escopo original do desafio.*

> Na versão atual do projeto foi contém a lógica anterior e inicial ainda próximo do escopo do desafio, no entanto,
> foram adicionadas melhorias significativas e essenciais em relação a engenharia e a boa base da aplicação,
> como separar devidamente as camadas de entidade e dto, implementação de mapeadores (mappers) para conversão entre essas camadas,
> esse tratamento é fundamental para melhor gerenciar os dados de forma segura e eficiente mantendo a integridade dos dados.
> além disso cria uma base sólida para futuras expansões como o próximo passo, que é separar a entidade cliente e conta,
> o próximo passo é separar o cliente que é criado no banco da sua conta podendo ele ter uma conta PJ ou Fisica, aproximando mais do que é visto no mercado profissional,
> essa lógica mentém o modelo de boas práticas e o otimos gerenciamento de dados.

Atualmente, o projeto conta com:
- [x] Estrutura base da API (Controller, Service, Exceptions)
- [x] Entity, DTO, mapper, configurations
- [ ] Implementação de Docker (Em breve)
- [ ] Autenticação com Spring Security (Em breve)
- [ ] Testes unitários (Em breve)
- [x] Documentação Swagger
- [ ] Adição de uma camada relacionada a conta bancária separando o cliente e a conta (Em brave)

---

## Tecnologias
- Java 25
- Spring Boot
- Spring doc (Swagger)
- Maven
