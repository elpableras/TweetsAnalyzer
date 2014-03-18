TweetsAnalyzer
===============

Se ha desarrollado un servicio web RESTful usando para ello NetBeans 7.3, como servidor GlassFish v3.1, que usaremos con las características de Java EE6. 


Se utilizará el método GET, para hacer la petición y obtener así la información por medio de un parámetro el cual será un String que retornará toda la información, luego con sucesivos split, crearemos arrays con la información que mostraremos, en este caso sobre el Tweet analizado. La clase que contendrá estos métodos es como una clase EJB Facade de una aplicación Java EE, aunque también podría haberse utilizado Jersey. 


Para mostrar el Servicio Web, se ha creado un HTML sencillo, el cual contiene JavaScript, que utilizaremos junto a AJAX y para consumir el JavaScript, utilizaremos jQuery.

A dicha dirección le pasaremos el parámetro (“base”) del Tweet escrito en el HTML, que será analizado con la aplicación y devolverá con el método GET el String con los datos.

Una vez con los datos en el HTML, se despiezarán y se utilizarán para: 

- Mostrar la frase del Tweet en minúscula con los signos de puntuación quitados 
- El valor de cada una de las palabras analizadas 
- El promedio de todas ellas 
- El idioma en que se encuentra el Tweet 
- Después con los datos de los valores de las palabras se creara un gráfico de tabla, con la utilidad que da la API de visualización de gráficos de Google
