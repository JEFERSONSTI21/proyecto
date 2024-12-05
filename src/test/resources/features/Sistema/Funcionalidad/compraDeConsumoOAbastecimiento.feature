#language: es
@compraDeConsumoOAbastecimiento
Característica: Como analista de automatizacion de pruebas o desarrollador
  Quiero probar la funcionalidad crear un material
  Para verificar la calidad de la aplicacion

  Antecedentes:
    Dado que se obtuvieron los datos del caso a ejecutar 1 iniciarSesion
    Y que el usuario ingreso a FIORI
    Cuando el usuario autentica con su usuario y contrasena
    Entonces el sistema debería mostrar la aplicacion home

  Esquema del escenario: Validar la funcionalidad para crear un material
    Dado que se obtuvieron los datos del caso a ejecutar <caso> crearMaterial
    Y que el usuario ingreso al modulo Creación de materiales
    Y que el usuario accedio a la aplicacion 1
    Cuando el usuario ingresa los datos del material a crear
    Entonces el sistema validara y confirmara la creacion exitosa del material

    Ejemplos:
      | caso |
      ##@externaldata@src/test/resources/datadriven/crearMaterial.xlsx@Hoja1
|1|

  Esquema del escenario: Validar la funcionalidad para crear un registro de información de compra
    Dado que se obtuvieron los datos del caso a ejecutar <caso> crearRegistroCompra
    Y que el usuario ingreso al modulo Gestionar registros de información de compras
    Cuando el usuario ingresa los datos del registro de comprar a crear
    Entonces el sistema validara y confirmara la creacion del registro de compra

    Ejemplos:
      | caso |
      ##@externaldata@src/test/resources/datadriven/crearRegistroCompra.xlsx@Hoja1
|1|

  Esquema del escenario: Validar funcionalidad crear una solicitud de pedido
    Dado que se obtuvieron los datos del caso a ejecutar <caso> crearSolicitudPedido
    Y que el usuario ingreso al modulo Gestión de solicitudes de pedido Profesional
    Cuando el usuario ingresa los datos de la solicitud de pedido a crear
    Entonces el sistema validara y confirmara la creacion de la solicitud de pedido

    Ejemplos:

      | caso |
      ##@externaldata@src/test/resources/datadriven/crearSolicitudPedido.xlsx@Hoja1
|1|

  Esquema del escenario: Validar funcionalidad convertir pedido en orden de compra
    Dado que se obtuvieron los datos del caso a ejecutar <caso> conversionPedidoAOrdenCompra
    Y que el usuario ingreso al modulo Procesar solicitudes de pedido antes, Gestionar solicitudes
    Cuando el usuario realiza el proceso de convertir pedido en orden de compra
    Entonces el sistema validara y confirmara la creacion de orden de compra

    Ejemplos:
      | caso |
      ##@externaldata@src/test/resources/datadriven/conversionPedidoAOrdenCompra.xlsx@Hoja1
|1|


  Esquema del escenario: Validar funcionalidad Contabilizar entrada mercancia
    Dado que se obtuvieron los datos del caso a ejecutar <caso> contabilizacionEntradaMercancia
    Y que el usuario ingreso al modulo Contabilizar movimiento mercancias
    Cuando el usuario realiza el proceso de contabilizacion de entrada mercancia a crear
    Entonces el sistema validara y confirmara la contabilizacion de entrada mercancia

    Ejemplos:
      | caso |
      ##@externaldata@src/test/resources/datadriven/contabilizacionEntradaMercancia.xlsx@Hoja1
|1|


  Esquema del escenario: Validar funcionalidad Crear factura de proveedor
    Dado que se obtuvieron los datos del caso a ejecutar <caso> crearFacturaProveedor
    Y que el usuario ingreso al modulo Crear factura de proveedor
    Cuando el usuario registra los datos para la factura proveedor a crear
    Entonces el sistema validara y confirmara creacion factura proveedor

    Ejemplos:
      | caso |
##@externaldata@src/test/resources/datadriven/crearFacturaProveedor.xlsx@Hoja1
|1|
