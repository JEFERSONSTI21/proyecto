package co.com.sura.acelerador.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;


public class ValidarMensajeCreacionQuestion implements Question<Boolean> {

    private final Target lblMensajeCreacion;

    private ValidarMensajeCreacionQuestion(Target lblMensajeCreacion) {
        this.lblMensajeCreacion = lblMensajeCreacion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(lblMensajeCreacion.resolveFor(actor).isDisplayed()).isTrue()
        );
        return true;
    }

    public static ValidarMensajeCreacionQuestion objetoVisible(Target lblMensajeCreacion) {
        return new ValidarMensajeCreacionQuestion(lblMensajeCreacion);
    }
}
