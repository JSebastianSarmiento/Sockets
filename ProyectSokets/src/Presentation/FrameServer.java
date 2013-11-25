package Presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logic.Conexion;
import logic.Servidor;

public class FrameServer extends JFrame implements ActionListener {
	

	private JLabel labelClientes,labelCancelar;
	private JComboBox boxClientes;
	private JTextArea areaClientes;
	private JTextField fieldMensaje;
	private JButton buttonAceptar,buttonEnviar;
	private Servidor servidor;
	
public FrameServer(){
		
		setSize(400, 400);
		setTitle("Servidor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
//		servidor = new Servidor("192.168.0.26", "salsa",this);
		
		try {
			servidor = new Servidor("salsa", this);
			servidor.iniciarServidor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		labelClientes = new JLabel("Clientes Activos");
		labelClientes.setBounds(10, 50, 100,20 );
		labelClientes.setBackground(Color.red);
		
		areaClientes = new JTextArea();
		areaClientes.setBounds(130,10, 200, 150);
		
		labelCancelar = new JLabel("Cancelar conexion");
		labelCancelar.setBounds(10, 180, 120, 20);
		
		boxClientes = new JComboBox();
		boxClientes.setBounds(130, 180, 100, 20);
		
		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setBounds(250, 180, 100, 20);
		
		fieldMensaje = new JTextField();
		fieldMensaje.setBounds(130, 250, 100, 30);
		
		buttonEnviar = new JButton ("Enviar");
		buttonEnviar.addActionListener(this);
		buttonEnviar.setBounds(130, 310, 100, 20);
		
		add(labelClientes);
		add(areaClientes);
		add(labelCancelar);
		add(boxClientes);
		add(buttonAceptar);
		add(fieldMensaje);
		add(buttonEnviar);
		
		setVisible(true);
		
	}
	public FrameServer(String ip,String nombreServer){
		
		setSize(400, 400);
		setTitle("Servidor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		try {
			servidor = new Servidor(ip, nombreServer,this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		labelClientes = new JLabel("Clientes Activos");
		labelClientes.setBounds(10, 50, 100,20 );
		labelClientes.setBackground(Color.red);
		
		areaClientes = new JTextArea();
		areaClientes.setBounds(130,10, 200, 150);
		
		labelCancelar = new JLabel("Cancelar conexion");
		labelCancelar.setBounds(10, 180, 120, 20);
		
		boxClientes = new JComboBox();
		boxClientes.setBounds(130, 180, 100, 20);
		
		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setBounds(250, 180, 100, 20);
		
		fieldMensaje = new JTextField();
		fieldMensaje.setBounds(130, 250, 100, 30);
		
		buttonEnviar = new JButton ("Enviar");
		buttonEnviar.addActionListener(this);
		buttonEnviar.setBounds(130, 310, 100, 20);
		
		add(labelClientes);
		add(areaClientes);
		add(labelCancelar);
		add(boxClientes);
		add(buttonAceptar);
		add(fieldMensaje);
		add(buttonEnviar);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Enviar")) {
//			servidor.getListConexion().get(0).setOpcion(0);
			System.out.println("Enviar");
			if (fieldMensaje.getText().length()>0) {
				for (int i = 0; i < servidor.getListConexiones().size(); i++) {
					servidor.getListConexiones().get(i).iniciarConexion(3, fieldMensaje.getText());
				}
				fieldMensaje.setText("");
			}
			
		}
		
		
}
	
	
	
	
	public JLabel getLabelClientes() {
		return labelClientes;
	}

	public void setLabelClientes(JLabel labelClientes) {
		this.labelClientes = labelClientes;
	}

	public JLabel getLabelCancelar() {
		return labelCancelar;
	}

	public void setLabelCancelar(JLabel labelCancelar) {
		this.labelCancelar = labelCancelar;
	}

	public JComboBox getBoxClientes() {
		return boxClientes;
	}

	public void setBoxClientes(JComboBox boxClientes) {
		this.boxClientes = boxClientes;
	}

	public JTextArea getAreaClientes() {
		return areaClientes;
	}

	public void setAreaClientes(JTextArea areaClientes) {
		this.areaClientes = areaClientes;
	}

	public JTextField getFieldMensaje() {
		return fieldMensaje;
	}

	public void setFieldMensaje(JTextField fieldMensaje) {
		this.fieldMensaje = fieldMensaje;
	}

	public JButton getButtonAceptar() {
		return buttonAceptar;
	}

	public void setButtonAceptar(JButton buttonAceptar) {
		this.buttonAceptar = buttonAceptar;
	}

	public JButton getButtonEnviar() {
		return buttonEnviar;
	}

	public void setButtonEnviar(JButton buttonEnviar) {
		this.buttonEnviar = buttonEnviar;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	
	public static void main(String[] args) {
		FrameServer frameServer = new FrameServer();
	}
}