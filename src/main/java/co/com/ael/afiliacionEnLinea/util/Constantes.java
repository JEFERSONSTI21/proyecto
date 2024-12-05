package co.com.sura.acelerador.util;

import co.com.sura.acelerador.util.excel.DatosExcelBasadosEnCasos;

public class Constantes {
    private Constantes() {
    }
    public static final String FIORI_URL = "https://vhsxaws3wd01.sap.sura.com.co:44380/sap/bc/ui2/flp?sap-client=100&sap-language=ES#Shell-home";
    public static final Double VALOR_IVA = 1.19;

    private static DatosExcelBasadosEnCasos datosExcelBasadosEnCasos = new DatosExcelBasadosEnCasos();

    public static DatosExcelBasadosEnCasos getDatosExcelBasadosEnCasos() {
        return datosExcelBasadosEnCasos;
    }
}
