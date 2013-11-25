package logic;

import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JOptionPane;

import Presentation.FrameCliente;

//import Presentation.FrameCliente;



public class Cliente implements Runnable {


	private Socket socket;
	private DataInputStream dataInputStream;//canal de entrada 
	private DataOutputStream dataOutputStream;//canal de salida
	private String direccionIp,nombreUsuario;
	private int puertoCliente;
	private boolean estado;
	private int opcion = Integer.MAX_VALUE;
	private FrameCliente frameCliente;

	public Cliente(FrameCliente frameCliente,String ip, String usuario)  {
		puertoCliente = 4451;
		this.nombreUsuario = usuario;
		this.frameCliente = frameCliente;
		try {
			socket = new Socket(ip, 4451);
//			JOptionPane.showMessageDialog(null, "Creado el cliente");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
//			JOptionPane.showMessageDialog(null, "Creado canal de entrada");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
//			JOptionPane.showMessageDialog(null, "Creado canal de salida");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			dataOutputStream.writeUTF(usuario);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread hilo = new Thread(this);
		hilo.start();
		
	}
	public void run() {
		while (!estado) {
//				System.out.println("opcion: "+opcion);
			try {

				opcion = dataInputStream.readInt();

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("se desconecto el cliente");
			} 
			
//			System.out.println("opcion: "+opcion);
			
			switch (opcion) {
			case 1:
				try {
					
					JOptionPane.showMessageDialog(null, dataInputStream.readUTF());
					
				} catch (HeadlessException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				
				String[] list = null;
				try {
					list = dataInputStream.readUTF().split(";");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < list.length; i++) {
					frameCliente.getBoxConciertos().addItem(list[i]);
				}
				break;

			case 3:
				try {
					JOptionPane.showMessageDialog(null, dataInputStream.readUTF());
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			default:
				
				break;
			}
			System.out.println("Esperando Conexiones...en cliente");
			opcion = Integer.MAX_VALUE;
		}	
	}		

	public void cerrarCliente (){
		estado = false;
	}


	public void cerrarConexion(){
		try {
			dataInputStream.close();
			JOptionPane.showMessageDialog(null, "Cerrado canal de entrada");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dataOutputStream.close();
			JOptionPane.showMessageDialog(null, "Cerrado canal de salida");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket.close();
			JOptionPane.showMessageDialog(null, "Cerrado el cliente");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public DataInputStream getDataInputStream() {
		return dataInputStream;
	}
	public void setDataInputStream(DataInputStream dataInputStream) {
		this.dataInputStream = dataInputStream;
	}
	public DataOutputStream getDataOutputStream() {
		return dataOutputStream;
	}
	public void setDataOutputStream(DataOutputStream dataOutputStream) {
		this.dataOutputStream = dataOutputStream;
	}
	public String getDireccionIp() {
		return direccionIp;
	}
	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}
	public int getPuertoCliente() {
		return puertoCliente;
	}
	public void setPuertoCliente(int puertoCliente) {
		this.puertoCliente = puertoCliente;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getOpcion() {
		return opcion;
	}
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	
}
