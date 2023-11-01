import java.util.*;
public class atm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String atmNumber, cardIssuerName = null;
        int multipliedNumbers = 1, addedValues = 0, evenNumberAdded = 0;

        System.out.print("Enter your 16 digits ATM Number : ");
        atmNumber = scanner.nextLine();
        atmNumber = atmNumber.replaceAll(" ", ""); // Remove spaces from the input

        if (atmNumber.length() != 16) {
            System.out.println("Couldn't recognize, please enter your 16 digits ATM number.");
        } else {
            for (int i = 0; i < atmNumber.length() - 1; i += 2) {
                char cToI = atmNumber.charAt(i);
                int cToIConverted = Character.getNumericValue(cToI);
                multipliedNumbers *= cToIConverted * 2;
                String itosConverted = Integer.toString(multipliedNumbers);
                if (itosConverted.length() >= 2) {
                    addedValues += multipliedNumbers % 10 + multipliedNumbers / 10;
                } else {
                    addedValues += multipliedNumbers;
                }
                multipliedNumbers = 1;
            }

            for (int j = 1; j <= atmNumber.length() - 2; j += 2) {
                char cToIForEven = atmNumber.charAt(j);
                int cToIConvertedEven = Character.getNumericValue(cToIForEven);
                evenNumberAdded += cToIConvertedEven;
            }

            int finalAddedValues = 10 - ((addedValues + evenNumberAdded) % 10);
            char firstATMNumber = atmNumber.charAt(0);
            int firstATMNumberConverted = Character.getNumericValue(firstATMNumber);
            char lastATMNumber = atmNumber.charAt(atmNumber.length() - 1);
            int lastATMNumberConverted = Character.getNumericValue(lastATMNumber);

            if (firstATMNumberConverted == 4) {
                cardIssuerName = "Visa";
            } else if (firstATMNumberConverted == 5) {
                cardIssuerName = "MasterCard";
            } else if (firstATMNumberConverted == 6) {
                cardIssuerName = "Rupay";
            }

            if (finalAddedValues == lastATMNumberConverted) {
                System.out.println("Your " + cardIssuerName + " ATM card Number is Original.");
                System.out.println("Thank You, have a Nice Day!");
            } else {
                System.out.println("Sorry, Your " + cardIssuerName + " ATM card Number is not Original,");
                System.out.println("Please contact your nearby bank branch.");
            }
        }
    }
}