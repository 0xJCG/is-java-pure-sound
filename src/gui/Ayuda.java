package gui;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Ayuda extends JDialog {
	public Ayuda() {
		setTitle("Ayuda");
		getContentPane().setBackground(new Color(255, 255, 255));
		
		getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel lblPuresound = new JLabel("PureSound");
		lblPuresound.setForeground(new Color(30, 144, 255));
		lblPuresound.setBackground(new Color(255, 255, 255));
		lblPuresound.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		getContentPane().add(lblPuresound);
		
		JLabel lblAyuda = new JLabel("Ayuda");
		lblAyuda.setForeground(new Color(30, 144, 255));
		lblAyuda.setBackground(new Color(255, 255, 255));
		lblAyuda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		getContentPane().add(lblAyuda);
	}
}
