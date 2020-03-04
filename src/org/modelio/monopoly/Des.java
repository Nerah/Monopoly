package org.modelio.monopoly;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.monopoly.utils.RandomUtils;

@objid ("252444f3-9928-4e68-8a16-07d1738473c4")
public class Des {
    @objid ("bc287feb-1e40-4e54-b549-1ccb47f1eb6f")
    private static int nbDes = 2;

    @objid ("daca1824-4a87-4f39-8b85-28028b35a36c")
    public static int lancerDes() {
        int res = 0;
        for (int i = 0; i < nbDes; i++) {
            res += RandomUtils.randomIntInRange(1, 6);
        }
        return res;
    }

}
