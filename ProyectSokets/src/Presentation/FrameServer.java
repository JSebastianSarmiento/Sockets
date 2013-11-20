package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logic.Conexion;
import logic.Servidor;

public class FrameServer extends JFrame implements ActionListener {
	

	private JTextArea area;
	private JTextField field;
	private JButton buttonEnviar;
	private Servidor servidor;
	public FrameServer(){
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		servidor = new Servidor();
		try {
			servidor.iniciarServidor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		area = new JTextArea();
		area.setBounds(3, 3, 100, 100);
		
		field = new JTextField();
		field.setBounds(50, 200, 100, 30);
		
		buttonEnviar = new JButton("enviar");
		buttonEnviar.addActionListener(this);
		buttonEnviar.setBounds(50, 250, 80, 20);
		
		
		add(area);
		add(field);
		add(buttonEnviar);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("enviar")) {
//			servidor.getListConexion().get(0).setOpcion(0);
			servidor.getListConexion().get(0).setMensaje(field.getText());
			servidor.getListConexion().get(0).iniciarConexion(0);
		}
}
	}
