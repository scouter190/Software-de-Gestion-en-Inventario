package gui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import arreglos.ArregloPersonal;
import clases.Personal;
import clases.Proveedor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class personal extends JInternalFrame {
	public JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtBuscar;
	private JTable tblPersonal;
	private DefaultTableModel moPer;
	private JTextField txtCodigo;
	public static Personal personal;
	public static ArregloPersonal per = new ArregloPersonal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personal frame = new personal();
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
	public personal() {
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 946, 574);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(29, 162, 339, 348);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(27, 104, 126, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblApellido.setBackground(Color.WHITE);
		lblApellido.setBounds(27, 151, 126, 14);
		panel.add(lblApellido);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblTelfono.setBackground(Color.WHITE);
		lblTelfono.setBounds(27, 203, 126, 14);
		panel.add(lblTelfono);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtNombre.setBackground(Color.WHITE);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

		        if (Character.isDigit(c)) {
		            e.consume(); 
		            Toolkit.getDefaultToolkit().beep();
		        }
			}
		});
		txtNombre.setBounds(163, 105, 152, 20);
		panel.add(txtNombre);
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtApellido.setBackground(Color.WHITE);
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

		        if (Character.isDigit(c)) {
		            e.consume(); 
		            Toolkit.getDefaultToolkit().beep();
		        }
			}
		});
		txtApellido.setBounds(163, 152, 152, 20);
		panel.add(txtApellido);
		txtApellido.setEnabled(false);
		txtApellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyTyped(KeyEvent e) {
				char c =e.getKeyChar();
				
				   if (!Character.isDigit(c)) {
			            e.consume(); 
			            Toolkit.getDefaultToolkit().beep();
			        }
				   if(txtTelefono.getText().length()>=9){
					   e.consume();
				   }
			}
		});
		txtTelefono.setBounds(163, 204, 152, 20);
		panel.add(txtTelefono);
	    txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnGuardar.setBounds(62, 268, 100, 23);
		panel.add(btnGuardar);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCdigo.setBackground(Color.WHITE);
		lblCdigo.setBounds(27, 57, 126, 21);
		panel.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(163, 58, 152, 20);
		panel.add(txtCodigo);
		txtCodigo.setEnabled(false);
		txtCodigo.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(389, 90, 567, 319);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtBuscar.setBackground(Color.WHITE);
		txtBuscar.setBounds(27, 38, 438, 30);
		panel_1.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 78, 516, 219);
		panel_1.add(scrollPane);
		
		tblPersonal = new JTable();
		tblPersonal.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPersonal);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(826, 461, 110, 23);
		getContentPane().add(btnEliminar);
		
		moPer = new DefaultTableModel();
		moPer.addColumn("ID");
		moPer.addColumn("NOMBRE");
		moPer.addColumn("APELLIDO");
		moPer.addColumn("TELÉFONO");
		
		tblPersonal.setModel(moPer);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String terminoBusqueda= txtBuscar.getText();
				buscarEnTabla(terminoBusqueda);
				
			}
		});
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setIcon(new ImageIcon(personal.class.getResource("/img/lupa.png")));
		btnBuscar.setBounds(475, 38, 68, 30);
		panel_1.add(btnBuscar);
		
		listar();
		
		txtCodigo.setText("" + per.codigoCorrelativo());
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(0, 0, 946, 60);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblPersonal = new JLabel("PERSONAL");
		lblPersonal.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblPersonal.setForeground(Color.WHITE);
		lblPersonal.setBounds(35, 11, 236, 38);
		panel_2.add(lblPersonal);
		
		txtCodigo.setText("" + per.codigoCorrelativo());
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(177, 268, 100, 23);
		panel.add(btnModificar);
		btnModificar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnModificar.setBackground(Color.WHITE);
		
		JLabel lblRegistroPersonal = new JLabel("Nuevo Registro");
		lblRegistroPersonal.setBounds(41, 123, 126, 14);
		getContentPane().add(lblRegistroPersonal);
		lblRegistroPersonal.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblRegistroPersonal.setBackground(Color.WHITE);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.setBounds(305, 107, 50, 30);
		getContentPane().add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(personal.class.getResource("/img/agregar (1).png")));
		btnNuevo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnNuevo.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("Ingresar ID:");
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label.setBounds(624, 436, 119, 18);
		getContentPane().add(label);
		
		txtEliminar = new JTextField();
		txtEliminar.setColumns(10);
		txtEliminar.setBounds(726, 430, 210, 24);
		getContentPane().add(txtEliminar);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCodigo.setEnabled(true);
			    txtNombre.setEnabled(true);
			    txtNombre.requestFocus();
			    txtApellido.setEnabled(true);
			    txtTelefono.setEnabled(true);
			}
		});
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});

	}
	
		private JLabel lblPersonal;
		private JTextField txtEliminar;
		
		public ArrayList<String> obtenerNombrePersonal() { //puso nompre en el nombre
		    ArrayList<String> nombrePersonal = new ArrayList<>();
		    for (int i = 0; i < per.tamanio(); i++) {
		        nombrePersonal.add(per.obtener(i).getNombre());
		    }
		    return nombrePersonal;
		}
		
		public void listar(){
			moPer.setRowCount(0);
			
			for (int i = 0; i < per.tamanio(); i++) {
				Object [] fila={
						per.obtener(i).getCodigo(),
						per.obtener(i).getNombre(),
						per.obtener(i).getApellido(),
						per.obtener(i).getTelefono()
				};
			moPer.addRow(fila);
			}
		}
		
		private void adicionar() {
		    try {
		        int codigo = leerCodigo();
		        String nombre = leerNombre();
		        String apellido = leerApellido();
		 

		        if (per.buscar(codigo) != null) {
		        	JOptionPane.showMessageDialog(null,"Ya existe un Personal con ese Código");
		        	limpiarFormulario();
		        }
		        else if(txtCodigo.getText().trim().equals("")){
			    	 JOptionPane.showMessageDialog(null, "Debe ingresar un código");
			    	 txtCodigo.requestFocus();
			     }
		        else if (nombre.length() == 0) {
		            JOptionPane.showMessageDialog(null,"Debe ingresar el Nombre del Personal.");
		            txtNombre.requestFocus();
		        }
		        else if (apellido.length() == 0) {
		        	JOptionPane.showMessageDialog(null,"Debe ingresar Apellido del Personal.");
		        	txtApellido.requestFocus();
		        }
		        else if (txtTelefono.getText().trim().equals("")) {
			    	 JOptionPane.showMessageDialog(null,"Debe ingresar Teléfono del Personal.");
			    	 txtTelefono.requestFocus();
			     }
		        else if (txtTelefono.getText().trim().length()<=8) {
			    	 JOptionPane.showMessageDialog(null,"Debe ingresar un teléfono de 9 dígitos");
			    	 txtTelefono.requestFocus();
			     }
			     else{
			    	 JOptionPane.showMessageDialog(null,"Personal Registrado");
			    	 int telefono = leerTelefono();

				        Personal personal = new Personal(codigo, nombre, apellido, telefono);
				        per.adicionar(personal);
				        
				      
				        //agregar al combobox
				        entradasi entrada= new entradasi();
				       String nombrePer= txtNombre.getText();
				        entrada.cboPersonal.addItem(nombrePer);

				        listar();
				        limpiarFormulario();
			     }
		       
		    } catch (Exception ex) {
		       
		    }
		}

		

		
		public void modificar(){
			try {
				
				String nombre = leerNombre();
				String apellido = leerApellido();
				
				 if(txtCodigo.getText().trim().equals("")){
			    	 JOptionPane.showMessageDialog(null, "Debe ingresar un código");
			    	 txtCodigo.requestFocus();
			     }
			     else if (nombre.length() == 0) {
			    	 JOptionPane.showMessageDialog(null,"Debe ingresar el Nombre del Personal.");
			    	 txtNombre.requestFocus();
			     }
			     else if (apellido.length() == 0) {
			    	 JOptionPane.showMessageDialog(null,"Debe ingresar Apellido del Personal.");
			    	 txtApellido.requestFocus();
			     }
			     else if (txtTelefono.getText().trim().equals("")) {
			    	 JOptionPane.showMessageDialog(null,"Debe ingresar Teléfono del Personal.");
			    	 txtTelefono.requestFocus();
			     }
			     else if (txtTelefono.getText().trim().length()<=8) {
			    	 JOptionPane.showMessageDialog(null,"Debe ingresar un teléfono de 9 dígitos");
			    	 txtTelefono.requestFocus();
			     }
				else {
					int codigo = leerCodigo();
					int telefono = leerTelefono();
					Personal x = per.buscar(codigo);
					
					if(x != null) {
				
						x.setCodigo(codigo);
						x.setNombre(nombre);
						x.setApellido(apellido);
						x.setTelefono(telefono);
						listar();
						JOptionPane.showMessageDialog(null, "Personal modificado");
						limpiarFormulario();
					}
					else if(x == null){
						JOptionPane.showMessageDialog(null, "No se encontró un personal para modificar");
						limpiarFormulario();
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		private void limpiarFormulario(){
			txtNombre.setText("");
			txtApellido.setText("");
			txtTelefono.setText("");
			txtCodigo.setText("" + per.codigoCorrelativo());
			txtNombre.requestFocus();
			
		}
		
		
		public boolean validarId(){
			try {
				if(txtCodigo.getText().trim().equals(""))
					throw new Exception("Ingresar ID");
					txtCodigo.requestFocus();
					return true;
			
			}
			 catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
				return false;
				
			}
			
		}
		
		public void eliminar() {
		    
		    try {
				if(validarId()){
					int codigo = Integer.parseInt(txtEliminar.getText().trim());;
				    
				    Personal x = per.buscar(codigo);
						    
					if(x != null){
						JOptionPane.showMessageDialog(null, "El personal con código: " +codigo +" fue eliminado");
						per.eliminar(x);
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
		
		private void buscarEnTabla(String terminoBusqueda) {
			
			//TableRowSorter : para ordenar y filtrar filas en una tabla.
			
	        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(moPer);
	        tblPersonal.setRowSorter(sorter);
	        
	        if (terminoBusqueda.trim().length() == 0) {
	            sorter.setRowFilter(null);
	        } else {
	            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + terminoBusqueda));
	        }
	        
	    }
		
		private int leerCodigo(){
			return Integer.parseInt(txtCodigo.getText().trim());
		}
		private String leerNombre(){
			return txtNombre.getText().trim();
			
		}
		private String leerApellido(){
			return txtApellido.getText().trim();
			
		}
		private int leerTelefono(){
			return Integer.parseInt(txtTelefono.getText().trim());
			
		}
}

