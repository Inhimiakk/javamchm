public class Wash_machine extends Appliance {
    public Wash_machine(int power, double size) {
        super( power, size, "Стиралочка");
    }
    
    public double getPrice() {
        if (getPower() > 1500) {
            return 10000 + getSize() * 1000;
        }
        else {
            return (10000 + getSize() * 1000)*0.7;
        }
    }
}
