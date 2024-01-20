package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionTableEntrepriseFenetreInsertionAssurance;
import controleur.insertion.GestionInsertionAssurance;

public class Fenetre_InsertionAssurance extends JInternalFrame {
	// Champs de saisie
	private JTextField textField_numPolice;
	private JTextField textField_montant;
	private JTextField textField_dateEcheance;

	// Gestionnaires d'actions
	private GestionInsertionAssurance gestionClic;
	private GestionTableEntrepriseFenetreInsertionAssurance gtefia;

	// Boutons
	private JButton btn_ajouter_entreprise;
	private JButton btn_charger_entreprise;

	// Table pour afficher les données d'entreprise
	private JScrollPane scrollPane_table_entreprise;
	private JTable table_entreprise;

	public Fenetre_InsertionAssurance() {
		// Initialisation des gestionnaires d'actions
		this.gestionClic = new GestionInsertionAssurance(this);
		this.gtefia = new GestionTableEntrepriseFenetreInsertionAssurance(this);

		// Configuration de la fenêtre interne
		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		// Panneau principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		// Libellé "Assurance"
		JLabel lbl_InsertionAssurance = new JLabel("Assurance");
		lbl_InsertionAssurance.setBounds(302, 39, 163, 20);
		lbl_InsertionAssurance.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InsertionAssurance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lbl_InsertionAssurance);

		// Champs de saisie pour numéro de police
		this.textField_numPolice = Utils.createTextField("Numéro de police", 135, 166, 197, 40, panel, false);
		this.textField_numPolice = Utils.createTextField("Montant", 135, 229, 197, 40, panel, true);
		this.textField_numPolice = Utils.createTextField("Date échéance (YYYY-MM-JJ)", 135, 298, 197, 40, panel, true);

		// Bouton "Ajouter"
		JButton btnAjouter = Utils.creerBouton("Ajouter", 276, 431, 94, 31);
		btnAjouter.addActionListener(this.gestionClic);
		panel.add(btnAjouter);

		// Bouton "Annuler"
		JButton btnAnnuler = Utils.creerBouton("Annuler", 428, 431, 94, 31);
		btnAnnuler.addActionListener(this.gestionClic);
		panel.add(btnAnnuler);

		// Séparateur
		JSeparator separator_Assurance = new JSeparator();
		separator_Assurance.setForeground(new Color(0, 102, 204));
		separator_Assurance.setBounds(302, 72, 190, 2);
		panel.add(separator_Assurance);

		// Séparateur vertical
		JSeparator separator_vertical = new JSeparator();
		separator_vertical.setOrientation(SwingConstants.VERTICAL);
		separator_vertical.setForeground(new Color(0, 102, 204));
		separator_vertical.setBounds(385, 100, 15, 292);
		panel.add(separator_vertical);

		// Partie ENTREPRISE
		this.btn_ajouter_entreprise = Utils.creerBouton("Insérer", 518, 328, 94, 31);
		this.btn_ajouter_entreprise.addActionListener(gestionClic);
		panel.add(this.btn_ajouter_entreprise);

		this.btn_charger_entreprise = Utils.creerBouton("Charger", 412, 328, 94, 31);
		this.btn_charger_entreprise.addActionListener(gestionClic);
		panel.add(this.btn_charger_entreprise);

		// Bouton "Modifier" pour entreprise
		JButton btn_modifier_entreprise = Utils.creerBouton("Modifier", 624, 329, 94, 31);
		btn_modifier_entreprise.addActionListener(gestionClic);
		panel.add(btn_modifier_entreprise);

		// JScrollPane pour la table des entreprises
		this.scrollPane_table_entreprise = new JScrollPane();
		this.scrollPane_table_entreprise.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		this.scrollPane_table_entreprise.setBounds(443, 196, 247, 97);
		panel.add(this.scrollPane_table_entreprise);

		// Table pour afficher les données d'entreprise
		this.table_entreprise = new JTable();
		this.table_entreprise.setSelectionBackground(new Color(0, 102, 204));
		this.table_entreprise
				.setModel(new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "SIRET", "Nom" }));
		this.table_entreprise.setBounds(499, 80, 135, 16);
		scrollPane_table_entreprise.setViewportView(this.table_entreprise);
		this.table_entreprise.getSelectionModel().addListSelectionListener(this.gtefia);

		// Libellé "Entreprise"
		JLabel lbl_Entreprise = new JLabel("Entreprise");
		lbl_Entreprise.setForeground(Color.BLACK);
		lbl_Entreprise.setBackground(new Color(0, 102, 204));
		lbl_Entreprise.setBounds(529, 143, 132, 31);
		panel.add(lbl_Entreprise);
	}

	// Getters pour les champs de saisie et autres composants
	public JTextField getTextField_numPolice() {
		return this.textField_numPolice;
	}

	public JTextField getTextField_montant() {
		return this.textField_montant;
	}

	public JTextField getTextField_dateEcheance() {
		return textField_dateEcheance;
	}

	public JButton getBtn_ajouter_entreprise() {
		return btn_ajouter_entreprise;
	}

	public JButton getBtn_charger_entreprise() {
		return btn_charger_entreprise;
	}

	public JScrollPane getScrollPane_table_entreprise() {
		return scrollPane_table_entreprise;
	}

	public JTable getTable_entreprise() {
		return table_entreprise;
	}
}
