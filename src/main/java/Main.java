import java.io.File;

public class Main {
    public static void main(String[] args){
        File app = new File("D:\\OneDrive - CIBERTEC\\Aby2024\\NTTData\\TechGirlPower\\11 - Automatizacion mobile\\Proyecto base\\apkinfo.apk");
        System.out.println("RUTA: " + app.getAbsolutePath().replace("\\", "/"));
    }
}
