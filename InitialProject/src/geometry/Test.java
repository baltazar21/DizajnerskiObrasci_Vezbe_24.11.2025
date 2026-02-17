package geometry;
public class Test {
	public static void main(String[] args) {
		// kreiramo objekat klase Point
		Point prvaTacka = new Point();
		//x koordinata prve tacke
		//System.out.println(x); --ne valja
		//System.out.println(Point.x);--ne valja
		//System.out.println(prvaTacka.x);--ne valja
		System.out.println(prvaTacka.getX());
		prvaTacka.setX(150);
		System.out.println(prvaTacka.getX());
		
		Point drugaTacka = new Point();
		System.out.println(drugaTacka.getY());
		drugaTacka.setY(150);
		System.out.println(drugaTacka.getY());
		
		prvaTacka.distance(drugaTacka);
		
		//Zadaci
		
		//1.
		Point point1 = new Point();
		Point point2 = new Point();
		//Line line1 = new Line(); greska
		point1.setX(10);
		point1.setY(20);
		point2.setX(30);
		point2.setY(40);
		
		//3.
		int y = point2.getY();
		point1.setX(y);
		
		//ili
		//point1.setX(point2.getY());
		
		//4.
		//ovde trenutno nece raditi jer vraca null pointer exception
		//pa cu zakomentarisati
		
		//pristup liniji je samo line1
		//pristupamo pocetnoj tacki linije line1.getStartPoint()
		//Point pocetnaTackaLinije = line1.getStartPoint();
		//dobiti x koordinatu pocetne tacke linije
		//int xKoordinata = pocetnaTackaLinije.getX();
		
		//ili u okviru jedne komande - 2. nacin
		//line1.getStartPoint().getX();
		
		//5.
		//line1.setStartPoint(point1);
		//line1.setEndPoint(point2);
		//sada se ne javlja exception jer smo postavili vrednosti
		//za start i end point
		//System.out.println(line1.getStartPoint().getX());
		//System.out.println(line1.getStartPoint().getY());
		//System.out.println(line1.getEndPoint().getX());
		//System.out.println(line1.getEndPoint().getY());
		
		//6.
		//line1.getEndPoint().setY(23);
		//System.out.println(line1.getEndPoint().getY());
		//prenos po referenci
		//System.out.println(point2.getY());
		
		//7.
		//line1.getStartPoint().setX(line1.getEndPoint().getY());
		
		//8. vec je slicno bilo
		
		//9.
		//line1.getEndPoint().setX((int)line1.length()-(line1.getStartPoint().getX()
				//+line1.getStartPoint().getY()));

		//Vezbe 4
		Rectangle rect1= new Rectangle();
		rect1.setUpperLeftPoint(point2);
		rect1.getUpperLeftPoint().setX(10);

		Point novaTacka = new Point(10,15, true);
		System.out.println(novaTacka.getX());

		System.out.println(novaTacka);
		//u pozadini se poziva ovako
		System.out.println(novaTacka.toString());

		//System.out.println(line1);

		int a = 5;
		int b = 5;
		System.out.println(a==b);
		Point novaTacka2 = new Point(10,15, true);
		//kod slozenih tipova operator == poredi reference
		System.out.println(novaTacka==novaTacka2);
		//metoda equals poredi objekte po vrednosti
		//kada se redefinise
		System.out.println(novaTacka.equals(novaTacka2));	
		//System.out.println(novaTacka.equals(line1));	


		//Pete vezbe
		Donut donut1 = new Donut(novaTacka, 50, 45);
		System.out.println(donut1.getInnerRadius());
		System.out.println(donut1.getRadius());
		System.out.println(donut1.selected);
		System.out.println(donut1);

		Circle donut2 = new Donut(novaTacka, 50, 45);
		System.out.println(donut2.getRadius());
		System.out.println(((Donut)donut2).getInnerRadius());

		//apstraktna klasa
		
		Shape shape1 = new Point(50,60);
		Shape shape2 = new Line(new Point(50,20), new Point(70,60));

		System.out.println(shape1.isSelected());

	}

}