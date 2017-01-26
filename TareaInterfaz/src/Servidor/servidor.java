package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Servidor.Interfaz;

public class servidor implements Interfaz {
	public int id;

	BBDD bbdd;

	// HashMap<Integer, ArrayList<String>> persona = new HashMap<Integer,
	// ArrayList<String>>();
	// array del arraylist de hasmap

	ArrayList<String> contactos = new ArrayList<String>();

	@Override
	public ArrayList<String> verListaContacto() {
		bbdd = new BBDD();
		//System.out.println(bbdd.verContactos());

		// TODO Auto-generated method stub
		return bbdd.verContactos();
	}

	String datos[] = new String[2];

	@Override
	public ArrayList<String> crearContacto(String nombre, int numero, String email) {
		bbdd = new BBDD();

		contactos.add(nombre);
		contactos.add(numero + "");
		contactos.add(email);

		bbdd.insertarContacto(nombre, numero, email);

		return contactos;
	}

	@Override
	public int modificarContacto(String nombre,int numero, String email,int id) {
		bbdd = new BBDD();
		bbdd.modificarContacto(nombre,numero,email,id);

		return id;
	}

	@Override
	public int borrarContacto(int id) {
		bbdd = new BBDD();
		bbdd.borrarcontacto(id);

		return id;
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

	@Override
	public boolean login(String nombre, int contra) throws RemoteException {
		bbdd = new BBDD();

		if (bbdd.comprobarUser(nombre, contra)) {
			return true;
		} else {
			return false;
		}

	}

}
