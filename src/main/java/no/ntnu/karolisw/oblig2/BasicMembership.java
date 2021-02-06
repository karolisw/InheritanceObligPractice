package no.ntnu.karolisw.oblig2;

public class BasicMembership extends Membership {
    private int bonusPointBalance;
    private int newPoints;
    private String membershipName;
    //metoden tar med inn som parameter gjeldende bonuspoeng-saldo, og poengene som
    //skal registreres. Metoden beregner så ny saldo basert på fordelene i gitt medlemskap.
    //Den nye saldoen blir så returnert.


    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
      int newBalance = bonusPointBalance + newPoints;
      return newBalance;

    }

    public int getBonusPointBalance() {
        return bonusPointBalance;
    }

    @Override
    public String getMembershipName(){
        return "Basic Membership";
    }

    @Override
    public void setMembershipName(){
      this.membershipName = "Basic Membership";
    }

}
