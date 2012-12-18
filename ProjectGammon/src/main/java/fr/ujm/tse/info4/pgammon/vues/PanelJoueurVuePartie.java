package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.MonochromeCheckbox;
import fr.ujm.tse.info4.pgammon.models.CouleurCase;
import fr.ujm.tse.info4.pgammon.models.Joueur;

public class PanelJoueurVuePartie extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7344853213808679707L;
	
	private Joueur joueur;
	private CouleurCase couleur;
	
	
	public static final String pionblanc = "images/big_pion_blanc.png";
	public static final String pionnoir = "images/big_pion_noir.png";
	private ImageIcon imgjoueur;
	private ImageIcon imgpion;
	
	
	private MonochromeCheckbox couppossible;
	private MonochromeCheckbox conseilcoup;
	private JLabel labNomJoueur;
	private JLabel conteneurimgjoueur;
	private JLabel conteneurimgpion;
	
		public PanelJoueurVuePartie(Joueur j,CouleurCase coul){
			joueur=j;
			couleur=coul;
			
			build();
			
		}
		
		
		public void build(){
			setLayout(null);
			
			
			//récupération de l'image
			try{
				if(couleur.equals(CouleurCase.BLANC)){
					imgpion = new ImageIcon(pionblanc);
				}
				else{
					imgpion = new ImageIcon(pionnoir);
				}
				
			}catch(Exception err){
				System.err.println(err);
			}
			
			labNomJoueur = new JLabel();
			conteneurimgjoueur = new JLabel();
			conteneurimgpion = new JLabel();
			couppossible = new MonochromeCheckbox("<html> Afficher les <br> coups possibles");
			conseilcoup = new MonochromeCheckbox("<html> conseiller le <br> prochain coup");
			
			
			JPanel centragePseudo = new JPanel();
			centragePseudo.setLayout(new BorderLayout());
			centragePseudo.setBounds(0,0,150,50);
			centragePseudo.setOpaque(false);
			//affichage des stats du joueur
			labNomJoueur.setForeground(new Color(0xCCCCCC));
			labNomJoueur.setText(joueur.getPseudo());
			//labNomJoueur.setPreferredSize(new Dimension(150,50));
			
			labNomJoueur.setHorizontalAlignment(0);
			add(centragePseudo);
			centragePseudo.add(labNomJoueur);
			
			
			//creation composant checbox
			couppossible.setForeground(new Color(0xCCCCCC));
			couppossible.setBounds(10, 120, 150, 50);
			couppossible.setOpaque(false);
			
			//creation composant checbox
			conseilcoup.setForeground(new Color(0xCCCCCC));
			conseilcoup.setBounds(10, 160, 150, 50);
			conseilcoup.setOpaque(false);
			
			//conteneurimgpion
			
			add(couppossible);
			add(conseilcoup);
			
		}
		
		
		
		public ImageIcon getImgjoueur() {
			return imgjoueur;
		}

		public void setImgjoueur(ImageIcon imgjoueur) {
			this.imgjoueur = imgjoueur;
		}

		public MonochromeCheckbox getCouppossible() {
			return couppossible;
		}

		public void setCouppossible(MonochromeCheckbox couppossible) {
			this.couppossible = couppossible;
		}

		public MonochromeCheckbox getConseilcoup() {
			return conseilcoup;
		}

		public void setConseilcoup(MonochromeCheckbox conseilcoup) {
			this.conseilcoup = conseilcoup;
		}

		public JLabel getLabNomJoueur() {
			return labNomJoueur;
		}

		public void setLabNomJoueur(JLabel affichestat) {
			this.labNomJoueur = affichestat;
		}

		public Joueur getJoueur() {
			return joueur;
		}
		

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			Graphics2D g2 = (Graphics2D) g.create(); 
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
			
			Paint p;
			int h = getHeight(); 
			int w = getWidth(); 
			
			// Arriere plan
			p = new RadialGradientPaint(new Point2D.Double(getWidth() / 2.0,
	                getHeight() / 2.0), 
	                getHeight(),
	                new float[] { 0.0f, 0.8f },
	                new Color[] { new Color(0x333333), new Color(0x000000) },
	                RadialGradientPaint.CycleMethod.NO_CYCLE);
			
			g2.setPaint(p); 
			g2.fillRect(0, 0, w, h); 
			
			// Bordure
			p = new Color(0x808080);
			g2.setStroke(new BasicStroke(5.0f) );
			g2.setPaint(p); 
			g2.drawRect(2, 0, w - 5 , h - 5);
			

			g.drawImage(imgpion.getImage(),80,55,this);
			g2.dispose(); 
			
			
		}

}