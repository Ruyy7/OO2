# Orden en que se refactorizó:
- **Clase Llamada**: Replace Type Code with Subclasses
- **Clase Cliente**: Replace Type Code with Subclasses

***En ambas clases se tuvo en cuenta el contexto del dominio, antes que el código de la clase Empresa***

- **Clase GestorNumerosDisponibles**: Replace Type Code with Strategy -> Se crea la clase Generador con sus respectivas subclases.
- **Clase llamada**: Move method.
- **Clase cliente**: Move method.
- **Clase cliente**: Push Down field.
- **Clase empresa**: Remove fields.
- **Clase empresa**: Replace loop with piline.
- **Clase empresa**: Remove middle man.
- **Clase empresa**: Move field.
- **Clase empresa**: Move method.
- **Clase cliente**: Remove parameters.
- **Clase llamada**: Rename method.
