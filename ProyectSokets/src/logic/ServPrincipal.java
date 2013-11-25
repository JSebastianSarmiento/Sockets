package logic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServPrincipal implements Runnable{
	
	private ArrayList<Servidor> listServer;
	private ServerSocket serverSocket;
	private ArrayList<ConexionServer> listConexion;
	private Socket conexionEntrante;
	private String direcionIp;
	private int puerto;
	private Concierto concierto;
	private boolean estado;
	private String estadisticas;
	
	public ServPrincipal(){
		puerto =4450;
		listConexion = new ArrayList<ConexionServer>();
		Thread hilo = new Thread(this);
		hilo.start();
	}


	public void run() {
		
while (!estado) {
			
			System.out.println("Esperando Conexiones... en servidor principal");
			
			try {
				conexionEntrante = serverSocket.accept();
				ConexionServer conexionServ = new ConexionServer(conexionEntrante);
				conexionServ.iniciarConexion(2, "conectado a principal");
				listConexion.add(conexionServ);
				System.out.println("conexiones : "+ listConexion.size());
				
//				JOptionPane.showMessageDialog(null, "Nueva conexion aceptada");
				
			} catch (IOException e) {
				
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
		}	
	}
	public void iniciarServidor() throws IOException{
		if (serverSocket==null) {
			serverSocket  = new ServerSocket(puerto);
		}
	}
}
