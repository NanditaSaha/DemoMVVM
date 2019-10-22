package nandita.demo.demomvvm.WithButterKnife.data.network.models.Login;

public class ApiRequest {


    /**
     * email : nandita@gmail.com
     * password : 123546
     * devicetype : A
     * devicetoken : hgshdgjksdjkd
     */

    private String email;
    private String password;
    private String devicetype;
    private String devicetoken;


    public ApiRequest(String email, String password, String devicetype, String devicetoken) {
        this.email = email;
        this.password = password;
        this.devicetype = devicetype;
        this.devicetoken = devicetoken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getDevicetoken() {
        return devicetoken;
    }

    public void setDevicetoken(String devicetoken) {
        this.devicetoken = devicetoken;
    }
}
