package coordinate.domain;

import static coordinate.util.NotNullValidator.validateNotNull;

public class Vector {

    private final int x;
    private final int y;

    public Vector(Line line) {
        validateNotNull(line);
        Point p1 = line.getStartPoint();
        Point p2 = line.getEndPoint();
        this.x = p2.minusX(p1);
        this.y = p2.minusY(p1);
    }

    private Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int innerProduct(Vector another) {
        return x * another.x + y * another.y;
    }

    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public Vector invert() {
        return new Vector(-x, -y);
    }
}
