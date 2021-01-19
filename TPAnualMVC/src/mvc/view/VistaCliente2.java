package mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import dao.negocio.Alianza;
import mvc.controller.ControladorLineaAerea;
import mvc.controller.ControladorPais;
import mvc.controller.ControladorProvincia;
import mvc.eventos.EventoCliente;

public class VistaCliente2 extends JFrame {

	private JPanel contentPane;
	public JTextField tf_id;
	public JTextField tf_nombre;
	public JTextField tf_apellido;
	public JTextField tf_cuit;
	public JTextField tf_email;
	public JTextField tf_calle;
	public JTextField tf_altura;
	public JTextField tf_ciudad;
	public JTextField tf_codigo_postal;
	public JTextField tf_celular;
	public JTextField tf_personal;
	public JTextField tf_laboral;
	public JTextField tf_numeroPasaporte;
	public JTextField tf_autoridadEmision;
	public JTextField tf_categoria;
	public JTextField tf_numeroPF;
	public JLabel lbl_id_direccion;
	public JComboBox comboProvincia;
	public JComboBox comboPais;
	public JLabel lbl_id_telefono;
	public JLabel lbl_id_pasaporte;
	public JFormattedTextField tf_fechaEmision;
	public JFormattedTextField tf_fechaVencimiento;
	public JComboBox comboPaisEmision;
	public JLabel lbl_id_pasajeroFrecuente;
	public JComboBox comboAerolinea;
	public JComboBox comboAlianza;
	public JButton btnConsultar;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JButton btnAgregar;
	public JButton btnAtras;
	public JScrollPane scrollPane;
	private JLabel lblNewLabel_29;
	public JTextField tf_dni;
	public JFormattedTextField tf_fecha_nacimiento;
	public JTextField tf_otroPais;
	private JLabel lblNewLabel_30;
	private JLabel lblNewLabel_31;
	public JTextField tf_otraProvincia;

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
		setBounds(100, 100, 477, 345);
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
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		JLabel lblNewLabel_28 = new JLabel("Clientes");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_28, "2, 2, 9, 1, center, default");
		
		JLabel lblNewLabel = new JLabel("ID");
		contentPane.add(lblNewLabel, "2, 4, left, default");
		
		tf_id = new JTextField();
		contentPane.add(tf_id, "4, 4, fill, default");
		tf_id.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		contentPane.add(btnConsultar, "10, 4");
		btnConsultar.addActionListener(new EventoCliente(this));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		contentPane.add(lblNewLabel_1, "2, 6, left, default");
		
		tf_nombre = new JTextField();
		contentPane.add(tf_nombre, "4, 6, fill, default");
		tf_nombre.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		contentPane.add(btnModificar, "10, 6");
		btnModificar.addActionListener(new EventoCliente(this));
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		contentPane.add(lblNewLabel_2, "2, 8, left, default");
		
		tf_apellido = new JTextField();
		contentPane.add(tf_apellido, "4, 8, fill, default");
		tf_apellido.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		contentPane.add(btnEliminar, "10, 8");
		btnEliminar.addActionListener(new EventoCliente(this));
		
		lblNewLabel_29 = new JLabel("DNI");
		contentPane.add(lblNewLabel_29, "2, 10, left, default");
		
		tf_dni = new JTextField();
		contentPane.add(tf_dni, "4, 10, fill, default");
		tf_dni.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		contentPane.add(btnAgregar, "10, 10");
		btnAgregar.addActionListener(new EventoCliente(this));
		
		JLabel lblNewLabel_3 = new JLabel("CUIT/CUIL");
		contentPane.add(lblNewLabel_3, "2, 12, left, default");
		
		tf_cuit = new JTextField();
		contentPane.add(tf_cuit, "4, 12, fill, default");
		tf_cuit.setColumns(10);
		
		btnAtras = new JButton("Atr\u00E1s");
		contentPane.add(btnAtras, "10, 12");
		btnAtras.addActionListener(new EventoCliente(this));
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de nacimiento");
		contentPane.add(lblNewLabel_4, "2, 14, left, default");
		
		tf_fecha_nacimiento = new JFormattedTextField(df);
		contentPane.add(tf_fecha_nacimiento, "4, 14, fill, default");
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		contentPane.add(lblNewLabel_5, "2, 16, left, default");
		
		tf_email = new JTextField();
		contentPane.add(tf_email, "4, 16, fill, default");
		tf_email.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Direcci\u00F3n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_6, "2, 18, center, default");
		
		lbl_id_direccion = new JLabel("");
		contentPane.add(lbl_id_direccion, "4, 18");
		
		JLabel lblNewLabel_7 = new JLabel("Calle");
		contentPane.add(lblNewLabel_7, "2, 20, left, default");
		
		tf_calle = new JTextField();
		contentPane.add(tf_calle, "4, 20, fill, default");
		tf_calle.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Altura");
		contentPane.add(lblNewLabel_8, "2, 22, left, default");
		
		tf_altura = new JTextField();
		contentPane.add(tf_altura, "4, 22, fill, default");
		tf_altura.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Ciudad");
		contentPane.add(lblNewLabel_9, "2, 24, left, default");
		
		tf_ciudad = new JTextField();
		contentPane.add(tf_ciudad, "4, 24, fill, default");
		tf_ciudad.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("C\u00F3digo postal");
		contentPane.add(lblNewLabel_10, "2, 26, left, default");
		
		tf_codigo_postal = new JTextField();
		contentPane.add(tf_codigo_postal, "4, 26, fill, default");
		tf_codigo_postal.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Provincia");
		contentPane.add(lblNewLabel_11, "2, 28, left, default");
		
		comboProvincia = new JComboBox(new ControladorProvincia().obtenerNombres().toArray());
		contentPane.add(comboProvincia, "4, 28, fill, default");
		
		lblNewLabel_30 = new JLabel("Otro");
		contentPane.add(lblNewLabel_30, "6, 28, right, default");
		
		tf_otroPais = new JTextField();
		contentPane.add(tf_otroPais, "8, 28, fill, default");
		tf_otroPais.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Pa\u00EDs");
		contentPane.add(lblNewLabel_12, "2, 30, left, default");
		
		comboPais = new JComboBox(new ControladorPais().obtenerNombres().toArray());
		contentPane.add(comboPais, "4, 30, fill, default");
		
		lblNewLabel_31 = new JLabel("Otro");
		contentPane.add(lblNewLabel_31, "6, 30, right, default");
		
		tf_otraProvincia = new JTextField();
		contentPane.add(tf_otraProvincia, "8, 30, fill, default");
		tf_otraProvincia.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Tel\u00E9fono");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_13, "2, 32, center, default");
		
		lbl_id_telefono = new JLabel("");
		contentPane.add(lbl_id_telefono, "4, 32");
		
		JLabel lblNewLabel_14 = new JLabel("Celular");
		contentPane.add(lblNewLabel_14, "2, 34, left, default");
		
		tf_celular = new JTextField();
		contentPane.add(tf_celular, "4, 34, fill, default");
		tf_celular.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Personal");
		contentPane.add(lblNewLabel_16, "2, 36, left, default");
		
		tf_personal = new JTextField();
		contentPane.add(tf_personal, "4, 36, fill, default");
		tf_personal.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Laboral");
		contentPane.add(lblNewLabel_15, "2, 38, left, default");
		
		tf_laboral = new JTextField();
		contentPane.add(tf_laboral, "4, 38, fill, default");
		tf_laboral.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Pasaporte");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_17, "2, 40, center, default");
		
		lbl_id_pasaporte = new JLabel("");
		contentPane.add(lbl_id_pasaporte, "4, 40");
		
		JLabel lblNewLabel_18 = new JLabel("N\u00FAmero");
		contentPane.add(lblNewLabel_18, "2, 42, left, default");
		
		tf_numeroPasaporte = new JTextField();
		contentPane.add(tf_numeroPasaporte, "4, 42, fill, default");
		tf_numeroPasaporte.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Autoridad de emisi\u00F3n");
		contentPane.add(lblNewLabel_19, "2, 44, left, default");
		
		tf_autoridadEmision = new JTextField();
		contentPane.add(tf_autoridadEmision, "4, 44, fill, default");
		tf_autoridadEmision.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("Fecha de emisi\u00F3n");
		contentPane.add(lblNewLabel_20, "2, 46, left, default");
		
		tf_fechaEmision = new JFormattedTextField(df);
		contentPane.add(tf_fechaEmision, "4, 46, fill, default");
		
		JLabel lblNewLabel_21 = new JLabel("Fecha de vencimiento");
		contentPane.add(lblNewLabel_21, "2, 48, right, default");
		
		tf_fechaVencimiento = new JFormattedTextField(df);
		contentPane.add(tf_fechaVencimiento, "4, 48, fill, default");
		
		JLabel lblNewLabel_22 = new JLabel("Pa\u00EDs de emisi\u00F3n");
		contentPane.add(lblNewLabel_22, "2, 50, left, default");
		
		comboPaisEmision = new JComboBox(new ControladorPais().obtenerNombres().toArray());
		contentPane.add(comboPaisEmision, "4, 50, fill, default");
		
		JLabel lblNewLabel_23 = new JLabel("Pasajero frecuente");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_23, "2, 52, center, default");
		
		lbl_id_pasajeroFrecuente = new JLabel("");
		contentPane.add(lbl_id_pasajeroFrecuente, "4, 52");
		
		JLabel lblNewLabel_24 = new JLabel("Categor\u00EDa");
		contentPane.add(lblNewLabel_24, "2, 54, left, default");
		
		tf_categoria = new JTextField();
		contentPane.add(tf_categoria, "4, 54, fill, default");
		tf_categoria.setColumns(10);
		
		JLabel lblNewLabel_25 = new JLabel("Alianza");
		contentPane.add(lblNewLabel_25, "2, 56, left, default");
		
		comboAlianza = new JComboBox();
		comboAlianza.setModel(new DefaultComboBoxModel(Alianza.values()));
		contentPane.add(comboAlianza, "4, 56, fill, default");
		
		JLabel lblNewLabel_26 = new JLabel("N\u00FAmero");
		contentPane.add(lblNewLabel_26, "2, 58, left, default");
		
		tf_numeroPF = new JTextField();
		contentPane.add(tf_numeroPF, "4, 58, fill, default");
		tf_numeroPF.setColumns(10);
		
		JLabel lblNewLabel_27 = new JLabel("Aerol\u00EDnea");
		contentPane.add(lblNewLabel_27, "2, 60, left, default");
		
		comboAerolinea = new JComboBox(new ControladorLineaAerea().obtenerNombres().toArray());
		contentPane.add(comboAerolinea, "4, 60, fill, default");
	}

}
