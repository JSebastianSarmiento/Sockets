package logic;

import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import Presentation.FrameServer;


public class Servidor implements Runnable{

	private ServerSocket serverSocket;
	private Socket socketConexionE;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private ArrayList<Conexion> listConexiones;
	private String direccioniP,nombreServidor;
	private int puertoServer;
	private boolean estado;
	private int opcion = Integer.MAX_VALUE;
	private FrameServer frameServer;

	public Servidor (String nombreServer,FrameServer frameServer) throws IOException{
		puertoServer = 4450;
		this.listConexiones = new ArrayList<Conexion>();
		this.nombreServidor = nombreServer;
		this.frameServer = frameServer;
		serverSocket= new ServerSocket(4451);
		
		Thread hilo = new Thread(this);
		hilo.start();
	}
	public Servidor (String ip,String nombreServer,FrameServer frameServer) throws IOException{
		puertoServer = 4450;
		serverSocket= new ServerSocket(4451);
		this.nombreServidor = nombreServer;
		this.frameServer = frameServer;
		this.listConexiones = new ArrayList<Conexion>();
		try {
			socketConexionE = new Socket(ip, puertoServer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dataInputStream = new DataInputStream(socketConexionE.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dataOutputStream = new DataOutputStream(socketConexionE.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dataOutputStream.writeUTF(nombreServidor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread hilo = new Thread(this);
		hilo.start();
	}


	public void run() {

		while (!estado) {
			
			
//			if (listConexiones.size()>0) {
//				for (int i = 0; i < listConexiones.size(); i++) {
//					frameServer.getBoxClientes().addItem(listConexiones.get(i).getNombreUsuario());
//				}
//			}
			try {
				
				socketConexionE = serverSocket.accept();
				Conexion conexion = new Conexion(socketConexionE);
				System.out.println(listConexiones);
				frameServer.getBoxClientes().addItem(conexion.getNombreUsuario());
				
				listConexiones.add(conexion);
//				System.out.println("conexiones : "+ listConexion.size());
				
//				JOptionPane.showMessageDialog(null, "Nueva conexion aceptada");
				
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
			switch (opcion) {
			case 1:
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
			case 2:
				
				
				break;
			default:
				break;
			}
		}
	}
	
	
	public void iniciarServidor() throws IOException{
		if (serverSocket==null) {
			serverSocket  = new ServerSocket(puertoServer);
		}
	}


	public ServerSocket getServerSocket() {
		return serverSocket;
	}


	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}


	public Socket getSocketConexionE() {
		return socketConexionE;
	}


	public void setSocketConexionE(Socket socketConexionE) {
		this.socketConexionE = socketConexionE;
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


	public ArrayList<Conexion> getListConexiones() {
		return listConexiones;
	}


	public void setListConexiones(ArrayList<Conexion> listConexiones) {
		this.listConexiones = listConexiones;
	}


	public String getDireccioniP() {
		return direccioniP;
	}


	public void setDireccioniP(String direccioniP) {
		this.direccioniP = direccioniP;
	}


	public String getNombreServidor() {
		return nombreServidor;
	}


	public void setNombreServidor(String nombreServidor) {
		this.nombreServidor = nombreServidor;
	}


	public int getPuertoServer() {
		return puertoServer;
	}


	public void setPuertoServer(int puertoServer) {
		this.puertoServer = puertoServer;
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


	public FrameServer getFrameServer() {
		return frameServer;
	}


	public void setFrameServer(FrameServer frameServer) {
		this.frameServer = frameServer;
	}
	
	
}
