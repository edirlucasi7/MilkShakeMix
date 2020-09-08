
package db.Conection;

import db.Conection.dev.DadosDatabaseDev;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;


public class Conexao {

private Statement st;
private Connection con;
private PreparedStatement pst;
private ResultSet rs = null;    
    
public static Connection conector() throws SQLException {
java.sql.Connection conexao = null;
String driver = DadosDatabaseDev.DRIVE;
String URL = DadosDatabaseDev.URL;
String usuario = "root";   
String senha = DadosDatabaseDev.PASSWORD_DATABASE;  
    
    //Fazendo conexão com o drive do MySQL
    try {
        Class.forName(driver);        
        conexao = DriverManager.getConnection(URL, usuario, senha);
        return conexao;

    } catch (ClassNotFoundException | SQLException e) {
        System.err.println(e);
        return null;
    }

}

public static Connection conectorConfigurationDatabase(){
    
    java.sql.Connection conexao = null;
    String driver = DadosDatabaseDev.DRIVE;
    String URL = DadosDatabaseDev.URL_DATABASE_CONFIGURATION;   
    String usuario = DadosDatabaseDev.USER_DATABASE;     
    String senha = DadosDatabaseDev.PASSWORD_DATABASE;  
    
    try {
        Class.forName(driver);        
        conexao = DriverManager.getConnection(URL, usuario, senha);
        return conexao;

    } catch (ClassNotFoundException | SQLException e) {
        System.err.println(e);
        return null;
    }
    
    
}


public boolean cadastrarProduto(String nome_produto, String preco, String tamanho, String especial){
        try {
            String sql = "insert into produtos(nomeproduto, preco, tamanho, especial) values('"+ nome_produto +"' , '"+ preco +"'"
                    + ", '"+ tamanho + "', '"+ especial +"');";
            
            
            con = Conexao.conector();
            pst = con.prepareStatement(sql);
            pst.execute();
            
            return true;
        } catch (SQLException ex) {
         return false;
        }
        
}

    public ResultSet ConsultarProduto(String nm) throws SQLException {

        String sql = "select * from produtos where nomeproduto like '%" +  nm + "%';";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
    
    public ResultSet ConsultarProdutoDiverso(String nm) throws SQLException {

        String sql = "select * from produtosdiversos where nomeproduto like '%" +  nm + "%';";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
    
    public boolean ConsultarProdutoCad(String nm, String pre, String tamanho, String especial) throws SQLException {

        String sql = "select * from produtos where nomeproduto ='"+nm+"' AND preco = '"+pre+"' AND tamanho = '"+tamanho+"' AND especial = '"+especial+"';";
        boolean verificacao = false;
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);
        while(rs.next()){
            verificacao = true;
        }
         if(verificacao == true){
             return true;
         }else{
             return false;
         }
 
    }
    
    public boolean AlterarProduto(String nm, String preco, String tamanho, String especial, String id) {
        
       
        try {
            st = con.createStatement();
            st.executeUpdate("update produtos SET nomeproduto = '" + nm + "' where id = '" + id + "';");
            st.executeUpdate("update produtos SET preco = '" + preco + "' where id = '" + id + "';");
            st.executeUpdate("update produtos SET tamanho = '" + tamanho + "' where id = '" + id + "';");
            st.executeUpdate("update produtos SET especial = '" + especial + "' where id = '" + id + "';");
            
            return true;
        
        } catch (SQLException ex) {
            return false;
        }

    }
    
     public Boolean deletarprodutos(String id) throws SQLException {

        try {
            st = con.createStatement();
            st.executeUpdate("delete from produtos where id = '" + id + "';");
            return true;
        } catch (SQLException e) {
            
            return false;
        }
      
    }
     
     public ResultSet ConsultarAllUsuarios() throws SQLException {

        String sql = "select * from usuarios;";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
     
     public ResultSet ConsultarVendasDiarias() throws SQLException {
        
        String sql = "select * from vendas where data = current_date();";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
     
      public ResultSet ConsultarVendasEntreDuasDatas(String data1, String data2) throws SQLException {
         String sql = "select * from vendas where data BETWEEN ('"+data1+"') AND ('"+data2+"');";
         
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
         
     }
       public ResultSet ConsultarTotalVendasEntreDuasDatas(String data1, String data2) throws SQLException {

        String sql = "select SUM(valor) as total from vendas where data BETWEEN '"+data1+"' AND '"+data2+"';";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);
        
        return rs;
    }
     
    public ResultSet ConsultarInsumosDiarias() throws SQLException {
        
        java.util.Date data = new java.util.Date();
        DateFormat formatadorData = DateFormat.getDateInstance(DateFormat.SHORT);
        String dataTeste = formatadorData.format(data);
        
        String sql = "select * from produtosdiversos where data = '"+dataTeste+"'";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
    
     public ResultSet ConsultarDiariaValorTotalInsumos() throws SQLException {
         
        java.util.Date data1 = new java.util.Date();
        DateFormat formatadorData = DateFormat.getDateInstance(DateFormat.SHORT);
        String dataTeste1 = formatadorData.format(data1);

        String sql = "select SUM(preco) as total from produtosdiversos where data = '"+dataTeste1+"';";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
     
     public ResultSet ConsultarTotalValorVendasDiarias() throws SQLException {

        String sql = "select SUM(valor) as total from vendas where data = current_date();";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
     
     public ResultSet ConsultarAllVendas() throws SQLException {

        String sql = "select * from vendas;";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
     
     public ResultSet ConsultarTotalValorVendas() throws SQLException {

        String sql = "select SUM(valor) as total from vendas;";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
     
     public ResultSet ConsultarTotalValorInsumos() throws SQLException {

        String sql = "select SUM(preco) as total from produtosdiversos;";
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
     public ResultSet ConsultarTotalValorInsumosEntreDuasDatas(String data1, String data2) throws SQLException {

        String sql = "select SUM(preco) as total from produtosdiversos where data BETWEEN '"+data1+"' AND '"+data2+"';";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);
        
        return rs;
    }
     
     public ResultSet ConsultarAllInsumos() throws SQLException {

        String sql = "select * from produtosdiversos;";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
     
      public ResultSet ConsultarAllProduto() throws SQLException {

        String sql = "select * from produtos;";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
     
     
     public ResultSet ConsultarInsumosEntreDatas(String data1, String data2) throws SQLException {
         String sql = "select * from produtosdiversos where data BETWEEN ('"+data1+"') AND ('"+data2+"');";
         
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
         
     }
     
     public ResultSet ConsultarAllProdutoDiverso() throws SQLException {

        String sql = "select * from produtosdiversos;";
        
        con = Conexao.conector();
        st = con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery(sql);

        return rs;
    }
     
     public boolean cadastrarVenda(String valor, String data, String tipo){
        try {
            String sql = "insert into vendas(valor, data, tipo) values('"+ valor +"' , '"+ data +"' , '"+ tipo +"');";
            
            con = Conexao.conector();
            pst = con.prepareStatement(sql);
            pst.execute();
            
            return true;
        } catch (SQLException ex) {
         return false;
        }
    }
    
}
