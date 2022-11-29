
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;


public class Seminar3 {

    public static void main(String[] args) throws IOException {
        System.out.println(String.join("", "C","e","р","г","е", "й"));
        System.out.println(String.join(",", "C","e","р","г","е", "й"));

        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("\\file.txt");
        File file = new File(pathFile);
        String answer = (file.createNewFile()) ? "File created": "File excists";
        System.out.println(answer);
        
        System.out.println(pathProject);
        System.out.println(pathFile);
        System.out.println(file.getAbsolutePath());

        Logger log = Logger.getLogger(Seminar3.class.getName());
        //ConsoleHandler info = new ConsoleHandler();
        FileHandler info = new FileHandler("log.xml");
        log.addHandler(info);
        //SimpleFormatter sFormat = new SimpleFormatter();
        XMLFormatter xml = new XMLFormatter();
        info.setFormatter(xml);
        //info.setFormatter(sFormat);
        log.log(Level.WARNING, "Test logging 1");
        log.info("Test logging 2");
        
    }
    
}
