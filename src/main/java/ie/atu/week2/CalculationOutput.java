package ie.atu.week2;

public class CalculationOutput {
    private String operation;
    private double total ;
    private String warning;

    public CalculationOutput(String operation, double total, String warning) {
        this.operation = operation;
        this.total = total;
        this.warning = warning;
    }

    public String getOperation() {
        return operation;
    }

    public double getTotal() {
        return total;
    }

    public String getWarning() {
        return warning;
    }
}





















