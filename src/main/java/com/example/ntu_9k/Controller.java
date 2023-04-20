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
            fx_TableColumn_1.setText("Actor_Id");
            fx_TableColumn_2.setText("First Name");
            fx_TableColumn_3.setText("Last Name");
            fx_TableColumn_4.setText(" ");
            fx_TableColumn_5.setText(" ");
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
            fx_TableColumn_1.setText("Movie_Id");
            fx_TableColumn_2.setText("Title");
            fx_TableColumn_3.setText("Release Year");
            fx_TableColumn_4.setText("Director_Id");
            fx_TableColumn_5.setText("Studio_Id");
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

        fx_OutStudios.setOnAction(event -> {
            fx_TableColumn_1.setText("Studio_Id");
            fx_TableColumn_2.setText("Name");
            fx_TableColumn_3.setText(" ");
            fx_TableColumn_4.setText(" ");
            fx_TableColumn_5.setText(" ");
            // Получаем данные о фильмах из базы данных
            List<Studio> studios = fetchStudiosData();
            // Создаем ObservableList для хранения данных
            ObservableList<Cinema> studioList = FXCollections.observableArrayList(studios);
            // Устанавливаем данные в TableView
            fx_OutTableView.setItems(studioList);
            // Настраиваем соответствие между столбцами таблицы и свойствами модели данных
            fx_TableColumn_1.setCellValueFactory(new PropertyValueFactory<>("studioId"));
            fx_TableColumn_2.setCellValueFactory(new PropertyValueFactory<>("name"));
            fx_TableColumn_3.setCellValueFactory(new PropertyValueFactory<>(null));
            fx_TableColumn_4.setCellValueFactory(new PropertyValueFactory<>(null));
            fx_TableColumn_5.setCellValueFactory(new PropertyValueFactory<>(null));
            handleFxOutStudioAction(null);
        });

        fx_OutVisitors.setOnAction(event -> {
            fx_TableColumn_1.setText("Visitors_Id");
            fx_TableColumn_2.setText("First Name");
            fx_TableColumn_3.setText("Last Name");
            fx_TableColumn_4.setText("Session_Id");
            fx_TableColumn_5.setText(" ");
            List<Visitor> visitors = fetchVisitorsData();
            ObservableList<Cinema> visitorList = FXCollections.observableArrayList(visitors);
            fx_OutTableView.setItems(visitorList);
            fx_TableColumn_1.setCellValueFactory(new PropertyValueFactory<>("visitorsId"));
            fx_TableColumn_2.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            fx_TableColumn_3.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            fx_TableColumn_4.setCellValueFactory(new PropertyValueFactory<>("sessionId"));
            fx_TableColumn_5.setCellValueFactory(new PropertyValueFactory<>(null));
            handleFxOutVisitorAction(null);
        });
        fx_OutSessions.setOnAction(event -> {
            fx_TableColumn_1.setText("Session_Id");
            fx_TableColumn_2.setText("Movie_Id");
            fx_TableColumn_3.setText("Visitors_Id");
            fx_TableColumn_4.setText(" ");
            fx_TableColumn_5.setText(" ");
            List<Session> sessions = fetchSessionData();
            ObservableList<Cinema> actorsList = FXCollections.observableArrayList(sessions);
            fx_OutTableView.setItems(actorsList);
            fx_TableColumn_1.setCellValueFactory(new PropertyValueFactory<>("sessionId"));
            fx_TableColumn_2.setCellValueFactory(new PropertyValueFactory<>("movieId"));
            fx_TableColumn_3.setCellValueFactory(new PropertyValueFactory<>("visitorsId"));
            fx_TableColumn_4.setCellValueFactory(new PropertyValueFactory<>(null));
            fx_TableColumn_5.setCellValueFactory(new PropertyValueFactory<>(null));
            handleFxOutSessionAction(null);
        });

        fx_OutEditors.setOnAction(event -> {
            fx_TableColumn_1.setText("Director_Id");
            fx_TableColumn_2.setText("First Name");
            fx_TableColumn_3.setText("Last Name");
            fx_TableColumn_4.setText(" ");
            fx_TableColumn_5.setText(" ");
            List<Director> directors = fetchDirectorData();
            ObservableList<Cinema> visitorList = FXCollections.observableArrayList(directors);
            fx_OutTableView.setItems(visitorList);
            fx_TableColumn_1.setCellValueFactory(new PropertyValueFactory<>("directorId"));
            fx_TableColumn_2.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            fx_TableColumn_3.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            fx_TableColumn_4.setCellValueFactory(new PropertyValueFactory<>(null));
            fx_TableColumn_5.setCellValueFactory(new PropertyValueFactory<>(null));
            handleFxOutDirectorAction(null);
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
    @FXML
    private void handleFxOutStudioAction(ActionEvent event) {
        // Получите данные фильмов, например, из базы данных или другого источника
        List<Studio> studios = fetchStudiosData();

        // Очистите текущую модель данных
        List.clear();

        // Добавьте новые данные фильмов в модель данных
        List.addAll(studios);

        // Обновите TableView
        fx_OutTableView.refresh();
    }
    private List<Studio> fetchStudiosData() {
        // Соединение с базой данных
        Connection connection = null;
        // Список для хранения данных о фильмах
        List<Studio> studios = new ArrayList<>();
        try {
            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");
            // Выполняем SQL-запрос для извлечения данных из таблицы movies
            String sql = "SELECT * FROM studios";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Извлекаем данные из результата запроса и добавляем их в список movies
            while (resultSet.next()) {
                int studio_id = resultSet.getInt("studio_id");
                String name = resultSet.getString("name");


                Studio studio = new Studio(studio_id, name);
                studios.add(studio);
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
        return studios;
    }
    @FXML
    private void handleFxOutVisitorAction(ActionEvent event) {
        // Получите данные фильмов, например, из базы данных или другого источника
        List<Visitor> visitors = fetchVisitorsData();

        // Очистите текущую модель данных
        List.clear();

        // Добавьте новые данные фильмов в модель данных
        List.addAll(visitors);

        // Обновите TableView
        fx_OutTableView.refresh();
    }
    private List<Visitor> fetchVisitorsData() {
        // Соединение с базой данных
        Connection connection = null;
        // Список для хранения данных о фильмах
        List<Visitor> visitors = new ArrayList<>();
        try {
            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");
            // Выполняем SQL-запрос для извлечения данных из таблицы movies
            String sql = "SELECT * FROM visitors";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Извлекаем данные из результата запроса и добавляем их в список movies
            while (resultSet.next()) {
                int visitors_id = resultSet.getInt("visitors_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int session_id = resultSet.getInt("session_id");


                Visitor visitor = new Visitor(visitors_id, first_name,last_name,session_id);
                visitors.add(visitor);
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
        return visitors;
    }
    @FXML
    private void handleFxOutSessionAction(ActionEvent event) {
        // Получите данные фильмов, например, из базы данных или другого источника
        List<Session> sessions = fetchSessionData();

        // Очистите текущую модель данных
        List.clear();

        // Добавьте новые данные фильмов в модель данных
        List.addAll(sessions);

        // Обновите TableView
        fx_OutTableView.refresh();
    }
    private List<Session> fetchSessionData() {
        // Соединение с базой данных
        Connection connection = null;
        // Список для хранения данных о фильмах
        List<Session> sessions = new ArrayList<>();
        try {
            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");
            // Выполняем SQL-запрос для извлечения данных из таблицы movies
            String sql = "SELECT * FROM sessions";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Извлекаем данные из результата запроса и добавляем их в список movies
            while (resultSet.next()) {
                int Session_id = resultSet.getInt("Session_id");
                int movie_id = resultSet.getInt("movie_id");
                int visitors_id = resultSet.getInt("visitors_id");



                Session session = new Session(Session_id,movie_id,visitors_id);
                sessions.add(session);
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
        return sessions;
    }

    @FXML
    private void handleFxOutDirectorAction(ActionEvent event) {
        // Получите данные фильмов, например, из базы данных или другого источника
        List<Director> directors = fetchDirectorData();

        // Очистите текущую модель данных
        List.clear();

        // Добавьте новые данные фильмов в модель данных
        List.addAll(directors);

        // Обновите TableView
        fx_OutTableView.refresh();
    }
    private List<Director> fetchDirectorData() {
        // Соединение с базой данных
        Connection connection = null;
        // Список для хранения данных о фильмах
        List<Director> directors = new ArrayList<>();
        try {
            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");
            // Выполняем SQL-запрос для извлечения данных из таблицы movies
            String sql = "SELECT * FROM directors";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Извлекаем данные из результата запроса и добавляем их в список movies
            while (resultSet.next()) {
                int director_id = resultSet.getInt("director_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");



                Director director = new Director(director_id, first_name, last_name);
                directors.add(director);
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
        return directors;
    }
}
