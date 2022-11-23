# collectorvault
Spring Boot restful API to manage a videogame collection

Create and manage your own collection of videogames of various plataforms, As a WIP project will have some unused database fields.

To run it correctly you will need to install the MYSQL database included in this git hub.

Just run as a springboot app in any of your trusted IDE.

Project contains openapi-ui extensión, you can access trought http://localhost:8080/swagger-ui/index.html when the API is running in local to test the functionality

Current functions of the API are as follow:

POST /api/coleccion >> Insert a new collection

GET /api/coleccion >> Get all collections stored in the system

GET /api/coleccion/{coleccionId} >> Get the specified {coleccionId} coleccion

PUT /api/coleccion >> update the collection included 

DELETE /api/coleccion/{coleccionId} >> Delete the specified {coleccionId} coleccion

