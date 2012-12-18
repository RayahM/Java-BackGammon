// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Joueur.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.models;

import java.util.Collection;
import java.util.Iterator;

import org.jdom2.Attribute;
import org.jdom2.Element;


public class Joueur
{
	private Integer id;
	private String pseudo;
	private String imageSource;
	//private BitmapData image;
	private NiveauAssistant niveauAssistant;
	private StatistiqueJoueur stat;
	
	public Joueur()
	{
		this.id = 0;
		this.pseudo="";
		this.imageSource = "";
		this.niveauAssistant = NiveauAssistant.NON_UTILISE;
		stat = new StatistiqueJoueur();
	}

	public Joueur(Integer id,String pseudo,String imageSource,NiveauAssistant niveauAssistant)
	{
		this.id = id;
		this.pseudo=pseudo;
		this.imageSource = imageSource;
		this.niveauAssistant = niveauAssistant;
		stat = new StatistiqueJoueur();
	}
	
	public void sauvegarder(Element racine)
	{
		Element joueur = new Element("joueurs");
	    racine.addContent(joueur);
	    
	    Attribute idJoueur = new Attribute("id",id.toString());
	    joueur.setAttribute(idJoueur);
	    
		    Element pseudoJoueur = new Element("pseudo");
		    pseudoJoueur.setText(pseudo);
		    joueur.addContent(pseudoJoueur);
		    
		    Element imageSourceJoueur = new Element("imageSource");
		    imageSourceJoueur.setText(imageSource);
		    joueur.addContent(imageSourceJoueur);
		    
		    Element niveauAssistantJoueur = new Element("niveauAssistant");
		    niveauAssistantJoueur.setText(niveauAssistant.toString());
		    joueur.addContent(niveauAssistantJoueur);
		    
		    stat.sauvegarder(joueur);
		    
	}
	
	public void charger(Element joueurElement)
	{
		//TODO charger
		throw new UnsupportedOperationException();
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public NiveauAssistant getNiveauAssistant() {
		return niveauAssistant;
	}

	public void setNiveauAssistant(NiveauAssistant niveauAssistant) {
		this.niveauAssistant = niveauAssistant;
	}

	public StatistiqueJoueur getStat() {
		return stat;
	}

	public void setStat(StatistiqueJoueur stat) {
		this.stat = stat;
	}
	
	
}
