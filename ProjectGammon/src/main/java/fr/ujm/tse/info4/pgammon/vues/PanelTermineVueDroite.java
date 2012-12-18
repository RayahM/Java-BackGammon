package fr.ujm.tse.info4.pgammon.vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ujm.tse.info4.pgammon.gui.IconMonochromeType;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromeIconButton;
import fr.ujm.tse.info4.pgammon.models.EtatSession;

public class PanelTermineVueDroite extends JPanel{
	

	private static final long serialVersionUID = 1735758716220950070L;
	//composante des images de revoir partie
		//Composant du panel droit
		MonochromeIconButton next;
		MonochromeIconButton undo;
		MonochromeIconButton x_white;

	public PanelTermineVueDroite(){
		
		build();
	}
	

	private void build() {
		setLayout(null);
		setOpaque(false);
		
			
			//
			//panel du coté droit
			//
			
			
			
			//setOpaque(true);
			//bouton pour revoir la partie
			next = new MonochromeIconButton(IconMonochromeType.SUIVANT,"MonochromeIconButton");
			next.setSizeBig();
			next.setBounds(10, 20, next.getPreferredSize().width, next.getPreferredSize().height);
			add(next);
			
			JLabel labnext = new JLabel("<html>partie<br>suivante");
			labnext.setForeground(new Color(0xCCCCCC));
			labnext.setBounds(15, 70, 80, 60);
			add(labnext);
			
			undo = new MonochromeIconButton(IconMonochromeType.ANNULER,"MonochromeIconButton");
			undo.setSizeBig();
			undo.setBounds(10, 185, undo.getPreferredSize().width, undo.getPreferredSize().height);
			add(undo);
			
			JLabel labundo = new JLabel("<html>revoir<br>partie<br>du début");
			labundo.setForeground(new Color(0xCCCCCC));
			labundo.setBounds(10, 240, 80, 60);
			add(labundo);
			
			x_white = new MonochromeIconButton(IconMonochromeType.X_BLANC,"MonochromeIconButton");
			x_white.setSizeBig();
			x_white.setBounds(10, 350, x_white.getPreferredSize().width, x_white.getPreferredSize().height);
			add(x_white);
			
			JLabel labx_white = new JLabel("<html>Interrompre<br>la partie");
			labx_white.setForeground(new Color(0xCCCCCC));
			labx_white.setBounds(10, 400, 80, 60);
			add(labx_white);
			}
		
			
	
	
	

	public MonochromeIconButton getNext() {
		return next;
	}

	public MonochromeIconButton getUndo() {
		return undo;
	}

	public MonochromeIconButton getX_white() {
		return x_white;
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		//super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
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
		g2.dispose();
	}
	
}