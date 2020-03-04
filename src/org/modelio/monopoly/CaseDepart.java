package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c83aeddc-4100-42ac-a1d6-438ce675118e")
public class CaseDepart extends Case {
    @objid ("9f99a500-959f-41e1-8c8a-dc81e6dd57e8")
    public CaseDepart(String nom) {
        super(nom);
    }

    @Override
    public void activate(Personnage perso) {
        perso.gagne(200);
    }
}
