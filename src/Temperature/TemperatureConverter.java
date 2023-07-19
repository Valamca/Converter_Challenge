package Temperature;
import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * <h1>Conversor de Temperaturas</h1>
 * Clase encargada de conversiones entre diferentes tipos de Temperaturas
 * @author Francisco Valam.
 * <h4>Celcius, Kelvin o Fahrenheit.</h4>
 */
public class TemperatureConverter {
	
	/**
	 * <H1>Métodos de Conversión de Temperaturas</H1>
	 * Contiene los procesos de conversión entre diferenetes tipos de temperaturas según se requiera.
	 * @param In Valor de Temperatura ingresado.
	 * @param TIn Tipo de Temperatura inicial seleccionada de la lista de variables.
	 * @param TOut Tipo de Temperatura a la cual se hará la conversión.
	 * @param Out Resultado de conversión de temperatura.
	 */
	public void ConverterTemp(String In, JComboBox<?> TIn, JComboBox<?> TOut, JTextField Out) {
		
		double result = 0;
		
		try {
		
			String ChooseIn = (String) TIn.getSelectedItem();
			String ChooseOut = (String) TOut.getSelectedItem();
			double DataIn = Double.valueOf(In);
			
			switch(ChooseIn) {
			
				case ("Celsius (°C)"):
					switch(ChooseOut) {
						case("Celsius (°C)"):
							result = DataIn/1;
							break;
						case("Kelvin (K)"):
							result = DataIn + 273.15;
							break;
						case("Fahrenheit (°F)"):
							result = (DataIn*9/5)+ 32;
							break;
					}
					break;
				
				case("Kelvin (K)"):
					switch(ChooseOut) {
						case("Celsius (°C)"):
							result = DataIn-273.15;
							break;
						case("Kelvin (K)"):
							result = DataIn/1;
							break;
						case("Fahrenheit (°F)"):
							result = (1.8*(DataIn - 273)) + 32;
							break;
					}
					break;
					
				case("Fahrenheit (°F)"):
					switch(ChooseOut) {
						case("Celsius (°C)"):
							result = (DataIn-32)*5/9;
							break;
						case("Kelvin (K)"):
							result = ((DataIn-32)*5/9)+273.15;
							break;
						case("Fahrenheit (°F)"):
							result = (DataIn/1);
							break;
					}
					break;
			}
		}
		catch(NullPointerException|NumberFormatException e) {
			System.out.println("Numero ingresado es erroneo");
			e.printStackTrace();
		}

		DecimalFormat format = new DecimalFormat("######.##");
		String ResultOut = format.format(result);
		Out.setText(ResultOut);
		
	}
}

