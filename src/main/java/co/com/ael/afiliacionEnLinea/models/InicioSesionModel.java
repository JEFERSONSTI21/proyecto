package co.com.sura.acelerador.models;

import co.com.sura.acelerador.util.Constantes;
import lombok.Data;

@Data
public class InicioSesionModel {

    private InicioSesionModel() {
    }

    public static String getUsuario() {
        return Constantes.getDatosExcelBasadosEnCasos().getDataMap("usuario");
    }

    public static String getClave() {
        return Constantes.getDatosExcelBasadosEnCasos().getDataMap("clave");
    }


}

