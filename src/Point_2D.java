
class Point_2D
{
	// attributs d'instance
	protected int x;
	protected int y;

	// attributs de classe
	protected static int nbPoints = 0;
	protected static final int epsilon = 5;

	/**
	 * Constructeurs
	 */
	// constructeur par d�faut
	public Point_2D ()
	{
		x = 0;
		y = 0;
		nbPoints++;
	}

	// constructeur valu�
	public Point_2D ( int x, int y)
	{
		this.x = x;
		this.y = y;
		nbPoints++;
	}

	// constructeur de copie
	public Point_2D (Point_2D p)
	{
		x = p.x;
		y = p.y;
		nbPoints ++;
	}

	// nettoyeur avant destruction
	protected void finalize()
	{
		nbPoints--;
	}

	/**
	 * Accesseurs
	 */
	public int getX () { return x; }
	public int getY () { return y; }
	public void setX (int val) { x = val; }
	public void setY (int val) { y = val; }

	public static int getNbPoints()
	{
		return nbPoints;
	}

	/**
	 * Affichage contenu
	 */
	// toString est une m�thode classique en Java, elle est pr�sente
	// dans les objets de type Object, on pourra dinc ainsi l'utiliser
	// dans une �ventuelle Liste de points.
	public String toString()
	{
		return new String (" x = " + getX() + " y = " + getY());
	}

	/**
	 * op�rations sur un point
	 */
	public void deplace(int dx, int dy)
	{
		this.x = dx;
		this.y = dy;
	}

	/**
	 * M�thodes de classe : op�rations sur les points
	 */

	public static double distance(Point_2D p1, Point_2D p2)
	{
		// on  remarquera que l� aussi on
		// utilise des m�thodes statiques
		// de l'objet Math : sqrt

		int dx = p1.x-p2.x;
		int dy = p1.y-p2.y;

		return Math.sqrt((dx*dx)+(dy*dy));
	}

	public  double distance(Point_2D p)
	{
		// on  remarquera que l� aussi on
		// utilise des m�thodes statiques
		// de l'objet Math : sqrt

		int dx = x-p.x;
		int dy = y-p.y;

		return ((int)Math.sqrt((dx*dx)+(dy*dy)));
	}

	public static boolean equal (Point_2D p1, Point_2D p2)
	{
		return (Point_2D.distance(p1,p2) < epsilon);
	}


}