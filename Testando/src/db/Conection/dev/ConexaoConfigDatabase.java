
package db.Conection.dev;

import db.Conection.Conexao;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexaoConfigDatabase {
    
    private PreparedStatement std;
    private Connection con;
    
    private DatabaseMetaData meta;
    private ResultSet rs;
    
    public boolean DatabaseCriated() throws SQLException{
        
        ArrayList<String> list = new ArrayList<String>();
        
        con = Conexao.conectorConfigurationDatabase();
        Statement st = con.createStatement();
        meta = con.getMetaData();
        rs = meta.getCatalogs();
        
        while(rs.next()){
              String listDatabases = rs.getString("TABLE_CAT");
              list.add(listDatabases);
        }
        if(list.contains(DadosDatabaseDev.NAME_DATABASE)){
            return true;
        }else{
            return false;
        }  
    }
    

    public void CreateDatabase(){
        try {
            String sql = "create database " + DadosDatabaseDev.NAME_DATABASE + ";";
            
            con = Conexao.conectorConfigurationDatabase();
            std = con.prepareStatement(sql);
            std.execute();
            System.out.println("Banco de dados criado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro na criação do banco" + ex);

        }
              
    }
    
    public void DeleteDatabase(){
        try {
            String sql = "drop database " + DadosDatabaseDev.NAME_DATABASE + ";";
            
            con = Conexao.conectorConfigurationDatabase();
            std = con.prepareStatement(sql);
            std.execute();
            System.out.println("Banco de dados deletado");
        } catch (SQLException ex) {
            System.out.println("Erro na remoção do banco de dados" + ex);

        }
              
    }
    
}
