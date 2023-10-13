package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;

public class inicio extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
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
	public inicio() {
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(inicio.class.getResource("/img/maquinaria.png")));
		lblImagen.setBounds(39, 0, 1108, 700);
		getContentPane().add(lblImagen);
		
		JPanel panelBarra = new JPanel();
		panelBarra.setBackground(Color.ORANGE);
		panelBarra.setBounds(856, 0, 262, 700);
		getContentPane().add(panelBarra);
		
		JLabel lblEmpresaaa = new JLabel("GESTI\u00D3N DE INVENTARIO");
		lblEmpresaaa.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
		lblEmpresaaa.setBounds(39, 35, 759, 169);
		getContentPane().add(lblEmpresaaa);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(40, 165, 533, 10);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(429, 207, 390, 10);
		getContentPane().add(panel_1);
		setBounds(0, 0, 1134, 730);

	}
}
