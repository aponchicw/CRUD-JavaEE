package kz.dostyk.db;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;
    private static final String url = "jdbc:postgresql://localhost:5432/dostyk_adm";
    private static final String user = "postgres";
    private static final String password = "postgres";

    static {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dostyk_adm", "postgres","postgres");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Users> getAllUsers(){
        ArrayList<Users> users = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                users.add(new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("country")));
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static Users getUser(Long id){
        Users user = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * from users WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("country"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(Users user){
        try {
            PreparedStatement statement = connection.prepareStatement("Insert into users(name, surname, country) values (?,?,?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getCountry());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveUser(Users user){
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET name = ?, surname = ?, country = ? WHERE id = ?");

            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getCountry());
            statement.setLong(4, user.getId());

            statement.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteUser(Users user){
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setLong(1, user.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
