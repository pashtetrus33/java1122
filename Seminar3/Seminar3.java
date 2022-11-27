package Seminar3;

import java.io.File;

public class Seminar3 {
    public static void main(String[] args) {
        System.out.println(String.join("", "C","e","р","г","е", "й"));
        System.out.println(String.join(",", "C","e","р","г","е", "й"));

        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("\\file.txt");
        File f3 = new File(pathFile);
        
        System.out.println(pathProject);
        System.out.println(pathFile);
        System.out.println(f3.getAbsolutePath());
        
    }
    
}
