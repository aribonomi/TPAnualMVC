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

public class VistaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JButton btnAerolineas;
	public JButton btnClientes;
	public JButton btnVentas;
	public JButton btnVuelos;
	public JButton btnSalir;

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
		LabelBienvenido.setBounds(0, 0, 434, 52);
		LabelBienvenido.setBackground(Color.ORANGE);
		LabelBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBienvenido.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		panel.add(LabelBienvenido);
		
		btnAerolineas = new JButton("Aerol\u00EDneas");
		btnAerolineas.setToolTipText("");
		btnAerolineas.setBounds(159, 63, 115, 23);
		panel.add(btnAerolineas);
		btnAerolineas.addActionListener(new EventosVistaPrincipal(this));
		
		btnClientes = new JButton("Clientes");
		btnClientes.setBounds(159, 97, 115, 23);
		panel.add(btnClientes);
		btnClientes.addActionListener(new EventosVistaPrincipal(this));
		
		btnVentas = new JButton("Ventas");
		btnVentas.setBounds(159, 131, 115, 23);
		panel.add(btnVentas);
		btnVentas.addActionListener(new EventosVistaPrincipal(this));
		
		btnVuelos = new JButton("Vuelos");
		btnVuelos.setBounds(159, 165, 115, 23);
		panel.add(btnVuelos);
		btnVuelos.addActionListener(new EventosVistaPrincipal(this));
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(159, 199, 115, 23);
		panel.add(btnSalir);
		btnSalir.addActionListener(new EventosVistaPrincipal(this));
	}
}
