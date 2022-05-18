package BDD;


public final class UserSession {

        public static UserSession instance;

        private String userName;
        private int idUser;

        private UserSession(String userName, int idUser ) {
            this.userName = userName;
            this.idUser = idUser;
        }

        public static UserSession getInstance(String userName, int idUser) {
            if(instance == null) {
                instance = new UserSession(userName, idUser);
            }
            return instance;
        }

        public String getUserName() {
            return userName;
        }

        public int getIdUser() {
            return idUser;
        }

        public void cleanUserSession() {
            userName = "";// or null
            idUser = 0;// or null
        }
}
