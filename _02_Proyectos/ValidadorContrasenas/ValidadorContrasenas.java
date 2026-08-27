package _02_Proyectos.ValidadorContrasenas;

import java.util.Scanner;

public class ValidadorContrasenas {
    public static void main(String[] args) {
        Scanner sw = new Scanner(System.in);
        System.out.println("Ingrese la contraseña:");
        String contra = sw.nextLine();
        boolean hayMayus = false;
        boolean hayNum = false;
        boolean longVal = contra.length() >= 8;
        for (int i = 0; i < contra.length(); i++) {
            char letra = contra.charAt(i);
            if (letra >= 'A' && letra <= 'Z') {
                hayMayus = true;
            }
            if (letra >= '0' && letra <= '9') {
                hayNum = true;
            }
        }

        if (hayMayus && hayNum && longVal) {
            System.out.println("Contraseña válida.");
        } else {
            System.out.println("Contraseña inválida.");
        }
        sw.close();
    }
}
