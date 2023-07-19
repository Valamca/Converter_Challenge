package Divisas;
import java.text.DecimalFormat;
import javax.swing.JTextField;

/**
 * <h1>Clase Divisa</h1>
 * Clase madre tipo Divisa "Currency", la cual contiene los métodos desarrollados para este tipo de objeto.
 * @author Francisco Valam.
 */
public class Currency {
	
	private String Country;    // La clase madre "Currency" o divisa en español. 
	private double value;		//Aquí se generan los metodos para la "Etiqueta", "Valor", y "Simbolo" de cada moneda que se vaya a utilizar
	private String Symbol;
	
	public String getCountry() {  //Setters y Getters de la clase
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getSymbol() {
		return Symbol;
	}
	public void setSymbol(String symbol) {
		Symbol = symbol;
	}
	
	/**
	 * <h1>Conversor de Divisas</h1>
	 * Este metodo combierte el valor de la divisa ingresada, en la divisa de destino y lo muestra en el <em>JTextField</em> especificado.
	 * @param valor - Valor de Divisa ingresado.
	 * @param coinb	- Tipo de Divisa del valor ingresado.
	 * @param coin - Valor de Divisa a la cual se hará la conversión.
	 * @param show	- Resultado de conversión.
	 * @param Symbol -Símbolo de divisa de entrada.
	 * @param s - Símbolo de divisa de salida.
	 */
	public void convertir(double valor,Currency coinb,Currency coin,JTextField show, JTextField Symbol,JTextField s) {
		DecimalFormat format = new DecimalFormat("######.##");
		String change = format.format((valor*coinb.getValue())/coin.getValue()); //Redondea el valor con 2 deimales y da formato
		show.setText(change); //Coloca el resultado
		Symbol.setText(coin.getSymbol()); //El campo muestra el simbolo de la moneda
		s.setText(coinb.getSymbol());
		}
}
