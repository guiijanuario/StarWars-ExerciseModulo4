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
                    String status = resultSet.getString("status");

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

    public void addRebel(String name, int age, String gender, String location, String status) {
        try {
            if (connection != null) {
                sql = "INSERT INTO rebels (name, age, gender, location, status) VALUES (?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setString(3, gender);
                preparedStatement.setString(4, location);
                preparedStatement.setString(5, status);

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

    public Rebel addRebelObj(String name, int age, String gender, String location, String status){
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

    public void reportRebel(Long id) {
        try {
            if (connection != null) {
                // Verifica se o rebelde está na tabela traitors
                sql = "SELECT id FROM traitors WHERE id_rebel = ?";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setLong(1, id);

                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // Se o rebelde estiver na tabela traitors, atualiza o número de warnings
                    sql = "UPDATE traitors SET warnings = warnings + 1 WHERE id_rebel = ?";
                    preparedStatement = connection.prepareStatement(sql);

                    preparedStatement.setLong(1, id);

                    preparedStatement.executeUpdate();

                    // Verifica se o número de warnings é igual a 3
                    sql = "SELECT warnings FROM traitors WHERE id_rebel = ?";
                    preparedStatement = connection.prepareStatement(sql);

                    preparedStatement.setLong(1, id);

                    resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        int warnings = resultSet.getInt("warnings");

                        // Se o número de warnings for igual a 3, atualiza o status do rebelde para 'traidor'
                        if (warnings == 3) {
                            sql = "UPDATE rebels SET status = 'traidor' WHERE id = ?";
                            preparedStatement = connection.prepareStatement(sql);

                            preparedStatement.setLong(1, id);

                            preparedStatement.executeUpdate();
                            System.out.println("\n ---- Ele virou um traidor por já somar 3 denuncias ----");


                            // Imprime os dados do traidor na tela
                            sql = "SELECT id, name, age, gender, location, status FROM rebels WHERE id = ?";
                            preparedStatement = connection.prepareStatement(sql);

                            preparedStatement.setLong(1, id);

                            resultSet = preparedStatement.executeQuery();

                            if (resultSet.next()) {

                                Long idRebelde = resultSet.getLong("id");
                                String name = resultSet.getString("name");
                                int age = resultSet.getInt("age");
                                String gender = resultSet.getString("gender");
                                String location = resultSet.getString("location");
                                String status = resultSet.getString("status");

                                System.out.println("\nID: " + idRebelde);
                                System.out.println("Nome: " + name);
                                System.out.println("Idade: " + age);
                                System.out.println("Gênero: " + gender);
                                System.out.println("Localização: " + location);
                                System.out.println("Status: " + status);
                                System.out.println("-----------------------");
                            }
                        } else if (warnings >= 4) {
                            System.out.println("Ele já é um traidor, tem mais de 3 denuncias.");
                        }
                    }
                } else {
                    // Se o rebelde não estiver na tabela traitors, cria um novo registro
                    sql = "INSERT INTO traitors (id_rebel, warnings) VALUES (?, ?)";
                    preparedStatement = connection.prepareStatement(sql);

                    preparedStatement.setLong(1, id);
                    preparedStatement.setInt(2, 1);

                    preparedStatement.executeUpdate();
                }
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
