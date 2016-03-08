/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p1513113
 */
public interface FormeGeometrique2D extends Affichable {

    void deplace(double dx, double dy);

    boolean estIdentique(Object o);
}
