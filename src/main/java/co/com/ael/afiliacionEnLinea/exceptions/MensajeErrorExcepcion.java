package co.com.sura.acelerador.exceptions;

public class MensajeErrorExcepcion extends AssertionError {

    public static final String MSJ_EXCEP_INICIO_SESION = "Error al intentar iniciar sesión en la página FIORI. Verifique las credenciales y la conexión.";
    public static final String MSJ_EXCEP_CREACION_BANCO = "Error al crear el Banco. Revise los datos ingresados y asegúrese de que los requisitos estén completos.";
    public static final String MSJ_EXCEP_CREACION_INTERLOCUTOR = "Error al crear el Interlocutor. Verifique los detalles proporcionados y los permisos necesarios.";
    public static final String MSJ_EXCEP_MODIFICACION_INTERLOCUTOR = "Error al modificar el Interlocutor. Verifique los detalles proporcionados y los permisos necesarios.";
    public static final String MSJ_EXCEP_CREACION_MATERIAL = "Error al crear el Material. Asegúrese de que los datos ingresados sean válidos y completos.";
    public static final String MSJ_EXCEP_CREACION_REGISTRO_COMPRA = "Error al crear el Registro de Compra. Asegúrese de que los datos ingresados sean válidos y completos.";
    public static final String MSJ_EXCEP_CREACION_SOLICITUD_PEDIDO = "Error al crear la solicitud de pedido. Asegúrese de que los datos ingresados sean válidos y completos.";
    public static final String MSJ_EXCEP_CREACION_ORDEN_COMPRA = "Error al crear la orden de compra. Asegúrese de que los datos ingresados sean válidos y completos.";
    public static final String MSJ_EXCEP_CREACION_CONTABILIZACION_MERCANCIA = "Error al crear la contabilizacion de entrada de mercancia. Asegúrese de que los datos ingresados sean válidos y completos.";
    public static final String MSJ_EXCEP_CREACION_FACTURA_PROVEEDOR = "Error al realizar la creacion factura proveedor. Asegúrese de que los datos ingresados sean válidos y completos.";
    public static final String MSJ_EXCEP_CREACION_FACTURA_VENTA = "Error al realizar la creacion factura venta. Asegúrese de que los datos ingresados sean válidos y completos.";
    public static final String MSJ_EXCEP_CREACION_OFERTA_VENTA = "Error al realizar la creacion de oferta venta. Asegúrese de que los datos ingresados sean válidos y completos.";
    public static final String MSJ_EXCEP_CREACION_CONTRATO_VENTA = "Error al realizar la creacion de contrato venta. Asegúrese de que los datos ingresados sean válidos y completos.";
    public static final String MSJ_EXCEP_CREACION_SOLICITUD_PEDIDO_VENTA = "Error al crear la solicitud de pedido venta. Asegúrese de que los datos ingresados sean válidos y completos.";

    public MensajeErrorExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

}
