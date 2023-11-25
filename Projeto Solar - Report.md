| Nome do Projeto | Projeto Solar |
|---|---|
|Github | [Clicar para ver Git](https://github.com/AquarioDeterminado/Projeto_Semestre_3.git) |
|ClickUp (Planeamento próximas semanas) | [Clicar Aqui para Ver o Planeamento](https://app.clickup.com/9015003806/v/s/90150012798) |

#### Equipa:
 - João Coelho (nº20220753) 
 - Ricardo Dias (nº20220494)

#### Objetivo 
 - Este projeto tem como objetivo facilitar o crescimento de empresas pequenas e de tamanho médio, proporcionando uma forma simples de interação entre as mesmas e de gestão do seu espaço de trabalho. 
 - Como colateral, promovemos e melhoramos o ambiente de *cowork spaces*, tornando a sua comunidade mais unida e resolvendo as necessidades dos seus clientes.

#### Proposta
 - A ideia deste projeto surgiu no estudo da interação entre empresas pequenas e de tamanho médio. 
 - Muitas destas empresas não apresentam a capacidade de obter escritórios próprios, recorrendo a espaços de coworking. Como tal, idealizamos uma aplicação que une os dois conceitos base desses espaços : o aluguer do espaço em si e o *networking* entre empresas. 

 - Existem varias aplicações que tocam nestes conceitos, mas não existe nenhuma, pelo menos que tenhamos encontrado, que os mistura.

 - A ideia *core* é uma rede social especificamente concebida para promover interações dentro dos espaços coworking, mas que também possuí a capacidade de gerir o aluguer do mesmo e os postos de trabalho disponíveis (hot desks).

#### Problemas
 - 1º - O problema principal da ideia de uma rede social é a integração da mesma no dia á dia do usuário. Tendo em conta o número de redes sociais no mercado, é difícil esperar que o utilizador se integre numa rede social que não seja simples. Como tal, cria-se a questão de como podemos criar uma rede social de baixo compromisso, onde facilmente um utilizador consegue interagir com a sua comunidade.
 
 - 2º - Na gestão de arrendamentos existem certos aspetos que não conseguimos colocar como definitivos. A forma de arrendar um espaço ou aderir a uma subscrição varia de *cowork space* para *cowork space*, sendo difícil encontrar um ponto medio que não seja muito vago.

#### Soluções
 - 1º - De forma a criarmos uma rede social *low effort* decidimos que a forma principal de interação dos utilizadores será através dos eventos do *cowork space*. Seja por participar, comentar, reagir ou criar eventos os utilizadores podem interagir sem a necessidade de estar constantemente a *postar* conteúdo. 

 - 2º - De forma a chegar ao modelo definitivo da gestão do arrendamento dos espaços, chegamos a conclusão que o melhor seria adaptar a app ao seu contexto. Ou seja, a *app* rege-se dependendo da forma como o espaço prefere gerir e disponibilizar as suas rendas e subscrições.

### Guiões Teste
- Seguem os guiões de teste. 

##### Mapa do Fluxo completo da app (sujeito a alterações)

---
### Guiões *Core*:
- Como a App tem dois conceitos base, achamos que fazia sentido apresentar dois fluxos cores.

#### Eventos:
- Fluxo para participar/ser notificado de eventos a decorrer no espaço
          ![](assets/User%20Flow%20-%20Cowork%20Space%20Manager%20[Recovered]-02.png)

#### Gestão de Subscrições e Rendas:
- Fluxo de gestão do arrendamento de espaços (este fluxo é limitado as pessoas responsáveis pelo arrendamento, ou seja, nem todas as pessoas de uma empresa tem acesso a este fluxo)
          ![](assets/User%20Flow%20-%20Cowork%20Space%20Manager%20[Recovered]-03.png)
---
### Guiões *Extra*:
- Estes guiões são uma extenção do fluxo *core* (daí a seta a sair da esquerda) 
#### Disponibilidade de Hot Desks:
- Mostra a Disponibilidade de *Hot Desks* do espaço.

          ![](assets/User%20Flow%20-%20Cowork%20Space%20Manager%20[Recovered]-04.png)
#### Cartão de Acesso
- Método de autenticação. Este cartão de acesso é a interação principal entre o espaço e app. Desde a marcação de uso de hot desks (através da leitura de qr codes nas secretarias), até o acesso ao workspace ou a áreas mais restritas (a definir com as implementações de acessos do espaço) este cartão é a chave para muitas funcionalidades do workspace.


          ![](assets/User%20Flow%20-%20Cowork%20Space%20Manager%20[Recovered]-05.png)

          ![](assets/User%20Flow%20-%20Cowork%20Space%20Manager%20[Recovered]-01.png)

#### Protótipo
- O protótipo demonstra a forma como a app se irá comportar, mas não é uma representação fiel do design final.

- Apartir da estrutura do protótipo podemos visualar o fluxo da app e como os utilizadores irão interagir com a mesma.

  Esclarecimentos:
  Em BackOffice será realizada, pelo espaço de Cowork:
    - A gestão de Eventos
    - A gestão de Subscrições e Rendas
    - A gestão e registro de Hot Desks
          - O registro de empresas

#### Protótipo - Base de Dados (modelo)

 ![Modelo](SQL/Modelagem%20Diagrama%20-%20Solar-01.png)
