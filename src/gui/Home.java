package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("");
	private JTextField txtUsuario;
	private JPasswordField txtContrasea;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setUndecorated(true);
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
	public Home() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 457);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 368, 462);
		contentPane.add(panel);
		panel.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/img/logo1.jpg")));
		lblNewLabel.setBounds(0, 0, 368, 292);
		panel.add(lblNewLabel);
		
		JLabel lblEmpresa = new JLabel("CEDAR E.I.R.L.");
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setBackground(Color.BLACK);
		lblEmpresa.setForeground(Color.BLACK);
		lblEmpresa.setFont(new Font("Verdana", Font.BOLD, 18));
		lblEmpresa.setBounds(83, 366, 202, 30);
		panel.add(lblEmpresa);
		
		JLabel lblNewLabel_1 = new JLabel("EMPRESA DE TRANSPORTES E INVERSIONES");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 321, 368, 30);
		panel.add(lblNewLabel_1);
		
		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(406, 274, 283, 25);
		contentPane.add(lblMensaje);
		
		
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				validarCredenciales();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresar.setBackground(new Color(255, 215, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresar.setBackground(new Color(255, 140, 0));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btnIngresar.setBackground(new Color(255, 140, 0));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnIngresar.setBackground(new Color(255, 215, 0));
			}
		});
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setFont(new Font("Candara", Font.BOLD, 16));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIngresar.setBackground(new Color(255, 215, 0));
		btnIngresar.setBounds(447, 326, 204, 38);
		contentPane.add(btnIngresar);
		
		JLabel lblUser = new JLabel("USUARIO");
		lblUser.setForeground(Color.DARK_GRAY);
		lblUser.setBounds(510, 68, 62, 14);
		contentPane.add(lblUser);
		
		JLabel lblContra = new JLabel("CONTRASE\u00D1A");
		lblContra.setForeground(Color.DARK_GRAY);
		lblContra.setBounds(503, 187, 81, 14);
		contentPane.add(lblContra);
		
		JLabel lblX = new JLabel("x");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if( JOptionPane.showConfirmDialog(null,"Estas seguro de salir?","Confirmar", JOptionPane.YES_NO_OPTION)==0){
					Home.this.dispose();
					}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		
		lblX.setForeground(Color.BLACK);
		lblX.setBounds(700, 0, 25, 25);
		contentPane.add(lblX);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(427, 110, 235, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.addFocusListener(new FocusAdapter() {
			
		});
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(10, 11, 215, 16);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(427, 225, 235, 38);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtContrasea = new JPasswordField();
		txtContrasea.setBorder(null);
		txtContrasea.setBounds(10, 11, 215, 16);
		panel_2.add(txtContrasea);
		
			}
	
		public void validarCredenciales() {
	    try {
	    	String usuario = txtUsuario.getText();
	        String contrasena = txtContrasea.getText();
	        
	        if (usuario.equals("admin") && contrasena.equals("admin123")) {
	            // Si las credenciales son correctas
	            lblMensaje.setText("");
	            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
	            dashboard2 dashboard= new dashboard2();
	            dashboard.setVisible(true);
	            Home.this.dispose();
	            
	        }else if (usuario.equals("") || usuario.equals("Usuario") ||
	                   contrasena.equals("") || contrasena.equals("Contraseña")) {
	            lblMensaje.setText("Por favor ingrese todos los requerimientos");
	            
	        } else if (contrasena.equals("admin123")) {
	            lblMensaje.setText("Usuario incorrecto");
	            
	        } else if(usuario.equals("admin")){
	        	lblMensaje.setText("Contraseña incorrecta");
	        	
	        } else {
	            lblMensaje.setText("Usuario y contraseña incorrecta");
	        }
	    } catch (Exception ex) {
	        
	        JOptionPane.showMessageDialog(null, "Error al validar las credenciales: " + ex.getMessage());
	    }
	}
	
	
	
	
	
	
	
	
	
	
}
