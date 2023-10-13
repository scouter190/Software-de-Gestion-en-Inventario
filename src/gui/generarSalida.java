package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
//calendario 
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.awt.FlowLayout;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloItems;
import arreglos.ArregloPersonal;
import arreglos.ArregloSalida;
import clases.Entrada;
import clases.Items;
import clases.Salida;

import java.awt.Color;
import java.awt.Window.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import gui.salidas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class generarSalida extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFecha;
	Calendar fecha= new GregorianCalendar();
	String anio=Integer.toString(fecha.get(Calendar.YEAR));
	String mes=Integer.toString(fecha.get(Calendar.MONTH)+1);
	String dia=Integer.toString(fecha.get(Calendar.DATE));
	String fechaCompleta= anio+"-"+mes+"-"+dia;
	
	String hora=Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
	String minutos=Integer.toString(fecha.get(Calendar.MINUTE));
	String horaActual= hora + ":"+ minutos;

	private LocalDateTime fechaHora;
	private JComboBox cboMaquinaDestino;
	public JComboBox <String> cboItem;
	public JComboBox <String> cboPersonal;
	private DefaultTableModel modelo;
	public static ArregloItems arregloItem= new ArregloItems();
	public static ArregloPersonal ap = new ArregloPersonal();
	public static ArregloSalida as= new ArregloSalida();
	
	public static String seleccionItem= "";
	public static String seleccionPersonal= "";
	public static String seleccionProveedor= "";
	public static String seleccionMaquina= "";

	salidas salida= new salidas();

	private JTextField txtCantidad;
	private JTextField txtNroOrdenSalida;
	private int codigoSalida=0;
	public static int cantidadSalida=0;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JButton btnImprimir;
	private JTextArea txtReporte;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			generarSalida dialog = new generarSalida();
			dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public generarSalida() {
		setType(Type.UTILITY);
		
		setBounds(350, 40, 622, 654);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 677, 83);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblOrdenDeSalida = new JLabel("ORDEN DE SALIDA");
		lblOrdenDeSalida.setForeground(Color.WHITE);
		lblOrdenDeSalida.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblOrdenDeSalida.setBounds(61, 21, 231, 41);
		panel.add(lblOrdenDeSalida);
		
		
		
		JLabel lblN = new JLabel("N\u00B0");
		lblN.setForeground(Color.GRAY);
		lblN.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		lblN.setBounds(455, 29, 43, 25);
		panel.add(lblN);
		
		txtNroOrdenSalida = new JTextField();
		txtNroOrdenSalida.setForeground(Color.WHITE);
		txtNroOrdenSalida.setHorizontalAlignment(SwingConstants.CENTER);
		txtNroOrdenSalida.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		txtNroOrdenSalida.setBackground(Color.ORANGE);
		txtNroOrdenSalida.setEditable(false);
		txtNroOrdenSalida.setBounds(506, 27, 58, 28);
		panel.add(txtNroOrdenSalida);
		txtNroOrdenSalida.setColumns(10);
		txtNroOrdenSalida.setText("" + as.codigoCorrelativo());
		
		
		JLabel lblAutorizadoPor = new JLabel("Autorizado por:");
		lblAutorizadoPor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblAutorizadoPor.setBounds(39, 161, 116, 22);
		contentPanel.add(lblAutorizadoPor);
		
		cboPersonal = new JComboBox(cargarPersonal());
		cboPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionPersonal = (String) 
				cboPersonal.getSelectedItem();
			}
		});
		cboPersonal.setBackground(Color.WHITE);
		cboPersonal.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		cboPersonal.setBounds(39, 184, 167, 25);
		contentPanel.add(cboPersonal);
		cboPersonal.setModel(cboNomPersonal);
		cboPersonal.setSelectedIndex(-1);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblDestino.setBounds(283, 161, 116, 22);
		contentPanel.add(lblDestino);
		
		cboMaquinaDestino = new JComboBox();
		cboMaquinaDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				seleccionMaquina = (String) 
				cboMaquinaDestino.getSelectedItem();
			}
		});
		cboMaquinaDestino.setModel(new DefaultComboBoxModel(new String[] {"-- Seleccionar --", "Mototraillas", "Perforadora", "Retropalas", "Dúmperes","Excavadora","Dragalinas"}));
		cboMaquinaDestino.setBackground(Color.WHITE);
		cboMaquinaDestino.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		cboMaquinaDestino.setBounds(283, 184, 167, 25);
		contentPanel.add(cboMaquinaDestino);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBounds(31, 330, 449, 5);
		contentPanel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 346, 449, 261);
		contentPanel.add(scrollPane);
		
		txtReporte = new JTextArea();
		txtReporte.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		scrollPane.setViewportView(txtReporte);
		modelo= new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("ÍTEM");
		modelo.addColumn("CATEGORÍA");
		modelo.addColumn("ESTADO");
		modelo.addColumn("UD. MEDIDA");
		modelo.addColumn("CANTIDAD");
		
		JLabel lblItem = new JLabel("\u00CDtem:");
		lblItem.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblItem.setBounds(39, 230, 147, 23);
		contentPanel.add(lblItem);
		
		JComboBox cboItem = new JComboBox(cargarItem());
		cboItem.setBackground(Color.WHITE);
		cboItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionItem = (String) 
						cboItem.getSelectedItem();
			}
		});
		cboItem.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		cboItem.setBounds(39, 252, 167, 25);
		contentPanel.add(cboItem);
		cboItem.setModel(cboItemNombre);
		cboItem.setSelectedIndex(-1);
		
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblFecha.setBounds(39, 95, 116, 22);
		contentPanel.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBackground(Color.WHITE);
		txtFecha.setEditable(false);
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setBounds(39, 128, 167, 22);
		contentPanel.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtFecha.setText(fechaCompleta + " " +horaActual);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCantidad.setBounds(283, 230, 147, 23);
		contentPanel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(283, 254, 167, 23);
		contentPanel.add(txtCantidad);
		
		btnAgregar = new JButton("");
		btnAgregar.setBackground(new Color(173, 255, 47));
		btnAgregar.setIcon(new ImageIcon(generarSalida.class.getResource("/img/registrar.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarSalida();
				limpiar();
			}
		});
		btnAgregar.setBounds(521, 161, 50, 35);
		contentPanel.add(btnAgregar);
		
		btnImprimir = new JButton("");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirIndividual();
			}
		});
		btnImprimir.setBackground(new Color(175, 238, 238));
		btnImprimir.setIcon(new ImageIcon(generarSalida.class.getResource("/img/imprimir-contorno-del-boton.png")));
		btnImprimir.setBounds(521, 383, 50, 35);
		contentPanel.add(btnImprimir);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnEliminar.setBackground(new Color(250, 128, 114));
		btnEliminar.setIcon(new ImageIcon(generarSalida.class.getResource("/img/limpieza-de-datos.png")));
		btnEliminar.setBounds(521, 230, 50, 35);
		contentPanel.add(btnEliminar);
		
		JLabel lblReporteDeSalida = new JLabel("REPORTE DE SALIDA");
		lblReporteDeSalida.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblReporteDeSalida.setBounds(27, 305, 162, 14);
		contentPanel.add(lblReporteDeSalida);
		
		JLabel label = new JLabel("Registrar");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(519, 201, 56, 14);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("Limpiar");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(519, 273, 56, 14);
		contentPanel.add(label_1);
		
		JButton btnImprimirTotal = new JButton("");
		btnImprimirTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimir();
			}
		});
		btnImprimirTotal.setIcon(new ImageIcon(generarSalida.class.getResource("/img/imprimir-contorno-del-boton.png")));
		btnImprimirTotal.setBackground(new Color(51, 153, 204));
		btnImprimirTotal.setBounds(521, 453, 50, 35);
		contentPanel.add(btnImprimirTotal);
		
		JLabel label_2 = new JLabel("Imprimir");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(520, 422, 50, 20);
		contentPanel.add(label_2);
		
		JLabel lblImpresin = new JLabel("Impresi\u00F3n ");
		lblImpresin.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpresin.setBounds(502, 499, 94, 14);
		contentPanel.add(lblImpresin);
		
		JLabel lblSecuencial = new JLabel("Secuencial");
		lblSecuencial.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecuencial.setBounds(512, 513, 72, 14);
		contentPanel.add(lblSecuencial);
		
		}
	
		personal personalInternal = new personal();
		ArrayList<String> nombrePersonal = personalInternal.obtenerNombrePersonal();
		DefaultComboBoxModel<String> cboNomPersonal = new DefaultComboBoxModel<>(nombrePersonal.toArray(new String[0]));
	
		nuevoRegistro itemInternal = new nuevoRegistro();
		ArrayList<String> nombreItem = itemInternal.obtenerNomItem();
		DefaultComboBoxModel<String> cboItemNombre = new DefaultComboBoxModel<>(nombreItem.toArray(new String[0]));
		

		

		
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
		
		public void registrarSalida(){
			try {
		        if (validarTextos()) {
		            codigoSalida = Integer.parseInt(txtNroOrdenSalida.getText().trim());
		            cantidadSalida = Integer.parseInt(txtCantidad.getText());

		            Salida salidaClase = new Salida(codigoSalida, cantidadSalida);
		            as.adicionar(salidaClase);

		            JOptionPane.showMessageDialog(null, "Registro de Salida ingresado correctamente");
		          
		           
		        }
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "El valor ingresado no es un número válido");
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar la Salida");
		    }
		}
		
		
		public boolean validarTextos() {
		    try {
		       
		        if (txtCantidad.getText().trim().equals("")) {
		            throw new Exception("Debe ingresar una cantidad");
		           
		        }
		        int cantidadSalida= Integer.parseInt(txtCantidad.getText());
		        if (cantidadSalida==0) {
		            throw new Exception("Debe ingresar una cantidad mayor a 0");
		        }
		        if(seleccionItem== null){
		        	throw new Exception("Debe seleccionar un ítem");
		        }
		        if(seleccionPersonal== null){
		        	throw new Exception("Debe seleccionar un personal");
		        }
		        if(seleccionMaquina== null){
		        	throw new Exception("Debe seleccionar una máquina");
		        }
		        	
		        return true;
		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(this, e.getMessage());
		        return false;
		    }
		
		}
	
		
		public void imprimirIndividual() {
		    
			if( codigoSalida==0 || cantidadSalida==0 | seleccionItem== null || seleccionPersonal==null || seleccionMaquina ==null){
				JOptionPane.showMessageDialog(null, "No existen salidas registradas");
			}
			else{
				txtReporte.setText("");
		        txtReporte.append("_____________________________________________________________"+ "\n");
		        txtReporte.append(" ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"+ "\n");
		        txtReporte.append("_____________________________________________________________"+ "\n"+"\n");
		        txtReporte.append("          "+"N° PARTE DE SALIDA" + "\n");
		        txtReporte.append("          |"+codigoSalida + "\n"+ "\n");
		        txtReporte.append("          "+"FECHA DE SALIDA" + "\n");
		        txtReporte.append("          |"+fechaCompleta + "\n"+ "\n");
		        txtReporte.append("          "+"HORA DE SALIDA" + "\n");
		        txtReporte.append("          |"+horaActual + "\n"+ "\n");
		        txtReporte.append("          "+"CANTIDAD DE SALIDA" + "\n");
		        txtReporte.append("          |"+cantidadSalida + "\n"+ "\n");
		        txtReporte.append("          "+"NOMBRE DE ÍTEM" + "\n");
		        txtReporte.append("          |"+seleccionItem + "\n"+ "\n");
		        txtReporte.append("          "+"PERSONAL QUE REGISTRÓ LA SALIDA" + "\n");
		        txtReporte.append("          |"+seleccionPersonal + "\n"+ "\n");
		        txtReporte.append("          "+"NOMBRE DE LA MÁQUINA DE DESTINO" + "\n");
		        txtReporte.append("          |"+seleccionMaquina + "\n"+ "\n");
			}
		}
		public void imprimir() {
		    
			if( codigoSalida==0 || cantidadSalida==0 | seleccionItem== null || seleccionPersonal==null || seleccionMaquina ==null){
				JOptionPane.showMessageDialog(null, "No existen salidas registradas");
			}
			else{
			
		        txtReporte.append("_____________________________________________________________"+ "\n");
		        txtReporte.append(" ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"+ "\n");
		        txtReporte.append("_____________________________________________________________"+ "\n"+"\n");
		        txtReporte.append("          "+"N° PARTE DE SALIDA" + "\n");
		        txtReporte.append("          |"+codigoSalida + "\n"+ "\n");
		        txtReporte.append("          "+"FECHA DE SALIDA" + "\n");
		        txtReporte.append("          |"+fechaCompleta + "\n"+ "\n");
		        txtReporte.append("          "+"HORA DE SALIDA" + "\n");
		        txtReporte.append("          |"+horaActual + "\n"+ "\n");
		        txtReporte.append("          "+"CANTIDAD DE SALIDA" + "\n");
		        txtReporte.append("          |"+cantidadSalida + "\n"+ "\n");
		        txtReporte.append("          "+"NOMBRE DE ÍTEM" + "\n");
		        txtReporte.append("          |"+seleccionItem + "\n"+ "\n");
		        txtReporte.append("          "+"PERSONAL QUE REGISTRÓ LA SALIDA" + "\n");
		        txtReporte.append("          |"+seleccionPersonal + "\n"+ "\n");
		        txtReporte.append("          "+"NOMBRE DE LA MÁQUINA DE DESTINO" + "\n");
		        txtReporte.append("          |"+seleccionMaquina + "\n"+ "\n");
		        txtReporte.setCaretPosition(0);
			}
		}
		
	public void limpiar(){
		
		txtCantidad.setText("");
		txtNroOrdenSalida.setText("" + as.codigoCorrelativo());
		
		txtCantidad.requestFocus();
		
	}
}