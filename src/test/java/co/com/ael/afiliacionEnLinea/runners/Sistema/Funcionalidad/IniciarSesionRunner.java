package co.com.sura.acelerador.runners.Sistema.Funcionalidad;

import co.com.sura.acelerador.util.ConstantesExcel;
import co.com.sura.acelerador.util.excel.EscrituraFeature;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Sistema/Funcionalidad",
        glue = "co.com.sura.acelerador.stepdefinitions",
        tags = "@inicioSesion",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class IniciarSesionRunner {

    @BeforeClass
    public static void prepararArchivosFeatures() throws IOException {
        EscrituraFeature.sobreescribirArchivosFeature(ConstantesExcel.RUTA_FEATURES);
    }
}
