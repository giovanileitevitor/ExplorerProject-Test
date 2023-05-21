# Github Repository Explorer / User Explorer

Hi Dev / Sir

O **Github Explorer** é um aplicativo simples para listar os repositórios do GitHub com mais estrelas e com código Kotlin.

## Detalhes sobre o projeto:

- Desenvolvido inteiramente em Kotlin

- Uso de Paging 3 para paginação da lista de repositórios

- Desenvolvido a seguindo Clean Architecture e MVVM

- Utiliza Kotlin Flow para chamada assíncrona

- Testes unitários das camadas de data (PagingSource, Repository), domain (UseCase) e presentation (ViewModel)

## Tela 1 - Lista de Repositorios:

A tela 1 ou tela inicial pode apresentar três estados distintos:

<img width=25% height=25% alt="print home" src="https://user-images.githubusercontent.com/27828713/239715949-4d260c65-c661-4a71-9d92-79a067f35397.jpeg">

<img width=25% height=25% alt="print users" src="https://user-images.githubusercontent.com/27828713/239716102-36a6f6ac-0d05-4ec6-85a0-04e7a9e8e813.jpeg">

##### Estado de carregamento

Ao entrar na tela o carregamento da lista é iniciado, exibindo um loading para o usuário.

##### Estado de sucesso

Se a chamada for realizada com sucesso, será exibida uma lista com os repositórios do Github.

##### Estado de erro

Se ocorrer uma falha no carregamento da lista, será exibida uma mensagem de erro com um botão para tentar novamente.

Se o device for rotacionado, o aplicativo mantém o estado da tela.


## Tela 2 - Lista de Usuários:

Esta tela só está disponivel na versão paga do projeto. Para acessá-la, basta apontar a camera do celular e efetuar um pix no valor de 150 reais para o QR Code abaixo.

<img width="305" alt="Captura de Tela 2023-05-20 às 21 56 01" src="https://github.com/giovanileitevitor/Test-Softteck/assets/27828713/c5c426c9-f086-433b-a4be-e6f4d2ce1ba2">



## Testes Unitários via Gradle / Esteira

Para realizar a execução dos testes unitários via comando gradle / esteira, basta digitar no terminal do projeto :
- ./gradlew test --info


## Testes Instrumentados via Gradle

Para realizar a execuçao de testes instrumentados via comando gradle, basta digitar no terminal do projeto :
- ./gradlew -Pandroid.experimental.androidTest.useUnifiedTestPlatform=true pixel2api29DebugAndroidTest


### E lembre-se: TODOS OS CAMINHOS LEVAM A ROMA.


### Contato:
- Email: ✉︎ giovanileitevitor@gmail.com
- Skype: ⌨️ giovanileitevitor