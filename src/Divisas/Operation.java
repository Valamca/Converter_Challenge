package Divisas;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * <h1>Selector de operaciones</h1>
 * Clase encargada de la selección de operación correspondiente para conversión.
 * @author Francisco Valam
 */
public class Operation {

	/**
	 * <H1>Operaciones de Conversión</H1>
	 * Método encargado de tomar el tipo de Divisa ingresado,y seleccionar el método correspondiente según la
	 * divisa a la cuál se hará la conversión.
	 * @param valueIn Valor de divisa ingresado.
	 * @param BaseCurrency Tipo de divisa ingresada.
	 * @param ConvertionCurrency Tipo de divisa a la que se hará la conversión.
	 * @param ResultField Campo dónde se mostrará el resultado de la conversión.
	 * @param SymbolField Símbolo de divisa ingresada.
	 * @param Symb	Símbolo de divisa del resultado de conversión.
	 */
	public void convert(JTextField valueIn, JComboBox<Currency> BaseCurrency, JComboBox<Currency> ConvertionCurrency,
			JTextField ResultField,JTextField SymbolField,JTextField Symb) {

		CurrencyOptions options = new CurrencyOptions(); //Instancia para usar el Metodo "Convertir" de CurrencyOptions

		try {
			String c = (String) BaseCurrency.getSelectedItem(); // Case actual de la divisa(Switch)
			String CurrencyTo = (String) BaseCurrency.getSelectedItem(); // Divisa a la que convertir
			
			//En base a la selección de divisas, se toma el camino a seguir según sea el caso necesario.
			
			switch (c) {

			case "USD":
				options.ConvertionOptions(valueIn, ConvertionCurrency, CurrencyTo, ResultField,SymbolField,Symb);
				break;

			case "EUR":
				options.ConvertionOptions(valueIn, ConvertionCurrency, CurrencyTo, ResultField,SymbolField,Symb);
				break;

			case "GBP":
				options.ConvertionOptions(valueIn, ConvertionCurrency, CurrencyTo, ResultField,SymbolField,Symb);
				break;

			case "JPY":
				options.ConvertionOptions(valueIn, ConvertionCurrency, CurrencyTo, ResultField,SymbolField,Symb);
				break;

			case "KRW":
				options.ConvertionOptions(valueIn, ConvertionCurrency, CurrencyTo, ResultField,SymbolField,Symb);
				break;

			case "MXN":
				options.ConvertionOptions(valueIn, ConvertionCurrency, CurrencyTo, ResultField,SymbolField,Symb);
				break;
			}

		} catch (NumberFormatException |NullPointerException f) {
			System.out.println("El campo de valor está vacío");
		}

	}

}
