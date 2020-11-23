package mvc.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mvc.controller.ControladorAeropuerto;
import mvc.controller.ControladorLineaAerea;
import mvc.controller.ControladorVuelo;
import mvc.eventos.EventoVuelo;

import javax.swing.JComboBox;

public class VistaVuelo extends JFrame{
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldNumero;
	

	public JTextField textField_idAerolineaMod;
	public JTextField textFieldNombreMod;
	public JTextField textFieldApellidoMod;
	public JTextField textFieldCantidadDeAsientos;
	public JTextField textFieldFechaSalida;
	public JTextField textFieldFechaLlegada;
	public JTextField textFieldTiempoVuelo;
	public JTextField ModtextFieldNumero;
	public JTextField ModtextFieldCantidadAsientos;
	public JTextField ModtextFieldFechaSalida;
	public JTextField ModtextFieldFechaLlegada;
	public JTextField ModtextFieldTiempoVuelo;
	public JComboBox comboBoxAerolinea;
	public JComboBox modcomboBoxAerolinea;
	public JButton btnAlta;
	public JButton btnModificar;
	public JButton btnAtras;
	public JButton btnEliminar;
	public JButton btnConsultar;
	public JComboBox comboBoxAeropLlegada;
	public JComboBox comboBoxAeropSalida;
	public JComboBox modcomboBoxAeropLlegada;
	public JComboBox modcomboBoxAeropSalida;
	public JComboBox comboBoxID;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVuelo window = new VistaVuelo();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaVuelo() {
		setTitle("Vuelo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelArgegarAerolinea = new JLabel("Agregar Vuelo");
		labelArgegarAerolinea.setBounds(114, 0, 173, 32);
		labelArgegarAerolinea.setHorizontalAlignment(SwingConstants.CENTER);
		labelArgegarAerolinea.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(labelArgegarAerolinea);
		
		JLabel labelNombre = new JLabel("Numero");
		labelNombre.setBounds(10, 36, 51, 14);
		contentPane.add(labelNombre);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(124, 33, 141, 19);
		contentPane.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(552, 57, 89, 23);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(new EventoVuelo(this));
		
		JLabel lblModificarAerolinea = new JLabel("Modificar Vuelo");
		lblModificarAerolinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarAerolinea.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblModificarAerolinea.setBounds(377, 0, 173, 32);
		contentPane.add(lblModificarAerolinea);
		
		btnAlta = new JButton("Agregar");
		btnAlta.setBounds(148, 239, 89, 23);
		contentPane.add(btnAlta);
		btnAlta.addActionListener(new EventoVuelo(this));
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(409, 266, 89, 23);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(new EventoVuelo(this));
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(552, 287, 89, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new EventoVuelo(this));
		
		JLabel lblCantidadDeAsientos = new JLabel("Cantidad de Asientos");
		lblCantidadDeAsientos.setBounds(10, 61, 113, 14);
		contentPane.add(lblCantidadDeAsientos);
		
		JLabel lblAeropuertoDeLlegada = new JLabel("Aeropuerto de Llegada");
		lblAeropuertoDeLlegada.setBounds(10, 86, 113, 14);
		contentPane.add(lblAeropuertoDeLlegada);
		
		JLabel lblAeropuertoDeSalida = new JLabel("Aeropuerto de Salida");
		lblAeropuertoDeSalida.setBounds(10, 111, 113, 14);
		contentPane.add(lblAeropuertoDeSalida);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida");
		lblFechaDeSalida.setBounds(10, 136, 113, 14);
		contentPane.add(lblFechaDeSalida);
		
		JLabel lblFechaDeLlegada = new JLabel("Fecha de Llegada");
		lblFechaDeLlegada.setBounds(10, 161, 113, 14);
		contentPane.add(lblFechaDeLlegada);
		
		JLabel lblTiempoDeVuelo = new JLabel("Tiempo de Vuelo");
		lblTiempoDeVuelo.setBounds(10, 187, 113, 14);
		contentPane.add(lblTiempoDeVuelo);
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(10, 212, 113, 14);
		contentPane.add(lblAerolinea);
		
		textFieldCantidadDeAsientos = new JTextField();
		textFieldCantidadDeAsientos.setColumns(10);
		textFieldCantidadDeAsientos.setBounds(124, 58, 141, 19);
		contentPane.add(textFieldCantidadDeAsientos);
		
		textFieldFechaSalida = new JTextField();
		textFieldFechaSalida.setColumns(10);
		textFieldFechaSalida.setBounds(124, 133, 141, 19);
		contentPane.add(textFieldFechaSalida);
		
		textFieldFechaLlegada = new JTextField();
		textFieldFechaLlegada.setColumns(10);
		textFieldFechaLlegada.setBounds(124, 158, 141, 19);
		contentPane.add(textFieldFechaLlegada);
		
		textFieldTiempoVuelo = new JTextField();
		textFieldTiempoVuelo.setColumns(10);
		textFieldTiempoVuelo.setBounds(124, 184, 141, 19);
		contentPane.add(textFieldTiempoVuelo);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(275, 36, 51, 14);
		contentPane.add(lblId);
		
		JLabel label = new JLabel("Numero");
		label.setBounds(275, 61, 51, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Cantidad de Asientos");
		label_1.setBounds(273, 86, 113, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Aeropuerto de Salida");
		label_2.setBounds(275, 136, 113, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Aeropuerto de Llegada");
		label_3.setBounds(275, 111, 113, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Fecha de Salida");
		label_4.setBounds(275, 161, 113, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Fecha de Llegada");
		label_5.setBounds(275, 187, 113, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Tiempo de Vuelo");
		label_6.setBounds(273, 212, 113, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Aerolinea");
		label_7.setBounds(273, 239, 113, 14);
		contentPane.add(label_7);
		
		ModtextFieldNumero = new JTextField();
		ModtextFieldNumero.setColumns(10);
		ModtextFieldNumero.setBounds(387, 58, 141, 19);
		contentPane.add(ModtextFieldNumero);
		
		ModtextFieldCantidadAsientos = new JTextField();
		ModtextFieldCantidadAsientos.setColumns(10);
		ModtextFieldCantidadAsientos.setBounds(387, 83, 141, 19);
		contentPane.add(ModtextFieldCantidadAsientos);
		
		ModtextFieldFechaSalida = new JTextField();
		ModtextFieldFechaSalida.setColumns(10);
		ModtextFieldFechaSalida.setBounds(387, 158, 141, 19);
		contentPane.add(ModtextFieldFechaSalida);
		
		ModtextFieldFechaLlegada = new JTextField();
		ModtextFieldFechaLlegada.setColumns(10);
		ModtextFieldFechaLlegada.setBounds(387, 184, 141, 19);
		contentPane.add(ModtextFieldFechaLlegada);
		
		ModtextFieldTiempoVuelo = new JTextField();
		ModtextFieldTiempoVuelo.setColumns(10);
		ModtextFieldTiempoVuelo.setBounds(387, 209, 141, 19);
		contentPane.add(ModtextFieldTiempoVuelo);
		
		comboBoxAerolinea = new JComboBox(new ControladorLineaAerea().obtenerNombres().toArray());
		comboBoxAerolinea.setBounds(124, 209, 141, 19);
		contentPane.add(comboBoxAerolinea);
		
		modcomboBoxAerolinea = new JComboBox(new ControladorLineaAerea().obtenerNombres().toArray());
		modcomboBoxAerolinea.setBounds(387, 235, 141, 20);
		contentPane.add(modcomboBoxAerolinea);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(552, 32, 89, 23);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(new EventoVuelo(this));
		
		comboBoxAeropLlegada = new JComboBox(new ControladorAeropuerto().obtenerNombres().toArray());
		comboBoxAeropLlegada.setBounds(124, 83, 141, 17);
		contentPane.add(comboBoxAeropLlegada);
		
		comboBoxAeropSalida = new JComboBox(new ControladorAeropuerto().obtenerNombres().toArray());
		comboBoxAeropSalida.setBounds(124, 108, 141, 17);
		contentPane.add(comboBoxAeropSalida);
		
		modcomboBoxAeropSalida = new JComboBox(new ControladorAeropuerto().obtenerNombres().toArray());
		modcomboBoxAeropSalida.setBounds(387, 133, 141, 17);
		contentPane.add(modcomboBoxAeropSalida);
		
		modcomboBoxAeropLlegada = new JComboBox(new ControladorAeropuerto().obtenerNombres().toArray());
		modcomboBoxAeropLlegada.setBounds(387, 108, 141, 19);
		contentPane.add(modcomboBoxAeropLlegada);
		
		comboBoxID = new JComboBox(new ControladorVuelo().obtenerIds().toArray());
		comboBoxID.setBounds(387, 33, 141, 17);
		contentPane.add(comboBoxID);
		
	}
}
