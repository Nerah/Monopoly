package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("993c3202-e824-49f9-83dd-8fe851e418e5")
public abstract class Case {
    @objid ("d001dd7a-d48a-4712-b9aa-e61be8f8c914")
    private String nom;

    @objid ("d5722607-dcf0-4fa6-8f56-d9380366e13f")
    private Case caseSuivante;

    @objid ("19bc4fd1-03a5-4e86-a910-b5e9525c8b56")
    public Case(String nom) {
        this.nom = nom;
    }

    @objid ("6071ed57-abb3-4bf2-adda-9c318905e490")
    public void setCaseSuiv(Case caseSuivante) {
        this.caseSuivante = caseSuivante;
    }

    @objid ("19db2c3a-2e87-4665-a2fd-ca673dde9d2c")
    public void achat(Personnage perso) {
        System.out.println("Vous ne pouvez pas acheter cette case.");
    }

    @objid ("a9662fe3-9104-4fe3-a413-d8bcbd6304a7")
    public void construire(Personnage perso) {
        System.out.println("Vous ne pouvez pas construire sur cette case.");
    }

    @objid ("f6793f1b-a645-4524-ac1d-c15b67d9dcd1")
    public Case getCaseSuiv() {
        return caseSuivante;
    }

    @objid ("7a968a86-4645-4e54-8c28-f2b19c5ebd1a")
    public void setProprietaire(Personnage perso) {
    }

    @objid ("bf0ff7db-5689-467e-9ba4-46fd6ebb6b5c")
    public Personnage getProprietaire() {
        return null;
    }

    @objid ("0387f74e-ef8f-4408-83e9-00c6b3ef5eda")
    public boolean peutEtreAchetee(int argent) {
        return false;
    }

    @objid ("46d6118c-18a7-4d11-a2a3-011c0c16cec1")
    public boolean estPossedee() {
        return false;
    }

    @objid ("3f6c093b-03bd-4e6b-bd59-1d320a3ab122")
    public boolean estAchetable() {
        return false;
    }

    public void setQuartier(Quartier quartier) {

    }

    @objid ("e0ecb98e-1ada-4f8e-8ec5-d0b154ee58fb")
    public int getLoyer(Personnage proprietaire) {
        return 0;
    }

    @objid ("067eaba0-1d47-4fce-8c3b-2c0445c2dbdd")
    public boolean hasProprietaire() {
        return false;
    }

    @objid ("8b424ecd-5d1c-4279-9f01-f1be6fdb6f01")
    public String getNom() {
        return nom;
    }

    public Quartier getQuartier() {
        return null;
    }

    public boolean isGare() {
        return false;
    }

    public boolean isService() {
        return false;
    }

    public int getPrix() {
        return 0;
    }

    public boolean isPropriete() {
        return false;
    }

    public boolean isConstructible() {
        return false;
    }

    public void activate(Personnage perso) {
    }
}
