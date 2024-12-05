package co.com.sura.acelerador.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.interactions.Actions;

public class ClickInteraction implements Interaction {

    private final Target element;

    public ClickInteraction(Target element) {
        this.element = element;
    }


    public static Performable clickAccion(Target element) {
        return new ClickInteraction(element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions action = new Actions(actor.usingAbilityTo(BrowseTheWeb.class).getDriver());
        action.click(element.resolveFor(actor)).perform();
    }
}
