![1](https://github.com/Ruyy7/OO2/assets/87097965/e8440792-b14f-48d3-8287-9f14b0eb78c2)

## Respuesta 1

Si ya que RuleEngine sería el Manejador de eventos del framework, es decir, el Framework tiene un flujo de procesamiento especifico pero este hace uso también de partes programables que nosostros implementemos, es decir, de los hook methods que el framework nos permite
implementar.

El Framework realizará la mayor parte de la labor de nuestra aplicación pero utilizara parte de nuestra lógica de nuestra implementación, en este una implementación concreta de la clase ```Rule``` para continuar luego con la ejecución del mismo. Luego el método ```Run()``` de ambas clases tiene determinado el flujo de ejecución de las reglas.

Conclusión: El framework es quien tiene el flujo de ejecución del programa, nosotros mediante los hook method deeterminamos si se ejecuta una regla o no pero las mismas son ejecutadas por el framework.

## Respuesta 2
Los hook method serian ```shouldProcess()``` y ```process()```

## Respuesta 3
En este caso el frozen spot se localiza en el método ```Run()``` de ambas clases, el cual determina de forma concisa de que manera se ejecutaran las reglas.
