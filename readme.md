# CRUD UniNotas - Etapa 1

Este projeto implementa um CRUD básico para a entidade `Faculdade` utilizando Java nativo (`com.sun.net.httpserver`). Os dados são armazenados temporariamente em memória (usando Coleções), cumprindo os requisitos da atividade de não utilizar banco de dados ou frameworks externos, como o Spring Boot. O projeto foi refatorado para utilizar a biblioteca **Jackson** no processamento e conversão direta dos dados JSON.

## Arquitetura e Funcionamento

O projeto foi estruturado seguindo o padrão em três camadas para separar responsabilidades:

* **Controller (`FaculdadeController`):** Camada de entrada. É responsável por abrir o servidor HTTP, receber as requisições (GET, POST, PUT, DELETE) vindas do Postman, extrair os dados em formato JSON (utilizando o `ObjectMapper` do Jackson) e enviá-los para a camada de serviço.
* **Service (`FaculdadeService`):** Camada de regras de negócio. Aplica a lógica da aplicação, servindo como uma ponte inteligente. Ela recebe os comandos do Controller, processa o que for necessário e solicita ao Repository que altere os dados.
* **Repository (`FaculdadeRepository`):** Camada de dados. Gere o acesso e a persistência das informações. Neste projeto, opera salvando, buscando e excluindo os objetos `FaculdadeEntity` diretamente de um `ArrayList` em memória.

## Pré-requisitos
* **Java JDK** instalado.
* **Postman** (ou Insomnia) para a realização dos testes das requisições HTTP.
* Uma IDE (como Eclipse, IntelliJ ou VS Code) para compilar e executar o código.

## Configuração e Execução

Como o projeto utiliza as bibliotecas nativamente através de ficheiros `.jar`, é necessário configurar a biblioteca Jackson na sua IDE antes de executar:

1. Faça o clone deste repositório na sua máquina local:
   `git clone https://github.com/Ericoalb/Unicotas`
2. Abra a pasta raiz do projeto na sua IDE[cite: 4].
3. **Ative a biblioteca Jackson:** No explorador de ficheiros da sua IDE, localize a pasta `libs` dentro do projeto[cite: 4]. Selecione os ficheiros `.jar` do Jackson e adicione-os como biblioteca (ex: clicar com o botão direito e escolher *Add as Library* no IntelliJ).
4. Navegue até ao ficheiro `Main.java` e execute-o (opção *Run*)[cite: 4].
5. O servidor será iniciado e exibirá a mensagem `"Servidor rodando!"` no terminal[cite: 4]. A API estará pronta para receber requisições na porta `8080`[cite: 4].

## Testes no Postman (Comandos CRUD)

**Atenção ao formato:** Certifique-se de configurar o Postman para a aba **Body ➔ raw ➔ JSON**[cite: 4].

### 1. Cadastrar Faculdade
* **Método:** `POST`[cite: 4]
* **URL:** `http://localhost:8080/faculdades`[cite: 4]
* **Body:**
```json
{
  "name": "nome",
  "cnpj": "0000000",
  "id": 0
}