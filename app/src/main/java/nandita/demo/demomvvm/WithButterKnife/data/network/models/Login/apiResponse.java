package nandita.demo.demomvvm.WithButterKnife.data.network.models.Login;

public class apiResponse {

    /**
     * responseCode : 1
     * responseText : Successfully Logged in.
     * data : {"user_id":2,"user_email":"nandita@gmail.com","first_name":"nandita new dara","last_name":"data nandita new","full_name":"nandita new dara data nandita new","phone_no":"7278768664","agantId":"A123"}
     */

    private int responseCode;
    private String responseText;
    private DataBean data;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 2
         * user_email : nandita@gmail.com
         * first_name : nandita new dara
         * last_name : data nandita new
         * full_name : nandita new dara data nandita new
         * phone_no : 7278768664
         * agantId : A123
         */

        private int user_id;
        private String user_email;
        private String first_name;
        private String last_name;
        private String full_name;
        private String phone_no;
        private String agantId;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_email() {
            return user_email;
        }

        public void setUser_email(String user_email) {
            this.user_email = user_email;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getPhone_no() {
            return phone_no;
        }

        public void setPhone_no(String phone_no) {
            this.phone_no = phone_no;
        }

        public String getAgantId() {
            return agantId;
        }

        public void setAgantId(String agantId) {
            this.agantId = agantId;
        }
    }
}
