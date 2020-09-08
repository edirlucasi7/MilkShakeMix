
package db.Conection.dev;

import db.Conection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoConfigTables{
    
    private PreparedStatement std;
    private Connection con;
    

    public void CreateTableUser(){
        try {
            String sql = "create table usuarios(id int(10) NOT NULL, login varchar(100) NOT NULL,"
                    + " nome varchar(100) NOT NULL, senha varchar(100) NOT NULL,"
                    + "perfil varchar(100) NOT NULL);";
            
            con = Conexao.conector();
            std = con.prepareStatement(sql);
            std.execute();
            System.out.println("Tabela usuário criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro na criação da tabela" + ex);

        }         
    }
      public void DeleteTableUser(){
        try {
            String sql = "drop table usuarios;";
            
            con = Conexao.conector();
            std = con.prepareStatement(sql);
            std.execute();
            
            System.out.println("Tabela usuário deletada");
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar tabela usuário" + ex);

        }
    }
    
//O CRUD da aplicação é feita após isso com as funções, exemplo : CreateUser(), CreateVenda() ...
 public void CadastrarUsuarioAdmin() throws SQLException {
     
     String sql = "insert into usuarios(id, login, nome, senha, perfil) values(1 , 'admin', 'Admin', '123','administrador');";
             
        con = Conexao.conector();
        std = con.prepareStatement(sql);
        std.execute();
        
    }
 
     public void CreateTableProduto(){
        try {
            String sql = "create table produtos(id int NOT NULL AUTO_INCREMENT PRIMARY KEY, nomeproduto varchar(100) NOT NULL,"
                    + " preco varchar(100) NOT NULL, tamanho varchar(100) NOT NULL,"
                    + "especial varchar(100));";
            
            con = Conexao.conector();
            std = con.prepareStatement(sql);
            std.execute();
            System.out.println("Tabela produtos criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro na criação da tabela" + ex);

        }         
    }
     public void DeleteTableProduto(){
        try {
            String sql = "drop table produtos;";
            
            con = Conexao.conector();
            std = con.prepareStatement(sql);
            std.execute();
            
            System.out.println("Tabela produtos deletada");
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar tabela usuário" + ex);

        }
    }
    
    public void CreateTableProdutoDiverso(){
        try {
            String sql = "create table produtosdiversos(id int NOT NULL AUTO_INCREMENT PRIMARY KEY, nomeproduto varchar(100) NOT NULL,"
                    + " preco varchar(100) NOT NULL,"
                    + "quantidade varchar(100) NOT NULL,"
                    + "data DATE NOT NULL);";
            
            con = Conexao.conector();
            std = con.prepareStatement(sql);
            std.execute();
            System.out.println("Tabela produtos diversos criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro na criação da tabela" + ex);

        }         
    }
        public void DeleteTableProdutoDiverso(){
        try {
            String sql = "drop table produtosdiversos;";
            
            con = Conexao.conector();
            std = con.prepareStatement(sql);
            std.execute();
            
            System.out.println("Tabela produtos deletada");
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar tabela usuário" + ex);

        }
    }
    
     public void CreateTableVenda(){
        try {
            String sql = "create table vendas(id int NOT NULL AUTO_INCREMENT PRIMARY KEY, valor varchar(100) NOT NULL,"
                    + " data DATE NOT NULL, tipo varchar(100) NOT NULL);";
            
            con = Conexao.conector();
            std = con.prepareStatement(sql);
            std.execute();
            System.out.println("Tabela vendas criada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro na criação da tabela" + ex);

        }         
    }
    
    public void DeleteTableVendas(){
        try {
            String sql = "drop table vendas;";
            
            con = Conexao.conector();
            std = con.prepareStatement(sql);
            std.execute();
            
            System.out.println("Tabela vendas deletada");
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar tabela vendas" + ex);
        }
    }
}
