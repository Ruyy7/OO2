# 1.2 Participación en proyectos

![image](https://github.com/Ruyy7/OO2/assets/87097965/f1d6dfe0-1e7c-41e4-85bb-3e7d43f3336f)

Se cambio la manera de obtener si una persona participa en un proyecto, en el primer escenario la persona es quien sabe buscarse en un proyecto solicitando a el proyecto
su colección de participantes y utilizando el contains pasandose a si mismo.

En cambio en el diseño revisado el proyecto es quien sabe buscar a un participante recibiendo a una persona como parametro y buscando en su colección si esa persona se encuentra
o no.

**Para mi criterio** la solución revisada me parece la mas adecuada porque es la clase contenedora quien debe manipular su colección y no otra clase.

Este fenomeno se conoce como ***"Feature Envy"*** el cual una clase se la llama envidiosa porque realiza acciones que no son de su naturaleza.
