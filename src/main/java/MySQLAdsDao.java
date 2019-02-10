import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config ) {
        try {

            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ad> all(){
        List<Ad> ads = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from ads");

            while (resultSet.next()){
                ads.add(new Ad(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description")));
            }
            return ads;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // insert a new ad and return the new ad's id
    public Long insert(Ad ad){
        try {
            String query = "INSERT INTO ads(title, description, user_id) " +
                    "VALUES ('"+ad.getTitle()+"', '"+ad.getDescription()+"','"+ad.getUserId()+"')";
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


