package mvc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import dao.negocio.Alianza;
import mvc.controller.ControladorPais;
import mvc.controller.ControladorProvincia;
import mvc.eventos.EventoCliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;



public class VistaCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldCiudad;
	public JTextField textFieldCodP;
	public JTextField textFieldCelular;
	public JTextField textFieldPersonal;
	public JTextField textFieldLaboral;
	public JTextField textFieldNumPas;
	public JTextField textFieldAut_emision;
	public JTextField textField_vencimiento;
	public JTextField textField_CatPF;
	public JTextField textField_idAerolinea;
	public JTextField textFieldNombre;
	public JTextField textFieldApellido;
	public JTextField textFieldDni;
	public JTextField textFieldCuit;
	public JTextField textFieldNacimiento;
	public JTextField textFieldEmail;
	public JTextField textFieldCalle;
	public JTextField textFieldAltura;
	public JTextField textField_fechaEmision;

	
	
	public JComboBox comboBox_provincia;
	public JButton btnAltaCliente;
	public JComboBox comboBox_pais;
	public JComboBox comboBox_paisEmision;
	public JComboBox comboBoxAlianza;
	public JTextField textField_NumPF;
	public JTextField ModtextFieldNombre;
	public JTextField ModtextFieldApellido;
	public JTextField ModtextFieldDni;
	public JTextField ModtextFieldCuit;
	public JTextField ModtextFieldNacimiento;
	public JTextField ModtextFieldEmail;
	public JTextField ModtextFieldCalle;
	public JTextField ModtextFieldAltura;
	public JTextField ModtextFieldCiudad;
	public JTextField ModtextFieldCodP;
	public JTextField ModtextFieldID;
	public JTextField ModtextFieldCelular;
	public JTextField ModtextFieldPersonal;
	public JTextField ModtextFieldLaboral;
	public JTextField ModtextFieldNumero;
	public JTextField ModtextField_emision;
	public JTextField ModtextField_vencimiento;
	public JTextField ModtextFieldCategoria;
	public JTextField ModtextFieldNumeroPF;
	public JTextField ModtextFieldFechaEmision;
	public JTextField ConstextField_id;
	public JButton btnConsultaMod;
	public JButton btnConsulta;
	public JButton btnEliminarCliente;
	public JButton btnAtrasMenuCliente;
	public TextArea textArea_resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCliente frame = new VistaCliente();
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
	public VistaCliente() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelArgegarCliente = new JLabel("Agregar Cliente");
		labelArgegarCliente.setBounds(5, 0, 282, 32);
		labelArgegarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		labelArgegarCliente.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(labelArgegarCliente);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(5, 36, 51, 14);
		contentPane.add(labelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(146, 33, 141, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelApellido = new JLabel("Apellido");
		labelApellido.setBounds(5, 61, 51, 14);
		contentPane.add(labelApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(146, 58, 141, 19);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel labelDni = new JLabel("DNI");
		labelDni.setBounds(5, 86, 32, 14);
		contentPane.add(labelDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(146, 83, 141, 19);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel labelCuit = new JLabel("CUIT/CUIL");
		labelCuit.setBounds(5, 111, 64, 14);
		contentPane.add(labelCuit);
		
		textFieldCuit = new JTextField();
		textFieldCuit.setBounds(146, 108, 141, 19);
		contentPane.add(textFieldCuit);
		textFieldCuit.setColumns(10);
		
		JLabel labelNacimiento = new JLabel("Fecha de nacimiento");
		labelNacimiento.setBounds(5, 136, 105, 14);
		contentPane.add(labelNacimiento);
		
		textFieldNacimiento = new JTextField();
		textFieldNacimiento.setBounds(146, 133, 141, 19);
		contentPane.add(textFieldNacimiento);
		textFieldNacimiento.setColumns(10);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(5, 161, 46, 14);
		contentPane.add(labelEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(146, 158, 141, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel labelDireccion = new JLabel("Direcci\u00F3n");
		labelDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelDireccion.setBounds(5, 186, 64, 14);
		contentPane.add(labelDireccion);
		
		JLabel labelCalle = new JLabel("Calle");
		labelCalle.setBounds(5, 211, 46, 14);
		contentPane.add(labelCalle);
		
		textFieldCalle = new JTextField();
		textFieldCalle.setBounds(146, 208, 141, 19);
		contentPane.add(textFieldCalle);
		textFieldCalle.setColumns(10);
		
		JLabel labelAltura = new JLabel("Altura");
		labelAltura.setBounds(5, 236, 46, 14);
		contentPane.add(labelAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(146, 233, 141, 19);
		contentPane.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel labelCiudad = new JLabel("Ciudad");
		labelCiudad.setBounds(5, 261, 46, 14);
		contentPane.add(labelCiudad);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setBounds(146, 258, 141, 19);
		contentPane.add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		JLabel labelCodPostal = new JLabel("C\u00F3digo postal");
		labelCodPostal.setBounds(5, 286, 86, 14);
		contentPane.add(labelCodPostal);
		
		textFieldCodP = new JTextField();
		textFieldCodP.setBounds(146, 283, 141, 19);
		contentPane.add(textFieldCodP);
		textFieldCodP.setColumns(10);
		
		JLabel labelProvincia = new JLabel("Provincia");
		labelProvincia.setBounds(5, 311, 46, 14);
		contentPane.add(labelProvincia);
		
		comboBox_provincia = new JComboBox(new ControladorProvincia().obtenerNombres().toArray());
		comboBox_provincia.setBounds(146, 309, 141, 19);
		contentPane.add(comboBox_provincia);
		
		
		JLabel labelPais = new JLabel("Pa\u00EDs");
		labelPais.setBounds(5, 336, 46, 14);
		contentPane.add(labelPais);
		
		comboBox_pais = new JComboBox(new ControladorPais().obtenerNombres().toArray());
		comboBox_pais.setBounds(146, 334, 141, 19);
		contentPane.add(comboBox_pais);
		
		JLabel labelTelefono = new JLabel("Tel\u00E9fono");
		labelTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelTelefono.setBounds(5, 361, 74, 14);
		contentPane.add(labelTelefono);
		
		JLabel labelCelular = new JLabel("Celular");
		labelCelular.setBounds(5, 386, 46, 14);
		contentPane.add(labelCelular);
		
		textFieldCelular = new JTextField();
		textFieldCelular.setBounds(146, 384, 141, 17);
		contentPane.add(textFieldCelular);
		textFieldCelular.setColumns(10);
		
		JLabel labelPersonal = new JLabel("Personal");
		labelPersonal.setBounds(5, 411, 46, 14);
		contentPane.add(labelPersonal);
		
		textFieldPersonal = new JTextField();
		textFieldPersonal.setBounds(146, 408, 141, 19);
		contentPane.add(textFieldPersonal);
		textFieldPersonal.setColumns(10);
		
		JLabel labelLaboral = new JLabel("Laboral");
		labelLaboral.setBounds(5, 436, 46, 14);
		contentPane.add(labelLaboral);
		
		textFieldLaboral = new JTextField();
		textFieldLaboral.setBounds(146, 433, 141, 19);
		contentPane.add(textFieldLaboral);
		textFieldLaboral.setColumns(10);
		
		JLabel labelNumPasaporte = new JLabel("N\u00FAmero de pasaporte");
		labelNumPasaporte.setBounds(5, 461, 131, 14);
		contentPane.add(labelNumPasaporte);
		
		textFieldNumPas = new JTextField();
		textFieldNumPas.setBounds(146, 458, 141, 19);
		contentPane.add(textFieldNumPas);
		textFieldNumPas.setColumns(10);
		
		JLabel labelAutDeEmision = new JLabel("Autoridad de emisi\u00F3n");
		labelAutDeEmision.setBounds(5, 486, 105, 14);
		contentPane.add(labelAutDeEmision);
		
		textFieldAut_emision = new JTextField();
		textFieldAut_emision.setBounds(146, 484, 141, 17);
		contentPane.add(textFieldAut_emision);
		textFieldAut_emision.setColumns(10);
		
		JLabel labelFecha_vencimiento = new JLabel("Fecha de vencimiento");
		labelFecha_vencimiento.setBounds(5, 533, 105, 14);
		contentPane.add(labelFecha_vencimiento);
		
		textField_vencimiento = new JTextField();
		textField_vencimiento.setBounds(146, 531, 141, 17);
		contentPane.add(textField_vencimiento);
		textField_vencimiento.setColumns(10);
		
		JLabel labelPais_emision = new JLabel("Pa\u00EDs de emisi\u00F3n");
		labelPais_emision.setBounds(5, 561, 105, 14);
		contentPane.add(labelPais_emision);
		
		JLabel labelPasajeroFrecuente = new JLabel("Pasajero frecuente");
		labelPasajeroFrecuente.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelPasajeroFrecuente.setBounds(5, 586, 125, 14);
		contentPane.add(labelPasajeroFrecuente);
		
		comboBox_paisEmision = new JComboBox(new ControladorPais().obtenerNombres().toArray());
		comboBox_paisEmision.setBounds(146, 559, 141, 19);
		contentPane.add(comboBox_paisEmision);
		
		JLabel labelCategoria = new JLabel("Categor\u00EDa");
		labelCategoria.setBounds(5, 611, 86, 14);
		contentPane.add(labelCategoria);
		
		textField_CatPF = new JTextField();
		textField_CatPF.setBounds(146, 609, 141, 17);
		contentPane.add(textField_CatPF);
		textField_CatPF.setColumns(10);
		
		JLabel labelAlianza = new JLabel("Alianza");
		labelAlianza.setBounds(5, 636, 46, 14);
		contentPane.add(labelAlianza);
		
		comboBoxAlianza = new JComboBox();
		comboBoxAlianza.setModel(new DefaultComboBoxModel(new String[] {"SKYTEAM", "ONEWORLD", "STARALLIANCE"}));
		comboBoxAlianza.setBounds(146, 633, 141, 17);
		contentPane.add(comboBoxAlianza);
		
		JLabel lblId_aerolinea = new JLabel("ID aerol\u00EDnea");
		lblId_aerolinea.setBounds(5, 683, 105, 14);
		contentPane.add(lblId_aerolinea);
		
		textField_idAerolinea = new JTextField();
		textField_idAerolinea.setBounds(146, 681, 141, 17);
		contentPane.add(textField_idAerolinea);
		textField_idAerolinea.setColumns(10);
		
		btnAltaCliente = new JButton("Agregar");
		btnAltaCliente.setBounds(301, 679, 89, 23);
		contentPane.add(btnAltaCliente);
		
		JLabel labelNumero = new JLabel("N\u00FAmero");
		labelNumero.setBounds(5, 658, 46, 14);
		contentPane.add(labelNumero);
		
		textField_NumPF = new JTextField();
		textField_NumPF.setBounds(146, 655, 141, 19);
		contentPane.add(textField_NumPF);
		textField_NumPF.setColumns(10);
		
		JLabel lblModificarCliente = new JLabel("Modificar Cliente");
		lblModificarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarCliente.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblModificarCliente.setBounds(301, 0, 343, 32);
		contentPane.add(lblModificarCliente);
		
		ModtextFieldNombre = new JTextField();
		ModtextFieldNombre.setColumns(10);
		ModtextFieldNombre.setBounds(404, 58, 141, 19);
		contentPane.add(ModtextFieldNombre);
		
		JLabel label = new JLabel("Nombre");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(286, 61, 117, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Apellido");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(286, 86, 117, 14);
		contentPane.add(label_1);
		
		ModtextFieldApellido = new JTextField();
		ModtextFieldApellido.setColumns(10);
		ModtextFieldApellido.setBounds(404, 83, 141, 19);
		contentPane.add(ModtextFieldApellido);
		
		JLabel label_2 = new JLabel("DNI");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(286, 111, 117, 14);
		contentPane.add(label_2);
		
		ModtextFieldDni = new JTextField();
		ModtextFieldDni.setColumns(10);
		ModtextFieldDni.setBounds(404, 108, 141, 19);
		contentPane.add(ModtextFieldDni);
		
		JLabel label_3 = new JLabel("CUIT/CUIL");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(297, 136, 106, 14);
		contentPane.add(label_3);
		
		ModtextFieldCuit = new JTextField();
		ModtextFieldCuit.setColumns(10);
		ModtextFieldCuit.setBounds(404, 133, 141, 19);
		contentPane.add(ModtextFieldCuit);
		
		JLabel label_4 = new JLabel("Fecha de nacimiento");
		label_4.setBounds(297, 161, 105, 14);
		contentPane.add(label_4);
		
		ModtextFieldNacimiento = new JTextField();
		ModtextFieldNacimiento.setColumns(10);
		ModtextFieldNacimiento.setBounds(404, 158, 141, 19);
		contentPane.add(ModtextFieldNacimiento);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(286, 186, 117, 14);
		contentPane.add(label_5);
		
		ModtextFieldEmail = new JTextField();
		ModtextFieldEmail.setColumns(10);
		ModtextFieldEmail.setBounds(404, 183, 141, 19);
		contentPane.add(ModtextFieldEmail);
		
		JLabel label_7 = new JLabel("Calle");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(286, 211, 117, 14);
		contentPane.add(label_7);
		
		ModtextFieldCalle = new JTextField();
		ModtextFieldCalle.setColumns(10);
		ModtextFieldCalle.setBounds(404, 208, 141, 19);
		contentPane.add(ModtextFieldCalle);
		
		JLabel label_8 = new JLabel("Altura");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(286, 236, 117, 14);
		contentPane.add(label_8);
		
		ModtextFieldAltura = new JTextField();
		ModtextFieldAltura.setColumns(10);
		ModtextFieldAltura.setBounds(404, 233, 141, 19);
		contentPane.add(ModtextFieldAltura);
		
		JLabel label_9 = new JLabel("Ciudad");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(286, 261, 117, 14);
		contentPane.add(label_9);
		
		ModtextFieldCiudad = new JTextField();
		ModtextFieldCiudad.setColumns(10);
		ModtextFieldCiudad.setBounds(404, 258, 141, 19);
		contentPane.add(ModtextFieldCiudad);
		
		JLabel label_10 = new JLabel("C\u00F3digo postal");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(286, 286, 117, 14);
		contentPane.add(label_10);
		
		ModtextFieldCodP = new JTextField();
		ModtextFieldCodP.setColumns(10);
		ModtextFieldCodP.setBounds(404, 283, 141, 19);
		contentPane.add(ModtextFieldCodP);
		
		JLabel label_11 = new JLabel("Provincia");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(286, 311, 117, 14);
		contentPane.add(label_11);
		
		JComboBox ModcomboBox_provincia = new JComboBox(new ControladorProvincia().obtenerNombres().toArray());
		ModcomboBox_provincia.setBounds(404, 309, 141, 19);
		contentPane.add(ModcomboBox_provincia);
		
		JLabel label_12 = new JLabel("Pa\u00EDs");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(286, 336, 117, 14);
		contentPane.add(label_12);
		
		JComboBox ModcomboBox_pais = new JComboBox(new ControladorPais().obtenerNombres().toArray());
		ModcomboBox_pais.setBounds(404, 334, 141, 19);
		contentPane.add(ModcomboBox_pais);
		
		JLabel label_14 = new JLabel("Celular");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(286, 361, 117, 14);
		contentPane.add(label_14);
		
		ModtextFieldID = new JTextField();
		ModtextFieldID.setColumns(10);
		ModtextFieldID.setBounds(404, 33, 141, 19);
		contentPane.add(ModtextFieldID);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1.setBounds(286, 36, 117, 14);
		contentPane.add(lblId_1);
		
		ModtextFieldCelular = new JTextField();
		ModtextFieldCelular.setColumns(10);
		ModtextFieldCelular.setBounds(404, 359, 141, 17);
		contentPane.add(ModtextFieldCelular);
		
		JLabel label_6 = new JLabel("Personal");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(286, 386, 117, 14);
		contentPane.add(label_6);
		
		ModtextFieldPersonal = new JTextField();
		ModtextFieldPersonal.setColumns(10);
		ModtextFieldPersonal.setBounds(404, 383, 141, 17);
		contentPane.add(ModtextFieldPersonal);
		
		JLabel label_13 = new JLabel("Laboral");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(286, 411, 117, 14);
		contentPane.add(label_13);
		
		ModtextFieldLaboral = new JTextField();
		ModtextFieldLaboral.setColumns(10);
		ModtextFieldLaboral.setBounds(404, 409, 141, 17);
		contentPane.add(ModtextFieldLaboral);
		
		JLabel label_15 = new JLabel("N\u00FAmero");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(286, 436, 117, 14);
		contentPane.add(label_15);
		
		ModtextFieldNumero = new JTextField();
		ModtextFieldNumero.setColumns(10);
		ModtextFieldNumero.setBounds(404, 433, 141, 19);
		contentPane.add(ModtextFieldNumero);
		
		JLabel label_16 = new JLabel("Autoridad de emisi\u00F3n");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(286, 461, 120, 14);
		contentPane.add(label_16);
		
		ModtextField_emision = new JTextField();
		ModtextField_emision.setColumns(10);
		ModtextField_emision.setBounds(404, 458, 141, 17);
		contentPane.add(ModtextField_emision);
		
		JLabel label_17 = new JLabel("Fecha de vencimiento");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(298, 508, 105, 14);
		contentPane.add(label_17);
		
		ModtextField_vencimiento = new JTextField();
		ModtextField_vencimiento.setColumns(10);
		ModtextField_vencimiento.setBounds(404, 506, 141, 17);
		contentPane.add(ModtextField_vencimiento);
		
		JLabel label_18 = new JLabel("Pa\u00EDs de emisi\u00F3n");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBounds(297, 533, 105, 14);
		contentPane.add(label_18);
		
		JComboBox ModcomboBox_paisEmision = new JComboBox(new ControladorPais().obtenerNombres().toArray());
		ModcomboBox_paisEmision.setBounds(404, 531, 141, 19);
		contentPane.add(ModcomboBox_paisEmision);
		
		JLabel label_19 = new JLabel("Categor\u00EDa");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(286, 561, 117, 14);
		contentPane.add(label_19);
		
		ModtextFieldCategoria = new JTextField();
		ModtextFieldCategoria.setColumns(10);
		ModtextFieldCategoria.setBounds(404, 559, 141, 17);
		contentPane.add(ModtextFieldCategoria);
		
		JLabel label_20 = new JLabel("Alianza");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBounds(286, 586, 117, 14);
		contentPane.add(label_20);
		
		JComboBox ModcomboBoxAlianza = new JComboBox();
		ModcomboBoxAlianza.setModel(new DefaultComboBoxModel(new String[] {"SKYTEAM", "ONEWORLD", "STARALLIANCE"}));
		ModcomboBoxAlianza.setBounds(404, 585, 141, 17);
		contentPane.add(ModcomboBoxAlianza);
		
		JLabel label_21 = new JLabel("N\u00FAmero");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setBounds(286, 611, 117, 14);
		contentPane.add(label_21);
		
		ModtextFieldNumeroPF = new JTextField();
		ModtextFieldNumeroPF.setColumns(10);
		ModtextFieldNumeroPF.setBounds(404, 608, 141, 19);
		contentPane.add(ModtextFieldNumeroPF);
		
		btnConsultaMod = new JButton("Consultar");
		btnConsultaMod.setBounds(555, 32, 89, 23);
		contentPane.add(btnConsultaMod);
		btnConsultaMod.addActionListener(new EventoCliente(this));
		
		btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.setBounds(857, 77, 89, 23);
		contentPane.add(btnEliminarCliente);
		btnEliminarCliente.addActionListener(new EventoCliente(this));
		
		JButton btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setBounds(555, 607, 89, 23);
		contentPane.add(btnModificarCliente);
		btnModificarCliente.addActionListener(new EventoCliente(this));
		
		btnAtrasMenuCliente = new JButton("Atras");
		btnAtrasMenuCliente.setBounds(819, 457, 89, 23);
		contentPane.add(btnAtrasMenuCliente);
		btnAtrasMenuCliente.addActionListener(new EventoCliente(this));
		
		JLabel labelFecha_emision = new JLabel("Fecha de emision");
		labelFecha_emision.setBounds(5, 508, 105, 14);
		contentPane.add(labelFecha_emision);
		
		textField_fechaEmision = new JTextField();
		textField_fechaEmision.setBounds(146, 508, 141, 17);
		contentPane.add(textField_fechaEmision);
		textField_fechaEmision.setColumns(10);
		
		JLabel Modlabel_fechaEmision = new JLabel("Fecha de emision");
		Modlabel_fechaEmision.setHorizontalAlignment(SwingConstants.CENTER);
		Modlabel_fechaEmision.setBounds(297, 486, 106, 14);
		contentPane.add(Modlabel_fechaEmision);
		
		ModtextFieldFechaEmision = new JTextField();
		ModtextFieldFechaEmision.setBounds(404, 483, 141, 17);
		contentPane.add(ModtextFieldFechaEmision);
		ModtextFieldFechaEmision.setColumns(10);
		
		JLabel lblId_2 = new JLabel("ID");
		lblId_2.setBounds(674, 36, 46, 14);
		contentPane.add(lblId_2);
		
		ConstextField_id = new JTextField();
		ConstextField_id.setBounds(730, 34, 117, 17);
		contentPane.add(ConstextField_id);
		ConstextField_id.setColumns(10);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.setBounds(857, 32, 89, 23);
		contentPane.add(btnConsulta);
		btnConsulta.addActionListener(new EventoCliente(this));
		
		textArea_resultado = new TextArea();
		textArea_resultado.setBounds(621, 111, 325, 191);
		contentPane.add(textArea_resultado);
		
		JLabel labelConsultar = new JLabel("Consultar cliente");
		labelConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		labelConsultar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelConsultar.setBounds(674, 0, 272, 32);
		contentPane.add(labelConsultar);
		btnAltaCliente.addActionListener(new EventoCliente(this));
		
		
		
		
	}
}
