# Anotacoes do projeto

Anotacoes para o projeto de AP1 DE Programacao a Orientacao a Objeto.

# Funcionalidade do Porjeto

    O aplicativo deve permitir que o usuário visualize a lista de partidas disponíveis para venda;
    Para cada partida, o usuário deve poder escolher a quantidade e o tipo de ingressos desejados;
    O aplicativo deve calcular o preço total da compra de acordo com a quantidade e o tipo de ingressos selecionados;
    Após o pagamento, o usuário deve receber uma mensagem com as informações sobre a partida e a quantidade e o tipo de ingressos comprados.

# Classes que devem ser desenvolvidas 

    Evento: classe abstrata que representa um evento. Deve conter os seguintes atributos e métodos:
    Atributo nome (String): nome do evento;
    Atributo data (String): data e horário do evento;
    Atributo local (String): local onde será realizado o evento;
    Atributo ingressosInteira (int): quantidade de ingressos tipo inteira disponíveis;
    Atributo ingressosMeia (int): quantidade de ingressos tipo meia disponíveis;
    Método isIngressoDisponivel(TipoIngresso tipo, int quantidade): verifica se há ingressos disponíveis para o tipo e quantidade especificados;
    Método venderIngresso(TipoIngresso tipo): realiza a venda de ingressos do tipo e quantidade especificados e retorna o valor total da venda;
    Implemente os métodos getters e setters conforme a necessidade;
    --------------------------------------------------------------------------------------------------------------------------------------------
    TipoIngresso: enumeração que representa os tipos de ingresso disponíveis. Deve conter os seguintes valores:
    INTEIRA: para ingressos inteiros;
    MEIA: para ingressos com desconto de meia-entrada.
    --------------------------------------------------------------------------------------------------------------------------------------
    Ingresso: classe abstrata que representa um ingresso vendido. Deve conter os seguintes atributos e métodos:
    Atributo evento (Evento): evento para o qual o ingresso foi vendido;
    Atributo preçoCheio (double): valor do ingresso cheio, sem o desconto de meia entrada;
    Atributo tipo (TipoIngresso): indica se é inteira ou meia entrada;
    Método getPreco(): retorna o preço a depender do tipo de ingresso.


# Menu de interface
Para a primeira entrega, foi solicitado que você elabore uma interface por linha de comando (CLI), de forma que o usuário possa realizar as seguintes operações:

    Cadastre um novo evento;
    Realize a venda de um ingresso, em que o usuário escolhe o tipo do ingresso (inteira ou meia) e apresenta as características particulares do ingresso (desconto social, por exemplo), e o programa gera um ingresso e exibe na tela as informações. O usuário deve confirmar se as informações estão corretas e o programa deve sinalizar que a compra foi realizada;
    Exibir informações do evento;
    Exibir o número de ingressos restantes;  
    Exibir informações do último ingresso vendido;

  O programa só precisa armazenar um evento e um ingresso por vez. Ou seja, se um novo evento for cadastrado, o evento anterior é apagado.
