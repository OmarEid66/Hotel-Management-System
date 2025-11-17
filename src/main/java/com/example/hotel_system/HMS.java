package com.example.hotel_system;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.*;

public class HMS extends Application {

    List<Room> rooms = new ArrayList<>();
    List<Guest> guests = new ArrayList<>();
    List<Booking> bookings = new ArrayList<>();
    List<Offer> offers = new ArrayList<>();

    public static void Main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primary_stage) {

        rooms.add(new Single("1001", 50.0));
        rooms.add(new Double("2001", 45.0));
        rooms.add(new Triple("3001", 30.0));
        rooms.add(new Single("1002", 47.0));
        rooms.add(new Double("2002", 42.0));
        rooms.add(new Triple("3002", 28.0));
        rooms.add(new Single("1003", 51.0));
        rooms.add(new Double("2003", 46.0));
        rooms.add(new Triple("3003", 31.0));

        offers.add(new Offer("Shine in Summer",
                15.0,
                LocalDate.of(2025, 6, 1),
                LocalDate.of(2025, 8, 31)));
        offers.add(new Offer("Early Bird",
                10.0,
                LocalDate.of(2025, 12, 29),
                LocalDate.of(2026, 1, 3)));

        Font defaultFont = Font.font("Arial");

        Image backgroundImage = new Image(
                "C:\\Users\\youss\\OneDrive\\Desktop\\advanced labs" +
                        "\\course project\\Hotel System\\src\\main\\java\\com\\" +
                        "example\\hotel_system\\home.png");
        ImageView bg = new ImageView(backgroundImage);
        bg.setOpacity(0.6);
        bg.setFitWidth(1650);
        bg.setFitHeight(900);
        bg.setPreserveRatio(false);

        Button mange_rooms = new Button("Manage Rooms");
        mange_rooms.setStyle("-fx-background-color: #1035AC; -fx-text-fill: white; -fx-font-size: 20; ");
        mange_rooms.setFont(defaultFont);

        Button check_in = new Button("Check in");
        check_in.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 20; ");
        check_in.setFont(defaultFont);

        Button check_out = new Button("Check Out");
        check_out.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-font-size: 20; ");
        check_out.setFont(defaultFont);


        HBox buttons = new HBox(mange_rooms, check_in, check_out);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(70);

        StackPane root = new StackPane(bg,buttons);
        Scene dashboard = new Scene(root, 950, 700);
        primary_stage.setScene(dashboard);
        primary_stage.show();

        check_in.setOnAction(f -> {
            Image backgroundImage1 = new Image(
                    "C:\\Users\\youss\\OneDrive\\Desktop\\advanced labs" +
                            "\\course project\\Hotel System\\src\\main\\java\\com\\" +
                            "example\\hotel_system\\side_tab.png");
            ImageView bg1 = new ImageView(backgroundImage1);
            bg1.setOpacity(0.6);
            bg1.setFitWidth(1650); // Increased width for two columns
            bg1.setFitHeight(900);
            bg1.setPreserveRatio(false);

            // Main container with two columns
            HBox mainContainer = new HBox(); //to hold left grid and right grid
            mainContainer.setSpacing(200);
            mainContainer.setAlignment(Pos.CENTER);

            // Left Grid (Personal Info)
            GridPane leftGrid = new GridPane();
            leftGrid.setPadding(new Insets(20));
            leftGrid.setAlignment(Pos.CENTER);
            leftGrid.setVgap(20);
            leftGrid.setHgap(20);

            // Right Grid (Reservation Info)
            GridPane rightGrid = new GridPane();
            rightGrid.setPadding(new Insets(20));
            rightGrid.setAlignment(Pos.CENTER);
            rightGrid.setVgap(20);
            rightGrid.setHgap(20);

            // Form title
            Label title = new Label("Guest Registration Form");
            title.setStyle("-fx-font-size: 20; -fx-font-weight: bold; ");
            leftGrid.add(title, 0, 0, 2, 1);

            // Personal Info Components (Left Grid)
            TextField name = new TextField();
            name.setFont(defaultFont);
            leftGrid.add(new Label("Name:") {{
                setStyle(" -fx-font-size: 16px; -fx-font-weight: bold;");
            }}, 0, 1);
            leftGrid.add(name, 0, 2);

            TextField mobile = new TextField();
            mobile.setFont(defaultFont);
            leftGrid.add(new Label("Mobile Number:") {{
                setStyle(" -fx-font-size: 14px; -fx-font-weight: bold;");
            }}, 0, 3);
            leftGrid.add(mobile, 0, 4);

            TextField email = new TextField();
            email.setFont(defaultFont);
            leftGrid.add(new Label("Email:") {{
                setStyle(" -fx-font-size: 14px; -fx-font-weight: bold;");
            }}, 0, 5);
            leftGrid.add(email, 0, 6);

            ToggleGroup gender = new ToggleGroup();
            RadioButton male = new RadioButton("Male");
            male.setFont(defaultFont);
            male.setToggleGroup(gender);
            RadioButton female = new RadioButton("Female");
            female.setFont(defaultFont);
            female.setToggleGroup(gender);

            leftGrid.add(new Label("Gender:") {{
                setStyle(" -fx-font-size: 14px; -fx-font-weight: bold;");
            }}, 0, 7);

            HBox genderBox = new HBox(male, female);
            genderBox.setSpacing(10);
            leftGrid.add(genderBox, 0, 8);

            TextField nationality = new TextField();
            nationality.setFont(defaultFont);
            leftGrid.add(new Label("Nationality:") {{
                setStyle(" -fx-font-size: 14px; -fx-font-weight: bold;");
            }}, 0, 9);
            leftGrid.add(nationality, 0, 10);

            TextField nationalID = new TextField();
            nationalID.setFont(defaultFont);
            leftGrid.add(new Label("National ID:") {{
                setStyle(" -fx-font-size: 14px; -fx-font-weight: bold;");
            }}, 0, 11);
            leftGrid.add(nationalID, 0, 12);

            // Reservation Components (Right Grid)
            DatePicker checkInDate = new DatePicker();
            checkInDate.setStyle("-fx-font-size: 16; ");
            // Disable dates before today
            checkInDate.setDayCellFactory(picker -> new DateCell() {
                @Override
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    // Disable past dates and style them
                    if (date.isBefore(today)) {
                        setDisable(true); // Make unselectable
                        setStyle("-fx-background-color: #eeeeee; -fx-text-fill: #aaaaaa;"); // Gray out
                    }
                }
            });
            rightGrid.add(new Label("Check IN Date:") {{
                setStyle(" -fx-font-size: 14px; -fx-font-weight: bold;");
            }}, 0, 1);
            rightGrid.add(checkInDate, 0, 2);

            ComboBox <String> roomTypeCombo = new ComboBox<>();
            roomTypeCombo.setStyle("-fx-font-size: 16; ");
            roomTypeCombo.getItems().addAll("Single", "Double", "Triple");
            rightGrid.add(new Label("Room Type:") {{
                setStyle(" " +
                        "-fx-font-size: 14px; " +
                        "-fx-font-weight: bold;");
            }}, 0, 3);
            rightGrid.add(roomTypeCombo, 0, 4);

            ComboBox<String> roomNoCombo = new ComboBox<>();
            roomNoCombo.setStyle("-fx-font-size: 16; ");
            roomNoCombo.setDisable(true);
            rightGrid.add(new Label("Room Number:") {{
                setStyle(" " +
                        "-fx-font-size: 14px; " +
                        "-fx-font-weight: bold;"); }}, 0, 5);
            rightGrid.add(roomNoCombo, 0, 6);

            // Handle selection changes when the combo box loses focus
            roomTypeCombo.setOnAction(event -> {//the selected room type
                if (roomTypeCombo.getValue() != null) {
                    roomNoCombo.getItems().clear();
                    for (Room r : rooms) {
                        if (r.getRoomType().equals(roomTypeCombo.getValue()) && r.getStatues())
                            roomNoCombo.getItems().add(r.getRoomNo());
                    }
                    roomNoCombo.setDisable(false);
                } else {
                    roomNoCombo.getItems().clear();
                    roomNoCombo.setDisable(true);
                }
            });

            TextField Deposit = new TextField();
            Deposit.setFont(defaultFont);
            rightGrid.add(new Label("Deposit:") {{
                setStyle(" " +
                        "-fx-font-size: 14px; " +
                        "-fx-font-weight: bold;");}}, 0, 7);
            rightGrid.add(Deposit, 0, 8);

            ComboBox<Offer> offerCombo = new ComboBox<>();
            offerCombo.getItems().addAll(offers);
            offerCombo.setStyle("-fx-font-size: 16; ");
            rightGrid.add(new Label("Offers:") {{
                setStyle(" -fx-font-size: 14px; -fx-font-weight: bold;");
            }}, 0, 9);
            rightGrid.add(offerCombo, 0, 10, 2, 1);

            checkInDate.setOnAction(event -> {//the selected room type
                if (checkInDate.getValue() != null) {
                    offerCombo.getItems().clear();
                    for (Offer o : offers) {
                        if (o.isValidForDate(checkInDate.getValue()))
                            offerCombo.getItems().add(o);
                    }
                } else {
                    offerCombo.getItems().clear();
                }
            });

            // Styled Buttons
            Button confirmButton = new Button("Confirm");
            confirmButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16; ");
            confirmButton.setFont(defaultFont);

            Button clearButton = new Button("Clear");
            clearButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-font-size: 16; ");
            clearButton.setFont(defaultFont);

            // Add buttons to right grid
            GridPane buttonPane = new GridPane();
            buttonPane.setHgap(15);
            buttonPane.add(confirmButton, 0, 0);
            buttonPane.add(clearButton, 1, 0);
            rightGrid.add(buttonPane, 0, 11, 2, 1);

            Button homeButton = new Button("Return to Home");
            homeButton.setStyle("-fx-background-color: #1035AC; -fx-text-fill: white; -fx-font-size: 16; ");
            homeButton.setFont(defaultFont);
            rightGrid.add(homeButton, 0, 12, 2, 1);

            // Confirmation Text
            Text statuesText = new Text();
            statuesText.setFont(defaultFont);
            statuesText.setVisible(true);
            statuesText.setFill(Color.FIREBRICK);
            statuesText.setStyle(" -fx-font-size: 20px; -fx-font-weight: bold;");
            rightGrid.add(statuesText, 0, 13, 2, 1);

            confirmButton.setOnAction(e -> {
                String selectedRoomNo = roomNoCombo.getValue();
                String selectedRoomType = roomTypeCombo.getValue();

                // Find the room that match type and is Available
                Room foundRoom = rooms.stream()
                        .filter(r -> String.valueOf(r.getRoomNo()).equals(selectedRoomNo) &&
                                r.getRoomType().equals(selectedRoomType))
                        .findFirst()
                        .orElse(null);

                try {
                    if (name.getText().isEmpty() ||
                        name.getText().isEmpty() ||
                        email.getText().isEmpty() ||
                        ((RadioButton) gender.getSelectedToggle()).getText().isEmpty() ||
                        Deposit.getText().isEmpty()||
                        nationality.getText().isEmpty() ||
                        nationalID.getText().isEmpty()||
                        checkInDate.getValue().toString().isEmpty() ||
                        roomNoCombo.getSelectionModel().isEmpty() ||
                        roomTypeCombo.getSelectionModel().isEmpty())
                        throw new IllegalArgumentException("Some Fields are missing or wrong \n  recheck data entered");
                         else {
                        Guest g = new Guest(
                                name.getText(),
                                mobile.getText(),
                                email.getText(),
                                ((RadioButton) gender.getSelectedToggle()).getText(),
                                nationality.getText(),
                                nationalID.getText()
                        );

                        Booking b;
                        if (!offerCombo.getSelectionModel().isEmpty()){ //choose between the two constructors of booking class
                            b = new Booking(
                                    g,
                                    foundRoom,
                                    java.lang.Double.parseDouble(Deposit.getText()),
                                    checkInDate.getValue(),
                                    offerCombo.getValue());
                        }
                        else{
                            b = new Booking(
                                    g,
                                    foundRoom,
                                    Deposit.getText() != null? java.lang.Double.parseDouble(Deposit.getText()) : 0.0,
                                    checkInDate.getValue());
                        }
                        guests.add(g);
                        bookings.add(b);
                        //send a confirmation text
                        statuesText.setText("Reservation Confirmed!\nRoom: " +
                                foundRoom.getRoomNo() +
                                "\nGuest: " + g.getName());
                        statuesText.setFill(Color.GREEN);
                    }
                }
                catch (IllegalArgumentException ex){
                    statuesText.setText(ex.getMessage());
                }
            });

            clearButton.setOnAction(e -> {
                name.clear();
                mobile.clear();
                email.clear();
                nationality.clear();
                nationalID.clear();
                gender.selectToggle(null);
                checkInDate.setValue(null);
                checkInDate.getEditor().clear();
                roomTypeCombo.getSelectionModel().clearSelection();
                roomNoCombo.getSelectionModel().clearSelection();
                offerCombo.getSelectionModel().clearSelection();
                Deposit.clear();
                statuesText.setVisible(false);
            });

            homeButton.setOnAction(e -> primary_stage.setScene(dashboard));

            // Add grids to main container
            mainContainer.getChildren().addAll(leftGrid, rightGrid);

            // Create scene with larger width
            StackPane form = new StackPane();
            form.getChildren().addAll(bg1, mainContainer);
            form.setAlignment(Pos.CENTER);
            Scene checkin = new Scene(form, 950, 700);
            primary_stage.setScene(checkin);
            primary_stage.setTitle("Hotel Check-In System");
            primary_stage.show();

        });

        mange_rooms.setOnAction(actionEvent -> {

            Image backgroundImage2 = new Image(
                    "C:\\Users\\youss\\OneDrive\\Desktop\\advanced labs" +
                            "\\course project\\Hotel System\\src\\main\\java\\com\\" +
                            "example\\hotel_system\\side_tab.png");
            ImageView bg2 = new ImageView(backgroundImage2);
            bg2.setOpacity(0.6);
            bg2.setFitWidth(1650);
            bg2.setFitHeight(900);
            bg2.setPreserveRatio(false);

            TableView roomdb = new TableView<Room>();
            TableColumn<Room, String> roomNoCol = new TableColumn<>("Room Number");
            TableColumn<Room, String> roomTypeCol = new TableColumn<>("Room Type");
            TableColumn<Room, String> priceCol = new TableColumn<>("Price");
            TableColumn<Room, String> availabilityCol = new TableColumn<>("Availability");
            roomdb.setEditable(true);

            roomNoCol.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
            roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
            priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            availabilityCol.setCellValueFactory(cellData ->
                    new ReadOnlyStringWrapper(cellData.getValue().getStatues()? "Available" : "Booked"));

            roomdb.getColumns().addAll(roomNoCol, roomTypeCol, priceCol, availabilityCol);
            roomdb.setItems(FXCollections.observableArrayList(rooms));
            roomdb.setColumnResizePolicy((TableView.CONSTRAINED_RESIZE_POLICY));
            roomdb.setStyle("-fx-max-height: 240px; " +
                    "-fx-max-width: 1400px"); // to avoid exploding table height

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(40);
            grid.setVgap(30);

            TextField roomNo = new TextField();
            roomNo.setFont(defaultFont);
            grid.add(new Label("Room Number:") {{
                setStyle(" -fx-font-size: 14px; -fx-font-weight: bold;");
            }}, 0, 1);
            grid.add(roomNo, 0, 2);

            ComboBox <String> roomTypeCombo = new ComboBox<>();
            roomTypeCombo.setStyle("-fx-font-size: 16; ");
            roomTypeCombo.getItems().addAll("Single", "Double", "Triple");
            grid.add(new Label("Room Type:") {{
                setStyle(" -fx-font-size: 14px; -fx-font-weight: bold;");
            }}, 0, 3);
            grid.add(roomTypeCombo, 0, 4);

            TextField price = new TextField();
            price.setFont(defaultFont);
            grid.add(new Label("Price:") {{
                setStyle(" -fx-font-size: 14px; -fx-font-weight: bold;");
            }}, 1, 1);
            grid.add(price, 1, 2);

            Button addRoomButton = new Button("Add Room");
            addRoomButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16; ");
            addRoomButton.setFont(defaultFont);

            Button homeButton = new Button("Home");
            homeButton.setStyle("-fx-background-color: #1035AC; -fx-text-fill: white; -fx-font-size: 16; ");
            homeButton.setFont(defaultFont);

            Button clearButton = new Button("Clear");
            clearButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-font-size: 16; ");
            clearButton.setFont(defaultFont);

            HBox buttons1 = new HBox(homeButton, clearButton, addRoomButton);
            buttons1.setAlignment(Pos.CENTER);
            buttons1.setSpacing(40);

            Text addRoomStatus = new Text();
            addRoomStatus.setFont(defaultFont);
            addRoomStatus.setFill(Color.FIREBRICK);
            addRoomStatus.setStyle(" -fx-font-size: 20px; -fx-font-weight: bold;");
            addRoomStatus.setVisible(true);

            CheckBox sort = new CheckBox("Sort by available rooms");
            sort.setFont(defaultFont);
            sort.setStyle("-fx-font-size: 17px; -fx-font-weight: bold;");
            sort.setPadding(new Insets(-12, 0, -25, 0));


            sort.setOnAction(e-> {
                Collections.sort(rooms);
                roomdb.setItems(FXCollections.observableArrayList(rooms));
            });

            VBox main_container = new VBox(roomdb, sort, grid, buttons1, addRoomStatus);
            main_container.setAlignment(Pos.CENTER);
            main_container.setSpacing(30);

            homeButton.setOnAction(e -> {
                primary_stage.setScene(dashboard);
            });

            addRoomButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String roomTypeUser = roomTypeCombo.getValue();
                    double roomPriceUser= java.lang.Double.parseDouble(price.getText());
                    String roomNoUser = roomNo.getText();
                    Room r =
                    switch (roomTypeUser) {
                        case "Single" ->
                                new Single(roomNoUser, roomPriceUser);
                        case "Double" ->
                                new Double(roomNoUser, roomPriceUser);
                        case "Triple" ->
                                new Triple(roomNoUser, roomPriceUser);
                        default -> null;
                    };

                    boolean match = rooms.stream()
                            .anyMatch(p -> p.getRoomNo().equals(roomNoUser));

                    if (match) {
                        addRoomStatus.setText("Room already Exist!");
                    }
                    else{
                        addRoomStatus.setFill(Color.GREEN);
                        addRoomStatus.setText("Room was added Successfully");
                        rooms.add(r);
                        roomdb.setItems(FXCollections.observableArrayList(rooms));
                    }
                }
            });

            clearButton.setOnAction(e -> {
                roomNo.clear();
                roomTypeCombo.getSelectionModel().clearSelection();
                price.clear();
            });

            StackPane form = new StackPane();
            form.getChildren().addAll(bg2, main_container);
            form.setAlignment(Pos.CENTER);
            Scene manage_room = new Scene(form, 950, 700);
            primary_stage.setScene(manage_room);
            primary_stage.setTitle("Hotel Check-In System");
            primary_stage.show();

        });

        check_out.setOnAction(c -> {
            Image backgroundImage2 = new Image(
                    "C:\\Users\\youss\\OneDrive\\Desktop\\advanced labs" +
                            "\\course project\\Hotel System\\src\\main\\java\\com\\" +
                            "example\\hotel_system\\side_tab.png");
            ImageView bg2 = new ImageView(backgroundImage2);
            bg2.setOpacity(0.6);
            bg2.setFitWidth(1650);
            bg2.setFitHeight(900);
            bg2.setPreserveRatio(false);

            HBox searchPart = new HBox();
            searchPart.setAlignment(Pos.CENTER);
            searchPart.setSpacing(20);

            Label searchLabel = new Label("Room Number");
            searchLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; ");

            TextField roomToSearch = new TextField();
            roomToSearch.setFont(defaultFont);

            Button searchButton = new Button("Search");
            searchButton.setStyle("-fx-background-color: #1035AC; -fx-text-fill: white; -fx-font-size: 16; ");
            searchButton.setFont(defaultFont);

            searchPart.getChildren().addAll(searchLabel, roomToSearch, searchButton);

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setVgap(20);
            grid.setHgap(80);

            grid.add(new Label("Guest Name") {{
                setStyle(" -fx-font-size: 16px; -fx-font-weight: bold;");
            }}, 0, 0);
            TextField GuestName = new TextField();
            GuestName.setFont(defaultFont);
            grid.add(GuestName, 0, 1);

            grid.add(new Label("Price per Day") {{
                setStyle(" -fx-font-size: 16px; -fx-font-weight: bold;");
            }}, 0, 2);
            TextField pricePerDay = new TextField();
            pricePerDay.setFont(defaultFont);
            grid.add(pricePerDay, 0, 3);

            grid.add(new Label("Check in Date") {{
                setStyle(" -fx-font-size: 16px; -fx-font-weight: bold;");
            }}, 0, 4);
            TextField checkInDate = new TextField();
            checkInDate.setFont(defaultFont);
            grid.add(checkInDate, 0, 5);

            grid.add(new Label("Mobile Number") {{
                setStyle(" -fx-font-size: 16px; -fx-font-weight: bold;");
            }}, 1, 0);
            TextField guestMobileNo = new TextField();
            guestMobileNo.setFont(defaultFont);
            grid.add(guestMobileNo, 1, 1);

            grid.add(new Label("Applied Offer") {{
                setStyle(" -fx-font-size: 16px; -fx-font-weight: bold;");
            }}, 1, 2);
            TextField appliedOffer = new TextField();
            appliedOffer.setFont(defaultFont);
            grid.add(appliedOffer, 1, 3);

            grid.add(new Label("Deposit") {{
                setStyle(" -fx-font-size: 16px; -fx-font-weight: bold;");
            }}, 1, 4);
            TextField Deposit = new TextField();
            Deposit.setFont(defaultFont);
            grid.add(Deposit, 1, 5);

            grid.add(new Label("Check Out Date") {{
                setStyle(" -fx-font-size: 16px; -fx-font-weight: bold;");
            }}, 2, 4);
            DatePicker checkOutdate = new DatePicker();
            grid.add(checkOutdate, 2, 5);

            grid.add(new Label("E-mail") {{
                setStyle(" -fx-font-size: 16px; -fx-font-weight: bold;");
            }}, 2, 0);
            TextField guestEmail = new TextField();
            guestEmail.setFont(defaultFont);
            grid.add(guestEmail, 2, 1);

            grid.add(new Label("Total Payment") {{
                setStyle(" -fx-font-size: 16px; -fx-font-weight: bold;");
            }}, 2, 2);
            TextField TotalPayment = new TextField();
            TotalPayment.setFont(defaultFont);
            grid.add(TotalPayment, 2, 3);

            Button clearButton = new Button("Clear");
            clearButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-font-size: 16; ");
            clearButton.setFont(defaultFont);

            Button checkOutButton = new Button("Check Out");
            checkOutButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16; ");
            checkOutButton.setFont(defaultFont);

            HBox actionButtons = new HBox(checkOutButton, clearButton);
            actionButtons.setSpacing(40);
            actionButtons.setAlignment(Pos.CENTER);
            grid.add(actionButtons, 1, 6);

            Button returnHomeButton = new Button("Home");
            returnHomeButton.setStyle("-fx-background-color: #1035AC; -fx-text-fill: white; -fx-font-size: 16; ");
            returnHomeButton.setFont(defaultFont);
            grid.add(returnHomeButton, 1, 8);
            GridPane.setHalignment(returnHomeButton, HPos.CENTER);
            GridPane.setValignment(returnHomeButton, VPos.CENTER);

            Text statuesText = new Text();
            statuesText.setFont(defaultFont);
            statuesText.setVisible(true);
            statuesText.setFill(Color.FIREBRICK);
            statuesText.setStyle(" -fx-font-size: 20px; -fx-font-weight: bold;");


            VBox main_container = new VBox(searchPart, grid, statuesText);
            main_container.setSpacing(60);
            main_container.setAlignment(Pos.CENTER);

            clearButton.setOnAction(e ->{
                roomToSearch.clear();
                GuestName.clear();
                pricePerDay.clear();
                checkInDate.clear();
                checkOutdate.getEditor().clear();;
                guestMobileNo.clear();
                appliedOffer.clear();
                Deposit.clear();
                guestEmail.clear();
                TotalPayment.clear();
                checkOutdate.getEditor().clear();;
            });

            returnHomeButton.setOnAction(e -> {primary_stage.setScene(dashboard);});

            searchButton.setOnAction(e -> {
                    String roomNosearch = roomToSearch.getText();
                    try {

                        if (roomNosearch.isEmpty())
                            throw new IllegalArgumentException("Enter a room number to search for");
                        else {
                            Booking foundbooking = bookings.stream()
                                    .filter(b -> String.valueOf(b.getRoom().getRoomNo()).equals(roomNosearch)
                                    && b.isBooked())
                                    .findFirst()
                                    .orElse(null);
                            if (foundbooking == null) throw new IllegalArgumentException("Entered room no. is not booked");
                            else {
                                if (statuesText.isVisible()) statuesText.setVisible(false);
                                GuestName.setText(foundbooking.getGuest().getName());
                                pricePerDay.setText(java.lang.Double.toString(foundbooking.getRoom().getPrice()));
                                checkInDate.setText(foundbooking.getCheckInDate().toString());
                                guestMobileNo.setText(foundbooking.getGuest().getMobileNumber());
                                appliedOffer.setText(foundbooking.getOffer() == null ? "No offers applied" : foundbooking.getOffer().getTitle());
                                Deposit.setText(java.lang.Double.toString(foundbooking.getDeposit()));
                                guestEmail.setText(foundbooking.getGuest().getEmail());

                                // Get the check-in date from the booking
                                LocalDate checkInDateToCancel = foundbooking.getCheckInDate();

                                // Configure the DatePicker to disable dates before check-in date
                                checkOutdate.setDayCellFactory(picker -> new DateCell() {
                                    @Override
                                    public void updateItem(LocalDate date, boolean empty) {
                                        super.updateItem(date, empty);

                                        // Disable dates before check-in date AND after today (optional)
                                        if (date.isBefore(checkInDateToCancel)) {
                                            setDisable(true);
                                            setStyle("-fx-background-color: #eeeeee; -fx-text-fill: #aaaaaa;");
                                        }
                                    }
                                });

                                checkOutdate.setOnAction(l -> {
                                    LocalDate datePicked = checkOutdate.getValue();
                                    foundbooking.setCheckOutDate(datePicked);
                                    TotalPayment.setText(String.format("%.2f", foundbooking.calculateTotalPayment()));
                                    checkOutButton.setOnAction(k -> {
                                        Text confirmationText = new Text("Are you sure you want to proceed with checking Out?");

                                        Button confirmButton = new Button("Confirm");
                                        confirmButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16; ");
                                        confirmButton.setFont(defaultFont);

                                        Button cancelButton = new Button("Cancel");
                                        cancelButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-font-size: 16; ");
                                        cancelButton.setFont(defaultFont);

                                        HBox twoButtons = new HBox(confirmButton, cancelButton);
                                        twoButtons.setAlignment(Pos.CENTER);
                                        twoButtons.setSpacing(20);

                                        VBox popUpContainer = new VBox(confirmationText, twoButtons);
                                        popUpContainer.setAlignment(Pos.CENTER);
                                        popUpContainer.setSpacing(30);

                                        BorderPane pane = new BorderPane();
                                        pane.setCenter(popUpContainer);
                                        Scene confirm = new Scene(pane, 300, 400);
                                        Stage message = new Stage();
                                        message.setScene(confirm);
                                        message.setTitle("Confirmation message");
                                        message.show();

                                        confirmButton.setOnAction((bookings) -> {
                                            statuesText.setVisible(true);
                                            statuesText.setText("Confirmation was done successfully!");
                                            statuesText.setFill(Color.GREEN);
                                            message.close();
                                            foundbooking.cancelBooking();
                                        });

                                        cancelButton.setOnAction(a -> {
                                            statuesText.setVisible(true);
                                            statuesText.setText("Confirmation was interrupted");
                                            message.close();
                                        });
                                    });

                                });
                            }
                        }
                    }
                    catch (IllegalArgumentException ex){
                        statuesText.setText(ex.getMessage());
                    }
            });

            StackPane stack = new StackPane(bg2, main_container);
            Scene checkout = new Scene(stack, 950, 700);
            primary_stage.setScene(checkout);
            primary_stage.setTitle("Hotel Check-In System");
            primary_stage.show();
        });
    }
}