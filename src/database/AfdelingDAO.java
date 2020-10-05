package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht
 * <p>
 * Doel
 */
public class AfdelingDAO {
    private DBaccess dBaccess;

    public AfdelingDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        if (this.dBaccess.getConnection() != null) {
            String sql = "INSERT INTO afdeling VALUES(?, ?);";
            try {
                PreparedStatement preparedStatement = this.dBaccess.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, afdeling.getAfdelingsNaam());
                preparedStatement.setString(2, afdeling.getAfdelingsPlaats());
                preparedStatement.executeUpdate();
            } catch (SQLException sqlFout) {
                System.out.println(sqlFout);
            }
        }
    }

    public ArrayList<Afdeling> geefAfdelingenMetPlaats(String afdelingsPlaats) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        if (this.dBaccess.getConnection() != null) {
            String sql2 = "SELECT * FROM afdeling WHERE afdelingsplaats = ?;";
            try {
                PreparedStatement preparedStatement = this.dBaccess.getConnection().prepareStatement(sql2);
                preparedStatement.setString(1, afdelingsPlaats);
                ResultSet resultSet = preparedStatement.executeQuery();

                System.out.println("In try block! Trying : " + preparedStatement.toString());

                while (resultSet.next()) {
                    afdelingen.add(new Afdeling(
                            resultSet.getString("afdelingsnaam"),
                            resultSet.getString("afdelingsplaats")));

                    System.out.println(resultSet.getString("afdelingsnaam") + " " +
                            resultSet.getString("afdelingsplaats"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return afdelingen;
    }
}
