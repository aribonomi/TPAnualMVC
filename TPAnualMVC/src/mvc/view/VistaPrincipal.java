package mvc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import mvc.eventos.EventosVistaPrincipal;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class VistaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JMenuItem mntmVentas;
	public JMenuItem mntmVuelos;
	public JMenuItem mntmAerolineas;
	public JMenuItem mntmClientes;
	public JMenuItem mntmSalir;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
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
	public VistaPrincipal() {
		setTitle("Men\u00FA principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("434px"),},
			new RowSpec[] {
				RowSpec.decode("261px"),}));
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.controlHighlight);
		contentPane.add(panel, "1, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("434px"),},
			new RowSpec[] {
				RowSpec.decode("21px"),
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
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar, "1, 1, fill, fill");
		
		mntmClientes = new JMenuItem("Clientes");
		menuBar.add(mntmClientes);
		//mntmClientes.addActionListener(new EventosVistaPrincipal(this));
		
		mntmAerolineas = new JMenuItem("Aerolineas");
		menuBar.add(mntmAerolineas);
		//mntmAerolineas.addActionListener(new EventosVistaPrincipal(this));
		
		mntmVuelos = new JMenuItem("Vuelos");
		menuBar.add(mntmVuelos);
		//mntmVuelos.addActionListener(new EventosVistaPrincipal(this));
		
		mntmVentas = new JMenuItem("Ventas");
		menuBar.add(mntmVentas);
		//mntmVentas.addActionListener(new EventosVistaPrincipal(this));
		
		mntmSalir = new JMenuItem("Salir");
		menuBar.add(mntmSalir);
		
		lblNewLabel = new JLabel("BIENVENIDO!");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		panel.add(lblNewLabel, "1, 11, center, default");
		//mntmSalir.addActionListener(new EventosVistaPrincipal(this));
	}
}
