package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloItems;

import java.awt.Toolkit;

public class dashboard2 extends JFrame {
	
	/**
	 * 
	 */
	private static JDesktopPane SwitchFrame;
	private JPanel contentPane;
	public static inicio ini;
	
	public static nuevoRegistro nuevoRegis;
	private static proveedores prov;
	private static personal perso;
	private static configuracion conf;
	public static entradasi entra;
	public static registroEntradas regEntradas;
	public static configuracion_categoria confCategoria;
	public static configuracion_unidades confUnidades;
	public static salidas sali;
	public static generarSalida geneSali;
	

	public static imprimirRegistro imprimir;
	public static Boolean mostrarImprimir= Boolean.FALSE;
	public static Boolean mostrarIni= Boolean.FALSE;
	public static Boolean mostrarNuevoRegistro = Boolean.FALSE;
	public static Boolean mostrarProv = Boolean.FALSE;
	public static Boolean mostrarPersonal = Boolean.FALSE;
	public static Boolean mostrarConf= Boolean.FALSE;
	public static Boolean mostrarEntra= Boolean.FALSE;
	public static Boolean mostrarSali= Boolean.FALSE;
	public static Boolean mostrarConfCategoria= Boolean.FALSE;
	public static Boolean mostrarConfUnidades= Boolean.FALSE;
	public static Boolean mostrarGenerarSali= Boolean.FALSE;
	public static Boolean mostrarRegisEntradas= Boolean.FALSE;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard2 frame = new dashboard2();
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
	
	
	void DiseaGUI(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		SwitchFrame = new JDesktopPane();
		SwitchFrame.setForeground(new Color(112, 128, 144));{
		
		
		};
		
		SwitchFrame.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SwitchFrame, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(SwitchFrame, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JLabel lblLomjorceSAC = new JLabel("CEDAR E.I.R.L.");
		lblLomjorceSAC.setHorizontalAlignment(SwingConstants.CENTER);
		lblLomjorceSAC.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 25));
		lblLomjorceSAC.setBounds(11, 11, 207, 26);
		panel.add(lblLomjorceSAC);
		
		JLabel lbl____ = new JLabel("____________________________");
		lbl____.setHorizontalAlignment(SwingConstants.CENTER);
		lbl____.setBounds(13, 35, 203, 14);
		panel.add(lbl____);
		
		JPanel panelInventarioItems = new JPanel();
		panelInventarioItems.addMouseListener(new PanelButtonMouseAdapter(panelInventarioItems){
			@Override
			public void mouseClicked(MouseEvent e){
				cerrarVentana();
				mostrarNuevoRegistro= Boolean.TRUE;
				ShowNuevoRegistro();
				
				
			}
		});
		panelInventarioItems.setLayout(null);
		panelInventarioItems.setBackground(Color.WHITE);
		panelInventarioItems.setBounds(0, 108, 230, 50);
		panel.add(panelInventarioItems);
		
		JLabel lblInventarioItems = new JLabel("INVENTARIO DE \u00CDTEMS");
		lblInventarioItems.setHorizontalAlignment(SwingConstants.LEFT);
		lblInventarioItems.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblInventarioItems.setBounds(71, 11, 168, 28);
		panelInventarioItems.add(lblInventarioItems);
		
		JLabel lblIconRegistroPasajeros = new JLabel("");
		lblIconRegistroPasajeros.setIcon(new ImageIcon(dashboard2.class.getResource("/img/la-gestion-del-inventario.png")));
		lblIconRegistroPasajeros.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconRegistroPasajeros.setBounds(13, 5, 40, 40);
	
		panelInventarioItems.add(lblIconRegistroPasajeros);
		
		JPanel panelProveedores = new JPanel();
		panelProveedores.addMouseListener(new PanelButtonMouseAdapter(panelProveedores){
			@Override
			public void mouseClicked(MouseEvent e){
				cerrarVentana();
				mostrarProv = Boolean.TRUE;
				ShowProveedor();
			}
		});
		panelProveedores.setLayout(null);
		panelProveedores.setBackground(Color.WHITE);
		panelProveedores.setBounds(0, 158, 230, 50);
		panel.add(panelProveedores);
		
		JLabel lblProveedores = new JLabel("PROVEEDORES");
		lblProveedores.setHorizontalAlignment(SwingConstants.LEFT);
		lblProveedores.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblProveedores.setBounds(71, 11, 168, 28);
		panelProveedores.add(lblProveedores);
		
		JLabel lblIconVenta = new JLabel("");
		lblIconVenta.setIcon(new ImageIcon(dashboard2.class.getResource("/img/mensajero.png")));
		lblIconVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconVenta.setBounds(13, 5, 40, 40);
		panelProveedores.add(lblIconVenta);
		
		JPanel panelPersonal = new JPanel();
		panelPersonal.addMouseListener(new PanelButtonMouseAdapter(panelPersonal){
			@Override
			public void mouseClicked(MouseEvent e){
				cerrarVentana();
				mostrarPersonal = Boolean.TRUE;
				ShowPersonal();
			}
		});
		panelPersonal.setLayout(null);
		panelPersonal.setBackground(Color.WHITE);
		panelPersonal.setBounds(0, 208, 230, 50);
		panel.add(panelPersonal);
		
		JLabel lblPersonal = new JLabel("PERSONAL");
		lblPersonal.setHorizontalAlignment(SwingConstants.LEFT);
		lblPersonal.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblPersonal.setBounds(71, 11, 168, 28);
		panelPersonal.add(lblPersonal);
		
		JLabel lblIconPasajeros = new JLabel("");
		lblIconPasajeros.setIcon(new ImageIcon(dashboard2.class.getResource("/img/informacion-personal.png")));
		lblIconPasajeros.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPasajeros.setBounds(13, 5, 40, 40);
		panelPersonal.add(lblIconPasajeros);
		
		JPanel panelConfiguracion = new JPanel();
		
		panelConfiguracion.setLayout(null);
		panelConfiguracion.addMouseListener(new PanelButtonMouseAdapter(panelConfiguracion){
			@Override
			public void mouseClicked(MouseEvent e){
				cerrarVentana();
				mostrarConf = Boolean.TRUE;
				ShowConfiguracion();
			}
		});
		panelConfiguracion.setBackground(Color.WHITE);
		panelConfiguracion.setBounds(0, 258, 230, 50);
		panel.add(panelConfiguracion);
		
		JLabel lblConfiguracion = new JLabel("CONFIGURACI\u00D3N");
		lblConfiguracion.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfiguracion.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblConfiguracion.setBounds(71, 11, 159, 28);
		panelConfiguracion.add(lblConfiguracion);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(dashboard2.class.getResource("/img/configuraciones.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(13, 5, 40, 40);
		panelConfiguracion.add(label);
		
		JPanel panelCerrarSesion = new JPanel();
		panelCerrarSesion.setLayout(null);
		panelCerrarSesion.setBackground(Color.WHITE);
		panelCerrarSesion.setBounds(0, 308, 230, 50);
		panelCerrarSesion.addMouseListener(new PanelButtonMouseAdapter(panelCerrarSesion){
			@Override
			public void mouseClicked(MouseEvent e){
				if(JOptionPane.showConfirmDialog(null,  "Estás seguro de cerrar la sesión?")==0){
					Home login= new Home();
					login.setVisible(true);
					dashboard2.this.dispose();
				}
				
			}
		});
		panel.add(panelCerrarSesion);
		
		JLabel lblCerrarSesion = new JLabel("CERRAR SESI\u00D3N");
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		lblCerrarSesion.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblCerrarSesion.setBounds(71, 11, 159, 28);
		panelCerrarSesion.add(lblCerrarSesion);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(13, 5, 40, 40);
		panelCerrarSesion.add(label_2);
		
		JLabel lblIconCerrarSesion = new JLabel("");
		lblIconCerrarSesion.setBounds(13, 5, 40, 40);
		panelCerrarSesion.add(lblIconCerrarSesion);
		lblIconCerrarSesion.setIcon(new ImageIcon(dashboard2.class.getResource("/img/salir.png")));
		lblIconCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelInicio = new JPanel();
		panelInicio.addMouseListener(new PanelButtonMouseAdapter(panelInicio){
			@Override
			public void mouseClicked(MouseEvent e){
				
				cerrarVentana();
				mostrarIni = Boolean.TRUE;
				ShowInicio();
			}
		});
		panelInicio.setLayout(null);
		panelInicio.setBackground(Color.WHITE);
		panelInicio.setBounds(0, 58, 230, 50);
		panel.add(panelInicio);
		
		JLabel lblIconInicio = new JLabel("");
			lblIconInicio.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconInicio.setBounds(13, 5, 40, 40);
			lblIconInicio.setIcon(new ImageIcon(dashboard2.class.getResource("/img/inicio.png")));
			panelInicio.add(lblIconInicio);
			
			JLabel lblInicio = new JLabel("INICIO");
			lblInicio.setHorizontalAlignment(SwingConstants.LEFT);
			lblInicio.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			lblInicio.setBounds(69, 11, 170, 28);
			panelInicio.add(lblInicio);
		
	
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public void menuClicked2(JInternalFrame internal){

		
		internal.setVisible(true);
	}
	
	
	public dashboard2() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		DiseaGUI();
	
	}
	
	public static void ShowInicio(){
		ini = new inicio();
		SwitchFrame.add(ini);
		ini.show();
		
	}
	
	public static void ShowNuevoRegistro(){
		nuevoRegis = new nuevoRegistro();
		SwitchFrame.add(nuevoRegis);
		nuevoRegis.setVisible(true);;
		
	}
	
	public static void ShowProveedor(){
		prov = new proveedores();
		SwitchFrame.add(prov);
		prov.show();
	}
	public static void ShowPersonal(){
		perso = new personal();
		SwitchFrame.add(perso);
		perso.show();
	}
	
	public static void ShowEntradas(){
		entra = new entradasi();
		SwitchFrame.add(entra);
		entra.show();
	
	}
	
	public static void ShowRegistroEntrada() {
		regEntradas = new registroEntradas();
		SwitchFrame.add(regEntradas);
		regEntradas.show();
	}
	
	public static void ShowGenerarSalidas(){
		geneSali = new generarSalida();
		SwitchFrame.add(geneSali);
		geneSali.setVisible(true);
	}
	public static void ShowSalidas() {
		sali = new salidas();
		SwitchFrame.add(sali);
		sali.show();
	}
	
	public static void ShowConfiguracion() {
		conf = new configuracion();
		SwitchFrame.add(conf);
		conf.show();
	}
	public static void ShowConfiguracionCategoria() {
		confCategoria = new configuracion_categoria();
		SwitchFrame.add(confCategoria);
		confCategoria.show();
	}
	public static void ShowConfiguracionUnidades() {
		confUnidades = new configuracion_unidades();
		SwitchFrame.add(confUnidades);
		confUnidades.show();
	}
	
	public static void ShowImprimir() {
		imprimir = new imprimirRegistro();
		SwitchFrame.add(imprimir);
		imprimir.show();
	}
	
	
	public static void CloseInicio(){
		try{
			ini.setClosed(true);	
		}catch(Exception ex){}
	}
	
	
	public static void CloseNuevoRgistro(){
		try{
			nuevoRegis.setClosed(true);	
		}catch(Exception ex){}
	}
	
	public static void CloseProveedor(){
		try{
			prov.setClosable(true);;	
		}catch(Exception ex){}

	}
	public static void ClosePersonal(){
		try{
			perso.setClosable(true);;	
		}catch(Exception ex){}

	}
	
	public static void CloseEntrada(){
		try{
			entra.setClosed(true);	
		}catch(Exception ex){}
	}
	
	public static void CloseRegEntrada(){
		try{
			regEntradas.setClosed(true);	
		}catch(Exception ex){}
	}
	
	public static void CloseSalidas(){
		try{
			sali.setClosed(true);	
		}catch(Exception ex){}
	}
	public static void CloseConfiguracion(){
		try{
			conf.setClosed(true);	
		}catch(Exception ex){}
	}
	public static void CloseConfiguracionCategoria(){
		try{
			confCategoria.setClosed(true);	
		}catch(Exception ex){}
	}
	public static void CloseConfiguracionUnidades(){
		try{
			confUnidades.setClosed(true);	
		}catch(Exception ex){}
	}
	public static void CloseGenerarSalidas(){
		try{
			geneSali.setVisible(false);	
		}catch(Exception ex){}
	}
	public static void CloseImprimirEntradas(){
		try{
			imprimir.setVisible(false);	
		}catch(Exception ex){}
	}
	
	
	public static void setLocation(int x, int y, JInternalFrame jif) {
		  Point old = jif.getLocation();
		  Point location = new Point(x, y);
		  if (old.equals(location))
		    return;
		  jif.setLocation(location);
	}

	public static void cerrarVentana() {
		if(mostrarIni) 
			ini.dispose();
	
		if(mostrarNuevoRegistro) 
			nuevoRegis.dispose();
		if(mostrarProv)
			prov.dispose();
		if(mostrarPersonal)
			perso.dispose();
		if(mostrarEntra)
			entra.dispose();
		if(mostrarRegisEntradas)
			regEntradas.dispose();
		if(mostrarSali) 
			sali.dispose();
		if(mostrarGenerarSali)
			geneSali.dispose();
		if(mostrarConf)
			conf.dispose();
		if(mostrarConfCategoria)
			confCategoria.dispose();
		if(mostrarConfUnidades)
			confUnidades.dispose();
		
		if(mostrarImprimir) 
			imprimir.dispose();
			
		
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel){
			this.panel= panel;
		}
		@Override 
		public void mouseEntered(MouseEvent e){
			panel.setBackground(new Color(255,140,0));
		}
		@Override 
		public void mouseExited(MouseEvent e){
			panel.setBackground(new Color(255,255,255));
		}
		@Override 
		public void mousePressed(MouseEvent e){
			panel.setBackground(new Color(245, 222, 179));
		}
		@Override 
		public void mouseReleased(MouseEvent e){
			panel.setBackground(new Color(255,140,0));
		}
		
	}
}
