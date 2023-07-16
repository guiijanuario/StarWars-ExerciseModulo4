package org.example.exerciseModule4.service;

import org.example.exerciseModule4.connection.ConnectionDataBase;
import org.example.exerciseModule4.model.Rebel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RebelService {

    Connection connection = ConnectionDataBase.getConnection();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "";

    List<Rebel> rebels = new ArrayList<>();

    public void queryAllRebelData() {

        try {
            if (connection != null) {
                sql = "SELECT * FROM rebels ORDER BY id";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {

                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String gender = resultSet.getString("gender");
                    String location = resultSet.getString("location");
                    boolean status = resultSet.getBoolean("status");

                    System.out.println("-----------------------");
                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + name);
                    System.out.println("Idade: " + age);
                    System.out.println("Gênero: " + gender);
                    System.out.println("Localização: " + location);
                    System.out.println("Status: " + status);
                    System.out.println("-----------------------");

                    rebels.add(new Rebel(id, name, age, gender, location, status));
                }
            }
        } catch (SQLException e) {
            System.out.println("[Error] Não foi possível listar os Rebeldes.");
            e.printStackTrace();
        }
    }

    public void addRebel(String name, int age, String gender, String location, boolean status) {
        try {
            if (connection != null) {
                sql = "INSERT INTO rebels (name, age, gender, location, status) VALUES (?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setString(3, gender);
                preparedStatement.setString(4, location);
                preparedStatement.setBoolean(5, status);

                int checkIfAdded = preparedStatement.executeUpdate();

                if (checkIfAdded > 0) {
                    System.out.println(" ==== Rebelde adicionado com sucesso! ====");
                } else {
                    System.out.println("==== Falha ao adicionar o Rebelde ====");
                }
                preparedStatement.close();
            }
        } catch (SQLException e) {
            System.out.println("[Error] Não foi possível cadastrar um novo Rebelde.");
            e.printStackTrace();
        }
    }

    public Rebel addRebelObj(String name, int age, String gender, String location, boolean status){
        return new Rebel(name, age, gender,location, status);
    }



    public void deleteRebel(Long id) {
        try {
            if (connection != null) {
                sql = "DELETE FROM rebels WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setLong(1, id);

                int checkIfDeleted = preparedStatement.executeUpdate();

                if (checkIfDeleted > 0) {
                    System.out.println("==== Cadastro removido com sucesso! ====");
                } else {
                    System.out.println("==== Nenhum cadastro encontrado com o ID informado. ====");
                }
                preparedStatement.close();
            }
        } catch (SQLException e) {
            System.out.println("[Error] Não foi possível deletar o Rebelde");
            e.printStackTrace();
        }
    }

    public void changeRebelLocation(Long id, String newLocation) {
        try {
            if (connection != null) {
                sql = "UPDATE rebels SET newLocation = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, newLocation);

                int rowsAffected = statement.executeUpdate(sql);

                if (rowsAffected > 0) {
                    System.out.println("==== Dado alterado com sucesso! ====");
                } else {
                    System.out.println("==== Nenhum dado encontrado com o ID informado. ====");
                }
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("[Error] Não foi possível alterar os dados do Rebelde");
            e.printStackTrace();
        }
    }

    public void changeRebelData(String newName, int newAge, String newGender) {
        try {
            if (connection != null) {
                sql = "UPDATE rebels SET name = ?, age = ?, gender = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, newName);
                preparedStatement.setInt(2, newAge);
                preparedStatement.setString(3, newGender);

                int rowsAffected = statement.executeUpdate(sql);

                if (rowsAffected > 0) {
                    System.out.println("==== Dado alterado com sucesso! ====");
                } else {
                    System.out.println("==== Nenhum dado encontrado com o ID informado. ====");
                }
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("[Error] Não foi possível alterar os dados do Rebelde");
            e.printStackTrace();
        }
    }
}
