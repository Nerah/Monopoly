package org.modelio.monopoly;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("46c60fe1-10b9-400a-b8af-e2e4ba94f489")
public class Plateau {
    @objid ("7cc1f2e8-9850-4d9b-985d-66f0ad272dff")
    private List<Case> cases = new ArrayList<> ();
    private List<Quartier> quartiers = new ArrayList<>();

    @objid ("bae18dd0-211e-4628-827b-abf021628695")
    public Plateau() {
        Quartier quartierRose = new Quartier("Rose");
        Quartier quartierBleu = new Quartier("Bleu");
        Quartier services = new Quartier("Services");

        CaseDepart caseDepart = new CaseDepart("Départ");
        CasePropriete boulevardDeBelleville = new CasePropriete("Boulevard de Belleville", 60, 2);
        CaseAutre caisseDeCommunaute = new CaseAutre("Caisse de Communauté");
        CasePrison prison = new CasePrison("Prison");
        CaseService pascalLeGrandFrere = new CaseService("Pascal le grand frère", 27);
        CasePropriete laCreuse = new CasePropriete("La Creuse", 400, 5000);
        CasePropriete tourcoing = new CasePropriete("Tourcoing", 60, 2000);
        CasePropriete antreDeLOgre = new CasePropriete("Antre de l'ogre", 5, 5);
        
        cases.add(caseDepart);
        cases.add(boulevardDeBelleville);
        cases.add(caisseDeCommunaute);
        cases.add(prison);
        cases.add(pascalLeGrandFrere);
        cases.add(laCreuse);
        cases.add(tourcoing);
        cases.add(antreDeLOgre);

        relieLesCases();

        quartierRose.associer(boulevardDeBelleville);
        services.associer(pascalLeGrandFrere);
        quartierBleu.associer(laCreuse)
                .associer(tourcoing)
                .associer(antreDeLOgre);

        quartiers.add(quartierRose);
        quartiers.add(services);
        quartiers.add(quartierBleu);
    }

    private void relieLesCases() {
        int taille = cases.size(), i = 0;
        while (i < taille) {
            cases.get(i).setCaseSuiv(cases.get((++i) % taille));
        }
    }

    @objid ("26d34e7c-8ca5-4472-b91d-c758d6e3c4fd")
    public Case getCaseDepart() {
        return cases.get(0);
    }

}
