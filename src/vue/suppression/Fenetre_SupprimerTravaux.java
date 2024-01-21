package vue.suppression;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.suppression.GestionSuppressionTravaux;

public class Fenetre_SupprimerTravaux extends JInternalFrame {
	GestionSuppressionTravaux gestionSuppressionTravaux;

	public Fenetre_SupprimerTravaux() {

		this.gestionSuppressionTravaux = new GestionSuppressionTravaux(this);

		// Paramètres de la fenêtre
		this.setBounds(100, 100, 445, 210);
		this.getContentPane().setLayout(null);

		// Message de confirmation
		JLabel lblTitre = new JLabel("Êtes-vous sûr de vouloir supprimer ?");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setBounds(52, 23, 323, 70);
		this.getContentPane().add(lblTitre);

		// Bouton supprimer
		JButton btn_supprimer = new JButton("Supprimer");
		btn_supprimer.addActionListener(this.gestionSuppressionTravaux);
		btn_supprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_supprimer.setBounds(96, 103, 103, 30);
		this.getContentPane().add(btn_supprimer);

		// Bouton annuler
		JButton btn_annuler = new JButton("Annuler");
		btn_annuler.addActionListener(this.gestionSuppressionTravaux);
		btn_annuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_annuler.setBounds(233, 103, 95, 30);
		this.getContentPane().add(btn_annuler);

	}
}
