package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public interface Interfaz extends Remote {

	public boolean login(String nombre, int contra) throws RemoteException;
	
	public boolean ComprobarUser(String name) throws RemoteException;
	
	public String Registro(String name, int pass) throws RemoteException;
	
	public ArrayList<String> verListaContacto( ) throws RemoteException;

	public ArrayList<String> crearContacto(String nombre, int numero, String email)throws RemoteException;

	public int modificarContacto(String nombre, int numero, String email,int id)throws RemoteException;

	public int borrarContacto(int id)throws RemoteException;
	
	public ArrayList<String> buscarC (String nombre)throws RemoteException;
}
