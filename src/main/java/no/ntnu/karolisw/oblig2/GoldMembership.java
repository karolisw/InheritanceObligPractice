package no.ntnu.karolisw.oblig2;

import no.ntnu.karolisw.oblig2.Membership;

public class GoldMembership extends Membership {
    private int bonusPointBalance;
    private int newPoints;
    private String membershipName;
    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        if(this.bonusPointBalance >= 75000 && this.bonusPointBalance < 90000){
            return this.bonusPointBalance = Math.round(bonusPointBalance + newPoints*POINTS_SCALING_FACTOR_LEVEL_1);
        }
        else if(bonusPointBalance >= 90000){
            return this.bonusPointBalance = Math.round(bonusPointBalance + newPoints*POINTS_SCALING_FACTOR_LEVEL_2);
        }
        else {
            throw new IllegalArgumentException("This user is not a gold member");
        }
    }

    public int getBonusPointBalance() {
        return bonusPointBalance;
    }

    private void setBonusPointBalance(int bonusPointBalance) {
        this.bonusPointBalance = bonusPointBalance;
    }

    @Override
    public String getMembershipName() {
        return "Gold Membership.";
    }
}
