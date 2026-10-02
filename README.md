🏥 API de Prontuário Médico (Atendimento de Emergência)
Status: 🚧 Em Desenvolvimento (WIP)

API REST desenvolvida em Java com Spring Boot para digitalização e gestão de Fichas de Atendimento pré-hospitalar e emergencial. O sistema permite o registro detalhado de pacientes, triagem de sinais vitais (PA, FC, Temperatura, O2), controle de lesões e acompanhamento de intervenções e medicações aplicadas durante o transporte/atendimento.

🚀 Arquitetura e Destaques Técnicos (Até o momento):

Modelagem de Domínio: Mapeamento de entidades complexas focadas na regra de negócio médica utilizando anotações JPA.

Persistência de Dados: Configuração de interfaces JpaRepository do Spring Data para abstração das transações com o banco de dados.

Consultas Customizadas: Criação de query methods (como findByIdentificacao) para buscas ágeis de prontuários.

📍 Roadmap de Desenvolvimento (To-Do):

[x] Estruturação inicial do projeto Spring Boot

[x] Modelagem da Entidade FichaAtendimento (JPA/Hibernate)

[x] Criação da camada de Repository (Spring Data JPA)

[ ] Implementação da camada de Service (Regras de negócio)

[ ] Criação da camada de Controller (Endpoints RESTful)

[ ] Validação de dados (Bean Validation)

[ ] Documentação da API com Swagger/OpenAPI

🛠️ Tecnologias Utilizadas:

Java 17+

Spring Boot

Spring Data JPA / Hibernate

Banco de Dados Relacional (MySQL/PostgreSQL)
