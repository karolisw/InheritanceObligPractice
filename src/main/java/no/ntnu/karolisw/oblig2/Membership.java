package no.ntnu.karolisw.oblig2;

public abstract class Membership {
    protected int bonusPointBalance;
    protected int newPoints;
    protected String membershipName;

    public abstract int registerPoints(int bonusPointBalance, int newPoints);
    public abstract String getMembershipName();
    public abstract void setMembershipName();

    @Override
    public String toString() {
        return "\nMembership details: " +
                "\nBonus point balance = " + bonusPointBalance +
                "\nNew Points = " + newPoints +
                "\nMembership Name = " + membershipName + '\'';
    }
}
