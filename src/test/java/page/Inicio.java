package page;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inicio {

    public Inicio() {PageFactory.initElements(new DriverContext().getDriver(), this);}

    @FindBy(xpath = "//*[@id=\"search-form-container\"]/div/div[1]/a")
    WebElement btnBuscar;

    public void buscar() throws InterruptedException {
        PdfQaNovaReports.addWebReportImage("Ingreso a la pagina", "El correcto ingreso a la pagina ", EstadoPrueba.DONE, false);
        if (btnBuscar == btnBuscar) {
            btnBuscar.click();
            Thread.sleep(11000);
            PdfQaNovaReports.addWebReportImage("Ingreso a la nueva pagina", "El correcto ingreso a la pagina despues de haber presionado el boton de busqueda", EstadoPrueba.PASSED, false);
        }else {
            PdfQaNovaReports.addWebReportImage("Ingreso a la pagina incorrecto", "El incorrecto ingreso a la pagina ", EstadoPrueba.FAILED, false);
        }
    }
}
