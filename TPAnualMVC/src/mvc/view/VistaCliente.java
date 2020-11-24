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
import mvc.controller.ControladorLineaAerea;
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
	public JTextField textFieldNombre;
	public JTextField textFieldApellido;
	public JTextField textFieldDni;
	public JTextField textFieldCuit;
	public JTextField textFieldNacimiento;
	public JTextField textFieldEmail;
	public JTextField textFieldCalle;
	public JTextField textFieldAltura;
	public JTextField textField_fechaEmision;
	public JComboBox comboBoxAerolinea;

	
	
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
	public JButton btnConsultaMod;
	public JButton btnEliminarCliente;
	public JButton btnAtrasMenuCliente;
	public JComboBox ModcomboBox_paisEmision;
	public JComboBox ModcomboBox_provincia;
	public JComboBox ModcomboBox_pais;
	public JComboBox ModcomboBoxAlianza;
	public JButton btnModificarCliente;
	public JLabel lbl_idDireccion;
	public JLabel lbl_idTelefono;
	public JLabel lbl_idPasaporte;
	public JLabel lbl_idPF;
	public JComboBox ModcomboBoxAerolinea;
	public JTextField textFieldProvincia;
	public JTextField textFieldOtroPais;
	public JTextField modtextFieldOtraProv;
	public JTextField modtextFieldOtroPais;
	

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
		setBounds(100, 100, 976, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelArgegarCliente = new JLabel("Agregar Cliente");
		labelArgegarCliente.setBounds(5, 0, 458, 32);
		labelArgegarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		labelArgegarCliente.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(labelArgegarCliente);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(5, 36, 51, 14);
		contentPane.add(labelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(170, 33, 141, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelApellido = new JLabel("Apellido");
		labelApellido.setBounds(5, 61, 51, 14);
		contentPane.add(labelApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(170, 58, 141, 19);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel labelDni = new JLabel("DNI");
		labelDni.setBounds(5, 86, 32, 14);
		contentPane.add(labelDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(170, 83, 141, 19);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel labelCuit = new JLabel("CUIT/CUIL");
		labelCuit.setBounds(5, 111, 64, 14);
		contentPane.add(labelCuit);
		
		textFieldCuit = new JTextField();
		textFieldCuit.setBounds(170, 108, 141, 19);
		contentPane.add(textFieldCuit);
		textFieldCuit.setColumns(10);
		
		JLabel labelNacimiento = new JLabel("Fecha de nacimiento");
		labelNacimiento.setBounds(5, 136, 131, 14);
		contentPane.add(labelNacimiento);
		
		textFieldNacimiento = new JTextField();
		textFieldNacimiento.setBounds(170, 133, 141, 19);
		contentPane.add(textFieldNacimiento);
		textFieldNacimiento.setColumns(10);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(5, 161, 46, 14);
		contentPane.add(labelEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(170, 158, 141, 19);
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
		textFieldCalle.setBounds(170, 208, 141, 19);
		contentPane.add(textFieldCalle);
		textFieldCalle.setColumns(10);
		
		JLabel labelAltura = new JLabel("Altura");
		labelAltura.setBounds(5, 236, 46, 14);
		contentPane.add(labelAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(170, 233, 141, 19);
		contentPane.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel labelCiudad = new JLabel("Ciudad");
		labelCiudad.setBounds(5, 261, 46, 14);
		contentPane.add(labelCiudad);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setBounds(170, 258, 141, 19);
		contentPane.add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		JLabel labelCodPostal = new JLabel("C\u00F3digo postal");
		labelCodPostal.setBounds(5, 286, 86, 14);
		contentPane.add(labelCodPostal);
		
		textFieldCodP = new JTextField();
		textFieldCodP.setBounds(170, 283, 141, 19);
		contentPane.add(textFieldCodP);
		textFieldCodP.setColumns(10);
		
		JLabel labelProvincia = new JLabel("Provincia");
		labelProvincia.setBounds(5, 311, 46, 14);
		contentPane.add(labelProvincia);
		
		comboBox_provincia = new JComboBox(new ControladorProvincia().obtenerNombres().toArray());
		comboBox_provincia.setBounds(170, 309, 141, 19);
		contentPane.add(comboBox_provincia);
		
		
		JLabel labelPais = new JLabel("Pa\u00EDs");
		labelPais.setBounds(5, 336, 46, 14);
		contentPane.add(labelPais);
		
		comboBox_pais = new JComboBox(new ControladorPais().obtenerNombres().toArray());
		comboBox_pais.setBounds(170, 334, 141, 19);
		contentPane.add(comboBox_pais);
		
		JLabel labelTelefono = new JLabel("Tel\u00E9fono");
		labelTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelTelefono.setBounds(5, 361, 74, 14);
		contentPane.add(labelTelefono);
		
		JLabel labelCelular = new JLabel("Celular");
		labelCelular.setBounds(5, 386, 46, 14);
		contentPane.add(labelCelular);
		
		textFieldCelular = new JTextField();
		textFieldCelular.setBounds(170, 384, 141, 17);
		contentPane.add(textFieldCelular);
		textFieldCelular.setColumns(10);
		
		JLabel labelPersonal = new JLabel("Personal");
		labelPersonal.setBounds(5, 411, 46, 14);
		contentPane.add(labelPersonal);
		
		textFieldPersonal = new JTextField();
		textFieldPersonal.setBounds(170, 408, 141, 19);
		contentPane.add(textFieldPersonal);
		textFieldPersonal.setColumns(10);
		
		JLabel labelLaboral = new JLabel("Laboral");
		labelLaboral.setBounds(5, 436, 46, 14);
		contentPane.add(labelLaboral);
		
		textFieldLaboral = new JTextField();
		textFieldLaboral.setBounds(170, 433, 141, 19);
		contentPane.add(textFieldLaboral);
		textFieldLaboral.setColumns(10);
		
		JLabel labelNumPasaporte = new JLabel("N\u00FAmero de pasaporte");
		labelNumPasaporte.setBounds(5, 461, 155, 14);
		contentPane.add(labelNumPasaporte);
		
		textFieldNumPas = new JTextField();
		textFieldNumPas.setBounds(170, 458, 141, 19);
		contentPane.add(textFieldNumPas);
		textFieldNumPas.setColumns(10);
		
		JLabel labelAutDeEmision = new JLabel("Autoridad de emisi\u00F3n");
		labelAutDeEmision.setBounds(5, 486, 155, 14);
		contentPane.add(labelAutDeEmision);
		
		textFieldAut_emision = new JTextField();
		textFieldAut_emision.setBounds(170, 484, 141, 17);
		contentPane.add(textFieldAut_emision);
		textFieldAut_emision.setColumns(10);
		
		JLabel labelFecha_vencimiento = new JLabel("Fecha de vencimiento");
		labelFecha_vencimiento.setBounds(5, 533, 131, 14);
		contentPane.add(labelFecha_vencimiento);
		
		textField_vencimiento = new JTextField();
		textField_vencimiento.setBounds(170, 531, 141, 17);
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
		comboBox_paisEmision.setBounds(170, 559, 141, 19);
		contentPane.add(comboBox_paisEmision);
		
		JLabel labelCategoria = new JLabel("Categor\u00EDa");
		labelCategoria.setBounds(5, 611, 86, 14);
		contentPane.add(labelCategoria);
		
		textField_CatPF = new JTextField();
		textField_CatPF.setBounds(170, 609, 141, 17);
		contentPane.add(textField_CatPF);
		textField_CatPF.setColumns(10);
		
		JLabel labelAlianza = new JLabel("Alianza");
		labelAlianza.setBounds(5, 636, 46, 14);
		contentPane.add(labelAlianza);
		
		comboBoxAlianza = new JComboBox();
		comboBoxAlianza.setModel(new DefaultComboBoxModel(Alianza.values()));
		comboBoxAlianza.setBounds(170, 631, 141, 17);
		contentPane.add(comboBoxAlianza);
		
		JLabel lblAerolinea = new JLabel("Aerol\u00EDnea");
		lblAerolinea.setBounds(5, 681, 105, 14);
		contentPane.add(lblAerolinea);
		
		btnAltaCliente = new JButton("Agregar");
		btnAltaCliente.setBounds(321, 672, 89, 23);
		contentPane.add(btnAltaCliente);
		
		JLabel labelNumero = new JLabel("N\u00FAmero");
		labelNumero.setBounds(5, 658, 46, 14);
		contentPane.add(labelNumero);
		
		textField_NumPF = new JTextField();
		textField_NumPF.setBounds(170, 655, 141, 19);
		contentPane.add(textField_NumPF);
		textField_NumPF.setColumns(10);
		
		JLabel lblModificarCliente = new JLabel("Modificar Cliente");
		lblModificarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarCliente.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblModificarCliente.setBounds(491, 0, 459, 32);
		contentPane.add(lblModificarCliente);
		
		ModtextFieldNombre = new JTextField();
		ModtextFieldNombre.setColumns(10);
		ModtextFieldNombre.setBounds(618, 58, 141, 19);
		contentPane.add(ModtextFieldNombre);
		
		JLabel label = new JLabel("Nombre");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(491, 61, 117, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Apellido");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(491, 86, 117, 14);
		contentPane.add(label_1);
		
		ModtextFieldApellido = new JTextField();
		ModtextFieldApellido.setColumns(10);
		ModtextFieldApellido.setBounds(618, 83, 141, 19);
		contentPane.add(ModtextFieldApellido);
		
		JLabel label_2 = new JLabel("DNI");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(491, 111, 117, 14);
		contentPane.add(label_2);
		
		ModtextFieldDni = new JTextField();
		ModtextFieldDni.setColumns(10);
		ModtextFieldDni.setBounds(618, 108, 141, 19);
		contentPane.add(ModtextFieldDni);
		
		JLabel label_3 = new JLabel("CUIT/CUIL");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(491, 136, 117, 14);
		contentPane.add(label_3);
		
		ModtextFieldCuit = new JTextField();
		ModtextFieldCuit.setColumns(10);
		ModtextFieldCuit.setBounds(618, 133, 141, 19);
		contentPane.add(ModtextFieldCuit);
		
		JLabel label_4 = new JLabel("Fecha de nacimiento");
		label_4.setBounds(491, 161, 117, 14);
		contentPane.add(label_4);
		
		ModtextFieldNacimiento = new JTextField();
		ModtextFieldNacimiento.setColumns(10);
		ModtextFieldNacimiento.setBounds(618, 158, 141, 19);
		contentPane.add(ModtextFieldNacimiento);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setBounds(491, 186, 117, 14);
		contentPane.add(label_5);
		
		ModtextFieldEmail = new JTextField();
		ModtextFieldEmail.setColumns(10);
		ModtextFieldEmail.setBounds(618, 183, 141, 19);
		contentPane.add(ModtextFieldEmail);
		
		JLabel label_7 = new JLabel("Calle");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setBounds(491, 211, 117, 14);
		contentPane.add(label_7);
		
		ModtextFieldCalle = new JTextField();
		ModtextFieldCalle.setColumns(10);
		ModtextFieldCalle.setBounds(618, 208, 141, 19);
		contentPane.add(ModtextFieldCalle);
		
		JLabel label_8 = new JLabel("Altura");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setBounds(491, 236, 117, 14);
		contentPane.add(label_8);
		
		ModtextFieldAltura = new JTextField();
		ModtextFieldAltura.setColumns(10);
		ModtextFieldAltura.setBounds(618, 233, 141, 19);
		contentPane.add(ModtextFieldAltura);
		
		JLabel label_9 = new JLabel("Ciudad");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setBounds(491, 261, 117, 14);
		contentPane.add(label_9);
		
		ModtextFieldCiudad = new JTextField();
		ModtextFieldCiudad.setColumns(10);
		ModtextFieldCiudad.setBounds(618, 258, 141, 19);
		contentPane.add(ModtextFieldCiudad);
		
		JLabel label_10 = new JLabel("C\u00F3digo postal");
		label_10.setHorizontalAlignment(SwingConstants.LEFT);
		label_10.setBounds(491, 286, 117, 14);
		contentPane.add(label_10);
		
		ModtextFieldCodP = new JTextField();
		ModtextFieldCodP.setColumns(10);
		ModtextFieldCodP.setBounds(618, 283, 141, 19);
		contentPane.add(ModtextFieldCodP);
		
		JLabel label_11 = new JLabel("Provincia");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setBounds(491, 311, 117, 14);
		contentPane.add(label_11);
		
		ModcomboBox_provincia = new JComboBox(new ControladorProvincia().obtenerNombres().toArray());
		ModcomboBox_provincia.setBounds(618, 309, 141, 19);
		contentPane.add(ModcomboBox_provincia);
		
		JLabel label_12 = new JLabel("Pa\u00EDs");
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setBounds(491, 336, 117, 14);
		contentPane.add(label_12);
		
		ModcomboBox_pais = new JComboBox(new ControladorPais().obtenerNombres().toArray());
		ModcomboBox_pais.setBounds(618, 334, 141, 19);
		contentPane.add(ModcomboBox_pais);
		
		JLabel label_14 = new JLabel("Celular");
		label_14.setHorizontalAlignment(SwingConstants.LEFT);
		label_14.setBounds(491, 361, 117, 14);
		contentPane.add(label_14);
		
		ModtextFieldID = new JTextField();
		ModtextFieldID.setColumns(10);
		ModtextFieldID.setBounds(618, 33, 141, 19);
		contentPane.add(ModtextFieldID);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblId_1.setBounds(491, 36, 117, 14);
		contentPane.add(lblId_1);
		
		ModtextFieldCelular = new JTextField();
		ModtextFieldCelular.setColumns(10);
		ModtextFieldCelular.setBounds(618, 359, 141, 17);
		contentPane.add(ModtextFieldCelular);
		
		JLabel label_6 = new JLabel("Personal");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setBounds(491, 386, 117, 14);
		contentPane.add(label_6);
		
		ModtextFieldPersonal = new JTextField();
		ModtextFieldPersonal.setColumns(10);
		ModtextFieldPersonal.setBounds(618, 384, 141, 17);
		contentPane.add(ModtextFieldPersonal);
		
		JLabel label_13 = new JLabel("Laboral");
		label_13.setHorizontalAlignment(SwingConstants.LEFT);
		label_13.setBounds(491, 411, 117, 14);
		contentPane.add(label_13);
		
		ModtextFieldLaboral = new JTextField();
		ModtextFieldLaboral.setColumns(10);
		ModtextFieldLaboral.setBounds(618, 409, 141, 17);
		contentPane.add(ModtextFieldLaboral);
		
		JLabel label_15 = new JLabel("N\u00FAmero");
		label_15.setHorizontalAlignment(SwingConstants.LEFT);
		label_15.setBounds(491, 436, 117, 14);
		contentPane.add(label_15);
		
		ModtextFieldNumero = new JTextField();
		ModtextFieldNumero.setColumns(10);
		ModtextFieldNumero.setBounds(618, 433, 141, 19);
		contentPane.add(ModtextFieldNumero);
		
		JLabel label_16 = new JLabel("Autoridad de emisi\u00F3n");
		label_16.setHorizontalAlignment(SwingConstants.LEFT);
		label_16.setBounds(491, 461, 117, 14);
		contentPane.add(label_16);
		
		ModtextField_emision = new JTextField();
		ModtextField_emision.setColumns(10);
		ModtextField_emision.setBounds(618, 459, 141, 17);
		contentPane.add(ModtextField_emision);
		
		JLabel label_17 = new JLabel("Fecha de vencimiento");
		label_17.setHorizontalAlignment(SwingConstants.LEFT);
		label_17.setBounds(491, 508, 119, 14);
		contentPane.add(label_17);
		
		ModtextField_vencimiento = new JTextField();
		ModtextField_vencimiento.setColumns(10);
		ModtextField_vencimiento.setBounds(618, 506, 141, 17);
		contentPane.add(ModtextField_vencimiento);
		
		JLabel label_18 = new JLabel("Pa\u00EDs de emisi\u00F3n");
		label_18.setHorizontalAlignment(SwingConstants.LEFT);
		label_18.setBounds(491, 533, 117, 14);
		contentPane.add(label_18);
		
		ModcomboBox_paisEmision = new JComboBox(new ControladorPais().obtenerNombres().toArray());
		ModcomboBox_paisEmision.setBounds(618, 531, 141, 19);
		contentPane.add(ModcomboBox_paisEmision);
		
		JLabel label_19 = new JLabel("Categor\u00EDa");
		label_19.setHorizontalAlignment(SwingConstants.LEFT);
		label_19.setBounds(491, 561, 117, 14);
		contentPane.add(label_19);
		
		ModtextFieldCategoria = new JTextField();
		ModtextFieldCategoria.setColumns(10);
		ModtextFieldCategoria.setBounds(618, 559, 141, 17);
		contentPane.add(ModtextFieldCategoria);
		
		JLabel label_20 = new JLabel("Alianza");
		label_20.setHorizontalAlignment(SwingConstants.LEFT);
		label_20.setBounds(491, 585, 117, 14);
		contentPane.add(label_20);
		
		ModcomboBoxAlianza = new JComboBox();
		ModcomboBoxAlianza.setModel(new DefaultComboBoxModel(Alianza.values()));
		ModcomboBoxAlianza.setBounds(618, 585, 141, 17);
		contentPane.add(ModcomboBoxAlianza);
		
		JLabel label_21 = new JLabel("N\u00FAmero");
		label_21.setHorizontalAlignment(SwingConstants.LEFT);
		label_21.setBounds(491, 611, 117, 14);
		contentPane.add(label_21);
		
		ModtextFieldNumeroPF = new JTextField();
		ModtextFieldNumeroPF.setColumns(10);
		ModtextFieldNumeroPF.setBounds(618, 608, 141, 19);
		contentPane.add(ModtextFieldNumeroPF);
		
		btnConsultaMod = new JButton("Consultar");
		btnConsultaMod.setBounds(775, 32, 89, 23);
		contentPane.add(btnConsultaMod);
		btnConsultaMod.addActionListener(new EventoCliente(this));
		
		btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.setBounds(775, 57, 89, 23);
		contentPane.add(btnEliminarCliente);
		btnEliminarCliente.addActionListener(new EventoCliente(this));
		
		btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setBounds(647, 672, 89, 23);
		contentPane.add(btnModificarCliente);
		btnModificarCliente.addActionListener(new EventoCliente(this));
		
		btnAtrasMenuCliente = new JButton("Atras");
		btnAtrasMenuCliente.setBounds(861, 672, 89, 23);
		contentPane.add(btnAtrasMenuCliente);
		btnAtrasMenuCliente.addActionListener(new EventoCliente(this));
		
		JLabel labelFecha_emision = new JLabel("Fecha de emision");
		labelFecha_emision.setBounds(5, 508, 141, 14);
		contentPane.add(labelFecha_emision);
		
		textField_fechaEmision = new JTextField();
		textField_fechaEmision.setBounds(170, 506, 141, 17);
		contentPane.add(textField_fechaEmision);
		textField_fechaEmision.setColumns(10);
		
		JLabel Modlabel_fechaEmision = new JLabel("Fecha de emision");
		Modlabel_fechaEmision.setHorizontalAlignment(SwingConstants.LEFT);
		Modlabel_fechaEmision.setBounds(491, 486, 117, 14);
		contentPane.add(Modlabel_fechaEmision);
		
		ModtextFieldFechaEmision = new JTextField();
		ModtextFieldFechaEmision.setBounds(618, 484, 141, 17);
		contentPane.add(ModtextFieldFechaEmision);
		ModtextFieldFechaEmision.setColumns(10);
		
		JLabel labelModID_aerolinea = new JLabel("ID aerol\u00EDnea");
		labelModID_aerolinea.setHorizontalAlignment(SwingConstants.LEFT);
		labelModID_aerolinea.setBounds(491, 636, 117, 14);
		contentPane.add(labelModID_aerolinea);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(771, 211, 64, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(771, 386, 64, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPasaporte.setBounds(771, 436, 64, 14);
		contentPane.add(lblPasaporte);
		
		JLabel lblPasajFrecuente = new JLabel("Pasajero Frecuente");
		lblPasajFrecuente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPasajFrecuente.setBounds(769, 561, 125, 14);
		contentPane.add(lblPasajFrecuente);
		
		lbl_idDireccion = new JLabel("");
		lbl_idDireccion.setBounds(828, 211, 46, 14);
		contentPane.add(lbl_idDireccion);
		
		lbl_idTelefono = new JLabel("");
		lbl_idTelefono.setBounds(828, 386, 46, 14);
		contentPane.add(lbl_idTelefono);
		
		lbl_idPasaporte = new JLabel("");
		lbl_idPasaporte.setBounds(828, 436, 46, 14);
		contentPane.add(lbl_idPasaporte);
		
		lbl_idPF = new JLabel("");
		lbl_idPF.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_idPF.setBounds(883, 561, 46, 14);
		contentPane.add(lbl_idPF);
		
		comboBoxAerolinea = new JComboBox(new ControladorLineaAerea().obtenerNombres().toArray());
		comboBoxAerolinea.setBounds(170, 678, 141, 17);
		contentPane.add(comboBoxAerolinea);
		
		ModcomboBoxAerolinea = new JComboBox(new ControladorLineaAerea().obtenerNombres().toArray());
		ModcomboBoxAerolinea.setBounds(618, 635, 141, 17);
		contentPane.add(ModcomboBoxAerolinea);
		
		JLabel lblOtraProv = new JLabel("Otro");
		lblOtraProv.setBounds(321, 311, 46, 14);
		contentPane.add(lblOtraProv);
		
		textFieldProvincia = new JTextField();
		textFieldProvincia.setBounds(377, 308, 86, 17);
		contentPane.add(textFieldProvincia);
		textFieldProvincia.setColumns(10);
		
		JLabel labelOtroPais = new JLabel("Otro");
		labelOtroPais.setBounds(321, 336, 46, 14);
		contentPane.add(labelOtroPais);
		
		textFieldOtroPais = new JTextField();
		textFieldOtroPais.setBounds(377, 333, 86, 17);
		contentPane.add(textFieldOtroPais);
		textFieldOtroPais.setColumns(10);
		
		JLabel lblOtraProvincia = new JLabel("Otro");
		lblOtraProvincia.setBounds(769, 311, 46, 14);
		contentPane.add(lblOtraProvincia);
		
		modtextFieldOtraProv = new JTextField();
		modtextFieldOtraProv.setBounds(828, 308, 86, 17);
		contentPane.add(modtextFieldOtraProv);
		modtextFieldOtraProv.setColumns(10);
		
		modtextFieldOtroPais = new JTextField();
		modtextFieldOtroPais.setText("");
		modtextFieldOtroPais.setBounds(828, 333, 86, 17);
		contentPane.add(modtextFieldOtroPais);
		modtextFieldOtroPais.setColumns(10);
		
		JLabel modlblOtroPais = new JLabel("Otro");
		modlblOtroPais.setBounds(769, 336, 46, 14);
		contentPane.add(modlblOtroPais);
		
		JLabel lblNewLabel = new JLabel("yyyy/MM/dd");
		lblNewLabel.setBounds(321, 136, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("yyyy/MM/dd");
		lblNewLabel_1.setBounds(321, 508, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("yyyy/MM/dd");
		lblNewLabel_2.setBounds(321, 533, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("yyyy/MM/dd");
		lblNewLabel_3.setBounds(769, 161, 66, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("yyyy/MM/dd");
		lblNewLabel_4.setBounds(769, 486, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("yyyy/MM/dd");
		lblNewLabel_5.setBounds(769, 508, 66, 14);
		contentPane.add(lblNewLabel_5);
		btnAltaCliente.addActionListener(new EventoCliente(this));
		
		
		
		
	}
}
