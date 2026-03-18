# REST-API-Banking-Challenge-with-Java-Spring-Boot
Este projeto consiste no desenvolvimento evolutivo de um sistema bancário, originado a partir de um desafio técnico para gestão de transações financeiras. O objetivo central é a implementação de uma API REST de alta performance, utilizando o ecossistema moderno do Java e Spring Boot.

# Sobre o Projeto - Bank Transaction API (Simulação Bancária)

A aplicação foi inicialmente concebida como uma solução para um desafio técnico focado em processamento de estatísticas e transações em tempo real. Identificando o potencial de expansão, o projeto evoluiu para uma arquitetura robusta, aplicando padrões rigorosos de Clean Code, imutabilidade e regras de negócio complexas, alinhadas às exigências do mercado financeiro.

# Detalhes sobre o desafio técnico (Fase Inicial)

Na fase inicial, a aplicação foi desenvolvida sob premissas específicas para testar a lógica de gerenciamento de dados:
- **Persistência:** Implementação de banco de dados simulado em memória (In-memory storage).
- **Arquitetura:** Estrutura simplificada focada em lógica de serviço.
- **Estatísticas em Tempo Real:** Processamento ágil para geração de métricas instantâneas (últimos 60 segundos).

---

## Status do Projeto

**Versão Atual:** 1.3.1 (Melhorias com a segurança de senhas e criptografias de senhas)

**Descrição:** Essa versão mostra como foi adicionado novos recursos sobre gerenciamento de senhas e suas respectivas seguranças, nessa versão o sistema trata a senha com segurança criptografando na criação de um novo cliente(usuário do sistema).

### Principais Melhorias desta Versão:

Segurança e Integridade de Dados (Refatoração de Credenciais)

Nesta etapa, o foco foi a implementação da base de segurança da API, preparando o terreno para a autenticação robusta com JWT.

Hashing de Alta Performance: Implementação do BCrypt para tratamento de senhas. O uso de Salt automático garante que, mesmo que o banco de dados seja comprometido, as senhas permaneçam ilegíveis e seguras contra ataques de força bruta.

Arquitetura Orientada à Segurança: A criptografia foi integrada diretamente à camada de Mapping. Ao converter um DTO em Entidade, a senha é hasheada instantaneamente. Isso garante que a entidade de domínio nunca "toque" na memória com a senha em texto plano, eliminando riscos de vazamento em logs ou estados inconsistentes.

Spring Security & Stateless: Configuração do SecurityFilterChain com política Stateless, desabilitando proteções desnecessárias para APIs REST (como CSRF) e preparando o sistema para o fluxo de tokens JWT.

Clean Code & Encapsulamento: Mantive o compromisso de não utilizar Setters. A senha protegida entra na entidade via Builder, respeitando a imutabilidade do objeto de domínio.
---

## Próximas Etapas
Com a base de domínio consolidada, os próximos passos focam na infraestrutura e segurança externa:
- **Persistência e Evolução de Banco:** Integração do Flyway para versionamento de base de dados.
- **Segurança:** Implementação de criptografia de senhas e autenticação via JWT (Stateless).
- **Qualidade:** Cobertura de testes unitários para as lógicas de serviço e domínio.
- **Documentação:** Refinamento da documentação via Swagger/OpenAPI.

---

## Tecnologias e Recursos Atuais
- **Java 25 / Spring Boot 3+**
- **Lombok:** Utilização estratégica de `@Builder` e `@Getter` para imutabilidade.
- **Jakarta Persistence (JPA):** Modelagem de relacionamentos complexos.
- **Bean Validation:** Validação de payloads de entrada.
- **Exceções Customizadas:** Handler global para respostas padronizadas.
- **Mappers Manuais:** Conversão controlada entre Entidades e DTOs.
