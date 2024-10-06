public abstract class Appliance implements Comparable<Appliance> {
    private int power;
    private double size;
    private String name;

    public Appliance(int power, double size, String name) {
        this.name = name;
        this.power = power;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    
    public double getSize() {
        return size;
    }

    public abstract double getPrice();

    public int compareTo(Appliance other) {
        return Double.compare(this.size, other.size);
    }

    public String toString() {
        return "Прибор: " + name + ", мощность(вт): " + power + ", размер(метры кубические): " + size + ", цена: " + getPrice()
                + " грн";
    }
} 
