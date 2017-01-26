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

		System.out.println("------------------LOGIN------------------");
		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe tu nombre");
		String nombre = sc.next();

		System.out.println("Escribe tu contrasena");
		int contra = sc.nextInt();

		// System.out.println((agenda.login(nombre, contra)));

		if (agenda.login(nombre, contra)) {

			System.out.println("Login correcto, " + nombre);
			while (o != 0) {

				if (agenda != null) {
					System.out.println("Realizando operaciones con el objeto remoto");

					System.out.println(".......................... \n" + ".  0 Salir \n"
							+ ".  1 Ver lista contactos  \n" + ".  2 Crear contacto \n" + ".  3 Modificar contacto \n"
							+ ".  4 Borrar contacto  \n" + ".  5  Buscar contacto  \n" + ".  6 Log outt  \n");

					o = sc.nextInt();

					if (o == 1) {
						System.out.println("Ver lista contactos \n " + (agenda).verListaContacto());
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

						System.out.println((agenda).verListaContacto());

						System.out.println("Escribe la id delcontacto a modificar ");
						int idM = sc.nextInt();

						System.out.println("Nuevo nombre");
						String nombreM = sc.next();

						System.out.println("Nuevo numero");
						int numero = sc.nextInt();

						System.out.println("Nuevo email");
						String email = sc.next();

						System.out.println(
								"Ver contacto modificado " + (agenda).modificarContacto(nombreM, numero, email, idM));
					}
					if (o == 4) {

						System.out.println((agenda).verListaContacto());

						System.out.println("Escribe la id delcontacto a borrar ");
						int idB = sc.nextInt();

						System.out.println((agenda).borrarContacto(idB));
						System.out.println("Borrado");
					}
					if (o == 5) {
						System.out.println("Escribe el nombre del contacto ");
						String nom = sc.next();

						System.out.println((agenda).buscarC(nom));
						// System.out.println("Borrado");
					}
					if (o == 6) {
						System.out.println("has cerrado sesion");
						main(args);

					}
				}
			}
		} else {
			System.out.println("Login incorrecto");
			main(args);
		}

	}
}
