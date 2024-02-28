public class Line {
    private double startX;
    private double endX;
    private double startY;
    private double endY;
    private boolean horizontal;

    public Line(double startX, double endX, double y, boolean horizontal) {
        this.startX = startX;
        this.endX = endX;
        this.horizontal = horizontal;
        if (horizontal) {
            this.startY = y;
            this.endY = y;
        } else {
            this.startY = startY;
            this.endY = y;
        }
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public double getX() {
        return startX;
    }

    public double getY() {
        return startY;
    }
}