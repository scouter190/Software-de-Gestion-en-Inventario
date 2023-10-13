package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import arreglos.ArregloCategoria;
import arreglos.ArregloEntrada;
import arreglos.ArregloItems;
import arreglos.ArregloPersonal;
import arreglos.ArregloUnidadMedida;


import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class imprimirRegistro extends JInternalFrame {
	private JTextArea txtReporteEntrada;
	private nuevoRegistro nuevoRegis;
	public static ArregloPersonal ap = new ArregloPersonal();
	public static ArregloCategoria c = new ArregloCategoria();
	public static ArregloUnidadMedida um= new ArregloUnidadMedida();
	public static ArregloItems arregloItem= new ArregloItems();
	public static ArregloEntrada arregloEntrada= new ArregloEntrada();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					imprimirRegistro frame = new imprimirRegistro();
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
	public imprimirRegistro() {
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 52, 525, 448);
		getContentPane().add(scrollPane);
		
		txtReporteEntrada = new JTextArea();
		scrollPane.setViewportView(txtReporteEntrada);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard2.cerrarVentana();
	
				dashboard2.ShowNuevoRegistro();
				dashboard2.mostrarNuevoRegistro= Boolean.TRUE;
				dashboard2.CloseImprimirEntradas();
				
			}
		});
		btnCerrar.setBackground(new Color(220, 20, 60));
		btnCerrar.setIcon(new ImageIcon(imprimirRegistro.class.getResource("/img/cancelar (1).png")));
		btnCerrar.setBounds(516, 510, 40, 40);
		getContentPane().add(btnCerrar);
		
		JButton btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reporte();
				
				
				
			}
		});
		btnReporte.setBounds(49, 527, 89, 23);
		getContentPane().add(btnReporte);
		
		JButton btnReporteTotal = new JButton("Reporte Total");
		btnReporteTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnReporteTotal.setBounds(262, 527, 109, 23);
		getContentPane().add(btnReporteTotal);
		setBounds(100, 50, 604, 602);

	}
	
	/*private void reporte(){
		
		
		
		personal= 
		int codigo= Integer.parseInt(nuevoRegis.txtCodigo.getText());
		String nombre= nuevoRegis.txtNombre.getText();
		String categoria= nuevoRegis.cboCategoria.getSelectedItem().toString();
		String unidadMedida= nuevoRegis.cboUnidadMedida.getSelectedItem().toString();
		int cantidad= Integer.parseInt(nuevoRegis.txtCantidad.getText());
		String estado= nuevoRegis.cboEstado.getSelectedItem().toString();
		String ubicacion= nuevoRegis.txtUbicacion.getText();
		
		txtReporteEntrada.setText("");
		txtReporteEntrada.append("Código de ítem: "+ "\n");
		txtReporteEntrada.append(codigo+ "\n");
		txtReporteEntrada.append("Nombre de ítem: "+ "\n");
		txtReporteEntrada.append(nombre+ "\n");
		txtReporteEntrada.append("Categoría de ítem: "+ "\n");
		txtReporteEntrada.append(categoria+ "\n");
		txtReporteEntrada.append("Unidad de medida de ítem: "+ "\n");
		txtReporteEntrada.append(unidadMedida+ "\n");
		txtReporteEntrada.append("Estado de ítem: "+ "\n");
		txtReporteEntrada.append(estado+ "\n");
		txtReporteEntrada.append("Ubicación de ítem: "+ "\n");
		txtReporteEntrada.append(ubicacion+ "\n");
		
	}
	
	
	
	void listar() {
		x=a);
		Ingreso i=ai.buscar(x.getCodigoIngreso());
		Socio s= as.buscar(i.getCodigoSocio());
		txtS.setText("");
		imprimir("Código de socio        :"+i.getCodigoSocio());
		imprimir("Nombres del socio      :"+s.getNombres());
		imprimir("Apellidos del socio    :"+s.getApellidos());
		imprimir("DNI del socio          :"+s.getDni());
		imprimir("Teléfono del socio     :"+s.getTelefono());
		imprimir("");
		imprimir("Código de ingreso      :"+i.getCodigoIngreso());
		imprimir("Fecha de ingreso       :"+i.getFechaIngreso()+"  -  "+i.getHoraINgreso());
		imprimir("Número de invitados    :"+i.getNumeroInvitados());
		imprimir("");
		imprimir("Total pagado           :S/."+x.getPagoTotal());
	}
//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 1);
	}*/
}
