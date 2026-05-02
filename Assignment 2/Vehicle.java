import java.util.Scanner;

class Vehicle {

    public String brandName;
    public String modelName;

    private double price;
    private double mileage;
    private int speed;

    // Default Constructor
    Vehicle() {
        brandName = "";
        modelName = "";
        price = 0;
        mileage = 0;
        speed = 0;
    }

    // Parameterized Constructor
    Vehicle(String brandName, String modelName, double price, double mileage) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.mileage = mileage;
    }

    // Copy Constructor
    Vehicle(Vehicle v) {
        this.brandName = v.brandName;
        this.modelName = v.modelName;
        this.price = v.price;
        this.mileage = v.mileage;
        this.speed = v.speed;
    }

    public double getPrice() {
        return price;
    }

    public double getMileage() {
        return mileage;
    }

    void start() {
        System.out.println(modelName + " started");
    }

    void stop() {
        System.out.println(modelName + " stopped");
    }

    void drive() {
        System.out.println(modelName + " is driving");
    }

    double calcMileage(double distance, double fuelUsed) {
        mileage = distance / fuelUsed;
        return mileage;
    }

    void changeSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine(); // 🔥 IMPORTANT (fix input bug)

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1));

            System.out.print("Brand Name: ");
            String brand = sc.nextLine();

            System.out.print("Model Name: ");
            String model = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Mileage: ");
            double mileage = sc.nextDouble();
            sc.nextLine(); // 🔥 consume leftover newline

            vehicles[i] = new Vehicle(brand, model, price, mileage);
        }

        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-12s %-10s%n",
                "Brand Name", "Model Name", "Price", "Mileage");
        System.out.println("-------------------------------------------------------------");

        for (Vehicle v : vehicles) {
            System.out.printf("%-15s %-15s %-12.2f %-10.2f%n",
                    v.brandName, v.modelName, v.getPrice(), v.getMileage());
        }

        System.out.println("-------------------------------------------------------------");

        sc.close();
    }
}