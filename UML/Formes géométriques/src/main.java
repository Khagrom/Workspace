
/**
 *
 * @author Diane Lakestani
 * @author Vincent Poirier
 */
public class main {

    public static void main(String[] args) {

        Forme[] tab = new Forme[6];

        Point centre = new Point(7, 7);
        float rayon = 10f;
        Cercle cer = new Cercle(centre, rayon);
        tab[0] = cer;

        Point pp1 = new Point(1, -2);
        Point pp2 = new Point(-2, 4);
        Point pp3 = new Point(3, 3);
        Parallelogramme par = new Parallelogramme(pp1, pp2, pp3);
        tab[1] = par;

        Point pr1 = new Point(0, 1);
        Point pr2 = new Point(6, 5);
        Rectangle rec = new Rectangle(pr1, pr2);
        tab[2] = rec;

        Point pl1 = new Point(0, 5);
        Point pl2 = new Point(-1, 0);
        Point pl3 = new Point(1, 0);
        Losange los = new Losange(pl1, pl2, pl3);
        tab[3] = los;

        Point pc1 = new Point(2, 3);
        Point pc2 = new Point(1, 1);
        Carre car = new Carre(pc1, pc2);
        tab[4] = car;

        Point pt1 = new Point(-2, 0);
        Point pt2 = new Point(2, 0);
        Point pt3 = new Point(0, 3);
        Triangle tri = new Triangle(pt1, pt2, pt3);
        tab[5] = tri;

        for (Forme i : tab) {
            System.out.println(i.affiche());
            System.out.println("Aire = " + i.calculAire());
            System.out.println("Périmètre = " + i.calculPerimetre() + "\n");
        }

        System.out.println("On tourne le triangle d'un angle de 90° dans le sens inverse des aiguilles d'une montre par rapport à l'origine : ");
        tri.rotation();
        System.out.println(tri.affiche());
        System.out.println("Aire = " + tri.calculAire());
        System.out.println("Périmètre = " + tri.calculPerimetre() + "\n");
        
        System.out.println("On tourne le triangle d'un angle de 90° dans le sens des aiguilles d'une montre par rapport à l'origine : ");
        tri.rotation(-(float)Math.PI/2);
        System.out.println(tri.affiche());
        System.out.println("Aire = " + tri.calculAire());
        System.out.println("Périmètre = " + tri.calculPerimetre() + "\n");
        
        System.out.println("On vérifie si le carré est bien à la fois un rectangle et un losange (héritage multiple) :");
        System.out.println(car.affiche());
        System.out.println(car.typeRectangle());
        System.out.println(car.typeLosange());

    }
}
