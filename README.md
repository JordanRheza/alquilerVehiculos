### Controller
Es la encargada de manejar las solicitudes HTTP del cliente. Actúa como intermediario, recibiendo peticiones, gestionando rutas y devolviendo respuestas (por lo general en formato JSON o HTML) a través de los métodos de los controladores.

### DTO
Se usan para transferir datos entre las capas de la aplicación de forma eficiente y segura. Permiten definir qué datos se envían y reciben desde el cliente, ayudando a proteger el modelo y evitando exponer información innecesaria.

### Model
Representa las entidades del negocio. Es donde se definen las clases que mapean la estructura de la base de datos. Estas clases son las que contienen los atributos principales.

### Repository
Se encarga de la comunicación con la base de datos. En esta capa, se crean las interfaces que extienden de `JpaRepository`, facilitando el acceso, almacenamiento y consulta de datos sin tener que escribir SQL manualmente.

### Service
Contiene la lógica del negocio de la aplicación. Aquí se implementan las reglas, validaciones y funciones de negocio que no dependen de la interfaz ni de la persistencia de datos, haciendo que la lógica sea reutilizable.


