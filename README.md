# Acceso a datos AA
## Actividad de aprendizaje de Acceso a datos 2ºDAM

Creacion del para una api de paqueteria.

## Datos

- Se almacenan los datos referentes a los camiones, a los conductores, los usuarios y por supuesto los paquetes.

## Funciones

- Se podran tener los datos de los **camiones**, **conductores**, **usuarios** y **paquetes**.
- Se podran **eliminar**, **modificar** y **crear** nuevos elementos de cada una de las clases.

## Relaciones

- La primera relacion es la de **camion** con **conductor**. Un camion puede ser conducido por muchos conductores.
  Y un conductor puede conducir muchos camiones *(ManyToMany)*
- La segunda relacion surge de la clase **paquete**. Un paquete puede ser entregado por un conductor, y un conductor puede entregar 
  muchos paquetes. El usuario tiene la misma relacion, puede recibir muchos paquetes y un paquete solo puede ser recibido por un usuario. *(OneToMany)*
  
## Extras
  
- Todas las clases tienen controladas las **excepciones**, y mas concretamente las 404.
- Se podran realizar pruebas con el programa **postman** y la **coleccion** que esta añadida al proyecto.
- Cuenta con un codigo que genera el **log** de practicamente todas las operaciones y metodos del proyecto.
- Filtrado cada clase por un parametro.
  - Usuario y conductor por direccion.
  - Paquete por color.
  - Camiones por marca.
