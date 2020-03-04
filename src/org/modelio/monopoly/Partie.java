package org.modelio.monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.monopoly.utils.ScannerUtils;

@objid ("87014e21-8ad3-430d-92af-5ef2427e6be7")
public class Partie {
    @objid ("9eec0f85-ee37-4c85-9ce7-61ad08669803")
    private final static int LANCER_DES = 1;

    @objid ("5bfcc29d-5eb7-4011-bfca-ff94a4510d0b")
    private final static int TRICHER_DES = 2;

    @objid ("5dfa799a-2060-435e-b04d-97ec68040eb2")
    private List<Personnage> personnages = new ArrayList<> ();

    @objid ("4771fcba-f3d2-4c59-8ead-331164a4c664")
    private Plateau plateau;

    @objid ("90012106-c74c-48cf-b0eb-ef9e5dffa365")
    private Personnage persoCourant;

    @objid ("9ec55b42-21ee-4ab9-b48b-58476083cc28")
    public void lancerPartie(int nbJ) {
        plateau = new Plateau();
        
        saisieNomsJoueurs(nbJ);
        setOrder();
        setJoueurCourant(personnages.get(0));
        
        while (!finPartie()) jouerTour();

        System.out.println(personnages.get(0).getNom() + " a gagné la partie!");
    }

    @objid ("378fb82d-950e-46ca-beb5-08cbf97f19e5")
    public void setJoueurCourant(Personnage perso) {
        persoCourant = perso;
        System.out.println("C'est au tour de " + perso.getNom());
    }

    @objid ("9038073e-360e-4652-a5c3-3f97163ac438")
    public void setOrder() {
        Collections.shuffle(personnages);
    }

    @objid ("780eba1f-c4ed-4d52-9596-f787b7a104e6")
    public void joueurSuivant() {
        int indexJoueurCourant = personnages.indexOf(persoCourant);
        setJoueurCourant(personnages.get((indexJoueurCourant + 1) % personnages.size()));
    }

    @objid ("9e588292-3444-4a1f-a4c5-60bf95020946")
    public boolean finPartie() {
        AtomicInteger comptePersoAvecArgent = new AtomicInteger();
        for (Personnage perso : personnages)
            if (perso.getArgent() > 0) comptePersoAvecArgent.incrementAndGet();
        return comptePersoAvecArgent.get() < 2;
    }

    @objid ("16ca2f36-161b-463b-b7aa-1ba4f8b130c9")
    public void finTour() {
        if (persoCourant.getArgent() <= 0) {
            System.out.println(persoCourant.getNom() + " est ruiné et a perdu la partie!");
            personnages.remove(persoCourant);
        }
        joueurSuivant();
    }

    @objid ("339c4e7e-673e-4c99-ba3b-aee0401fbbd8")
    public void createDepart() {
    }

    @objid ("5a3a97d2-fceb-4f7b-bf8d-7f0653509a1f")
    public void jouerTour() {
        int scoreDes, choix;
        Case caseActuelle;
        
        choix = demandeLanceDesOuQuitterPartie();
        
        // quitte la partie.
        if (choix != LANCER_DES && choix != TRICHER_DES) {
            forceFinDePartie();
            return;
        }
        
        // lancer les dés
        if (choix == 1) scoreDes = lancerLesDes();
        else scoreDes = tricherAuxDes();
        
        System.out.println("[Score dés] " + scoreDes);
        persoCourant.deplacer(scoreDes);
        
        caseActuelle = persoCourant.getPosition();
        if (caseActuelle.hasProprietaire() && caseActuelle.getProprietaire() != persoCourant)
            persoCourant.payeLoyer();
        else persoCourant.choixSurCase();
        finTour();
    }

    @objid ("30f8a190-ad19-457a-9797-aa6a8e6ec8b7")
    private void saisieNomsJoueurs(int nbJ) {
        Case depart = plateau.getCaseDepart();
        IntStream.range(0, nbJ).forEach(i -> {
            System.out.println("[" + (i+1) + "/" + nbJ + "] - Entrez le nom du joueur: ");
            personnages.add(new Personnage(ScannerUtils.getString(), depart));
        });
    }

    @objid ("f1043296-cf2a-455c-ace7-63577d81c535")
    private void forceFinDePartie() {
        personnages.clear();
    }

    @objid ("6926c891-4066-4f0a-a3a9-2fe46ba807af")
    private static int lancerLesDes() {
        return Des.lancerDes();
    }

    @objid ("09e7daa0-585c-48d4-a1cb-d62bc2d4c396")
    private static int tricherAuxDes() {
        System.out.println("[Message du système] Tu devrais avoir honte...");
        System.out.println("De combien de cases avancer? ");
        return ScannerUtils.getNb();
    }

    @objid ("6a18a7b4-3280-4aff-9044-b0a4fcbc0f7e")
    private static int demandeLanceDesOuQuitterPartie() {
        System.out.println(LANCER_DES + " - Lancez les dés");
        System.out.println(TRICHER_DES + " - Tricher aux dés");
        System.out.println("<autre> - Quitter la partie");
        return ScannerUtils.getNb();
    }

}
