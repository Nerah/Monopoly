package org.modelio.monopoly;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("35ec5bb1-5c83-41cb-a1ac-1ed22d9c2e9c")
public class Quartier {
    @objid ("76dfda28-1ab5-49ec-9813-8416508db1db")
    private String nom;

    private List<CaseAchetable> casesAchetables = new ArrayList<>();

    @objid ("f5e5aa26-45c6-45b6-a8c8-361f28f9afa8")
    public Quartier(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getNbCases() {
        return casesAchetables.size();
    }

    public Quartier associer(CaseAchetable caseAchetable) {
        casesAchetables.add(caseAchetable);
        caseAchetable.setQuartier(this);
        return this;
    }

    public boolean appartientA(Personnage perso) {
        for (CaseAchetable c : casesAchetables) {
            if (c.getProprietaire() != perso) return false;
        }
        return true;
    }

    public void devientConstructible() {
        for (CaseAchetable c : casesAchetables) {
            c.setEtatConstructible();
        }
    }
}
