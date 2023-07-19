package Medición;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <h1>Panel de Medición</h1> 
 * Clase encargada de generar el <em> JPanel Medición
 * </em> en el cuál se tienen los procesos necesarios para hacer las
 * correspondientes conversiones entre unidades de Medición.
 * 
 * @author Francisco Valam
 *
 */
public class MeditionJP extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField TextIn;
	private JTextField TextOut;
	private JTextField Field2;

	/**
	 * Create the panel.
	 */
	public MeditionJP() {
		setForeground(new Color(0, 0, 0));

		MeditionConverter Changer = new MeditionConverter();
		JLabel Alert = new JLabel("");
		setLayout(null);

		// Lista de variables para ingresar valores
		JComboBox ToChange = new JComboBox();
		ToChange.setBackground(new Color(255, 255, 255));
		ToChange.setBounds(193, 173, 163, 28);
		ToChange.setToolTipText("Scale");
		ToChange.setModel(new DefaultComboBoxModel(new String[] { "Milímetros", "Centímetros", "Metros", "Kilómetros",
				"Pulgada", "Pie", "Yarda", "Milla" }));
		ToChange.setForeground(new Color(0, 0, 0));
		ToChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(ToChange);

		// Tag para texto de conversión
		JLabel Text = new JLabel("convertir a");
		Text.setBounds(225, 224, 98, 28);
		Text.setHorizontalAlignment(SwingConstants.CENTER);
		Text.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(Text);

		// Lista de variables a la cual se hará la conversión
		JComboBox ToResult = new JComboBox();
		ToResult.setModel(new DefaultComboBoxModel(new String[] { "Milímetros", "Centímetros", "Metros", "Kilómetros",
				"Pulgada", "Pie", "Yarda", "Milla" }));
		ToResult.setBounds(193, 278, 163, 28);
		ToResult.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Changer.meditionConverter(TextIn, ToChange, ToResult, TextOut);
			}
		});
		ToResult.setToolTipText("Scale");
		ToResult.setForeground(new Color(255, 165, 0));
		ToResult.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(ToResult);

		// Espacio de texto para ingresar valores
		TextIn = new JTextField();
		TextIn.setText("0");
		TextIn.setBounds(159, 48, 236, 100);
		TextIn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TextIn.setText("");
			}
		});
		TextIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {
					Alert.setText("Ingresa solo dígitos");
					e.consume();
				}
				if (Character.isDigit(c)) {
					Alert.setText("");
				}
			}
		});

		TextIn.setToolTipText("Enter a number");
		TextIn.setHorizontalAlignment(SwingConstants.CENTER);
		TextIn.setForeground(new Color(0, 0, 0));
		TextIn.setFont(new Font("Tahoma", Font.BOLD, 34));
		TextIn.setColumns(10);
		add(TextIn);

		// Espacio de texto para mostrar resultados
		TextOut = new JTextField();
		TextOut.setBounds(159, 332, 236, 100);
		TextOut.setToolTipText("Result");
		TextOut.setText("0");
		TextOut.setHorizontalAlignment(SwingConstants.CENTER);
		TextOut.setForeground(new Color(255, 165, 0));
		TextOut.setFont(new Font("Tahoma", Font.BOLD, 30));
		TextOut.setFocusable(false);
		TextOut.setEditable(false);
		TextOut.setColumns(10);
		add(TextOut);
		
		//Tag para mostrar errores o alertas
		Alert.setBounds(225, 10, 112, 28);
		add(Alert);
		
		//CAMPO PARA COLORES
		Field2 = new JTextField();
		Field2.setBackground(new Color(255, 165, 0));
		Field2.setBorder(null);
		Field2.setBounds(0, 356, 23, 170);
		add(Field2);
		Field2.setColumns(10);

		//Botón para intercambiar valores entre los campos de Entrada y Salida, así como sus JComobBOx
		JLabel ChangeBtn = new JLabel("↑↑↑");
		ChangeBtn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ChangeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ChangeBtn.setCursor(new Cursor(12));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TextIn.setText(TextOut.getText());
				TextOut.setText("");
				ToChange.setSelectedItem(ToResult.getSelectedItem());
				ToResult.setSelectedItem("");
			}
		});
		ChangeBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		ChangeBtn.setHorizontalAlignment(SwingConstants.CENTER);
		ChangeBtn.setBounds(382, 278, 37, 28);
		add(ChangeBtn);

	}
}
