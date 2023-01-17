import java.io.*;
import java.awt.Point;

public class PointListCommandLine {

    public static void main(String[] args) throws IOException {
        PointList polygon = new ArrayPointList();
        Point vertex;
        InputStreamReader reader = new InputStreamReader(System.in);
        StreamTokenizer tokens = new StreamTokenizer(reader);

        while (true) {
            tokens.nextToken();
            String tok = tokens.sval;

            switch (tok) {
                case "add":
                    vertex = new Point();

                    tokens.nextToken();
                    vertex.x = (int) tokens.nval;

                    tokens.nextToken();
                    vertex.y = (int) tokens.nval;

                    polygon.append(vertex);
                    break;

                case "curr":
                    System.out.printf("(%d, %d)\n",polygon.getCursor().x,polygon.getCursor().y);
                    break;

                case "next":
                    System.out.println(polygon.goToNext());
                    break;

                case "prev":
                    System.out.println(polygon.goToPrior());
                    break;

                case "start":
                    System.out.println(polygon.goToBeginning());
                    break;

                case "end":
                    System.out.println(polygon.goToEnd());
                    break;

                case "empty":
                    System.out.println(polygon.isEmpty());
                    break;

                case "full":
                    System.out.println(polygon.isFull());
                    break;

                case "clear":
                    polygon.clear();
                    break;

                case "quit":
                    System.exit(-1);
                    break;
            }
        }
    }
}


