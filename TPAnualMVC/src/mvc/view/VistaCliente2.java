package mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JButton;

public class VistaCliente2 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_id;
	private JTextField tf_nombre;
	private JTextField tf_apellido;
	private JTextField tf_cuit;
	private JTextField tf_email;
	private JTextField tf_calle;
	private JTextField tf_altura;
	private JTextField tf_ciudad;
	private JTextField tf_codigo_postal;
	private JTextField tf_celular;
	private JTextField tf_personal;
	private JTextField tf_laboral;
	private JTextField tf_numeroPasaporte;
	private JTextField tf_autoridadEmision;
	private JTextField tf_categoria;
	private JTextField tf_numeroPF;
	private JLabel lbl_id_direccion;
	private JComboBox comboProvincia;
	private JComboBox comboPais;
	private JLabel lbl_id_telefono;
	private JLabel lbl_id_pasaporte;
	private JFormattedTextField tf_fechaEmision;
	private JFormattedTextField tf_fechaVencimiento;
	private JComboBox comboPaisEmision;
	private JLabel lbl_id_pasajeroFrecuente;
	private JComboBox comboAerolinea;
	private JComboBox comboAlianza;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JButton btnAtras;
	public JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCliente2 frame = new VistaCliente2();
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
	public VistaCliente2() {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 10, 500, 400);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		scrollPane.setPreferredSize(new Dimension(450, 800));
		scrollPane.setViewportView(contentPane);
		
		setContentPane(scrollPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_28 = new JLabel("Clientes");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_28, "2, 2, 5, 1, center, default");
		
		JLabel lblNewLabel = new JLabel("ID");
		contentPane.add(lblNewLabel, "2, 4, left, default");
		
		tf_id = new JTextField();
		contentPane.add(tf_id, "4, 4, fill, default");
		tf_id.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		contentPane.add(btnConsultar, "6, 4");
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		contentPane.add(lblNewLabel_1, "2, 6, left, default");
		
		tf_nombre = new JTextField();
		contentPane.add(tf_nombre, "4, 6, fill, default");
		tf_nombre.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		contentPane.add(btnModificar, "6, 6");
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		contentPane.add(lblNewLabel_2, "2, 8, left, default");
		
		tf_apellido = new JTextField();
		contentPane.add(tf_apellido, "4, 8, fill, default");
		tf_apellido.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		contentPane.add(btnEliminar, "6, 8");
		
		JLabel lblNewLabel_3 = new JLabel("CUIT/CUIL");
		contentPane.add(lblNewLabel_3, "2, 10, left, default");
		
		tf_cuit = new JTextField();
		contentPane.add(tf_cuit, "4, 10, fill, default");
		tf_cuit.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		contentPane.add(btnAgregar, "6, 10");
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de nacimiento");
		contentPane.add(lblNewLabel_4, "2, 12, left, default");
		
		JFormattedTextField tf_fecha_nacimiento = new JFormattedTextField();
		contentPane.add(tf_fecha_nacimiento, "4, 12, fill, default");
		
		btnAtras = new JButton("Atr\u00E1s");
		contentPane.add(btnAtras, "6, 12");
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		contentPane.add(lblNewLabel_5, "2, 14, left, default");
		
		tf_email = new JTextField();
		contentPane.add(tf_email, "4, 14, fill, default");
		tf_email.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Direcci\u00F3n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_6, "2, 16, center, default");
		
		lbl_id_direccion = new JLabel("");
		contentPane.add(lbl_id_direccion, "4, 16");
		
		JLabel lblNewLabel_7 = new JLabel("Calle");
		contentPane.add(lblNewLabel_7, "2, 18, left, default");
		
		tf_calle = new JTextField();
		contentPane.add(tf_calle, "4, 18, fill, default");
		tf_calle.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Altura");
		contentPane.add(lblNewLabel_8, "2, 20, left, default");
		
		tf_altura = new JTextField();
		contentPane.add(tf_altura, "4, 20, fill, default");
		tf_altura.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Ciudad");
		contentPane.add(lblNewLabel_9, "2, 22, left, default");
		
		tf_ciudad = new JTextField();
		contentPane.add(tf_ciudad, "4, 22, fill, default");
		tf_ciudad.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("C\u00F3digo postal");
		contentPane.add(lblNewLabel_10, "2, 24, left, default");
		
		tf_codigo_postal = new JTextField();
		contentPane.add(tf_codigo_postal, "4, 24, fill, default");
		tf_codigo_postal.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Provincia");
		contentPane.add(lblNewLabel_11, "2, 26, left, default");
		
		comboProvincia = new JComboBox();
		contentPane.add(comboProvincia, "4, 26, fill, default");
		
		JLabel lblNewLabel_12 = new JLabel("Pa\u00EDs");
		contentPane.add(lblNewLabel_12, "2, 28, left, default");
		
		comboPais = new JComboBox();
		contentPane.add(comboPais, "4, 28, fill, default");
		
		JLabel lblNewLabel_13 = new JLabel("Tel\u00E9fono");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_13, "2, 30, center, default");
		
		lbl_id_telefono = new JLabel("");
		contentPane.add(lbl_id_telefono, "4, 30");
		
		JLabel lblNewLabel_14 = new JLabel("Celular");
		contentPane.add(lblNewLabel_14, "2, 32, left, default");
		
		tf_celular = new JTextField();
		contentPane.add(tf_celular, "4, 32, fill, default");
		tf_celular.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Personal");
		contentPane.add(lblNewLabel_16, "2, 34, left, default");
		
		tf_personal = new JTextField();
		contentPane.add(tf_personal, "4, 34, fill, default");
		tf_personal.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Laboral");
		contentPane.add(lblNewLabel_15, "2, 36, left, default");
		
		tf_laboral = new JTextField();
		contentPane.add(tf_laboral, "4, 36, fill, default");
		tf_laboral.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Pasaporte");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_17, "2, 38, center, default");
		
		lbl_id_pasaporte = new JLabel("");
		contentPane.add(lbl_id_pasaporte, "4, 38");
		
		JLabel lblNewLabel_18 = new JLabel("N\u00FAmero");
		contentPane.add(lblNewLabel_18, "2, 40, left, default");
		
		tf_numeroPasaporte = new JTextField();
		contentPane.add(tf_numeroPasaporte, "4, 40, fill, default");
		tf_numeroPasaporte.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Autoridad de emisi\u00F3n");
		contentPane.add(lblNewLabel_19, "2, 42, left, default");
		
		tf_autoridadEmision = new JTextField();
		contentPane.add(tf_autoridadEmision, "4, 42, fill, default");
		tf_autoridadEmision.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("Fecha de emisi\u00F3n");
		contentPane.add(lblNewLabel_20, "2, 44, left, default");
		
		tf_fechaEmision = new JFormattedTextField();
		contentPane.add(tf_fechaEmision, "4, 44, fill, default");
		
		JLabel lblNewLabel_21 = new JLabel("Fecha de vencimiento");
		contentPane.add(lblNewLabel_21, "2, 46, right, default");
		
		tf_fechaVencimiento = new JFormattedTextField();
		contentPane.add(tf_fechaVencimiento, "4, 46, fill, default");
		
		JLabel lblNewLabel_22 = new JLabel("Pa\u00EDs de emisi\u00F3n");
		contentPane.add(lblNewLabel_22, "2, 48, left, default");
		
		comboPaisEmision = new JComboBox();
		contentPane.add(comboPaisEmision, "4, 48, fill, default");
		
		JLabel lblNewLabel_23 = new JLabel("Pasajero frecuente");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_23, "2, 50, center, default");
		
		lbl_id_pasajeroFrecuente = new JLabel("");
		contentPane.add(lbl_id_pasajeroFrecuente, "4, 50");
		
		JLabel lblNewLabel_24 = new JLabel("Categor\u00EDa");
		contentPane.add(lblNewLabel_24, "2, 52, left, default");
		
		tf_categoria = new JTextField();
		contentPane.add(tf_categoria, "4, 52, fill, default");
		tf_categoria.setColumns(10);
		
		JLabel lblNewLabel_25 = new JLabel("Alianza");
		contentPane.add(lblNewLabel_25, "2, 54, left, default");
		
		comboAlianza = new JComboBox();
		contentPane.add(comboAlianza, "4, 54, fill, default");
		
		JLabel lblNewLabel_26 = new JLabel("N\u00FAmero");
		contentPane.add(lblNewLabel_26, "2, 56, left, default");
		
		tf_numeroPF = new JTextField();
		contentPane.add(tf_numeroPF, "4, 56, fill, default");
		tf_numeroPF.setColumns(10);
		
		JLabel lblNewLabel_27 = new JLabel("Aerol\u00EDnea");
		contentPane.add(lblNewLabel_27, "2, 58, left, default");
		
		comboAerolinea = new JComboBox();
		contentPane.add(comboAerolinea, "4, 58, fill, default");
	}

}
