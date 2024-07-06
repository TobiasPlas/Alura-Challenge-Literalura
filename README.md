#LIBRERIA NOBY







####Lo primero que nos encontramos al ejecutar el programa es el menu de inicio que cuenta con 8 opciones

[![menu-inicio.png](https://i.postimg.cc/YC1XFY82/menu-inicio.png)](https://postimg.cc/zyGSZL94)
```java
 Mostrar todos los libros colgados en la red
 Filtrar libro por titulo
 Filtrar libro por autor
 Filtrar por idioma
 Mostrar lista de autores guardados
 Mostrar autores vivos en determinado año
 Exhibir cantidad de libros guardados en un determinado idioma
 Salir
```

La funcionalidad del mismo es la siguiente:Le mostramos al usuario la lista de opciones con un numero asignado para que pueda elegir una accion, guardando su respuesta en una variable gracias a la funcion Scanner.
Con el metodo switch logramos que segun su respuesta ejecute diveros metodos

[![Funcion-Menu.png](https://i.postimg.cc/3wsTngmy/Funcion-Menu.png)](https://postimg.cc/QBJwMK6s)


 

  En la primera opcion tenemos el metodo mostrar libros que se encarga de crear y mostrar la lista de libros
 [![metodo-monstrar-Libros-primera-opcion.png](https://i.postimg.cc/g2ckZqHm/metodo-monstrar-Libros-primera-opcion.png)](https://postimg.cc/2VJDpWtK)

 Dentro de la misma se llama al metodo obtener datos que el mismo se encarga de consumir la api y mapearla en la entidad DatosRecibidos
 
 [![Obtener-Datos.png](https://i.postimg.cc/vHLHrDKv/Obtener-Datos.png)](https://postimg.cc/2VyDmjrq)

 [![Obtener-Datos.png](https://i.postimg.cc/9QQVybZW/Obtener-Datos.png)](https://postimg.cc/vckpsW0j)
 
 [![Clase-Consumir-Api.png](https://i.postimg.cc/qRf9Dxh6/Clase-Consumir-Api.png)](https://postimg.cc/2qwcVvxC)

 Analisando el Json que entregaba la api,note que la principal entidad contaba con 4 importantes parametros.

 "count":La cantidad de resultados
 "next":La url de la pagina siguiente
 "previous":La url de la pagina anterior
 "results":Lista de libros

Dicha lista de libros estaba limitada a 32 libros y para ver la continuasion de dicha lista de libros habria que ingresar a la url de la siguiente pagina proporsionada en el apartado "next".
De alli surge el metodo menuSecundario().
 
