import java.io.*;
import java.util.Scanner;

public class ex1 {

	private static double tab[] = new double[20];

	public static void ecriture(String nom) throws IOException {
		DataOutputStream sortie = null;

		try {
			FileOutputStream f = new FileOutputStream(nom);
			BufferedOutputStream Buff = new BufferedOutputStream(f);
			sortie = new DataOutputStream(Buff);

			for (int i = 0; i < 20; i++) {

				double n = (Math.random() * 70) - 20;
				sortie.writeDouble(n);
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

	public static void lecture(String nom) throws IOException {
		DataInputStream entree = null;

		try {
			FileInputStream f = new FileInputStream(nom);
			BufferedInputStream Buff = new BufferedInputStream(f);
			entree = new DataInputStream(Buff);

			boolean eof = false;

			while (!eof) {

				double n = 0;
				try {
					n = entree.readDouble();
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
	}

	public static void affiche(String nom) throws Exception {

		DataInputStream entree = null;

		try {
			FileInputStream f = new FileInputStream(nom);
			BufferedInputStream Buff = new BufferedInputStream(f);
			entree = new DataInputStream(Buff);

			for (int i = 0; i < 20; i++) {
				tab[i] = entree.readDouble();
			}

			double ValMin = Double.MAX_VALUE;

			for (int i = 0; i < 20; i++) {
				if (tab[i] < ValMin)
					ValMin = tab[i];
			}
			System.out.println("\nLa valeur minimale est " + ValMin);

			double ValMax = Double.MIN_VALUE;

			for (int i = 0; i < 20; i++) {
				if (tab[i] > ValMax)
					ValMax = tab[i];
			}
			System.out.println("\nLa valeur maximale est " + ValMax);

			double ValMoy = 0;

			for (int i = 0; i < 20; i++) {
				ValMoy += tab[i];
			}
			ValMoy = ValMoy / 20;
			System.out.println("\nLa valeur moyenne est " + ValMoy);
		}

		catch (IOException e) {
			System.out.println("Erreur Lecture Fichier");
		}

		finally {
			if (entree != null)
				entree.close();
		}
		System.out.println("Fichier" + nom + " valeurs cree");
	}

	public static int neg() {

		int comp = 0;

		for (int i = 0; i < 20; i++) {
			if (tab[i] < 0)
				comp += 1;
		}

		return comp;
	}

	public static void contientVal() {

		boolean Cont = false;
		System.out.println("Entrer un entier entre -20 et 50 :");
		Scanner sc = new Scanner(System.in);
		int Val = sc.nextInt();
		int m = 0;

		for (int i = 0; i < 20; i++) {
			m = (int) tab[i];
			if (m == Val)
				Cont = true;
			System.out.println(m);
		}
		if (Cont == true)
			System.out.println(Val + " est la partie entière d'au moins un nombre du fichier");
		else
			System.out.println(Val + " n'est pas la partie entière d'un nombre du fichier");
	}

	public static void ecriture2(String nom) throws IOException {
		DataOutputStream sortie = null;

		try {
			FileOutputStream f = new FileOutputStream(nom);
			BufferedOutputStream Buff = new BufferedOutputStream(f);
			sortie = new DataOutputStream(Buff);

			for (int i = 0; i < 30; i++) {

				double n = (Math.random() * 70) - 10;
				sortie.writeDouble(n);
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

	public static void lecture2() throws IOException {
		String nom;
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom du fichier");
		nom = sc.nextLine();

		DataInputStream entree = null;
		try {
			FileInputStream f = new FileInputStream(nom);
			BufferedInputStream Buff = new BufferedInputStream(f);
			entree = new DataInputStream(Buff);

			boolean eof = false;

			while (!eof) {

				double n = 0;
				try {
					n = entree.readDouble();
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
	}

	public static void ecritureNegPos(String nom) throws IOException {
		DataInputStream entree = null;
		DataOutputStream sortiePos = null;
		DataOutputStream sortieNeg = null;

		try {

			FileInputStream f = new FileInputStream(nom);
			FileOutputStream fd1 = new FileOutputStream("Reels1Pos");
			FileOutputStream fd2 = new FileOutputStream("Reels1Neg");

			sortiePos = new DataOutputStream(fd1);
			entree = new DataInputStream(f);
			sortieNeg = new DataOutputStream(fd2);
			boolean eof = false;
			int n = 0;
			while (!eof) {
				try {
					n = entree.readInt();
					if (n >= 0)
						sortiePos.writeInt(n);
					else
						sortieNeg.writeInt(n);

				} catch (EOFException e) {
					eof = true;
				}
			}
			entree.close();
			sortiePos.close();
			sortieNeg.close();
		} catch (IOException e) {

			System.out.println("Fichier " + nom + " cree");
		}

	}

	public static void ecritureConcate(String nom) throws IOException {
		DataOutputStream sortie = null;

		try {
			FileOutputStream f = new FileOutputStream(nom);
			BufferedOutputStream Buff = new BufferedOutputStream(f);
			sortie = new DataOutputStream(Buff);

			for (int i = 0; i < 20; i++) {
				if (tab[i] > 0)
					sortie.writeDouble(tab[i]);
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

	public static void main(String[] args) throws Exception {

		ecriture("Reels1");
		// lecture("Reels1");
		affiche("Reels1");
		// System.out.println("Il y a " + neg() + " valeur(s) négative(s) dans le
		// fichier.");
		// contientVal();
		// ecriture2("Reels2");
ecritureNegPos("Reels1");
		lecture2();
	}
}
