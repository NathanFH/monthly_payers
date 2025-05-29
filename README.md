Nathan Fernandes Henrique,
Victor Kobinski e Silva,
Raí Tobias da Veiga Almeida

O projeto se trata de uma API para ter controle de mensalidades de jogos de futebol, nele temos duas tabelas, jogador com nome, data de nascimento e email e pagamento com ano, mês, valor e cod_jogador
que é uma chave estrangeira vinda da tabela de jogador, que é o id_jogador, já que é necessário que cada pagamento tenha relação com um jogador. Para fazer a relação de chave estrangeira no java foi utilizado
na tabela jogador "@OneToMany(mappedBy = "jogador", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})" e na tabela pagamento "@ManyToOne @JoinColumn(name = "cod_jogador", nullable = false)", o que isso
significa é que um jogador pode ter vários pagamentos, porém cada pagamento está associado a um jogador. Além disso nos controllers de ambas as tabelas foram feitas as operações de uma API, que se trata de 
POST,GET,PUT e DELETE. 
