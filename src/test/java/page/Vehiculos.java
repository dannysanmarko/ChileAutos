package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class Vehiculos {

    public Vehiculos(){PageFactory.initElements(new DriverContext().getDriver(), this);}

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div/div/a")
    WebElement listaAuto;

    @FindBy(xpath = "//*[@id=\"1e505deed3832c02c96ca5abe70df9ab\"]/div/div[2]/div[1]/div[3]")
    WebElement btnRobot;

    public void seleccion() throws InterruptedException {
        listaAuto.click();
        Thread.sleep(1000);
        PdfQaNovaReports.addWebReportImage("Ingreso a la pagina del vehiculo ", "El correcto ingreso a la pagina dodne aparece toda la informacion del vehiculo en venta ", EstadoPrueba.PASSED, false);

        /*List<WebElement> filas = listaAuto.findElements(By.tagName("div"));
        int cantFilas = filas.size();
        int producto = Integer.parseInt(ReadProperties.readFromConfig("propiedades.properties").getProperty("indice"));
        for (int i = 0;i<cantFilas;i++){
            if (i == producto){
                filas.get(i).click();
                PdfQaNovaReports.addWebReportImage("Ingreso a la pagina del vehiculo ", "El correcto ingreso a la pagina dodne aparece toda la informacion del vehiculo en venta ", EstadoPrueba.PASSED, false);
                break;
            }
        }*/
    }
}
