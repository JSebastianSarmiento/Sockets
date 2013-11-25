package trial;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Perssistence.ReadLetra;

public class FrameLetra extends JFrame {

	
	private JTextArea area;
	private JLabel precio,tiempo;
	private ReadLetra letra;
	
	
	public FrameLetra (){
		setSize(400, 400);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			letra = new ReadLetra(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		area = new JTextArea ();
		area.setBounds(10, 10, 300, 200);
		
		precio = new JLabel();
		precio.setBounds(10, 250, 80, 20);
		
		tiempo = new JLabel();
		tiempo.setBounds(10, 300, 80, 20);
		
		add(area);
		add(precio);
		add(tiempo);
		
		area.setText("");
		
		setVisible(true);
		
	}


	public JTextArea getArea() {
		return area;
	}


	public void setArea(JTextArea area) {
		this.area = area;
	}


	public JLabel getPrecio() {
		return precio;
	}


	public void setPrecio(JLabel precio) {
		this.precio = precio;
	}


	public JLabel getTiempo() {
		return tiempo;
	}


	public void setTiempo(JLabel tiempo) {
		this.tiempo = tiempo;
	}
	
	public static void main(String[] args) {
		FrameLetra  frameLetra= new FrameLetra();
	}
}
