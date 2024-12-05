package co.com.sura.acelerador.stepdefinitions.dataDriven;

import co.com.sura.acelerador.util.excel.DatosBasadosEnCasos;
import io.cucumber.java.es.Dado;

public class DataDrivenDataDeCasosDefinitions {
    DatosBasadosEnCasos datosBasadosEnCasos = new DatosBasadosEnCasos();


    @Dado("^que se obtuvieron los datos del caso a ejecutar (.*) (.*)")
    public void obtenerDatosCasoAEjecutar(String intCaso, String nombreDocumento) {
        String ruta = "src/test/resources/datadriven/"+nombreDocumento+".xlsx";
        datosBasadosEnCasos.obtenerDatosPrueba(Integer.parseInt(intCaso), "Hoja1", ruta);
    }

}
