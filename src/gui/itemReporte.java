package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloItems;
import clases.Items;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class itemReporte extends JFrame {

	private JPanel contentPane;
	private JTextArea txtReporteItem;
	public JComboBox <String> cboItem;
	private Items item;
	public static String seleccionItem= "";
	public static ArregloItems arregloItem2;
	private entrada entra= new entrada();
	private generarSalida salida= new generarSalida();
	private nuevoRegistro nuevo= new nuevoRegistro();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itemReporte frame = new itemReporte();
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
	public itemReporte() {
		arregloItem2= new ArregloItems();
	
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 581);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 593, 103);
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblReportetems = new JLabel("REPORTE \u00CDTEMS");
		lblReportetems.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblReportetems.setBounds(25, 31, 331, 46);
		panel.add(lblReportetems);
		
		cboItem = new JComboBox(cargarItem());
		cboItem.setBackground(Color.WHITE);
		cboItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionItem = (String) 
				cboItem.getSelectedItem();
			}
		});
		cboItem.setBounds(180, 139, 258, 25);
		contentPane.add(cboItem);
		cboItem.setModel(cboItemNombre);
		cboItem.setSelectedIndex(-1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 195, 530, 319);
		contentPane.add(scrollPane);
		
		txtReporteItem = new JTextArea();
		txtReporteItem.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		scrollPane.setViewportView(txtReporteItem);
		
		JLabel lblSeleccionartem = new JLabel("Seleccionar \u00EDtem:");
		lblSeleccionartem.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		lblSeleccionartem.setBounds(24, 139, 241, 25);
		contentPane.add(lblSeleccionartem);
		
		JButton btnImp = new JButton("");
		btnImp.setBackground(new Color(153, 204, 255));
		btnImp.setIcon(new ImageIcon(itemReporte.class.getResource("/img/imprimir-contorno-del-boton.png")));
		btnImp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnImp.setBounds(504, 124, 50, 40);
		contentPane.add(btnImp);
	}
	
	nuevoRegistro itemGui = new nuevoRegistro();
	ArrayList<String> nombreItem = itemGui.obtenerNomItem();
	DefaultComboBoxModel<String> cboItemNombre = new DefaultComboBoxModel<>(nombreItem.toArray(new String[0]));
	
	public static String[] cargarItem() {
		  
	      
	      String[] listaItem = new String[arregloItem2.tamanio() + 1];
				listaItem[0] = "--Seleccionar--";
			
			for(int i = 0; i < arregloItem2.tamanio(); i++) 
				
			{
				listaItem[i + 1] = arregloItem2.obtener(i).getNombre();
			}

			return listaItem;
			
			
	}
	
	public void listar() {
		try {
			 if(seleccionItem== null){
		        	JOptionPane.showMessageDialog(null, "Debe seleccionar un ítem");
		        }
			else{
				txtReporteItem.append("_____________________________________________________________\n");
			     txtReporteItem.append(" ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
			     txtReporteItem.append("_____________________________________________________________\n\n");
			    int cant= nuevoRegistro.cantidad;
			    int cantEntrada=entrada.cantidadEntrada;
			    int cantSalida=generarSalida.cantidadSalida;
			    
			    int stock= cant+ cantEntrada - cantSalida;
			    
			    for (int i = 0; i < 1; i++) {
			        txtReporteItem.append("          R E P O R T E  D E  I T E M S");
			        txtReporteItem.append("          |" +   "\n\n");
			        txtReporteItem.append("          ID DE ÍTEM\n");
			        txtReporteItem.append("          |" +  nuevoRegistro.codigo+ "\n\n");
			        txtReporteItem.append("          NOMBRE DE ÍTEM\n");
			        txtReporteItem.append("          |" + nuevoRegistro.nombre + "\n\n");
			        txtReporteItem.append("          UBICACIÓN DE ÍTEM\n");
			        txtReporteItem.append("          |" + nuevoRegistro.ubicacion + "\n\n");
			        txtReporteItem.append("          STOCK ANTERIOR\n");
			        txtReporteItem.append("          |" + nuevoRegistro.cantidad + "\n\n");
			        txtReporteItem.append("          CANTIDAD DE ENTRADA\n");
			        txtReporteItem.append("          |" + entrada.cantidadEntrada + "\n\n");
			        txtReporteItem.append("          CANTIDAD DE SALIDA\n");
			        txtReporteItem.append("          |" + generarSalida.cantidadSalida + "\n\n");
			        txtReporteItem.append("          STOCK ACTUAL\n");
			        txtReporteItem.append("          |" + stock + "\n\n");
			        txtReporteItem.append("_____________________________________________________________\n");
			        txtReporteItem.append(" ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
			        txtReporteItem.append("_____________________________________________________________\n\n");
			        txtReporteItem.print();
			    }
			}
		} catch (PrinterException e) {
	        JOptionPane.showMessageDialog(null, "Error al imprimir");
	    }
	}
	
	
	
}
