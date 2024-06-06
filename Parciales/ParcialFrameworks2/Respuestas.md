![2](https://github.com/Ruyy7/OO2/assets/87097965/4ecb9fad-ff85-4198-b50b-cc893bdc8206)

## Respuesta 1
Mediante herencia ya que la clase EmailFilter cuenta con 2 métodos abstractos ```isEmailAllowed``` y ```addEmail``` los cuales, si se quieren implementar de diferentes maneras, deberíamos crear subclases nuevas de EmailFilter.

## Respuesta 2
En el método ```filterEmail``` (líneas 8 a 12) ya que el flujo de control para filtrar un email está dado por el framework, este mismo utiliza las implementaciones de los métodos ```isEmailAllowed``` y ```addEmail``` que nosotros construimos pero como antes mencioné, el
flujo de control/ejecución esta determinado por la lógica del framework.

## Respuesta 3
Si, ya que queda a nuestro deber implementar un comportamiento al método ya que el mismo es abstracto dentro del código del framework dejandose a implementar por subclases que nosotros hagamos.
