/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package figures;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *30 mai 2010
 * @author agindre
 */
public class Polygone extends FigureGraphique implements Serializable {

    protected Point_2D[] points;
    protected Point_2D centre = new Point_2D();
    protected int nbPoints;
    public static int nbPoly= 0;

    public Polygone() {
        super();
    }

    public Polygone(String nom, Color cc, Color cr, Point_2D[] points, int nbPoints) {
        super(nom, cc, cr);
        this.points = points;
        this.nbPoints = nbPoints;
        for (Point_2D current : points) {
            centre.x += current.x;
            centre.y += current.y;
        }
        centre.x = centre.x / points.length;
        centre.y = centre.y / points.length;
        nbPoly += 1;
    }

    public int[] getYTab() {
        int[] res = new int[nbPoints];
        for (int i=0; i < nbPoints; i++) {
            res[i] = points[i].y;
        }
        return res;
    }

    public int[] getXTab() {
        int[] res = new int[nbPoints];
        for(int i=0; i < nbPoints; i++) {
            res[i] = points[i].x;
        }
        return res;
    }

    @Override
    public void dessineToi(Graphics g) {
         // installer la couleur de remplissage du rectangle
        g.setColor(cr);
        // dessiner l'interieur du rectangle
        g.fillPolygon(getXTab(), getYTab(), nbPoints);
        // installer la couleur de contour du rectangle
        g.setColor(cc);
        // dessiner le contour du rectangle
        g.drawPolygon(getXTab(), getYTab(), nbPoints);
        // afficher le nom de la figure � partir de son centre
        g.drawString(nom, getCentre().x, getCentre().y);
    }

    @Override
    public double surface() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Point_2D getCentre() {
        return centre;
    }

    @Override
    public void deplace(int dx, int dy) {
        centre.deplace(dx, dy);
    }

    public void translate(Point_2D p) {
        centre.x = centre.x + p.x;
        centre.y = centre.y + p.y;
    }

    @Override
    public boolean contient(Point_2D p) {
        return false;
    }

}