/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p1513113
 */
public abstract class FigureGeometrique {

    public abstract void homothetie(double coef);

    public abstract void rotation(double angle);

    public abstract void identite();

    public void affiche() {
        System.out.println("Je suis une figure geometrique de type :");
        identite();
    }

    public void afficheFigures(FigureGeometrique[] tab) {
        for (FigureGeometrique f : tab) {
            f.affiche();
        }
    }

    public void homotethieFigures(FigureGeometrique[] tab, double coeff) {
        for (FigureGeometrique f : tab) {
            f.homothetie(coeff);
        }
    }

    public void rotationFigures(FigureGeometrique[] tab, double angle) {
        for (FigureGeometrique f : tab) {
            f.rotation(angle);
        }
    }
}
