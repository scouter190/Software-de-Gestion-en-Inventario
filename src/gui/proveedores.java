package gui;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import arreglos.ArregloProveedores;
import arreglos.ArregloItems;
import clases.Proveedor;
import clases.UnidadMedida;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import gui.entradasi;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class proveedores extends JInternalFrame {
	private JTextField txtBuscarProveedores;
	private JTable tblPro;
	private DefaultTableModel tablaPro;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField txtIdProv;
	private JTextField txtRuc;
	public JTextField txtRazonSocial;
	public static ArregloProveedores arregloProveedores = new ArregloProveedores();
	public static Proveedor provedor;
	private JLabel lblIngresarId;
	private JTextField txtId;
	private JPanel panel_1;
	private JLabel lblNuevoRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proveedores frame = new proveedores();
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
	public proveedores() {
		getContentPane().setBackground(Color.WHITE);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 905, 606);
		getContentPane().setLayout(null);
		
		txtBuscarProveedores = new JTextField();
		txtBuscarProveedores.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtBuscarProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String terminoBusqueda = txtBuscarProveedores.getText();
	              buscarEnTabla(terminoBusqueda);
			
			}
		});
		txtBuscarProveedores.setBounds(331, 150, 459, 30);
		getContentPane().add(txtBuscarProveedores);
		txtBuscarProveedores.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 201, 548, 239);
		getContentPane().add(scrollPane);
		
		tblPro = new JTable();
		tblPro.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPro);
		
		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(proveedores.class.getResource("/img/agregar (1).png")));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdProv.setEnabled(true);
			    txtRuc.setEnabled(true);
			    txtRazonSocial.setEnabled(true);
			}
		});
		btnNuevo.setBounds(253, 146, 50, 30);
		getContentPane().add(btnNuevo);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(proveedores.class.getResource("/img/lupa.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String terminoBusqueda= txtBuscarProveedores.getText();
				buscarEnTabla(terminoBusqueda);
			}
		});
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		
		btnBuscar.setBounds(800, 151, 75, 30);
		getContentPane().add(btnBuscar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBorder(null);
		panel.setBounds(34, 185, 269, 336);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("ID");
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label.setBounds(32, 40, 46, 14);
		panel.add(label);
		
		txtIdProv = new JTextField();
		txtIdProv.setEnabled(false);
		txtIdProv.setBackground(Color.WHITE);
		txtIdProv.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtIdProv.setColumns(10);
		txtIdProv.setBounds(57, 71, 155, 20);
		txtIdProv.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (!Character.isDigit(c)) {
		            e.consume(); // Ignora el carácter si es un número
		            Toolkit.getDefaultToolkit().beep();
		        }
		    }
		});
		panel.add(txtIdProv);
		
		JLabel label_1 = new JLabel("RUC");
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_1.setBounds(32, 110, 46, 14);
		panel.add(label_1);
		
		txtRuc = new JTextField();
		txtRuc.setBackground(Color.WHITE);
		txtRuc.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtRuc.setEnabled(false);
		txtRuc.setColumns(10);
		txtRuc.setBounds(57, 141, 155, 20);
		txtRuc.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (!Character.isDigit(c)) {
		            e.consume(); // Ignora el carácter si es un número
		            Toolkit.getDefaultToolkit().beep();
		        }
		        if(txtRuc.getText().length()>=11){
		        	 e.consume();
		        }
		    }
		});
		panel.add(txtRuc);
		
		JLabel label_2 = new JLabel("Raz\u00F3n Social");
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_2.setBounds(32, 180, 86, 14);
		panel.add(label_2);
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setBackground(Color.WHITE);
		txtRazonSocial.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtRazonSocial.setEnabled(false);
		txtRazonSocial.setColumns(10);
		txtRazonSocial.setBounds(57, 211, 155, 20);
		txtRazonSocial.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (Character.isDigit(c)) {
		            e.consume(); // Ignora el carácter si es un número
		            Toolkit.getDefaultToolkit().beep();
		        }
		    }
		});
		panel.add(txtRazonSocial);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(775, 517, 100, 30);
		getContentPane().add(btnEliminar);
		
		tablaPro = new DefaultTableModel();
		tablaPro.addColumn("Id");
		tablaPro.addColumn("Ruc");
		tablaPro.addColumn("Razón Social");
		
		tblPro.setModel(tablaPro);
		

		
		listar();
		txtIdProv.setText("" + arregloProveedores.codigoCorrelativo());
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(141, 272, 100, 30);
		panel.add(btnGuardar);
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(32, 272, 100, 30);
		panel.add(btnModificar);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
		}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adicionar();
			
                  
				
			}
		});
		
		lblIngresarId = new JLabel("Ingresar ID:");
		lblIngresarId.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblIngresarId.setBounds(563, 482, 119, 18);
		getContentPane().add(lblIngresarId);
		
		txtId = new JTextField();
		txtId.setBounds(665, 476, 210, 24);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 0, 905, 84);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProveedores = new JLabel("REGISTRO DE PROVEEDORES");
		lblProveedores.setForeground(Color.WHITE);
		lblProveedores.setBounds(40, 32, 307, 24);
		panel_1.add(lblProveedores);
		lblProveedores.setHorizontalAlignment(SwingConstants.LEFT);
		lblProveedores.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		
		lblNuevoRegistro = new JLabel("Nuevo Registro");
		lblNuevoRegistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNuevoRegistro.setBounds(54, 148, 141, 29);
		getContentPane().add(lblNuevoRegistro);
		
	}

		public ArrayList<String> obtenerRazonesSociales() {
		    ArrayList<String> razonesSociales = new ArrayList<>();
		    for (int i = 0; i < arregloProveedores.tamanio(); i++) {
		        razonesSociales.add(arregloProveedores.obtener(i).getRazonSocial());
		    }
		    return razonesSociales;
		}
		
		public void listar(){
			tablaPro.setRowCount(0);
			for(int i=0; i<arregloProveedores.tamanio();i++){
				Object [] fila ={
						arregloProveedores.obtener(i).getId(),
						arregloProveedores.obtener(i).getRuc(),
						arregloProveedores.obtener(i).getRazonSocial(),
				};
			tablaPro.addRow(fila);
			}
		}
		
	
		private void adicionar(){
			try{
				int id = leerId();
				String ruc = leerRuc();
				String razonS = leerRazonSocial();
				if(arregloProveedores.buscar(id)!= null)
					throw new Exception("Ya existe un Proveedor con ese Id");
				if(ruc.length()== 0)
					throw new Exception("Debe ingresar el Ruc del Proveedor.");
				if(ruc.length()<= 10)
					throw new Exception("Debe ingresar 11 caracteres en el RUC.");
				if(razonS.length()== 0)
					throw new Exception("Debe ingresar Razón Social del Proveedor.");
				if (id <= 0 || ruc.isEmpty() || razonS.isEmpty()) 
		            throw new Exception("Llene los campos");
				else {
					JOptionPane.showMessageDialog(null, "Proveedor registrado");
				}
		       
				
		        Proveedor proveedor = new Proveedor(id, ruc, razonS);
		        arregloProveedores.adicionar(proveedor);
		        //agregar al combobox
		        entradasi entrada= new entradasi();
		        String razonSocial = txtRazonSocial.getText();
		        entrada.cboProveedor.addItem(razonSocial);
		        
		        listar();
		        limpiarFormulario();
			}
			
			catch (Exception ex){
				mostrarMensaje(ex.getMessage());
			}
			}
		
		
		
		public boolean validarId(){
			try {
				if(txtId.getText().trim().equals(""))
					throw new Exception("Ingresar ID");
					txtId.requestFocus();
					return true;
			
			}
			 catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
				return false;
				
			}
			
		}
		
		public void eliminar(){
			 try {
					if(validarId()){
						int codigo= Integer.parseInt(txtId.getText());
						String razonSocial= txtRazonSocial.getText();
						String ruc= txtRuc.getText();
						provedor= new Proveedor(codigo, ruc, razonSocial);
						
						Proveedor x= arregloProveedores.buscar(codigo);
						
						if(x != null){
							JOptionPane.showMessageDialog(null, "El proveedor con código: " +codigo +" fue eliminado");
							arregloProveedores.eliminar(x);
					        listar();
							limpiarFormulario();
						}
						else{
							JOptionPane.showMessageDialog(null, "El código ingresado NO existe" );
							limpiarFormulario();
						}
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
		}
		public void modificar(){
			try {
				int id = leerId();
				
				String ruc = leerRuc();
				String razonSocial = leerRazonSocial();
				if(txtIdProv.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null,"Debe ingresar un ID");
					txtIdProv.requestFocus();
				}
				else if(ruc.length()== 0){
					JOptionPane.showMessageDialog(null,"Debe ingresar el Ruc del Proveedor.");
				}
				else if(ruc.length()<= 10){
					JOptionPane.showMessageDialog(null,"Debe ingresar 11 caracteres en el RUC.");
				}
				else if(razonSocial.length()== 0){
					JOptionPane.showMessageDialog(null,"Debe ingresar Razón Social del Proveedor.");
				}
				
				else {
					
					Proveedor x = arregloProveedores.buscar(id);
					if(x != null) {
				
						x.setId(id);
						x.setRuc(ruc);
						x.setRazonSocial(razonSocial);
						listar();
						JOptionPane.showMessageDialog(null, "Proveedor modificado");
						limpiarFormulario();
					}
					else if(x == null){
						JOptionPane.showMessageDialog(null, "No se encontró un proveedor para modificar");
						limpiarFormulario();
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		private void buscarEnTabla(String terminoBusqueda) {
			
			//TableRowSorter : para ordenar y filtrar filas en una tabla.
			
	        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tablaPro);
	        tblPro.setRowSorter(sorter);
	        
	        if (terminoBusqueda.trim().length() == 0) {
	            sorter.setRowFilter(null);
	        } else {
	            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + terminoBusqueda));
	        }
	        
	    }
		
		
		private void limpiarFormulario(){
			txtIdProv.setText("");
			txtRuc.setText("");
			txtRazonSocial.setText("");
			txtId.setText("");
			txtIdProv.setText("" + arregloProveedores.codigoCorrelativo());
			txtRuc.requestFocus();
		}
		
		private void mostrarMensaje(String mensaje){
			JOptionPane.showMessageDialog(this, mensaje, "Información", 0);
		}
		
		private int leerId(){
			return Integer.parseInt(txtIdProv.getText().trim());
			
		}
		
		private String leerRuc(){
			return txtRuc.getText().trim();
			
		}
		
		private String leerRazonSocial(){
			return txtRazonSocial.getText().trim();
			
		}
		
		
		
		
		
		
		
		
		
}