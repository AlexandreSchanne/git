package senCity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Stats2 {


	public static void testIntervalle(String args[]){
		long pars1 = Long.parseLong(args[2]);
		long pars2 = Long.parseLong(args[3]);
		long lePlusGrand;
		long lePlusPetit;

		FileReader flot;
		BufferedReader flotfiltre;

		if(pars1-pars2 <0){
			lePlusPetit = pars1;
			lePlusGrand = pars2;
		}else{
			lePlusPetit = pars2;
			lePlusGrand = pars1;
		}



		try{
			flot = new FileReader(args[0]);						// Fichier � lire : d�fini avec args[0]
			flotfiltre = new BufferedReader(flot);				// Cr�ation d'un flot sur le fichier pour en sortir les valeurs

			String ligne = flotfiltre.readLine();				// On lis la premi�re ligne (titre)
			while((ligne = flotfiltre.readLine()) != null){		// Tant que la ligne n'est pas nulle (� partir de la deuxi�me ligne)
				Scanner sc = new Scanner(ligne);				// Scanner sur "ligne"
				sc.useDelimiter(",");							// On d�compose les ligne en mot tous les ","
				String s = sc.next();							// On regarde le premier mot de la ligne
				long s1 = Long.parseLong(s);
				if(s1 >= lePlusPetit && s1 <=lePlusGrand ){	// Fonction de test dans un intervalle de deux timestamp
					System.out.print(s + " ");					// On affiche le timestamp s'il est bon
					while(sc.hasNext()){						// On regarde tant qu'il reste des mots sur la ligne
						s = sc.next();							// On regarde le mot suivant, apr�s la virgule
						System.out.print(s + " ");				// On affiche le mot suivant pour avoir la ligne compl�te. Avec un espace pour que ce soit propre
					}			
					System.out.println();						// println pour sauter une ligne
				}
			}

		}catch(IOException e)									// arriv� � la fin du document, plus de ligne
		{System.out.println("pas de ligne");					// Message d'erreur
		}


	}

}

