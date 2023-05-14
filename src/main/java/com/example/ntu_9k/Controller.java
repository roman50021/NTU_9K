package com.example.ntu_9k;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;

public class Controller {
    @FXML
    private Button fx_AddActors;

    @FXML
    private Button fx_AddEditors;

    @FXML
    private Button fx_AddFilms;

    @FXML
    private Button fx_AddSessions;

    @FXML
    private Button fx_AddStudios;

    @FXML
    private Button fx_AddVisitors;

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

    @FXML
    private Button fx_Deletion;


    private ObservableList<Object> List = FXCollections.observableArrayList();

    public void initialize() {


        fx_OutTableView.setEditable(true); //  - робить таблицю редагованою.

        fx_OutActors.setOnAction(event -> { //  - встановлює обробник події на натискання кнопки "fx_OutActors".
            // Далі виконується код, який буде виконуватися при кожному натисканні кнопки.
            fx_TableColumn_1.setText("Actor_Id"); // - встановлює заголовки стовпців таблиці.
            fx_TableColumn_2.setText("First Name"); // - встановлює заголовки стовпців таблиці.
            fx_TableColumn_3.setText("Last Name"); // - встановлює заголовки стовпців таблиці.
            fx_TableColumn_4.setText(" "); // - встановлює заголовки стовпців таблиці.
            fx_TableColumn_5.setText(" "); // - встановлює заголовки стовпців таблиці.
            List<Actor> actors = fetchActorsData(); //  - отримує список об'єктів Actor з бази даних.
            ObservableList<Cinema> actorsList = FXCollections.observableArrayList(actors); //  - перетворює список Actor
            // на ObservableList для використання в таблиці.
            fx_OutTableView.setItems(actorsList); // -  - встановлює новий список елементів таблиці.
            fx_TableColumn_1.setCellValueFactory(new PropertyValueFactory<>("actorId")); // -  - встановлює фабрику
            // значень для кожного стовпця таблиці,
            // що дозволяє відображати значення відповідних полів об'єктів в кожному стовпці.
            fx_TableColumn_2.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            fx_TableColumn_3.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            fx_TableColumn_4.setCellValueFactory(new PropertyValueFactory<>(null));
            fx_TableColumn_5.setCellValueFactory(new PropertyValueFactory<>(null));
            handleFxOutActorAction(null);// - викликає метод handleFxOutActorAction() для оновлення вмісту таблиці.
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
            fx_TableColumn_3.setText(" ");
            fx_TableColumn_4.setText(" ");
            fx_TableColumn_5.setText(" ");
            List<Session> sessions = fetchSessionData();
            ObservableList<Cinema> actorsList = FXCollections.observableArrayList(sessions);
            fx_OutTableView.setItems(actorsList);
            fx_TableColumn_1.setCellValueFactory(new PropertyValueFactory<>("sessionId"));
            fx_TableColumn_2.setCellValueFactory(new PropertyValueFactory<>("movieId"));
            fx_TableColumn_3.setCellValueFactory(new PropertyValueFactory<>(null));
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

        //Ввод данных
        fx_AddFilms.setOnAction(event -> {
            // Создаем диалоговое окно для ввода данных фильма
            Dialog<Movie> dialog = new Dialog<>();
            dialog.setTitle("Добавить фильм");

            // Устанавливаем кнопку "Добавить" и кнопку "Отмена"
            ButtonType addButton = new ButtonType("Добавить", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

            // Создаем форму для ввода данных
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            // Создаем текстовые поля для ввода данных
            TextField titleTextField = new TextField();
            TextField releaseYearTextField = new TextField();
            TextField directorIdTextField = new TextField();
            TextField studioIdTextField = new TextField();

            // Добавляем текстовые поля на форму
            grid.add(new Label("Title:"), 0, 0);
            grid.add(titleTextField, 1, 0);
            grid.add(new Label("Release Year:"), 0, 1);
            grid.add(releaseYearTextField, 1, 1);
            grid.add(new Label("Director Id:"), 0, 2);
            grid.add(directorIdTextField, 1, 2);
            grid.add(new Label("Studio Id:"), 0, 3);
            grid.add(studioIdTextField, 1, 3);

            // Устанавливаем форму на диалоговое окно
            dialog.getDialogPane().setContent(grid);

            // Устанавливаем фокус на поле Title при открытии окна
            Platform.runLater(() -> titleTextField.requestFocus());

            // Обрабатываем результат нажатия кнопки "Добавить"
            dialog.setResultConverter(buttonType -> {
                if (buttonType == addButton) {
                    // Извлекаем данные из текстовых полей
                    String title = titleTextField.getText();
                    int releaseYear = Integer.parseInt(releaseYearTextField.getText());
                    int directorId = Integer.parseInt(directorIdTextField.getText());
                    int studioId = Integer.parseInt(studioIdTextField.getText());

                    // Создаем объект Movie с введенными данными
                    Movie movie = new Movie(0, title, releaseYear, directorId, studioId);

                    // Добавляем фильм в базу данных
                    addMovieToDatabase(movie);

                    // Возвращаем объект Movie в качестве результата
                    return movie;
                }
                return null;
            });

            // Открываем диалоговое окно и ждем результата
            Optional<Movie> result = dialog.showAndWait();

            // Обновляем TableView, если был добавлен новый фильм
            result.ifPresent(movie -> {
                fx_OutTableView.getItems().add(movie);
                fx_OutTableView.refresh();
            });
        });

        fx_AddActors.setOnAction(event -> {
            // Створюємо діалогове вікно для введення даних актора
            Dialog<Actor> dialog = new Dialog<>();
            dialog.setTitle("Добавить актера");

            // Встановлюємо кнопку "Додати" та кнопку "Скасувати"
            ButtonType addButton = new ButtonType("Добавить", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

            // Створюємо форму для введення даних
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            // Створюємо текстові поля для введення даних
            TextField firstNameTextField = new TextField();
            TextField lastNameTextField = new TextField();

            // Додаємо текстові поля на форму
            grid.add(new Label("First Name:"), 0, 0);
            grid.add(firstNameTextField, 1, 0);
            grid.add(new Label("Last Name:"), 0, 1);
            grid.add(lastNameTextField, 1, 1);

            // Встановлюємо форму на діалогове вікно
            dialog.getDialogPane().setContent(grid);

            // Встановлюємо фокус на полі First Name під час відкриття вікна
            Platform.runLater(() -> firstNameTextField.requestFocus());

            // Обробляємо результат натискання кнопки "Додати"
            dialog.setResultConverter(buttonType -> {
                if (buttonType == addButton) {
                    // Вилучаємо дані з текстових полів
                    String firstName = firstNameTextField.getText();
                    String lastName = lastNameTextField.getText();

                    // Створюємо об'єкт Actor із введеними даними
                    Actor actor = new Actor(0,firstName, lastName);

                    // Додаємо актора до бази даних
                    addActorToDatabase(actor);

                    // Повертаємо об'єкт Actor як результат
                    return actor;
                }
                return null;
            });

            // Відкриваємо діалогове вікно і чекаємо на результат
            Optional<Actor> result = dialog.showAndWait();

            //Оновлюємо TableView, якщо було додано новий актор
            result.ifPresent(actor -> {
                fx_OutTableView.getItems().add(actor);
                fx_OutTableView.refresh();
            });
        });

        fx_AddStudios.setOnAction(event -> {
            // Создаем диалоговое окно для ввода данных студии
            Dialog<Studio> dialog = new Dialog<>();
            dialog.setTitle("Добавить студию");

            // Устанавливаем кнопку "Добавить" и кнопку "Отмена"
            ButtonType addButton = new ButtonType("Добавить", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

            // Создаем форму для ввода данных
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            // Создаем текстовое поле для ввода названия студии
            TextField studioNameTextField = new TextField();

            // Добавляем текстовое поле на форму
            grid.add(new Label("Название студии:"), 0, 0);
            grid.add(studioNameTextField, 1, 0);

            // Устанавливаем форму на диалоговое окно
            dialog.getDialogPane().setContent(grid);

            // Устанавливаем фокус на поле Название студии при открытии окна
            Platform.runLater(() -> studioNameTextField.requestFocus());

            // Обрабатываем результат нажатия кнопки "Добавить"
            dialog.setResultConverter(buttonType -> {
                if (buttonType == addButton) {
                    // Извлекаем данные из текстового поля
                    String studioName = studioNameTextField.getText();

                    // Создаем объект Studio с введенными данными и автоматически устанавливаем ID
                    Studio studio = new Studio(0, studioName); // 0 - это временное значение ID

                    // Добавляем студию в базу данных
                    addStudioToDatabase(studio);

                    // Возвращаем объект Studio в качестве результата
                    return studio;
                }
                return null;
            });

            // Открываем диалоговое окно и ждем результата
            Optional<Studio> result = dialog.showAndWait();

            // Обновляем TableView, если была добавлена новая студия
            result.ifPresent(studio -> {
                fx_OutTableView.getItems().add(studio);
                fx_OutTableView.refresh();
            });
        });

        fx_AddSessions.setOnAction(event -> {
            // Создаем диалоговое окно для ввода данных сеанса
            Dialog<Session> dialog = new Dialog<>();
            dialog.setTitle("Добавить сеанс");

            // Устанавливаем кнопку "Добавить" и кнопку "Отмена"
            ButtonType addButton = new ButtonType("Добавить", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

            // Создаем форму для ввода данных
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            // Создаем текстовые поля для ввода данных сеанса
            TextField movieIdTextField = new TextField();


            // Добавляем текстовые поля на форму
            grid.add(new Label("ID фильма:"), 0, 0);
            grid.add(movieIdTextField, 1, 0);


            // Устанавливаем форму на диалоговое окно
            dialog.getDialogPane().setContent(grid);

            // Устанавливаем фокус на поле ID фильма при открытии окна
            Platform.runLater(() -> movieIdTextField.requestFocus());

            // Обрабатываем результат нажатия кнопки "Добавить"
            dialog.setResultConverter(buttonType -> {
                if (buttonType == addButton) {
                    // Извлекаем данные из текстовых полей
                    int movieid = Integer.parseInt(movieIdTextField.getText());


                    // Создаем объект Session с введенными данными и автоматически устанавливаем ID
                    Session session = new Session(0, movieid); // 0 - это временное значение ID

                    // Добавляем сеанс в базу данных
                    addSessionToDatabase(session);

                    // Возвращаем объект Session в качестве результата
                    return session;
                }
                return null;
            });

            // Открываем диалоговое окно и ждем результата
            Optional<Session> result = dialog.showAndWait();

            // Обновляем TableView, если был добавлен новый сеанс
            result.ifPresent(session -> {
                fx_OutTableView.getItems().add(session);
                fx_OutTableView.refresh();
            });



        });

        fx_AddVisitors.setOnAction(event -> {
            // Создаем диалоговое окно для ввода данных посетителя
            Dialog<Visitor> dialog = new Dialog<>();
            dialog.setTitle("Добавить посетителя");

            // Устанавливаем кнопку "Добавить" и кнопку "Отмена"
            ButtonType addButton = new ButtonType("Добавить", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

            // Создаем форму для ввода данных
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            // Создаем текстовые поля для ввода данных посетителя и Session_id
            TextField firstNameTextField = new TextField();
            TextField lastNameTextField = new TextField();
            TextField sessionIdTextField = new TextField();

            // Добавляем текстовые поля на форму
            grid.add(new Label("Имя:"), 0, 0);
            grid.add(firstNameTextField, 1, 0);
            grid.add(new Label("Фамилия:"), 0, 1);
            grid.add(lastNameTextField, 1, 1);
            grid.add(new Label("ID сессии:"), 0, 2);
            grid.add(sessionIdTextField, 1, 2);

            // Устанавливаем форму на диалоговое окно
            dialog.getDialogPane().setContent(grid);

            // Устанавливаем фокус на поле Имя при открытии окна
            Platform.runLater(() -> firstNameTextField.requestFocus());

            // Обрабатываем результат нажатия кнопки "Добавить"
            dialog.setResultConverter(buttonType -> {
                if (buttonType == addButton) {
                    // Извлекаем данные из текстовых полей
                    String firstName = firstNameTextField.getText();
                    String lastName = lastNameTextField.getText();
                    int sessionId = Integer.parseInt(sessionIdTextField.getText()); // Получаем значение Session_id и преобразуем его в int

                    // Создаем объект Visitor с введенными данными и автоматически устанавливаем ID и Session_id
                    Visitor visitor = new Visitor(0, firstName, lastName, sessionId);
                    visitor.setSessionId(sessionId);

                    // Добавляем посетителя в базу данных
                    addVisitorToDatabase(visitor);

                    // Возвращаем объект Visitor в качестве результата
                    return visitor;
                }
                return null;
            });

            // Открываем диалоговое окно и ждем результата
            Optional<Visitor> result = dialog.showAndWait();

            // Обновляем TableView, если был добавлен новый посетитель
            result.ifPresent(visitor -> {
                fx_OutTableView.getItems().add(visitor);
                fx_OutTableView.refresh();
            });
        });
        fx_AddEditors.setOnAction(event -> {
            // Создаем диалоговое окно для ввода данных редактора
            Dialog<Director> dialog = new Dialog<>();
            dialog.setTitle("Добавить редактора");

            // Устанавливаем кнопку "Добавить" и кнопку "Отмена"
            ButtonType addButton = new ButtonType("Добавить", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

            // Создаем форму для ввода данных
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            // Создаем текстовые поля для ввода данных редактора
            TextField firstNameTextField = new TextField();
            TextField lastNameTextField = new TextField();


            // Добавляем текстовые поля на форму
            grid.add(new Label("Имя:"), 0, 0);
            grid.add(firstNameTextField, 1, 0);
            grid.add(new Label("Фамилия:"), 0, 1);
            grid.add(lastNameTextField, 1, 1);


            // Устанавливаем форму на диалоговое окно
            dialog.getDialogPane().setContent(grid);

            // Устанавливаем фокус на поле Имя при открытии окна
            Platform.runLater(() -> firstNameTextField.requestFocus());

            // Обрабатываем результат нажатия кнопки "Добавить"
            dialog.setResultConverter(buttonType -> {
                if (buttonType == addButton) {
                    // Извлекаем данные из текстовых полей
                    String firstName = firstNameTextField.getText();
                    String lastName = lastNameTextField.getText();


                    // Создаем объект Editor с введенными данными и автоматически устанавливаем ID
                    Director director = new Director(0, firstName, lastName);

                    // Добавляем редактора в базу данных
                    addEditorToDatabase(director);

                    // Возвращаем объект Editor в качестве результата
                    return director;
                }
                return null;
            });

            // Открываем диалоговое окно и ждем результата
            Optional<Director> result = dialog.showAndWait();

            // Обновляем TableView, если был добавлен новый редактор
            result.ifPresent(director -> {
                fx_OutTableView.getItems().add(director);
                fx_OutTableView.refresh();
            });
        });

        //Удаление элементов


        fx_Deletion.setOnAction(event -> {
            // Створюємо діалогове вікно для видалення елемента з таблиці
            Dialog<Void> dialog = new Dialog<>();
            dialog.setTitle("Удалить элемент из таблицы");

            // Встановлюємо кнопку "Видалити" та кнопку "Скасувати"
            ButtonType deleteButton = new ButtonType("Удалить", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(deleteButton, ButtonType.CANCEL);

            // Створюємо форму для вибору таблиці та введення імені колонки та значення ID
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            // Створюємо ChoiceBox для вибору таблиці
            ChoiceBox<String> tableChoiceBox = new ChoiceBox<>();
            tableChoiceBox.getItems().addAll("actors", "directors", "movies", "sessions", "studios", "visitors");
            tableChoiceBox.setValue("actors");

            // Створюємо текстове поле для введення імені колонки
            TextField columnNameTextField = new TextField();
            columnNameTextField.setPromptText("Введите имя колонки");

            // Створюємо текстове поле для введення значення ID
            TextField idTextField = new TextField();
            idTextField.setPromptText("Введите значение ID");

            // Додаємо ChoiceBox та текстові поля на форму
            grid.add(new Label("Таблица:"), 0, 0);
            grid.add(tableChoiceBox, 1, 0);
            grid.add(new Label("Имя колонки:"), 0, 1);
            grid.add(columnNameTextField, 1, 1);
            grid.add(new Label("Значение ID:"), 0, 2);
            grid.add(idTextField, 1, 2);

            // Встановлюємо форму на діалогове вікно
            dialog.getDialogPane().setContent(grid);

            // Встановлюємо фокус на полі введення імені колонки під час відкриття вікна
            Platform.runLater(() -> columnNameTextField.requestFocus());

            // Обробляємо результат натискання кнопки "Видалити"
            dialog.setResultConverter(buttonType -> {
                if (buttonType == deleteButton) {
                    // Виймаємо вибрану таблицю, ім'я колонки та значення ID з полів уведення
                    String table = tableChoiceBox.getValue();
                    String columnName = columnNameTextField.getText();
                    String id = idTextField.getText();

                    // Викликаємо метод deleteElementFromDatabase() з передачею імені колонки, значення ID та імені таблиці
                    deleteElementFromDatabase(table, columnName, id);



                    // Повертаємо результат діалогу
                    return null;
                }
                return null;
            });

            // Відображаємо діалогове вікно та чекаємо на його закриття
            dialog.showAndWait();
        });
    }
    private void deleteElementFromDatabase(String table, String columnName, String id) {
        try {
            //Створюємо підключення до бази даних
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");
            // Створюємо SQL-запит для видалення елемента з таблиці
            String sql = "DELETE FROM " + table + " WHERE " + columnName + " = ?";
            // Готуємо SQL-запит
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //Встановлюємо значення ID у параметр SQL-запиту
            preparedStatement.setString(1, id);
            // Виконуємо SQL-запит
            preparedStatement.executeUpdate();
            // Закриваємо з'єднання з базою даних та звільняємо ресурси
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void addEditorToDatabase(Director director) {
        // Подключение к базе данных
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Установка соединения с базой данных
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");

            // Создание SQL-запроса для вставки нового редактора в базу данных
            String sql = "INSERT INTO directors (first_name, last_name) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, director.getFirst_name());
            preparedStatement.setString(2, director.getLast_name());


            // Выполнение SQL-запроса
            preparedStatement.executeUpdate();

            System.out.println("Редактор успешно добавлен в базу данных.");
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении редактора в базу данных: " + e.getMessage());
        } finally {
            // Закрытие ресурсов
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    System.out.println("Ошибка при закрытии PreparedStatement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Ошибка при закрытии Connection: " + e.getMessage());
                }
            }
        }
    }

    private void addVisitorToDatabase(Visitor visitor) {
        // Подключение к базе данных
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");

            // Создание SQL-запроса для вставки нового посетителя в базу данных
            String sql = "INSERT INTO visitors (first_name, last_name, session_id) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, visitor.getFirstName());
            preparedStatement.setString(2, visitor.getLastName());
            preparedStatement.setInt(3, visitor.getSessionId());

            // Выполнение SQL-запроса
            preparedStatement.executeUpdate();

            System.out.println("Посетитель успешно добавлен в базу данных.");
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении посетителя в базу данных: " + e.getMessage());
        } finally {
            // Закрытие ресурсов
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    System.out.println("Ошибка при закрытии PreparedStatement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Ошибка при закрытии Connection: " + e.getMessage());
                }
            }
        }
    }

    private void addSessionToDatabase(Session session) {
        // Подключаемся к базе данных
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");

            // Создаем SQL-запрос для вставки новой сессии в базу данных
            String sql = "INSERT INTO sessions (movie_id) VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, session.getMovieId());



            // Выполняем SQL-запрос
            preparedStatement.executeUpdate();

            System.out.println("Сессия успешно добавлена в базу данных.");
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении сессии в базу данных: " + e.getMessage());
        } finally {
            // Закрываем ресурсы
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    System.out.println("Ошибка при закрытии PreparedStatement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Ошибка при закрытии Connection: " + e.getMessage());
                }
            }
        }
    }
    private void addStudioToDatabase(Studio studio) {
        try {
            // Создаем подключение к базе данных
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");

            // Создаем SQL-запрос на добавление студии без указания значения для поля id
            String query = "INSERT INTO studios (name) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, studio.getName());

            // Выполняем SQL-запрос
            preparedStatement.executeUpdate();

            // Получаем сгенерированный базой данных ID студии
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int studioId = generatedKeys.getInt(1);
                studio.setStudioId(studioId); // Устанавливаем сгенерированный ID студии в объекте Studio
            }

            // Закрываем подключение к базе данных
            preparedStatement.close();
            connection.close();

            System.out.println("Студия успешно добавлена в базу данных. ID: " + studio.getStudioId());
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении студии в базу данных: " + e.getMessage());
        }
    }
    // Оголошення методу з параметром типу Actor, який додає актора до бази даних
    private void addActorToDatabase(Actor actor) {
        try {
            // Створення підключення до бази даних з використанням параметрів підключення
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");

            // Підготовка SQL-запиту на вставку даних про актора в таблицю actors
            // Запит містить два параметри, які потрібно встановити з використанням PreparedStatement
            String query = "INSERT INTO actors (first_name, last_name) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, actor.getFirstName());
            preparedStatement.setString(2, actor.getLastName());


            // Виконання SQL-запиту на вставку даних про актора в таблицю actors
            preparedStatement.executeUpdate();

            // Отримання ID актора, що було згенеровано автоматично базою даних
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int actorId = generatedKeys.getInt(1);
                actor.setActorId(actorId); // Встановлення ID актора в об'єкті Actor

            }

            // Закриття підключення до бази даних
            preparedStatement.close();
            connection.close();

            // Виведення повідомлення про успішне додавання актора до бази даних
            System.out.println("Актер успешно добавлен в базу данных. ID: " + actor.getActorId());
        } catch (SQLException e) {
            // Виведення повідомлення про помилку при додаванні актора до бази даних
            System.out.println("Ошибка при добавлении актера в базу данных: " + e.getMessage());
        }
    }

    private void addMovieToDatabase(Movie movie) {
        // Подключение к базе данных (предполагается, что у вас уже есть соединение с базой данных)
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ntuk", "root", "sabarak");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ; // Получение соединения с базой данных

        try {
            // Создаем PreparedStatement для выполнения SQL-запроса
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movies (title, release_year, director_id, studio_id) VALUES (?, ?, ?, ?)");

            // Устанавливаем параметры запроса на основе данных фильма
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getReleaseYear());
            preparedStatement.setInt(3, movie.getDirectorId());
            preparedStatement.setInt(4, movie.getStudioId());

            // Выполняем SQL-запрос
            preparedStatement.executeUpdate();

            // Закрываем PreparedStatement
            preparedStatement.close();

            // Закрываем соединение с базой данных
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleFxOutFilmsAction(ActionEvent event) {
        // Получаем данные фильмов из базы данных
        List<Movie> movies = fetchMoviesData();
        // Очищаем текущую модель данных
        fx_OutTableView.getItems().clear();
        // Добавляем новые данные фильмов в модель данных
        fx_OutTableView.getItems().addAll(movies);
        // Обновляем TableView
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


                Session session = new Session(Session_id,movie_id);
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
