public abstract class MembershipPlan implements Billable {
    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    public MembershipPlan(String planCode, String clientName,
                          int months, double baseMonthlyFee,
                          boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public String getPlanCode() {
        return planCode;
    }

    public String getClientName() {
        return clientName;
    }

    public int getMonths() {
        return months;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public abstract String getPlanType();

    public abstract double calculateMonthlyNetPrice();

    public double calculateMonthlyGrossPrice() {
        return calculateMonthlyNetPrice() * 1.23;
    }

    public double calculateTotalNetPrice() {
        return calculateMonthlyNetPrice() * months;
    }

    public final void printSummary() {
        System.out.println("---Podsumowanie---");
        System.out.println("Numer planu: " + getPlanCode());
        System.out.println("Dane klienta: " + getClientName());
        System.out.println("Miesięczna cena netto: " + calculateTotalNetPrice());
        System.out.println("Miesięczna cena brutto " + calculateMonthlyGrossPrice());
        System.out.println("Cena całego planu: " + calculateTotalNetPrice());
    }

    @Override
    public String toString() {
        return "Klient{numerPlanu='" + getPlanCode() +
                "', imieINazwisko= '" + getClientName() +
                "', miesiace= '" + getMonths() +
                "', bazowaMiesiecznaOplata= '" +
                getBaseMonthlyFee() +
                "',odnowaAutomatyczna= '" +
                isAutoRenew() + "}";
    }
}
