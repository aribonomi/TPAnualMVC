package mvc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import mvc.controller.ControladorCliente;

import javax.swing.border.BevelBorder;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuCliente = new JMenu("Clientes");
		menuCliente.setForeground(new Color(0, 0, 0));
		menuCliente.setBackground(Color.BLACK);
		menuBar.add(menuCliente);
		
		JMenuItem agregarCliente = new JMenuItem("Agregar");
		menuCliente.add(agregarCliente);
		agregarCliente.addActionListener(new ControladorCliente(this));
		
		JMenuItem consultarCliente = new JMenuItem("Consultar");
		menuCliente.add(consultarCliente);
		
		JMenuItem modificarCliente = new JMenuItem("Modificar");
		menuCliente.add(modificarCliente);
		
		JMenuItem eliminarCliente = new JMenuItem("Eliminar");
		menuCliente.add(eliminarCliente);
		
		JMenu menuLineaAerea = new JMenu("Líneas aereas");
		menuLineaAerea.setBackground(Color.BLACK);
		menuBar.add(menuLineaAerea);
		
		JMenuItem agregarLineaAerea = new JMenuItem("Agregar");
		menuLineaAerea.add(agregarLineaAerea);
		
		JMenuItem consultarLineaAerea = new JMenuItem("Consultar");
		menuLineaAerea.add(consultarLineaAerea);
		
		JMenuItem modificarLineaAerea = new JMenuItem("Modificar");
		menuLineaAerea.add(modificarLineaAerea);
		
		JMenuItem eliminarLineaAerea = new JMenuItem("Eliminar");
		menuLineaAerea.add(eliminarLineaAerea);
		
		JMenu menuVuelo = new JMenu("Vuelos");
		menuVuelo.setBackground(Color.BLACK);
		menuBar.add(menuVuelo);
		
		JMenuItem agregarVuelo = new JMenuItem("Agregar");
		menuVuelo.add(agregarVuelo);
		
		JMenuItem consultarVuelo = new JMenuItem("Consultar");
		menuVuelo.add(consultarVuelo);
		
		JMenuItem modificarVuelo = new JMenuItem("Modificar");
		menuVuelo.add(modificarVuelo);
		
		JMenuItem eliminarVuelo = new JMenuItem("Eliminar");
		menuVuelo.add(eliminarVuelo);
		
		JMenu menuVenta = new JMenu("Ventas");
		menuVenta.setBackground(new Color(0, 0, 0));
		menuBar.add(menuVenta);
		
		JMenuItem agregarVenta = new JMenuItem("Agregar");
		menuVenta.add(agregarVenta);
		
		JMenuItem consultarVenta = new JMenuItem("Consultar");
		menuVenta.add(consultarVenta);
		
		JMenuItem modificarVenta = new JMenuItem("Modificar");
		menuVenta.add(modificarVenta);
		
		JMenuItem eliminarVenta = new JMenuItem("Eliminar");
		menuVenta.add(eliminarVenta);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 434, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel LabelBienvenido = new JLabel("BIENVENIDO!");
		LabelBienvenido.setBounds(108, 88, 223, 41);
		LabelBienvenido.setBackground(Color.ORANGE);
		LabelBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBienvenido.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		panel.add(LabelBienvenido);
	}
}
