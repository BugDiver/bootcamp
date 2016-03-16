public class Rectangle {
    private final Length length;
    private final Breadth breadth;

    public Rectangle(Length length, Breadth breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int area() {
        return length.getValue()*breadth.getValue();
    }

    public int perimeter() {
        return 2*(length.getValue()+breadth.getValue());
    }
}
