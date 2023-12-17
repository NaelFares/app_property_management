package controleur.modification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.outils.Sauvegarde;
import modele.Bien;
import modele.Charge;
import modele.dao.DaoBien;
import modele.dao.DaoCharge;
import vue.Fenetre_Accueil;
import vue.modification.Fenetre_ModificationCharges;

public class GestionModificationCharges implements ActionListener {

	private Fenetre_ModificationCharges modificationCharge;
	private DaoCharge daoCharge;
	private DaoBien daoBien;

	public GestionModificationCharges(Fenetre_ModificationCharges modificationCharge) {
		this.modificationCharge = modificationCharge;
		this.daoCharge = new DaoCharge();
		this.daoBien = new DaoBien();
		Sauvegarde.initializeSave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		Fenetre_Accueil fenetre_Principale = (Fenetre_Accueil) this.modificationCharge.getTopLevelAncestor();

		switch (btn.getText()) {

		case "Modifier":
			try {
				int deductibleValeur = 0; // Non déductible par défaut

				// choix de la radio button
				if (this.modificationCharge.getRdbtnAjouterChargeOui().isSelected()) {
					deductibleValeur = 1;
				} else if (this.modificationCharge.getRdbtnAjouterChargeNon().isSelected()) {
					deductibleValeur = 0;
				}

				Bien bienSauvegarde = (Bien) Sauvegarde.getItem("Logement");
				Bien bienCourant;

				bienCourant = this.daoBien.findById(bienSauvegarde.getIdBien());

				Charge nouvelleCharge = new Charge(this.modificationCharge.getTextField_nomCharge().getText(),
						Double.parseDouble(this.modificationCharge.getTextField_montantPrevisionnel().getText()),
						Double.parseDouble(this.modificationCharge.getTextField_montantReel().getText()),
						deductibleValeur, bienCourant);
				this.daoCharge.update(nouvelleCharge);

				this.modificationCharge.dispose(); // Fermer la page après l'ajout

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "Annuler":
            // Vérifier si l'élément "Logement" est présent dans la sauvegarde
            if (Sauvegarde.onSave("Logement")==true) {
                // Si oui, fermer la fenêtre de modification
                this.modificationCharge.dispose();
            } else {
                // Si non, afficher un message d'avertissement ou prendre une autre action
                System.out.println("Aucun élément 'Logement' trouvé dans la sauvegarde.");
            }
            break;
    }
}}