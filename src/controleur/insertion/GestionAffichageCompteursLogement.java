package controleur.insertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Compteur;
import modele.dao.DaoCompteur;
import vue.Fenetre_Accueil;
import vue.insertion.Fenetre_AffichageCompteursLogement;
import vue.insertion.Fenetre_AffichageReleveCompteursLogement;
import vue.insertion.Fenetre_InsertionReleve;

public class GestionAffichageCompteursLogement implements ActionListener {

	private Fenetre_AffichageCompteursLogement facl;
	private DaoCompteur daoCompteur;

	// Constructeur prenant en paramètre la fenêtre d'affichage des compteurs
	public GestionAffichageCompteursLogement(Fenetre_AffichageCompteursLogement fenetre_AffichageCompteursLogement) {
		this.facl = fenetre_AffichageCompteursLogement;
		// Initialisation de l'accès à la base de données pour l'entité Compteur
		this.daoCompteur = new DaoCompteur();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.facl.getTopLevelAncestor(); // fenetre dans laquelle
																								// on ouvre des internal
																								// frame
		switch (btn.getText()) {
		case "Ajouter un relevé":
			if (Sauvegarde.onSave("Compteur") == true) {
				// Vérifie si le compteur est dans la sauvegarde avant d'ajouter un relevé
				Fenetre_InsertionReleve insertion_releve = new Fenetre_InsertionReleve();
				fenetre_Principale.getLayeredPane().add(insertion_releve);
				insertion_releve.setVisible(true);
				insertion_releve.moveToFront();
			} else {
				JOptionPane.showMessageDialog(fenetre_Principale, "Veuillez sélectionner un compteur !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}

			break;

		case "Afficher les relevés":
			if (Sauvegarde.onSave("Compteur") == true) {
				// Vérifie si le compteur est dans la sauvegarde avant d'ajouter un relevé
				Fenetre_AffichageReleveCompteursLogement affichage_releve = new Fenetre_AffichageReleveCompteursLogement();
				fenetre_Principale.getLayeredPane().add(affichage_releve);
				affichage_releve.setVisible(true);
				affichage_releve.moveToFront();

				// On charge les données au moment de l'ouverture
				try {
					affichage_releve.getGestionAffichage().chargerReleveCompteurs();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(fenetre_Principale, "Veuillez sélectionner un compteur !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Annuler":
			// Fermeture de la fenêtre
			this.facl.dispose();
			break;
		}
	}

	/**
	 * Méthode pour écrire une ligne de compteur dans la table des compteurs
	 *
	 * @param numeroLigne (int) : correspond au numéro de la ligne courante dans la
	 *                    table des compteurs
	 * @param e           (Compteur) : correspond au compteur courant
	 * @throws SQLException
	 */
	public void ecrireLigneTableCompteurs(int numeroLigne, Compteur e) throws SQLException {
		JTable tableCompteur = this.facl.getTable_compteurs();
		DefaultTableModel modeleTable = (DefaultTableModel) tableCompteur.getModel();

		modeleTable.setValueAt(e.getIdCompteur(), numeroLigne, 0);
		modeleTable.setValueAt(e.getTypeComp(), numeroLigne, 1);
		modeleTable.setValueAt(e.getPrix_abonnement(), numeroLigne, 2);
	}

	/**
	 * Méthode qui permet de charger les compteurs dans la table des compteurs
	 *
	 * @throws SQLException
	 */
	public void chargerCompteurs() throws SQLException {
		// On récupère le logement de la sauvegarde pour utiliser son ID
		Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");

		List<Compteur> compteurs = this.daoCompteur.findByIdBienListe(bienSauvegarde.getIdBien());

		DefaultTableModel modeleTable = (DefaultTableModel) this.facl.getTable_compteurs().getModel();

		modeleTable.setRowCount(compteurs.size());

		for (int i = 0; i < compteurs.size(); i++) {
			Compteur e = compteurs.get(i);
			this.ecrireLigneTableCompteurs(i, e);
		}
	}
}
