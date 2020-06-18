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
