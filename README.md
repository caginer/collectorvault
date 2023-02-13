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

POST /api/coleccion >> Insert a new collection

GET /api/coleccion >> Get all collections stored in the system

GET /api/coleccion/{coleccionId} >> Get the specified {coleccionId} coleccion

PUT /api/coleccion >> update the collection included 

DELETE /api/coleccion/{coleccionId} >> Delete the specified {coleccionId} coleccion

