package org.example.exerciseModule4.service;

import org.example.exerciseModule4.connection.ConnectionDataBase;

import java.sql.*;

public class InventoryService {

    Connection connection = ConnectionDataBase.getConnection();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "";



    public void updateInventoryFromPurchases(Long rebelId) {
        try {
            if (connection != null) {

                String sql = "SELECT item_id, quantity FROM purchases WHERE rebel_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, rebelId);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int itemId = resultSet.getInt("item_id");
                    int quantity = resultSet.getInt("quantity");
                    updateInventory(rebelId, itemId, quantity);
                }

                printInventory(rebelId);
            }
        } catch (SQLException e) {
            System.out.println("[Error] Não foi possível atualizar o inventário do rebelde.");
            e.printStackTrace();
        }
    }

    private void updateInventory(Long rebelId, int itemId, int quantity) throws SQLException {

        String sql = "SELECT id, water_quantity, food_quantity FROM inventory WHERE id_rebel = ? AND id_item = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, rebelId);
        preparedStatement.setInt(2, itemId);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {

            int inventoryId = resultSet.getInt("id");
            int waterQuantity = resultSet.getInt("water_quantity");
            int foodQuantity = resultSet.getInt("food_quantity");

            if (itemId == 10) {
                waterQuantity += quantity;
            } else if (itemId == 11) {
                foodQuantity += quantity;
            }

            sql = "UPDATE inventory SET water_quantity = ?, food_quantity = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, waterQuantity);
            preparedStatement.setInt(2, foodQuantity);
            preparedStatement.setInt(3, inventoryId);
            preparedStatement.executeUpdate();
        } else {

            sql = "INSERT INTO inventory (id_rebel, id_item, water_quantity, food_quantity) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, rebelId);
            preparedStatement.setInt(2, itemId);

            if (itemId == 10) {
                preparedStatement.setInt(3, quantity);
                preparedStatement.setInt(4, 0);
            } else if (itemId == 11) {
                preparedStatement.setInt(3, 0);
                preparedStatement.setInt(4, quantity);
            }

            preparedStatement.executeUpdate();
        }
    }


    private void printInventory(Long rebelId) {
        try {
            // Seleciona os detalhes do inventário do rebelde
            String sql = "SELECT i.name, inv.ammo_quantity, inv.food_quantity, inv.water_quantity FROM inventory inv JOIN items i ON inv.id_item = i.id WHERE inv.id_rebel = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, rebelId);
            resultSet = preparedStatement.executeQuery();

            System.out.println("----- Inventário do Rebelde -----");
            while (resultSet.next()) {
                String itemName = resultSet.getString("name");
                int ammoQuantity = resultSet.getInt("ammo_quantity");
                int foodQuantity = resultSet.getInt("food_quantity");
                int waterQuantity = resultSet.getInt("water_quantity");

                System.out.println("Item: " + itemName);
                System.out.println("Quantidade de Munição: " + ammoQuantity);
                System.out.println("Quantidade de Comida: " + foodQuantity);
                System.out.println("Quantidade de Água: " + waterQuantity);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("[Error] Não foi possível imprimir o inventário do rebelde.");
            e.printStackTrace();
        }
    }
}

