package listClasses;

public class Usuario {
    private String user;

    private String password;

    private String name;

    private String email;

    private String province;

    public Usuario(String user, String password, String name, String email, String province){
        this.user = user;
        this.password = password;
        this.name = name;
        this.email = email;
        this.province = province;
    }

    public String getUser(){
        return this.user;
    }

    public String getPassword(){
        return this.password;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getProvince(){
        return this.province;
    }
}
