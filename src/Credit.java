
public class Credit {
    private String clientName;
    private double amount;
    private double annualInterestRate;
    private int durationMonths;

    public Credit(String clientName, double amount, double annualInterestRate, int durationMonths) {
        this.clientName = clientName;
        this.amount = amount;
        this.annualInterestRate = annualInterestRate;
        this.durationMonths = durationMonths;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    /**
     * Monthly payment using the standard amortization formula.
     */
    public double monthlyPayment() {
        double monthlyRate = annualInterestRate / 12.0 / 100.0;
        if (monthlyRate == 0) {
            return amount / durationMonths;
        }
        double factor = Math.pow(1 + monthlyRate, durationMonths);
        return amount * (monthlyRate * factor) / (factor - 1);
    }

    public double totalToRepay() {
        return monthlyPayment() * durationMonths;
    }

    public void display() {
        System.out.println("Client: " + clientName);
        System.out.println("Amount: " + amount);
        System.out.println("Annual interest rate: " + annualInterestRate + "%");
        System.out.println("Duration: " + durationMonths + " months");
        System.out.printf("Monthly payment: %.2f%n", monthlyPayment());
        System.out.printf("Total to repay: %.2f%n", totalToRepay());
    }

    public static void main(String[] args) {
        Credit credit = new Credit("Kaloba Leger", 10000.0, 8.5, 24);
        credit.display();
    }
}
