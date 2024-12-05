package co.com.sura.acelerador.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class EsperaElementoInteraction implements Interaction {
    private static final int TIEMPO_DEFINIDO = 50;
    private final Target objeto;

    public EsperaElementoInteraction(Target objeto) {
        this.objeto = objeto;

    }


    public static Performable esperaElemento(Target objeto) {
        return new EsperaElementoInteraction(objeto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(objeto, WebElementStateMatchers.isPresent()).forNoMoreThan(TIEMPO_DEFINIDO).seconds(),
                WaitUntil.the(objeto, WebElementStateMatchers.isCurrentlyVisible()).forNoMoreThan(TIEMPO_DEFINIDO).seconds(),

                WaitUntil.the(objeto, WebElementStateMatchers.isEnabled()).forNoMoreThan(TIEMPO_DEFINIDO).seconds(),
                WaitUntil.the(objeto, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO_DEFINIDO).seconds(),

                WaitUntil.the(objeto, WebElementStateMatchers.isEnabled()).forNoMoreThan(TIEMPO_DEFINIDO).seconds(),
                WaitUntil.the(objeto, WebElementStateMatchers.isVisible()).forNoMoreThan(TIEMPO_DEFINIDO).seconds(),

                WaitUntil.the(objeto, WebElementStateMatchers.containsText("")).forNoMoreThan(TIEMPO_DEFINIDO).seconds()
        );
    }
}
