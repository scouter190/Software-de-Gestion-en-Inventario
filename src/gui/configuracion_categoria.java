package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.BorderLayout;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import clases.Categoria;
import clases.Proveedor;
import arreglos.ArregloCategoria;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class configuracion_categoria extends JInternalFrame {
	private JTextField txtCategoria;
	private JTextField txtBuscarPorNombre;
	private JTable tblReporteCategoria;
	private DefaultTableModel modelo;
	private Categoria cate;
	public static ArregloCategoria c= new ArregloCategoria();
	private JTextField txtId;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					configuracion_categoria frame = new configuracion_categoria();
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
	public configuracion_categoria() {
		
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 815, 528);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 65, 321, 353);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNuevaCategoria = new JButton("Nueva");
		btnNuevaCategoria.setIcon(null);
		btnNuevaCategoria.setForeground(new Color(255, 255, 255));
		btnNuevaCategoria.setBackground(new Color(255, 153, 0));
		btnNuevaCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnNuevaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String categoria= txtCategoria.getText();
				//lblId.setText(String.valueOf(contador));
				txtCategoria.setEnabled(true);
				txtCategoria.requestFocus();
			}
		});
		btnNuevaCategoria.setBounds(217, 73, 80, 34);
		panel.add(btnNuevaCategoria);
		
		JLabel lblCategoria2 = new JLabel("CATEGOR\u00CDA");
		lblCategoria2.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblCategoria2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategoria2.setBounds(10, 117, 146, 22);
		panel.add(lblCategoria2);
		
		txtCategoria = new JTextField();
		txtCategoria.setBackground(new Color(255, 255, 240));
		txtCategoria.setBounds(10, 149, 301, 23);
		panel.add(txtCategoria);
		txtCategoria.setColumns(10);
		txtCategoria.setEnabled(false);
		txtCategoria.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (Character.isDigit(c)) {
		            e.consume(); // Ignora el carácter si es un número
		            Toolkit.getDefaultToolkit().beep();
		        }
		    }
		});
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnGuardar.setBounds(9, 184, 90, 22);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionar();
				txtCategoria.setEnabled(false);
			//	agregarCategoria();
				
			}
		});
		panel.add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBackground(Color.WHITE);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
				
			}
		});
		btnModificar.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnModificar.setBounds(66, 305, 90, 22);
		panel.add(btnModificar);
		
		JLabel lblRegistroDeCategora = new JLabel("Registro de Categor\u00EDa");
		lblRegistroDeCategora.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeCategora.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblRegistroDeCategora.setBounds(27, 23, 270, 22);
		panel.add(lblRegistroDeCategora);
		
		JLabel lblIngresarId = new JLabel("Ingresar ID");
		lblIngresarId.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblIngresarId.setBounds(10, 230, 146, 22);
		panel.add(lblIngresarId);
		
		txtId = new JTextField();
		txtId.setBounds(13, 261, 298, 22);
		panel.add(txtId);
		txtId.setColumns(10);
		txtId.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (!Character.isDigit(c)) {
		            e.consume(); 
		            Toolkit.getDefaultToolkit().beep();
		        }
		    }
		});
		
		JButton btnXlimpiarBarra = new JButton("Eliminar");
		btnXlimpiarBarra.setBackground(Color.WHITE);
		btnXlimpiarBarra.setBounds(198, 305, 90, 23);
		panel.add(btnXlimpiarBarra);
		btnXlimpiarBarra.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnXlimpiarBarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				eliminar();
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(358, 65, 447, 353);
		getContentPane().add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel lblListaDeCategora = new JLabel("Lista de Categor\u00EDa");
		lblListaDeCategora.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeCategora.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblListaDeCategora.setBounds(88, 19, 270, 22);
		panel_1.add(lblListaDeCategora);
		
		txtBuscarPorNombre = new JTextField();
		txtBuscarPorNombre.setBackground(new Color(255, 255, 240));
		txtBuscarPorNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtBuscarPorNombre.setBounds(10, 52, 353, 22);
		panel_1.add(txtBuscarPorNombre);
		txtBuscarPorNombre.setColumns(10);
		txtBuscarPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  String terminoBusqueda = txtBuscarPorNombre.getText();
	              buscarEnTabla(terminoBusqueda);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 427, 221);
		panel_1.add(scrollPane);
		
		tblReporteCategoria = new JTable();
		tblReporteCategoria.setBorder(null);
		tblReporteCategoria.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		tblReporteCategoria.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblReporteCategoria);
		
		modelo= new DefaultTableModel();
		
		modelo.addColumn("ID");
		modelo.addColumn("CATEGORÍA");
		
		tblReporteCategoria.setModel(modelo);
		
		JButton button = new JButton("\uD83D\uDD0E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String terminoBusqueda = txtBuscarPorNombre.getText();
	             buscarEnTabla(terminoBusqueda);
			}
		});
		button.setBounds(378, 52, 59, 23);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 0));
		panel_2.setBounds(10, 30, 795, 15);
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 153, 0));
		panel_3.setBounds(10, 449, 795, 15);
		getContentPane().add(panel_3);
	
		listar();
	}

	public void adicionar(){
		try {
			if(validarTexto()){
				String categoria= txtCategoria.getText();
				Categoria cate= new Categoria(c.codigoCorrelativo(), categoria);
				c.adicionar(cate);
				listar();
				JOptionPane.showMessageDialog(null, "Nueva categoría agregada");
				limpiar();	
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	public void listar(){
		modelo.setRowCount(0);
			for(int i=0; i<c.tamanio(); i++){
				Object[] fila= {
						c.obtener(i).getIdCategoria(),
						c.obtener(i).getNombreCategoria(),
				};
				modelo.addRow(fila);
			}
		
	}
	
	public void limpiar(){
		txtCategoria.setText("");
		txtId.setText("");
	}
	
	public boolean validarTexto(){
		try {
			if(txtCategoria.getText().trim().equals(""))
				throw new Exception("Ingresar nombre de categoría");
				return true;
			
			
		}
		 catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return false;
			
		}
		
	}
	public boolean validarId(){
		try {
			if(txtId.getText().trim().equals(""))
				JOptionPane.showMessageDialog(null,"Ingresar ID");
				txtId.requestFocus();
				return true;
		
		}
		 catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return false;
			
		}
		
	}
	
	public ArrayList<String> obtenerNomCate() {
	    ArrayList<String> nomCate = new ArrayList<>();
	    for (int i = 0; i < c.tamanio(); i++) {
	        nomCate.add(c.obtener(i).getNombreCategoria());
	    }
	    return nomCate;
	}
	
	//BUSCADOR 
	private void buscarEnTabla(String terminoBusqueda) {
		
		//TableRowSorter : para ordenar y filtrar filas en una tabla.
		
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblReporteCategoria.setRowSorter(sorter);
        
        if (terminoBusqueda.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + terminoBusqueda));
        }
        
    }
	
	
	
	
	public void eliminar(){
		 try {
				if(validarId()){
					int codigo= Integer.parseInt(txtId.getText());
					String nombre= txtCategoria.getText();
					
					cate= new Categoria(codigo, nombre);
					
					Categoria x= c.buscar(codigo);
					
					if(x != null){
						JOptionPane.showMessageDialog(null, "La categoría con código: " +codigo +" fue eliminada");
						c.eliminar(x);
				        listar();
						limpiar();
					}
					else{
						JOptionPane.showMessageDialog(null, "El código ingresado NO existe" );
						limpiar();
					}
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	public void modificar(){
		try {
				if(validarId()){
					int codigo= Integer.parseInt(txtId.getText());
					String nombre= txtCategoria.getText();
					
					Categoria x= c.buscar(codigo);
					
					if(nombre.length()==0){
						JOptionPane.showMessageDialog(null,"Ingresar el nombre de la Categoria a modificar");
						txtCategoria.requestFocus();
						
					}else if (x == null){
						JOptionPane.showMessageDialog(null, "El código ingresado NO existe" );
						limpiar();
						
					}else{
						x.setNombreCategoria(nombre);
						JOptionPane.showMessageDialog(null, "La Categoria con código " + codigo +" fue modificada");
				        listar();
						limpiar();
						}
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	
	}
	
	
}
