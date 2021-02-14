package no.ntnu.karolisw.oblig2;

/**
 * Class SilverMembership
 * @author Karoline Sund Wahl
 * @version 1.4 (14.02.2021)
 */

public class SilverMembership extends Membership{
    private final float POINTS_SCALING_FACTOR = 1.2f;

    /**
     * Constructor for creating objects of Silver membership for assigning to BonusMember objects
     * membershipName is given value of accessor method 'getMembershipName()'
     * @param bonusPointBalance
     */
    public SilverMembership(int bonusPointBalance) {
        super(bonusPointBalance);
        membershipName = getMembershipName();
    }

    /**
     * Method for registration of points
     * Uses mutator method setBonusPointBalance with local variable 'newBalance' as parameter
     *
     * @param bonusPointBalance
     * @param newPoints
     * @return bonusPointBalance after registration of points
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        int newBalance = Math.round(bonusPointBalance + newPoints*POINTS_SCALING_FACTOR);
        setBonusPointBalance(newBalance);
        return this.bonusPointBalance;
    }

    /**
     * Accessor method for bonusPointBalance field
     * @return bonusPointBalance
     */
    @Override
    public int getBonusPointBalance() {
        return bonusPointBalance;
    }

    /**
     * Mutator method for bonusPointBalance
     * @param bonusPointBalance
     */
    public void setBonusPointBalance(int bonusPointBalance) {
        this.bonusPointBalance = bonusPointBalance;
    }

    /**
     * Modified accessor
     * @return String with name of membership
     */
    @Override
    public String getMembershipName() {
        return "Silver Membership";
    }


}

