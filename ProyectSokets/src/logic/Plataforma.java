package logic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Presentation.FramePlataforma;


public class Plataforma implements Runnable {
	
	private ServerSocket serverSocket;
	private ArrayList<Conexion> listServer;
	private Socket conexionEntrante;
	private int puerto;
	private boolean estado;
	private String estadisticas;
	private String lisServidores;
	private FramePlataforma framePlataforma;
	

	public Plataforma(FramePlataforma framePlataforma) throws IOException {
		puerto = 4450;
		serverSocket= new ServerSocket(puerto);
		listServer = new ArrayList<Conexion>();
		this.framePlataforma = framePlataforma;
		Thread hilo = new Thread(this);
		hilo.start();
	}
	

 

	public void run() {
		while (!estado) {
			System.out.println("Esperando Conexiones... en servidor");
			
			
			try {
				
				conexionEntrante = serverSocket.accept();
				Conexion conexionServidores = new Conexion(conexionEntrante);
				framePlataforma.getBoxServers().addItem(conexionServidores.getNombreUsuario());
				
				
				framePlataforma.getTextAreaServers().setText(framePlataforma.getTextAreaServers().getText()+"-"
						+conexionServidores.getNombreUsuario()+"\n");
				listServer.add(conexionServidores);
				System.out.println("servidores conectados =" + listServer.size());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Error");
			}
		}
	}
	
	public void iniciarServidor() throws IOException{
		if (serverSocket==null) {
			serverSocket  = new ServerSocket(puerto);
		}
	}




	public ServerSocket getServerSocket() {
		return serverSocket;
	}




	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}




	public ArrayList<Conexion> getListServer() {
		return listServer;
	}




	public void setListServer(ArrayList<Conexion> listServer) {
		this.listServer = listServer;
	}




	public Socket getConexionEntrante() {
		return conexionEntrante;
	}




	public void setConexionEntrante(Socket conexionEntrante) {
		this.conexionEntrante = conexionEntrante;
	}




	public int getPuerto() {
		return puerto;
	}




	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}




	public boolean isEstado() {
		return estado;
	}




	public void setEstado(boolean estado) {
		this.estado = estado;
	}




	public String getEstadisticas() {
		return estadisticas;
	}




	public void setEstadisticas(String estadisticas) {
		this.estadisticas = estadisticas;
	}




	public String getLisServidores() {
		return lisServidores;
	}




	public void setLisServidores(String lisServidores) {
		this.lisServidores = lisServidores;
	}




	public FramePlataforma getFramePlataforma() {
		return framePlataforma;
	}




	public void setFramePlataforma(FramePlataforma framePlataforma) {
		this.framePlataforma = framePlataforma;
	}
	
}
