# PacmanTesting

Los objetivos son:
-----------------
levantar mapa de file

jugada por turno , girar en una direccion, caminar en la direccion en la que ya estaba o quedarse en el lugar el Pacman

Luego, si la partida no alcanzo una condicion de fin de juego, los Fantasmas se mueven, y si chocaron con una pared, cambian su direccion 

Si Pacman choca con un Fantasma, Pacman muere

pelota especial para matar Fantasmas, por 10 turnos

Se gana cuando no hay mas pelotas

Cuando un Fantasma muere, se hace invisible por 3 turnos ( sigue caminando en el tablero estando invisible, pero no mata al Pacman si lo choca )


Consideraciones
---------------
Debe tomarse en cuenta las siguientes consideraciones:

a) Sistema de colisiones

Pacman
Pacman Especial
Fantasma
Fantasma Invisible
Pared
Pastilla
Pastilla Especial
VACIO

Pacman vs Fantasma = Muere Pacman
Pacman vs Pared = ninguno muere, Pacman no avanza
Pacman vs Pastilla = La pastilla se quita del tablero
Pacman vs Pastilla Especial = La pastilla se quita del tablero, Pacman ahora le gana a los Fantasmas por los proximos 10 turnos
Pacman vs "VACIO" = se dibuja el Pacman
Pacman vs Fantasma invisible = ninguno muere, se dibuja el Pacman

Pacman Especial vs Pared = ninguno muere, Pacman no avanza
Pacman Especial vs Fantasmas = Muere Fantasma, el Fantasma pasa a estar en invisible
Pacman Especial vs Pastilla = La pastilla se quita del tablero
Pacman Especial vs Pastilla Especial = La pastilla se quita del tablero, ¿Aumenta la cantidad de turnos en 10(turnos restantes = turnos restantes + 10 ), o se restaura el contador a 10( turnos restantes = 10)?
Pacman Especial vs "VACIO" = se dibuja el Pacman
Pacman Especial vs Fantasma invisible = ninguno muere, se dibuja el Pacman

Fantasma vs Pared = ninguno muere, el Fantasma debe cambiar de direccion para no volver a chocar la pared el turno siguiente ( Hay que tener encuenta las esquinas )
Fantasma vs Pastilla = ninguno muere, se dibuja el Fantasma
Fantasma vs Pastilla Especial = ninguno muere, se dibuja el Fantasma
Fantasma vs Fantasma = ninguno muere, se dibuja algun Fantasma VISIBLE
Fantasma vs Fantasma Invisible = ninguno muere, se dibuja algun Fantasma VISIBLE
Fantasma vs "VACIO" = se dibuja el Fantasma
Fantasma vs Pacman = Pacman muere, se dibuja el Fantasma
Fantasma vs Pacman Especial = el Fantasma muere, se dibuja el Pacman. ( El Fantasma pasa a estar invisible por 3 turnos, no puede volver a ser comido hasta que pasen los 3 turnos)

Fantasma Invisible vs Pared = ver Fantasma vs Pared
Fantasma Invisible vs Pastilla = ninguno muere, se dibuja la pastilla
Fantasma Invisible vs Pastilla Especial = ninguno muere, se dibuja la pastilla
Fantasma Invisible vs Fantasma = ninguno muere, se dibuja algun Fantasma VISIBLE
Fantasma Invisible vs Fantasma Invisible = ninguno muere, se dibuja "VACIO"
Fantasma Invisible vs "VACIO" = se dibuja "VACIO"
Fantasma Invisible vs Pacman = ninguno muere, se dibuja el Pacman
Fantasma Invisible vs Pacman Especial = ninguno muere se dibuja el Pacman


b) Mapas de usuario

El mapa de usuario tiene que tener las siguientes caracteristicas
1) Ser en texto plano
2) Cada caracter, debe ser alguno de los siguientes:
W - Wall / Pared
P - Punto de partida inicial del Pacman
G - Punto de partida inicial de todos los fantasmas
. - Pill / Pastilla
* - Pill Special / Pastilla Especial

3) Solo puede haber un P en todo el archivo
4) En principio, solo puede haber un G (Esto se puede cambiar eventualmente para que spawneen en puntos diferentes dentro de su jaula) y un P
5) El archivo debe tener en todas sus lineas la misma cantidad de caracteres
6) Ejemplo de un mapa valido:
WWWWWWWWW
W.......W
W.*...*.W
W.......W
W..WGW..W
W..WWW..W
W...P...W
W.*...*.W
W.......W
WWWWWWWWW

7) Si se elige no usar un mapa de usuario, usar uno por default
(Pendiente buscar el mapa default del pacman original)

c) Pacman vs el Mapa

Pacman, al llegar al limite de un mapa y no tener una pared, debe aparecer al otro lado del mapa.
Ejemplo:
WWWW.WWWW
W.......W
W.*...*.W
.........
W..WGW..W
W..WWW..W
W...P...W
W.*...*.W
W.......W
WWWW.WWWW

Si pacman avanza hacia la derecha estando en 3 9, debe aparecer en 3 0
Si pacman avanza hacia arriba estando en 0 5, debe aparecer en 9 5

d) En cada posicion del laberinto pueden convivir distintas entidades, segun las reglas del sistema de colision:
Ejemplo: En una misma celda pueden estar uno o mas fantasma(visibles) y una Pastilla
