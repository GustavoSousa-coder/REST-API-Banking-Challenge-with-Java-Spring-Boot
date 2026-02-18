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

**Versão Atual:** 1.2.0 (MVP)

**Descrição:** A Versão 1.2.0, Nessa versão há pontos forte sobre o tratamento de dados e a organização do código, onde o foco foi melhorar a estrutura do projeto,
seguindo boas práticas de desenvolvimento e organização de código, além de implementar uma camada de cadastro único para clientes e contas bancárias,
melhorando a experiência do usuário e a eficiência do processo de criação de contas.

Primeiramente melhorei a estrutura do projeto organizando os pacotes de forma mais clara e que fosse fácil de ler,
por conta do crescimento das funcionalidades e adição de novas camadas.

Refatorando a maior parte do código, a melhor melhoria feita foi no relacionamento entre as enitdades como cliente com relacionamento com account 1:N,
entre account e transaction 1:N, além de melhorar o relacionamento durante o desenvolvimento e refatoração de transaction decidi chegar minimamente próximo ao mercado adicionando a função de poder criar uma chave de acesso para a transferência de dinheiro de uma conta para outra,
isso ajuda a identificar melhor quem está realizando a transferância e quem está recebendo, além de melhorar a lógica de captura de estatísticas deixando o código mais limpo,
foi implementado a verificação de idade mínima na abertura da conta, essa esnrte outras aplicações e regras de negócio foram implementadas focando na melhor performace.

Pendencias, Infelizmente não há implementação nessa versão sobre a parte de segurança e manipulação da senha,
além disso ainda há pendencia na documentação usando Swagger,
a faltam implementação sobre testes unitários.

próxima versão, o foco será a implementação e melhoria do modelo de senha,
além de melhorar o tratamento de erros e exceções que atenderão aos padrões RESTful e a toda a api, além de refatoração de afinamento das pendencias do projeto como o uso adequado de certas exceções,
além disso, a documentação usando Swagger e testes unitários serão implementados.

## Próximas Etapas
**:** Nas próximas versões, o projeto buscará implementar:
-Modelo de senha mais proximo ao mercado financeiro.
-Melhor tratamento de erros e exceções que atenderão aos padrões RESTful e a toda a api.
-refatoração de afinamento das pendencias do projeto como o uso adequado de certas exceções.

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
