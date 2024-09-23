package л3;


class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    private double Discriminant;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public boolean Discr() {
        return (b * b - 4 * a * c >= 0);
    }
    
    public double [] Koreni() {
        Discriminant = b * b - 4 * a * c;
        double x1;
        double x2;

        if (Discriminant > 0) {
            x1 = (-b + Math.sqrt(Discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(Discriminant)) / (2 * a);

            return new double[] { x1, x2 };
        }

        else if (b * b - 4 * a * c == 0) {
            x1 = (-b + Math.sqrt(Discriminant)) / (2 * a);

            return new double[] { x1 };
        }

        else {
            return new double[0];
        }

    }
    
    public double[] Extremum() {
        if (Discr()) {

            double extrx = -b / 2 * a;
            double extry = (-Discriminant) / (4 * a);

            return new double[] { extrx, extry };
        } else {
            return new double[0];
        }

    }
    
    public Double getMaxKorin() {
        double[] koreni = Koreni();
        if (koreni.length == 0) {
            return null;
        }
        return (koreni.length == 1) ? koreni[0] : Math.max(koreni[0], koreni[1]);
    }

    public String toString() {
        return "Квадратное уравнение{a=" + a + ", b=" + b + ", c=" + c + "}";
    }

    public static QuadraticEquation getMaxKorinEquation(QuadraticEquation[] equations) {
        QuadraticEquation maxEquation = null;
        Double maxKorin = null;

        for (QuadraticEquation equation : equations) {
            Double currentRoot = equation.getMaxKorin();
            if (currentRoot != null && (maxKorin == null || currentRoot > maxKorin)) {
                maxKorin = currentRoot;
                maxEquation = equation;
            }
        }

        return maxEquation;
    }

}
