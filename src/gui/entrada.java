package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloEntrada;
import arreglos.ArregloItems;
import arreglos.ArregloPersonal;
import arreglos.ArregloProveedores;
import clases.Entrada;
import clases.Items;
import clases.Personal;
import clases.Proveedor;
import javax.swing.JTextArea;

public class entrada extends JFrame {

	private JPanel contentPane;
	public static ArregloItems arregloItem;
	public JComboBox <String> cboProveedor;
	public JComboBox <String> cboItem;
	public JComboBox <String> cboPersonal;
	public static ArregloPersonal ap;
	public static ArregloProveedores arregloProveedores;
	public static ArregloEntrada arregloEntrada;
	public static DefaultTableModel modelo;
	
	private Items item;
	private Personal personal;
	private Proveedor proveedor;
	public static String seleccionItem= "";
	public static String seleccionPersonal= "";
	public static String seleccionProveedor= "";
	
	private int codigoEntrada=0;
	public static int cantidadEntrada=0;
	private JTextField txtCantidadEntrada;
	private JTextArea txtReporteEntrada;
	private JTextField txtNumEntrada;
	
	
	Calendar fecha= new GregorianCalendar();
	String anio=Integer.toString(fecha.get(Calendar.YEAR));
	String mes=Integer.toString(fecha.get(Calendar.MONTH)+1);
	String dia=Integer.toString(fecha.get(Calendar.DATE));
	String fechaCompleta= anio+"-"+mes+"-"+dia;
	
	String hora=Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
	String minutos=Integer.toString(fecha.get(Calendar.MINUTE));
	String horaActual= hora + ":"+ minutos;

	private LocalDateTime fechaHora;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entrada frame = new entrada();
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
	public entrada() {
		arregloEntrada= new ArregloEntrada();
		arregloItem= new ArregloItems();
		ap = new ArregloPersonal();
		arregloProveedores = new ArregloProveedores();
		
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 30, 685, 680);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(281, 108, 125, 14);
		lblProveedor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		getContentPane().add(lblProveedor);
		
		cboProveedor = new JComboBox(cargarProveedores());
		cboProveedor.setBounds(280, 140, 200, 30);
		cboProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionProveedor = (String) 
				cboProveedor.getSelectedItem();
			}
		});
		cboProveedor.setBackground(Color.WHITE);
		cboProveedor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		
		cboProveedor.setModel(cboModel);
		cboProveedor.setSelectedIndex(-1);
		getContentPane().add(cboProveedor);
		
		JLabel lblRecibidoPor = new JLabel("Recibido por:");
		lblRecibidoPor.setBounds(42, 108, 125, 14);
		lblRecibidoPor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		getContentPane().add(lblRecibidoPor);
		
		
		cboPersonal = new JComboBox(cargarPersonal());
		cboPersonal.setBounds(42, 143, 204, 25);
		cboPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionPersonal = (String) 
				cboPersonal.getSelectedItem();
			}
		});
		cboPersonal.setBackground(Color.WHITE);
		cboPersonal.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		getContentPane().add(cboPersonal);
		cboPersonal.setModel(cboModel2);
		cboPersonal.setSelectedIndex(-1);
		
		JLabel lbltem = new JLabel("\u00CDtem:");
		lbltem.setBounds(42, 200, 147, 23);
		lbltem.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		getContentPane().add(lbltem);
		
		JComboBox cboItem = new JComboBox(cargarItem());
		cboItem.setBounds(42, 239, 204, 25);
		cboItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				seleccionItem = (String) 
				cboItem.getSelectedItem();
			}
		});
		cboItem.setBackground(Color.WHITE);
		cboItem.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		cboItem.setModel(cboItemNombre);
		cboItem.setSelectedIndex(-1);
		getContentPane().add(cboItem);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(280, 205, 147, 23);
		lblCantidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		getContentPane().add(lblCantidad);
		
		txtCantidadEntrada = new JTextField();
		txtCantidadEntrada.setBounds(280, 241, 200, 23);
		getContentPane().add(txtCantidadEntrada);
		txtCantidadEntrada.setColumns(10);
		txtCantidadEntrada.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyTyped(KeyEvent e) {
				char c =e.getKeyChar();
				
				   if (!Character.isDigit(c)) {
			            e.consume(); 
			            Toolkit.getDefaultToolkit().beep();
			        }
				  
			}
		});
		
		
		modelo= new DefaultTableModel();
		modelo.addColumn("N° Entrada");
		modelo.addColumn("Fecha de entrada");
		modelo.addColumn("Ítem");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Proveedor");
		modelo.addColumn("Recepcionador");
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 84, 649, 557);
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.ORANGE);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 250, 450, 296);
		panel.add(scrollPane);
		
		txtReporteEntrada = new JTextArea();
		txtReporteEntrada.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		scrollPane.setViewportView(txtReporteEntrada);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setBounds(539, 124, 50, 35);
		panel.add(btnLimpiar);
		btnLimpiar.setIcon(new ImageIcon(entradasi.class.getResource("/img/limpieza-de-datos.png")));
		btnLimpiar.setBackground(new Color(255, 51, 51));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		JButton btnRegistrar = new JButton("");
		btnRegistrar.setBounds(539, 56, 50, 35);
		panel.add(btnRegistrar);
		btnRegistrar.setIcon(new ImageIcon(entradasi.class.getResource("/img/registrar.png")));
		btnRegistrar.setBackground(new Color(173, 255, 47));
		btnRegistrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		
		JButton btnImprimir = new JButton("");
		btnImprimir.setBackground(new Color(135, 206, 250));
		btnImprimir.setBounds(539, 250, 50, 35);
		panel.add(btnImprimir);
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimirIndividual();
				
			}
		});
		btnImprimir.setIcon(new ImageIcon(entradasi.class.getResource("/img/imprimir-contorno-del-boton.png")));
		
		JLabel lblReporteDeEntrada = new JLabel("REPORTE DE ENTRADA");
		lblReporteDeEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		lblReporteDeEntrada.setForeground(new Color(165, 42, 42));
		lblReporteDeEntrada.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblReporteDeEntrada.setBounds(37, 198, 221, 47);
		panel.add(lblReporteDeEntrada);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimir();
			}
		});
		button.setIcon(new ImageIcon(entrada.class.getResource("/img/imprimir-contorno-del-boton.png")));
		button.setBackground(new Color(102, 51, 204));
		button.setBounds(539, 344, 50, 35);
		panel.add(button);
		
		JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setBounds(535, 99, 56, 14);
		panel.add(lblRegistrar);
		
		JLabel lblLimpiar = new JLabel("Limpiar");
		lblLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimpiar.setBounds(535, 171, 56, 14);
		panel.add(lblLimpiar);
		
		JLabel label_1 = new JLabel("Impresi\u00F3n ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(519, 390, 94, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Secuencial");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(529, 404, 72, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Imprimir");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(539, 289, 50, 20);
		panel.add(label_3);
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrarEntrada();
				limpiar();
								
			}
		});
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 0, 669, 73);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRegistroDeIngreso = new JLabel("INGRESO ALMAC\u00C9N");
		lblRegistroDeIngreso.setBounds(50, 12, 366, 47);
		panel_1.add(lblRegistroDeIngreso);
		lblRegistroDeIngreso.setForeground(Color.WHITE);
		lblRegistroDeIngreso.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistroDeIngreso.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		
		txtNumEntrada = new JTextField();
		txtNumEntrada.setEditable(false);
		txtNumEntrada.setForeground(Color.WHITE);
		txtNumEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumEntrada.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		txtNumEntrada.setBackground(Color.ORANGE);
		txtNumEntrada.setBounds(570, 24, 64, 30);
		panel_1.add(txtNumEntrada);
		txtNumEntrada.setColumns(10);
		txtNumEntrada.setText(""+arregloEntrada.codigoCorrelativo());
		
		JLabel label = new JLabel("N\u00B0");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(517, 35, 43, 25);
		panel_1.add(label);
		txtNumEntrada.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyTyped(KeyEvent e) {
				char c =e.getKeyChar();
				
				   if (!Character.isDigit(c)) {
			            e.consume(); 
			            Toolkit.getDefaultToolkit().beep();
			        }
				  
			}
		});
		
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
	
	
	public void imprimir() {
		if( codigoEntrada==0 || cantidadEntrada==0 || seleccionItem== null || seleccionPersonal== null || seleccionProveedor== null ){
			JOptionPane.showMessageDialog(null, "No hay valores para imprimir");
		}
		else{
	
	        txtReporteEntrada.append("_____________________________________________________________"+ "\n");
	        txtReporteEntrada.append(" ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"+ "\n");
	        txtReporteEntrada.append("_____________________________________________________________"+ "\n"+"\n");
	        txtReporteEntrada.append("          "+"N° PARTE DE ENTRADA" + "\n");
	        txtReporteEntrada.append("          |"+codigoEntrada + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"FECHA DE ENTRADA" + "\n");
	        txtReporteEntrada.append("          |"+fechaCompleta + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"HORA DE ENTRADA" + "\n");
	        txtReporteEntrada.append("          |"+horaActual + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"CANTIDAD DE ENTRADA" + "\n");
	        txtReporteEntrada.append("          |"+cantidadEntrada + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"NOMBRE DE ÍTEM" + "\n");
	        txtReporteEntrada.append("          |"+seleccionItem + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"PERSONAL QUE REGISTRÓ LA ENTRADA" + "\n");
	        txtReporteEntrada.append("          |"+seleccionPersonal + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"RAZÓN SOCIAL DEL PROVEEDOR" + "\n");
	        txtReporteEntrada.append("          |"+seleccionProveedor + "\n"+ "\n");
	        txtReporteEntrada.setCaretPosition(0);
		}
	}
	
	public void imprimirIndividual() {
	    
		if(codigoEntrada==0 || cantidadEntrada==0 || seleccionItem== null || seleccionPersonal== null || seleccionProveedor== null ){
			JOptionPane.showMessageDialog(null, "No existen entradas registradas");
		}
		else{
			txtReporteEntrada.setText("");
	        txtReporteEntrada.append("_____________________________________________________________"+ "\n");
	        txtReporteEntrada.append(" ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"+ "\n");
	        txtReporteEntrada.append("_____________________________________________________________"+ "\n"+"\n");
	        txtReporteEntrada.append("          "+"N° PARTE DE ENTRADA" + "\n");
	        txtReporteEntrada.append("          |"+codigoEntrada + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"FECHA DE ENTRADA" + "\n");
	        txtReporteEntrada.append("          |"+fechaCompleta + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"HORA DE ENTRADA" + "\n");
	        txtReporteEntrada.append("          |"+horaActual + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"CANTIDAD DE ENTRADA" + "\n");
	        txtReporteEntrada.append("          |"+cantidadEntrada + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"NOMBRE DE ÍTEM" + "\n");
	        txtReporteEntrada.append("          |"+seleccionItem + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"PERSONAL QUE REGISTRÓ LA ENTRADA" + "\n");
	        txtReporteEntrada.append("          |"+seleccionPersonal + "\n"+ "\n");
	        txtReporteEntrada.append("          "+"RAZÓN SOCIAL DEL PROVEEDOR" + "\n");
	        txtReporteEntrada.append("          |"+seleccionProveedor + "\n"+ "\n");
		}
        
        
       
    
}

	
	public void RegistrarEntrada() {
	    try {
	        if (validarTextos()) {
	            codigoEntrada = Integer.parseInt(txtNumEntrada.getText().trim());
	            cantidadEntrada = Integer.parseInt(txtCantidadEntrada.getText());

	            Entrada entradaClase = new Entrada(codigoEntrada, cantidadEntrada);
	            arregloEntrada.adicionar(entradaClase);

	            JOptionPane.showMessageDialog(null, "Registro de entrada ingresado correctamente");
	            
	            
	  
	        }
	
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar la entrada");
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
	        if(seleccionItem== null){
	        	throw new Exception("Debe seleccionar un ítem");
	        }
	        if(seleccionPersonal== null){
	        	throw new Exception("Debe seleccionar un personal");
	        }
	        if(seleccionProveedor== null){
	        	throw new Exception("Debe seleccionar un proveedor");
	        }
	        	        
	        return true;
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, e.getMessage());
	        return false;
	    }
	
	}
}