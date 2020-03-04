package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.monopoly.utils.ScannerUtils;

@objid ("53a6aa14-8449-4ddf-8c32-640562d4f412")
public class Main {
    @objid ("cf5c8034-5e55-4851-a097-5def4ea0237e")
     static Partie partie = new Partie();

    @objid ("ba3dbc19-4737-4f72-82b5-12fb2339e62d")
    public static void lancerPartie(Partie partie) {
        int nbJoueurs = demanderNbJoueurs();
        partie.lancerPartie(nbJoueurs);
    }

    @objid ("856649ea-8859-4f99-8ca3-56dc4aebb647")
    public static void main(String[] args) {
        lancerPartie(partie);
        System.out.println("La partie est terminée.");
    }

    @objid ("e1efb827-c646-4a84-8be4-0d7aff6828e7")
    private static int demanderNbJoueurs() {
        System.out.println("Nombre de joueurs: ");
        return ScannerUtils.getNb();
    }

}
