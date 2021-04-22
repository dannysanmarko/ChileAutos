package page;

import Utils.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class PictureAuto {

    public PictureAuto() { PageFactory.initElements(new DriverContext().getDriver(), this);}

    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div[2]/div/div[1]/div[3]/div/div/div")
    List<WebElement> rowPicture;

    public void extraccionImagenes() throws IOException {
        for (int x = 0; x<rowPicture.size(); x++) {
            String imagen = "/imagen" +x+ ".jpg";
            String url = rowPicture.get(x).findElement(By.tagName("img")).getAttribute("src");
            System.out.println(url);
            String folder = "C:\\git\\imagenesVehiculos";
            File dir = new File(folder);
            if (!dir.exists())
            if (!dir.mkdir())
                return;
            File file = new File(folder + imagen);
            URLConnection conn = new URL(url).openConnection();
            conn.connect();
            System.out.println("\nempezando descarga: \n");
            System.out.println(">> URL: " + url);
            System.out.println(">> Nombre: " + imagen);
            System.out.println(">> tamaño: " + conn.getContentLength() + " bytes");
            InputStream in = conn.getInputStream();
            OutputStream out = new FileOutputStream(file);
            int b = 0;
            while (b != -1) {
                b = in.read();
                if (b != -1)
                    out.write(b);
            }
            out.close();
            in.close();
        }
    }

}
