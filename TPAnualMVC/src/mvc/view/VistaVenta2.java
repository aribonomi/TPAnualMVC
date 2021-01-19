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

import mvc.controller.ControladorCliente;
import mvc.controller.ControladorLineaAerea;
import mvc.controller.ControladorVuelo;
import mvc.eventos.EventoVenta;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.TextArea;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class VistaVenta2 extends JFrame {

	public JPanel contentPane;
	public JTextField tf_id;
	public JComboBox comboCliente;
	public JComboBox comboAerolinea;
	public JFormattedTextField tf_fecha;
	public JComboBox comboCuotas;
	public JButton btnConsultar;
	public JButton btnAtras;
	public JButton btnAgregar;
	public JButton btnModificar;
	public JButton btnEliminar;
	public TextArea resultado;
	public JComboBox comboVuelo;
	public JComboBox comboFormaPago;
	public JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVenta2 frame = new VistaVenta2();
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
	public VistaVenta2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 10, 550, 350);
		setBounds(100, 100, 485, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		scrollPane.setPreferredSize(new Dimension(785, 300));
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
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		JLabel lblNewLabel = new JLabel("Ventas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel, "1, 2, 9, 1, center, default");
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		contentPane.add(lblNewLabel_1, "2, 4, left, default");
		
		tf_id = new JTextField();
		contentPane.add(tf_id, "4, 4, fill, default");
		tf_id.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		contentPane.add(btnConsultar, "6, 4");
		btnConsultar.addActionListener(new EventoVenta(this));
		
		JLabel lblNewLabel_2 = new JLabel("Cliente");
		contentPane.add(lblNewLabel_2, "2, 6, left, default");
		
		comboCliente = new JComboBox(new ControladorCliente().obtenerIds().toArray());
		contentPane.add(comboCliente, "4, 6, fill, default");
		
		btnEliminar = new JButton("Eliminar");
		contentPane.add(btnEliminar, "6, 6");
		btnEliminar.addActionListener(new EventoVenta(this));
		
		JLabel lblNewLabel_3 = new JLabel("Vuelo");
		contentPane.add(lblNewLabel_3, "2, 8, left, default");
		
		comboVuelo = new JComboBox(new ControladorVuelo().obtenerIds().toArray());
		contentPane.add(comboVuelo, "4, 8, fill, default");
		
		btnModificar = new JButton("Modificar");
		contentPane.add(btnModificar, "6, 8");
		btnModificar.addActionListener(new EventoVenta(this));
		
		JLabel lblNewLabel_4 = new JLabel("Aerol\u00EDnea");
		contentPane.add(lblNewLabel_4, "2, 10, left, default");
		
		comboAerolinea = new JComboBox(new ControladorLineaAerea().obtenerNombres().toArray());
		contentPane.add(comboAerolinea, "4, 10, fill, default");
		
		resultado = new TextArea();
		contentPane.add(resultado, "10, 9, 1, 10");
		
		JLabel lblNewLabel_5 = new JLabel("Fecha");
		contentPane.add(lblNewLabel_5, "2, 12, left, default");
		
		
		tf_fecha = new JFormattedTextField(df);
		contentPane.add(tf_fecha, "4, 12, fill, default");
		
		JLabel lblNewLabel_6 = new JLabel("Forma de pago");
		contentPane.add(lblNewLabel_6, "2, 14, left, default");
		
		comboFormaPago = new JComboBox();
		comboFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "D\u00E9bito", "Cr\u00E9dito"}));
		contentPane.add(comboFormaPago, "4, 14, fill, default");
		
		JLabel lblNewLabel_7 = new JLabel("Cuotas (si paga con cr\u00E9dito)");
		contentPane.add(lblNewLabel_7, "2, 16, right, default");
		
		comboCuotas = new JComboBox();
		comboCuotas.setModel(new DefaultComboBoxModel(new String[] {"3 s/ inter\u00E9s", "6 s/ inter\u00E9s", "12 (10% de inter\u00E9s)", "24 (10% de inter\u00E9s)"}));
		contentPane.add(comboCuotas, "4, 16, fill, default");
		
		btnAtras = new JButton("Atr\u00E1s");
		contentPane.add(btnAtras, "2, 18, left, default");
		btnAtras.addActionListener(new EventoVenta(this));
		
		btnAgregar = new JButton("Agregar");
		contentPane.add(btnAgregar, "4, 18");
		btnAgregar.addActionListener(new EventoVenta(this));
	}

}
