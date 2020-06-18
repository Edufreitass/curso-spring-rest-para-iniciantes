# Curso de Spring Rest 100% gratuito para iniciantes.
#### Ministrado pelo [Thiago Faria de Andrade](https://github.com/thiagofa) - CEO, [AlgaWorks](https://github.com/algaworks). 

## O que é uma API? :thinking:

- **Application Programming Interface** ou *Interface de Programação de Aplicações*, é um componente de software que possui um 
conjunto de funções que faz a intermediação do acesso, as funcionalidades de algum sistema.
  * *Exemplo:* Software Consumidor :left_right_arrow: API :left_right_arrow: Software Provedor
  
- **Web Services vs APIs** :desktop_computer: 	
  * *Web Services*: São um tipo de API, ou seja, uma API que fornece a sua interface de comunicação pela web, pela internet. 
  Então quando falamos de Web Services, estamos falando de Web APIs.
    
    * *Exemplo:* Software Restaurante :left_right_arrow: API do iFood :left_right_arrow: iFood

- **REST** :computer:
  * **RE**presentational **S**tate **T**ransfer, é um estilo arquitetural para desenvolver Web APIs, ou seja, 
  para desenvolver Web Services. Então resumindo, **REST** é uma especificação que define a forma de comunicação
  entre componentes de softwares na web, independente da linguagem de programação usada.
  
- **Por que REST?** :thinking:
  * Separação entre cliente e servidor
  * Escalabilidade
  * Independência de linguagem
  * Mercado
  
- **Constraints** são as melhores práticas ou regras para ser **REST**.
  * **API**
    * **Cliente-servidor**: significa que precisamos de um cliente, que pode ser uma aplicação front-end, mobile ou qualquer
    outra aplicação consumidora, enviando requisições para um servidor que é a API. E essa aplicações devem poder evoluir 
    separadamente sem qualquer dependência entre elas. Inclusive um cliente ou servidor, pode ser substituido sem interferir
    em nada, desde que a interface entre elas permaneça inalterada.
    * **Stateless**: significa sem estado, ou seja, a aplicação não deve possuir estado. Na prática isso quer dizer que
    a requisição feita ao servidor da API, deve conter tudo o que for necessário para que seja devidamente processado.
    Por exemplo, o servidor não pode manter uma sessão.
    
    * **Cache**: é uma memória de consulta rápida, ou seja, a API pode fazer caching das respostas das requisições, por exemplo,
    imagina que temos um serviço em nossa API que retorna uma lista de cidades, quantas vezes uma lista é alterada dentro de
    um dia, um mês ou ano? Talvez nenhuma vez, não se cria cidades com frequência, então esse seria um tipo de requisição
    que poderia ser guardada em cache ou ser cacheada, já que não há mudanças frequentes nesses dados em nossa API. Então
    quando houver uma requisição para esse mesmo serviço novamente, antes mesmo de receber uma resposta o cache entra em ação 
    e nem chega a consumir a rede, isso melhora a escalabilidade e performance da aplicação, já que reduzimos o número de hits
    no servidor, ou seja, o número de acessos ao servidor. *Observação, **não** use cache em toda aplicação, utilize apenas 
    sobre a possibilidade e quando necessário.*
    
    * **Interface uniforme**: é um conjunto de operações bem definidas dentro de um sistema, ou seja, uma vez definida como a
    interface da API funciona, é necessário seguir isso religiosamente. Essa **constraint** simplifica e desacopla a
    arquitetura, isso permite que cada parte evolua de forma independente.
    
    * **Sistema em camadas**: ela diz sobre a possibilidade entre o cliente que consome a API e o servidor que hospeda a API
    ter outros servidores no meio do caminho, esses servidores podem fornecer uma camada de segurança, de cache, balanceamento
    de cargas etc. *Observação, o cliente **não** deve conhecer quantas camadas possuem no meio.*
    
    * **Código sob demanda**: é opcional e muito pouco usado em APIs já que não se aplica na maioria dos casos.
- **Protocolo HTTP**

![image](https://user-images.githubusercontent.com/56324728/84975718-7d615780-b0fc-11ea-81bf-f0b205acda89.png)
   
   * **Composição da requisição**
   ```
   [MÉTODO] [URI] HTTP/[Versão]                         POST /produtos HTTP/1.1
   [Cabeçalhos]                                         Content-Type: application/json
                                                        Accept: application/json
   [CORPO/PAYLOAD]                                      
                                                        {
                                                           "nome": "Notebook i7",
                                                           "preco": 2100.0
                                                        }
   ```
   
   * **Composição da resposta**
   ```
   HTTP/[Versão] [STATUS]                               HTTP/1.1 201 Created
   [Cabeçalhos]                                         Location: /produtos/331
                                                        Content-Type: application/json
   [CORPO]                                      
                                                        {
                                                           "codigo": 331,
                                                           "nome": "Notebook i7",
                                                           "preco": 2100.0
                                                        }
   ```

- **Recursos REST ou *REST Resources***: é qualquer coisa exposta na web, como um documento, uma página, um vídeo, uma imagem e até mesmo um processo de
negócio. É algo que tem importância suficiente para ser referenciado como uma coisa no software, por exemplo, em um *e-commerce*, um catálogo de produtos, um único produto, uma nota fiscal um pagamento, tudo isso pode ser considerado como um recurso, um *resource*.
   * Um único produto é um recurso
      * *Singleton Resource*
   * Coleção de produtos é um recurso
      * *Collection Resource*

- **Identificando Recursos**
   * **URI**: *Uniform Resource Identifier*, basicamente é um conjunto de caracteres, ou seja, uma String, que tem como objetivo dar uma espécie de endereço para os recursos, de forma não ambígua.

- **URI vs URL**
   * URL: é um tipo de URI. **URL** significa *Uniform Resource Locator*, então uma URL é tipo de identificação de recursos também, mas ela especifica não apenas o identificador, mas a localização do recurso também, ou seja, aonde o recurso está disponível, qual o mecanismo para chegar até ele etc.
      * Exemplo:
      
![image](https://user-images.githubusercontent.com/56324728/84975606-3a9f7f80-b0fc-11ea-82e5-3101d5d3c71d.png)
      
- **Observação**: O exemplo da imagem acima :point_up: **NÃO** é uma boa prática a se seguir, não é uma boa prática identificar um recurso dessa forma.
Por que? :thinking: ... A **URI** deve ser referir a uma coisa, ou seja, a um substantivo e NÃO um verbo ou uma ação, porque coisas possuem propriedades e verbos não possuem.

- **A boa prática seria fazer da seguinte forma:**

![image](https://user-images.githubusercontent.com/56324728/85019921-f46f0e00-b145-11ea-8bb0-16e98aeee35e.png)

- **Observação**: Como exibe a imagem acima, a boa prática seria escrever o caminho usando um **substantivo** e não um *verbo*, ficando assim: **/produtos**. E caso você esteja se perguntando, "e como ficaria então o caminho de listar produtos? :thinking:", boa pergunta, a diferenciação viria atráves dos métodos HTTP, **GET, POST, PUT, DELETE** etc.

- **No exemplo abaixo temos um recurso único e para identificar esse recurso único podemos fazer da seguinte forma:**

![image](https://user-images.githubusercontent.com/56324728/85020661-0bfac680-b147-11ea-8ef6-7381fe9a3131.png)

- **Observação**: Como exibe a imagem acima, a identificação de um recurso único viria através de um *código* identificador que inserimos na URI. **Mas veja bem, o ideal é que tenhamos uma interface uniforme e a imagem acima NÃO está uniforme.** Lembra que a coleção de produto**S** exibidas anteriormente nos exemplos acima, era /produto**S** no plural, nesse exemplo acima está no singular, e isso não segue as boas práticas de URI. **O ideal e também  praticamente um consenso do mercado, é utilizar sempre nomes no PLURAL.**
   * Exemplo: /produto**S**/{codigo}
   
   ![image](https://user-images.githubusercontent.com/56324728/85021509-53358700-b148-11ea-8768-82b699f9dc49.png)

***
## Spring REST :leaves:
Mas o que é Spring REST? Uma tecnologia? Um framework? A resposta seria **NÃO** para todas as perguntas anteriores.
**Spring REST** é apenas um **termo** que utilizamos para simplificar a nossa comunicação e dizer que temos uma **REST API desenvolvida com o ecossistema Spring**.

![image](https://user-images.githubusercontent.com/56324728/85023136-b6281d80-b14a-11ea-9e9e-a4efb8087c11.png)

- **Spring** não é um framework apenas, mas um ecossistema de projetos, ou seja, um conjunto de projetos que resolvem vários problemas do dia a dia de um programador **Java**. Ele nos ajuda a criar aplicações com simplicidade e flexibilidade. Como o ecossistema Spring tem muitos projetos, se falarmos apenas a palavra *Spring*, provavelmente estamos referenciando um conjunto de projetos, o ecossistema e não um projeto em especifíco. A ideia é que o Spring ajude a focar no desenvolvimento das regras de negócio e não ficar perdendo tempo desenvolvendo codigos de infraestrutura da aplicação.

- **Por que Spring?**
   * **Canivete suíço para desenvolvedores Java**: ou seja, ele resolve vários problemas de desenvolvimento de software, desde gerenciamento de objetos, injeção de dependências, acesso a diferentes fontes de dados, como bancos de dados SQL, NoSQL, criação de projetos web, REST API, segurança da aplicação, dentre várias outras.
   * **Simplicidade**: ele realmente simplifica o desenvolvimento de projetos, o objeto do Spring é reduzir a complexidade.
   * **Maturidade**: é uma tecnologia bem madura, usada por grandes empresas do mundo todo, então o grau de confiança nessa tecnologia é muito grande.
   * **Modularidade**: Spring **NÃO** é um projeto gigante que você precisa adicionar tudo para usar. Ele é *organizado* por projetos e até *sub-projetos*, e nós podemos escolher quais deles queremos usar para resolver nossos problemas. Também é possível usar projetos Spring em conjunto com outras tecnologias que não são do mesmo ecossistema, então não é preciso ficar preso apenas ao ecossistema.
   * **Evolução constante**: a tecnologia está sempre em evolução.
   * **Open source**: o código de todos os projetos são abertos, isso significa que você pode contribuir com a tecnologia, corrigir algum eventual problema e pode usar livremente, sem ter que pagar nada para VmWare, que é a empresa que está por trás da tecnologia.
   * **Comunidade grande e forte**: é uma comunidade que possui um grande número de pessoas e forte no sentido que existem muita ajuda disponíveis em forum, livros, documentaçoes etc.
   * **Popularidade**: a popularidade da tecnologia é muito alta, hoje em dia as empresas que adotaram Java no back-end, a maioria usa *Spring*.
   * **Empregabilidade**: as empresas estão sempre buscando por profissionais que tem o conhecimento sobre essa tecnologia.

- Quem usa Spring? (18/06/2020)

![image](https://user-images.githubusercontent.com/56324728/85027998-ee325f00-b150-11ea-8725-3c861d875ec1.png)

