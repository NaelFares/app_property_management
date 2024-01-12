package modele.dao.requetes.sousProgramme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Impôt;

public class SousProgrammeInsertImpot implements SousProgramme<Impôt> {

	@Override
	public String appelSousProgramme() {
		return "{call Inserer_Impot(?,?,?)}";
	}

	@Override
	public void parametres(PreparedStatement prSt, String... parametres) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void parametres(PreparedStatement prSt, Impôt donnee) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void parametres(PreparedStatement prSt, Impôt donnee, int Sequence) throws SQLException {
		prSt.setString(1, donnee.getNom());
		prSt.setDouble(2, donnee.getMontant());
		prSt.setString(3, donnee.getAnnee());
	}

}