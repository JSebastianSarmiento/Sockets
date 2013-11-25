package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.Cliente;

public class FrameCliente extends JFrame implements ActionListener{

	private JLabel labelConciertosDisp;
	private JComboBox boxConciertos;
	private JButton buttonAcept;
	private FrameMenu frameMenu;
	private String usuario;
	private Cliente cliente;
	
	public FrameCliente (FrameMenu frameMenu,String usuario,String ip){
		this.frameMenu = frameMenu;
		this.usuario = usuario;
		cliente = new Cliente(this,ip,usuario);
		setSize(200, 120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		labelConciertosDisp = new JLabel("Conciertos Disp");
		labelConciertosDisp.setBounds(2, 10, 100, 20);
		
		boxConciertos = new JComboBox();
		boxConciertos.setBounds(100, 10, 80, 20);
		
		buttonAcept = new JButton("Aceptar");
		buttonAcept.setBounds(60, 60, 80, 20);
		
		add(labelConciertosDisp);
		add(boxConciertos);
		add(buttonAcept);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Aceptar")) {
			
		}
	}

	public JLabel getLabelConciertosDisp() {
		return labelConciertosDisp;
	}

	public void setLabelConciertosDisp(JLabel labelConciertosDisp) {
		this.labelConciertosDisp = labelConciertosDisp;
	}

	public JComboBox getBoxConciertos() {
		return boxConciertos;
	}

	public void setBoxConciertos(JComboBox boxConciertos) {
		this.boxConciertos = boxConciertos;
	}

	public JButton getButtonAcept() {
		return buttonAcept;
	}

	public void setButtonAcept(JButton buttonAcept) {
		this.buttonAcept = buttonAcept;
	}

	public FrameMenu getFrameMenu() {
		return frameMenu;
	}

	public void setFrameMenu(FrameMenu frameMenu) {
		this.frameMenu = frameMenu;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
