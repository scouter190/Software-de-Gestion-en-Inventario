package gui;

import java.awt.Color;
import gui.*;


import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.plaf.PanelUI;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.builder.PanelBuilder;

import clases.*;
import arreglos.*;
import gui.*;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;

public class nuevoRegistro extends JInternalFrame {
	public static JTextField txtNombre;
	public static JTextField txtCodigo;
	public static JTextField txtUbicacion;
	public static JTextField txtCantidad;
	public static Items item;
	public static ArregloItems arregloItem= new ArregloItems();
	public static JComboBox <String> cboCategoria;
	public static JComboBox <String> cboUnidadMedida;
	public static JComboBox <String> cboPersonal;
	public static ArregloPersonal ap = new ArregloPersonal();
	public static ArregloCategoria c = new ArregloCategoria();
	public static ArregloUnidadMedida um= new ArregloUnidadMedida();
	public static ArregloEntrada arregloEntrada= new ArregloEntrada();
	public static Entrada claseEntrada;
	
	private Categoria categoria;
	private UnidadMedida uniMedida;
	private Personal personal;
	private Proveedor proveedor;
	public static DefaultTableModel modelo2;
	public JComboBox cboEstado;
	private JTable tblInventario;
	
	public static entrada entra= new entrada();
	public static String seleccionEstado = ""; 
	public static String seleccionCategoria = ""; 
	public static String seleccionUnidadMedida = ""; 
	public static String seleccionPersonal = ""; 
	
	public static int nuevoStock=0;
	public static int codigo= 0;
	public static int cantidad=0;
	public static String nombre= "";
	public static String ubicacion= "";
	
	public static String nombreEntradaItem= "";
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevoRegistro frame = new nuevoRegistro();
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
	public nuevoRegistro() {
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setBackground(new Color(255, 255, 255));		
		
		getContentPane().setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		setTitle("Nuevo Ingreso");
		setBounds(0, 0, 1104, 624);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre de \u00CDtem:");
		lblNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNombre.setBounds(270, 150, 127, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblCod = new JLabel("Codigo:");
		lblCod.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCod.setBounds(26, 150, 72, 25);
		getContentPane().add(lblCod);
		
		JLabel lblUnidadDeMedida = new JLabel("Unidad de Medida:");
		lblUnidadDeMedida.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblUnidadDeMedida.setBounds(270, 336, 192, 14);
		getContentPane().add(lblUnidadDeMedida);
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n");
		lblUbicacin.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblUbicacin.setBounds(273, 432, 86, 14);
		getContentPane().add(lblUbicacin);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtNombre.setBounds(270, 181, 204, 25);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new KeyAdapter() {
			//validar
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (Character.isDigit(c)) {
		            e.consume(); // Ignora el carácter si es un número
		            Toolkit.getDefaultToolkit().beep();
		        }
		    }
		});
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtCodigo.setBounds(26, 186, 204, 25);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtCodigo.setText(""+ arregloItem.codigoCorrelativo());
		txtCodigo.addKeyListener(new KeyAdapter() {
			//validar
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (!Character.isDigit(c)) {
		            e.consume(); 
		            Toolkit.getDefaultToolkit().beep();
		        }
		    }
		});
		
		txtUbicacion = new JTextField();
		txtUbicacion.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtUbicacion.setColumns(10);
		txtUbicacion.setBounds(270, 462, 207, 25);
		
		getContentPane().add(txtUbicacion);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCantidad.setBounds(29, 428, 147, 23);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(26, 462, 205, 25);
		getContentPane().add(txtCantidad);
		txtCantidad.addKeyListener(new KeyAdapter() {
			//validar
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (!Character.isDigit(c)) {
		            e.consume(); 
		            Toolkit.getDefaultToolkit().beep();
		        }
		    }
		});
		JButton btnRegistrar = new JButton("");
		btnRegistrar.setIcon(new ImageIcon(nuevoRegistro.class.getResource("/img/agregar-producto.png")));
		btnRegistrar.setBackground(new Color(153, 255, 51));
		btnRegistrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrarEntrada();
				
			
				
			}
		});
		btnRegistrar.setBounds(134, 528, 50, 40);
		getContentPane().add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(nuevoRegistro.class.getResource("/img/limpieza-de-datos.png")));
		btnLimpiar.setBackground(new Color(204, 51, 0));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnLimpiar.setBounds(41, 528, 50, 40);
		getContentPane().add(btnLimpiar);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEstado.setBounds(26, 236, 125, 14);
		getContentPane().add(lblEstado);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCategora.setBounds(270, 236, 192, 25);
		getContentPane().add(lblCategora);
		
		cboCategoria = new JComboBox(cargarCategoria());
		cboCategoria.setBackground(new Color(255, 255, 255));
		cboCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				seleccionCategoria = (String) 
				cboCategoria.getSelectedItem();
			}
		});
		cboCategoria.setBounds(270, 272, 204, 25);
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"-- Seleccionar --", "Herramienta"}));
		cboCategoria.setModel(cboModelo);
		cboCategoria.setSelectedIndex(-1);
		getContentPane().add(cboCategoria);
		
		
		
		
		cboUnidadMedida = new JComboBox(cargarUnidadMedida());
		cboUnidadMedida.setBackground(new Color(255, 255, 255));
		cboUnidadMedida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionUnidadMedida = (String) 
				cboUnidadMedida.getSelectedItem();
				
			}
		});
		cboUnidadMedida.setBounds(270, 373, 204, 25);
		cboUnidadMedida.setModel(new DefaultComboBoxModel(new String[] {"-- Seleccionar --", "Unidad"}));
		cboUnidadMedida.setModel(cboModelo2);
		cboUnidadMedida.setSelectedIndex(-1);
		
		getContentPane().add(cboUnidadMedida);
		
		JLabel lblRecibidoPor = new JLabel("Recibido por:");
		lblRecibidoPor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblRecibidoPor.setBounds(26, 337, 125, 14);
		getContentPane().add(lblRecibidoPor);
		
		cboPersonal = new JComboBox(cargarPersonal());
		cboPersonal.setBackground(new Color(255, 255, 255));
		cboPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionPersonal = (String) 
				cboPersonal.getSelectedItem();
				
			}
		});
		cboPersonal.setModel(new DefaultComboBoxModel(new String[] {"-- Seleccionar --", "Julian", "Isabel"}));
		cboPersonal.setModel(cboModel2);
		cboPersonal.setSelectedIndex(-1);
		cboPersonal.setBounds(26, 375, 204, 25);
		getContentPane().add(cboPersonal);
		
		
		cboEstado = new JComboBox(new Object[]{});
		cboEstado.setBackground(new Color(255, 255, 255));
		cboEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionEstado = (String) 
				cboEstado.getSelectedItem();
				
			}
		});
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"-- Seleccionar --", "Nuevo", "Bueno", "Usado", "Da\u00F1ado"}));
		cboEstado.setBounds(26, 274, 204, 25);
		getContentPane().add(cboEstado);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1104, 93);
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblNuevoRegistro = new JLabel("NUEVO REGISTRO");
		lblNuevoRegistro.setBounds(28, 32, 289, 36);
		panel.add(lblNuevoRegistro);
		lblNuevoRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoRegistro.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(498, 108, 596, 460);
		getContentPane().add(scrollPane);
		
		tblInventario = new JTable();
		tblInventario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblInventario);
		
		modelo2= new DefaultTableModel();
		
		modelo2.addColumn("CÓDIGO");
		modelo2.addColumn("NOMBRE");
		modelo2.addColumn("CANTIDAD");
		modelo2.addColumn("CATEGORÍA");
		modelo2.addColumn("UBICACIÓN");
		modelo2.addColumn("UNIDAD MEDIDA");
		modelo2.addColumn("ESTADO");
		modelo2.addColumn("PERSONAL");
		
		tblInventario.setModel(modelo2);
		
		JButton btnEntrada = new JButton("");
		btnEntrada.setBackground(new Color(51, 153, 204));
		btnEntrada.setIcon(new ImageIcon(nuevoRegistro.class.getResource("/img/bandeja-de-entrada.png")));
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				entrada entradaFrame= new entrada();
				entradaFrame.setVisible(true);
			}
		});
		btnEntrada.setBounds(232, 528, 50, 40);
		getContentPane().add(btnEntrada);
		
		JButton btnActualizar = new JButton("");
		btnActualizar.setBackground(new Color(255, 255, 51));
		btnActualizar.setIcon(new ImageIcon(nuevoRegistro.class.getResource("/img/reporte.png")));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				itemReporte reporte= new itemReporte();
				reporte.setVisible(true);
			}
		});
		btnActualizar.setBounds(408, 528, 50, 40);
		getContentPane().add(btnActualizar);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarSalida salida= new generarSalida();
				salida.setVisible(true);
				
			}
		});
		button.setBackground(new Color(255, 102, 0));
		button.setIcon(new ImageIcon(nuevoRegistro.class.getResource("/img/flecha.png")));
		button.setBounds(322, 528, 50, 40);
		getContentPane().add(button);
		
		JLabel lblLimpiar = new JLabel("Limpiar");
		lblLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimpiar.setBounds(41, 572, 50, 14);
		getContentPane().add(lblLimpiar);
		
		JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setBounds(124, 572, 72, 14);
		getContentPane().add(lblRegistrar);
		
		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrada.setBounds(232, 572, 50, 14);
		getContentPane().add(lblEntrada);
		
		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalida.setBounds(322, 572, 50, 14);
		getContentPane().add(lblSalida);
		
		JLabel lblActualizar = new JLabel("Reporte");
		lblActualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizar.setBounds(397, 572, 72, 14);
		getContentPane().add(lblActualizar);
		

	}
	
	
	configuracion_categoria categoriasFrame = new configuracion_categoria();
	ArrayList<String> nomCate = categoriasFrame.obtenerNomCate();
	
	DefaultComboBoxModel<String> cboModelo = new DefaultComboBoxModel<>(nomCate.toArray(new String[0]));
	
	personal personalInternal = new personal();
	ArrayList<String> nombrePersonal = personalInternal.obtenerNombrePersonal();
	DefaultComboBoxModel<String> cboModel2 = new DefaultComboBoxModel<>(nombrePersonal.toArray(new String[0]));
	
	configuracion_unidades unidadesMedida = new configuracion_unidades();
	ArrayList<String> nomUni = unidadesMedida.obtenerUnidadMedida();
	
	DefaultComboBoxModel<String> cboModelo2 = new DefaultComboBoxModel<>(nomUni.toArray(new String[0]));
	

	private void limpiar(){
		
		txtCodigo.setText("" + arregloItem.codigoCorrelativo());
		txtNombre.setText("");
		txtCantidad.setText("");
		txtUbicacion.setText("");
		
		/*cboCategoria.setSelectedIndex(-1);
		cboEstado.setSelectedIndex(-1);
		cboPersonal.setSelectedIndex(-1);
		cboUnidadMedida.setSelectedIndex(-1);*/
		
	}
	
	
	
	public void actualizarCantidad(){

	}
	 public void agregarItem() {
	        // Buscar si el ítem ya existe en la lista
	        for (int i=0; i< arregloItem.tamanio(); i++) {
	        	nombre= txtNombre.getText();
	        	Items x= arregloItem.buscar(nombre);
	        	
	        	
	        	
	            if (x!=null ) {
	                // Si el ítem ya existe, sumar la nueva cantidad a la cantidad existente
	                int nuevaCantidad = claseEntrada.getCantidadEntrada() + item.getStock();
	                item.setStock(nuevaCantidad);
	                return; // Terminar el método después de actualizar la cantidad
	            }
	        }

	        // Si el ítem no existe, agregarlo a la lista
	        
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
	
	public static String[] cargarCategoria() {
			  
	        
	     String[] listaCategoria = new String[c.tamanio() + 1];
	  			listaCategoria[0] = "--Seleccionar--";
	  		
	  	for(int i = 0; i < c.tamanio(); i++) 
	  			
	  	{
	  		listaCategoria[i + 1] = c.obtener(i).getNombreCategoria();
	  	}
	  
	  	return listaCategoria;
	  		
	  		
	}
	
	public ArrayList<String> obtenerNomItem() {
	    ArrayList<String> nomItem = new ArrayList<>();
	    for (int i = 0; i < arregloItem.tamanio(); i++) {
	        nomItem.add(arregloItem.obtener(i).getNombre());
	    }
	    return nomItem;
	}
	
	
	public static String[] cargarUnidadMedida() {
		  
        
	     String[] listaUnidadMedida = new String[um.tamanio() + 1];
	  			listaUnidadMedida[0] = "--Seleccionar--";
	  		
	  	for(int i = 0; i < um.tamanio(); i++) 
	  			
	  	{
	  		listaUnidadMedida[i + 1] = um.obtener(i).getNombreMedida();
	  	}
	  
	  	return listaUnidadMedida;
	  		
	  		
	}
	
	   
	   public void cargarProv(){
			for(int i=0; i<c.tamanio();i++){	
				c.obtener(i).getNombreCategoria();
				cboCategoria.getSelectedIndex();
		};
	 }
	   
	   
	 
	   
	   public void registrar(){
		 
		   
		  try {
			  
			   Object[] row = new Object[8];
	        	codigo = Integer.parseInt(txtCodigo.getText());
	            cantidad = Integer.parseInt(txtCantidad.getText());
	            nombre = txtNombre.getText();
	            ubicacion = txtUbicacion.getText();

	            row[0] = codigo;
				row[1] = nombre;
				row[2] = cantidad;
				row [3]= seleccionCategoria;
				row [4]= ubicacion;
				row [5]= seleccionUnidadMedida;
				row [6]= seleccionEstado;
				row [7]= seleccionPersonal;
			  
					modelo2.addRow(row);
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo hacer la tabla");
		}
		   
	
		  
		   
	   }
	   
	   
	   
	   public void RegistrarEntrada() {
		    try {
		        if (validarNombre() && validarEstado() && validarCantidadEntrada() && validarUbicacion()&& validarExistencia()) {
		            codigo = Integer.parseInt(txtCodigo.getText());
		            cantidad = Integer.parseInt(txtCantidad.getText());
		            nombre = txtNombre.getText();
		            ubicacion = txtUbicacion.getText();

		           
		             item = new Items(codigo, nombre, cantidad, ubicacion);
		             arregloItem.adicionar(item);
		            
		             JOptionPane.showMessageDialog(null, "Se han registrado correctamente los datos");
		             registrar();
		             limpiar();
		            }
		        
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(null, "Debe ingresar datos completos");
		    }
		}

	  /*public void sumarItem(){
		  
		   	String nombre= entrada.seleccionItem;
	         Items x = arregloItem.buscar(nombre);

	        if (x != null) {
	        	 JOptionPane.showMessageDialog(null,"Existe un ítem con este nombre: " + nombre);
	        	 int cantidadEntrada = entrada.cantidadEntrada;
	             int stockActual = x.getStock();
	             int nuevoStock = stockActual + cantidadEntrada;
	             JOptionPane.showMessageDialog(null,"Nueva cantidad: " + nuevoStock);
	            /* x.setStock(nuevoStock);
	             arregloItem.adicionar(x);
	             registrar();
	        	
	        }
	   }*/
	   
	  
	  public boolean sumarItem(){
		  
		  try {
			 	String nombre= entrada.seleccionItem;
		         Items x = arregloItem.buscar(nombre);

		        if (x != null) {
		        	 JOptionPane.showMessageDialog(null,"Existe un ítem con este nombre: " + nombre);
		        	 int cantidadEntrada = entrada.cantidadEntrada;
		             int stockActual = x.getStock();
		             nuevoStock = stockActual + cantidadEntrada;
		             
		             nuevoStock = item.getStock();
		            /* JOptionPane.showMessageDialog(null,"Nueva cantidad: " + nuevoStock);
		             x.setStock(nuevoStock);
		             arregloItem.adicionar(x);*/
		            
		        }
		   return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
	        return false;
		}
	        
	       
	   }
	  
	   
		public boolean validarExistencia(){
			try {
				 codigo = Integer.parseInt(txtCodigo.getText());
		          Items x = arregloItem.buscar(codigo);

		        if (x != null) {
		            throw new Exception("Ya existe un ítem con este código: " + codigo);
	                
		        }
		        return true;
		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(this, e.getMessage());
		        return false;
		    }
		}
		
	public boolean validarNombre(){
		 
		 try {
				if(txtNombre.getText().trim().equals(" "))
					throw new Exception("Debe ingresar el nombre del ítem");
					return true;
				
				
			}
			 catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
				return false;
				
			}
	}
	
	public boolean validarCantidadEntrada(){
		try {
			
			if(txtCantidad.getText().equals("")){
				throw new Exception("Debe ingresar una cantidad");
				
			}
			cantidad= Integer.parseInt(txtCantidad.getText());
			if(cantidad == 0){
				throw new Exception("Debe ingresar una cantidad mayor a 0");
				
			}
			return true;
		}
					 catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return false;
			
		}
	}
	
	
	public boolean validarUbicacion(){
		
		try {
			
			if(txtUbicacion.getText().trim().length() <= 3){
				throw new Exception("Debe ingresar una ubicación con 4 dígitos");
				
			}
			if(txtUbicacion.getText().trim().equals("")){
				throw new Exception("Debe ingresar una ubicación");
				
			}
			return true;
		}
			catch (Exception e) {
			
				JOptionPane.showMessageDialog(this, e.getMessage());
			
				return false;
			
		}
		
	}
	public boolean validarEstado() {
	    try {
	       
	        if (seleccionEstado==null) {
	            throw new Exception("Debe seleccionar un estado");
	        }
	        
	        return true;
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, e.getMessage());
	        return false;
	    }
	
	}
	
	
	
	
}
