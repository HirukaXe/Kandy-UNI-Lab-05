import java.util.Scanner;

public class IT26202408Lab5Q3 {
    public static final double ROOM_CHARGE_PER_DAY = 48000.00;
    public static final double DISCOUNT_3_TO_4_DAYS = 10.0;
    public static final double DISCOUNT_5_OR_MORE_DAYS = 20.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Start Date (1-31): ");
        int startDate = scanner.nextInt();

        System.out.print("Enter End Date (1-31): ");
        int endDate = scanner.nextInt();

        if (startDate < 1 || startDate > 31 || endDate < 1 || endDate > 31) {
            System.out.println("Error: Days must be between 1 and 31");
            scanner.close();
            return;
        }

        if (startDate >= endDate) {
            System.out.println("Error: Start Date must be less than End Date");
            scanner.close();
            return;
        }

        int daysReserved = endDate - startDate;
        double totalCost = daysReserved * ROOM_CHARGE_PER_DAY;

        double discountRate = 0.0;
        if (daysReserved >= 3 && daysReserved <= 4) {
            discountRate = DISCOUNT_3_TO_4_DAYS;
        } else if (daysReserved >= 5) {
            discountRate = DISCOUNT_5_OR_MORE_DAYS;
        }

        double discountAmount = totalCost * (discountRate / 100.0);
        double totalAmountToBePaid = totalCost - discountAmount;

        System.out.println();
        System.out.println("Room Charge Per Day: Rs. " + ROOM_CHARGE_PER_DAY + "/=");
        System.out.println("Number of Days Reserved: " + daysReserved);
        System.out.println("Total Amount to be Paid: " + totalAmountToBePaid);

        scanner.close();
    }
}