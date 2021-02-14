package no.ntnu.karolisw.oblig2;

public abstract class Membership {
    private int bonusPointBalance;
    private int newPoints;
    private String membershipName;

    protected abstract int registerPoints(int bonusPointBalance, int newPoints);
    protected abstract String getMembershipName();

    public Membership(int bonusPointBalance){
        this.bonusPointBalance = bonusPointBalance;
    }

    public abstract int getBonusPointBalance();

    @Override
    public String toString() {
        return "\nMembership details: " +
                "\nBonus point balance = " + bonusPointBalance +
                "\nNew Points = " + newPoints +
                "\nMembership Name = " + membershipName + '\'';
    }
}
