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

public class VistaAgregarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAgregarCliente frame = new VistaAgregarCliente();
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
	public VistaAgregarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelArgegarCliente = new JLabel("Agregar cliente");
		labelArgegarCliente.setBounds(146, 6, 141, 62);
		labelArgegarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		labelArgegarCliente.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(labelArgegarCliente);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(5, 68, 51, 19);
		contentPane.add(labelNombre);
		
		JTextField textFieldNombre = new JTextField();
		textFieldNombre.setBounds(146, 68, 141, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelApellido = new JLabel("Apellido");
		labelApellido.setBounds(5, 99, 51, 19);
		contentPane.add(labelApellido);
		
		JTextField textFieldApellido = new JTextField();
		textFieldApellido.setBounds(146, 98, 141, 19);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel labelDni = new JLabel("DNI");
		labelDni.setBounds(5, 129, 51, 19);
		contentPane.add(labelDni);
		
		JTextField textFieldDni = new JTextField();
		textFieldDni.setBounds(146, 128, 141, 19);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel labelCuit = new JLabel("CUIT/CUIL");
		labelCuit.setBounds(5, 159, 64, 14);
		contentPane.add(labelCuit);
		
		JTextField textFieldCuit = new JTextField();
		textFieldCuit.setBounds(146, 158, 141, 19);
		contentPane.add(textFieldCuit);
		textFieldCuit.setColumns(10);
		
		JLabel labelNacimiento = new JLabel("Fecha de nacimiento");
		labelNacimiento.setBounds(5, 190, 105, 14);
		contentPane.add(labelNacimiento);
		
		JTextField textFieldNacimiento = new JTextField();
		textFieldNacimiento.setBounds(146, 188, 141, 19);
		contentPane.add(textFieldNacimiento);
		textFieldNacimiento.setColumns(10);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(5, 217, 46, 14);
		contentPane.add(labelEmail);
		
		JTextField textFieldEmail = new JTextField();
		textFieldEmail.setBounds(146, 218, 141, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel labelDireccion = new JLabel("Direcci\u00F3n");
		labelDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelDireccion.setBounds(5, 247, 64, 14);
		contentPane.add(labelDireccion);
		
		JLabel labelCalle = new JLabel("Calle");
		labelCalle.setBounds(5, 276, 46, 14);
		contentPane.add(labelCalle);
		
		JTextField textFieldCalle = new JTextField();
		textFieldCalle.setBounds(146, 273, 141, 19);
		contentPane.add(textFieldCalle);
		textFieldCalle.setColumns(10);
		
		JLabel labelAltura = new JLabel("Altura");
		labelAltura.setBounds(5, 301, 46, 14);
		contentPane.add(labelAltura);
		
		JTextField textFieldAltura = new JTextField();
		textFieldAltura.setBounds(146, 298, 141, 19);
		contentPane.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel labelCiudad = new JLabel("Ciudad");
		labelCiudad.setBounds(5, 326, 46, 14);
		contentPane.add(labelCiudad);
		
		textField = new JTextField();
		textField.setBounds(146, 323, 141, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(5, 451, 378, -84);
		contentPane.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 6, 17, 48);
		contentPane.add(scrollBar);
		
		JLabel labelCodPostal = new JLabel("C\u00F3digo postal");
		labelCodPostal.setBounds(5, 353, 86, 14);
		contentPane.add(labelCodPostal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 348, 141, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel labelProvincia = new JLabel("Provincia");
		labelProvincia.setBounds(5, 378, 46, 14);
		contentPane.add(labelProvincia);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(146, 373, 141, 19);
		contentPane.add(comboBox);
		
		JLabel labelPais = new JLabel("Pa\u00EDs");
		labelPais.setBounds(5, 400, 46, 14);
		contentPane.add(labelPais);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(146, 398, 141, 19);
		contentPane.add(comboBox_1);
		
		JLabel labelTelefono = new JLabel("Tel\u00E9fono");
		labelTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelTelefono.setBounds(5, 425, 74, 14);
		contentPane.add(labelTelefono);
		
		JLabel labelCelular = new JLabel("Celular");
		labelCelular.setBounds(5, 451, 46, 14);
		contentPane.add(labelCelular);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 448, 141, 17);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
