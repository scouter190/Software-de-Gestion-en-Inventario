package gui;

import java.awt.Color;
import gui.*;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.List;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.*;
import arreglos.*;
import gui.*;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class entradasi extends JInternalFrame {
	
	public static ArregloItems arregloItem= new ArregloItems();
	public JComboBox <String> cboProveedor;
	public JComboBox <String> cboItem;
	public JComboBox <String> cboPersonal;
	public static ArregloPersonal ap = new ArregloPersonal();
	public static ArregloProveedores arregloProveedores = new ArregloProveedores();
	public static DefaultTableModel modelo;
	
	public static String seleccionItem= "";
	public static String seleccionPersonal= "";
	public static String seleccionProveedor= "";
	
	public static int numEntrada=0;
	public static int cantidadEntrada=0;
	
	public static Entrada entrada;
	public static ArregloEntrada arregloEntrada;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entradasi frame = new entradasi();
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
	public entradasi() {
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setBackground(new Color(255, 255, 255));		
		
		getContentPane().setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		setTitle("Ingreso a Almac\u00E9n");
		setBounds(50, 50, 868, 635);
		getContentPane().setLayout(null);
		JButton btnRegistrar = new JButton("");
		btnRegistrar.setIcon(new ImageIcon(entradasi.class.getResource("/img/registrar.png")));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrarEntrada();
				
								
			}
		});
		btnRegistrar.setBounds(775, 447, 50, 35);
		getContentPane().add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(entradasi.class.getResource("/img/limpieza-de-datos.png")));
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnLimpiar.setBounds(775, 401, 50, 35);
		getContentPane().add(btnLimpiar);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblProveedor.setBounds(281, 108, 125, 14);
		getContentPane().add(lblProveedor);
		
		cboProveedor = new JComboBox(cargarProveedores());
		cboProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionProveedor = (String) 
				cboProveedor.getSelectedItem();
			}
		});
		cboProveedor.setBackground(Color.WHITE);
		cboProveedor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		cboProveedor.setBounds(280, 140, 200, 30);
		
		cboProveedor.setModel(cboModel);
		cboProveedor.setSelectedIndex(-1);
		getContentPane().add(cboProveedor);
		
		JLabel lblRecibidoPor = new JLabel("Recibido por:");
		lblRecibidoPor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblRecibidoPor.setBounds(42, 108, 125, 14);
		getContentPane().add(lblRecibidoPor);
		
		
		cboPersonal = new JComboBox(cargarPersonal());
		cboPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionPersonal = (String) 
				cboPersonal.getSelectedItem();
			}
		});
		cboPersonal.setBackground(Color.WHITE);
		cboPersonal.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		cboPersonal.setBounds(42, 143, 204, 25);
		getContentPane().add(cboPersonal);
		cboPersonal.setModel(cboModel2);
		cboPersonal.setSelectedIndex(-1);
		
		JLabel lbltem = new JLabel("\u00CDtem:");
		lbltem.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lbltem.setBounds(42, 200, 147, 23);
		getContentPane().add(lbltem);
		
		JComboBox cboItem = new JComboBox(cargarItem());
		cboItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				seleccionItem = (String) 
				cboItem.getSelectedItem();
			}
		});
		cboItem.setBackground(Color.WHITE);
		cboItem.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		cboItem.setBounds(42, 239, 204, 25);
		cboItem.setModel(cboItemNombre);
		cboItem.setSelectedIndex(-1);
		getContentPane().add(cboItem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(525, 141, 301, 121);
		getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 340, 697, 257);
		getContentPane().add(scrollPane_1);
		
		tblEntrada = new JTable();
		scrollPane_1.setViewportView(tblEntrada);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCantidad.setBounds(280, 205, 147, 23);
		getContentPane().add(lblCantidad);
		
		txtCantidadEntrada = new JTextField();
		txtCantidadEntrada.setBounds(280, 241, 200, 23);
		getContentPane().add(txtCantidadEntrada);
		txtCantidadEntrada.setColumns(10);
		
		
		modelo= new DefaultTableModel();
		modelo.addColumn("N° Entrada");
		modelo.addColumn("Fecha de entrada");
		modelo.addColumn("Ítem");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Proveedor");
		modelo.addColumn("Recepcionador");
	
		
		tblEntrada.setModel(modelo);
		
		JButton btnImprimir = new JButton("");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnImprimir.setIcon(new ImageIcon(entradasi.class.getResource("/img/imprimir-contorno-del-boton.png")));
		btnImprimir.setBounds(775, 493, 50, 35);
		getContentPane().add(btnImprimir);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(Color.ORANGE);
		panel.setBounds(0, 0, 868, 85);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistroDeIngreso = new JLabel("INGRESO ALMAC\u00C9N");
		lblRegistroDeIngreso.setForeground(Color.WHITE);
		lblRegistroDeIngreso.setBounds(46, 19, 366, 47);
		panel.add(lblRegistroDeIngreso);
		lblRegistroDeIngreso.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistroDeIngreso.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		
		txtNumEntrada = new JTextField();
		txtNumEntrada.setBounds(693, 22, 165, 27);
		panel.add(txtNumEntrada);
		txtNumEntrada.setColumns(10);
		
		//txtNumEntrada.setText(""+arregloEntrada.codigoCorrelativo());
		/*dashboard2.cerrarVentana();
				dashboard2.mostrarImprimir = Boolean.TRUE;
				dashboard2.ShowImprimir();
				dashboard2.CloseNuevoRgistro();*/
		
	}
	
	personal personalInternal = new personal();
	ArrayList<String> nombrePersonal = personalInternal.obtenerNombrePersonal();
	DefaultComboBoxModel<String> cboModel2 = new DefaultComboBoxModel<>(nombrePersonal.toArray(new String[0]));
	
	proveedores proveedoresFrame = new proveedores();
	ArrayList<String> razonesSociales = proveedoresFrame.obtenerRazonesSociales();
	
	DefaultComboBoxModel<String> cboModel = new DefaultComboBoxModel<>(razonesSociales.toArray(new String[0]));
	
	nuevoRegistro itemInternal = new nuevoRegistro();
	ArrayList<String> nombreItem = itemInternal.obtenerNomItem();
	DefaultComboBoxModel<String> cboItemNombre = new DefaultComboBoxModel<>(nombreItem.toArray(new String[0]));
	private JTable tblEntrada;
	private JTextField txtCantidadEntrada;
	private JTextField txtNumEntrada;
	
	

	
	public void registrar(){
		 
		   
		  try {
			  
			   Object[] row = new Object[7];
	        	numEntrada = Integer.parseInt(txtCantidadEntrada.getText());
	        	cantidadEntrada= Integer.parseInt(txtCantidadEntrada.getText());
	            
	        	row[0] = seleccionItem;
				row[1] = seleccionItem;
				row[2]= seleccionItem;
				row[3] = seleccionItem;
				row [4]= seleccionProveedor;
				row [5]= seleccionPersonal;
				row [6]= seleccionPersonal;
			
			  
				modelo.addRow(row);
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo hacer la tabla");
		}
	}
	
	
	public void RegistrarEntrada() {
	    try {
	        
	        	numEntrada = Integer.parseInt(txtNumEntrada.getText());
	        	cantidadEntrada= Integer.parseInt(txtCantidadEntrada.getText());
	            
	        	entrada= new Entrada(numEntrada, cantidadEntrada);
	            arregloEntrada.adicionar(entrada);
	            
	             JOptionPane.showMessageDialog(null, "Se han registrado correctamente los datos");
	             registrar();
	      
	             limpiar();
	            
	        
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Debe ingresar datos completos");
	    }
	}
	
	private void limpiar(){
		
		txtNumEntrada.setText(""+arregloEntrada.codigoCorrelativo());
		txtCantidadEntrada.setText("");
				
	}
	
	
	public static String[] cargarProveedores() {
		  
        
        String[] listaProveedores = new String[arregloProveedores.tamanio() + 1];
			listaProveedores[0] = "--Seleccionar--";
		
		for(int i = 0; i < arregloProveedores.tamanio(); i++) 
			
		{
			listaProveedores[i + 1] = arregloProveedores.obtener(i).getRazonSocial();
		}

		return listaProveedores;
		
		
	   }
	
	
		public static String[] cargarItem() {
		  
        
        String[] listaItem = new String[arregloItem.tamanio() + 1];
			listaItem[0] = "--Seleccionar--";
		
		for(int i = 0; i < arregloItem.tamanio(); i++) 
			
		{
			listaItem[i + 1] = arregloItem.obtener(i).getNombre();
		}

		return listaItem;
		
		
	   }
	
	public static String[] cargarPersonal() {
			  
	        
	     String[] listaPersonal = new String[ap.tamanio() + 1];
	  			listaPersonal[0] = "--Seleccionar--";
	  		
	  	for(int i = 0; i < ap.tamanio(); i++) 
	  			
	  	{
	  		listaPersonal[i + 1] = ap.obtener(i).getNombre();
	  	}
	  
	  	return listaPersonal;
	  		
	  		
	}
	
	public boolean validarTextos() {
	    try {
	       
	        if (txtCantidadEntrada.getText().trim().equals("")) {
	            throw new Exception("Debe ingresar una cantidad");
	        }
	        int cantidadEntrada= Integer.parseInt(txtCantidadEntrada.getText());
	        if (cantidadEntrada==0) {
	            throw new Exception("Debe ingresar una cantidad mayor a 0");
	        }
	        
	        return true;
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, e.getMessage());
	        return false;
	    }
	
	}
}
