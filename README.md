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

**Versão Atual:** 1.5.2 (Adição de novas formas de Abstrair extratos por um período de tempo personalizado)

**Descrição:** 
Essa versão introduz melhorias na forma de extrair extratos ou históricos de transações, permitindo que o cliente possa extrair usando o filtro de segundos, dias ou até messes.

### Principais Melhorias desta Versão:

Adição de um novo enumerate `TimeUnitType` para definir as unidades de tempo disponíveis para filtragem de transações.

implementação de um novo endpoint `"/{accountId}/personalise"` que permite a extração de transações com base em um período de tempo personalizado, utilizando o `TimeUnitType` para especificar a unidade de tempo desejada.

---

## Próximas Etapas
- **Novas Funcionalidades:** novas funcionalidades virão juntamente com o desenvolvimento do aplicativo no qual consumirá a API, como a completa implementação e uso das estatisticas e de metodos gerados.
- **Qualidade:** Cobertura de testes unitários nos services.
- **Documentação:** Refinamento do Swagger/OpenAPI.