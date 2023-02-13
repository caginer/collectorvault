# collectorvault
Spring Boot restful API to manage a videogame collection

Create and manage your own collection of videogames of various plataforms, As a WIP project will have some unused database fields.

To run it correctly you will need to install the MYSQL database included in the "BBDD" folder.

Just run as a springboot APP in any of your trusted IDE.

API uses JWT token authetification, you will need to get a token from the API to work with it.

To get a working account it's needed to call "/api/auth/registrar", with the following JSON parameters.

{
    "nombre" : "Insert full name here",
    "username" : "username",
    "email" : "xxx@gmail.com",
    "password" : "password"
}

With a valid account is possible to start a session using "/api/auth/iniciarSesion", with the following JSON parameters.

{
    "usernameOrEmail": "username",
    "password": "password"
}

After starting a new session correctly the API will return a JWT token that let the user work with the API.

Current functions of the API are as follow:

POST /api/coleccion >> Insert a new collection using the JSON below:

{
            
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
}

GET /api/coleccion >> Get all collections stored in the system owned by the authorized user

GET /api/coleccion?pageNo=x&pageSize=x&sortBy=coleccionId&sortDir=asc >> Get all collections stored in the system owned by the authorized user using
"pageSize" to determine the number of pages that the system uses to distribute the collections, "pageNo" it's used to indicate to he system which page yoy want and 
"sortBy" is used to specify which field is going to be used to sort the collections and sortDir states which direction will be used to present the items

GET /api/coleccion/{coleccionId} >> Get the specified {coleccionId} coleccion

PUT /api/coleccion >> update the collection included 

DELETE /api/coleccion/{coleccionId} >> Delete the specified {coleccionId} coleccion

