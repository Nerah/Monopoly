package org.modelio.monopoly.utils;

import java.util.Scanner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("562ca63b-7034-4461-a14d-eca21ab4e016")
public class ScannerUtils {
    @objid ("2dab9e13-b86b-4d68-b94b-729adfc967df")
    private static Scanner sc = new Scanner(System.in);

    @objid ("3d45c689-b599-445f-8d65-c19178228a85")
    public static int getNb() {
        while(!sc.hasNextInt()) {
            System.out.println("Un entier est attendu!");
            sc.nextLine();
        }
        int res = sc.nextInt();
        sc.nextLine();
        return res;
    }

    @objid ("e2f042db-6912-4190-b07f-f43012744f44")
    public static String getString() {
        return sc.nextLine();
    }

}
