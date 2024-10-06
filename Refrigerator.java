public class Refrigerator extends Appliance{
    public Refrigerator(int power, double size) {
        super(power, size, "холодосик");
    }

    public double getPrice() {
                if (getPower() > 1800) {
            return 12000 + getSize() * 800;
        }
        else {
            return (12000 + getSize() * 800)*0.8;
        }
    }
}
