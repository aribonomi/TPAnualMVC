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
	
	public JTextField textFieldCiudadMod;
	public JTextField textFieldCodPMod;
	public JTextField textFieldCelularMod;
	public JTextField textFieldPersonalMod;
	public JTextField textFieldLaboralMod;
	public JTextField textFieldNumPasMod;
	public JTextField textFieldAut_emisionMod;
	public JTextField textField_vencimientoMod;
	public JTextField textField_CatPFMod;
	public JTextField textField_idAerolineaMod;
	public JTextField textFieldNombreMod;
	public JTextField textFieldApellidoMod;
	public JTextField textFieldDniMod;
	public JTextField textFieldCuitMod;
	public JTextField textFieldNacimientoMod;
	public JTextField textFieldEmailMod;
	public JTextField textFieldCalleMod;
	public JTextField textFieldAlturaMod;
	
	private JComboBox comboBox_provincia;

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
		setBounds(100, 100, 621, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelArgegarCliente = new JLabel("Agregar cliente");
		labelArgegarCliente.setBounds(146, 0, 141, 32);
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
		
		comboBox_provincia = new JComboBox();
		comboBox_provincia.setBounds(146, 309, 141, 19);
		contentPane.add(comboBox_provincia);
		
		JLabel labelPais = new JLabel("Pa\u00EDs");
		labelPais.setBounds(5, 336, 46, 14);
		contentPane.add(labelPais);
		
		JComboBox comboBox_pais = new JComboBox();
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
		
		JLabel labelPasaporte = new JLabel("Pasaporte");
		labelPasaporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelPasaporte.setBounds(5, 461, 69, 14);
		contentPane.add(labelPasaporte);
		
		JLabel labelNumPasaporte = new JLabel("N\u00FAmero");
		labelNumPasaporte.setBounds(5, 486, 46, 14);
		contentPane.add(labelNumPasaporte);
		
		textFieldNumPas = new JTextField();
		textFieldNumPas.setBounds(146, 483, 141, 19);
		contentPane.add(textFieldNumPas);
		textFieldNumPas.setColumns(10);
		
		JLabel labelAutDeEmision = new JLabel("Autoridad de emisi\u00F3n");
		labelAutDeEmision.setBounds(5, 511, 105, 14);
		contentPane.add(labelAutDeEmision);
		
		textFieldAut_emision = new JTextField();
		textFieldAut_emision.setBounds(146, 509, 141, 17);
		contentPane.add(textFieldAut_emision);
		textFieldAut_emision.setColumns(10);
		
		JLabel labelFecha_vencimiento = new JLabel("Fecha de vencimiento");
		labelFecha_vencimiento.setBounds(5, 536, 105, 14);
		contentPane.add(labelFecha_vencimiento);
		
		textField_vencimiento = new JTextField();
		textField_vencimiento.setBounds(146, 534, 141, 17);
		contentPane.add(textField_vencimiento);
		textField_vencimiento.setColumns(10);
		
		JLabel labelPais_emision = new JLabel("Pa\u00EDs de emisi\u00F3n");
		labelPais_emision.setBounds(5, 561, 105, 14);
		contentPane.add(labelPais_emision);
		
		JLabel labelPasajeroFrecuente = new JLabel("Pasajero frecuente");
		labelPasajeroFrecuente.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelPasajeroFrecuente.setBounds(5, 586, 125, 14);
		contentPane.add(labelPasajeroFrecuente);
		
		JComboBox comboBox_paisEmision = new JComboBox();
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
		
		JComboBox comboBoxAlianza = new JComboBox();
		comboBoxAlianza.setModel(new DefaultComboBoxModel(new String[] {"SKYTEAM", "ONEWORLD", "STARALLIANCE"}));
		comboBoxAlianza.setBounds(146, 633, 141, 17);
		contentPane.add(comboBoxAlianza);
		
		JLabel lblId = new JLabel("ID ");
		lblId.setBounds(5, 683, 46, 14);
		contentPane.add(lblId);
		
		JLabel labelAerolinea = new JLabel("Aerolinea");
		labelAerolinea.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelAerolinea.setBounds(5, 661, 74, 14);
		contentPane.add(labelAerolinea);
		
		textField_idAerolinea = new JTextField();
		textField_idAerolinea.setBounds(146, 681, 141, 17);
		contentPane.add(textField_idAerolinea);
		textField_idAerolinea.setColumns(10);
		
		JButton btnAltaCliente = new JButton("Ingresar");
		btnAltaCliente.setBounds(301, 679, 89, 23);
		contentPane.add(btnAltaCliente);
		
		
	}
}
