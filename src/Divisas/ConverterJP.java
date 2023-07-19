package Divisas;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

/**
 * <h1>Conversor de Divisas</h1>
 * Clase encargada de generar el <em>JPanel Converter</em> el cual tiene los procesos necesarios para 
 * realizar la conversión entre diferentes tipos de divisas.
 * @author Francisco Valam.
 */
public class ConverterJP extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField CurrencyOut;
	private JTextField CurrencyIn;
	private JTextField SymbolField;
	private JTextField Symb;
	private JTextField Field2;

	/**
	 * Create the panel.
	 */
	public ConverterJP() {
		setLayout(null);
		
		Operation change = new Operation();
		
		//Campo de Texto de resultados
		CurrencyOut = new JTextField();
		CurrencyOut.setToolTipText("Result");
		CurrencyOut.setText("0");
		CurrencyOut.setBorder(null);
		CurrencyOut.setFont(new Font("Tahoma", Font.BOLD, 35));
		CurrencyOut.setHorizontalAlignment(SwingConstants.CENTER);
		CurrencyOut.setEditable(false);
		CurrencyOut.setForeground(new Color(255, 0, 0));
		CurrencyOut.setColumns(10);
		CurrencyOut.setBounds(131, 331, 286, 100);
		add(CurrencyOut);
		
		//Campo utilizado para errores o alertas.
		JLabel Alert = new JLabel("");
		Alert.setHorizontalAlignment(SwingConstants.CENTER);
		Alert.setFont(new Font("Tahoma", Font.BOLD, 12));
		Alert.setBounds(210, 25, 132, 20);
		add(Alert);
		
		//Simbolo de cada tipo de monedas
		Symb = new JTextField();
		Symb.setHorizontalAlignment(SwingConstants.LEFT);
		Symb.setForeground(new Color(0, 128, 0));
		Symb.setFont(new Font("Tahoma", Font.BOLD, 38));
		Symb.setColumns(10);
		Symb.setBorder(null);
		Symb.setBackground(UIManager.getColor("Button.background"));
		Symb.setBounds(418, 79, 68, 50);
		add(Symb);
		
		//Lista de variables de tipos de divisas aceptadas
		JComboBox ToChange = new JComboBox();
		ToChange.setToolTipText("Scale");
		ToChange.setForeground(new Color(0, 128, 0));
		ToChange.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR", "GBP", "JPY", "KRW", "MXN"}));
		ToChange.setSelectedIndex(5);
		ToChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		ToChange.setBounds(235, 164, 80, 28);
		add(ToChange);
		
		//Campo de texto impreso en pantalla.
		JLabel Text = new JLabel("convertir a");
		Text.setHorizontalAlignment(SwingConstants.CENTER);
		Text.setFont(new Font("Tahoma", Font.BOLD, 14));
		Text.setBounds(222, 220, 98, 28);
		add(Text);

		//Valore de divisa ingresado para conversión.
		CurrencyIn = new JTextField();
		CurrencyIn.setToolTipText("Insert a number");
		CurrencyIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CurrencyIn.setText("");
			}
		});
		CurrencyIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c)) {
					Alert.setText("Ingresa solo dígitos");
					e.consume();
				}
				if(Character.isDigit(c)) {
					Alert.setText("");
				}
			}
		});
		
		CurrencyIn.setFont(new Font("Tahoma", Font.BOLD, 38));
		CurrencyIn.setText("0");
		CurrencyIn.setHorizontalAlignment(SwingConstants.CENTER);
		CurrencyIn.setForeground(new Color(0, 128, 0));
		CurrencyIn.setColumns(10);
		CurrencyIn.setBounds(157, 54, 236, 100);
		add(CurrencyIn);
		
		//Simbolo de divisas
		SymbolField = new JTextField();
		SymbolField.setBackground(new Color(240, 240, 240));
		SymbolField.setBorder(null);
		SymbolField.setHorizontalAlignment(SwingConstants.LEFT);
		SymbolField.setForeground(new Color(255, 0, 0));
		SymbolField.setFont(new Font("Tahoma", Font.BOLD, 38));
		SymbolField.setBounds(418, 354, 68, 50);
		add(SymbolField);
		SymbolField.setColumns(10);
		
		//lista de variable de divisas la cual se hará la conversión.
		JComboBox ToResult = new JComboBox();
		ToResult.setToolTipText("Scale");
		ToResult.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				change.convert(CurrencyIn, ToChange, ToResult,CurrencyOut,SymbolField,Symb);
			}
		});
		ToResult.setForeground(new Color(255, 0, 0));
		ToResult.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR", "GBP", "JPY", "KRW", "MXN"}));
		ToResult.setFont(new Font("Tahoma", Font.BOLD, 18));
		ToResult.setBounds(235, 271, 80, 28);
		add(ToResult);
		
		//Botón para invertir las cantidad de salida y entrada así como sus JComboBox correspondientes.
		JLabel ChangeBtm = new JLabel("↑↑↑");
		ChangeBtm.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ChangeBtm.setHorizontalAlignment(SwingConstants.CENTER);
		ChangeBtm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CurrencyIn.setText(CurrencyOut.getText());
				CurrencyOut.setText("");
				ToChange.setSelectedItem(ToResult.getSelectedItem());
				ToResult.setSelectedItem("");
				Symb.setText(SymbolField.getText());
				SymbolField.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
					ChangeBtm.setCursor(new Cursor(12));
			}
		});
		ChangeBtm.setBounds(335, 271, 45, 28);
		add(ChangeBtm);
		
		//Campo de color.
		Field2 = new JTextField();
		Field2.setBackground(new Color(0, 128, 0));
		Field2.setBorder(null);
		Field2.setBounds(-11, -11, 33, 204);
		add(Field2);
		Field2.setColumns(10);

	}
}
