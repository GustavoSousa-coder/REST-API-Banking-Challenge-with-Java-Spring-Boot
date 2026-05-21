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

**Versão Atual:** 1.5.0 (Regras de Negócio Bancário e Validações de Conta)

**Descrição:** Nessa versão implementamos regras de negócio reais por tipo de conta, corrigimos falhas de lógica no fluxo de transações e fortalecemos as validações de criação de contas seguindo padrões do mercado financeiro.

### Principais Melhorias desta Versão:

**Limite de Contas por Cliente**
Um cliente agora pode ter no máximo duas contas — uma corrente e uma poupança. Validação implementada no `AccountService` verificando quantidade e tipo antes de persistir, lançando `Conflict` em caso de violação.

**Rich Domain Model na Entidade Account**
A entidade `Account` passou a encapsular suas próprias regras de negócio seguindo o padrão de modelo de domínio rico. Dois métodos foram adicionados diretamente no model: `executeWithdrawalCorrente` e `executeWithdrawalPoupanca`, cada um com suas regras específicas.

**Regras por Tipo de Conta**
Conta corrente considera `balance + overdraftLimit` para validar se o débito é permitido, habilitando o uso do cheque especial. Conta poupança limita a 6 transferências de saída mensais com reset automático baseado em `lastWithdrawalReset`, sem depender de agendamento externo.

**Correção do Fluxo de Transação**
As contas remetente e receptora agora são persistidas após a movimentação via `accountRepository.save()`, garantindo que os saldos atualizados e o contador de saques da poupança sejam refletidos no banco de dados.

**Correção do findAllByClientId**
O método que buscava todas as contas independente do cliente foi corrigido para filtrar corretamente pelo UUID do cliente usando `findByClientUuid` no repository, retornando apenas as contas do cliente informado.

---

## Próximas Etapas
- **Estatísticas:** Melhorar precisão financeira com BigDecimal e filtrar por cliente autenticado.
- **Funcionalidades:** Extrato por período, limite diário de transações.
- **Segurança:** Rate limiting no endpoint de login contra ataques de força bruta.
- **Qualidade:** Cobertura de testes unitários nos services.
- **Documentação:** Refinamento do Swagger/OpenAPI
