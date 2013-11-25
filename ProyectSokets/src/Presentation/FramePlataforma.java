package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import logic.Plataforma;

public class FramePlataforma extends JFrame implements ActionListener{

	private JLabel labelServ,labelActivos;
	private JTextArea textAreaServers;
	private JLabel labelCancel;
	private JComboBox boxServers;
	private JButton buttonAcept;
	private Plataforma plataforma ;
	
	
	public FramePlataforma() {
		setSize(300, 280);
		setTitle("Plataforma");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		
		try {
			plataforma = new Plataforma(this);
			plataforma.iniciarServidor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
		}
		
		
		labelServ = new JLabel("Servidores");
		labelServ.setBounds(10, 30, 90, 20);
		
		labelActivos = new JLabel("Activos");
		labelActivos.setBounds(10, 50, 90, 20);
		
		textAreaServers = new JTextArea();
		textAreaServers.setBounds(100, 30, 150, 100);
		
		labelCancel = new JLabel("Cancelar Conexion");
		labelCancel.setBounds(10,150, 120, 20);
		
		boxServers = new JComboBox();
		boxServers.setBounds(130, 150, 90, 20);
		
		buttonAcept = new JButton("Aceptar");
		buttonAcept.addActionListener(this);
		buttonAcept.setBounds(60, 190, 90, 20);
		
		
		add(labelServ);
		add(labelActivos);
		add(textAreaServers);
		add(labelCancel);
		add(boxServers);
		add(buttonAcept);
		
		setVisible(true);
		}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Aceptar")) {
			for (int i = 0; i < plataforma.getListServer().size(); i++) {
				if (plataforma.getListServer().get(i).getNombreUsuario().equalsIgnoreCase(
						boxServers.getSelectedItem().toString())){
//					plataforma.getListServer().get(i).get
					plataforma.getListServer().remove(i);
					
				}
			}
			boxServers.removeAllItems();
			for (int i = 0; i < plataforma.getListServer().size(); i++) {
				boxServers.addItem(plataforma.getListServer().get(i).getNombreUsuario());
			}
		}
	}
	
	
	public static void main(String[] args) {
		FramePlataforma framePlataforma = new FramePlataforma();
	}

	public JLabel getLabelServ() {
		return labelServ;
	}

	public void setLabelServ(JLabel labelServ) {
		this.labelServ = labelServ;
	}

	public JLabel getLabelActivos() {
		return labelActivos;
	}

	public void setLabelActivos(JLabel labelActivos) {
		this.labelActivos = labelActivos;
	}

	public JTextArea getTextAreaServers() {
		return textAreaServers;
	}

	public void setTextAreaServers(JTextArea textAreaServers) {
		this.textAreaServers = textAreaServers;
	}

	public JLabel getLabelCancel() {
		return labelCancel;
	}

	public void setLabelCancel(JLabel labelCancel) {
		this.labelCancel = labelCancel;
	}

	public JComboBox getBoxServers() {
		return boxServers;
	}

	public void setBoxServers(JComboBox boxServers) {
		this.boxServers = boxServers;
	}

	public JButton getButtonAcept() {
		return buttonAcept;
	}

	public void setButtonAcept(JButton buttonAcept) {
		this.buttonAcept = buttonAcept;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}


	
}
