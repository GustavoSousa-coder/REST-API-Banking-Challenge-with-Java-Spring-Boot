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

**Versão Atual:** 1.3.0 (Refatoração de Domínio e Arquitetura)

**Descrição:** Esta versão marca uma transição crítica no projeto, focada na robustez arquitetural e na segurança do domínio. O código foi integralmente refatorado para garantir que a lógica de negócio seja o coração da aplicação, tornando-a legível, segura e pronta para escalabilidade.

### Principais Melhorias desta Versão:

- **Refatoração de Entidades e DTOs:** Simplificação completa das classes de dados, removendo verbosidade e abrindo caminho para lógicas mais robustas. A estrutura agora segue padrões de Clean Code, facilitando a manutenção.
- **Domínio Rico e Imutabilidade:** O uso indiscriminado de métodos `Set` foi descontinuado em favor de uma abordagem mais responsável. Implementamos métodos de negócio específicos que protegem o estado da entidade, garantindo que o objeto seja sempre consistente e seguro contra manipulações indevidas.
- **Nova Arquitetura de Exceções RESTful:** Toda a camada de tratamento de erros foi redesenhada. Implementamos exceções personalizadas como `NotFoundException` e `ConflictException`, permitindo que a API responda com os Status Codes adequados (404, 409, 422, 403), tornando a comunicação com o cliente mais eficiente e clara.
- **Regras de Negócio Avançadas:**
    - **Validação de Cadastro:** Implementação de lógicas para verificação de idade mínima e validação rigorosa de CPF.
    - **Controle de Status:** Introdução de verificações de estado (Active/Inactive) para Clientes e Contas, bloqueando operações financeiras caso os requisitos do sistema não sejam atendidos.
- **Relacionamentos e Chaves:** Otimização dos relacionamentos JPA (1:N) e implementação de chaves de endereçamento (`AddressKey`) para transferências, aproximando a lógica ao funcionamento real de um sistema de pagamentos.

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
