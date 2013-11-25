package Perssistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import trial.FrameLetra;



public class ReadLetra implements Runnable {

	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private File file;
	private String pathFile;
	private String cancion="";
	private int iniSegundos,iniMinutos;
	private int costo,segundos,minutos;
	private FrameLetra frameLetra;



	public ReadLetra (FrameLetra frameLetra)throws IOException {
		this.frameLetra = frameLetra;
		file = new File("");
		pathFile = file.getAbsolutePath()+"/src/Perssistence/letra.txt";
		fileReader = new FileReader(pathFile);
		bufferedReader = new BufferedReader(fileReader);
		String line="";
		//		int cont =0;
		while ((line=bufferedReader.readLine())!=null) {
			cancion+=line+"."; 
		}
		cancion+="0";

		Thread hilo = new Thread(this);
		hilo.start();
	}

	public void run() {
		// TODO Auto-generated method stub
		int  n=0;
		Calendar calendar = Calendar.getInstance();
		iniSegundos = calendar.get(calendar.SECOND);
		iniMinutos = calendar.get(calendar.MINUTE);
		while (cancion.charAt(n)!='0') {
			Calendar calendar2 = Calendar.getInstance();
			if (cancion.charAt(n)=='.') {
				
				frameLetra.getArea().setText(frameLetra.getArea().getText()+"\n");
				System.out.println(calendar.get(calendar.SECOND));
			}else{
				try {
					
					frameLetra.getArea().setText(frameLetra.getArea().getText()+cancion.charAt(n));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				System.out.println(calendar.get(calendar.SECOND));
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			n++;
		}
	}

	public int calc(int min,int sec){
		int min1=min-iniMinutos;
		int seg1=segundos-iniSegundos;
		
		return seg1+(min1*60);
	}


}
