package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Divisas.ConverterJP;
import Medición.MeditionJP;
import Temperature.TemperatureJP;

/**
 * <h1>Conversor:</h1>
 * Programa hecho para realizar conversiones entre diferentes tipos de sistemas<br>
 * Realiza conversiones entre los siguiente tipos de sistemas: <br>
 * <em>Sistemas de Divisas</em>: <br>
 * &#160&#160&#160&#160- Dolares, Libras, Euros, Yenes, Wones, Pesos Mexicanos. <br>
 * <em>Sistema de Temperaturas</em>: <br>
 * &#160&#160&#160&#160- Celcius, Kelvin y Fahrenheit. <br>
 * <em>Sistema de Medición</em>: <br>
 * &#160&#160&#160&#160- Milímetros, Centímetros, Metros, Kilómetros, Pulgadas, Pies, Yardas, Millas.<br>
 * <br>
 * @author Francisco Valam Cortes Anguiano Linkedin: 
 * @author LinkedIn:/franciscovalamca and GitHub:/ValamCA
 * @version 1.0
 */
public class Conversor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conversor() {
		setTitle("Conversor");
		setFont(new Font("Arial Black", Font.PLAIN, 35));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Conversor.class.getResource("/resources/ProgramIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel TagLabel = new JPanel();
		TagLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		TagLabel.setBounds(0, 0, 178, 59);
		TagLabel.setBackground(new Color(240, 240, 240));
		TagLabel.setForeground(new Color(0, 0, 0));
		contentPane.add(TagLabel);
		TagLabel.setLayout(null);
		
		JLabel TagDivisas = new JLabel("Divisas");
		TagDivisas.setForeground(new Color(0, 128, 0));
		TagDivisas.setHorizontalAlignment(SwingConstants.CENTER);
		TagDivisas.setFont(new Font("Open Sans Semibold", Font.PLAIN, 30));
		TagDivisas.setBounds(10, 10, 158, 39);
		TagLabel.add(TagDivisas);
		
		JPanel EtiquetaTemperatura = new JPanel();
		EtiquetaTemperatura.setBorder(new EmptyBorder(0, 0, 0, 0));
		EtiquetaTemperatura.setForeground(Color.BLACK);
		EtiquetaTemperatura.setBackground(new Color(240, 240, 240));
		EtiquetaTemperatura.setBounds(0, 175, 178, 59);
		contentPane.add(EtiquetaTemperatura);
		EtiquetaTemperatura.setLayout(null);
		
		JLabel TagTemperature = new JLabel("Temperatura");
		TagTemperature.setForeground(new Color(4, 132, 217));
		TagTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		TagTemperature.setFont(new Font("Open Sans Semibold", Font.PLAIN, 25));
		TagTemperature.setBounds(10, 10, 158, 39);
		EtiquetaTemperatura.add(TagTemperature);
		
		JPanel EtiquetaMedicion = new JPanel();
		EtiquetaMedicion.setBorder(new EmptyBorder(0, 0, 0, 0));
		EtiquetaMedicion.setForeground(Color.BLACK);
		EtiquetaMedicion.setBackground(new Color(240, 240, 240));
		EtiquetaMedicion.setBounds(0, 350, 178, 59);
		contentPane.add(EtiquetaMedicion);
		EtiquetaMedicion.setLayout(null);

		JLabel TagLogitud = new JLabel("Longitud");
		TagLogitud.setForeground(new Color(255, 128, 64));
		TagLogitud.setHorizontalAlignment(SwingConstants.CENTER);
		TagLogitud.setFont(new Font("Open Sans Semibold", Font.PLAIN, 30));
		TagLogitud.setBounds(10, 0, 158, 42);
		EtiquetaMedicion.add(TagLogitud);
		
		JPanel Content = new JPanel(); //Panel de referencia para sobreescribir sobre el los paneles llamados durante la ejecución.
		Content.setBounds(177, 0, 516, 515);
		contentPane.add(Content);
		Content.setLayout(null);
		
		ConverterJP CP = new ConverterJP();
		CP.setSize(495, 515);
		CP.setLocation(0, 0);
		Content.removeAll();
		Content.add(CP,BorderLayout.CENTER);
		Content.revalidate();
		Content.repaint();
		
		JButton CurrrencyBtn = new JButton("");	
		CurrrencyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConverterJP CJP = new ConverterJP();
				AdjustPanel(CJP, Content);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CurrrencyBtn.setCursor(new Cursor(12));
			}
		});
		CurrrencyBtn.setIcon(new ImageIcon(Conversor.class.getResource("/resources/Btn1Test.png")));
		CurrrencyBtn.setToolTipText("");
		CurrrencyBtn.setBackground(new Color(240, 240, 240));
		CurrrencyBtn.setForeground(new Color(128, 255, 255));
		CurrrencyBtn.setFocusPainted(false);
		CurrrencyBtn.setBorder(null);
		CurrrencyBtn.setBounds(10, 58, 157, 107);
		contentPane.add(CurrrencyBtn);
	
		JButton TemperatureBtn = new JButton("");
		TemperatureBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TemperatureJP TJP = new TemperatureJP();
				AdjustPanel(TJP, Content);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				TemperatureBtn.setCursor(new Cursor(12));
			}
		});
		TemperatureBtn.setBackground(new Color(240, 240, 240));
		TemperatureBtn.setIcon(new ImageIcon(Conversor.class.getResource("/resources/BtnTemperature.png")));
		TemperatureBtn.setFocusPainted(false);
		TemperatureBtn.setBorder(null);
		TemperatureBtn.setBounds(10, 244, 160, 96);
		contentPane.add(TemperatureBtn);
		
		JButton Meditionbtn = new JButton("");
		Meditionbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MeditionJP MJP = new MeditionJP();
				AdjustPanel(MJP, Content);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Meditionbtn.setCursor(new Cursor(12));
			}
		});
		Meditionbtn.setBackground(new Color(240, 240, 240));
		Meditionbtn.setIcon(new ImageIcon(Conversor.class.getResource("/resources/BtnMedition.png")));
		Meditionbtn.setFocusPainted(false);
		Meditionbtn.setBorder(null);
		Meditionbtn.setBounds(10, 397, 160, 96);
		contentPane.add(Meditionbtn);
		
	}
	
	/**
	 * <h1>Método de Ajuste</h1>
	 * Este método se encarga de ajustar cada <em>JPanel</em> a su posición especifica, así como su impresión.
	 * @param NP Nuevo panel que será impreso.
	 * @param PB Panel base sobre el cual se sobreescribirá el panel "NP".
	 */
	public void AdjustPanel(JPanel NP,JPanel PB) {
		NP.setSize(593, 515);
		NP.setLocation(0, 0);
		PB.removeAll();
		PB.add(NP, BorderLayout.CENTER);
		PB.revalidate();
		PB.repaint();
	}


}
