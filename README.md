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
