package vue.insertion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controleur.insertion.GestionInsertionBien;
import controleur.insertion.GestionInsertionCompteur;
import controleur.insertion.GestionInsertionLogement;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class Fenetre_InsertionCompteur extends JInternalFrame {
	private JTextField textField_IdCompteur;
	private JTextField textField_IndiceCompteur;
	private GestionInsertionCompteur gestionClic;
	private JComboBox comboBox_typeDeCompteur;
	private JTextField textFieldPrixAbo;

	public Fenetre_InsertionCompteur() {
		this.gestionClic = new GestionInsertionCompteur(this);

		this.setBounds(100, 100, 762, 541);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 755, 511);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		JSeparator separator_titreInsererCompteur = new JSeparator();
		separator_titreInsererCompteur.setForeground(new Color(0, 102, 204));
		separator_titreInsererCompteur.setBounds(270, 102, 190, 2);
		panel.add(separator_titreInsererCompteur);

		JLabel lbl_InsererUnCompteur = new JLabel("Ajouter un Compteur");
		lbl_InsererUnCompteur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_InsererUnCompteur.setBounds(285, 56, 160, 48);
		panel.add(lbl_InsererUnCompteur);

		comboBox_typeDeCompteur = new JComboBox();
		comboBox_typeDeCompteur.setModel(new DefaultComboBoxModel(new String[] { "Eau", "Gaz", "Electricité" }));
		comboBox_typeDeCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Type",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		comboBox_typeDeCompteur.setBounds(270, 147, 189, 39);
		panel.add(comboBox_typeDeCompteur);

		textField_IdCompteur = new JTextField();
		textField_IdCompteur.setColumns(10);
		textField_IdCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)), "Id Compteur",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_IdCompteur.setBounds(270, 207, 190, 40);
		panel.add(textField_IdCompteur);

		textField_IndiceCompteur = new JTextField();
		textField_IndiceCompteur.setColumns(10);
		textField_IndiceCompteur.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Indice du Compteur", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textField_IndiceCompteur.setBounds(270, 273, 190, 40);
		panel.add(textField_IndiceCompteur);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.setBounds(246, 447, 94, 31);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(0, 102, 204));
		btnAjouter.addActionListener(this.gestionClic);
		panel.add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnnuler.setBounds(398, 447, 94, 31);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(0, 102, 204));
		btnAnnuler.addActionListener(this.gestionClic);
		panel.add(btnAnnuler);
		
		textFieldPrixAbo = new JTextField();
		textFieldPrixAbo.setColumns(10);
		textFieldPrixAbo.setBorder(new TitledBorder(new LineBorder(new Color(0, 102, 204)),
				"Prix de l'abonnement", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		textFieldPrixAbo.setBounds(270, 343, 190, 40);
		panel.add(textFieldPrixAbo);

	}

	public JTextField getTextField_IdCompteur() {
		return textField_IdCompteur;
	}
	
	public JTextField getTextField_textFieldPrixAbo() {
		return textFieldPrixAbo;
	}

	public JTextField getTextField_IndiceCompteur() {
		return textField_IndiceCompteur;
	}

	public JComboBox getComboBox_typeDeCompteur() {
		return comboBox_typeDeCompteur;
	}
}
