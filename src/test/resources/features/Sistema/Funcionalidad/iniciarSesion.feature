#language: es
@inicioSesion
Característica: Como analista de automatizacion de pruebas o desarrollador
  Quiero probar el iniciar de sesion de la aplicacion
  Para verificar la calidad de la aplicacion


  Esquema del escenario: Validar que al ingresar el usuario y contrasena correctos el sistema nos muestra el nombre de la aplicacion
    Dado que se obtuvieron los datos del caso a ejecutar <caso> iniciarSesion
    Dado que el usuario ingreso a FIORI
    Cuando el usuario autentica con su usuario y contrasena
    Entonces el sistema debería mostrar la aplicacion home

    Ejemplos:
      | caso |
          ##@externaldata@src/test/resources/datadriven/iniciarSesion.xlsx@Hoja1
|1|
