package mvc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import dao.negocio.Alianza;
import mvc.eventos.EventoAerolinea;

public class VistaAerolinea extends JFrame {
	public JTextField tf_id;
	public JTextField tf_nombre;
	public JComboBox comboAlianza;
	public JButton btnConsultar;
	public JButton btnModificar;
	public JButton btnAgregar;
	public JButton btnAtras;
	public JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAerolinea frame = new VistaAerolinea();
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
	public VistaAerolinea() {
		setTitle("Gesti\u00F3n de aerol\u00EDneas");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Aerol\u00EDneas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, "1, 2, 18, 1");
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		getContentPane().add(lblNewLabel_1, "2, 6");
		
		tf_id = new JTextField();
		getContentPane().add(tf_id, "6, 6, fill, default");
		tf_id.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		getContentPane().add(btnConsultar, "10, 6");
		btnConsultar.addActionListener(new EventoAerolinea(this));
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		getContentPane().add(lblNewLabel_2, "2, 8");
		
		tf_nombre = new JTextField();
		getContentPane().add(tf_nombre, "6, 8, fill, default");
		tf_nombre.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		getContentPane().add(btnEliminar, "10, 8");
		btnEliminar.addActionListener(new EventoAerolinea(this));
		
		JLabel lblNewLabel_3 = new JLabel("Alianza");
		getContentPane().add(lblNewLabel_3, "2, 10");
		
		comboAlianza = new JComboBox();
		comboAlianza.setModel(new DefaultComboBoxModel(Alianza.values()));
		getContentPane().add(comboAlianza, "6, 10, fill, default");
		
		btnModificar = new JButton("Modificar");
		getContentPane().add(btnModificar, "10, 10");
		btnModificar.addActionListener(new EventoAerolinea(this));
		
		btnAtras = new JButton("Atr\u00E1s");
		getContentPane().add(btnAtras, "2, 12");
		btnAtras.addActionListener(new EventoAerolinea(this));
		
		btnAgregar = new JButton("Agregar");
		getContentPane().add(btnAgregar, "6, 12");
		btnAgregar.addActionListener(new EventoAerolinea(this));
	}
}
