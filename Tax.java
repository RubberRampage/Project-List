import java.util.ArrayList;

public class Tax {
    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;

    private int filingStatus;
    private ArrayList<ArrayList<Integer>> brackets;
    private ArrayList<Double> rates;
    private double taxableIncome;

    public Tax(int filingStatus, ArrayList<ArrayList<Integer>> brackets, ArrayList<Double> rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTax() {
        double tax = 0;
        ArrayList<Integer> bracket = brackets.get(filingStatus);
        if (taxableIncome <= bracket.get(0)) {
            tax = taxableIncome * rates.get(0);
        } else {
            tax = bracket.get(0) * rates.get(0);
            int i;
            for (i = 1; i < bracket.size(); i++) {
                if (taxableIncome > bracket.get(i)) {
                    tax += (bracket.get(i) - bracket.get(i - 1)) * rates.get(i);
                } else {
                    break;
                }
            }
            tax += (taxableIncome - bracket.get(i - 1)) * rates.get(i);
        }
        return tax;
    }
}
