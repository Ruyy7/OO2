![IMG_20240627_101022999](https://github.com/Ruyy7/OO2/assets/87097965/31fd13e8-0a9d-4e13-8515-9a2f78c21130)

## Inciso 1
a) No ya que el método ```listarTareas()``` de la clase ```Calendario``` es parte del frozenspot del framework, es decir, de la parte no modificable.
b) Los programadores pueden incluir nuevas tareas para la aplicación ya que la clase abstracta ```Tarea``` forma parte del hotspot del framework.
c) No se puede modificar ya que el listado de tareas es labor de la clase ```Calendario``` la cual, como antes mencioné, es parte del frozenspot del framework.
d) Si, se puede implementar una tarea que incluya el comportamiento mencionado, ya que, el atributo de fecha pertenece a la clase abstracta de tarea y utilizando un getter del atributo podríamos crear un algortimo que cumpla con lo solicitado.

## Inciso 2
Si, el método gancho del framework es ```getNivelDeUrgencia()```, el cual, si bien se encuentra implementado en la clase abstracta ```Tarea```, podríamos sobreescribirlo y modificar el comportamiento en cada una de las subclases que implementemos.

## Inciso 3
En la clase turno no hay una inversión de control como tal pero si en la clase calendario en el método ```listarTareas()``` el cual la inversión de control se percibe cuando este método llama a el método ```getNivelDeUrgencia()``` de una tarea que hayamos implementado.
