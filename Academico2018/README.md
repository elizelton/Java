# Academico2018
Usando programa Acadêmico:

1.
Altere a classe Aluno, inclua o campo dataCadastro, salve nesse campo a data do dia que foi realizado o cadastro,
não deve ter entrada desse campo na interface do CRUDAluno, 
   deve fazer automaticamente quando gravar, apenas exibir;

2.
Fazer uma rotina que atribua a data de hoje no campo dataCadastro para todos os alunos cadastrados no banco;

3.
 Altere a classe Disciplina, inclua o campo semestral, do tipo boolean, persistir no banco, usar CheckBox no CRUD;

4.
 Faça uma rotina que filtre todos os alunos que são menores de 18 anos;

5.
 Altere a exibição do tableview de alunos para mostrar em negrito os alunos que fazem aniversário no mês;

6.
 Crie a classe Departamento com os seguintes campos: sigla (unique) e nome, com persistencia no banco, 
   sem CRUD nem interface de exibição, inclua via código 5 departamentos;

7.
 Altere a classe Professor, inclua o campo departamento, que deve fazer referencia para a classe Departamento;

8.
 Altere o CRUD de Professor, inclua o campo departamento na interface, como sendo um ComboBox;

9.
 Garanta que a sigla da classe Departamento seja gravada em maisculo;

10.
 Crie a classe Turno, com os seguintes campos sigla e nome, sem interface;

11.
 Crie rotina para cadastral manualmente os seguintes turnos no banco
    M - Matutino
    V - Vespertino
    N - Noturno
    I - Integral

12.
 Altere a classe Disciplina inclua nela um campo para a classe Turnom com DBREF;

13.
 Altere o CRUD de disciplina, para incluir um combobox para Turno;