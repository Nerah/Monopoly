package org.modelio.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.monopoly.utils.ScannerUtils;

@objid ("864fd208-1341-4353-ba1e-7697d03f5ac5")
public class Personnage {
    private final static int ACHETER = 1;
    private final static int CONSTRUIRE = 2;

    @objid ("8705da6f-d1c3-40d3-83e5-ae649a940474")
    private String nom;

    @objid ("0081b75f-7afd-4849-b7db-ffc7f45f3bbb")
    private int argent;

    @objid ("a7999915-8d02-4e4f-9c4a-c3e39755a0ca")
    private int deplacement;

    @objid ("9cacb3ed-b978-426b-bfe0-ee0e387bebd8")
    private List<CaseAchetable> proprietes = new ArrayList<CaseAchetable> ();

    @objid ("8f627d31-b01e-440b-b206-1a36d60aaa0f")
    private Case caseSurLaquelleIlSeTrouve;

    @objid ("2dc47f08-fd78-4498-a8c8-7da5b92cc7fa")
    public Personnage(String nom, Case depart) {
        this.nom = nom;
        this.caseSurLaquelleIlSeTrouve = depart;
        this.argent = 1500;
    }

    @objid ("b687ae59-02f8-4374-be56-20d1cee515bc")
    public void deplacer(int nbCases) {
        for (int i = 0; i < nbCases; i++) {
            caseSurLaquelleIlSeTrouve = getPosition().getCaseSuiv();
            getPosition().activate(this);
        }
        this.deplacement = nbCases;
    }

    @objid ("22d5d15d-ccc3-4ad1-9b46-b83d927ec742")
    public void choixSurCase() {
        int choix;
        do {
            afficherInfosJoueur();
            choix = demandeAcheterConstruireOuFinirTour();

            if (choix == ACHETER) acheteCase();
            else if (choix == CONSTRUIRE) construire();
        } while (choix == ACHETER || choix == CONSTRUIRE);
    }

    private static int demandeAcheterConstruireOuFinirTour() {
        System.out.println(ACHETER + " - Acheter la Case");
        System.out.println(CONSTRUIRE + " - Construire");
        System.out.println("<autre> - Passer le tour");

        return ScannerUtils.getNb();
    }

    private void afficherInfosJoueur() {
        System.out.println(
                "[joueur courant] " + getNom()
                        + " [argent restant] " + getArgent()
                        + " [est sur la case] " + getPosition().getNom()
                        + " [prix case] " + getPosition().getPrix()
                        + (getPosition().getQuartier() != null ?
                            " [quartier] " + getPosition().getQuartier().getNom()
                            : "")
        );
    }

    @objid ("595f1a29-1db3-4fa4-8946-2fc1863c2c87")
    public void gagnePropriete() {
        proprietes.add((CaseAchetable) caseSurLaquelleIlSeTrouve);
    }

    @objid ("eed8d598-2d9c-4441-a7e0-fadc31e70c33")
    public void paye(int prix) {
        argent -= prix;
        System.out.println(getNom() + " a payé " + prix + "€.");
    }

    public void gagne(int argent) {
        this.argent += argent;
        System.out.println(getNom() + " gagne " + argent + "€.");
    }

    @objid ("695465ac-53ee-459a-a213-bb0062f89c64")
    public void acheteCase() {
        caseSurLaquelleIlSeTrouve.achat(this);
    }

    @objid ("6737797d-32aa-45ef-ba86-2c98aa82cdda")
    public int getArgent() {
        return argent;
    }

    @objid ("249958c3-33e7-4c7f-8e73-94321b8152d0")
    public boolean possedeQuartier(Quartier quartier) {
        return quartier.appartientA(this);
    }

    @objid ("292db6eb-52f0-411a-8832-9597c64e3917")
    public void construire() {
        List<CaseAchetable> aConstruire = new ArrayList<>();

        int i = 1;
        for (CaseAchetable caseActuelle : proprietes) {
            if (caseActuelle.isConstructible()) {
                aConstruire.add(caseActuelle);
                ++i;
            }
        }

        i = 1;
        if (aConstruire.size() > 0) {
            System.out.println("Liste des propriétés constructibles: ");
            for (CaseAchetable caseConstructible : aConstruire) {
                System.out.println(
                        i + "- " + caseConstructible.getNom()
                                + " [prix] " + caseConstructible.getPrix() + "€"
                                + " [nombre de maisons] " + caseConstructible.getNiveauAmelioration()
                );
            }
            System.out.println("#####################################");
            System.out.println("Veuillez sélectionner l'index associé à la propriété à améliorer: ");
            int choix = ScannerUtils.getNb();
            if (choix >= 1 && choix <= aConstruire.size()) aConstruire.get(choix - 1).construire(this);

        } else System.out.println("Aucune propriété n'est constructible.");
    }

    @objid ("79e4fd1f-cba0-44ce-b3e8-d11a51aff0a7")
    public void payeLoyer() {
        Personnage proprietaireCase = getPosition().getProprietaire();
        int sommeAPayer = getPosition().getLoyer(proprietaireCase);
        paye(sommeAPayer);
        proprietaireCase.gagne(sommeAPayer);
        messagePaiementLoyer(proprietaireCase, sommeAPayer);
    }

    private void messagePaiementLoyer(Personnage proprietaireCase, int sommeAPayer) {
        System.out.println(
                getNom() + " a donné "
                        + sommeAPayer + "€ à "
                        + proprietaireCase.getNom() + " pour avoir loué "
                        + getPosition().getNom()
        );
    }

    @objid ("78ca8bb6-ed97-4a66-8b7d-2f56b12f433d")
    public Case getPosition() {
        return caseSurLaquelleIlSeTrouve;
    }

    @objid ("cee8e48f-3612-4287-bde3-50bb660cad9c")
    public String getNom() {
        return nom;
    }

    public int getDernierDeplacement() {
        return deplacement;
    }

    public List<CaseAchetable> getProprietes() {
        return proprietes;
    }

    public boolean peutPayer() {
        return getPosition().peutEtreAchetee(getArgent());
    }
}
