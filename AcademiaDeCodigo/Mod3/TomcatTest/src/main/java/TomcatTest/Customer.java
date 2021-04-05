package TomcatTest;

public class Customer {

    private String name;
    private String email;
    private String password;
    private int phone;

    public Customer(){

    }

    public boolean isPWCorrect(String enteredPW){
        return enteredPW.equals(password);
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }




}
