package co.com.sura.acelerador.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class EnterInteraction implements Interaction {

    public EnterInteraction() {
        //Constructor vacio para poder interactuar con el enter
    }

    public static Performable enterAccion() {
        return new EnterInteraction();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions action = new Actions(actor.usingAbilityTo(BrowseTheWeb.class).getDriver());
        action.sendKeys(Keys.ENTER).build().perform();
    }
}
