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

**Versão Atual:** 1.3.2 (Melhorias com gerenciamento com banco de dados e segurança)

**Descrição:** Nessa versão adicionamos a camada de segurança, gerenciamento e versionamento com o flyway, que tanto nos abre caminho para a implementação de autenticação JWT, quanto para a melhoria da performance e integridade dos dados, com a adoção de UUIDs binários e precisão decimal para campos financeiros.

### Principais Melhorias desta Versão:

Segurança, Persistência e Integridade de Dados (Refatoração de Infraestrutura)
Nesta etapa, consolidamos a base de segurança e a arquitetura de dados da API, garantindo que a comunicação entre o Java (Hibernate) e o MySQL seja performática e à prova de falhas, preparando o terreno para a autenticação JWT.

Versionamento de Banco de Dados com Flyway: Implementação de migrações automatizadas (V1 e V2). A estrutura do banco agora é versionada, permitindo um ambiente de desenvolvimento replicável e consistente, com carga inicial de dados (Seed) automatizada.

Otimização de Performance com UUID (Binary16): Refatoração completa da estratégia de identificadores. Substituímos Strings por BINARY(16) no MySQL, alinhando a performance nativa do banco com o padrão do Hibernate 6, reduzindo o consumo de armazenamento e acelerando a indexação de chaves primárias e estrangeiras.

Integridade Financeira com Precisão Decimal: Ajuste rigoroso dos campos monetários (balance e overdraft_limit). Utilizamos BigDecimal no Java e DECIMAL(19,2) no SQL para eliminar erros de arredondamento comuns em tipos de ponto flutuante, garantindo precisão absoluta em transações bancárias.

Arquitetura Stateless & Clean Code: Configuração inicial do SecurityFilterChain focada em APIs REST, desabilitando CSRF e sessões de estado, mantendo o compromisso com o encapsulamento e a imutabilidade dos objetos de domínio.
---

## Próximas Etapas
Com a base de domínio consolidada, os próximos passos focam na infraestrutura e segurança externa:
- **Segurança:** Implementação autenticação via JWT (Stateless).
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
