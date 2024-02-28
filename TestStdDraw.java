import java.util.ArrayList;
import java.util.List;

public class TestStdDraw {
    private static double pointX = 0.5;
    private static double pointY = 0.5;
    private static List<Line> lines = new ArrayList<>();
    private static final double LINE_THICKNESS = 0.005; // Adjusted line thickness for better visibility

    public static void main(String[] args) {
        StdDraw.setPenRadius(0.005); // Adjusted pen radius for better visibility
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenColor(StdDraw.MAGENTA);

        // Add horizontal lines
        for (double y = 0.1; y <= 0.9; y += 0.1) {
            lines.add(new Line(-0.1, 1.1, y, true)); // Extend lines beyond screen boundaries
        }

        // Add vertical lines
        for (double x = 0.1; x <= 0.9; x += 0.1) {
            lines.add(new Line(x, x, -0.1, false)); // Extend lines beyond screen boundaries
        }

        while (!gameOver) {
            StdDraw.clear();
            drawScene();
            checkCollision();
            StdDraw.show(20); // Adjust the frame rate
        
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                handleKeyPress(key);
            }
        
            moveLines();
        }
    }

    private static void drawScene() {
        for (Line line : lines) {
            if (line.isHorizontal()) {
                StdDraw.line(line.getStartX(), line.getY(), line.getEndX(), line.getY()); // Draw horizontal line
            } else {
                StdDraw.line(line.getX(), line.getStartY(), line.getX(), line.getEndY()); // Draw vertical line
            }
        }
        StdDraw.setPenColor(StdDraw.RED); // Set ball color
        StdDraw.filledCircle(pointX, pointY, LINE_THICKNESS); // Draw filled circle as ball
    }

    private static void checkCollision() {
        for (Line line : lines) {
            if (line.isHorizontal()) {
                if (Math.abs(pointY - line.getStartY()) < LINE_THICKNESS / 2 &&
                        pointX >= line.getStartX() && pointX <= line.getEndX()) {
                    return; // Exit the method if collision detected, do not call handleCollision() yet
                }
            } else {
                if (Math.abs(pointX - line.getX()) < LINE_THICKNESS / 2 &&
                        pointY >= line.getStartY() && pointY <= line.getEndY()) {
                    return; // Exit the method if collision detected, do not call handleCollision() yet
                }
            }
        }
        // If no collision detected after checking all lines, then call handleCollision()
        handleCollision();
    }

private static void handleKeyPress(char key) {
    switch (key) {
        case 'a':
            pointX -= 0.01; // Adjusted movement speed
            break;
        case 'd':
            pointX += 0.01; // Adjusted movement speed
            break;
        case 'w':
            pointY += 0.01; // Adjusted movement speed
            break;
        case 's':
            pointY -= 0.01; // Adjusted movement speed
            break;
        case '1':
            lines.add(new Line(-0.1, 1.1, Math.random(), true)); // Add a new random horizontal line
            break;
        case '2':
            lines.add(new Line(Math.random(), Math.random(), -0.1, false)); // Add a new random vertical line
            break;
        case '3':
            if (!lines.isEmpty()) {
                lines.remove(lines.size() - 1); // Remove the last line
            }
            break;
    }
}

    private static void moveLines() {
        for (Line line : lines) {
            if (line.isHorizontal()) {
                line.setStartX(line.getStartX() + 0.002); // Adjusted movement speed
                line.setEndX(line.getEndX() + 0.002); // Adjusted movement speed
                // Wrap lines when they go off-screen
                if (line.getEndX() > 1.1) {
                    line.setStartX(-0.1);
                    line.setEndX(1.1);
                }
            } else {
                line.setStartY(line.getStartY() + 0.002); // Adjusted movement speed
                line.setEndY(line.getEndY() + 0.002); // Adjusted movement speed
                // Wrap lines when they go off-screen
                if (line.getEndY() > 1.1) {
                    line.setStartY(-0.1);
                    line.setEndY(1.1);
                }
            }
        }
    }

    private static boolean gameOver = false;

    private static void handleCollision() {
        gameOver = true;
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(0.5, 0.5, "Game Over");
        StdDraw.show();
    }
}