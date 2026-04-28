public class PersonalTrainingPlan extends MembershipPlan {
    private int sessionsPerMonth;
    private int trainerLevel;
    private boolean dietConsultationIncluded;

    public PersonalTrainingPlan (String planCode, String clientName,
                                 int months, double baseMonthlyFee,
                                 boolean autoRenew, int sessionsPerMonth,
                                 int trainerLevel, boolean dietConsultationIncluded) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.sessionsPerMonth = sessionsPerMonth;
        setTrainerLevel(trainerLevel);
        this.dietConsultationIncluded = dietConsultationIncluded;
    }

    public int getSessionsPerMonth() {
        return sessionsPerMonth;
    }

    public int getTrainerLevel() {
        return trainerLevel;
    }

    public void setTrainerLevel(int trainerLevel) {
       if (trainerLevel > 3) {
           throw new IllegalArgumentException("Wartość nie może przekraczać 3!");
       }
       this.trainerLevel = trainerLevel;
    }

    public boolean isDietConsultationIncluded() {
        return this.dietConsultationIncluded;
    }

    @Override
    public String getPlanType() {
        return "Indywidualny Plan Treningowy - Siłownia";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double totalPrice = getBaseMonthlyFee();
        totalPrice = totalPrice + (getSessionsPerMonth() * 70);
        if (getTrainerLevel() == 2) {
            totalPrice += 90;
        }
        if (getTrainerLevel() == 3) {
            totalPrice += 180;
        }
        if (isDietConsultationIncluded()) {
            totalPrice += 50;
        }
        if (isAutoRenew()) {
            totalPrice -= 15;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRODZAJ KARNETU: " + getPlanType() +
                "\nLICZBA TRENINGÓW PERSONALNYCH W  MIESIĄCU: " + getSessionsPerMonth() +
                "\nPOZIOM TRENERA: " + getTrainerLevel() +
                "\nCZY W PAKIECIE ZNAJDUJE SIĘ KONSULATCJA DIETETYCZNA?: " + isDietConsultationIncluded();
    }
}
