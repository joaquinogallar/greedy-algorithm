public class Main {
    public static void main(String[] args) {
        GreedyAlgorithm ga = new GreedyAlgorithm();
        ga.setBoardDimension(10, 10);
        ga.generateNumbers();
        ga.start(ga.setStartPoint(0, 0));
        System.err.println("--------------------");
        System.out.println("Total Points: " + ga.getPoints());
        System.err.println("--------------------");
    }
}
