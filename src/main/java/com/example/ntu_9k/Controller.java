package com.example.ntu_9k;
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
    private TableView<Cinema> fx_OutTableView;


    @FXML
    private Button fx_OutVisitors;

    @FXML
    private TableColumn<?, ?> fx_TableColumn_1;

    @FXML
    private TableColumn<?, ?> fx_TableColumn_2;

    @FXML
    private TableColumn<?, ?> fx_TableColumn_3;

    @FXML
    private TableColumn<?, ?> fx_TableColumn_4;

    @FXML
    private TableColumn<?, ?> fx_TableColumn_5;

    @FXML
    private TableColumn<?, ?> fx_TableColumn_6;

    @FXML
    private TableColumn<?, ?> fx_TableColumn_7;

    @FXML
    private TableColumn<?, ?> fx_TableColumn_8;

    @FXML
    private TableColumn<?, ?> fx_TableColumn_9;

    private ObservableList<Object> List = FXCollections.observableArrayList();

    public void initialize() {
        fx_OutActors.setOnAction(event -> {
            List<Actor> actors = fetchActorsData();
            ObservableList<Cinema> actorsList = FXCollections.observableArrayList(actors);
            fx_OutTableView.setItems(actorsList);
            fx_TableColumn_1.setCellValueFactory(new PropertyValueFactory<>("actorId"));
            fx_TableColumn_2.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            fx_TableColumn_3.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            fx_TableColumn_4.setCellValueFactory(new PropertyValueFactory<>(null));
            fx_TableColumn_5.setCellValueFactory(new PropertyValueFactory<>(null));
            handleFxOutActorAction(null);
        });


        fx_OutFilms.setOnAction(event -> {
            // Получаем данные о фильмах из базы данных
            List<Movie> movies = fetchMoviesData();
            // Создаем ObservableList для хранения данных
            ObservableList<Cinema> movieList = FXCollections.observableArrayList(movies);
            // Устанавливаем данные в TableView
            fx_OutTableView.setItems(movieList);
            // Настраиваем соответствие между столбцами таблицы и свойствами модели данных
            fx_TableColumn_1.setCellValueFactory(new PropertyValueFactory<>("movieId"));
            fx_TableColumn_2.setCellValueFactory(new PropertyValueFactory<>("title"));
            fx_TableColumn_3.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
            fx_TableColumn_4.setCellValueFactory(new PropertyValueFactory<>("directorId"));
            fx_TableColumn_5.setCellValueFactory(new PropertyValueFactory<>("studioId"));
            handleFxOutFilmsAction(null);
        });
    }

    @FXML
    private void handleFxOutFilmsAction(ActionEvent event) {
        // Получите данные фильмов, например, из базы данных или другого источника
        List<Movie> movies = fetchMoviesData();

        // Очистите текущую модель данных
        List.clear();

        // Добавьте новые данные фильмов в модель данных
        List.addAll(movies);

        // Обновите TableView
        fx_OutTableView.refresh();
    }
    @FXML
    private void handleFxOutActorAction(ActionEvent event) {
        // Получите данные фильмов, например, из базы данных или другого источника
        List<Actor> actors = fetchActorsData();

        // Очистите текущую модель данных
        List.clear();

        // Добавьте новые данные фильмов в модель данных
        List.addAll(actors);

        // Обновите TableView
        fx_OutTableView.refresh();
    }

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
    private List<Actor> fetchActorsData() {
        // Соединение с базой данных
        Connection connection = null;
        // Список для хранения данных о фильмах
        List<Actor> actors = new ArrayList<>();
        try {
            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");
            // Выполняем SQL-запрос для извлечения данных из таблицы movies
            String sql = "SELECT * FROM actors";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Извлекаем данные из результата запроса и добавляем их в список movies
            while (resultSet.next()) {
                int actor_id = resultSet.getInt("actor_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");

                Actor actor = new Actor(actor_id, first_name, last_name);
                actors.add(actor);
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
        return actors;
    }
}
