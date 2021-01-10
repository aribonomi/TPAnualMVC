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

public class VistaVuelo2 extends JFrame {

	private JPanel contentPane;
	private JTextField tfCantidadAsientos;
	private JTextField tf_Id;
	private JComboBox comboAeropuerto_Salida;
	private JComboBox comboAeropuerto_llegada;
	private JFormattedTextField tf_fecha_salida;
	private JFormattedTextField tf_fecha_llegada;
	private JButton btnConsultar;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
		contentPane.add(lblNewJgoodiesTitle, "4, 2, center, default");
		
		JLabel lblNewLabel_8 = new JLabel("ID");
		contentPane.add(lblNewLabel_8, "2, 6, left, default");
		
		tf_Id = new JTextField();
		contentPane.add(tf_Id, "4, 6, fill, default");
		tf_Id.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		contentPane.add(btnConsultar, "6, 6");
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de vuelo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_1, "2, 8, left, default");
		
		JLabel lblNroVuelo = new JLabel("");
		contentPane.add(lblNroVuelo, "4, 8, center, default");
		
		JButton btnModificar = new JButton("Modificar");
		contentPane.add(btnModificar, "6, 8");
		
		JLabel lblNewLabel = new JLabel("Cantidad de asientos");
		contentPane.add(lblNewLabel, "2, 10, left, default");
		
		tfCantidadAsientos = new JTextField();
		contentPane.add(tfCantidadAsientos, "4, 10, fill, default");
		tfCantidadAsientos.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		contentPane.add(btnAgregar, "6, 10");
		
		JLabel lblNewLabel_2 = new JLabel("Aeropuerto de llegada");
		contentPane.add(lblNewLabel_2, "2, 12, left, default");
		
		comboAeropuerto_llegada = new JComboBox();
		contentPane.add(comboAeropuerto_llegada, "4, 12, fill, default");
		
		JLabel lblNewLabel_3 = new JLabel("Aeropuerto de salida");
		contentPane.add(lblNewLabel_3, "2, 14, left, default");
		
		comboAeropuerto_Salida = new JComboBox();
		contentPane.add(comboAeropuerto_Salida, "4, 14, fill, default");
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de salida");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_4, "2, 16, left, default");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		tf_fecha_salida = new JFormattedTextField(df);
		contentPane.add(tf_fecha_salida, "4, 16, fill, default");
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de llegada");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_5, "2, 18, left, default");
		
		tf_fecha_llegada = new JFormattedTextField(df);
		contentPane.add(tf_fecha_llegada, "4, 18, fill, default");
		
		JLabel lblNewLabel_6 = new JLabel("Tiempo de vuelo (horas)");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_6, "2, 20, left, default");
		
		JSpinner tf_tiempo_vuelo = new JSpinner();
		tf_tiempo_vuelo.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		contentPane.add(tf_tiempo_vuelo, "4, 20");
		
		JLabel lblNewLabel_7 = new JLabel("Aerol\u00EDnea");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_7, "2, 22, left, default");
		
		JComboBox combo_aerolinea = new JComboBox();
		contentPane.add(combo_aerolinea, "4, 22, fill, default");
	}

}
