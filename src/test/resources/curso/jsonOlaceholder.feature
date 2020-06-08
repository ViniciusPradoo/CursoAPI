#language: pt
@tag
Funcionalidade: teste post

  @tag1
  Cenario: test1
    Dado que acesso a url "https://jsonplaceholder.typicode.com" com o endpoint "/posts"
    Quando preencho o campo "titulo" com "testServico" no objeto json
    E preencho o campo "nome" com "Vinicius" no objeto cliente
    E preencho o campo "idade" com "24" no objeto cliente
    E preencho o campo "nome" com "Thais" no objeto clienteDois
    E preencho o campo "idade" com "26" no objeto clienteDois
    E adiciono o objeto cliente na lista clientes
    E adiciono o objeto clienteDois na lista clientes
    E adiciono o campo "cliente" com a lista clientes no objeto json
    E realizo a requisicao post
    Entao valido que no campo "cliente[0].nome" recebo o valor "Vinicius"
    E valido que no campo "cliente[0].idade" recebo o valor "24"
    E valido que no campo "cliente[1].nome" recebo o valor "Thais"
    E valido que no campo "cliente[1].idade" recebo o valor "26"

  @tag1
  Esquema do Cenario: test1
    Dado que acesso a url "https://jsonplaceholder.typicode.com" com o endpoint "/posts"
    Quando preencho o campo "titulo" com "testServico" no objeto json
    E preencho o campo "nome" com "<nome>" no objeto cliente
    E preencho o campo "idade" com "<idade>" no objeto cliente
    E preencho o campo "nome" com "Thais" no objeto clienteDois
    E preencho o campo "idade" com "26" no objeto clienteDois
    E adiciono o objeto cliente na lista clientes
    E adiciono o objeto clienteDois na lista clientes
    E adiciono o campo "cliente" com a lista clientes no objeto json
    E realizo a requisicao post
    Entao valido que no campo "cliente[0].nome" recebo o valor "Vinicius"
    E valido que no campo "cliente[0].idade" recebo o valor "24"
    E valido que no campo "cliente[1].nome" recebo o valor "Thais"
    E valido que no campo "cliente[1].idade" recebo o valor "26"

    Exemplos: 
      | nome     | idade |
      | Vinicius |    24 |
      | Thais    |    26 |
      | Hulk     |     1 |
      | Thor     |     1 |
