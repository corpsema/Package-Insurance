import java.util.Scanner;

public class TestPackage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the weight in oz");
        Object weight = in.toString();
        System.out.println("Please select A for air, T for truck, or M for mail");
        Object shippingMethod = in.toString();

        Package[] packageArray = new Package[3];

        packageArray[0] = weight(3, 'A');
        packageArray[1] = weight(10, 'T');
        packageArray[2] = weight(15, 'M');

        System.out.println("Would you like insurance with your product? (y/n)");
        Object insurance = in.toString();
        PackageInsurance[] PackageInsuranceArray = new PackageInsurance[0];
        if (insurance == "y") {
            PackageInsuranceArray = new PackageInsurance[3];
            PackageInsuranceArray[0] = (PackageInsurance) shippingMethod(14, 'M');
            PackageInsuranceArray[1] = (PackageInsurance) shippingMethod(4, 'T');
            PackageInsuranceArray[2] = (PackageInsurance) shippingMethod(20, 'A');
        }

        System.out.println("Displaying Packages");
        for (Package p : packageArray)
            p.display();

        System.out.println("\nDisplaying Insured Packages");
        for (PackageInsurance ip : PackageInsuranceArray)
            ip.display();
    }

    private static Object shippingMethod(int i, char a) {
        return null;
    }

    private static Package weight(int i, char a) {
        return null;
    }
}


