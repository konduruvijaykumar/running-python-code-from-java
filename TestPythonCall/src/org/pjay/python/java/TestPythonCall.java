package org.pjay.python.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Vijay Konduru
 *
 */
public class TestPythonCall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Not a better way of doing, but was unable to find DHT22 sensor working library in java.
			// Need to move aws, ibm sdk integration code to python 
			//Process pythonProcess = Runtime.getRuntime().exec("python3 /home/pi/PROJECT-DSI/sensingDHT22.py");
			String line = "";
			int numberOfIterations = 30;
			BufferedReader bufferedReader = null;
			for(;numberOfIterations > 0;){
				Process pythonProcess = Runtime.getRuntime().exec("python3 /home/pi/PROJECT-DSI/sensingDHT22.py");
				bufferedReader = new BufferedReader(new InputStreamReader(pythonProcess.getInputStream()));
				while(null != (line = bufferedReader.readLine())){
					System.out.println("Data humidity,temperature is :: " + line);
					Thread.sleep(2000);
				}
				numberOfIterations--;
				pythonProcess.destroy();
				//bufferedReader.close();
			}
			bufferedReader.close();
			//Thread.sleep(6000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
