package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b1916280-d848-4aaa-bec7-881a1542bf2f")
public class EtatLibre extends EtatAbstrait {
    public EtatLibre(CaseAchetable caseAchetable) {
        this.caseAchetable = caseAchetable;
    }

    @objid ("4c1ad33e-a108-4b64-9d9b-1a5a455da524")
    @Override
    public void construire(Personnage perso) {
        System.out.println("Cette case n'est pas constructible. Il faut l'acheter d'abord.");
    }

    @objid ("e062d081-79fa-4f36-8bf6-8f27d2acfa4a")
    @Override
    public void achat(Personnage perso) {
        if (perso.peutPayer()) {
            caseAchetable.setProprietaire(perso);
            perso.gagnePropriete();
            perso.paye(caseAchetable.getPrix());

            System.out.println(perso.getNom() + " a acheté " + caseAchetable.getNom() + "!");

            Quartier quartierCase = caseAchetable.getQuartier();
            if (quartierCase.appartientA(perso)) {
                quartierCase.devientConstructible();

                System.out.println("Les cases de ce groupe sont maintenant constructibles");
            } else caseAchetable.setEtatAchete();
        } else System.out.println(perso.getNom() + " est trop pauvre pour se le permettre.");
    }

}
