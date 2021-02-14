package no.ntnu.karolisw.oblig2;

/**
 * Class GoldMembership
 * @author Karoline Sund Wahl
 * @version 1.4 (14.02.2021)
 */

public class GoldMembership extends Membership {
    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    /**
     * Constructor for GoldMembership objects
     * Uses constructor from Membership
     * @see super
     * @param bonusPointBalance
     * Constructor also sets field membershipName equal to method getMembershipName()
     */
    public GoldMembership(int bonusPointBalance) {
        super(bonusPointBalance);
        membershipName = getMembershipName();
    }

    /**
     * Method for registration of Bonus points.
     * If the value is above or equal to 75000, and below 90000, the new points added will be multiplied with 1.3
     * If the value is above or equal to 90000, the new points added will be multiplied with 1.5
     * @param bonusPointBalance
     * @param newPoints
     * @return bonusPointBalance after registration of new points
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {//this i parametret?????????????????????
        if(bonusPointBalance >= 75000 && bonusPointBalance < 90000){
            int newBalance = Math.round(bonusPointBalance + newPoints*POINTS_SCALING_FACTOR_LEVEL_1);
            setBonusPointBalance(newBalance);
        }
        else if(bonusPointBalance >= 90000){
            int newBalance = Math.round(bonusPointBalance + newPoints*POINTS_SCALING_FACTOR_LEVEL_2);
            setBonusPointBalance(newBalance);
        }
        return this.bonusPointBalance;
        }

    /**
     * Accessor for bonusPointBalance
     * @return bonusPointBalance
     */
    @Override
    public int getBonusPointBalance() {
        return bonusPointBalance;
    }

    /**
     * Mutator for bonusPointBalance
     * @param bonusPointBalance
     */
    public void setBonusPointBalance(int bonusPointBalance) {
        this.bonusPointBalance = bonusPointBalance;
    }

    /**
     * Accessor for membershipName
     * @return String with name of membership
     */
    @Override
    public String getMembershipName() {
        return "Gold Membership.";
    }
}
