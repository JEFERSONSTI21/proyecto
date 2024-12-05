package co.com.sura.acelerador.util.excel;


public class DatosBasadosEnCasos {
    DatosExcelBasadosEnCasos datosExcelBasadosEnCasos = new DatosExcelBasadosEnCasos();

    public void obtenerDatosPrueba(int intCaso, String strCaso, String ruta) {
        datosExcelBasadosEnCasos.cargarMapaDatos(intCaso, strCaso, ruta);
    }

}
