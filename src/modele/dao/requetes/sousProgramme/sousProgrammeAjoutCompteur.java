package modele.dao.requetes.sousProgramme;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Compteur;
import modele.dao.SousProgramme;

public class sousProgrammeAjoutCompteur implements SousProgramme<Compteur>{

	@Override
	public String appelSousProgramme() {
		return "{call Insert_Compteur(?, ?, ?, ?, ?)}";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]);
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setString(4, parametres[3]);
		prSt.setString(5, parametres[4]);
	}

}
