package org.example.exerciseModule4.service;

import org.example.exerciseModule4.connection.ConnectionDataBase;

import java.sql.*;

public class StoreService {
    Connection connection = ConnectionDataBase.getConnection();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "";

    public void buyItems(int rebelId, int itemId, int quantity, double price) {

        try {
            if (connection != null) {

                sql = "SELECT * FROM rebels WHERE id = " + rebelId;
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    if(resultSet.getString("status").equals("traidor")) {
                        System.out.println("--------------------------------------------");
                        System.out.println(" Atenção: Ele é um traidor não pode comprar");
                        System.out.println("--------------------------------------------");
                    }else {
                        sql = "INSERT INTO purchases (rebel_id, item_id, quantity, price) VALUES (?, ?, ?, ?)";
                        preparedStatement = connection.prepareStatement(sql);

                        preparedStatement.setInt(1, rebelId);
                        preparedStatement.setInt(2, itemId);
                        preparedStatement.setInt(3, quantity);
                        preparedStatement.setDouble(4, price);

                        preparedStatement.executeUpdate();

                        preparedStatement.getUpdateCount();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("[Error] Não foi possível realizar a compra");
            e.printStackTrace();
        }

    }

    public void listSales() {

        try {
            if (connection != null) {
                sql = "SELECT purchases.id, rebels.name AS rebel_name, items.id AS item_id, items.name AS item_name, purchases.quantity, purchases.price FROM purchases JOIN rebels ON purchases.rebel_id = rebels.id JOIN items ON purchases.item_id = items.id;";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);

                System.out.println("--------------------------------------");
                System.out.println("          Lista de vendas             ");
                System.out.println("--------------------------------------");

                while (resultSet.next()) {

                    Long id = resultSet.getLong("id");
                    String nameRebel = resultSet.getString("rebel_name");
                    int idItem = resultSet.getInt("item_id");
                    String nameItem = resultSet.getString("item_name");
                    int quantityItem = resultSet.getInt("quantity");
                    int priceSale = resultSet.getInt("price");

                    System.out.println("------------------------------------------");
                    System.out.println("ID da Compra: " + id);
                    System.out.println("Nome Rebelde: " + nameRebel);
                    System.out.println("ID do Item: " + idItem);
                    System.out.println("Nome Item: " + nameItem);
                    System.out.println("Quantidade de item vendido: " + quantityItem);
                    System.out.println("Preço da venda: " + priceSale);
                    System.out.println("------------------------------------------");
                }
            }
        } catch (SQLException e) {
            System.out.println("[Error] Não foi possível listar as compras.");
            e.printStackTrace();
        }
    }
}
