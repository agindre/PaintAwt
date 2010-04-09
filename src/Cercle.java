import java.awt.*;

public class Cercle extends FigureGraphique
{
	protected Point_2D centre;
	protected int rayon;

	/**
	 * Constructeurs
	 */
	// constructeur valu� 
	public Cercle(String nom,Color cc,Color cr, int x, int y, int r)
	{
		super(nom,cc,cr);
		centre = new Point_2D(x,y);
		rayon=r;
	}


	/**
	 * Concretisation Figure
	 * calcul du centre du Segment
	 */
	public String toString(){
		return new String(" cercle : "+ nom +" centre : "+ centre.toString()+
			" rayon : "+ rayon+"\n\t\t couleur remlissage: "+cr+" couleur contour "+cc );
	}

	/**
	 * Implementation FigureGraphique
	 * calcul du centre du cercle
	 */
	public Point_2D getCentre()
	{	return centre;	}

	/**
	 * Concretisation FigureGraphique
	 * D�placement du cercle = deplacement du centre
	 */
	public void deplace(int dx, int dy)
	{	centre.deplace(dx,dy);	}

	/**
	 * Concretisation FigureGraphique
	 * Affichage contenu
	 */

	public void dessineToi(Graphics g)
	{
		// installer la couleur du cercle
		 g.setColor(cr);
		// dessiner le remplissage du cercle	
		 g.fillOval(getCentre().x-rayon,getCentre().y-rayon,rayon*2,rayon*2);
		 g.setColor(cc);
		// dessiner le contour du cercle	
		 g.drawOval(getCentre().x-rayon,getCentre().y-rayon,rayon*2,rayon*2);
		 g.drawString(nom,getCentre().x,getCentre().y);
	}


	/**
	 * Concretisation FigureGraphique
	 * test de contenu
	 */
	public boolean contient(Point_2D p)
	{	return (Point_2D.distance(centre, p) < rayon);	}

	/**
	 * Concretisation de FigureGraphique
	 * calcul de surface
	 */

	public double surface (){
		return Math.PI*rayon*rayon;
	}
}	