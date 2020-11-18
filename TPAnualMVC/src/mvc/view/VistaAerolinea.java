package mvc.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mvc.eventos.EventoCliente;

public class VistaAerolinea extends JFrame {

	private JFrame frame;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldNombre;
	public JTextField textFieldAlianza;
	
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
	private JTextField ModtextFieldNombre;
	private JTextField ModtextFieldAlianza;
	private JTextField ModtextFieldID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAerolinea window = new VistaAerolinea();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaAerolinea() {
		setTitle("Aerolinea");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelArgegarAerolinea = new JLabel("Agregar Aerolinea");
		labelArgegarAerolinea.setBounds(87, 0, 173, 32);
		labelArgegarAerolinea.setHorizontalAlignment(SwingConstants.CENTER);
		labelArgegarAerolinea.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(labelArgegarAerolinea);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(10, 36, 51, 14);
		contentPane.add(labelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(97, 33, 141, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelApellido = new JLabel("Alianza");
		labelApellido.setBounds(10, 61, 51, 14);
		contentPane.add(labelApellido);
		
		textFieldAlianza = new JTextField();
		textFieldAlianza.setBounds(97, 58, 141, 19);
		contentPane.add(textFieldAlianza);
		textFieldAlianza.setColumns(10);
		
		ModtextFieldNombre = new JTextField();
		ModtextFieldNombre.setColumns(10);
		ModtextFieldNombre.setBounds(373, 58, 141, 19);
		contentPane.add(ModtextFieldNombre);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(284, 61, 51, 14);
		contentPane.add(label);
		
		JLabel lblAlianza = new JLabel("Alianza");
		lblAlianza.setBounds(284, 86, 51, 14);
		contentPane.add(lblAlianza);
		
		ModtextFieldAlianza = new JTextField();
		ModtextFieldAlianza.setColumns(10);
		ModtextFieldAlianza.setBounds(373, 83, 141, 19);
		contentPane.add(ModtextFieldAlianza);
		
		ModtextFieldID = new JTextField();
		ModtextFieldID.setColumns(10);
		ModtextFieldID.setBounds(373, 33, 141, 19);
		contentPane.add(ModtextFieldID);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setBounds(284, 36, 51, 14);
		contentPane.add(lblId_1);
		
		JButton btnConsultaAerolinea = new JButton("Consultar");
		btnConsultaAerolinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultaAerolinea.setBounds(524, 32, 89, 23);
		contentPane.add(btnConsultaAerolinea);
		
		JButton btnEliminarAerolinea = new JButton("Eliminar");
		btnEliminarAerolinea.setBounds(524, 57, 89, 23);
		contentPane.add(btnEliminarAerolinea);
		
		JLabel lblModificarAerolinea = new JLabel("Modificar Aerolinea");
		lblModificarAerolinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarAerolinea.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblModificarAerolinea.setBounds(352, 0, 173, 32);
		contentPane.add(lblModificarAerolinea);
		
		JButton btnAltaAerolinea = new JButton("Agregar");
		btnAltaAerolinea.setBounds(124, 88, 89, 23);
		contentPane.add(btnAltaAerolinea);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(398, 113, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(530, 137, 89, 23);
		contentPane.add(btnAtras);
		
		
		
		
	}
}
