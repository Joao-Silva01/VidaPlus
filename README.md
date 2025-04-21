# 🏥VidaPlus🏥
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Joao-Silva01/VidaPlus/blob/main/LICENSE)
<p>
 O projeto VidaPlus é um Sistema de Gestão Hospitalar e de Serviços de Saúde (SGHSS), que tem como objetivo oferecer 
um ambiente de gerenciamento de pacientes, profissionais da saúde e processos administrativos, afim de reduzir as burocracias e agilizar os atendimentos.
</p>
<p>O Sistema também tem os agendamentos das consultas(presencial e online), envio de e-mails, controle de atualização do registro médico do paciente, o cadastro de pacientes, os exames, os prontuários, as hospitalizações, os relatórios, a validação de login e diversos endpoints.</p>

## Funcionalidades

### Consultation (Consulta):
   - Agendamento, Atualização e exclusão de consultas.
   - Status para controlar o tempo da consulta: 🟡SCHEDULED | 🟢COMPLETED | 🔴CANCELLED.
   - Realiza associações de diversas classes, ex: Patient, HealthProfessional, Prescription, etc.
     
### Report (Relatório):
   - Só o administradores podem gerar os relátorios.
   - Na requisição o body(corpo) é opcional, pois o relatório é gerado automático.
   - É gerado com o faturamento mensal, a quantidades de consultas, prescrições, hospitalizações e exames.

### Notification (Notificação):
   - Envia a notificação para o paciente por e-mail.
     
### MedicalRecord (Registro Médico):
   - Criação e Atualização do registro.
   - A atualização é feita usando uma classe intermediaria (UpdateLog), salvando quem fez a atualização, a data e o que foi modificado.
      
### Security and Authentication (Segurança e Autenticação): 
   - Implementação do Spring Security com autenticação via JWT.
   - Cadastro de senhas e assinaturas criptografadas.
   - Controle de acesso baseado no tipo de perfil (UserRole).
      
### Validation and Exception (Validações e Exceções):
   - Validações personalizadas para o E-mail e Document.
   - Tratamento de erros com mensagens customizadas.
   - Usando mappers para converter DTO para entitidade.
     
### Database and Migrations(Banco de dados e Migrações):
   - Usando docker parar subir o database PostgreSQL.
   - Utilizando migrations para criar/atualizar as tabelas e seus relacionamentos.

## Modelo Conceitual

### Diagrama Entidade e Relacionamento (DER):


<img src="https://github.com/user-attachments/assets/53f55c67-2d73-4922-b92f-ac4f79d8c75c" alt="DER" width="800"/>

### Diagrama UML:
<img src="https://github.com/user-attachments/assets/6c7c7603-553c-4e21-b96d-ff55f9b5cdd8" alt="diagrama" width="800"/>

#### Enumerations:
<img src="https://github.com/user-attachments/assets/95f69505-5b47-42e7-8268-bce41e092a02" alt="enum" width="300"/>

## 👨‍💻Tecnologias Usadas👨‍💻

  - Java
  - Spring Boot
  - Spring Security
  - Spring Email
  - JWT (JSON Web Token)
  - Flyway (Migrations)
  - Maven
  - Docker + PostgreSQL
  - MapStruct
  - OAuth2 Resource Server
    
## 🚀Executação do Projeto🚀
Para Executar este projeto tem que ter os seguintes requisitos.

  - Ter o [JDK 21](https://www.oracle.com/br/java/technologies/downloads/#java21) instalado.
  - Ter o [Maven](https://maven.apache.org/download.cgi) instalado.
  - Ter o [Docker](https://www.docker.com/get-started/) instalado.

### Tudo ok?? Então vamos começar a execução do projeto😀

 1. Clone o repositório:
```
git clone https://github.com/Joao-Silva01/VidaPlus.git
```

2. Entre no repositório e vai até a pasta aonde se encontra o arquivo docker compose:
```
cd VidaPlus/src/main/java/com/RobDev/VidaPlus/docker
```
   - OBS: É muito importante fazer esse passo, pois esse arquivo vai subir o database PostgreSQL via docker.

3. Execute o arquivo docker compose:
```
docker compose up -d
```
4. Volte para a pasta principal do projeto:
```
cd ../../../../../../..
```
4. Builda o Projeto:
```
mvn clean spring-boot:run
```
5. Caso queira parar o arquivo docker compose:
```
docker stop docker-postgres-1
```   
  
