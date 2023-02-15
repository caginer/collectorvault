# collectorvault
Spring Boot restful API to manage a videogame collection.

Create and manage your collection of videogames, As a WIP project will have some unused database fields.

To run it correctly you will need to install the MYSQL database included in the "BBDD" folder.

Just run as a springboot APP in any of your trusted IDE.

API uses JWT token authetification, you will need to get a token from the API to work with it.

To get a working account it's needed to call "/api/auth/registrar", with the following JSON parameters.

    "nombre" : "Insert full name here",
    "username" : "username",
    "email" : "xxx@gmail.com",
    "password" : "password"

With a valid account is possible to start a session using "/api/auth/iniciarSesion", with the following JSON parameters.

    "usernameOrEmail": "username",
    "password": "password"
    
After starting a new session correctly the API will return a JWT token that let the user work with the API. You need to use this token within the application.

Current functions of the API are as follow:

POST /api/coleccion >> Insert a new collection using the JSON below:
            
      "nombreCol": "any name will do",
      "valor": 0,
      "numeroArticulos": 0,
      "fechaApertura": "2015-12-11T23:00:00.000+00:00",
            
      "plataforma": 4(only platform 4 exists at the moment),
      "itemsDeLaColeccion": [
           {
              "itemId": 1
           },
           {
              "itemId": 2
           },
           {
              "itemId": x...
           }
         ]

It's not mandatory to add any games upon creation of the collection. You can add (or delete) any games you want later using PUT command.


GET /api/coleccion >> Get all collections stored in the system owned by the authorized user.


GET /api/coleccion?pageNo=x&pageSize=x&sortBy=coleccionId&sortDir=asc >> Get all collections stored in the system owned by the authorized user.

In this case "pageSize" is used to determine the number of pages that the system uses to distribute the collections.

"pageNo" it's used to indicate to he system which page yoy want to retrieve from the API. 

"sortBy" is used to specify which field is going to be used to sort the collections.

"sortDir" states which direction will be used to present the items(asc for ascending, dsc for descending).

Also for any GET response is included a summary with the following fields:
    "numeroPagina": 1,(page number served)
    "medidaPagina": 2,(how many items are included by page)
    "totalElementos": 3,(total items included in the collection)
    "totalPaginas": 2,(total number of pages in the response)
    "ultima": true (a boolean to confirm if we are at the last page)
    
 A full response will look like this :
 
 insertar respuest completa.


GET /api/coleccion/{coleccionId} >> Get the collection with specified {coleccionId}.


PUT /api/coleccion >> update the collection with the information send in JSON format.

Just need to send the ID and any other fields you want to update.


DELETE /api/coleccion/{coleccionId} >> Delete the collection with the specified ID.

