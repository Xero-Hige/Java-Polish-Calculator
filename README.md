# TP0 - inicial

La idea de este tp0 es que se familiaricen con las herramientas que vamos a usar para el tp principal de la materia.

### Problema

Implementar una calculadora como las viejas HP que aceptaban "Reverse Polish notation" (RPN).

Ej:

*   8 2 + = 8 + 2 = 10
*   5 1 2 + 4 × + 3 − = 14

### Aclaraciones

* Los valores/operadores estarán separados por un espacio.
* Hay operadores binarios y n-arios:
    * Binarios: +, -, /, *, MOD
    * n-arios: ++, --, //, **
* Si un n-ario tiene un solo operando para trabajar, devolver ese operando, es decir: 10 ++ --> 10

### Restricciones

* El trabajo es individual.
* Se deben utilizar las herramientas propuestas por la cátedra: java8, junit4, gradle, git, bitbucket.
* No usar libs externas. (excepto las de la jdk, es decir, String, List, Queue, Streams, etc).
* No usar ningún if/switch/try-catch/operador ternario/break/continue.
* No usar herencia.
* El comando: "gradle build" no deberá tirar ningún error.

### Instrucciones generales (investigar)
* Instalar la JDK8 en su sistema operativo.
* Forkear el proyecto en bitbucket.
* invitar al usuario tdd7510.
* Correr ./gradlew o gradlew.bat según corresponda (Este comando bajara una serie de herramientas, tardará como 10 min)
* Para "buildear": gradle build  (gradle == ./gradlew o gradlew.bat)
* Para "checkear" el código: gradle check
* Para correr los tests: gradle test

### Fecha de entrega
* Jueves 10 de septiembre.
* Armar un tag con el nombre "entrega" y avisar por slack.
