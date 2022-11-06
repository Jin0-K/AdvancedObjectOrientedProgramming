package src;

    public class Triangle extends Shape {
        private String name;
        private int x1, y1, x2, y2, x3, y3;

        public Triangle(String name, int min, int max) {
            this.name = name;
            x1 = MyRandom.randInt(min, max);
            y1 = MyRandom.randInt(min, max);
            x2 = MyRandom.randInt(min, max);
            y2 = MyRandom.randInt(min, max);
            x3 = MyRandom.randInt(min, max);
            y3 = MyRandom.randInt(min, max);
        }

        public void calcBounds() {
            setMinBoundsX(min(min(x1, x2), x3));
            setMinBoundsY(min(min(y1, y2), y3));
            setMaxBoundsX(max(max(x1, x2), x3));
            setMaxBoundsY(max(max(y1, y2), y3));
        }

        public String getShapeName() {
            return name;
        }

        private int min(int a, int b) {
            return (a < b) ? a: b;
        }

        private int max(int a, int b) {
            return (a > b) ? a: b;
        }
    }
