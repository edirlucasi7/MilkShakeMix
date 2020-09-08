
package db.Conection.dev;


public interface DadosDatabaseDev {
    
    /**
     *
     */
    String USER_DATABASE = "root";
    String PASSWORD_DATABASE = "root";
    String URL = "jdbc:mysql://localhost:3306/sorveteria?useSSL=true&useTimezone=true&serverTimezone=UTC";
    String DRIVE = "com.mysql.cj.jdbc.Driver";
    
    String HOST_DATABASE_CONFIGURATION = "mysql";
    String URL_DATABASE_CONFIGURATION = "jdbc:mysql://localhost:3306/" + HOST_DATABASE_CONFIGURATION;
    String NAME_DATABASE = "sorveteria";
}
