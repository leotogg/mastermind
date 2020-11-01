/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.mastermind;
import java.util.Scanner;

/**
 *
 * @author Léo Togg
 */
public class TPMASTERMIND {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Bonjour, quel est votre pseudo ?");
        String pseudoJoueur = sc.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Bonjour " + pseudoJoueur + ". Combien voulez-vous faire de manche(s) ?");
        int nbreManche = sc.nextInt();
        if (nbreManche == 0) {
            System.out.println("Fin du jeu");
            System.exit(0);

        } else {

            System.out.println("----------------------------------------------------------------------");
            System.out.println("Voulez vous jouer Devineur(1) ou Codeur(-1) ");
            int role = sc.nextInt();
            System.out.println("----------------------------------------------------------------------");
            System.out.println("                         Début du jeu !                  ");
            while (role != -1 && role != 1) {
                role = sc.nextInt();
            }
            Joueur joueur = new Joueur(pseudoJoueur, role);
            Joueur pc = new Joueur("PC", -1 * role);

            for (int i = 1; i <= nbreManche; i++) {
                if(joueur.role == 1){
                    System.out.println("----------------------------------------------------------------------");
                    if (i == 1) {
                        System.out.println("Voici la " + (i) + "-ère manche, l'ordinateur a choisi un nouveau code :");
                    } else {
                        System.out.println("Voici la " + (i) + "-eme manche, l'ordinateur a choisi un nouveau code :");
                    }
                    joueur.creerCode(joueur);
                }
                if(joueur.role == -1){
                    joueur.saisirCode(joueur);
                    joueur.listProp(joueur);                    
                }
                    
                System.out.println("----------------------------------------------------------------------");

                while (joueur.nbReponse != 0 && joueur.nbreProp < 10 && i <= nbreManche) {
                    if(joueur.role == 1){
                        joueur.saisirProp(joueur);
                        joueur.verifPlaces(joueur);
                        joueur.finManche(joueur);
                        joueur.incrScore(joueur);
                        
                        joueur.affichProp(joueur);
                        joueur.AfficherJoueur(joueur);
                        joueur.AfficherOrdinateur(joueur);
                    }
                    
                    if(joueur.role == -1){
                        joueur.chooseProp(joueur);
                        joueur.verifProp(joueur);
                        joueur.verifList(joueur);
                        joueur.finManche(joueur);
                        joueur.incrScorepc(joueur);
                        joueur.AfficherJoueur(joueur);
                        joueur.AfficherOrdinateur(joueur);
                    }    
                }
                joueur.nbReponse = 1;
                joueur.nbreProp = 0;
                

            }

        }
        System.out.println("------------------------------");
        System.out.println("La partie est terminée \nMerci d'avoir joué !");
        System.exit(0);
        
    }
    
}
