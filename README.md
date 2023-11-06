# API de Destinos de Viagem

Esta API permite gerenciar destinos de viagem, incluindo cadastro, pesquisa, avaliação e exclusão.

## Endpoints

- **Cadastro de Destino:**
  - Método: POST
  - URL: `http://localhost:8080/api/destinos/`
  - Corpo (JSON):
    ```json
    {
        "nome": "Destino Teste",
        "localizacao": "Local Teste",
        "avaliacao": 0.0
    }
    ```
    Cria um novo destino de viagem.

- **Listagem de Destinos:**
  - Método: GET
  - URL: `http://localhost:8080/api/destinos/`
  
  Retorna a lista de destinos de viagem disponíveis.

- **Busca de Destino por ID:**
  - Método: GET
  - URL: `http://localhost:8080/api/destinos/{id}`
  - Substitua `{id}` pelo ID do destino desejado.

  Retorna informações detalhadas sobre um destino de viagem específico.

- **Pesquisa de Destinos por Nome ou Localização:**
  - Método: GET
  - URL: `http://localhost:8080/api/destinos/pesquisar?termo={termo}`
  - Substitua `{termo}` pelo nome ou localização desejados.

  Retorna destinos de viagem correspondentes ao termo fornecido.

- **Avaliação de Destino:**
  - Método: PUT
  - URL: `http://localhost:8080/api/destinos/{id}/avaliar`
  - Substitua `{id}` pelo ID do destino desejado.
  - Corpo (JSON):
    ```json
    {
        "avaliacao": 8.5
    }
    ```
    Atualiza a avaliação de um destino de viagem existente.

- **Exclusão de Destino:**
  - Método: DELETE
  - URL: `http://localhost:8080/api/destinos/{id}`
  - Substitua `{id}` pelo ID do destino que deseja excluir.

  Exclui um destino de viagem existente.
