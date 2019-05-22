package coordinate.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static coordinate.util.NotNullValidator.validateNotNull;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        validateNotNull(p1);
        validateNotNull(p2);
        validateNoDuplication(Arrays.asList(p1, p2));
        this.p1 = p1;
        this.p2 = p2;
    }

    private void validateNoDuplication(List<Point> points) {
        if ((new HashSet<>(points)).size() != points.size()) {
            throw new IllegalArgumentException("선분을 만들 때 중복되는 점이 존재하면 안 됩니다.");
        }
    }

    public double calculateDistance() {
        return Math.sqrt(Math.pow(calculateXDifference(), 2)
                        + Math.pow(calculateYDifference(), 2));
    }

    public double calculateSlope() {
        return (double) calculateYDifference() / calculateXDifference();
    }

    public boolean isHorizontal() {
        return calculateYDifference() == 0;
    }

    public boolean isVertical() {
        return calculateXDifference() == 0;
    }

    private int calculateXDifference() {
        return p2.getX() - p1.getX();
    }

    private int calculateYDifference() {
        return p2.getY() - p1.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return (Objects.equals(p1, line.p1) &&
                Objects.equals(p2, line.p2)) ||
                (Objects.equals(p1, line.p2) &&
                Objects.equals(p2, line.p1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2);
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}