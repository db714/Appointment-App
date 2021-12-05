package model;

public class Users {

        private int id;
        private String usrName;
        private String pssWrd;

        public Users(int id, String usrName, String pssWrd){

            this.id = id;
            this.usrName = usrName;
            this.pssWrd = pssWrd;
        }

    public int getId() {
        return id;
    }

    public String getUsrName(){

            return usrName;
    }

    public String getPssWrd(){

            return pssWrd;
    }
}



