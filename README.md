# Projeto de Telefonia - Trabalho Acadêmico

Este projeto foi desenvolvido como parte de um trabalho acadêmico para a disciplina de Programação Orientada a Objetos no curso de Analise e Desenvolvimento de Sistemas.

## Descrição do Projeto

O projeto consiste em um sistema de telefonia que permite cadastrar e gerenciar assinantes pré-pagos e pós-pagos. Os assinantes pré-pagos podem fazer recargas de créditos e realizar chamadas, enquanto os assinantes pós-pagos têm uma assinatura mensal e também podem fazer chamadas. O sistema é implementado utilizando conceitos de programação orientada a objetos em Java.

## Funcionalidades

O sistema de telefonia possui as seguintes funcionalidades:

1. Cadastrar Assinante: Permite cadastrar um novo assinante, solicitando informações como nome, CPF, tipo de assinante (pré-pago ou pós-pago) e outros dados relevantes. Os assinantes são armazenados em vetores separados de acordo com o tipo de assinante.

2. Listar Assinantes: Exibe a lista de todos os assinantes cadastrados, incluindo os assinantes pré-pagos e pós-pagos. Os assinantes são exibidos com informações como nome, CPF e número de telefone.

3. Fazer Chamada: Permite que um assinante faça uma chamada, informando o número de telefone e a duração da chamada. O sistema verifica se o assinante tem créditos suficientes (no caso dos assinantes pré-pagos) ou se está dentro do limite da assinatura (no caso dos assinantes pós-pagos) para efetuar a chamada.

4. Fazer Recarga: Permite que um assinante pré-pago faça uma recarga de créditos, informando o valor da recarga e a data. O sistema atualiza os créditos do assinante pré-pago.

5. Imprimir Faturas: Imprime as faturas de todos os assinantes do mês atual, incluindo as informações das chamadas realizadas e recargas feitas no mês. A fatura exibe o valor total a ser pago pelo assinante.

## Como executar o projeto

Para executar o projeto, siga as etapas abaixo:

1. Certifique-se de ter o ambiente Java instalado em seu sistema.

2. Faça o download ou clone este repositório para sua máquina.

3. Abra o projeto em sua IDE de desenvolvimento Java preferida.

4. Compile e execute a classe principal `Main.java`.

5. O programa exibirá um menu com as opções disponíveis. Escolha uma opção e siga as instruções fornecidas pelo sistema.

## Equipe
- [Julia Oliveira](https://github.com/JuliaOliveiraa)

## Considerações Finais

Este projeto foi desenvolvido como parte do trabalho acadêmico para a disciplina de Programação Orientada a Objetos. Ele demonstra a aplicação dos conceitos aprendidos durante o curso e proporciona a oportunidade de desenvolver um sistema de telefonia básico em Java.

Caso você queira contribuir com melhorias ou novas funcionalidades, sinta-se à vontade para fazer um fork do repositório e enviar suas contribuições.
