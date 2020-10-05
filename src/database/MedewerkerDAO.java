package database;

import model.Werknemer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht
 * <p>
 * Doel
 */
public class MedewerkerDAO {
    private DBaccess dBaccess;

    public MedewerkerDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void slaMedewerkerOp(Werknemer werknemer) {
        PersoonDAO persoonDAO = new PersoonDAO(dBaccess);
        int primaryKey = persoonDAO.createPersoonGetPK(werknemer);

        System.out.println(primaryKey);

        if (this.dBaccess.getConnection() != null) {
            String sql = "INSERT INTO werknemer(personeelsnummer, maandsalaris) VALUES(?, ?);";
            try {
                PreparedStatement preparedStatement = this.dBaccess.getConnection().prepareStatement(sql);
                preparedStatement.setInt(1, primaryKey);
                preparedStatement.setDouble(2, werknemer.getMaandSalaris());
                preparedStatement.executeUpdate();
            } catch (SQLException sqlFout) {
                System.out.println(sqlFout);
            }
        }
    }
}
