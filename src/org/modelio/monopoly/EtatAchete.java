package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ee12ea19-d76b-4c3d-9b43-d9656ddf6448")
public class EtatAchete extends EtatAbstrait {
    public EtatAchete(CaseAchetable caseAchetable) {
        this.caseAchetable = caseAchetable;
    }

    @objid ("6260ba22-aed0-4426-84ce-7f7a9db75152")
    @Override
    public void construire(Personnage perso) {
        System.out.println("Cette case n'est pas constructible. Il faut acheter toutes les cases du même quartier.");
    }

    @objid ("b7f6420c-4d35-4b66-ba5c-de6f7c8bf8df")
    @Override
    public void achat(Personnage perso) {
        System.out.println("Cette case a déjà été acheté. Mais un pourboire ne me dérange pas.");
    }

}
