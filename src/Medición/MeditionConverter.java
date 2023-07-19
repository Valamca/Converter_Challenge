package Medición;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * <h1>Conversor de medidas de medición</h1>
 * Clase encargada de seleccionar el tipo de medidas a convertir, y la llamada al método correspondiente en cada caso.
 * @author Francisco Valam
 *
 */
public class MeditionConverter {
	
	/**
	 * <h1>Selector de métodos de conversión</h1>
	 * Método desarrollado para tomar el tipo de medida de ingreso "MBase" del tipo JComboBox para elegir su método de conversión.
	 * @author Francisco Valam
	 * @param ValueIn Valor ingresado para ser convertido.
	 * @param MBase	Tipo de medida base del valor ingresado.
	 * @param MConverter Medida a la cual se hará la conversión.
	 * @param ValueOut Resultado de conversión.
	 */
	public void meditionConverter(JTextField ValueIn, JComboBox<String> MBase,JComboBox<String> MConverter, JTextField ValueOut) {
	
	try {
	double valueIn = Double.valueOf(ValueIn.getText());
	String base = MBase.getSelectedItem().toString();
	
		switch(base) { //Aquí se decide cual método se llamára para realizar la conversión necesaria
		
			case("Milímetros"):
				MeasurementConverter.convertFromMilimeters(valueIn, base, MConverter.getSelectedItem().toString(), ValueOut);
				break;
			case("Centímetros"):
				MeasurementConverter.convertFromCentimeters(valueIn, MConverter.getSelectedItem().toString(), ValueOut);
				break;
			case("Metros"):
				MeasurementConverter.convertFromMeters(valueIn, MConverter.getSelectedItem().toString(), ValueOut);
				break;
			case("Kilómetros"):
				MeasurementConverter.convertFromKilometers(valueIn,MConverter.getSelectedItem().toString(), ValueOut);
				break;
			case("Pulgada"):
				MeasurementConverter.convertFromInches(valueIn,MConverter.getSelectedItem().toString(), ValueOut);
				break;
			case("Pie"):
				MeasurementConverter.convertFromFeet(valueIn,MConverter.getSelectedItem().toString(), ValueOut);
				break;
			case("Yarda"):
				MeasurementConverter.convertFromYards(valueIn,MConverter.getSelectedItem().toString(), ValueOut);
				break;
			case("Milla"):
				MeasurementConverter.convertFromMiles(valueIn, MConverter.getSelectedItem().toString(), ValueOut);
				break;
			
		}
	}catch(NumberFormatException|NullPointerException e) { //En caso de un dato ingresado incorrecto, se imprime en consola
		System.out.println("Valor Nulo");					//pero no detiene el programa.
	}
   }
}