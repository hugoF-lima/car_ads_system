package sys_auto_web;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.sql.*;

public class CarDataParser {
    public static void main(String[] args) {
        Connection connection = null;
        Writer writer = null;
        try {
            // Establish a connection to the SQLite database
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:E:\\Documents\\Java_Scripts\\06-Jun_2023\\sys_automovel\\sys_auto\\lib\\veiculos.db");
            System.out.println("Connected to the database.");

            // Create a statement and execute the query to fetch car data
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Fabricante_Anunc, Modelo_Anunc, Ano_veic_Anunc, Km_veic_Anunc, Foto_veic FROM ANUNCIO");

            // Create a JSON array to hold the car data
            JSONArray jsonArray = new JSONArray();

            // Iterate over the result set and populate the JSON array
            while (resultSet.next()) {
                JSONObject carObject = new JSONObject();
                carObject.put("Fabricante_Anunc", resultSet.getString("Fabricante_Anunc"));
                carObject.put("Modelo_Anunc", resultSet.getString("Modelo_Anunc"));
                carObject.put("Ano_veic_Anunc", resultSet.getInt("Ano_veic_Anunc"));
                carObject.put("Km_veic_Anunc", resultSet.getString("Km_veic_Anunc"));

                // Retrieve the BLOB data as a byte array
                byte[] blobBytes = resultSet.getBytes("Foto_veic");

                // Encode the BLOB data as Base64 and include it in the JSON object
                String base64Image = new String(Base64.encodeBase64(blobBytes));
                carObject.put("imageData", base64Image);

                jsonArray.put(carObject);
            }
            
         // Write the JSON array to a file
            writer = new BufferedWriter(new FileWriter("carData.json"));
            writer.write(jsonArray.toString());

            System.out.println("JSON file generated successfully.");

            // Print the JSON array
            System.out.println(jsonArray.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        	// Close the writer
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // Close the database connection
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Database connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

