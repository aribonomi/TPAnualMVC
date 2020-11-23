package mvc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.controller.ControladorCliente;
import mvc.controller.ControladorLineaAerea;
import mvc.controller.ControladorVenta;
import mvc.controller.ControladorVuelo;
import mvc.eventos.EventoVenta;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class VistaVenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	public JTextField textField_idAerolineaMod;
	public JTextField textFieldNombreMod;
	public JTextField textFieldApellidoMod;
	public JTextField textFieldFecha;
	public JTextField textFieldFormaDePago;
	public JTextField ModtextFieldFecha;
	public JTextField ModtextFieldFormaDePago;
	public JComboBox comboBoxCliente;
	public JComboBox comboBoxVuelo;
	public JComboBox comboBoxAerolinea;
	public JComboBox comboBoxId;
	public JComboBox modcomboBoxCliente;
	public JComboBox modcomboBoxVuelo;
	public JButton btnAgregar;
	public JButton btnModificarVenta;
	public JButton btnConsulta;
	public JButton btnEliminar;
	public JButton btnAtras;
	public JComboBox modcomboBoxAerolinea;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVenta window = new VistaVenta();
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
	public VistaVenta() {
		setTitle("Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelArgegarAerolinea = new JLabel("Agregar Venta");
		labelArgegarAerolinea.setBounds(103, 0, 173, 32);
		labelArgegarAerolinea.setHorizontalAlignment(SwingConstants.CENTER);
		labelArgegarAerolinea.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(labelArgegarAerolinea);
		
		JLabel labelNombre = new JLabel("Cliente");
		labelNombre.setBounds(10, 36, 51, 14);
		contentPane.add(labelNombre);
		
		JLabel labelApellido = new JLabel("ID Vuelo");
		labelApellido.setBounds(10, 61, 51, 14);
		contentPane.add(labelApellido);
		
		JLabel lblModificarAerolinea = new JLabel("Modificar Venta");
		lblModificarAerolinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarAerolinea.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblModificarAerolinea.setBounds(352, 0, 173, 32);
		contentPane.add(lblModificarAerolinea);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(524, 202, 89, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(new EventoVenta(this));
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(10, 86, 75, 14);
		contentPane.add(lblAerolinea);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(119, 110, 141, 19);
		contentPane.add(textFieldFecha);
		
		textFieldFormaDePago = new JTextField();
		textFieldFormaDePago.setColumns(10);
		textFieldFormaDePago.setBounds(119, 134, 141, 19);
		contentPane.add(textFieldFormaDePago);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 113, 51, 14);
		contentPane.add(lblFecha);
		
		JLabel lblFormaDePago = new JLabel("Forma de Pago");
		lblFormaDePago.setBounds(10, 137, 99, 14);
		contentPane.add(lblFormaDePago);
		
		JLabel label = new JLabel("Cliente");
		label.setBounds(292, 61, 51, 14);
		contentPane.add(label);
		
		JLabel lblIdVuelo = new JLabel("ID Vuelo");
		lblIdVuelo.setBounds(292, 86, 51, 14);
		contentPane.add(lblIdVuelo);
		
		JLabel label_2 = new JLabel("Aerolinea");
		label_2.setBounds(292, 113, 81, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Fecha");
		label_3.setBounds(292, 137, 51, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Forma de Pago");
		label_4.setBounds(292, 161, 81, 14);
		contentPane.add(label_4);
		
		ModtextFieldFecha = new JTextField();
		ModtextFieldFecha.setColumns(10);
		ModtextFieldFecha.setBounds(373, 134, 141, 19);
		contentPane.add(ModtextFieldFecha);
		
		ModtextFieldFormaDePago = new JTextField();
		ModtextFieldFormaDePago.setColumns(10);
		ModtextFieldFormaDePago.setBounds(373, 158, 141, 19);
		contentPane.add(ModtextFieldFormaDePago);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(292, 36, 51, 14);
		contentPane.add(lblId);
		
		comboBoxVuelo = new JComboBox(new ControladorVuelo().obtenerIds().toArray());
		comboBoxVuelo.setBounds(119, 58, 141, 20);
		contentPane.add(comboBoxVuelo);
		
		comboBoxAerolinea = new JComboBox(new ControladorLineaAerea().obtenerNombres().toArray());
		comboBoxAerolinea.setBounds(119, 83, 141, 20);
		contentPane.add(comboBoxAerolinea);
		
		comboBoxCliente = new JComboBox(new ControladorCliente().obtenerIds().toArray());
		comboBoxCliente.setBounds(119, 33, 141, 20);
		contentPane.add(comboBoxCliente);
		
		comboBoxId = new JComboBox(new ControladorVenta().obtenerIds().toArray());
		comboBoxId.setBounds(373, 33, 141, 20);
		contentPane.add(comboBoxId);
		
		modcomboBoxCliente = new JComboBox(new ControladorCliente().obtenerIds().toArray());
		modcomboBoxCliente.setBounds(373, 58, 141, 20);
		contentPane.add(modcomboBoxCliente);
		
		modcomboBoxVuelo = new JComboBox(new ControladorVuelo().obtenerIds().toArray());
		modcomboBoxVuelo.setBounds(373, 83, 141, 20);
		contentPane.add(modcomboBoxVuelo);
		
		modcomboBoxAerolinea = new JComboBox(new ControladorLineaAerea().obtenerNombres().toArray());
		modcomboBoxAerolinea.setBounds(373, 110, 141, 20);
		contentPane.add(modcomboBoxAerolinea);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(145, 164, 89, 23);
		contentPane.add(btnAgregar);
		btnAgregar.addActionListener(new EventoVenta(this));
		
		btnModificarVenta = new JButton("Modificar");
		btnModificarVenta.setBounds(403, 188, 89, 23);
		contentPane.add(btnModificarVenta);
		btnModificarVenta.addActionListener(new EventoVenta(this));
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.setBounds(524, 32, 89, 23);
		contentPane.add(btnConsulta);
		btnConsulta.addActionListener(new EventoVenta(this));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(524, 66, 89, 23);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(new EventoVenta(this));
		
	}
}
