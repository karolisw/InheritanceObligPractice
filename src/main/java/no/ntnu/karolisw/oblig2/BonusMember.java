package no.ntnu.karolisw.oblig2;

import java.time.LocalDate;

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

    //samtlige get-metoder

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

    //Denne metoden skal returnere true dersom passordet i parameteren password matcher passordet til objektet
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public void registerBonusPoints(int newPoints){

        this.membership.registerPoints(this.getBonusPointsBalance(),newPoints);
        checkAndSetMembership();
    }

    //konstruktør, komposisjon pga. memberarchive
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.password = null;
        checkAndSetMembership();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //støttemetoden som er del av konstruktør og registerBonusPoints
    public void checkAndSetMembership() {
//        System.out.println("This user has a: " + this.membership.getMembershipName());
        if (this.getBonusPointsBalance() >= GOLD_LIMIT) {
            if (!(this.membership instanceof GoldMembership)) {
                this.membership = new GoldMembership();
                System.out.println("This user has been upgraded to Gold Membership");
            }
            else{
                System.out.println("This membership is a: "+ this.getMembership().toString());
            }
        }
        else if (this.getBonusPointsBalance() >= SILVER_LIMIT && this.getBonusPointsBalance() < GOLD_LIMIT) {
            if (!(this.membership instanceof SilverMembership)) {
                this.membership = new SilverMembership();
                System.out.println("This user has been upgraded to Silver Membership");
            }
            else{
                System.out.println("This membership is a: "+ this.getMembership().toString());
            }
        }
        else if(this.getBonusPointsBalance() < SILVER_LIMIT){
            if (!(this.membership instanceof BasicMembership)) {
                this.membership = new BasicMembership();
            }
            else{
                System.out.println("This membership is a: "+ this.getMembership().toString());
            }
        }
    }

    @Override
    public String toString() {
        return "BonusMember{" +
                "memberNumber=" + memberNumber +
                ", enrolledDate=" + enrolledDate +
                ", bonusPointsBalance=" + bonusPointsBalance +
                ", name='" + name + '\'' +
                ", eMailAddress='" + eMailAddress + '\'' +
                ", password='" + password + '\'' +
                ", membership=" + membership +
                '}';
    }
}
