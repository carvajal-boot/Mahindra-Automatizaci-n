package com.avianca.automation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.Types.NUMERIC;

public class DataDrivenExcel {

	private DecimalFormat df = new DecimalFormat("0.###");
	Logger logger = Logger.getLogger( DataDrivenExcel.class.getName()); 
	public Map<String, String> leerExcel(Excel excel) {
		// Variable que contendra todas las filas
		Map<String, String> datosExcel = new HashMap<>();
		try {
			// Invocaci�n y uso del excel
			FileInputStream arcExcel = new FileInputStream(new File(excel.getRutaExcel()));
			Workbook libroExcel = new XSSFWorkbook(arcExcel);
			// Hoja del excel a usar
			Sheet hojaArcExcel = libroExcel.getSheet(excel.getHojaExcel());
			Iterator<Row> iterator = hojaArcExcel.iterator();
			ArrayList<String> cabeceras = new ArrayList<>();
			// Ciclo de iteraci�n por cada fila
			while (iterator.hasNext()) {
				Row filaActual = iterator.next();
				Iterator<Cell> iteratorCelda = filaActual.iterator();
				// Variable que almacenara cada fila
				int numFila = filaActual.getRowNum();
				if ((excel.isContieneCabecera() && numFila == 0) || numFila == excel.getFilaLeer()) {
					// Ciclo de celdas o columnas de la hoja del excel
					while (iteratorCelda.hasNext()) {
						Cell celdaActual = iteratorCelda.next();
						String valorCelda;
						// Validar tipo de celda para procesarla
						switch (celdaActual.getCellType()) {
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(celdaActual)) {
								valorCelda = "" + celdaActual.getDateCellValue().getTime();
							} else {
								valorCelda = df.format(celdaActual.getNumericCellValue());
							}
							break;
						default:
							valorCelda = celdaActual.getStringCellValue();
							break;
						}
						// Validar si tiene cabecera o no
						if (excel.isContieneCabecera()) {
							if (numFila == 0) {
								cabeceras.add(valorCelda);
							} else {
								datosExcel.put(cabeceras.get(celdaActual.getColumnIndex()), valorCelda);
							}
						} else {
							if (numFila == excel.getFilaLeer()) {
								datosExcel.put("" + celdaActual.getColumnIndex() + "", valorCelda);
							}
						}
					}
				}
			}
//			libroExcel.closew;
		} catch (IOException e) {
			logger.log(Level.INFO, e.getMessage());
		}
		return datosExcel;
	}

}
