package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class salidas extends JInternalFrame {
	private JTable tblSalida;
	private DefaultTableModel modelo;
	private JTextField txtBuscador;
	public int contador=0;
	private JButton btnNuevaSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salidas frame = new salidas();
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
	public salidas() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblSalidaDeAlamcn = new JLabel("SALIDA DE ALMAC\u00C9N");
		lblSalidaDeAlamcn.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		lblSalidaDeAlamcn.setBounds(60, 11, 327, 70);
		getContentPane().add(lblSalidaDeAlamcn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 148, 623, 361);
		getContentPane().add(scrollPane);
		
		tblSalida = new JTable();
		tblSalida.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblSalida);
		
		txtBuscador = new JTextField();
		txtBuscador.setBounds(25, 92, 412, 34);
		getContentPane().add(txtBuscador);
		txtBuscador.setColumns(10);
		
		btnNuevaSalida = new JButton("Nueva Salida");
		btnNuevaSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador++;
				generarSalida genSalida= new generarSalida();
				genSalida.setVisible(true);
			}
		});
		btnNuevaSalida.setBounds(487, 98, 111, 28);
		getContentPane().add(btnNuevaSalida);
		modelo= new DefaultTableModel();
		modelo.addColumn("N°");
		modelo.addColumn("Entregado por");
		modelo.addColumn("Destino");
		modelo.addColumn("Fecha");
		modelo.addColumn("Detalles");
		
		tblSalida.setModel(modelo);
		
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setBounds(210, 105, 674, 606);

	}
	
	
	
}
