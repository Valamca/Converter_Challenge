package Medición;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

/**
 * Clase en la cual se guardan los <em>Factores de Conversión</em> para cada una de las variables disponibles almacenados en HashMap's,
 * así como cada uno de los métodos de conversión, según sea el caso correspondiente.
 * 
 * @author Francisco Valam
 * @version 1.0
 */

public class MeasurementConverter { 

	private static Map<String, Double> conversionFactors = initializeConversionFactors();

	private static Map<String, Double> initializeConversionFactors() {
		Map<String, Double> factors = new HashMap<>();

		// Factores de Conversión de Milimetros al resto de variables
		factors.put("Milímetros", 1.0);
		factors.put("Centímetros", 0.1);
		factors.put("Metros", 0.001);
		factors.put("Kilómetros", 0.000001);
		factors.put("Pulgada", 0.0393701);
		factors.put("Pie", 0.00328084);
		factors.put("Yarda", 0.00109361);
		factors.put("Milla", 0.000000621371);

		return factors;
	}
	
	/**
	 * <h1>Milímetros</h1>
	 * Este método convierte de Milímetros a cualquier unidad, basado en los factores declarados en "factors".
	 * @param value Valor ingresado para ser convertido.
	 * @param fromUnit Divisa de ingreso .
	 * @param toUnit	Divisa a la cual se hará la conversión.
	 * @param Out	Resultado de la conversión.
	 */
	public static void convertFromMilimeters(double value, String fromUnit, String toUnit, JTextField Out) {
		
		//Proceso de Conversión de Milimetros a las demas variables segun sea el caso
	    double factorFrom = conversionFactors.get(fromUnit);
	    double factorTo = conversionFactors.get(toUnit);
		DecimalFormat format = new DecimalFormat("#,###.####");
	    String result = format.format(value * (factorFrom * factorTo));
	    Out.setText(result);
	}
	/** 
	 * <h1>Centímetros</h1>
	 * Este método convierte de Centimetros a cualquier unidad, basado en los factores declarados en "ConversionFactors".
	 * @param value Valor ingresado para ser convertido.
	 * @param toUnit Divisa a la cual se hará la conversión.
	 * @param Out	Resultado de la conversión.
	 */
	public static void convertFromCentimeters(double value, String toUnit, JTextField Out) {
	    Map<String, Double> conversionFactors = new HashMap<>();

	    // Factores de Conversión de Centimetros
	    conversionFactors.put("Milímetros", 10.0);
	    conversionFactors.put("Centímetros", 1.0);
	    conversionFactors.put("Metros", 0.01);
	    conversionFactors.put("Kilómetros", 0.00001);
	    conversionFactors.put("Pulgada", 0.393701);
	    conversionFactors.put("Pie", 0.0328084);
	    conversionFactors.put("Yarda", 0.0109361);
	    conversionFactors.put("Milla", 0.0000062137);
	    
	  //Proceso de Conversión de Centimetros
	    double factor = conversionFactors.getOrDefault(toUnit, 0.0);
	    double result = value * factor;
	    DecimalFormat format = new DecimalFormat("#,###.####");
	    String formattedResult = format.format(result);
	    Out.setText(formattedResult);
	}
	/**
	 * <h1>Metros</h1>
	 * Este método convierte de Metros a cualquier unidad, basado en los factores declarados en "ConversionFactors".
	 * @param value Valor ingresado para ser convertido.
	 * @param toUnit Divisa a la cual se hará la conversión.
	 * @param Out	Resultado de la conversión.
	 */
	public static void convertFromMeters(double value, String toUnit, JTextField Out) {
	    Map<String, Double> conversionFactors = new HashMap<>();

	    // Factores de Conversión de Metros
	    conversionFactors.put("Milímetros", 1000.0);
	    conversionFactors.put("Centímetros", 100.0);
	    conversionFactors.put("Metros", 1.0);
	    conversionFactors.put("Kilómetros", 0.001);
	    conversionFactors.put("Pulgada", 39.3701);
	    conversionFactors.put("Pie", 3.28084);
	    conversionFactors.put("Yarda", 1.09361);
	    conversionFactors.put("Milla", 0.000621371);
	    
	  //Proceso de Conversión de Metros
	    double factor = conversionFactors.get(toUnit);
	    double result = value * factor;
	    DecimalFormat format = new DecimalFormat("#,###.####");
	    String formattedResult = format.format(result);
	    Out.setText(formattedResult);
	}
	
	/**
	 * <h1>Kilómetros</h1>
	 * Este método convierte de Kilometros a cualquier unidad, basado en los factores declarados en "ConversionFactors".
	 * @param value Valor ingresado para ser convertido.
	 * @param toUnit Divisa a la cual se hará la conversión.
	 * @param Out	Resultado de la conversión.
	 */
	public static void convertFromKilometers(double value, String toUnit, JTextField Out) {
	    Map<String, Double> conversionFactors = new HashMap<>();
	    
	    // Factores de Conversión de Kilometros
	    conversionFactors.put("Milímetros", 1000000.0);
	    conversionFactors.put("Centímetros", 100000.0);
	    conversionFactors.put("Metros", 1000.0);
	    conversionFactors.put("Kilómetros", 1.0);
	    conversionFactors.put("Pulgada", 39370.1);
	    conversionFactors.put("Pie", 3280.84);
	    conversionFactors.put("Yarda", 1093.61);
	    conversionFactors.put("Milla", 0.621371);
	    
	  //Proceso de Conversión de Kilometros
	    double factor = conversionFactors.get(toUnit);
	    double result = value * factor;
	    DecimalFormat format = new DecimalFormat("#,###.####");
	    String formattedResult = format.format(result);
	    Out.setText(formattedResult);
	}
	
	/**
	 * <h1>Pulgadas</h1>
	 * Este método convierte de Pulgada a cualquier unidad, basado en los factores declarados en "ConversionFactors".
	 * @param value Valor ingresado para ser convertido.
	 * @param toUnit Divisa a la cual se hará la conversión.
	 * @param Out	Resultado de la conversión.
	 */
	public static void convertFromInches(double value, String toUnit, JTextField Out) {
	    Map<String, Double> conversionFactors = new HashMap<>();
	    
	    // Factores de Conversión de Pulgadas
	    conversionFactors.put("Milímetros", 25.4);
	    conversionFactors.put("Centímetros", 2.54);
	    conversionFactors.put("Metros", 0.0254);
	    conversionFactors.put("Kilómetros", 0.0000254);
	    conversionFactors.put("Pulgada", 1.0);
	    conversionFactors.put("Pie", 0.0833333);
	    conversionFactors.put("Yarda", 0.0277778);
	    conversionFactors.put("Milla", 0.0000157828);

	  //Proceso de Conversión de Pulgadas
	    double factor = conversionFactors.get(toUnit);
	    double result = value * factor;
	    DecimalFormat format = new DecimalFormat("#,###.####");
	    String formattedResult = format.format(result);
	    Out.setText(formattedResult);
	}
	
	/**
	 * <h1>Pies</h1>
	 * Este método convierte de Pies a cualquier unidad, basado en los factores declarados en "ConversionFactors".
	 * @param value Valor ingresado para ser convertido.
	 * @param toUnit Divisa a la cual se hará la conversión.
	 * @param Out	Resultado de la conversión.
	 */
	public static void convertFromFeet(double value, String toUnit, JTextField Out) {
	    Map<String, Double> conversionFactors = new HashMap<>();
	    
	    // Factores de Conversión de Pies
	    conversionFactors.put("Milímetros", 304.8);
	    conversionFactors.put("Centímetros", 30.48);
	    conversionFactors.put("Metros", 0.3048);
	    conversionFactors.put("Kilómetros", 0.0003048);
	    conversionFactors.put("Pulgada", 12.0);
	    conversionFactors.put("Pie", 1.0);
	    conversionFactors.put("Yarda", 0.333333);
	    conversionFactors.put("Milla", 0.000189394);

	  //Proceso de Conversión de Pies
	    double factor = conversionFactors.get(toUnit);
	    double result = value * factor;
	    DecimalFormat format = new DecimalFormat("#,###.####");
	    String formattedResult = format.format(result);
	    Out.setText(formattedResult);
	}
	
	/**
	 * <h1>Yardas</h1>
	 * Este método convierte de Yardas a cualquier unidad, basado en los factores declarados en "ConversionFactors".
	 * @param value Valor ingresado para ser convertido.
	 * @param toUnit Divisa a la cual se hará la conversión.
	 * @param Out	Resultado de la conversión.
	 */
	public static void convertFromYards(double value, String toUnit, JTextField Out) {
	    Map<String, Double> conversionFactors = new HashMap<>();
	    
	    // Factores de Conversión de Yardas
	    conversionFactors.put("Milímetros", 914.4);
	    conversionFactors.put("Centímetros", 91.44);
	    conversionFactors.put("Metros", 0.9144);
	    conversionFactors.put("Kilómetros", 0.0009144);
	    conversionFactors.put("Pulgada", 36.0);
	    conversionFactors.put("Pie", 3.0);
	    conversionFactors.put("Yarda", 1.0);
	    conversionFactors.put("Milla", 0.000568182);

	  //Proceso de Conversión de Yardas
	    double factor = conversionFactors.get(toUnit);
	    double result = value * factor;
	    DecimalFormat format = new DecimalFormat("#,###.####");
	    String formattedResult = format.format(result);
	    Out.setText(formattedResult);
	}
	
	/**
	 * <h1>Millas</h1>
	 * Este método convierte de Millas a cualquier unidad, basado en los factores declarados en "ConversionFactors"
	 * @param value Valor ingresado para ser convertido.
	 * @param toUnit Divisa a la cual se hará la conversión.
	 * @param Out	Resultado de la conversión.
	 */
	public static void convertFromMiles(double value, String toUnit, JTextField Out) {
	    Map<String, Double> conversionFactors = new HashMap<>();
	    
	    // Factores de Conversión de Millas
	    conversionFactors.put("Milímetros", 1609344.0);
	    conversionFactors.put("Centímetros", 160934.4);
	    conversionFactors.put("Metros", 1609.344);
	    conversionFactors.put("Kilómetros", 1.609344);
	    conversionFactors.put("Pulgada", 63360.0);
	    conversionFactors.put("Pie", 5280.0);
	    conversionFactors.put("Yarda", 1760.0);
	    conversionFactors.put("Milla", 1.0);

	  //Proceso de Conversión de Millas
	    double factor = conversionFactors.get(toUnit);
	    double result = value * factor;
	    DecimalFormat format = new DecimalFormat("#,###.####");
	    String formattedResult = format.format(result);
	    Out.setText(formattedResult);
	}

}
