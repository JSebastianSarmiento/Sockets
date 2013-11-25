package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.Cliente;

public class FrameMenuServer extends JFrame implements ActionListener{


	private JLabel jLabelIp,labelUsuario;
	private JTextField fieldIp,fieldUsuario;
	private JButton buttonAceptar;
	private Cliente cliente;
	private String ip ="192.168.0.26";

	public FrameMenuServer (){
		setSize(200, 150);
		setLocationRelativeTo(null);
		setTitle("Menu Server");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jLabelIp = new JLabel ("Ip:");
		jLabelIp.setBounds(10, 10, 30, 20);
		
		fieldIp = new JTextField();
		fieldIp.setBounds(80, 10, 90, 20);
		
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(10, 50, 90, 20);
		
		fieldUsuario = new JTextField();
		fieldUsuario.setBounds(70, 50, 90, 20);
		
		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(this);
		buttonAceptar.setBounds(30, 80, 100, 20);
		
		
		add(jLabelIp);
		add(fieldIp);
		add(labelUsuario);
		add(fieldUsuario);
		add(buttonAceptar);
		fieldIp.setText(ip);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Aceptar")) {
			FrameServer frameServer = new FrameServer(fieldIp.getText(), fieldUsuario.getText());
			this.setVisible(false);
			
		}
	}
	
	
	
	
	public static void main(String[] args) {
		FrameMenuServer frameMenuServer = new FrameMenuServer();
	}

}
