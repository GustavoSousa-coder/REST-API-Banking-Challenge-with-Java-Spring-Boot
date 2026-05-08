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

**Versão Atual:** 1.4.0 (Autenticação JWT e Fortalecimento de Segurança)

**Descrição:** Nessa versão implementamos autenticação stateless via JWT com Spring Security, fortalecemos as validações de entrada com anotações customizadas e reorganizamos responsabilidades entre as camadas da aplicação.

### Principais Melhorias desta Versão:

**Autenticação JWT com Spring Security**
Implementação completa do fluxo de autenticação stateless. O cliente se autentica via email e senha, recebe um token JWT assinado com HMAC256 e o utiliza nas requisições subsequentes. O token carrega a identidade e as permissões do usuário, eliminando a necessidade de sessão no servidor.

**Autorização por Roles**
Controle de acesso granular por perfil com `ROLE_CLIENT` e `ROLE_ADMIN`. Endpoints sensíveis como listagem global de clientes e estatísticas são restritos ao administrador, enquanto operações bancárias do próprio cliente exigem autenticação com perfil CLIENT.

**Validação Customizada de CPF**
Implementação de annotation customizada `@ValidCpf` com validação matemática completa dos dígitos verificadores seguindo o algoritmo da Receita Federal, rejeitando CPFs sintaticamente corretos mas matematicamente inválidos.

**Fortalecimento das Validações de Entrada**
Adição de `@NotBlank`, `@Email`, `@Past`, `@Size` e `@Pattern` nos DTOs de cadastro. Validação de senha com regex exigindo caracteres maiúsculos, minúsculos, números e especiais. Inclusão do `spring-boot-starter-validation` para ativação do Bean Validation.

**Reorganização de Responsabilidades**
Movimentação da criptografia BCrypt do Mapper para o Service, alinhando a lógica de segurança à camada correta. Separação entre `AuthenticationService` (orquestra o login), `UserDetailsServiceImpl` (contrato do Spring Security) e `TokenService` (geração e validação do JWT).

**Integração do Client com UserDetails**
A entidade `Client` implementa `UserDetails` do Spring Security, expondo `getAuthorities()` baseado na role, `isEnabled()` vinculado ao `ClientStatus` e `isAccountNonLocked()` verificando status `BLOCKED` e `SUSPICIOUS`.

---

## Próximas Etapas
- **Funcionalidades:** Limite diário de transações, extrato por período, transferência atômica entre contas.
- **Segurança:** Rate limiting no endpoint de login contra ataques de força bruta.
- **Qualidade:** Cobertura de testes unitários nos services.
- **Documentação:** Refinamento do Swagger/OpenAPI e README final.
