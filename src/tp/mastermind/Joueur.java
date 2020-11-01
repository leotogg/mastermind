/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.mastermind;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Léo Togg
 */
public class Joueur {
    public String pseudo;
    public float score;
    public int role;
    public int[] codeSecret;
    public int[] propositions;
    public int nbreProp;
    public int roleOrdinateur;
    public int nbReponse = 1;
    public int[][] listprop;
    public int[] resultat;
    public int scorepc;

    public Joueur(String pseudoJoueur, int roleJoueur) {
        this.pseudo = pseudoJoueur;
        this.role = roleJoueur;
    }


    public void AfficherJoueur(Joueur joueur) {
        System.out.println("Les caractéristiques du joueurs sont : pseudo " + pseudo + ", rôle " + role + ", nombre de proposition " + nbreProp + ", score " + score);
        
    }

    public void AfficherOrdinateur(Joueur joueur) {
        System.out.println("Les caractéristiques de l'ordinateur sont : rôle " + roleOrdinateur + ", nombre de proposition " + nbreProp + ", score " + scorepc);
    }

    public void creerCode(Joueur joueur) {
        int[] tab = new int[5];
        int nb;
        for (int i = 0; i < tab.length; i++) {
            Random randomCode = new Random();
            nb = randomCode.nextInt(10);
            boolean verif = true;
            while (verif == true) {
                
                for (int j = 0; j < i; j++) {
                    if (nb == tab[j]) {
                        verif = true;
                        nb = randomCode.nextInt(10);
                    }
                    
                }
                verif = false;
            }
            tab[i] = nb;
        }
        System.out.println(Arrays.toString(tab)); //Afficher le code de l'ordinateur

        this.codeSecret = tab;
    }


    public void saisirProp(Joueur joueur) {
        int[] tab = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un code à 5 chiffres ?");

        for (int i = 0; i < tab.length; i++) {

            System.out.println("Entrez le " + (i + 1) + "i-ème numero");
            int numerocode = sc.nextInt();
            while (numerocode > 9) {
                System.out.println("Rentrez un chiffre compris entre 0 et 9.");
                numerocode = sc.nextInt();
            }

            tab[i] = numerocode;
//            System.out.println(tab[i]);
        }
//        System.out.println(Arrays.toString(tab));
        this.propositions = tab;
        this.nbreProp = this.nbreProp + 1;

    }

    public void verifPlaces(Joueur joueur) {
        int bonnereponse = 0;
        int malplace = 0;

        for (int i = 0; i < this.codeSecret.length; i++) {
            for(int j = 0; j < this.codeSecret.length; j++){
                if (this.codeSecret[i] == this.propositions[j] && i == j) {
                    bonnereponse = bonnereponse + 1;
                }
                if (this.codeSecret[i] == this.propositions[j] && i != j){
                    malplace = malplace + 1;
                }
                
                
            }
        }
        System.out.println("Vous avez " + bonnereponse + " chiffre(s) bien placés).");
        System.out.println("Vous avez " + (5 - bonnereponse - malplace) + " chiffre(s) qui n'existe(nt) pas).");
        System.out.println("Vous avez " + malplace + " chiffre(s) mal placés).");
        this.nbReponse = 5-bonnereponse;
    }

    public void finManche(Joueur joueur) {
//        listProp(joueur);
        if (this.nbReponse == 0) {
            System.out.println("------------------------------");
            System.out.println("La manche est terminée,\nBien joue Beau gosse !");
            this.role = this.role * -1;
            
        }
    }

    public void incrScore(Joueur joueur) {
        int score = 10 - this.nbreProp;
        this.score = score;

    }

    public void affichProp(Joueur joueur) {
        System.out.println(Arrays.toString(this.propositions));
    }
    
    
    
    
    
//--------------------------------------- part 2 ------------------------------ 
    
    
    
    
    
    public void saisirCode(Joueur joueur){        
        //méthode qui permet au joeur de rentrer un code secret
        
        int[] tab = new int[5];        
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un code secret Ã  5 chiffres ?");
        System.out.println("Entrez le premier numÃ©ro");
        int numero1 = sc.nextInt();
        while (numero1 > 9){                    
                System.out.println("Rentrez un chiffre compris entre 0 et 9.");
                numero1 = sc.nextInt();
        }
        tab[0] = numero1;
        
        for(int i = 1; i < tab.length; i++){
            
            System.out.println("Entrez le "+ (i+1) +"-Ã¨me numÃ©ro");           
            int numerocode = sc.nextInt();
            while (numerocode > 9){                
                System.out.println("Rentrez un chiffre compris entre 0 et 9.");
                numerocode = sc.nextInt();
            }
            boolean verif = true;
            while(verif == true){
                verif = false;
                for(int j = 0; j < i; j++){
                    if (tab[j] == numerocode){
                        verif = true;
                        System.out.println("Rentrez un numÃ©ro diffÃ©rent d'un des numÃ©ros des prÃ©cÃ©dents");
                        numerocode = sc.nextInt();
                        while (numerocode > 9){                
                            System.out.println("Rentrez un chiffre compris entre 0 et 9.");
                            numerocode = sc.nextInt();
                        }    
                    }
                } 

            }
 
            tab[i] = numerocode;
//            System.out.println(tab[i]);
        }

    this.codeSecret = tab;
    }
    
    public void listProp(Joueur joueur){
                                                            // méthode qui permet de créer une matrice contenant toutes les propositions possibles
        System.out.println("dedans 1");
        int[][] listeprop = new int[15120][5];              //creation d'une matrice de taille 15120x5
        int[] tab = new int[5];                             //création d'un tableau qui va accueillir une proposition
        int nb;

//        }
        for (int k = 0; k<15120; k++){                      //boucle qui parcourt toute la matrice pour la remplir de prop tte differentes entre elles
//            System.out.println("dedans 2");
            boolean exist;
            exist = true;
            while (exist == true){
                exist = false;
                
                for (int i = 0; i < 5; i++) {               //creation d'une proposition dont les chiffres sont differents entre eux
                    
                    Random randomCode = new Random();
                    nb = randomCode.nextInt(10);
                    boolean verif = true;
                    while (verif == true) {
                        verif = false;

                        for (int j = 0; j < i; j++) {
                            
                            if (nb == tab[j]) {
                                verif = true;
                                nb = randomCode.nextInt(10);
                            }

                        }
                    }
                    tab[i] = nb;
                }    
//                System.out.println(Arrays.toString(tab));

                for (int i = 0; i<k; i++){                  //on parcourt la matrice jusque la ligne k pour verifier que la prop n'existe pas deja
                    int compteur = 0;                       //on initialise un compteur
                    for (int j = 0; j<5; j++){
                        if (tab[j] == listeprop[i][j]) {
                        compteur = compteur +1;             //compte le nombre d'elements egaux entre la ligne de la matrice et la proposition
                        }
                        if (compteur == 5) {                //si le compteur vaut 5 cela veut dire que tous les elements sont identiques, la proposition existe donc deja
                            exist = true;                   //la variable exist permet de sortir de la boucle while si elle vaut false, ici on veut recreer une nouvelle prop, donc rester dans le while         
                        }
                    }
                   
                }                                
            }
            System.arraycopy(tab, 0, listeprop[k], 0, 5);  //permet de copier la proposition dans la ligne k de la matrice, fonction comme un double for

        }
        System.out.println("dedans 4");
//        for (int i = 0; i<15120; i++){                   //boucle qui permet d'afficher la matrice
//            for (int j = 0; j<5; j++){   
//                System.out.print(listeprop[i][j]);
//            }
//            System.out.println("");
//        }
        this.listprop = listeprop;                        //on attribut la matrice que l'on vient de creer a la variable de notre classe joeur
   
    }
    
    public void chooseProp(Joueur joueur){
        //methode qui permet de tirer une proposition au hasard parmi celles de la matrice qui contient la liste de ttes les prop restantes
        int nb;
        int[] tab = new int[5];
        Random randomCode = new Random();
        int pif = this.listprop.length;
        System.out.println("pif "+pif);
        nb = randomCode.nextInt(pif);
        for(int i =0; i<5; i++){
            tab[i] = this.listprop[nb][i];
        }
        this.propositions = tab;
    }
    
    public void verifProp(Joueur joueur) {
        //methode qui permet au joueur de comparer son code secret à la prop que l'ordi lui soumet
        System.out.println(Arrays.toString(this.codeSecret));   //affiche le code secret du joueur
        System.out.println(Arrays.toString(this.propositions)); //affiche la prop de l'ordi
        Scanner sc = new Scanner(System.in);
        System.out.println("Combien de chiffre sont bien placés ?");
        int nbbienplace = sc.nextInt();
        System.out.println("Combien de chiffre sont bons mais mal placés ?");
        int nbmalplace = sc.nextInt(); 
        System.out.println("Combien de chiffre sont mauvais ?");
        int nbmauvais = sc.nextInt();
        int[] tab = new int[3];
        tab[0] = nbbienplace;
        tab[1] = nbmalplace;
        tab[2] = nbmauvais;
        this.resultat = tab;                                    //on stocke la comparaison dans un tableau que l'on nomme resultat
        this.nbReponse = 5 - nbbienplace;
        this.nbreProp = this.nbreProp + 1;
        
    }
    
    public void verifList(Joueur joueur){
        //methode qui permet de comparer la proposition de l'ordi à ttes les prop de la liste, puis garder celles qui ont le même resultat que la comparaison avec le code secret du joueur
        //methode vraiment pas opti mais osef
        System.out.println("veriflist");
        int taillelist = 0;
        int indice = 0;
        System.out.println(this.listprop.length);
        for(int k = 0; k < this.listprop.length; k++){
            //premiere boucle qui permet de compter cb de prop ont le meme resultat, permet d'obtenir la taille du tableau ou on va les stocker
            int bonnereponse = 0;
            int malplace = 0;
            int[] tab = new int[3];
            for(int i = 0; i<5; i++){
                for(int j = 0; j < 5; j++){
                    if (this.listprop[k][i] == this.propositions[j] && i == j) {
                        bonnereponse = bonnereponse + 1;
                    }
                    if (this.listprop[k][i] == this.propositions[j] && i != j){
                        malplace = malplace + 1;
                    }
                }
            }    
            tab [0] = bonnereponse;
            tab[1] = malplace;
            tab[2] = 5-bonnereponse-malplace;
//            System.out.println(Arrays.toString(tab)+" tab");
//            System.out.println(Arrays.toString(this.resultat)+ " resultat");
            if (tab[0] == this.resultat[0] && tab[1] == this.resultat[1]&&tab[2] == this.resultat[2]){//on verifie si le resultat est le meme que celui avec le code secret
                taillelist = taillelist + 1;  //determine la taille de la nouvelle matrice
//                System.out.println(taillelist + "if");
            }
            
        }
        System.out.println(taillelist + "apres if");
        
        int[][] nvllist = new int[taillelist][5]; //on initialise une nouvelle matrice de taille tallelistx5 où on va stocker les bonnes prop
        
        for(int k = 0; k < this.listprop.length; k++){
            //compare encore une fois la prop aux prop de la liste
            int bonnereponse = 0;
            int malplace = 0;
            int[] tab = new int[3];
            for(int i = 0; i<5; i++){
                for(int j = 0; j < 5; j++){
                    if (this.listprop[k][i] == this.propositions[j] && i == j) {
                        bonnereponse = bonnereponse + 1;
                    }
                    if (this.listprop[k][i] == this.propositions[j] && i != j){
                        malplace = malplace + 1;
                    }
                }
            }    
            tab [0] = bonnereponse;
            tab[1] = malplace;
            tab[2] = 5-bonnereponse-malplace;
            if (tab[0] == this.resultat[0] && tab[1] == this.resultat[1]&&tab[2] == this.resultat[2]){
                //si le resultat est identique, on copie la prop dans la nouvelle liste
//                System.out.println("wsh la detail");
                for (int i=0; i<5; i++){                      
//                    System.out.println(indice);
                    nvllist[indice][i]= this.listprop[k][i];
                    
                }
                indice = indice + 1; //permet de passer a la ligne suivante dans notre nouvelle matrice
            }
            
        }
//        System.out.println(Arrays.toString(nvllist));
        this.listprop = nvllist;   //affecte la nouvelle liste a la liste de la classe
        
//        System.out.println(this.listprop.length); //sert juste a afficher la matrice pour faire des tests
//        for (int i = 0; i<this.listprop.length; i++){
//            for (int j = 0; j<5; j++){   
//                System.out.print(this.listprop[i][j]);
//            }
//            System.out.println("");
//        }
        
    }
    
    public void incrScorepc(Joueur joueur) {
        int score = 10 - this.nbreProp;
        this.scorepc = score;

    }
    
    
}
