# 📄 API de Gestão de Alunos e Matrículas

Projeto Pessoal para prática e estudos em Java e Spring, onde realizo a gestão de Alunos e suas respectivas matrículas.
A gestão das matrículas é realizada onde ao criar o aluno automaticamente também uma matrícula, e ao deletar todas as matrículas do aluno, respectivamente o aluno é excluído.

---

## Diagrama de CLasses

     ________________                ___________________   
    | Alunos         |               | Matriculas       |
    |________________| 1 --------> n |__________________|
    | id             |               | id               |
    | nome           |               | codigoMatricula  |
    | telefone       |               | nomeCurso        |
    | dataNascimento |               | dataInicio       |
    | dataInclusao   |               | dataInclusao     |
    | dataAtualizacao|               | dataAtualizacao  |
     ________________                 __________________  

___

## 🔧 Tecnologias Utilizadas

- Linguagem Java 21
- Framework Spring Boot
- Spring Data JPA
- Lombok
- H2 Database
- Maven
- REST Client
- Bean Validation
___

## 🧱 Descrição do Projeto

- A API permite:

- ✅ Cadastrar um aluno junto com suas matrículas
- ✅ Listar todos os alunos cadastrados
- ✅ Listar todas as matriculas de um aluno a partir do seu ID
- ✅ Atualizar os dados cadastrais de um aluno (e suas matrículas)
- ✅ Remover um aluno (e suas matrículas associadas)
___

## 📬Contato

- Email: danielamedeiromota@hotmail.com
- [🔗 LinkedIn](https://www.linkedin.com/in/danielammota/)