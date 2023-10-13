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
import clases.UnidadMedida;

import arreglos.ArregloUnidadMedida;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class configuracion_unidades extends JInternalFrame {
	private JTextField txtUnidadesMedida;
	private JTextField txtBuscarPorNombre;
	private JTable tblReporteUnidadesMedida;
	private DefaultTableModel modelo;
	private UnidadMedida uniMedida;
	public static ArregloUnidadMedida um= new ArregloUnidadMedida();
	private JTextField txtId;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					configuracion_unidades frame = new configuracion_unidades();
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
	public configuracion_unidades() {
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
		
		JButton btnNuevaUnidadDeMedida = new JButton("Nueva");
		btnNuevaUnidadDeMedida.setIcon(null);
		btnNuevaUnidadDeMedida.setForeground(new Color(255, 255, 255));
		btnNuevaUnidadDeMedida.setBackground(new Color(255, 153, 0));
		btnNuevaUnidadDeMedida.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnNuevaUnidadDeMedida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String categoria= txtUnidadesMedida.getText();
				//lblId.setText(String.valueOf(contador));
				txtUnidadesMedida.setEnabled(true);
				txtUnidadesMedida.requestFocus();
			}
		});
		btnNuevaUnidadDeMedida.setBounds(217, 73, 80, 34);
		panel.add(btnNuevaUnidadDeMedida);
		
		JLabel lblUnidadMedida = new JLabel("UNIDAD DE MEDIDA");
		lblUnidadMedida.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblUnidadMedida.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnidadMedida.setBounds(10, 117, 146, 22);
		panel.add(lblUnidadMedida);
		
		txtUnidadesMedida = new JTextField();
		txtUnidadesMedida.setBackground(new Color(255, 255, 240));
		txtUnidadesMedida.setBounds(10, 149, 301, 23);
		panel.add(txtUnidadesMedida);
		txtUnidadesMedida.setColumns(10);
		txtUnidadesMedida.setEnabled(false);
		txtUnidadesMedida.addKeyListener(new KeyAdapter() {
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
				txtUnidadesMedida.setEnabled(false);
			
				
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
		btnModificar.setBounds(56, 305, 90, 22);
		panel.add(btnModificar);
		
		JLabel lblRegistroDeUnidadesDeMedida = new JLabel("Registro de Unidades de Medida");
		lblRegistroDeUnidadesDeMedida.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeUnidadesDeMedida.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblRegistroDeUnidadesDeMedida.setBounds(27, 23, 270, 22);
		panel.add(lblRegistroDeUnidadesDeMedida);
		
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
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(183, 305, 90, 23);
		panel.add(btnEliminar);
		btnEliminar.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				eliminar();
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(358, 65, 447, 353);
		getContentPane().add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel lblListaDeUnidadesDeMedida = new JLabel("Lista de Unidades de Medida");
		lblListaDeUnidadesDeMedida.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeUnidadesDeMedida.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblListaDeUnidadesDeMedida.setBounds(88, 19, 270, 22);
		panel_1.add(lblListaDeUnidadesDeMedida);
		
		txtBuscarPorNombre = new JTextField();
		txtBuscarPorNombre.setBackground(new Color(255, 255, 240));
		txtBuscarPorNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtBuscarPorNombre.setBounds(10, 52, 347, 22);
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
		
		tblReporteUnidadesMedida = new JTable();
		tblReporteUnidadesMedida.setBorder(null);
		tblReporteUnidadesMedida.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		tblReporteUnidadesMedida.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblReporteUnidadesMedida);
		
		modelo= new DefaultTableModel();
		
		modelo.addColumn("ID");
		modelo.addColumn("UNIDAD DE MEDIDA");
		
		tblReporteUnidadesMedida.setModel(modelo);
		
		JButton button = new JButton("\uD83D\uDD0E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String terminoBusqueda= txtBuscarPorNombre.getText();
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
				String categoria= txtUnidadesMedida.getText();
				UnidadMedida cate= new UnidadMedida(um.codigoCorrelativo(), categoria);
				um.adicionar(cate);
				listar();
				JOptionPane.showMessageDialog(null, "Nueva unidad de medida agregada");
				limpiar();	
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	public void listar(){
		modelo.setRowCount(0);
			for(int i=0; i<um.tamanio(); i++){
				Object[] fila= {
						um.obtener(i).getIdUnidadMedida(),
						um.obtener(i).getNombreMedida(),
				};
				modelo.addRow(fila);
			}
		
	}
	
	public void limpiar(){
		txtUnidadesMedida.setText("");
		txtId.setText("");
	}
	
	public boolean validarTexto(){
		try {
			if(txtUnidadesMedida.getText().trim().equals(""))
				throw new Exception("Ingresar nombre de unidad de medida");
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
				throw new Exception("Ingresar ID");
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
	    for (int i = 0; i < um.tamanio(); i++) {
	        nomCate.add(um.obtener(i).getNombreMedida());
	    }
	    return nomCate;
	}
	
	//BUSCADOR 
	private void buscarEnTabla(String terminoBusqueda) {
		
		//TableRowSorter : para ordenar y filtrar filas en una tabla.
		
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblReporteUnidadesMedida.setRowSorter(sorter);
        
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
					String nombre= txtUnidadesMedida.getText();
					
					uniMedida= new UnidadMedida(codigo, nombre);
					
					UnidadMedida x= um.buscar(codigo);
					
					if(x != null){
						JOptionPane.showMessageDialog(null, "La unidad de medida con código: " +codigo +" fue eliminado");
						um.eliminar(x);
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
				String nombre= txtUnidadesMedida.getText();
				UnidadMedida x= um.buscar(codigo);
				
				if(nombre.length()==0){
					JOptionPane.showMessageDialog(null,"Ingresar el nombre de la unidad a modificar");
					txtUnidadesMedida.requestFocus();
				}
				else if (x == null){
					JOptionPane.showMessageDialog(null, "El código ingresado NO existe" );
					limpiar();
				}else{
					x.setNombreMedida(nombre);
					JOptionPane.showMessageDialog(null, "La Unidad de Medida con código " + codigo +" fue modificada");
			        listar();
					limpiar();
					}
					
				}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<String> obtenerUnidadMedida() {
	    ArrayList<String> nomUni = new ArrayList<>();
	    for (int i = 0; i < um.tamanio(); i++) {
	        nomUni.add(um.obtener(i).getNombreMedida());
	    }
	    return nomUni;
	}
	
	
}
