package no.ntnu.karolisw.oblig2;

import java.time.LocalDate;
/**
 * Class BonusMember
 * @author Karoline Sund Wahl
 * @version 1.4 (14.02.2021)
 */
public class BonusMember {
    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;
    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    /**
     * Accessor methods for all fields
     */
    public String getName() {
        return name;
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public Membership getMembership() {
        return membership;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Mutator method for membership. The purpose of this method is to support checkAndSet() method
     * Starts by checking to see if the Bonus member has a membership
     * If the Bonus member has been assigned a basic membership but is eligible to be upgraded,
     * the method will assign the correct membership.
     * @param membership
     */
    public void setMembership(Membership membership) {
        if (this.membership == null) {
            this.membership = new BasicMembership(bonusPointsBalance);
        }
        else if(this.getBonusPointsBalance() >= GOLD_LIMIT){
            this.membership = new GoldMembership(this.getBonusPointsBalance());
            System.out.println("Bonusmember (" + getMemberNumber() + ") Upgraded to Gold membership via set-method.");
        }
        /*
        perhaps this could work:
        if(bonusPointsBalance >= GOLD_LIMIT){
            this.membership = new GoldMembership(bonusPointsBalance); */
        else if (this.getBonusPointsBalance() < GOLD_LIMIT && this.getBonusPointsBalance() >= SILVER_LIMIT) {
            this.membership = new SilverMembership(this.getBonusPointsBalance());
            System.out.println("Bonusmember (" + getMemberNumber() + ") Upgraded to Silver membership via set-method.");
        }
        else{
            System.out.println("Bonusmember (" + getMemberNumber() + ") remained Basic member.");
        }
    }

    //Denne metoden skal returnere true dersom passordet i parameteren password matcher passordet til objektet

    /**
     * Method that passes a password
     *
     * @param password
     * @return true if the passed password is equal to password belonging to the object in question
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Mutator for field password. This is necessary because it is not part of the BonusMember constructor
     * @param password
     */
    public void setPassword (String password){
        this.password = password;
    }

    /**
     * First part in the chain of registration of bonuspoints.
     * Uses method checkAndSetMembership after registration (in case of membership-change)
     * @param newPoints
     */
    public void registerBonusPoints(int newPoints) {
        bonusPointsBalance = membership.registerPoints(this.getBonusPointsBalance(), newPoints);
        checkAndSetMembership();
    }

    /**
     * Constructor for Bonusmember.
     * @param memberNumber
     * @param enrolledDate
     * @param bonusPointsBalance
     * @param name
     * @param eMailAddress
     */
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.password = null;
        checkAndSetMembership();
    }

    /**
     * Method for checking to see if membership is assigned correctly.
     * Uses method setMembership as supporting method
     * If membership is no longer correct after registration of points, this method will assign correct membership
     */
    public void checkAndSetMembership () {
        if (membership == null) {
            setMembership(membership);
            System.out.println("\nThis member had no membership, but is now a basic member. Checking to see if it should be gold or silver...");
            //checkAndSetMembership();
            setMembership(membership);
        } else if (!(membership instanceof GoldMembership) && bonusPointsBalance > GOLD_LIMIT) {
            setMembership(membership);
        } else if (!(membership instanceof SilverMembership)) {
            if (membership.getBonusPointBalance() >= SILVER_LIMIT && membership.getBonusPointBalance() < GOLD_LIMIT) {
                setMembership(membership);
            }
        }
    }

    /**
     * toString() method
     * Prints out Bonus member and corresponding fields
     * Because Membership has its own toString method, the field membership can be printed without accessors
     * @return BonusMember objects
     */
        @Override
        public String toString(){
            return "Bonus Member = " + "\n" +
                    "Member Number: " + memberNumber +
                    ", Enrolled Date: " + enrolledDate +
                    ", Bonuspoint Balance: " + bonusPointsBalance +
                    ", Name: '" + name + '\'' +
                    ", EmailAddress: '" + eMailAddress + '\'' +
                    ", Password: " + password + '\'' + "\n" +
                    membership;
        }
    }

