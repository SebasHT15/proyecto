package listClasses;

/**
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */
public class Usuario {
    private String user;

    private String password;

    private String name;

    private String email;

    private String province;

    private String urlBibliotecas;

    /**
     * Metodo constructor del obejto Usuario.
     * @param user Nombre del usuario.
     * @param password Contraseña del ususario.
     * @param name Nombre real de usuario.
     * @param email Correo del usuario.
     * @param province Provincia del usuario.
     * @param urlBibliotecas Url del csv con las bibliotecas de cada usuario.
     */
    public Usuario(String user, String password, String name, String email, String province, String urlBibliotecas){
        this.user = user;
        this.password = password;
        this.name = name;
        this.email = email;
        this.province = province;
        this.urlBibliotecas = urlBibliotecas;
    }

    /**
     * Retorna el nombre del usuario.
     * @return Nombre del usuario.
     */
    public String getUser(){
        return this.user;
    }

    /**
     * Retorna la contraseña del usuario.
     * @return Contraseña de usuario.
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Retorna el nombre completo del usuario.
     * @return completo del usuario.
     */

    public String getName(){
        return this.name;
    }

    /**
     * Retorna correo del usuario.
     * @return correo del usuario.
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Retorna la provincia del usuario.
     * @return provincia del usuario.
     */
    public String getProvince(){return this.province;}

    /**
     * Retorna la biblioteca del usuario.
     * @return biblioteca del usuario.
     */
    public String getUrlBibliotecas(){return urlBibliotecas;}
}
