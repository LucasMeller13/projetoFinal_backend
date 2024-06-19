
# API Atendimento Médico

Este documento fornece uma visão geral dos endpoints da API para gerenciar as entidades de atendimento (consultas), paciente e médico, sendo **SpringBoot Java** o framework utilizado.

## Base URL

Todos os endpoints possuem o seguinte prefixo:

```
http://localhost:8080/
```

## Endpoints

### Paciente 

#### Create Paciente

- **URL:** `/paciente/`
- **Method:** `POST`
- **Headers:**
  - `Content-Type: application/json`
- **Body:**
  ```json
  {
    "nome": "Cleber da Silva",
    "idade": 22,
    "genero": "masculino",
    "cep": "8888888",
    "cpf": "123456",
    "alergias": "paracetamol",
    "tiposanguineo": "ab",
    "telefone": "234234234",
    "email": "clebersilva@exemplo.com"
  }
  ```

#### Get Paciente

- **URL:** `/paciente/`
- **Method:** `GET`
- **Parameters:**
  - `resultados`: quantidade de resultados para retornar.
  - `paginas`: número da página.
  - `sortBy`: ordernar por um atributo (`telefone, nome, etc`).

#### Update Paciente

- **URL:** `/paciente/`
- **Method:** `PATCH`
- **Headers:**
  - `Content-Type: application/json`
- **Body:**
  ```json
  {
    "id": "af2580bb-a267-4010-a12b-f6fbf473b62a",
    "nome": "Alice Ferreira",
    "idade": 50,
    "genero": "feminino",
    "cep": "89012345",
    "cpf": "98765432100",
    "alergias": " ",
    "tiposanguineo": "ab+",
    "telefone": "78901234",
    "email": "alicemarques@example.com"
  }
  ```

#### Delete Paciente

- **URL:** `/paciente/{id}`
- **Method:** `DELETE`
- **Parameters:**
  - `id`: necessário id como parâmetro para deletar.

### Medico

#### Create Medico

- **URL:** `/medico/`
- **Method:** `POST`
- **Headers:**
  - `Content-Type: application/json`
- **Body:**
  ```json
  {
    "nome": "Teo Geronimo",
    "idade": 35,
    "genero": "masculino",
    "cep": "8888888",
    "cpf": "123467",
    "alergias": "paracetamol",
    "tiposanguineo": "ab",
    "telefone": "234234234",
    "email": "teogeronimo@exemplo.com",
    "especializacao": "ortopedia",
    "crm": "123467"
  }
  ```

#### Get Medico

- **URL:** `/medico/`
- **Method:** `GET`
- **Parameters:**
  - `resultados`: quantidade de resultados para retornar.
  - `paginas`: número da página.
  - `sortBy`: ordernar por um atributo (`telefone, nome, etc`).

#### Update Medico

- **URL:** `/medico/`
- **Method:** `PATCH`
- **Headers:**
  - `Content-Type: application/json`
- **Body:**
  ```json
  {
    "id": "225c77eb-8d2f-4699-ab69-71c97cf1ac46",
    "nome": "Marina Ferreira",
    "idade": 20,
    "genero": "feminino",
    "cep": "87654321",
    "cpf": "23456789012",
    "alergias": "caseina",
    "tiposanguineo": "o-",
    "telefone": "5556789",
    "email": "marinaferreira@example.com",
    "especializacao": "Pediatria",
    "crm": "42365423"
  }
  ```

#### Delete Medico

- **URL:** `/medico/{id}`
- **Method:** `DELETE`
- **Parameters:**
  - `id`: necessário id como parâmetro para deletar.

### Atendimento 

#### Create Atendimento

- **URL:** `/atendimento/`
- **Method:** `POST`
- **Headers:**
  - `Content-Type: application/json`
- **Body:**
  ```json
  {
    "idMedico": "214f3d9c-bd1e-4737-8831-1651eb78d85c",
    "idPaciente": "3ccaa588-c6fe-45f8-874b-985b9fe7ecd8",
    "data": "2024-06-16T12:00:00.000+00:00",
    "descricao": " ",
    "remedios": " ",
    "sala": "10.1.1",
    "status": "pendente",
    "duracao": 0
  }
  ```

#### Get Atendimento

- **URL:** `/atendimento/`
- **Method:** `GET`
- **Parameters:**
	 - `resultados`: quantidade de resultados para retornar.
	  - `paginas`: número da página.
	  - `sortBy`: ordernar por um atributo (`duração, sala, etc`).

#### Update Atendimento

- **URL:** `/atendimento/`
- **Method:** `PATCH`
- **Headers:**
  - `Content-Type: application/json`
- **Body:**
  ```json
  {
    "id": "ccef90af-3c73-4b2b-baf3-253932208666",
    "idMedico": "0fc70d21-b000-47c7-9955-4f427528d107",
    "idPaciente": "3a6309b5-fe5c-4cd4-a61f-3f03f4249b13",
    "data": "2024-06-16T12:00:00.000+00:00",
    "descricao": "Paciente com TDAH",
    "remedios": "Venvanse",
    "sala": "20.22",
    "status": "feita",
    "duracao": 30
  }
  ```

#### Delete Atendimento

- **URL:** `/atendimento/{id}`
- **Method:** `DELETE`
- **Parameters:**
  - `id`: necessário id como parâmetro para deletar.

### Ajuda 

#### Retorna informações do projeto

- **URL:** `/ajuda`
- **Method:** `GET`
- **Headers:**
  - `Content-Type: application/json`
- **Body:**
  ```json
    {
	"projeto": "Atendimento em consultório",
	"tema": "Sistema de atendimento médico",
	"estudantes": [
		"Igor Rocha",
		"Lucas Meller"
		]
	}
  ```
