package co.com.sura.acelerador.stepdefinitions.Sistema.Funcionalidad;

import co.com.sura.acelerador.tasks.SeleccionarAplicacionTask;
import co.com.sura.acelerador.tasks.SeleccionarModuloTask;
import co.com.sura.acelerador.tasks.SeleccionarPosicionDefinidaTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PaginaPrincipalDefinition {

    @Before
    public void prepararEscenario(){
        setTheStage(new OnlineCast());
    }
    @Y("^que el usuario ingreso al modulo (.*)")
    public void ingresarModuloDeseado(String modulo) {
        theActorInTheSpotlight().attemptsTo(SeleccionarModuloTask.seleccionarModulo(modulo));
    }
    @Y("^que el usuario ingreso por posicion al modulo (.*) (.*)")
    public void ingresarModuloPorPosicion(String modulo,String posicion) {
        theActorInTheSpotlight().attemptsTo(SeleccionarPosicionDefinidaTask.seleccionarPosicionDefinida(modulo,posicion));
    }

    @Y("^que el usuario accedio a la aplicacion (.*)")
    public void ingresarAplicacion(String opcion) {
        theActorInTheSpotlight().attemptsTo(SeleccionarAplicacionTask.seleccionarAplicacion(opcion));
    }

}
