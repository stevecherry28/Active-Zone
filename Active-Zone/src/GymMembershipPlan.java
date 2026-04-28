import java.io.Serializable;

public class GymMembershipPlan extends MembershipPlan implements Freezable {
    private int entriesPerMonth;
    private boolean saunaAccess;

    public GymMembershipPlan (String planCode, String clientName,
                              int months, double baseMonthlyFee,
                              boolean autoRenew, int entriesPerMonth,
                              boolean saunaAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.entriesPerMonth = entriesPerMonth;
        this.saunaAccess = saunaAccess;
    }

    public int getEntriesPerMonth() {
        return entriesPerMonth;
    }

    public boolean isSaunaAccess() {
        return saunaAccess;
    }

    @Override
    public boolean canFreeze() {
    return (getMonths() >= 3);
    }

    @Override
    public String getPlanType() {
        return "Miesięczny Karnet - Siłownia";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double totalPrice = getBaseMonthlyFee();
        totalPrice = totalPrice + (getEntriesPerMonth() * 4);
        if (isSaunaAccess()) {
            totalPrice += 25;
        } if (isAutoRenew()) {
            totalPrice -= 10;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRODZAJ KARNETU: " + getPlanType() +
                "\nWEJŚCIA W MIESIĄCU: " + getEntriesPerMonth() +
                "\nCZY UWZGLĘDNIONA SAUNA? : " + isSaunaAccess();
    }



}
