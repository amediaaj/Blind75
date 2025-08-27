package com.amediaa.challenges;

import com.amediaa.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GenericsChallenge implements Demo {
    @Override
    public void execute() {
        Park park = new Park("Yellowstone National Park", new double[] {44.48, -110.59});
        River river = new River("Mississippi River", new double[][] {
                {47.21, -95.23},
                {35.15, -90.06},
                {29.15, 89.24}
        });

        Layer layer = new Layer(new ArrayList<>(List.of(park, river)));
        layer.addMappable(new Park("Saguaro Nation Monument", new double[] {33.33, -110.10}));
        layer.renderLayer();
    }

    class Layer<T extends Mappable> {
        private List<T> mappables;

        Layer(List<T> mappables) {
            this.mappables = mappables;
        }

        void renderLayer() {
            for (var element : mappables) {
                element.render();
            }
        }

        void addMappable(T mappable) {
            mappables.add(mappable);
        }
    }

    interface Mappable {
        void render();
    }

    abstract class Point implements Mappable {
        private double[] coords;

        Point(double[] coords) {
            this.coords = coords;
        }

        public double[] getCoords() {
            return coords;
        }
    }

    abstract class Line implements Mappable {
        private double[][] coordsArr;

        Line(double[][] coordsArr) {
            this.coordsArr = coordsArr;
        }

        double[][] getCoordsArr() {
            return coordsArr;
        }
    }

    class Park extends Point {

        private String name;

        Park(String name, double[] coords) {
            super(coords);
            this.name = name;
        }

        @Override
        public void render() {
            System.out.printf("Render %s as Point %s%n", name, Arrays.toString(getCoords()));
        }


    }

    class River extends Line {

        private String name;

        River(String name, double[][] coordsArr) {
            super(coordsArr);
            this.name = name;
        }

        @Override
        public void render() {
            System.out.printf("Render %s as Line (", name);
            System.out.print(Arrays.deepToString(getCoordsArr()));
            System.out.println(")");
        }
    }
}
