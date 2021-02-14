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


    public void setMembership(Membership membership) {

        // starts by checking to see if the Bonusmember has a membership
        if (this.membership == null) {
            this.membership = new BasicMembership(bonusPointsBalance);
        }
        //trying out something new
        else if(this.getBonusPointsBalance() >= GOLD_LIMIT){
            this.membership = new GoldMembership(this.getBonusPointsBalance());
            System.out.println("Upgraded to Gold membership via set-method.");
        }
        //trying out something else
        //if(bonusPointsBalance >= GOLD_LIMIT){
        //    this.membership = new GoldMembership(bonusPointsBalance);
        //}
        else if (this.getBonusPointsBalance() < GOLD_LIMIT && this.getBonusPointsBalance() >= SILVER_LIMIT) {
            this.membership = new SilverMembership(this.getBonusPointsBalance());
            System.out.println("Upgraded to Silver membership via set-method.");
        }
        else{
            System.out.println("Bonusmember remained Basic member.");
        }
        //if(this.getBonusPointsBalance() < SILVER_LIMIT) {
            //this.membership = new BasicMembership(this.getBonusPointsBalance());
       // }
    }

    //Denne metoden skal returnere true dersom passordet i parameteren password matcher passordet til objektet
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void registerBonusPoints(int newPoints) {
        bonusPointsBalance = membership.registerPoints(this.getBonusPointsBalance(), newPoints);
        checkAndSet();
    }

    //konstruktør, komposisjon pga. memberarchive
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.password = null;
        //checkAndSetMembership();
        checkAndSet();
    }

        public void setPassword (String password){
            this.password = password;
        }

        public void checkAndSet () {
            if (this.membership == null) {
                setMembership(this.membership);
                System.out.println("This member had no membership, but is now a basic member. Checking to see if it should be gold or silver...");
                checkAndSet();
            } else if (!(this.membership instanceof GoldMembership) && this.bonusPointsBalance > GOLD_LIMIT) {
                setMembership(this.membership);
            } else if (!(this.membership instanceof SilverMembership)) {
                if (this.membership.getBonusPointBalance() >= SILVER_LIMIT && this.membership.getBonusPointBalance() < GOLD_LIMIT) {
                    setMembership(this.membership);
                }
            }

        }

        @Override
        public String toString(){
            return "BonusMember{" +
                    "memberNumber=" + memberNumber +
                    ", enrolledDate=" + enrolledDate +
                    ", bonusPointsBalance=" + bonusPointsBalance +
                    ", name='" + name + '\'' +
                    ", eMailAddress='" + eMailAddress + '\'' +
                    ", password='" + password + '\'' + "\n" +
                    "Membership =" + membership +
                    '}';
        }
    }

