package database;

import model.Persoon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht
 * <p>
 * Doel
 */
public class PersoonDAO {
    private DBaccess dBaccess;

    public PersoonDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public int createPersoonGetPK(Persoon persoon) {
        int primaryKey = 0;
        if (this.dBaccess.getConnection() != null) {
            String sql = "INSERT INTO persoon(naam, woonplaats, afdeling) VALUES(?, ?, ?);";
            try {
                PreparedStatement preparedStatement = this.dBaccess.getConnection().prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, persoon.getNaam());
                preparedStatement.setString(2, persoon.getWoonplaats());
                preparedStatement.setString(3, persoon.getAfdeling().getAfdelingsNaam());
                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    primaryKey = resultSet.getInt(1);
                }
            } catch (SQLException sqlFout) {
                System.out.println(sqlFout);
            }
        }
        return primaryKey;
    }
}
