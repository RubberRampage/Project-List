import java.util.ArrayList;
import java.util.Arrays;

public class Exercise10_08 {

    public static void main(String[] args) {
        // 2001 Tax Information
        ArrayList<ArrayList<Integer>> bracketsFor2001 = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(27050, 65550, 136750, 297350)), // Single filer
                        new ArrayList<>(Arrays.asList(45200, 109250, 166500, 297350)), // Married jointly or qualifying widow(er)
                        new ArrayList<>(Arrays.asList(22600, 54625, 83250, 148675)), // Married separately
                        new ArrayList<>(Arrays.asList(36250, 93650, 151650, 297350)) // Head of household
                )
        );

        ArrayList<Double> ratesFor2001 = new ArrayList<>(
                Arrays.asList(0.15, 0.275, 0.305, 0.355, 0.391)
        );

        Tax taxFor2001 = new Tax(0, bracketsFor2001, ratesFor2001, 50000);
        printTaxTable(taxFor2001, 50000, 60000, 2001);

        // 2009 Tax Information
        ArrayList<ArrayList<Integer>> bracketsFor2009 = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(8350, 33950, 82250, 171550, 372950)), // Single filer
                        new ArrayList<>(Arrays.asList(16700, 67900, 137050, 208850, 372950)), // Married jointly or qualifying widow(er)
                        new ArrayList<>(Arrays.asList(8350, 33950, 68525, 104425, 186475)), // Married separately
                        new ArrayList<>(Arrays.asList(11950, 45500, 117450, 190200, 372950)) // Head of household
                )
        );

        ArrayList<Double> ratesFor2009 = new ArrayList<>(
                Arrays.asList(0.10, 0.15, 0.25, 0.28, 0.33, 0.35)
        );

        Tax taxFor2009 = new Tax(0, bracketsFor2009, ratesFor2009, 50000);
        printTaxTable(taxFor2009, 50000, 60000, 2009);

        // 2024 Tax Information
        ArrayList<ArrayList<Integer>> bracketsFor2024 = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(11600, 47150, 100525, 191950, 243725)), // Single filer
                        new ArrayList<>(Arrays.asList(23200, 94300, 201050, 383900, 487450)), // Married jointly or qualifying widow(er)
                        new ArrayList<>(Arrays.asList(11600, 47150, 100525, 191950, 243725)), // Married separately
                        new ArrayList<>(Arrays.asList(16550, 63100, 100500, 191950, 243700)) // Head of household
                )
        );

        ArrayList<Double> ratesFor2024 = new ArrayList<>(
                Arrays.asList(0.10, 0.12, 0.22, 0.24, 0.32)
        );

        Tax taxFor2024 = new Tax(0, bracketsFor2024, ratesFor2024, 50000);
        printTaxTable(taxFor2024, 50000, 60000, 2024);
    }

    public static void printTaxTable(Tax tax, int startIncome, int endIncome, int year) {
        System.out.println(year + " Tax Table");
        System.out.println("Taxable\t\tSingle\t\tMarried\t\tMarried\t\tHead of");
        System.out.println("Income\t\tSingle\t\tJoint\t\tSeparate\ta House");

        for (int taxableIncome = startIncome; taxableIncome <= endIncome; taxableIncome += 1000) {
            tax.setTaxableIncome(taxableIncome);

            tax.setFilingStatus(Tax.SINGLE_FILER);
            int taxForStatus0 = (int) tax.getTax();

            tax.setFilingStatus(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER);
            int taxForStatus1 = (int) tax.getTax();

            tax.setFilingStatus(Tax.MARRIED_SEPARATELY);
            int taxForStatus2 = (int) tax.getTax();

            tax.setFilingStatus(Tax.HEAD_OF_HOUSEHOLD);
            int taxForStatus3 = (int) tax.getTax();

            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d%n", taxableIncome, taxForStatus0, taxForStatus1, taxForStatus2, taxForStatus3);
        }
    }
}
