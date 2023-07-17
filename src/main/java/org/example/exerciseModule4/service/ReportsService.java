package org.example.exerciseModule4.service;

import org.example.exerciseModule4.connection.ConnectionDataBase;
import org.example.exerciseModule4.model.Reports;

import java.sql.*;

public class ReportsService {

    private Reports reports;
    Connection connection = ConnectionDataBase.getConnection();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "";

    public void reportsPorcent(){

        sql = "SELECT status FROM rebels";

        int rebels = 0;
        int traitors = 0;
        int total = 0;

        try{
            if(connection != null) {
                sql = "SELECT status FROM rebels WHERE id = ?";
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    if(resultSet.getString("status").equals("aliado")) {
                        rebels += 1;
                    }else {
                        traitors += 1;
                    }

                }

                total = rebels + traitors;

                System.out.println("----------------------------------------------------------------------------------------------");
                System.out.println("                                    " + ((rebels * 100)/ total) + "%" + " -> São Rebeldes ");
                System.out.println("                                    " + ((traitors * 100)/ total) + "%" + " -> São Traidores ");
                System.out.println("----------------------------------------------------------------------------------------------");
            }
        }catch (SQLException e) {
            System.out.println("Não foi possível gerar o relatório!:");

            e.printStackTrace();
        }

    }


}
