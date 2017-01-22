package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Interfaz extends Remote {

	public ArrayList<String> verListaContacto(String nombre, int numero, String email) throws RemoteException;

	public ArrayList<String> crearContacto(String nombre, int numero, String email)throws RemoteException;

	public ArrayList<String> modificarContacto(String nombreAntiguo, String nombreNuevo, int numero, String email)throws RemoteException;

	public String borrarContacto(String nombre)throws RemoteException;
	

}
