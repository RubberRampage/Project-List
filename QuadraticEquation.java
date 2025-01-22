class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    
    public QuadraticEquation() {
        
    }
    
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
    
    public double getDiscriminant() { return Math.pow(b, 2) - 4 * a * c;}
    public double getRoot1() { 
        double det = getDiscriminant();
        return ( -b + Math.sqrt(det) ) / (2 * a);
    }
    
    public double getRoot2() { 
        double det = getDiscriminant();
        return ( -b - Math.sqrt(det) ) / (2 * a);
    }
    
}