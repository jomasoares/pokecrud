# pokecrud

Este é o projeto de uma API REST simples, feita em Java.

## Inicializar o Projeto

Se você já possui o Maven instalado, execute na linha de comando:
```shell script
mvn spring-boot:run 
```
Se não possui, você pode usar o arquivo **mvnw** para a plataforma Linux ou **mvnw.cmd** para Windows, usando o mesmo argumento: **spring-boot:run**. Ambos os arquivos encontram-se na raiz do projeto.
Para isso, abrir um terminal (linux) ou um PowerShell (Windows) **na pasta do projeto** e execute a linha de comando:
```shell script
# linux
./mvnw spring-boot:run

# windows
./mvnw.cmd spring-boot:run
```
Obs.: Caso o linux não permita a execução do arquivo, tente dar a permissão de execução rodando esse comando:
```shell script
chmod +x mvnw
```

## Como utilizar os endpoints

Esta API contém os quatro endpoints básicos do CRUD mais um endpoint de listar todos os pokemons, pra facilitar a visualização da lista de pokemons salvos:

| *Método HTTP* | *Endpoint*                 | *Ação*                                                          |
| :-----------: |--------------------------- |  -------------------------------------------------------------- |
| GET           | /pokemon                   | Retorna todos os pokemons listados                              |
| GET           | /pokemon/{id}              | Retorna um pokemon com o id específico                          |
| POST          | /pokemon                   | Cadastra um novo pokemon na memória                             |
| PUT           | /pokemon/{id}              | Edita oa informações de um pokemon existente                    |
| DELETE        | /pokemon/{id}              | Deleta um pokemon da memória                                    |

Os endpoints POST e PUT precisam de um body na requisição, em formato JSON, como no exemplo a seguir:

```json
{
    "id": 16,
    "name": "poketeste",
    "height": 15,
    "weight": 14
} 
```
Se você utiliza o POSTMAN para testar endpoints, você pode baixar a coleção [**clicando aqui**](https://drive.google.com/file/d/1WSkVri6TopcWpnS8vRQ0rz-y8K0qb2og/view?usp=share_link)!

## Demais informações

* Lembre-se que a versão utilizada do Java é 11!
* Toda vez que o projeto reinicia, a memória é apagada.
* Os commits seguiram a convenção do [**Conventional Commits**](https://www.conventionalcommits.org/en/v1.0.0/).


