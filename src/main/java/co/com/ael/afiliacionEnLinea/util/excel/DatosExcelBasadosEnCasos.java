package co.com.sura.acelerador.util.excel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class DatosExcelBasadosEnCasos {

    private static Map<String, String> mapaDatosExcel = new HashMap<>();

    private Logger logger = Logger.getLogger(DatosExcelBasadosEnCasos.class.getName());

    public static Map<String, String> getMapaDatosExcel() {
        return mapaDatosExcel;
    }

    /**
     * Metodo que extrae datos de excel y los carga al mapa de datos
     *
     * @param casoNumero Entero con fila de excel a cargar al mapa de datos
     * @param strCaso String con hoja de excel a cargar al mapa de datos
     */
    public void cargarMapaDatos(int casoNumero, String strCaso, String ruta) {
        try {

            DatosExcelBasadosEnCasos.getMapaDatosExcel().clear();
            List<Map<String, String>> datosExcel = new LecturaExcel().obtenerDatos(ruta, strCaso);

            for (Entry<String, String> mapData : datosExcel.get(casoNumero - 1).entrySet()) {
                setDataMap(mapData.getKey(), mapData.getValue());
            }
        } catch (Exception e) {
            logger.info("Error en metodo cargarMapaDatos de la clase DataDrivenExcel: " + e.getMessage());
        }
    }

    /**
     * Metodo que extrae los datos de mapa
     *
     * @param strDatoSolicitado String con valor de key a consultar en el mapa
     */
    public String getDataMap(String strDatoSolicitado) {
        String valor = DatosExcelBasadosEnCasos.getMapaDatosExcel().get(strDatoSolicitado);
        if (valor == null || valor.isEmpty()) {
            return "0";
        }
        return valor;
    }

    /**
     * Metodo que agrega datos al mapa
     *
     * @param strKey   String con valor de key a agregar en el mapa
     * @param strValue String con valor de dato a agregar en el mapa
     */
    public void setDataMap(String strKey, String strValue) {
        DatosExcelBasadosEnCasos.getMapaDatosExcel().put(strKey, strValue);
    }


}