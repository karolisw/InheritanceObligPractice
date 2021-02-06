package no.ntnu.karolisw.oblig2;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
     * The member archive holds all the bonus members. The archive provides
     * functionality for adding members to the register, looking up bonuspoints
     * of given members, registering new bonuspoints and listing all the members.
     *
     * @author arne
     */
    public class MemberArchive {

        // Use a HashMap, since the members have a unique member number.
        private HashMap<Integer, BonusMember> members;

        /**
         * Creates a new instance of MemberArchive.
         */
        public MemberArchive() {
            this.members = new HashMap<>();
            this.fillRegisterWithTestdata();
        }

        public boolean doesMemberExcist(Integer memberID){
            return members.containsKey(memberID);
        }

        /**
         * Adds a new member to the register. The new member must have a memebr number
         * different from exsisting members. If not, the new member will not be added.
         *
         * @return {@code true} if the new member was added successfully,
         *         {@code false} if the new member could not be added, due to a
         *          membernumber that already excists.
         */
        public boolean addMember(BonusMember bonusMember) {
            boolean success = true;
            if(doesMemberExcist(bonusMember.getMemberNumber())){
                success = false;
                }
            return success;
        }

        /**
         * Registers new bonuspoints to the member with the member number given
         * by the parameter {@code memberNumber}. If no member in the register
         * matches the provided member number, {@code false} is returned.
         *
         * @param memberNumber the member number to add the bonus points to
         * @param bonusPoints the bonus points to be added
         * @return {@code true} if bonuspoints were added successfully,
         *         {@code false} if not.
         */
        public boolean registerPoints(int memberNumber, int bonusPoints) {
            boolean success = false;
            if(doesMemberExcist(memberNumber)){
                members.get(memberNumber).registerBonusPoints(bonusPoints);
                success = true;
            }
            return success;
        }

        /**
         * Lists all members to the console.
         */
        public void listAllMembers() {
            for(Integer memberNumber : members.keySet()){
                String key = memberNumber.toString();
                String value = members.get(memberNumber).toString();
            }
        }

        public int findPoints(Integer memberNumber, String password){
            BonusMember member = members.get(memberNumber);
            if(member.getPassword().equals(password)){
                return member.getBonusPointsBalance();
            }
            return -1;
        }

        /**
         * Fills the register with some arbitrary members, for testing purposes.
         */
        private void fillRegisterWithTestdata() {
            BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz");
            this.members.put(member.getMemberNumber(), member);

            BonusMember member2 = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz");
            this.members.put(member2.getMemberNumber(), member2);

            BonusMember member3 = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no");
            this.members.put(member3.getMemberNumber(), member3);

            BonusMember member4 = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org");
            this.members.put(member4.getMemberNumber(), member4);

            BonusMember member5 = new BonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com");
            this.members.put(member5.getMemberNumber(), member5);
        }


    }

