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

**Versão Atual:** 1.5.1 (Refatoração de Estatísticas e Consistência de DTOs)

**Descrição:** Versão de refatoração focada em corrigir inconsistências nos DTOs, melhorar a precisão financeira das estatísticas e alinhar o fluxo de dados entre as camadas da aplicação.

### Principais Melhorias desta Versão:

**Precisão Financeira nas Estatísticas**
Substituição do `DoubleSummaryStatistics` por cálculos manuais com `BigDecimal`, eliminando erros de arredondamento em valores financeiros. As operações de soma, média, mínimo e máximo agora usam `reduce`, `min` e `max` do Stream API com `BigDecimal::compareTo`.

**StatisticsResponseDTO migrado para Record**
O DTO de estatísticas foi convertido para record, alinhando com o padrão já adotado nos demais DTOs da aplicação e eliminando getters, setters e construtores manuais desnecessários.

**Resposta 204 para Estatísticas Vazias**
Quando não há transações no período consultado a API agora retorna `204 No Content` em vez de um objeto vazio. O service retorna `Optional<StatisticsResponseDTO>` e o controller usa `ResponseEntity.of()` para tratar os dois casos automaticamente.

**Correção do Retorno de Transações por Período**
O repository `findRecentTransactions` foi corrigido para retornar `List<Transaction>` em vez de `List<TransactionResponseDTO>`, respeitando a separação de camadas. A conversão para DTO agora acontece no service via mapper.

---

## Próximas Etapas
- **Estatísticas:** Filtrar por cliente autenticado com dados personalizados por período.
- **Funcionalidades:** Extrato por período, limite diário de transações.
- **Segurança:** Rate limiting no endpoint de login contra ataques de força bruta.
- **Qualidade:** Cobertura de testes unitários nos services.
- **Documentação:** Refinamento do Swagger/OpenAPI.