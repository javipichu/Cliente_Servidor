/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacliente;

/**
 *
 * @author javi
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientesSOcketStream {
	
	public static void main(String[] args){
		try{
			System.out.println("Creando socket cliente");
			Socket clienteSocket=new Socket();
			System.out.println("Estableciendo la conexion");
			
			InetSocketAddress addr=new InetSocketAddress("192.168.0.1",5555);
			clienteSocket.connect(addr);   //para cponectarse al server 

			InputStream is = clienteSocket.getInputStream();
			OutputStream os= clienteSocket.getOutputStream();

			System.out.println("Enviando mensaje");

			String mensaje="mensaje desde el cliente";
			os.write(mensaje.getBytes());

			System.out.println("Mensaje enviado");

			System.out.println("Cerrando el socket cliente");

			clienteSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
				e.printStackTrace();
			}
	}
}	