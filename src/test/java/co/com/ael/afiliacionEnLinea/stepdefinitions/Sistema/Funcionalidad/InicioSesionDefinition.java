package co.com.sura.acelerador.stepdefinitions.Sistema.Funcionalidad;

import co.com.sura.acelerador.exceptions.MensajeErrorExcepcion;
import co.com.sura.acelerador.questions.ValidarMensajeComparacionQuestion;
import co.com.sura.acelerador.tasks.AutenticarTask;
import co.com.sura.acelerador.tasks.NavegarTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.sura.acelerador.exceptions.MensajeErrorExcepcion.MSJ_EXCEP_INICIO_SESION;
import static co.com.sura.acelerador.userinterfaces.PaginaPrincipalUserInterface.SPN_HOME_TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InicioSesionDefinition {
    private static final String USUARIO = "Usuario";
    private static final String HOME_PAGE_TITLE = "Página de inicio";

    @Before
    public void prepararEscenario(){
        setTheStage(new OnlineCast());
    }

    @Y("que el usuario ingreso a FIORI")
    public void ingresarAFiori() {
        theActorCalled(USUARIO).wasAbleTo(
                NavegarTask.navegarFiori()
        );
    }
    @Cuando("el usuario autentica con su usuario y contrasena")
    public void autenticarUsuario() {
        theActorInTheSpotlight().attemptsTo(
                AutenticarTask.autenticar()
        );
    }
    @Entonces("el sistema debería mostrar la aplicacion home")
    public void mostrarHome() {
        theActorInTheSpotlight().should(
                seeThat(ValidarMensajeComparacionQuestion.validarMensajeComparacion(SPN_HOME_TITLE,HOME_PAGE_TITLE))
                        .orComplainWith(MensajeErrorExcepcion.class,MSJ_EXCEP_INICIO_SESION));

    }
}
