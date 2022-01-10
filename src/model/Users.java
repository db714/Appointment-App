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

        public Users(int id, String usrName){

            this.id = id;
            this.usrName = usrName;

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

    @Override
    public String toString(){
        return(("#" + Integer.toString(id) + " " + usrName));
    }
}



