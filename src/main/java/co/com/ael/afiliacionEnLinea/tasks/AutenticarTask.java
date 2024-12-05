package co.com.sura.acelerador.tasks;

import co.com.sura.acelerador.interactions.EsperaElementoInteraction;
import co.com.sura.acelerador.models.InicioSesionModel;
import co.com.sura.acelerador.util.Utilidades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;

import static co.com.sura.acelerador.userinterfaces.AccesoUserInterface.TXT_USUARIO;
import static co.com.sura.acelerador.userinterfaces.AccesoUserInterface.TXT_CLAVE;
import static co.com.sura.acelerador.userinterfaces.PaginaPrincipalUserInterface.SPN_HOME_MENSAJE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AutenticarTask implements Task {

    public static Performable autenticar() {
        return instrumented(AutenticarTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperaElementoInteraction.esperaElemento(TXT_USUARIO),
                Enter.theValue(Utilidades.decodificarBase64(InicioSesionModel.getUsuario())).into(TXT_USUARIO),
                Enter.theValue(Utilidades.decodificarBase64(InicioSesionModel.getClave())).into(TXT_CLAVE),
                Click.on(Button.withText("Acceder al sistema")),
                EsperaElementoInteraction.esperaElemento(SPN_HOME_MENSAJE)
        );
    }
}

