# Preguntas herencia.
**a. ¿Qué debo hacer si aparece una nueva fuente de energía (por ejemplo, paneles solares con baterías)? ¿Cuántas y cuáles clases debo agregar en caso de querer todas las variantes de robots posibles para este nuevo tipo de fuente de energía?**

Debería crear un tipo de robot con el tipo de energía deseado. Respondiendo a la segunda pregunta si agregó un robot con paneles solares con baterías debería realizar las siguientes subclases:
-	```SolarPanelWithBatteriesRobot```
-	```SolarPanelWithBatteriesCaterpillarRobot```
-	```SolarPanelWithBatteriesCaterpillarRobotWithBombs```
-	```SolarPanelWithBatteriesCaterpillarRobotWithLasers```
-	```SolarPanelWithBatteriesOvercraftRobot```
-	```SolarPanelWithBatteriesOvercraftRobotWithBombs```
-	```SolarPanelWithBatteriesOvercraftRobotWithLasers```

Es decir 7 clases en total.

**b. ¿Puedo cambiarle, a un robot existente, el sistema de armas sin tener que instanciar el robot de nuevo?**

No, dería crear un nuevo robot con el sistema de armas que quiera.

**c. ¿Dónde almacenaría usted el nivel de carga de la batería? ¿Qué implicaría eso sí antes de disparar el láser hay que garantizar que la fuente de energía puede satisfacer el consumo del arma?**

El nivel de carga de la bateria lo implementaría en la clase ```SolarPanelWithBatteriesRobot```. Respondiendo a la segunda pregunta debería tener un método en la clase ```SolarPanelWithBatteriesRobot``` que reciba una cantidad N de energía y devuelva un booleano si puede satisfacer el consumo del arma o no. En cada método de fireArms que incluyan un arma láser debemos debemos realzar el chequeo, esto hace que se repíta en este caso 2 veces el código: ```SolarPanelWithBatteriesCaterpillarRobotWithLasers``` y ```SolarPanelWithBatteriesOvercraftRobotWithLasers```.
