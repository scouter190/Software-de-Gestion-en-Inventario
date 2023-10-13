	package gui;
	
	import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
	
	import javax.swing.JInternalFrame;
	import javax.swing.JPanel;
	import javax.swing.JLabel;
	import java.awt.Font;
	import javax.swing.JDesktopPane;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import gui.configuracion_categoria;
	
	
	import javax.swing.SwingConstants;
	import javax.swing.UIManager;
	
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;


	public class configuracion extends JInternalFrame {
	private JDesktopPane configuracionSwitchFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					configuracion frame = new configuracion();
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
	public configuracion() {
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1134, 730);
		getContentPane().setLayout(null);
		
		configuracionSwitchFrame = new JDesktopPane();
		configuracionSwitchFrame.setBounds(0, 98, 1134, 652);
		getContentPane().add(configuracionSwitchFrame);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1134, 100);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblConfiguracin = new JLabel("CONFIGURACI\u00D3N");
		lblConfiguracin.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblConfiguracin.setBounds(40, 23, 259, 54);
		panel.add(lblConfiguracin);
		
		JPanel panelCategoria = new JPanel();
		panelCategoria.addMouseListener(new PanelButtonMouseAdapter(panelCategoria){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
		        dashboard2.ShowConfiguracionCategoria();
		        dashboard2.mostrarConfCategoria= Boolean.TRUE;
		        dashboard2.CloseConfiguracionUnidades();
				
			}
		});
		panelCategoria.setBackground(new Color(255, 255, 255));
		panelCategoria.setBounds(735, 25, 140, 50);
		panel.add(panelCategoria);
		panelCategoria.setLayout(null);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategora.setBounds(29, 11, 81, 25);
		panelCategoria.add(lblCategora);
		lblCategora.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		
		JPanel panelUnidades = new JPanel();
		panelUnidades.setBounds(874, 25, 140, 50);
		panel.add(panelUnidades);
		panelUnidades.addMouseListener(new PanelButtonMouseAdapter(panelUnidades) {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dashboard2.ShowConfiguracionUnidades();
		        dashboard2.mostrarConfUnidades= Boolean.TRUE;
		        dashboard2.CloseConfiguracionCategoria();
				
			}
		});
		panelUnidades.setBackground(new Color(255, 255, 255));
		panelUnidades.setLayout(null);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnidades.setBounds(30, 11, 80, 24);
		panelUnidades.add(lblUnidades);
		lblUnidades.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));

	}

	
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel){
			this.panel= panel;
		}
		@Override 
		public void mouseEntered(MouseEvent e){
			panel.setBackground(new Color(255,165,0));
		}
		@Override 
		public void mouseExited(MouseEvent e){
			panel.setBackground(new Color(255,255,255));
		}
		@Override 
		public void mousePressed(MouseEvent e){
			panel.setBackground(new Color(255,228,181));
		}
		@Override 
		public void mouseReleased(MouseEvent e){
			panel.setBackground(new Color(255,255,255));
		}
		
	}
}