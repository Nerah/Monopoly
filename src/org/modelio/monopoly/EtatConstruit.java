package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("787f5a82-3e7c-4c92-bcc4-a074d93c5dd0")
public class EtatConstruit extends EtatAbstrait {
    public EtatConstruit(CaseAchetable caseAchetable) {
        this.caseAchetable = caseAchetable;
    }

    @objid ("470a64bf-1752-4c7c-bfbc-c9f5b9e1a040")
    @Override
    public void construire(Personnage perso) {
        System.out.println("Vous avez déjà un hôtel. Vous en voulez un deuxième aussi? Sigh...");
    }

    @objid ("eb6cefb8-ea13-4f53-a05d-3b5ea4f0ee02")
    @Override
    public void achat(Personnage perso) {
        System.out.println("Vous ne pouvez pas acheter cette case.");
    }

}
