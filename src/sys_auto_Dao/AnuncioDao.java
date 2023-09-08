package sys_auto_Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import groovy.ui.SystemOutputInterceptor;
import sys_auto_beans.ConsultarMarcaVeicBean;
import sys_auto_beans.AnuncioBean;
import sys_auto_beans.ConsultarCarrVeicBean;

public class AnuncioDao {
	
	private static final String Insert_Anuncio = "Insert Into Anuncio (Fabricante_Anunc, Modelo_Anunc, Ano_veic_Anunc, Veic_Anunc, Ipva_veic_Anunc, Licenca_veic_Anunc, Foto_veic, Km_veic_Anunc, Preco_veic_Anunc, Combst_veic_Anunc, Descr_veic_Anunc) Values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String Return_Anuncio = "Select * from veiculo where fabricante = ? "; //select lista_carros from veiculo where Fabricante = 'Fiat'
    private static final String List_Car_Models = "SELECT modelo FROM veiculo WHERE fabricante = ? AND lista_carros = ?";

    public static void InserirAnuncio(AnuncioBean a) {
    	
		Connection connection = null;
		byte[] byteArray = null; 
		
		try {
			System.out.println(Insert_Anuncio);
			connection = DriverManager.getConnection("jdbc:sqlite:E:\\Documents\\Java_Scripts\\06-Jun_2023\\sys_automovel\\sys_auto\\lib\\veiculos.db");
			PreparedStatement statement = connection.prepareStatement(Insert_Anuncio);
        	statement.setString(1, a.getAnunc_fabricante());
        	statement.setString(2, a.getAnunc_modelo());
        	statement.setInt(3, a.getAnunc_anoVeic());
        	statement.setString(4, a.getAnunc_veiculo());
        	statement.setString(5, a.getIpva_StatusVeic());
        	statement.setString(6, a.getLicenca_StatusVeic());
        	byteArray = a.getFoto_Veic();
        	statement.setBytes(7, byteArray);
        	statement.setString(8, a.getKm_Veic());
        	statement.setString(9, a.getPreco_veiculo());
        	statement.setString(10, a.getCombst_veiculo());
        	statement.setString(11, a.getDescr_veic());
			statement.execute();
			
			JOptionPane.showMessageDialog(null,"Anuncio cadastrado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"Falha ao Cadastrar, verifique se os campos estão preenchidos corretamente!"
					+ "\n             Caso o erro persistir, contate os desenvolvedores do sistema!",
					"Erro!", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e1);
			
		}finally {
			
		          try
		          {
		            if(connection != null)
		              connection.close();
		          }
		          catch(SQLException e1)
		          {
		            // connection close failed.
		            System.err.println(e1.getMessage());
		          }
		        
		}
    }
}
