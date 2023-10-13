package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloItems;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class registroEntradas extends JInternalFrame {
	private JTextField textField;
	private JTable tblReporteEntrada;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registroEntradas frame = new registroEntradas();
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
	public registroEntradas() {
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 899, 566);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(27, 132, 750, 23);
		textField.setToolTipText("");
		textField.setColumns(10);
		getContentPane().add(textField);
		
		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(787, 132, 89, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBackground(Color.WHITE);
		getContentPane().add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 179, 846, 267);
		getContentPane().add(scrollPane);
		
		tblReporteEntrada = new JTable();
		tblReporteEntrada.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblReporteEntrada);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 899, 82);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistroEntradas = new JLabel("REGISTRO ENTRADAS");
		lblRegistroEntradas.setBounds(46, 28, 356, 31);
		panel.add(lblRegistroEntradas);
		lblRegistroEntradas.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		
		JButton button = new JButton("NUEVO INGRESO");
		button.setBounds(726, 37, 140, 23);
		panel.add(button);
		button.setBackground(Color.WHITE);
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnImprimir.setBounds(784, 493, 89, 23);
		getContentPane().add(btnImprimir);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dashboard2.CloseRegEntrada();
				dashboard2.ShowEntradas();
				dashboard2.mostrarEntra= Boolean.TRUE;
			}
		});
		
		modelo= new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("RECIBIDO POR");
		modelo.addColumn("P");
		modelo.addColumn("DESCRIPCIÓN");
		modelo.addColumn("UNIDAD MEDIDA");
		modelo.addColumn("STOCK");
		listar();
		
	}
	
	private void listar(){
		modelo.setRowCount(0);
		for(int i=0; i<entradasi.arregloItem.tamanio(); i++){
			Object[] fila= {
					entradasi.arregloItem.obtener(i).getIdItems(),
					entradasi.arregloItem.obtener(i).getNombre(),
					
					entradasi.arregloItem.obtener(i).getStock(),
					entradasi.arregloItem.obtener(i).getUbicación(),
			};
			modelo.addRow(fila);
		}
	}


}
