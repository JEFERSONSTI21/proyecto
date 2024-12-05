package co.com.sura.acelerador.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;


public class LecturaExcel {

    public List<Map<String, String>> obtenerDatos(String rutaArchivoExcel, String nombreHoja) throws IOException {

        Sheet hoja = obtenerHojaPorNombre(rutaArchivoExcel, nombreHoja);
        return leerHoja(hoja);
    }

    private Sheet obtenerHojaPorNombre(String rutaArchivoExcel, String nombreHoja) throws IOException {

        return obtenerLibroExcel(rutaArchivoExcel).getSheet(nombreHoja);
    }

    private Workbook obtenerLibroExcel(String rutaArchivoExcel) throws IOException {
        File archivo = new File(rutaArchivoExcel);
        FileInputStream archivoInput = new FileInputStream(archivo);
        return WorkbookFactory.create(archivoInput);
    }

    private List<Map<String, String>> leerHoja(Sheet hoja) {

        Row fila;
        int totalFilas  = hoja.getPhysicalNumberOfRows();
        List<Map<String, String>> filasExcel = new ArrayList<>();
        int numeroFilaCabecera = obtenerNumeroFilaCabecera(hoja);

        if (numeroFilaCabecera != -1) {

            int totalColumnas = hoja.getRow(numeroFilaCabecera).getLastCellNum();
            int filaActual = 1;
            for (int filaCorriente  = filaActual ; filaCorriente <= totalFilas; filaCorriente++) {

                fila = obtenerFila(hoja, hoja.getFirstRowNum() + filaCorriente);
                LinkedHashMap<String, String> datosColumna = new LinkedHashMap<>();

                for (int columnaCorriente = 0; columnaCorriente < totalColumnas; columnaCorriente++) {

                    datosColumna .putAll(obtenerValorCelda(hoja, fila, columnaCorriente));
                }

                filasExcel.add(datosColumna);
            }
        }

        return filasExcel;
    }

    private int obtenerNumeroFilaCabecera(Sheet hoja) {

        Row fila;
        int totalFilas = hoja.getLastRowNum();

        for (int filaCorriente = 0; filaCorriente <= totalFilas + 1; filaCorriente++) {

            fila = obtenerFila(hoja, filaCorriente);

            if (fila != null) {

                int totalColumnas = fila.getLastCellNum();

                for (int columnaCorriente = 0; columnaCorriente < totalColumnas; columnaCorriente++) {

                    Cell celda;
                    celda = fila.getCell(columnaCorriente, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (celda.getCellType() == CellType.STRING || celda.getCellType() == CellType.NUMERIC || celda.getCellType() == CellType.BOOLEAN || celda.getCellType() == CellType.ERROR) {

                        return fila.getRowNum();
                    }
                }
            }
        }

        return (-1);
    }

    private Row obtenerFila(Sheet hoja, int numeroFila) {

        return hoja.getRow(numeroFila);
    }

    private static LinkedHashMap<String, String> obtenerValorCelda(Sheet hoja, Row fila, int columnaCorriente) {
        LinkedHashMap<String, String> datosColumna = new LinkedHashMap<>();
        Cell celda;
        try {

            if (fila == null) {

                if (hoja.getRow(hoja.getFirstRowNum()).getCell(columnaCorriente, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {

                    String nombreCabeceraColumna = hoja.getRow(hoja.getFirstRowNum()).getCell(columnaCorriente).getStringCellValue();
                    datosColumna.put(nombreCabeceraColumna, "");
                }
            } else {

                celda = fila.getCell(columnaCorriente, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                String[] data = obtenerValorPorTipoCelda(celda, hoja.getRow(hoja.getFirstRowNum()).getCell(celda.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
                datosColumna.put(data[0], data[1]);
            }

            return datosColumna;
        } catch(Exception e) {
            e.getMessage();
        }
        return datosColumna;
    }

    private static  String[] obtenerValorPorTipoCelda(Cell celdaPorTipo, Cell celdaDatos) {

        String[] data = new String[2];

        if (celdaDatos.getCellType() != CellType.BLANK) {

            data[0] = celdaDatos.getStringCellValue();

            if (celdaPorTipo.getCellType() == CellType.STRING) {
                data[1] = celdaPorTipo.getStringCellValue();
            }else if (celdaPorTipo.getCellType() == CellType.NUMERIC) {
                data[1] = NumberToTextConverter.toText(celdaPorTipo.getNumericCellValue());
            }else if(celdaPorTipo.getCellType() == CellType.BLANK) {
                data[1] = "";
            }else if (celdaPorTipo.getCellType() == CellType.BOOLEAN) {
                data[1] = Boolean.toString(celdaPorTipo.getBooleanCellValue());
            }else if (celdaPorTipo.getCellType() == CellType.ERROR) {
                data[1] = Byte.toString(celdaPorTipo.getErrorCellValue());
            }
        }

        return data;

    }
}