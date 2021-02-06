package no.ntnu.karolisw.oblig2;

import javax.swing.*;

public class SilverMembership extends Membership{
    private int bonusPointBalance;
    private int newPoints;
    private String membershipName;
    private final float POINTS_SCALING_FACTOR = 1.2f;

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        int newBalance1 = Math.round(bonusPointBalance + newPoints*POINTS_SCALING_FACTOR);
        setBonusPointBalance(newBalance1);
        return bonusPointBalance;
    }

    public void setBonusPointBalance(int bonusPointBalance) {
        this.bonusPointBalance = bonusPointBalance;
    }

    @Override
    public String getMembershipName() {
        return "Silver Membership";
    }

    @Override
    public void setMembershipName() {
        this.membershipName = "Silver Membership";
    }
}
