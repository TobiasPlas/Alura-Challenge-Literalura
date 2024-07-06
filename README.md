#LIBRERIA NOBY







####Lo primero que nos encontramos al ejecutar el programa es el menu de inicio que cuenta con 8 opciones

[![menu-inicio.png](https://i.postimg.cc/YC1XFY82/menu-inicio.png)](https://postimg.cc/zyGSZL94)


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

 "count":La cantidad de resultados.  
 "next":La url de la pagina siguiente.  
 "previous":La url de la pagina anterior.  
 "results":Lista de libros.  

Dicha lista de libros estaba limitada a 32 libros y para ver la continuasion de dicha lista de libros habria que ingresar a la url de la siguiente pagina proporsionada en el apartado "next".
De alli surge el metodo menuSecundario().

[![Menu-Secundario.png](https://i.postimg.cc/HsCbWc50/Menu-Secundario.png)](https://postimg.cc/4nBYB3Wn)

Lo que hace es verificar si la entidad "datos" recibida contiene o no pagina siguiente o anterior y determina que opciones brindarle al usuario para que eliga entre pasar de pagina,volver a la pagina anterior o salir al menu principal.  

Las opciones 2 y 3 , "Filtrar libro por titulo" y "Filtrar libro por autor" si bien llaman metodos distintos, los dos desembocan a un mismo metodo que es el de buscarLibro(); 

[![buscar-Libros-Segun.png](https://i.postimg.cc/jjN7rR53/buscar-Libros-Segun.png)](https://postimg.cc/bGyJxc11)

[![buscar-Libros.png](https://i.postimg.cc/63XGWF4W/buscar-Libros.png)](https://postimg.cc/HJ6L3ZtR)

Aprovechando que la Api proporciona un endPoin para buscar nombres de autores y títulos de libros con palabras dadas, lo unico que tenia que hacer era filtrarlo para cada metodo en especifico como se ve en la imagen.

Al final de los mismos se puede ver el metodo de guardarLibro(),que le brinda al usuario la capacidad de elegir guardar o no alguno de los libros mostrados en pantalla tomando como referencia el id;  

 [![guardar-Libro.png](https://i.postimg.cc/LsRHnSDb/guardar-Libro.png)](https://postimg.cc/PC3GRBBW) 


 La cuarta opcion "Filtrar por idioma" le brinda al usuario la posibilidad de elegir si ver libros en español o en ingles asegurandose de que el usuario coloque un valor valido,sino se vuelve al menu de inicio.  
 
[![filtrar-Idioma.png](https://i.postimg.cc/SxmSKqDt/filtrar-Idioma.png)](https://postimg.cc/w7b8fKKh)
 En la opcion numero 5 "Mostrar lista de autores guardados"

