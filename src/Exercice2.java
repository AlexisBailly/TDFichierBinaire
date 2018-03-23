import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercice2 {

	public static void creer(String nom) throws IOException{
		DataOutputStream sortie = null;

		try {
			FileOutputStream f = new FileOutputStream(nom);
			BufferedOutputStream Buff = new BufferedOutputStream(f);
			sortie = new DataOutputStream(Buff);

			for (int i = 0; i < 20; i++) {

				int n = (int) ((Math.random() * 22) -1);
				sortie.writeInt(n);
			}
		}

		catch (IOException e) {
			System.out.println("Erreur Fichier");
		}

		finally {
			sortie.close();
		}
		System.out.println("Fichier " + nom + " cree");
	}

	public static int compte(String nom, int p) throws IOException {
		int count =0;
		DataInputStream entree = null;

		try {
			FileInputStream f = new FileInputStream(nom);
			BufferedInputStream Buff = new BufferedInputStream(f);
			entree = new DataInputStream(Buff);

			boolean eof = false;

			while (!eof) {

				int n = 0;
				
				try {
					n = entree.readInt();
					for(int i = 0; i < 20; i++) {
						if(n == p)
							count+=1;
					}

				} catch (EOFException e) {
					eof = true;
				}
				if (!eof)
					System.out.println(n);	
				
			}
		}
		

		catch (IOException e) {
			System.out.println("Erreur Lecture Fichier");
		}

		finally {
			if (entree != null)
				entree.close();
		}
		System.out.println("Fichier" + nom + " cree");
	
		return (count/20);
	}
	public static void main(String[] args) throws IOException {
		creer("Game");
		System.out.println(compte("Game",19));

	}

}
