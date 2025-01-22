public class Rectangle {
    double height;
    double width;
    
    public Rectangle() { setHeight(1.0); setWidth(1.0); }
    public Rectangle(double h, double w) {setHeight(h); setWidth(w); }
    
    void setHeight(double h) {
        if (h > 0) height = h;
        else height = 1;
    }
    double getHeight() { return height;}
    
    void setWidth(double w) { 
        if (w > 0) width = w;
        else width = 1;
    }
    double getWidth() { return width;}
    double getPerimeter() { return 2 * (height + width); }
    double getArea() { return height * width; }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Rectangle with height: " + height + " and width: "  + width);
        return result.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        Rectangle r = (Rectangle) o;
        if (r.getHeight() == height && r.getWidth() == width)
            return true;
        else    
            return false;
    }
}


