package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("592af2ce-6486-4d8b-9fce-df02c48ac6ce")
public class CaseGare extends CaseAchetable {
    @objid ("e55674c4-0454-473c-8184-3fd035d3a203")
    private int charge;

    @objid ("2bce8196-268f-4e4c-bd51-1651bbc22783")
    public CaseGare(String nom, int prix, int loyer) {
        super(nom, prix);
        charge = loyer;
    }

    @Override
    public boolean isGare() {
        return true;
    }

    @objid ("2ad0bf29-c734-470d-a543-344d586ca951")
    @Override
    public int getLoyer(Personnage perso) {
        int res = 0;
        for (Case c : perso.getProprietes()) {
            if (c.isGare()) res++;
        }
        return charge * res;
    }

}
