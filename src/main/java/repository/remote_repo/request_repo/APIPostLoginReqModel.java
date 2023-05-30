package repository.remote_repo.request_repo;

public class APIPostLoginReqModel {


    /**
     * email : eve.holt@reqres.in
     * password : cityslicka
     */

    private String email;
    private String password;

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
}
