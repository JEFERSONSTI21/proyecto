package co.com.sura.acelerador.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.interactions.Actions;

public class ClickCondicionalVisibleInteraction implements Interaction {

    private final Target objeto;

    public ClickCondicionalVisibleInteraction(Target objeto) {
        this.objeto = objeto;
    }

    public static ClickCondicionalVisibleInteraction clickCondicionalVisibleInteraction(Target objeto) {
        return new ClickCondicionalVisibleInteraction(objeto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(objeto, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(15).seconds(),
                    Check.whether(objeto.resolveFor(actor).isVisible())
                            .andIfSo(Click.on(objeto))
            );
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
