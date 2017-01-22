package cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import Servidor.Interfaz;

public class cliente {
	public static void main(String[] args) throws RemoteException {
		Interfaz agenda = null;
		try {
			System.out.println("Localizando el registro de objetos remitos");
			Registry registry = LocateRegistry.getRegistry("localhost", 5555);
			System.out.println("Obteniendo el stab del objeto remoto");
			agenda = (Interfaz) registry.lookup("Agenda");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer o = 1;
		while (o != 0) {

			if (agenda != null) {
				System.out.println("Realizando operaciones con el objeto remoto");

				System.out.println(".......................... \n" + ".  0 Salir \n" + ".  1 Ver lista contactos  \n"
						+ ".  2 Crear contacto \n" + ".  3 Modificar contacto \n" + ".  4 Borrar contacto  \n");
				Scanner sc = new Scanner(System.in);
				o = sc.nextInt();

				if (o == 1) {
					System.out.println("Ver lista contactos " + (agenda).verListaContacto("todosnombes", 1, "todos numeros"));
				}
				if (o == 2) {
					System.out.println("Nuevo nombre");
					String Nombre = sc.next();

					System.out.println("Nuevo numero");
					int numero = sc.nextInt();

					System.out.println("Nuevo email");
					String email = sc.next();

					System.out.println("Ver contacto creado " + (agenda).crearContacto(Nombre, numero, email));
					
				}
				if (o == 3) {
					System.out.println("Atiguo nombre");
					String Anombre = sc.next();
					
					System.out.println("Nuevo nombre");
					String Nnombre = sc.next();

					System.out.println("Nuevo numero");
					int numero = sc.nextInt();

					System.out.println("Nuevo email");
					String email = sc.next();
					
					System.out.println("Ver contacto modificado " + (agenda).modificarContacto(Anombre, Nnombre, numero, email));
				}

			}
		}
	}
}
