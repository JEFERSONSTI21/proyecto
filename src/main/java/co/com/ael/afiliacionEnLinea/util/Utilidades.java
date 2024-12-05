package co.com.sura.acelerador.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Base64;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {
    private Utilidades() {
    }
    public static String decodificarBase64(String encodedData) {
        return new String(Base64.getDecoder().decode(encodedData));
    }

    public static String extraerNumeroCadena(String inputText) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputText);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }


    public static String calcularIva(String valorConIva) {
        try {
            
            String valorSinPuntos = valorConIva.replace(".", "");
            double valorNumerico = Double.parseDouble(valorSinPuntos);

            long valorIva = Math.round(valorNumerico - (valorNumerico / Constantes.VALOR_IVA));

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("es", "CO"));
            symbols.setGroupingSeparator('.');
            symbols.setDecimalSeparator(',');
            DecimalFormat formatter = new DecimalFormat("#,###", symbols);

            return formatter.format(valorIva);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El valor proporcionado no es válido: " + valorConIva, e);
        }
    }
}
