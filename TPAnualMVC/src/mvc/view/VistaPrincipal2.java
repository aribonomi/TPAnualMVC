package mvc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.eventos.EventosVistaPrincipal;

import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VistaPrincipal2 extends JFrame {

	private JPanel contentPane;
	public JMenuItem mntmSalir;
	public JMenuItem mntmVentas;
	public JMenuItem mntmVuelos;
	public JMenuItem mntmAerolineas;
	public JMenuItem mntmClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal2 frame = new VistaPrincipal2();
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
	public VistaPrincipal2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmClientes);
		mntmClientes.addActionListener(new EventosVistaPrincipal(this));
		
		mntmAerolineas = new JMenuItem("Aerol\u00EDneas");
		mntmAerolineas.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmAerolineas);
		mntmAerolineas.addActionListener(new EventosVistaPrincipal(this));
		
		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmVentas);
		mntmVentas.addActionListener(new EventosVistaPrincipal(this));
		
		mntmVuelos = new JMenuItem("Vuelos");
		mntmVuelos.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmVuelos);
		mntmVuelos.addActionListener(new EventosVistaPrincipal(this));
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmSalir);
		mntmSalir.addActionListener(new EventosVistaPrincipal(this));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

}
