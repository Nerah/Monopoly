package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("868fdf62-e912-421f-92f7-27d7f45eb3f7")
public abstract class CaseAchetable extends Case {
    @objid ("2d64acc2-c484-4159-be86-094909b07663")
    private int prix;

    @objid ("3aafff30-0264-4dc7-a193-88f4ba5a44cb")
    private Personnage proprietaire;

    @objid ("f2dfd58e-39cd-48b7-90d5-f44b5da0d2d7")
    protected EtatAbstrait etat;

    @objid ("ca1e02a1-88ca-4a16-beec-622f0e6820ff")
    private Quartier quartier;

    @objid ("271582a7-23fb-47f9-9e02-46f5ff194552")
    public CaseAchetable(String nom, int prix) {
        super(nom);
        this.prix = prix;
        this.proprietaire = null;
        this.etat = new EtatLibre(this);
    }

    @Override
    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }

    @objid ("4514e2fa-d016-4f73-b014-bdaf84e1cd77")
    public void setEtatAchete() {
        etat = new EtatAchete(this);
    }

    @objid ("42380df3-5ee0-4cdb-878c-c090e34210eb")
    public void setEtatConstructible() {
        etat = new EtatConstructible(this);
    }

    public void setEtatConstruit() {
        etat = new EtatConstruit(this);
    }

    @objid ("9053b307-04fa-4dcf-a5a2-fbd802860bc2")
    public abstract int getLoyer(Personnage perso);

    @objid ("82816215-32a9-4c7b-9751-c99cd6bb700d")
    @Override
    public boolean peutEtreAchetee(int argent) {
        return argent > prix;
    }

    @objid ("e7c2e41b-9ddd-46d4-9318-fdcfc8a98887")
    public Quartier getQuartier() {
        return this.quartier;
    }

    @objid ("23dbaf61-5d2c-4130-bd8e-81feeecbf145")
    @Override
    public Personnage getProprietaire() {
        return proprietaire;
    }

    @objid ("cd525e55-c636-4e86-8fef-9ed613e3d5bc")
    @Override
    public void setProprietaire(Personnage perso) {
        proprietaire = perso;
    }

    @objid ("30eafe5e-b490-4f36-a99e-c88865ad0ba3")
    @Override
    public boolean estPossedee() {
        return proprietaire != null;
    }

    @objid ("a4f8f703-0009-481d-a4e2-b3dab08dae59")
    @Override
    public void achat(Personnage perso) {
        etat.achat(perso);
    }

    @objid ("b1776608-7d56-43cd-8114-4d713ad820ec")
    @Override
    public boolean hasProprietaire() {
        return proprietaire != null;
    }

    @Override
    public int getPrix() {
        return prix;
    }

    public int getNiveauAmelioration() {
        return 0;
    }

    public void ameliorer() {
        System.out.println("Vous ne pouvez pas améliorer cette case.");
    }
}
