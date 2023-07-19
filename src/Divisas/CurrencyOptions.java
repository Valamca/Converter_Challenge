package Divisas;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * <h1>Conversion</h1>
 * Clase con los diferentes métodos de conversión de Divisas.
 * @author Francisco Valam
 */
public class CurrencyOptions  {
	
	/**
	 * <h1>Selector de Conversor</h1>
	 * Método encargado de convertir las variables de entrada en <em>objetos </em><em>"Currency"</em>, para obtener sus factores de conversión,
	 * así como su símbolo, valor y codigo de denominación.<br>
	 * Después genera el proceso de conversión con los valores anteriormente obtenidos. 
	 * @param value Valor de divisa ingresado.
	 * @param CurrencyChoose Tipo de divisa base del valor.
	 * @param CurrencyTo Tipo de divisa a la cual se hará la conversión.
	 * @param Result Resultado de la conversión.
	 * @param SymbolField Símbolo de la divisa de entrada.
	 * @param s Símbolo de la divisa de salida.
	 */
	public void ConvertionOptions(JTextField value,JComboBox<Currency> CurrencyChoose ,String CurrencyTo,JTextField Result,
			JTextField SymbolField,JTextField s) {
		

		//Creación de cada tipo de moneda con su clase Currency, su etiqueta, valor y simbolo distintivo
		
		Currency dollar = new Currency();
		dollar.setCountry("USD");
		dollar.setValue(1);
		dollar.setSymbol("$");
		
		Currency euro = new Currency();
		euro.setCountry("EUR");
		euro.setValue(dollar.getValue()*1.12);
		euro.setSymbol("€");
		
		Currency libraE = new Currency();
		libraE.setCountry("GBP");
		libraE.setValue(dollar.getValue()*1.31);
		libraE.setSymbol("£");
		
		Currency yen = new Currency();
		yen.setCountry("JPY");
		yen.setValue(dollar.getValue()*0.0072);
		yen.setSymbol("¥");
		
		Currency won = new Currency();
		won.setCountry("KRW");
		won.setValue(dollar.getValue()*0.00079);
		won.setSymbol("₩");
		
		Currency pesoMx = new Currency();
		pesoMx.setCountry("MXN");
		pesoMx.setValue(dollar.getValue()*0.060);
		pesoMx.setSymbol("$");
		
		
		//Selección de base para hacer las operaciones de conversión
		
		Currency base = null; //Para asegurarse de reiniciar la tag antes de otorgarle un Objeto Currency
		
		switch(CurrencyTo) {
		case("USD"): 
			base = dollar;
			break;
		case("EUR"):
			base = euro;
			break;
		case("GBP"):
			base = libraE;
			break;
		case("JPY"):
			base = yen;
		    break;
		case("KRW"):
			base = won;
		    break;
		case("MXN"):
			base = pesoMx;
		    break;
		}	
		// Selección de método a utilizar basado en el valor ingresado y la divisa a la que se quiere convertir
		
		try {
		
		Currency Changer = new Currency(); //Metodo para acceder a la clase Currency	
		double ValueDouble = Double.valueOf(value.getText()); //Valor de entrada
		String StringCurrency = (String) CurrencyChoose.getSelectedItem();//Divisa de Destino
		
		if(StringCurrency == dollar.getCountry()) {          //Sí el item del JComboBox cumple la condición, se realiza el método convertir ↓↓
			Changer.convertir(ValueDouble,base, dollar, Result,SymbolField,s);         //El método "Convertir" cambia el valor ingresado y su moneda base ↓↓
			}										                      // a la moneda especifica y lo muestra en el "JTextFiel" ingresado
		
		else if(StringCurrency == euro.getCountry()) {
			Changer.convertir(ValueDouble,base, euro, Result,SymbolField,s);
			}
		
		else if(StringCurrency == libraE.getCountry()) {
			Changer.convertir(ValueDouble,base, libraE, Result,SymbolField,s);
			}
		
		else if(StringCurrency == yen.getCountry()) {
			Changer.convertir(ValueDouble,base, yen, Result,SymbolField,s);
			}
		
		else if(StringCurrency == won.getCountry()) {
			Changer.convertir(ValueDouble,base, won, Result,SymbolField,s);
			}
		
		else if(StringCurrency == pesoMx.getCountry()) {
			Changer.convertir(ValueDouble,base, pesoMx, Result,SymbolField,s);
			}
		}
		catch(NumberFormatException e) { //En caso de que no haya un número en el campo se detecta el error
			System.out.println("El campo de valor está vacío");}
		}

}
