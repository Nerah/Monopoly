package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c63e1d2d-6ae2-4853-8920-7857b5ce05d0")
public class EtatConstructible extends EtatAbstrait {
    public EtatConstructible(CaseAchetable caseAchetable) {
        this.caseAchetable = caseAchetable;
    }

    @objid ("eaa1a16d-e151-44b0-bda0-8cf0d4b83ad5")
    @Override
    public void construire(Personnage perso) {
        if (perso.peutPayer())
            perso.paye(caseAchetable.getPrix());
            if (caseAchetable.getNiveauAmelioration() < 5) {
                caseAchetable.ameliorer();
                if (caseAchetable.getNiveauAmelioration() == 5) caseAchetable.setEtatConstruit();
            }
            else caseAchetable.setEtatConstruit();
    }

    @objid ("262c6152-535c-4cd6-83a7-1eefca4b35a1")
    @Override
    public void achat(Personnage perso) {
        System.out.println("Vous ne pouvez pas acheter cette case.");
    }

    @Override
    public boolean estConstructible() {
        return true;
    }

}
