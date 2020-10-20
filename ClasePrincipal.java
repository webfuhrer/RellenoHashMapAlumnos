import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClasePrincipal {

	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("T:\\ficheros\\notasAlumnos.csv");
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			HashMap<String, ArrayList <Asignatura>> mapa_notas=new HashMap();
			while(linea!=null)
			{
				String[] datos=linea.split(",");
				String nombre=datos[0];
				String asignatura=datos[1];
				String nota=datos[2];
				Asignatura a=new Asignatura(asignatura, Integer.parseInt(nota));
				if(mapa_notas.containsKey(nombre))
				{
					mapa_notas.get(nombre).add(a);
				}
				else
				{
					ArrayList<Asignatura> lista=new ArrayList();
					lista.add(a);
					mapa_notas.put(nombre, lista);
				}
				linea=br.readLine();
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
