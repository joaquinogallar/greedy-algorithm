
public class Main {
    public static void main(String[] args) {
        Board p = new Board();
        p.setBoardDimension(10, 10);
        p.generateNumbers();
        p.start(p.setStartPoint(0, 0));
        System.err.println("--------------------");
        System.out.println("Puntos totales: " + p.getPoints());
        System.err.println("--------------------");
    }
}
