public class CorporateWellnessPlan extends MembershipPlan implements RemoteAccess, Freezable {
    private int employeeCount;
    private int workshopsPerMonth;
    private boolean onlineDashboard;

    public CorporateWellnessPlan (String planCode, String clientName,
                                  int months, double baseMonthlyFee,
                                  boolean autoRenew, int employeeCount,
                                  int workshopsPerMonth, boolean onlineDashboard) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.employeeCount = employeeCount;
        this.workshopsPerMonth = workshopsPerMonth;
        this.onlineDashboard = onlineDashboard;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public int getWorkshopsPerMonth() {
        return workshopsPerMonth;
    }

    public boolean isOnlineDashboard() {
        return onlineDashboard;
    }

    @Override
    public boolean hasOnlineAccess() {
        return isOnlineDashboard();
    }

    @Override
    public boolean canFreeze() {
        return (getMonths() >= 6 && getWorkshopsPerMonth() == 0);
    }

    @Override
    public String getPlanType() {
        return "Program CorporateWellness - Siłownia";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double totalPrice = getBaseMonthlyFee();
        totalPrice = totalPrice + (getEmployeeCount() * 18) + (getWorkshopsPerMonth() * 220);
        if (getEmployeeCount() >= 20) {
            totalPrice -= (totalPrice * 0.12);
        }
        if (isOnlineDashboard()) {
            totalPrice += 80;
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRODZAJ KARNETU: " + getPlanType() +
                "\nLICZBA PRACOWNIKÓW OBJĘTYCH PLANEM: " + getEmployeeCount() +
                "\nLICZBA WARSZTATÓW REALIZOWANYCH W MIESIĄCU: " + getWorkshopsPerMonth() +
                "\nCZY FIRMA MA DOSTĘP DO PANELU ONLINE?: " + isOnlineDashboard();
    }
}
