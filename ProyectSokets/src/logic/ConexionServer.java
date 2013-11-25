package logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ConexionServer implements Runnable{

	private Socket serverSocket;
	private DataInputStream dataInputStream;//canal de entrada 
	private DataOutputStream dataOutputStream;//canal de salida
	private boolean estado;
	private int opcion = Integer.MAX_VALUE;
	private String mensaje,nombreServer;
	
	public ConexionServer (Socket serverSocket){
		this.serverSocket = serverSocket;
		try {
			dataInputStream = new DataInputStream(serverSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dataOutputStream = new DataOutputStream(serverSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			nombreServer = dataInputStream.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		iniciarConexion(1,"conexion servidor Exitosa");
		
		Thread hilo = new Thread(this);
		hilo.start();
		
	}

	public void iniciarConexion(int i, String mensaje) {
		try {
			dataOutputStream.writeInt(i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dataOutputStream.writeUTF(mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void run() {
		// TODO Auto-generated method stub
		while (!estado) {

			try {
				
				opcion = dataInputStream.readInt();

			} catch (IOException e) {
				e.printStackTrace();
			} 
			switch (opcion) {
			case 1:
				
				break;
			case 2:
				try {
					
					JOptionPane.showMessageDialog(null, dataInputStream.readUTF());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 3:

				break;

			default:

				break;
			}
			System.out.println("Esperando Conexiones...en conexion");

		}	
		}

	public Socket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(Socket serverSocket) {
		this.serverSocket = serverSocket;
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNombreServer() {
		return nombreServer;
	}

	public void setNombreServer(String nombreServer) {
		this.nombreServer = nombreServer;
	}
	
	
}
