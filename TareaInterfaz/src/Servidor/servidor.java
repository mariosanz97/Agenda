package Servidor;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

import Servidor.Interfaz;

public class servidor implements Interfaz {

	@Override
	public ArrayList<String> verListaContacto(String nombre, int numero, String email) {
		System.out.println("Ver lista: ");
		ArrayList<String> obj = new ArrayList<String>();
		obj.add(nombre);
		obj.add(numero + "");
		obj.add(email);
		// TODO Auto-generated method stub
		return obj;
	}

	@Override
	public ArrayList<String> crearContacto(String nombre, int numero, String email) {
		// TODO Auto-generated method stub
		ArrayList<String> obj = new ArrayList<String>();
		obj.add(nombre);
		obj.add(numero + "");
		obj.add(email);
		// TODO Auto-generated method stub
		return obj;
	}

	@Override
	public ArrayList<String> modificarContacto(String nombreAntiguo, String nombreNuevo, int numero, String email) {
		// TODO Auto-generated method stub
		ArrayList<String> obj = new ArrayList<String>();
		//obj.add(nombreAntiguo);
		obj.add(nombreNuevo);
		obj.add(numero + "");
		obj.add(email);
		// TODO Auto-generated method stub
		return obj;
	}

	@Override
	public String borrarContacto(String nombre) {
		// TODO Auto-generated method stub
		return nombre;
	}

	public static void main(String[] args) {
		Registry reg = null;
		try {
			System.out.println("Crea el registro de objetos, escuchando en el puerto 5555");
			reg = LocateRegistry.createRegistry(5555);
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido crear el registro");
			e.printStackTrace();
		}
		System.out.println("Creando el objeto servidor");
		servidor serverObject = new servidor();
		try {
			System.out.println("Inscribiendo el objeto servidor en el registro");
			System.out.println("Se le da un nombre único: Agenda");
			reg.rebind("Agenda", (Interfaz) UnicastRemoteObject.exportObject(serverObject, 0));
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido inscribir el objeto servidor.");
			e.printStackTrace();
		}
	}

}
