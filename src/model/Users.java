package model;

/**Class that defines objects and variables for users.*/
public class Users {

        private int id;
        private String usrName;
        private String pssWrd;

        /**Method creates user object.
         @param id
         @param usrName
         @param pssWrd */
        public Users(int id, String usrName, String pssWrd){

            this.id = id;
            this.usrName = usrName;
            this.pssWrd = pssWrd;
        }

        /**Method creates another user object.
         @param id
         @param usrName */
        public Users(int id, String usrName){

            this.id = id;
            this.usrName = usrName;

        }

        /**Method retrieves id.
         @return id */
    public int getId() {
        return id;
    }

    /**Method retrieves usrName.
     @return usrName */
    public String getUsrName(){

            return usrName;
    }

    /**Method retrieves pssWrd.
     @return  pssWrd */
    public String getPssWrd(){

            return pssWrd;
    }

    /**Method converts user object to string.
     @return user */
    @Override
    public String toString(){
        return(("#" + Integer.toString(id) + " " + usrName));
    }
}



