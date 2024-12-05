package co.com.sura.acelerador.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static co.com.sura.acelerador.userinterfaces.CrearMaterialUserInterface.CHK_OPCION;
import static co.com.sura.acelerador.userinterfaces.CrearMaterialUserInterface.LBL_OPCION_VISTA;

public class SeleccionarOpcionesDeVistasInteraction implements Interaction {

    private final String opcion;

    public SeleccionarOpcionesDeVistasInteraction(String opcion) {
        this.opcion = opcion;

    }


    public static Performable seleccionarCheckSeleccionVistas(String opcion) {
        return new SeleccionarOpcionesDeVistasInteraction(opcion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String posicionCheck;
        posicionCheck = LBL_OPCION_VISTA.of(opcion).resolveFor(actor).getAttribute("lsmatrixrowindex");

        actor.attemptsTo(
                EsperaElementoInteraction.esperaElemento(CHK_OPCION.of(posicionCheck)),
                ClickInteraction.clickAccion(CHK_OPCION.of(posicionCheck))
        );
    }
}
