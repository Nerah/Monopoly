package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d34e1ccb-35c1-4bc1-9a32-ba38c3d99207")
public class CasePropriete extends CaseAchetable {
    @objid ("7f9bb4bf-6c94-4bb7-a8e5-64b73f5c989d")
    private int loyer;

    private int niveauAmelioration = 0;

    @objid ("fe6b418f-cd0e-401c-b238-c1dbc1ea6a0b")
    public CasePropriete(String nom, int prix, int loyer) {
        super(nom, prix);
        this.loyer = loyer;
    }

    @objid ("73520ae2-d1b3-4f52-aa06-8d692d0bfaeb")
    public void ameliorer() {
        ++niveauAmelioration;
        System.out.println("La propriété est passé au niveau " + niveauAmelioration);
    }

    @objid ("1a1a7138-45c3-448a-b15a-1c95e3ca8926")
    @Override
    public void construire(Personnage perso) {
        etat.construire(perso);
    }

    @Override
    public boolean isConstructible() {
        return etat.estConstructible();
    }

    @objid ("e831e3dc-0a71-48ba-8350-0c8fbe8b8b79")
    @Override
    public int getLoyer(Personnage perso) {
        if (niveauAmelioration > 0) return loyer * niveauAmelioration * 4;
        else if (perso.possedeQuartier(getQuartier())) return loyer * 2;
        return loyer;
    }

    @Override
    public boolean isPropriete() {
        return true;
    }

    @Override
    public int getNiveauAmelioration() {
        return niveauAmelioration;
    }
}
