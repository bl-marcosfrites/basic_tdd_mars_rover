# Mars Rover | TDD Training

This repository contains the resolution of the "Mars Rover" exercise proposed in the 2023 "Basic TDD" training at Bitlogic.

The resolutions are done:

> - in Java (v18) with Spring Boot, using JUnit 5 as testing framework.
> - in C# (v10) with .NET 7.0, using XUnit as testing framework.

## 'Mars Rover' Exercise

### Explicación

El ejercicio de TDD para MarsRover consiste en desarrollar un programa que permita al rover moverse en un plano bidimensional y orientarse hacia los cuatro puntos cardinales: norte, sur, este y oeste. El programa debe ser capaz de procesar una cadena de comandos que permita mover al rover hacia adelante, hacia atrás, girar a la izquierda o a la derecha.
Para comenzar, se debe desarrollar una prueba que permita verificar si el programa puede determinar la posición y la dirección del rover al inicio del sistema. Se deben definir los valores esperados para la posición (x,y) y la dirección (N, S, E, O). Si el programa es capaz de devolver los valores esperados, la prueba será exitosa.
Luego, se debe desarrollar una prueba para verificar si el programa puede determinar si el rover se encuentra en una posición y dirección determinada. Para esto, se debe definir una posición y dirección específica y compararla con los valores devueltos por el programa. Si el programa es capaz de determinar correctamente la posición y la dirección, la prueba será exitosa.
El siguiente paso es desarrollar pruebas para verificar si el programa es capaz de mover al rover hacia adelante o hacia atrás según la dirección en la que esté orientado. Se deben definir posiciones y direcciones específicas y compararlas con los valores devueltos después de procesar la cadena de comandos. Si el rover se mueve correctamente, la prueba será exitosa.
Por último, se deben desarrollar pruebas para verificar si el programa es capaz de girar a la izquierda o a la derecha según la dirección en la que esté orientado. Se deben definir posiciones y direcciones específicas y compararlas con los valores devueltos después de procesar la cadena de comandos. Si el rover gira correctamente, la prueba será exitosa.
En resumen, el ejercicio de TDD para MarsRover consiste en desarrollar pruebas para verificar si el programa puede determinar la posición y la dirección del rover, si puede determinar si el rover se encuentra en una posición y dirección específica, si puede mover al rover hacia adelante o hacia atrás según la dirección en la que esté orientado, y si puede girar a la izquierda o a la derecha según la dirección en la que esté orientado.

### Condiciones

MarsRover inicia su sistema y necesita saber en que posicion esta y en que direccion esta mirando por ejemplo, el rover puede estar en la posicion x=1, y=1 y mirando al norte (N) o al sur (S) o al este (E) o al oeste (W)
MarsRover necesita saber si esta en una posicion determinada y mirando en una direccion determinada es decir, si esta en la posicion 1,1,N y se le pregunta si esta en la posicion 1,1,N debe responder true
MarsRover procesa una cadena de comandos y se mueve según el punto cardinal al que esta mirando.

#### Moverse hacia adelante

- si esta en la posicion x=1, y=1, direccion=N;
- y se le pasa la cadena "f" (forward);
- debe moverse a la posicion x=1, y=2, direccion=N;
- aumenta la coordenada y en 1 (y+1);
- se mantiene en la direccion N porque no se le ha dado la orden de girar.

#### Moverse hacia atrás

- si esta en la posicion x=1, y=1, direccion=N;
- y se le pasa la cadena "b" (backward);
- debe moverse a la posicion x=1, y=0, direccion=N;
- disminuye la coordenada y en 1 (y-1);
- se mantiene en la direccion N porque no se le ha dado la orden de girar.

#### Girar a la izquierda

- si esta en la posicion x=1, y=1, direccion=N;
- y se le pasa la cadena "l" (left);
- debe moverse a la posicion x=1, y=1, direccion=W (oeste);
- se mantiene en la posicion x=1, y=1;
- cambia la direccion de N a W.

#### Girar a la derecha

- si esta en la posicion x=1, y=1, direccion=N;
- y se le pasa la cadena "r" (right);
- debe moverse a la posicion x=1, y=1, direccion=E (este);
- se mantiene en la posicion x=1, y=1;
- cambia la direccion de N a E.

##### Ejemplo de cadena de comandos #1

- si esta en la posicion x=1, y=1, direccion=N;
- y se le pasa la cadena "fb" (forward, backward);
- con el comando "f" avanza una posicion en la direccion en la que esta mirando, es decir, al norte (N) y queda en la posicion x=1, y=2;
- con el comando "b" retrocede una posicion en la direccion en la que esta mirando, es decir, al norte (N) y queda en la posicion x=1, y=1;
- debe moverse a la posicion x=1, y=1, direccion=N.

##### Ejemplo de cadena de comandos #2

- si esta en la posicion x=1, y=1, direccion=N;
- y se le pasa la cadena "lfr" (left, forward, right);
- con el comando "l" gira a la izquierda y queda mirando al oeste (W);
- con el comando "f" avanza una posicion en la direccion en la que esta mirando, es decir, al oeste (W) y queda en la posicion x=0, y=1;
- con el comando "r" gira a la derecha y queda mirando al norte (N);
- debe moverse a la posicion x=0, y=1, direccion=N.

##### Ejemplo de cadena de comandos #3

- si esta en la posicion x=1, y=1, direccion=N;
- y se le pasa la cadena "ffrfflfrff" (forward, forward, right, forward, forward, left, forward, right, forward, forward);
- con el comando "f" avanza una posicion en la direccion en la que esta mirando, es decir, al norte (N) y queda en la posicion x=1, y=2;
- con el comando "f" avanza una posicion en la direccion en la que esta mirando, es decir, al norte (N) y queda en la posicion x=1, y=3;
- con el comando "r" gira a la derecha y queda mirando al este (E);
- con el comando "f" avanza una posicion en la direccion en la que esta mirando, es decir, al este (E) y queda en la posicion x=2, y=3;
- con el comando "f" avanza una posicion en la direccion en la que esta mirando, es decir, al este (E) y queda en la posicion x=3, y=3;
- con el comando "l" gira a la izquierda y queda mirando al norte (N);
- con el comando "f" avanza una posicion en la direccion en la que esta mirando, es decir, al norte (N) y queda en la posicion x=3, y=4;
- con el comando "r" gira a la derecha y queda mirando al este (E);
- con el comando "f" avanza una posicion en la direccion en la que esta mirando, es decir, al este (E) y queda en la posicion x=4, y=4;
- con el comando "f" avanza una posicion en la direccion en la que esta mirando, es decir, al este (E) y queda en la posicion x=5, y=4;
- debe moverse a la posicion x=5, y=4, direccion=E.

##### Ejemplo de cadena de comandos #4

- si esta en la posicion x=1, y=1, direccion=N;
- y se le pasa la cadena "fbblrr" (forward, backward, backward, left, right, right);
- con el comando "f" avanza una posicion en la direccion en la que esta mirando, es decir, al norte (N) y queda en la posicion x=1, y=2;
- con el comando "b" retrocede una posicion en la direccion en la que esta mirando, es decir, al norte (N) y queda en la posicion x=1, y=1;
- con el comando "b" retrocede una posicion en la direccion en la que esta mirando, es decir, al norte (N) y queda en la posicion x=1, y=0;
- con el comando "l" gira a la izquierda y queda mirando al oeste (W);
- con el comando "r" gira a la derecha y queda mirando al norte (N);
- con el comando "r" gira a la derecha y queda mirando al este (E);
- debe moverse a la posicion x=1, y=0, direccion=E.
