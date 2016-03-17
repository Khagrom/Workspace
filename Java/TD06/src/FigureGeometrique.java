/**
 *
 * @author Vincent Poirier
 * @author Fanny Rottee
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

    public static void homotethieFigures(FigureGeometrique[] tab, double coeff) {
        for (FigureGeometrique f : tab) {
            f.homothetie(coeff);
        }
    }

    public static void rotationFigures(FigureGeometrique[] tab, double angle) {
        for (FigureGeometrique f : tab) {
            f.rotation(angle);
        }
    }
}
