package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private Connection connection;

    public DatabaseHelper() {
        connection = null;
        String connectionUrl = "jdbc:sqlite:test_database.sql";
        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        initDatabase();
    }

    // создаем необходимые таблицы
    public void initDatabase() {
        PreparedStatement statement = null;
        PreparedStatement feed = null;
        try {
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS channels (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "URL TEXT);");
            statement.execute();

            feed = connection.prepareStatement("CREATE TABLE IF NOT EXISTS feed (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "title TEXT, " +
                    "link TEXT," +
                    "description TEXT," +
                    "date TEXT);");
            feed.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // добавляем новый канал в базу
    public void saveChannel(String name, String URL) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO channels (name, URL) VALUES (?, ?);");
            statement.setString(1, name);
            statement.setString(2, URL);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // добавляем все новости в базу
    public void saveNews(String title, String URL, String description, String date) {
        try {
            PreparedStatement feed = connection.prepareStatement("INSERT INTO feed (title, URL, description, date) VALUES (?, ?, ?, ?);");
            feed.setString(1, title);
            feed.setString(2, URL);
            feed.setString(3, description);
            feed.setString(4, date);
            feed.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // достаем из базы все сохраненные новости
    public List<FeedEntity> getAllNews() {
        List<FeedEntity> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM feed;");
            ResultSet tableRows = statement.executeQuery();

            while (tableRows.next()) {
                FeedEntity currentEntity = new FeedEntity(tableRows.getString("title"),
                        tableRows.getString("URL"),
                        tableRows.getString("description"),
                        tableRows.getString("date"));
                result.add(currentEntity);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // достаем из базы все каналы
    public List<ChannelsEntity> getAllChannels() {
        List<ChannelsEntity> resultChannels = new ArrayList<>();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM channels;");

            ResultSet tableRows = statement.executeQuery();

            while (tableRows.next()) {
               ChannelsEntity currentEntity = new ChannelsEntity(tableRows.getString("name"),
                        tableRows.getString("URL"));

                resultChannels.add(currentEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultChannels;
    }
}
