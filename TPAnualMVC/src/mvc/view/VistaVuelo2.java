package mvc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import mvc.controller.ControladorAeropuerto;
import mvc.controller.ControladorLineaAerea;
import mvc.eventos.EventoVuelo;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.TextArea;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.Label;
import javax.swing.DefaultComboBoxModel;
import dao.negocio.Alianza;
import java.awt.Button;
import java.awt.Dimension;

public class VistaVuelo2 extends JFrame {

	private JPanel contentPane;
	public JTextField tf_Id;
	public JComboBox comboAeropuerto_Salida;
	public JComboBox comboAeropuerto_llegada;
	public JFormattedTextField tf_fecha_llegada;
	public JButton btnConsultar;
	public JButton btnAgregar;
	public JButton btnModificar;
	public JFormattedTextField tf_fechaSalida;
	public JComboBox combo_aerolinea;
	public JLabel lblNroVuelo;
	public TextArea textArea_resultado;
	public JButton btnEliminar;
	public JButton btnAtras;
	public JTextField tf_tiempo_vuelo;
	public JTextField tf_cantidadAsientos;
	private JLabel lblNewLabel_9;
	public JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVuelo2 frame = new VistaVuelo2();
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
	public VistaVuelo2() {
	
		setTitle("Gesti\u00F3n de vuelos");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 10, 650, 400);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		scrollPane.setPreferredSize(new Dimension(715, 357));
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
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
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
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Vuelos");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewJgoodiesTitle, "4, 2, 5, 1, center, default");
		
		JLabel lblNewLabel_8 = new JLabel("ID");
		contentPane.add(lblNewLabel_8, "2, 6, left, default");
		
		tf_Id = new JTextField();
		contentPane.add(tf_Id, "4, 6, fill, default");
		tf_Id.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		contentPane.add(btnConsultar, "6, 6");
		btnConsultar.addActionListener(new EventoVuelo(this));
		
		btnAtras = new JButton("Atr\u00E1s");
		contentPane.add(btnAtras, "8, 6");
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de vuelo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_1, "2, 8, left, default");
		
		lblNroVuelo = new JLabel("");
		contentPane.add(lblNroVuelo, "4, 8, center, default");
		
		btnModificar = new JButton("Modificar");
		contentPane.add(btnModificar, "6, 8");
		btnModificar.addActionListener(new EventoVuelo(this));
		
		JLabel lblNewLabel = new JLabel("Cantidad de asientos");
		contentPane.add(lblNewLabel, "2, 10, left, default");
		
		tf_cantidadAsientos = new JTextField();
		contentPane.add(tf_cantidadAsientos, "4, 10, fill, default");
		tf_cantidadAsientos.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		contentPane.add(btnAgregar, "6, 10");
		btnAgregar.addActionListener(new EventoVuelo(this));
		
		JLabel lblNewLabel_2 = new JLabel("Aeropuerto de llegada");
		contentPane.add(lblNewLabel_2, "2, 12, left, default");
		
		comboAeropuerto_llegada = new JComboBox(new ControladorAeropuerto().obtenerNombres().toArray());
		contentPane.add(comboAeropuerto_llegada, "4, 12, fill, default");
		
		btnEliminar = new JButton("Eliminar");
		contentPane.add(btnEliminar, "6, 12");
		btnEliminar.addActionListener(new EventoVuelo(this));
		
		lblNewLabel_9 = new JLabel("Datos completos");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblNewLabel_9, "10, 12");
		
		JLabel lblNewLabel_3 = new JLabel("Aeropuerto de salida");
		contentPane.add(lblNewLabel_3, "2, 14, left, default");
		
		comboAeropuerto_Salida = new JComboBox(new ControladorAeropuerto().obtenerNombres().toArray());
		contentPane.add(comboAeropuerto_Salida, "4, 14, fill, default");
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de salida");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_4, "2, 16, left, default");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		tf_fechaSalida = new JFormattedTextField(df);
		contentPane.add(tf_fechaSalida, "4, 16, fill, default");
		
		Label label = new Label("yyyy-MM-dd");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label, "6, 16, center, default");
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de llegada");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_5, "2, 18, left, default");
		
		tf_fecha_llegada = new JFormattedTextField(df);
		contentPane.add(tf_fecha_llegada, "4, 18, fill, default");
		
		Label label_1 = new Label("yyyy-MM-dd");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label_1, "6, 18, center, default");
		
		JLabel lblNewLabel_6 = new JLabel("Tiempo de vuelo (horas)");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_6, "2, 20, right, default");
		
		textArea_resultado = new TextArea();
		contentPane.add(textArea_resultado, "10, 13, 1, 8");
		
		tf_tiempo_vuelo = new JTextField();
		contentPane.add(tf_tiempo_vuelo, "4, 20, fill, default");
		tf_tiempo_vuelo.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Aerol\u00EDnea");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_7, "2, 22, left, default");
		
		combo_aerolinea = new JComboBox(new ControladorLineaAerea().obtenerNombres().toArray());
		contentPane.add(combo_aerolinea, "4, 22, fill, default");
	}

}
