# API de Mouses

Uma API que permite gerenciar mouses.

## Rotas

- Listar todos os mouses: `GET /mouses`
- Obter um mouse por id: `GET /mouses/id`
- Criar um novo mouse: `POST /mouses`
>  ```
>    // body
>    {
>      "brand": string,
>      "model": string,
>      "price": double,
>    }
>    ```
- Atualizar um mouse existente: `PUT /mouses/id`
>  ```
>    // body
>    {
>      "brand"?: string,
>      "model"?: string,
>      "price"?: double,
>    }
>    ```
- Excluir um mouse: `DELETE /mouses/id`

## IMPORTANTE
- No arquivo application.properties o caminho do banco de dados
- deve ser informado da seguinte forma:

> spring.data.mongodb.uri = Url do MongoDB
> Não está informado a url do meu banco de dados por questões de segurança.
