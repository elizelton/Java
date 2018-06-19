Folha de Pagamento

Funcionário (super classe) Abstrata:
- atributos: nome (String), salário (double), sexo (char 'f' ou String)
- método abstrato: getSalarioFinal() 
getTipo() retorna nome da Classe (getClass().getName()), tratamento de string

- Vendedor: salário + 4% da venda (comissão) getComissao()
- Gerente: salário + bonificação (abstrata)
- Administrativo salário

Salário final (depende do tipo do funcionário)
getSalarioFinal() -> abstrato

Salário: não pode ser negativo nem zero
Bonificação: só pode ser 0 

public void Vendedor( nome, salario, sexo, venda); --constructor classe Vendedor
vendas * 0.04; getComissao()
getSalarioFinal()

Super (nome, sexo, salario); --chama constructor do pai
vendas (local)
constructor protected na classe pai Funcionario (não instancia, visível pro filho)

Lista, for, mostra salários

if sexo = "F"
return "Feminino";

--INTERFACE--
*hbox:
radiobutton para: adm ger ven (CheckedProperty() bind do visible Property -> "visibilizar" o hbox extra)
nome (.txtFldNome.RequestFocus()) receber foco, visível e não disable
radiobutton togglegroup (pra desmarcar o outro)
salario (Listener pra não digitar String no campo que só aceita Double)

*hbox:
textfield extra (bonificação ou vendas)
setText() a partir da seleção

*hbox
button Add (adicione NOVO no FINAL da Lista)
limpar campos ( clear() ) após clicar no botão

*TableView Lista Funcionários
Nome - Tipo - Sexo - Salário - Extras - Final

*hbox
Mostrar número de funcionários
