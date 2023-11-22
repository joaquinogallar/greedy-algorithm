import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GreedyAlgorithm {
    static final int VISITED = 0;
    private List<List<Integer>> board;
    private int points;

    public GreedyAlgorithm() {
        board = new ArrayList<>();
        points = 0;
    }

    public int getPoints() {
        return points;
    }

    public List<List<Integer>> getBoard() {
        return board;
    }

    public void setBoardDimension(int x, int y) {
        for (int i = 0; i < y; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < x; j++) {
                row.add(0);
            }
            board.add(row);
        }
    }

    public void printBoard() {
        for (List<Integer> li : board) {
            for (Integer i : li) {
                System.out.printf("%-4d", i);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void generateNumbers() {
        Random r = new Random();
        for (List<Integer> li : board)
            for (int i = 0; i < li.size(); i++)
                li.set(i, r.nextInt(100) + 1);

    }

    public HashMap<String, Integer> setStartPoint(int x, int y) {
        HashMap<String, Integer> position = new HashMap<>();
        position.put("x", x);
        position.put("y", y);
        return position;
    }

    public void makeMove(HashMap<String, Integer> actualPosition, String axis) {
        actualPosition.put(axis, actualPosition.get(axis) + 1);
        board.get(actualPosition.get("y")).set(actualPosition.get("x"), VISITED);
    }

    public void start(HashMap<String, Integer> startPosition) {
        HashMap<String, Integer> actualPosition = new HashMap<>(startPosition);
        printBoard();
        update(actualPosition, startPosition.get("y"), startPosition.get("x"));
    }
    
    private void update(HashMap<String, Integer> actualPosition, int y, int x) {
        points += board.get(y).get(x);
        board.get(y).set(x, VISITED);
        printBoard();
    
        while (actualPosition.get("x") + 1 < board.get(0).size() && actualPosition.get("y") + 1 < board.size()) {
            if (board.get(actualPosition.get("y")).get(actualPosition.get("x") + 1) > board
                    .get(actualPosition.get("y") + 1).get(actualPosition.get("x"))) {
                points += board.get(actualPosition.get("y")).get(actualPosition.get("x") + 1);
                makeMove(actualPosition, "x");
            } else {
                points += board.get(actualPosition.get("y") + 1).get(actualPosition.get("x"));
                makeMove(actualPosition, "y");
            }
    
            printBoard();
        }
    }
    

    public void move(HashMap<String, Integer> actualPosition, String axis) {
        actualPosition.put(axis, actualPosition.get(axis) + 1);
        board.get(actualPosition.get("y")).set(actualPosition.get("x"), VISITED);
    }
}
