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
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel LabelBienvenido = new JLabel("BIENVENIDO!");
		LabelBienvenido.setBounds(0, 105, 434, 52);
		LabelBienvenido.setBackground(Color.ORANGE);
		LabelBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBienvenido.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		panel.add(LabelBienvenido);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		panel.add(menuBar);
		
		mntmClientes = new JMenuItem("Clientes");
		menuBar.add(mntmClientes);
		mntmClientes.addActionListener(new EventosVistaPrincipal(this));
		
		mntmAerolineas = new JMenuItem("Aerolineas");
		menuBar.add(mntmAerolineas);
		mntmAerolineas.addActionListener(new EventosVistaPrincipal(this));
		
		mntmVuelos = new JMenuItem("Vuelos");
		menuBar.add(mntmVuelos);
		mntmVuelos.addActionListener(new EventosVistaPrincipal(this));
		
		mntmVentas = new JMenuItem("Ventas");
		menuBar.add(mntmVentas);
		mntmVentas.addActionListener(new EventosVistaPrincipal(this));
		
		mntmSalir = new JMenuItem("Salir");
		menuBar.add(mntmSalir);
		mntmSalir.addActionListener(new EventosVistaPrincipal(this));
	}
}
