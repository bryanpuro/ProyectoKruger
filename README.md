# ProyectoKruger
 El proyecto tiene como lenguaje java y usa el framework spring boot en su versión 2.5.10 construido con Gradle y con la versión de java 8, usando como gestor de base de datos Postgresql.
El script de la base de datos se encuentra en \src\main\database
DataBase= “vacunacion”
username=postgres
password=root
se ejecuta de manera local en el puerto 8081, no tiene seguridades para poder acceder a los webs services. La estructura consta de la entidad, controladores, repositorios y servicios 
dentro del paquete entidad tenemos una sola entidad con el nombre de empleado, en el paquete de servicios tenemos cada uno de los métodos que van a ser utilizados para crear, listar, eliminar o actualizar la entidad.
En el paquete de repositorio tenemos el repositorio donde alojamos los métodos jpql y para el paquete de controladores encontramos cada uno de los web services que podemos consumir
Para la documentación de apis se uso swagger2 al cual se puede acceder de manera local mediante el url http://localhost:8081/pkServices/swagger-ui.html

