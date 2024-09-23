package л3;

public class Main {
    public static void main(String[] args) {
        QuadraticEquation[] equations = {
            new QuadraticEquation(1, -3, 2),   
            new QuadraticEquation(1, -2, 1),   
            new QuadraticEquation(1, 2, 1),   
            new QuadraticEquation(1, 1, 1)     
        };

        QuadraticEquation maxRootEquation = QuadraticEquation.getMaxKorinEquation(equations);
        
        if (maxRootEquation != null) {
            System.out.println("Уравнение с самым больщим корешком: " + maxRootEquation);
            System.out.println("Самый большой корешок: " + maxRootEquation.getMaxKorin());
        } else {
            System.out.println("К счастью, корней нет ни в одном из уравнений");
        }
    }
}

