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

public class VistaAgregarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

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
		
		JLabel label = new JLabel("");
		label.setBounds(5, 6, 141, 62);
		contentPane.add(label);
		
		JLabel labelArgegarCliente = new JLabel("Agregar cliente");
		labelArgegarCliente.setBounds(146, 6, 141, 62);
		labelArgegarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		labelArgegarCliente.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(labelArgegarCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(409, 6, 19, 248);
		contentPane.add(scrollPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setViewportView(scrollBar);
		
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
	}
}
