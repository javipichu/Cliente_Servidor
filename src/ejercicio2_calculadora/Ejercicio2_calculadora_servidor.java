/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2_calculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

/**
 *
 * @author javi
 */
public class Ejercicio2_calculadora_servidor {

  
    public static void main(String[] args) {
                try{
			System.out.println("Creando socket servidor");
	
			ServerSocket serverSocket=new ServerSocket();

			InetSocketAddress addr=new InetSocketAddress("192.168.0.1",5555);
			serverSocket.bind(addr);

			System.out.println("Aceptando conexiones");

			Socket newSocket= serverSocket.accept();

			System.out.println("Conexion recibida");
                        
			InputStream is=newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();

			byte[] numero1=new byte[1];
			is.read(numero1);
                        
                        byte[] operacion =new byte[1];
			is.read(operacion);
                        
                        byte[] numero2 =new byte[1];
			is.read(numero2);
                        
                        String numero1String = new String(numero1);
                        int numero1Int = Integer.parseInt(numero1String);
                        
                        String operacionString = new String(operacion);
                        int operacionInt = Integer.parseInt(operacionString);
                        
                        String numero2String = new String(numero2);
                        int numero2Int = Integer.parseInt(numero2String);

                        int resultado = 0;
                     
                       switch (operacionInt) {
                            case 1:
                                resultado = numero1Int + numero2Int;  //operacion para sumar
                                break;
                            case 2:
                                resultado = numero1Int - numero2Int;  //operacion para restar
                                break;
                            case 3:
                                resultado = numero1Int * numero2Int;    //operacion para multiplicar
                                break;
                            case 4:
                                resultado = numero1Int / numero2Int;    //operacion para dividir
                                break;
                        }
                        String str1 = Integer.toString(resultado);
                        
                        os.write(str1.getBytes());
                        
                        System.out.println("Resultado enviado");
                       
			newSocket.close();

			System.out.println("Cerrando el socket servidor");

			serverSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
			}
		}
}