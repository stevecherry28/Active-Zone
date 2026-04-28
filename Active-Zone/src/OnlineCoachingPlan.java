public class OnlineCoachingPlan extends MembershipPlan implements RemoteAccess {
    private int videoConsultations;
    private boolean mealPlanIncluded;
    private boolean recordedLibraryAccess;

    public OnlineCoachingPlan (String planCode, String clientName,
                               int months, double baseMonthlyFee,
                               boolean autoRenew, int videoConsultations,
                               boolean mealPlanIncluded, boolean recordedLibraryAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.videoConsultations = videoConsultations;
        this.mealPlanIncluded = mealPlanIncluded;
        this.recordedLibraryAccess = recordedLibraryAccess;
    }

    public int getVideoConsultations() {
        return videoConsultations;
    }

    public boolean isMealPlanIncluded() {
        return mealPlanIncluded;
    }

    public boolean isRecordedLibraryAccess() {
        return recordedLibraryAccess;
    }

    @Override
    public boolean hasOnlineAccess() {
        return true;
    }

    @Override
    public String getPlanType() {
        return "Coaching Online - Siłownia";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double totalPrice = getBaseMonthlyFee();
        totalPrice = totalPrice + (getVideoConsultations() * 45);
        if (isMealPlanIncluded()) {
            totalPrice += 60;
        }
        if (isRecordedLibraryAccess()) {
            totalPrice += 20;
        }
        if (isAutoRenew()) {
            totalPrice -= 12;
        }
        return totalPrice;
    }

    @Override
    public String toString(){
        return super.toString() + "\nRODZAJ KARNETU: " + getPlanType() +
                "\nLICZBA KONSULTACJI WIDEO W  MIESIĄCU: " + getVideoConsultations() +
                "\nCZY PLAN ŻYWIENIOWY JEST WLICZONY?: " + isMealPlanIncluded() +
                "\nCZY KLIENT MA DOSTĘP DO BIBLIOTEKI NAGRAŃ?: " + isRecordedLibraryAccess();
    }

}
