package sys_auto_Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import groovy.ui.SystemOutputInterceptor;
import sys_auto_beans.ConsultarMarcaVeicBean;
import sys_auto_beans.ConsultarCarrVeicBean;

public class VeiculoDao {
    //private Connection connection;
    private static final String Return_Manufacter = "Select * from fabricante";
    private static final String Return_Vehicle = "Select * from veiculo where fabricante = ? "; //select lista_carros from veiculo where Fabricante = 'Fiat'
    private static final String List_Car_Models = "SELECT modelo FROM veiculo WHERE fabricante = ? AND lista_carros = ?";
    

    // Constructor to initialize the database connection

    public List<ConsultarMarcaVeicBean> getAllItems() {
        List<ConsultarMarcaVeicBean> items = new ArrayList<>();
        
        Connection connection = null;
        
        try {
        	connection = DriverManager.getConnection("jdbc:sqlite:E:\\Documents\\Java_Scripts\\06-Jun_2023\\sys_automovel\\sys_auto\\lib\\veiculos.db");
        	Statement statement = connection.createStatement();
        	//statement.setQueryTimeout(1);  // set timeout to 30 sec.
        	ResultSet resultSet = statement.executeQuery(Return_Manufacter);

            while (resultSet.next()) {
            	ConsultarMarcaVeicBean f = new ConsultarMarcaVeicBean();
                f.setId_veic(resultSet.getInt("ID_Fabricante"));
                f.setFabricante(resultSet.getString("Fabricante"));
                //ConsultarVeicBean item = new ConsultarVeicBean(f);
                //This encapsulates, excluding some getters and setters?
                items.add(f);
                //System.out.println(items);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }

        return items;
    }
    
    public Set<ConsultarCarrVeicBean> getBrandVehicles(String brand_Str) {
        Set<ConsultarCarrVeicBean> items = new HashSet<>(); //TreeSet could not apply
        
        Connection connection = null;
        
        try {
        	connection = DriverManager.getConnection("jdbc:sqlite:E:\\Documents\\Java_Scripts\\06-Jun_2023\\sys_automovel\\sys_auto\\lib\\veiculos.db");
        	PreparedStatement statement = connection.prepareStatement(Return_Vehicle);
        	//statement.setQueryTimeout(1);  // set timeout to 30 sec.
        	statement.setString(1, brand_Str);
        	ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	ConsultarCarrVeicBean f = new ConsultarCarrVeicBean();
                f.setVeiculo(resultSet.getString("lista_carros"));
            	//f.setModelo(resultSet.getString("modelo"));
            	//f.setVeiculo(resultSet.getString("veiculo"));
                //ConsultarVeicBean item = new ConsultarVeicBean(f);
                //This encapsulates, excluding some getters and setters?
                items.add(f);
                //System.out.println(items);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }

        return items;
    }
    
    public Set<ConsultarCarrVeicBean> getCarVehicles(String brand_Str, String list_car_Str) {
        Set<ConsultarCarrVeicBean> items = new HashSet<>(); //TreeSet could not apply
        
        Connection connection = null;
        
        try {
        	connection = DriverManager.getConnection("jdbc:sqlite:E:\\Documents\\Java_Scripts\\06-Jun_2023\\sys_automovel\\sys_auto\\lib\\veiculos.db");
        	PreparedStatement statement = connection.prepareStatement(List_Car_Models);
        	//statement.setQueryTimeout(1);  // set timeout to 30 sec.
        	statement.setString(1, brand_Str);
        	statement.setString(2,  list_car_Str);
        	ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	ConsultarCarrVeicBean f = new ConsultarCarrVeicBean();
                //f.setVeiculo(resultSet.getString("veiculo"));
            	f.setModelo(resultSet.getString("modelo"));
            	//f.setVeiculo(resultSet.getString("veiculo"));
                //ConsultarVeicBean item = new ConsultarVeicBean(f);
                //This encapsulates, excluding some getters and setters?
                items.add(f);
                //System.out.println(items);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }

        return items;
    }
}

