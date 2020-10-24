# Tarea integradora 2
![ios-7-music-icon-nn-1024x400](https://user-images.githubusercontent.com/64206343/95392908-34a5f800-08bf-11eb-9047-8d143bdf14b3.jpg)
Imagen tomada de: [Imagen](https://www.faq-mac.com/2015/04/primera-beta-de-ios-8-4-con-nueva-aplicacion-musica/)
## ENUNCIADO 📋:<br><br>
<b>Cansados de las continuas interrupciones de la publicidad y comerciales mientras escuchan música usando las plataformas de streaming</b>, usted y unos compañeros de la universidad decidieron aplicar sus conocimientos en programación para diseñar e implementar el prototipo de una aplicación que permita organizar y compartir música entre sus usuarios.<br>

Inicialmente, el equipo de desarrollo decidió bautizar la aplicación: el <b>Music Collect & Share o MCS</b> para referirse al prototipo de la app de forma corta. En un momento de creatividad crearon un logo y lo convirtieron en ascii para el prototipo (mientras aprenden interfaz gráfica de usuario)
El Music Collect & Share tiene varios usuarios registrados, un pool de canciones compartidas y una colección de playlists.<br><br>  Cada usuario tiene un apodo o nombre de usuario que es una sola palabra, sin espacios.  Por ejemplo, lunalunera, djchristian y seyerman son nombres de usuarios de la aplicación. Todos los usuarios tienen además una contraseña, una edad y una categoría.  La categoría de un usuario  puede ser, newbie, little contributor, mild contributor y star contributor, la categoría de un usuario  se asigna dependiendo de la cantidad de canciones que han compartido en el pool de canciones así:<br><br>
<b>Un usuario está en la categoría newbie cuando está recién creado y hasta que comparte tres canciones. <br>
* A partir de tres canciones compartidas, un usuario se convierte en  little contributor hasta que comparta diez canciones.<br>
* Cuando un usuario comparte diez canciones se convierte en usuario mild contributor  y conserva esta categoría hasta que comparte 30 canciones.<br>
* A partir de las 30 canciones compartidas, el usuario está en la categoría star contributor</b><br><br>
Cada canción en el pool de canciones del MCS tiene un título, un nombre de artista o banda, una fecha de lanzamiento, una duración y un género. El género se refiere al género musical, aunque existen diversos  géneros musicales, usted y sus compañeros decidieron limitar los géneros de las canciones del MCS a rock, hip hop, música clásica, reggae, salsa y metal.  <br>
De forma general,  cada playlist en el MCS tiene un nombre, una duración y los géneros de las canciones que hacen parte del playlist. La duración de una playlist se obtiene sumando la duración de cada una de las canciones en el play list, y los géneros es el conjunto de géneros de las canciones del playlist.  Por tanto, cuando se crea un playlist en el MCS este playlist tiene un nombre pero está vacío por tanto su duración es cero y su conjunto de géneros está vacío.  La duración y el conjunto de géneros cambia a medida que se vayan agregando canciones.<br>  
<b>A continuación se explica con un ejemplo 📄:</b><br>

* Se crea un playlist llamado “Música para programar”, con  duración igual a cero y género vacío.<br>
* Se incluye en la playlist la canción “November rain” de Guns N’ Roses con duración 4:43 y género Hard Rock.  Por tanto, se actualiza la duración de la playlist a 4:43 y el género a ROCK<br>
* Se incluye la canción “Nothing else matters” de Metallica con duración 6:28 y género Hard Rock. Entonces se actualiza la duración de la playlist a 11:11 y género sigue siendo ROCK<br>
* Se incluye la canción “Jump around” de House of Pain con duración 3:37 y género hip hop.  Entonces la duración de la playlist se actualiza a  14:48 y su género se actualiza a ROCK, HIP HOP<br>

<b>Los playlist tienen tres variantes: playlists privados, restringidos y públicos. A continuación se explican las particularidades de los playlists 🔧:</b><br>
* Un playlist privado tiene un único usuario que puede añadir y listar las canciones que contiene.<br>
* Un playlist restringido tiene un máximo de cinco usuarios que pueden añadir y listar canciones.<br>
* Un playlist público no tiene restricciones de usuarios, es abierto para todos, pero tiene una calificación promedio, porque cualquier usuario puede ingresar una calificación entre 1  y 5 indicando qué tanto le gustó el playlist (1 la nota más baja, 5 la nota más alta)<br>
