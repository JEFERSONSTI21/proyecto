package co.com.sura.acelerador.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.interactions.Actions;


public class DesplazamientoBarrasInteraction implements Interaction {

    private final Target objeto;
    private final int posicionX;
    private final int posicionY;

    public DesplazamientoBarrasInteraction(Target objeto, int posicionX, int posicionY) {
        this.objeto = objeto;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }


    public static Performable desplazamientoBarrasActions(Target objeto,int posicionX,int posicionY) {
        return new DesplazamientoBarrasInteraction(objeto,posicionX,posicionY);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions actions = new Actions(actor.usingAbilityTo(BrowseTheWeb.class).getDriver());

        actions.clickAndHold(objeto.resolveFor(actor))
                .moveByOffset(posicionX,posicionY)
                .release()
                .perform();
    }
}
