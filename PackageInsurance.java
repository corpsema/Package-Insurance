import java.text.DecimalFormat;
import java.util.Scanner;

public class PackageInsurance extends Package {
    private final double[] INSURANCE = {2.45, 3.95, 5.55}; // Initialized insurance shipping cost

    private double shippingBefore;
    private double shippingCost;
    private double insuranceCost;

    public PackageInsurance(int weight, char shippingMethod)
    {
        super(weight, shippingMethod);

        this.calculateShipping();
    }

    /**
     * This calculates the shipping cost based off the given equation, which is
     * Say the weight of the Package is 10 oz. Then calculated cost will be    8 oz * $2.00 + 2 oz * $3 = $22.0
     * Say the weight of the Package is 20 oz. Then calculated cost will be   8 oz * $2.00 + 8 oz * $3 + 4 oz * $4.5 = $58.0
     * @return
     */

    public double calculateShipping() {
        shippingBefore = super.getShippingCost();
        if (shippingBefore <= 1.00)
            insuranceCost = INSURANCE[0];
        else if (shippingBefore >= 1.01 && shippingBefore <= 3.00)
            insuranceCost = INSURANCE[1];
        else if (shippingBefore >= 3.01)
            insuranceCost = INSURANCE[2];
        // This is meant to take the input from the user to calculate the total amount of oz
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.print("Please enter the total weight in oz");

            int oz = scanner.nextInt(); // Reads user input
            double shippingCost = 0;
            if (oz - 8 < 0) {
                shippingCost += oz * 2;
                return shippingCost;
            } else {
                shippingCost += 8 * 2; // 16
                oz -= 8;
            }

            if (oz - 8 < 0) {
                shippingCost += oz * 3;
                return shippingCost;
            } else {
                shippingCost += 8 * 3; // 24
                oz -= 8;
            }
            shippingCost += oz * 4.5;
            return shippingCost;
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (scanner!=null) {
                scanner.close();
            }
        }
    }

    public void display()
    {

        DecimalFormat f = new DecimalFormat("##.00");
        String formattedShippingCost = f.format(shippingCost);
        String formattedInsuranceCost = f.format(insuranceCost);

        String outputForPackageInsurance = "";
        outputForPackageInsurance += "Weight: " + super.getWeight();
        outputForPackageInsurance += "\nShipping Method: " + super.getShippingMethod();
        outputForPackageInsurance += "\nInsurance: $" + formattedInsuranceCost;
        outputForPackageInsurance += "\nShipping Cost it is insurance: $" + formattedShippingCost;

    }
}
