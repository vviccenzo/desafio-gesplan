# DesafioGesplan

Para este desafio, foram utilizadas principalmente as tecnologias: <br>
- Java 11+ <br>
- Spring <br>
- Angular 15 <br>
- MySql <br>
- JPA <br>
<br>

Para executar o front-end da aplicação, é necessário rodar o comando "ng serve" em seu terminal no diretório da aplicação, caso não possua o Angular CLI instalado em seu computador, execute o comando "npm install -g @angular/cli", após isso, pode executar o comando "ng serve" que deverá iniciar a aplicação corretamente na porta 4200, ou através do link "localhost:4200".<br><br>
Após garantir que o front-end está rodando, inicie a classe DesafiogesplanApplication.java, para que o back-end da aplicação seja iniciado.<br><br>
Em application.properties, foi configurado para que o back-end rode na porta 3306, caso não seja a sua porta, pode apenas mudar esta linha no prórpio application.properties:<br>
"spring.datasource.url=jdbc:mysql://localhost:3306/database_gesplan?createDatabaseIfNotExist=true", onde estiver o 3306, coloque a sua porta padrão.
Foi configurado para que caso não exista um banco de dados no computador, o próprio spring irá gerar automaticamente o banco de dados, portanto, não é necessário rodar um script para geração do banco.<br><br>
Supondo que o front-end e o back-end estejam rodando corretamente, você deve chegar em um site parecido com isto:
![image](https://user-images.githubusercontent.com/102992249/221415222-a43bd0a0-bc67-4b50-aae4-c47e55eced4e.png) <br>
Sendo este o formulário de cadastro de um fornecedor:
![image](https://user-images.githubusercontent.com/102992249/221415273-d03eb276-4c62-452b-8a74-19bf05a6f065.png)



