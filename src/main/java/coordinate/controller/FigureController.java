package coordinate.controller;

import coordinate.domain.Figure;
import coordinate.domain.FigureFactory;
import coordinate.domain.Point;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class FigureController {
    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 1;
    private final Figure figure;

    public FigureController() {
        FigureFactory figureFactory = new FigureFactory();
        this.figure = createFigure(figureFactory);
    }

    private Figure createFigure(FigureFactory figureFactory) {
        try {
            return figureFactory.create(createPoints());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createFigure(figureFactory);
        }
    }

    private List<Point> createPoints() {
        List<Point> points = new ArrayList<>();
        for (String s : InputView.inputPoints()) {
            String[] xy = s.split(",");
            points.add(new Point(Integer.parseInt(xy[X_INDEX]), Integer.parseInt(xy[Y_INDEX])));
        }
        return points;
    }

    public void printResult() {
        OutputView.printPoints(figure.getPoints());
        OutputView.printResult(figure);
    }
}
