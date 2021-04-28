package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Edwin y Marcos
 */
public class ETL {

    private JDBC jdbc;
    private int id_estacion;
    private int id_elemento;
    private float medicion;
    private int no_semana;
    private String fecha;

    public ETL() {
        jdbc = new JDBC("dataminingdba", "12345678", 3306, "contaminantes");
        jdbc.createConnection();
    }

    public void extract() {

        File directory = new File("../pph/");
        File[] fileArr = directory.listFiles();

        for (File file : fileArr) {
            extractDataFromExcel(file);
            break;
        }
    }

    public void extractDataFromExcel(File file) {
        String datePattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);

        id_elemento = getIdElemento(file.getName());
        FileInputStream originalFile = null;
        try {
            originalFile = new FileInputStream(file.getPath());
            Workbook book = WorkbookFactory.create(originalFile);
            Sheet sheet = book.getSheetAt(0);
            Iterator rows = sheet.rowIterator();

            List<String> header = new ArrayList();

            while (rows.hasNext()) {
                Row row = (Row) rows.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext()) {
                    Cell cell = (Cell) cells.next();

                    if (cell.getRowIndex() == 0) {
                        //Encabezado de la tabla
                        header.add(cell.getStringCellValue());
                    } else {
                        //Fecha
                        if (cell.getColumnIndex() == 0) {
                            fecha = dateFormat.format(cell.getDateCellValue());

                            Calendar cal = Calendar.getInstance();
                            cal.setTime(cell.getDateCellValue());
                            no_semana = cal.get(Calendar.WEEK_OF_YEAR);
                        } else {
                        //Medicion
                            medicion = (float) cell.getNumericCellValue();
                            String clave = header.get(cell.getColumnIndex());
                            id_estacion = getIdEstacion(clave);
                            
                            System.out.println(Integer.toString(id_estacion)+","
                                    +Integer.toString(id_elemento)+","
                                    +Float.toString(medicion)+","
                                    +Integer.toString(no_semana)+","
                                    +fecha);
                        }

                        
                    }
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ETL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | EncryptedDocumentException ex) {
            Logger.getLogger(ETL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int getIdElemento(String filename) {
        String clave = filename.substring(4, filename.length() - 5);
        return jdbc.FindIdElementoByClave(clave);
    }

    private int getIdEstacion(String claveEstacion) {
        if (claveEstacion.equals("CHA")) {
            claveEstacion = "MON";
        }
        return jdbc.FindIdEstacionByClaveEst(claveEstacion);
    }

}
