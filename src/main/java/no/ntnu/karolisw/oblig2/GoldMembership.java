package no.ntnu.karolisw.oblig2;

import no.ntnu.karolisw.oblig2.Membership;

public class GoldMembership extends Membership {
    private int bonusPointBalance;
    private int newPoints;
    private String membershipName;
    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    public GoldMembership(int bonusPointBalance) {
        super(bonusPointBalance);
        membershipName = getMembershipName();
    }

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

    @Override
    public int getBonusPointBalance() {
        return bonusPointBalance;
    }

    public void setBonusPointBalance(int bonusPointBalance) {
        this.bonusPointBalance = bonusPointBalance;
    }

    @Override
    public String getMembershipName() {
        return "Gold Membership.";
    }
}
