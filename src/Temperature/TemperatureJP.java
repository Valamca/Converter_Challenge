package Temperature;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/***
 * <h1>Panel de Conversión de Temperaturas</h1>
 * Clase encargada de generar el <em>JPanel Temperature</em> de conversión de temperaturas, el cual contiene todos los procesos
 * para realizar conversiones entre diferentes tipos de temperaturas
 * @author Francisco Valam
 *
 */
public class TemperatureJP extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField TempIN;
	private JTextField TempOut;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TemperatureJP() {
		setLayout(null);
		
		 //Creación del panel
		TemperatureConverter ChangeTemperature = new TemperatureConverter();
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("ComboBox.border"));
		panel.setBounds(0, 0, 496, 515);
		add(panel);
		panel.setLayout(null);
		
		//Espacio para delimitar area de Areas de Texto
		JPanel Base = new JPanel();
		Base.setToolTipText("");
		Base.setBackground(new Color(240, 240, 240));
		Base.setForeground(new Color(255, 0, 0));
		Base.setBorder(new EmptyBorder(0, 0, 0, 0));
		Base.setBounds(115, 42, 350, 215);
		panel.add(Base);
		Base.setLayout(null);
		
		//Espacio para errores o alertas
		JLabel Alert = new JLabel("");
		Alert.setBounds(183, 25, 177, 20);
		panel.add(Alert);
		Alert.setHorizontalAlignment(SwingConstants.CENTER);
		Alert.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		//Valor de entrada ingresado
		TempIN = new JTextField();
		TempIN.setText("0");
		TempIN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TempIN.setText("");
			}
		});
		TempIN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(Character.isLetter(c)) {
					Alert.setText("Ingresa solo dígitos");
					e.consume();
				}
				if(Character.isDigit(c)) {
					Alert.setText("");
				}
			}

		});
		TempIN.setToolTipText("Insert number");
		TempIN.setBackground(new Color(240, 240, 240));
		TempIN.setForeground(new Color(255, 0, 0));
		TempIN.setHorizontalAlignment(SwingConstants.CENTER);
		TempIN.setFont(new Font("Tahoma", Font.BOLD, 36));
		TempIN.setBounds(41, 10, 236, 100);
		Base.add(TempIN);
		TempIN.setColumns(10);
		
		//Lista de variable de temperaturas de entrada
		JComboBox<String>  TemperaturesIn = new JComboBox<String> ();
		TemperaturesIn.setToolTipText("Scale");
		TemperaturesIn.setForeground(new Color(255, 0, 0));
		TemperaturesIn.setFont(new Font("Tahoma", Font.BOLD, 23));
		TemperaturesIn.setModel(new DefaultComboBoxModel<String>(new String[] {"Celsius (°C)", "Kelvin (K)", "Fahrenheit (°F)"}));
		TemperaturesIn.setBounds(41, 131, 236, 31);
		Base.add(TemperaturesIn);
		
		//Texto de variable impreso en pantalla
		JLabel TempText = new JLabel("Convertir a");
		TempText.setFont(new Font("Tahoma", Font.PLAIN, 25));
		TempText.setHorizontalAlignment(SwingConstants.CENTER);
		TempText.setBounds(41, 184, 236, 31);
		Base.add(TempText);

		//Segunda base para delimitar areas de texto
		JPanel Base2 = new JPanel();
		Base2.setBorder(new EmptyBorder(0, 0, 0, 0));
		Base2.setBounds(115, 300, 350, 205);
		panel.add(Base2);
		Base2.setLayout(null);
		
		//Resultado de conversión
		TempOut = new JTextField("");
		TempOut.setForeground(new Color(0, 128, 255));
		TempOut.setHorizontalAlignment(SwingConstants.CENTER);
		TempOut.setFont(new Font("Tahoma", Font.BOLD, 31));
		TempOut.setEditable(false);
		TempOut.setFocusable(false);
		TempOut.setToolTipText("Result");
		TempOut.setColumns(10);
		TempOut.setBounds(42, 0, 236, 101);
		Base2.add(TempOut);
		
		//Lista de variables para conversión.
		JComboBox<String>  TemperaturasOut = new JComboBox<String> ();
		TemperaturasOut.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ChangeTemperature.ConverterTemp(TempIN.getText(), TemperaturesIn, TemperaturasOut, TempOut);;
			}
		});
		TemperaturasOut.setForeground(new Color(0, 128, 255));
		TemperaturasOut.setToolTipText("Scale");
		TemperaturasOut.setFont(new Font("Tahoma", Font.BOLD, 23));
		TemperaturasOut.setModel(new DefaultComboBoxModel<String>(new String[] {"Celsius (°C)", "Kelvin (K)", "Fahrenheit (°F)"}));
		TemperaturasOut.setSelectedIndex(2);
		TemperaturasOut.setBounds(42, 118, 236, 31);
		Base2.add(TemperaturasOut);
		
		//botón para invertir valores en los campos de entrada y resultado, así como las variables de las listas.
		JLabel ChangeBtn = new JLabel("↑↑↑");
		ChangeBtn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ChangeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TempIN.setText(TempOut.getText());
				TempOut.setText("");
				TemperaturesIn.setSelectedItem(TemperaturasOut.getSelectedItem());
				TemperaturasOut.setSelectedItem("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
					ChangeBtn.setCursor(new Cursor(12));
			}
		});
		ChangeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		ChangeBtn.setHorizontalAlignment(SwingConstants.CENTER);
		ChangeBtn.setBounds(294, 118, 46, 31);
		Base2.add(ChangeBtn);
		
		//Campo de texto para color
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(0, 128, 192));
		textField_1.setBounds(-12, 195, 34, 164);
		panel.add(textField_1);

	}
}
