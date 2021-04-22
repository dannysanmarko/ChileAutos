package TestClass;

import page.Auto;
import page.Inicio;
import page.PictureAuto;
import page.Vehiculos;

import java.io.IOException;

public class TestExtraer {

    Inicio inicio;
    Vehiculos vehiculos;
    Auto auto;
    PictureAuto pictureAuto;

    public void extraccion() throws InterruptedException, IOException {
        inicio = new Inicio();
        inicio.buscar();
        vehiculos = new Vehiculos();
        vehiculos.seleccion();
        auto = new Auto();
        auto.extraer();
        pictureAuto = new PictureAuto();
        pictureAuto.extraccionImagenes();
    }
}
