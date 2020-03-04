package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ec0884b0-0225-470c-be06-a71d1cf40462")
public abstract class EtatAbstrait {
    @objid ("8562a54a-bb9a-4c73-9456-cec7bbf77912")
    protected CaseAchetable caseAchetable;

    @objid ("f4099fdc-ae80-4992-b90e-cb720bfb1225")
    public abstract void construire(Personnage perso);

    @objid ("9c309f7a-f608-4971-a5a9-1e36fc384f04")
    public abstract void achat(Personnage perso);

    public boolean estConstructible() {
        return false;
    }
}
