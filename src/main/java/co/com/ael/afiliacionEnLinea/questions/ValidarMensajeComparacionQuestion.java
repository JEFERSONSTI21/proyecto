package co.com.sura.acelerador.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;


public class ValidarMensajeComparacionQuestion implements Question<Boolean> {
    private final Target elemento;
    private final String valorEsperado;

    private ValidarMensajeComparacionQuestion(Target elemento, String valorEsperado) {
        this.elemento = elemento;
        this.valorEsperado = valorEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String valorActual = elemento.resolveFor(actor).getText();
        actor.attemptsTo(
                Ensure.that(valorActual).isEqualTo(valorEsperado)
        );
        return true;
    }

    public static ValidarMensajeComparacionQuestion validarMensajeComparacion(Target elemento, String valorEsperado) {
        return new ValidarMensajeComparacionQuestion(elemento, valorEsperado);
    }
}