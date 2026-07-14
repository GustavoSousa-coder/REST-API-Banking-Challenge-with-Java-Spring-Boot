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

**Versão Atual:** 1.6 (Adição de nova geração de transações via cartão, e gerção de um cartão virtual quando o cliente desejar)

**Descrição:** 
Nessa Atualização houveram mudanças significativas na estrutura do projeto,
como a simplificação do tipo de conta, como este repositório tem cunho de desafiio de demonstração de habilidades não existe necessidade de uma vasta estrutura nisso retirei o accountType para que o client etenha uma unica conta,
o foco não é aproximação do mercado real quando refiro a simplificação.
outra mudança significativa foi a adição de um novo endpoint que permite criar um cartão virtual para o cliente, e a geração de transações via cartão, que permite ao cliente gerar transações de forma simples.
O cartão é gerado automaticamente pela API contendo:

- Número do cartão;
- CVV;
- Data de validade;
- Titular;
- Status de ativação;
- Conta vinculada.

A criação do cartão é realizada pelo sistema, evitando que o usuário informe manualmente dados sensíveis.

outra mudança foi a alterção do nome da chave de endereço de transferência que agora referece a Pix para diferenciar do outro metodo de transferência card.


---

## Próximas Etapas finais do projeto
- **Qualidade:** Cobertura de testes unitários nos services.
- **Documentação:** Refinamento do Swagger/OpenAPI.