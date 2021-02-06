package no.ntnu.karolisw.oblig2;

public class GoldMembership extends Membership{
    private int bonusPointBalance;
    private int newPoints;
    private String membershipName;
    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        this.bonusPointBalance = bonusPointBalance;
        if(bonusPointBalance >= 75000 && bonusPointBalance < 90000){
            return this.bonusPointBalance = Math.round(bonusPointBalance + newPoints*POINTS_SCALING_FACTOR_LEVEL_1);
            //burde det stå this foran bonusPointBalance her?
        }
        else if(bonusPointBalance >= 90000){
            return this.bonusPointBalance = Math.round(bonusPointBalance + newPoints*POINTS_SCALING_FACTOR_LEVEL_2);
        }
        else {
            throw new IllegalArgumentException("This user is not a gold member");
        }
    }

    @Override
    public String getMembershipName() {
        return "Gold Membership.";
    }

    @Override
    public void setMembershipName(){
        this.membershipName = "Gold membership";
    }
}
