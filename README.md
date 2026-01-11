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
*Para ver o escopo completo e original do desafio, consulte o arquivo [docs/escopo-do-desafio-Itau.md](./docs/escopo-do-desafio-Itau.md).*

O objetivo inicial era criar uma API REST capaz de:
- Receber transações financeiras via endpoint POST `/transactions`.
- Calcular estatísticas em tempo real (soma, média, máximo, mínimo e cont
- agem) para transações ocorridas nos últimos 60 segundos via endpoint GET `/statistics`.
- Gerenciar transações antigas (mais de 60 segundos) retornando o status HTTP 204 (No Content).

## Status do Projeto

**Versão Atual:** 1.1.0 (MVP)

**Descrição:** A Versão 1.1.0 do projeto já se difere do escopo original do desafio,
incorporando melhorias significativas na estrutura do código e na organização dos dados, nessa versão foi adicionado uma nova camada comum no mercado,
essa camada separando a entidade client de account o que foi fundamental muito comum onde vemos a separação correta de responsabilidades,
para que siga a lógica comum onde em certos casos um cliente pode ter uma ou mais contas de diferentes tipos,
além disso para melhorar na criação de dados foi adicionado uma camada de cadastro unico onde o foco é que o cliente preencha um formulário uma unica vez e comummente no mercado a que o próprio sistema gerar a conta bancária,
essa camada conta com a geração de conta e cliente no banco de dados de forma simples.
para melhor performace e organização o código gera primeiramente o cliente e depois a conta vinculada a esse cliente.
essa camada de Onboarding que é onde ocorre o cadastro do cliente e a geração da conta bancaria foi fundamental para melhorar a organização do código e seguir boas práticas de desenvolvimento.
além de conter as regras de segurança para garantir a integridade dos dados do cliente e da conta bancaria, evitando usar diretamente a entidade nos mappers dedicados a levar os dados, outro ponto crucial foi adicionar uma geração de resposta da criação, onde confirmamos que o objeto foi devidamente criado.
embora ainda há falhas notavei e ainda não implementadas, o projeto ainda está e desenvolvimento ativo,
caso esta versão tenha falhas de segurança ou falhas na documentação, essas serão corrigidas nas próximas versões.

## Próximas Etapas
**:** Nas próximas versões, o projeto buscará implementar:
-Ligação e relacionamento entre clientes e contas bancárias.
-Validação de idade mínima para abertura de conta.
-Modelo de senha mais proximo ao mercado financeiro.
-Melhor tratamento de erros e exceções que atenderão aos padrões RESTful e a toda a api.
-geração natural e comum no mercado sobre os dados da conta bancária.
-melhoria na regra de negócio para garantir que o sistema esteja alinhado com as práticas do mercado financeiro.
-refatoração de afinamento das pendencias do projeto.
-melhoria na lógica das transações que irão vir juntas com o relacionamento de clientes e contas.

**OBS**: as descrições de implementações futuras são sugestões e podem ser ajustadas conforme o desenvolvimento avança e novas necessidades surgem, podem haver mais coisas a serem adicionada, que estarão na descrição da versão atual da próxima versão.

---

Atualmente, o projeto conta com:
- [x] Pacote de configuração do Spring Boot.
- [x] Controllers con endpoints RESTful para Account, Client, Onboarding, Statistics e transactions.
- [x] Estrutura de DTOs (Data Transfer Objects) para transferência de dados contando com request e responses.
- [x] Exeptions customizadas para tratamento de erros.
- [x] Mappers manuais para conversão entre entidades e DTOs além de converter de request para request em um mapper Onboarding.
- [x] Model contendo entidades Account, Client e Transaction.
- [x] Enums contendo opções de tipos de dados.
- [x] Repository focado na lógica de armazenamento em memória.
- [x] Services contendo a lógica de negócio para Account, Client, Onboarding, Statistics e Transactions.
- [x] Documentação da API utilizando Spring doc (Swagger).

---

## Tecnologias
- Java 25
- Spring Boot
- Spring doc (Swagger)
- Maven
