package page;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Auto {

    public Auto() { PageFactory.initElements(new DriverContext().getDriver(), this);}

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[14]/div")
    WebElement txtComentario;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[16]/div")
    WebElement txtComGeneral;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[4]/div/div/div[1]/div")
    WebElement btnImagen;

    public void extraer() throws InterruptedException {
        String comentario = txtComentario.getText();
        String comgeneral = txtComGeneral.getText();
        System.out.println(comentario + "\n" + comgeneral);
        btnImagen.click();
        Thread.sleep(1000);
        PdfQaNovaReports.addWebReportImage("Ingreso a imagenes", "El correcto ingreso a la pagina donde aparecen las imagenes del vehiculo", EstadoPrueba.PASSED, false);

    }
}
