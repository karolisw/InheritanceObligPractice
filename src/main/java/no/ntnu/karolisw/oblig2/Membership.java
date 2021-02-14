package no.ntnu.karolisw.oblig2;

/**
 * Class Membership
 * @author Karoline Sund Wahl
 * @version 1.4 (14.02.2021)
 */
public abstract class Membership {
    protected int bonusPointBalance;
    protected String membershipName;

    /**
     * Abstract method registerPoints.
     * Subclasses use this registration method for adding correct amount of points.
     * After modifying points to correct amount, the subclasses send the points back to the Membership object of this class
     * @param bonusPointBalance
     * @param newPoints
     */
    protected abstract int registerPoints(int bonusPointBalance, int newPoints);

    /**
     * Abstract method getMembershipName()
     * Subclasses override this method for specialised membershipName-return
     */
    protected abstract String getMembershipName();

    /**
     * Constructor for membership-objects.
     * @param bonusPointBalance
     */
    public Membership(int bonusPointBalance){
        this.bonusPointBalance = bonusPointBalance;
    }

    /**
     * Abstract accessor method for getting bonusPointBalance
     */
    public abstract int getBonusPointBalance();

    /**
     * toString() method.
     * @return objects bonusPointBalance and membershipName
     */
    @Override
    public String toString() {
        return "\nMembership details: " +
                "\nBonus point balance = " + bonusPointBalance +
                "\nMembership Name = " + membershipName + '\'';
    }
}
