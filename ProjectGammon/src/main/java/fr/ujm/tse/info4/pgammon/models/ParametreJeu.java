// 
//
//  @ Projet : Project Gammon
//  @ Fichier : ParametreJeu.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//




package fr.ujm.tse.info4.pgammon.models;

import org.jdom2.Element;


public class ParametreJeu
{
	private int secondesParTour;
	private int nbrPartieGagnante;
	private boolean utiliseVideau;
	public Joueur joueurBlanc;
	public Joueur joueurNoir;
	
		
	public ParametreJeu(int secondesParTour, int nbrPartieGagnante, boolean utiliseVideau,Joueur joueurBlanc,Joueur joueurNoir )
	{
		this.secondesParTour = secondesParTour;
		this.nbrPartieGagnante = nbrPartieGagnante;
		this.utiliseVideau = utiliseVideau;
		this.joueurBlanc = joueurBlanc;
		this.joueurNoir = joueurNoir;
	}


	public void sauvegarder(Element session)
	{
		Element parametres = new Element("parametres");
		session.addContent(parametres);
		
		Element secondesParTourXML = new Element("secondesParTour");
		secondesParTourXML.setText(String.valueOf(secondesParTour));
		parametres.addContent(secondesParTourXML);
	    
	    Element nbrPartieGagnanteXML = new Element("nbrPartieGagnante");
	    nbrPartieGagnanteXML.setText(String.valueOf(nbrPartieGagnante));
	    parametres.addContent(nbrPartieGagnanteXML);
	    
	    Element utiliseVideauXML = new Element("utiliseVideau");
	    if(utiliseVideau){
	    	 utiliseVideauXML.setText("1");
	    }else{
	    	 utiliseVideauXML.setText("0");
	    }
	    parametres.addContent(utiliseVideauXML);
	}
	
	public void charger(Element parametres)
	{
		 secondesParTour = Integer.valueOf(parametres.getChildText("secondesParTour"));
		 nbrPartieGagnante  = Integer.valueOf(parametres.getChildText("nbrPartieGagnante"));
		 switch(parametres.getChildText("utiliseVideau")){
			case "1":utiliseVideau = true;
			case "0":utiliseVideau =  false;
		}
	}

	
	
	
	public int getSecondesParTour() {
		return secondesParTour;
	}

	public int getNbrPartieGagnante() {
		return nbrPartieGagnante;
	}

	public boolean isUtiliseVideau() {
		return utiliseVideau;
	}

	public Joueur getJoueurBlanc() {
		return joueurBlanc;
	}

	public Joueur getJoueurNoir() {
		return joueurNoir;
	}
	
	public Joueur getJoueur(CouleurCase couleurJoueur) {
		if (couleurJoueur == CouleurCase.BLANC)
			return joueurBlanc;
		else
			return joueurNoir;
	}
	public Joueur getAdversaireJoueur(CouleurCase couleurJoueur) {
		if (couleurJoueur == CouleurCase.BLANC)
			return joueurNoir;
		else
			return joueurBlanc;
	}






}
