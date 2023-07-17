package org.example.exerciseModule4.service;

import org.example.exerciseModule4.connection.ConnectionDataBase;

import java.sql.*;

public class ItemService {

    Connection connection = ConnectionDataBase.getConnection();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "";

    public void queryAllItemsData() {

        try {
            if (connection != null) {
                sql = "SELECT * FROM items ORDER BY id";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);

                System.out.println("--------------------------------------");
                System.out.println("Lista de itens disponível para compra");
                System.out.println("--------------------------------------");

                while (resultSet.next()) {

                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    int damage = resultSet.getInt("damage");
                    String color = resultSet.getString("color");
                    int durability = resultSet.getInt("durability");
                    int maximumAmmoAmount = resultSet.getInt("maximumAmmoAmount");
                    int amount = resultSet.getInt("amount");
                    String category = resultSet.getString("category");

                    System.out.println("------------------------------------------");
                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + name);
                    System.out.println("Dano: " + damage);
                    System.out.println("Cor: " + color);
                    System.out.println("Durabilidade: " + durability);
                    System.out.println("Capacidade máxima de munição: " + maximumAmmoAmount);
                    System.out.println("Quantidade: " + amount);
                    System.out.println("Categoria do item: " + category);
                    System.out.println("------------------------------------------");
                }
            }
        } catch (SQLException e) {
            System.out.println("[Error] Não foi possível listar os Rebeldes.");
            e.printStackTrace();
        }
    }
}
