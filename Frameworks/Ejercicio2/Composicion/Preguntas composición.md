**a. ¿Qué debo hacer si aparece una nueva fuente de locomoción (por ejemplo, motor con ruedas con tracción 4x4)? ¿Cuántas y cuáles clases debo agregar en caso de querer todas las variantes de robots posibles para este nuevo tipo de sistema de locomoción?**

En el caso que quiera agregar una nueva fuente de locomoción solo debemos agregar una subclase nueva que se extienda de la clase ```Locomotion```

**b. ¿Puedo cambiarle, a un robot existente, el sistema de armas sin tener que instanciar el robot de nuevo?**

Si, ya que no hace falta generar una clase de un robot específico con un arma específica. Con un setter para las armas bastaría.

**c. ¿Dónde almacenaría usted el nivel de carga de la batería? ¿Qué implicaría eso si antes de disparar el láser hay que garantizar que la fuente de energía puede satisfacer el consumo del arma?**

En nivel de carga de la batería lo almacenaria en la clase ```EnegySource``` ya que corresponde que la fuente de alimentación del robot sepa manejar sus niveles de energía. 
En el caso de disparar con un laser solo deberíamos preguntar si la cantidad que este consume no supera la capacidad de la fuente de alimentación. Podriamos hacer un método en la clase ```EnergySource``` que devuelva un booleano si es posible consumir la cantidad de energía
que solicita el laser. La clase ```LaserSystem``` le enviaría un mensaje a ```EnergySource```.
