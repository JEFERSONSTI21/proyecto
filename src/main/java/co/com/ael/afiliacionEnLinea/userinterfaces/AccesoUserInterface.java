package co.com.sura.acelerador.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class AccesoUserInterface {
    private AccesoUserInterface() {
    }
    public static final Target TXT_USUARIO = Target.the("Campo de texto para el usuario").located(By.xpath("//div[@id='USERNAME_BLOCK']//input"));
    public static final Target TXT_CLAVE = Target.the("Campo de texto para la contraseña").located(By.xpath("//div[@id='PASSWORD_BLOCK']//input"));
}
