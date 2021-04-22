package TestSuite;

import TestClass.TestExtraer;
import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RecuperarInformacion   {
    @BeforeTest
    public void setUp() {

        String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("web");
        DriverContext.setUp(Navegador.Chrome, url);
        PdfQaNovaReports.createPDF();
    }

    @AfterTest
    public void end() {

        DriverContext.closeDriver();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void extraccion() throws InterruptedException, IOException {
        TestExtraer extraer = new TestExtraer();
        extraer.extraccion();
    }
}
