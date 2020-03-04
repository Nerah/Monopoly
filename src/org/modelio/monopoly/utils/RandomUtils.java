package org.modelio.monopoly.utils;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("08fd4a95-b8d7-4984-8b47-42818c53f26a")
public class RandomUtils {
    @objid ("0563c8e3-262f-4155-911c-f00239af3b7f")
    public static int randomIntInRange(int min, int max) {
        return min  + (int)(Math.random() * ((max - min) + 1));
    }

}
