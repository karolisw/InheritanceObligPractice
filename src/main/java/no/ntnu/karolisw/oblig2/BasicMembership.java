package no.ntnu.karolisw.oblig2;

/**
 * Class BasicMembership
 * @author Karoline Sund Wahl
 * @version 1.4 (14.02.2021)
 */

public class BasicMembership extends Membership {

    /**
     * Constructor for generating objects of Basic Membership
     * @param bonusPointBalance
     * @see Membership constructor
     */
    public BasicMembership(int bonusPointBalance){
        super(bonusPointBalance);
        membershipName = getMembershipName();
    }

    /**
     * Method that registers bonuspoints for a bonus member.
     * This method is sent from Bonusmember, to Membership, and delegated here.
     * @param bonusPointBalance
     * @param newPoints
     * @return bonusPointBalance after bonus point registration
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
      int newBalance = bonusPointBalance + newPoints;
      setBonusPointBalance(newBalance);
      return this.bonusPointBalance;
    }

    /**
     * Accessor method for BonusPointBalance
     * @return bonusPointBalance
     */
    @Override
    public int getBonusPointBalance() {
        return bonusPointBalance;
    }

    /**
     * Mutator method for bonusPointBalance
     * Used in correspondance with:
     * registerPoints() method, setMembership(), and checkAndSet() method
     * @param bonusPointBalance
     */
    public void setBonusPointBalance(int bonusPointBalance) {
        this.bonusPointBalance = bonusPointBalance;
    }

    /**
     * Method that overrides membershipName from Membership-class.
     * @return String with name of class.
     */
    @Override
    public String getMembershipName(){
        return "Basic Membership";
    }

}
