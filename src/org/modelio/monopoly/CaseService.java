package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("0ac0e2de-dfed-457e-be2e-0cc781c6fc25")
public class CaseService extends CaseAchetable {
    @objid ("90e9b498-a6c3-47df-9680-bfb5d964f8e5")
    public CaseService(String nom, int prix) {
        super(nom, prix);
    }

    @Override
    public boolean isService() {
        return true;
    }

    @objid ("e5b2802c-369b-4230-aae6-d68f6180f17b")
    @Override
    public int getLoyer(Personnage perso) {
        int res = 0;
        for (Case c : perso.getProprietes()) if (c.isService()) res++;
        if (res == 2) return 10 * perso.getDernierDeplacement();
        return 4 * perso.getDernierDeplacement();
    }

}
