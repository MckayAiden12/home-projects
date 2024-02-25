public class TestStdDraw {
    private static double pointX = 0.5;
    private static double pointY = 0.5;

    public static void main(String[] args) {
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2);

        StdDraw.point(pointX, pointY);

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                switch (key) {
                    case 'a':
                        pointX -= 0.05;
                        break;
                    case 'd':
                        pointX += 0.05;
                        break;
                    case 'w':
                        pointY += 0.05;
                        break;
                    case 's':
                        pointY -= 0.05;
                        break;
                }
                StdDraw.clear();
                StdDraw.setPenRadius(0.05);
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.setPenColor(StdDraw.MAGENTA);
                StdDraw.line(0.2, 0.2, 0.8, 0.2);
                StdDraw.point(pointX, pointY);
            }
            if (Math.abs(pointY - 0.2) < 0.02) { // Check if the point is close enough to the line
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.text(0.5, 0.5, "Game Over");
                StdDraw.show();
                break; // Exit the loop
            }
        }
    }
}