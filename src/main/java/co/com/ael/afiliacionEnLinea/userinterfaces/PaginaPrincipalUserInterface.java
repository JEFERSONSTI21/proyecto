package co.com.sura.acelerador.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaPrincipalUserInterface {
    private PaginaPrincipalUserInterface() {
    }
    public static final Target SPN_HOME_TITLE = Target.the("Título de la página de inicio").located(By.xpath("//span[@class='sapUshellAppTitleText']"));
    public static final Target SPN_HOME_MENSAJE  = Target.the("Mensaje de validación").located(By.xpath("//span[contains(text(),'¿Todavía no hay nada')]"));

    public static final Target BTN_ICONO_BUSQUEDA  = Target.the("Botón de búsqueda").located(By.xpath("//div[@id='shell-header-hdr-end']//a[@data-help-id='shellHeader-search']"));

    public static final Target TXT_BUSQUEDA  = Target.the("Campo de entrada de búsqueda").located(By.xpath("//input[@id='searchFieldInShell-input-inner']"));

    public static final Target LNK_OPCION_MODULO = Target.the("Enlace de opción del módulo").located(By.xpath("//li//span[contains(@id,'text')]"));
    public static final Target LNK_OPCION_MODULO_POSICION = Target.the("Enlace de opción del módulo definido").locatedBy("(//li//span[contains(@id,'text')])[{0}]");

    public static final Target LNK_MODULO_OPCION_MENU_IGUAL = Target.the("Opción del módulo").locatedBy("(//div[@class='sapMGTHdrTxt'])['{0}']");

}
