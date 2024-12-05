package co.com.sura.acelerador.util.excel;

import co.com.sura.acelerador.util.ConstantesExcel;
import com.google.common.base.Charsets;

import org.apache.commons.lang3.StringUtils;


import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EscrituraFeature {

    private EscrituraFeature() {

        throw new IllegalStateException(ConstantesExcel.ESCRITURA_FEATURE);
    }

        private static List<String> escribirDatosExcelFeature(File archivoFeature) throws  IOException {

        List<String> datosArchivo = new ArrayList<>();

        try (BufferedReader buffReader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(new FileInputStream(archivoFeature)), Charsets.UTF_8))) {

            String datos;
            boolean datosFeature = false;

            while ((datos = buffReader.readLine()) != null) {

                if (datos.trim().contains(ConstantesExcel.EXTERNAL_DATA)) {

                    datosArchivo = configurarDatosExcel(datos, datosArchivo);
                    datosFeature = true;

                } else {

                    if (datos.startsWith("|") || datos.endsWith("|")) {

                        if (!datosFeature) {

                            datosArchivo.add(datos);
                        }
                    } else {

                        datosArchivo.add(datos);
                        datosFeature = false;
                    }
                }
            }
        }

        return datosArchivo;
    }

    private static List<String> configurarDatosExcel(String datos, List<String> datosArchivo)
            throws  IOException {

        String rutaArchivoExcel = datos.substring(StringUtils.ordinalIndexOf(datos, "@", 2) + 1, datos.lastIndexOf('@'));
        datosArchivo.add(datos);
        return iteracionArraysData(
                new LecturaExcel().obtenerDatos(rutaArchivoExcel, datos.substring(datos.lastIndexOf('@') + 1, datos.length())),
                datosArchivo);
    }

    private static List<File> listarArchivosFeature(File carpeta) {

        List<File> archivosFeature = new ArrayList<>();

        for (File archivoEntrada : carpeta.listFiles()) {

            if (archivoEntrada.isDirectory()) {

                archivosFeature.addAll(listarArchivosFeature(archivoEntrada));

            } else {

                if (archivoEntrada.isFile() && archivoEntrada.getName().endsWith(".feature")) {
                    archivosFeature.add(archivoEntrada);
                }
            }
        }
        return archivosFeature;
    }

    public static void sobreescribirArchivosFeature(String rutaDirectorioFeatures)
            throws IOException {

        List<File> listaArchivosFeature = listarArchivosFeature(new File(rutaDirectorioFeatures));

        for (File archivoFeature : listaArchivosFeature) {

            List<String> featureConDatosExcel = escribirDatosExcelFeature(archivoFeature);

            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(archivoFeature), Charsets.UTF_8));) {

                for (String string : featureConDatosExcel) {
                    writer.write(string);
                    writer.write(System.lineSeparator());
                }
            }
        }
    }

    private static List<String> iteracionArraysData(List<Map<String, String>> datosExcel, List<String> datosArchivo) {

        try {

            int contador = 1;
            boolean bandera = true;

            for (int numeroFila = 0; numeroFila < datosExcel.size() - 1; numeroFila++) {

                StringBuilder datosCelda = new StringBuilder();

                for (Entry<String, String> datosMapa : datosExcel.get(numeroFila).entrySet()) {

                    if (datosMapa.getValue().equalsIgnoreCase(String.valueOf(contador))
                            && datosMapa.getKey().equalsIgnoreCase(ConstantesExcel.CASO)) {

                        datosCelda.append("|" + datosMapa.getValue());
                        contador++;

                    } else if (datosMapa.getValue().trim().isEmpty()) {
                        bandera = false;
                    }
                }

                if (bandera) {
                    datosArchivo.add(datosCelda.toString() + "|");
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }

        return datosArchivo;
    }
}
