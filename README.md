# IMD Corp

## Uso

Garanta que o [GNU make](https://www.gnu.org/software/make/manual/make.html), o [maven](https://maven.apache.org/) e ao menos o **Java 17** estejam instalados no computador.

Uma vez na pasta raiz do projeto (mesma desse README), use o Makefile com os comandos:

- **Para compilar**

  ```
  make build
  ```

- **Para executar**

  ```
  make run
  ```

O arquivo `banco.dat` é o binário que armazena as 10 instâncias de Professores e Técnicos ADM.

## Estrutura do projeto

```
app
├── controller
│   ├── MenuController.java
│   ├── PessoaController.java
│   ├── ProfessorController.java
│   ├── TecnicoADM.java
│   └── TecnicoADMController.java
├── dao
│   └── BancoDAO.java
├── model
│   ├── enums
│   │   ├── Formacao.java
│   │   ├── Genero.java
│   │   ├── Nivel.java
│   │   └── TipoDeFuncionario.java
│   ├── interfaces
│   │   └── Funcionario.java
│   ├── Endereco.java
│   ├── Pessoa.java
│   ├── Professor.java
│   └── TecnicoADM.java
├── service
│   └── BancoService.java
├── util
│   ├── InputUtils.java
│   └── Pair.java
├── view
│   ├── MenuView.java
│   ├── PessoaView.java
│   ├── ProfessorView.java
│   └── TecnicoADMView.java
└── App.java
```

### Detalhes

1. **`controller/`**:

   - Contém a lógica que conecta o modelo (`model`) e a visão (`view`).
   - Classes como `PessoaController` e `TecnicoADMController` server para gerenciar funcionalidades de cadastro de Professor e Técnico e o `MenuController` serve para gerenciar a navegação no menu.

2. **`dao/`**:

   - Contém a classe `BancoDAO.java`, que segue o padrão singleton para armazenar e gerenciar os objetos da aplicação.

3. **`model/`**:

   - Contém as classes de domínio (`Pessoa`, `Professor`, `TecnicoADM`, etc.) e os enums (`Genero`, `Nivel`, `Formacao`) que modelam as entidades do sistema.

4. **`view/`**:

   - Contém as classes que gerenciam a interação com o usuário. `MenuView.java` é usada para exibir as telas e capturar prompts.

5. **`util/`**:

   - Contém classes utilitárias, como `InputUtils.java`, que serve para encapsular o Scanner.

6. **`App.java`**:

   - Contém o ponto de entrada do programa, inicializando os componentes e exibindo o menu interativo.
