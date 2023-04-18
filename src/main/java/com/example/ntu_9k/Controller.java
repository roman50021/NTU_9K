package com.example.ntu_9k;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    private Button fx_OutActors;

    @FXML
    private Button fx_OutEditors;

    @FXML
    private Button fx_OutFilms;

    @FXML
    private Button fx_OutSessions;

    @FXML
    private Button fx_OutStudios;

    @FXML
    private TableView<Movie> fx_OutTableView;

    @FXML
    private Button fx_OutVisitors;

    @FXML
    private TableColumn<Movie, Integer> fx_TableColumn_1;

    @FXML
    private TableColumn<Movie, String> fx_TableColumn_2;

    @FXML
    private TableColumn<Movie, Integer> fx_TableColumn_3;

    @FXML
    private TableColumn<Movie, Integer> fx_TableColumn_4;

    @FXML
    private TableColumn<Movie, Integer> fx_TableColumn_5;

    @FXML
    private TableColumn<Movie, Integer> fx_TableColumn_6;

    @FXML
    private TableColumn<Movie, Integer> fx_TableColumn_7;

    @FXML
    private TableColumn<Movie, Integer> fx_TableColumn_8;

    @FXML
    private TableColumn<Movie, Integer> fx_TableColumn_9;

    private ObservableList<Movie> movieList = FXCollections.observableArrayList();

    public void initialize() {
        // Получаем данные о фильмах из базы данных
        List<Movie> movies = fetchMoviesData();
        // Создаем ObservableList для хранения данных
        ObservableList<Movie> movieList = FXCollections.observableArrayList(movies);
        // Устанавливаем данные в TableView
        fx_OutTableView.setItems(movieList);
        // Настраиваем соответствие между столбцами таблицы и свойствами модели данных
        fx_TableColumn_1.setCellValueFactory(new PropertyValueFactory<>("movieId"));
        fx_TableColumn_2.setCellValueFactory(new PropertyValueFactory<>("title"));
        fx_TableColumn_3.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        fx_TableColumn_4.setCellValueFactory(new PropertyValueFactory<>("directorId"));
        fx_TableColumn_5.setCellValueFactory(new PropertyValueFactory<>("studioId"));
    }

    @FXML
    private void handleFxOutFilmsAction(ActionEvent event) {
        // Получите данные фильмов, например, из базы данных или другого источника
        List<Movie> movies = fetchMoviesData();

        // Очистите текущую модель данных
        movieList.clear();

        // Добавьте новые данные фильмов в модель данных
        movieList.addAll(movies);

        // Обновите TableView
        fx_OutTableView.refresh();
    }

    // Метод для получения данных о фильмах
    private List<Movie> fetchMoviesData() {
        // Соединение с базой данных
        Connection connection = null;
        // Список для хранения данных о фильмах
        List<Movie> movies = new ArrayList<>();
        try {
            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");
            // Выполняем SQL-запрос для извлечения данных из таблицы movies
            String sql = "SELECT * FROM movies";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Извлекаем данные из результата запроса и добавляем их в список movies
            while (resultSet.next()) {
                int id = resultSet.getInt("movie_id");
                String title = resultSet.getString("title");
                int releaseYear = resultSet.getInt("release_year");
                int directorId = resultSet.getInt("director_id");
                int studioId = resultSet.getInt("studio_id");
                Movie movie = new Movie(id, title, releaseYear, directorId, studioId);
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Закрываем соединение с базой данных
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // Верните список объектов Movie, содержащих данные о фильмах
        return movies;
    }
}
