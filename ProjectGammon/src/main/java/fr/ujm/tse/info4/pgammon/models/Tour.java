// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Tour.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.models;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;


public class Tour
{
	private ArrayList<DeSixFaces> deSixFaces;
	

	private ArrayList<Deplacement> listDeplacement;
	private CouleurCase couleurJoueur;
	
	public Tour(CouleurCase couleurJoueur,ArrayList<DeSixFaces> deSixFaces)
	{
		this.couleurJoueur = couleurJoueur;
		this.deSixFaces = deSixFaces;
		this.listDeplacement = new ArrayList<Deplacement>();
	}
	
	

	public void addDeplacement(Deplacement deplacement)
	{
		listDeplacement.add(deplacement);
	}
	
	public void supprimerDernierDeplacement()
	{
		listDeplacement.remove(listDeplacement.size()-1);
	}
	
	public Deplacement getDernierDeplacement()
	{	if (listDeplacement.size()!=0)
			return listDeplacement.get(listDeplacement.size()-1);
		else
			return null;
	}
	
	
	public CouleurCase getCouleurJoueur() {
		return couleurJoueur;
	}
	
	public ArrayList<DeSixFaces> getDeSixFaces() {
		return deSixFaces;
	}
	
	public ArrayList<Deplacement> getListDeplacement(){
		return listDeplacement;
	}
	
	
	// SERIALISATION
	public void sauvegarder(Element historiqueToursJoueurXML)
	{
		Element tourXML = new Element("tour");
		historiqueToursJoueurXML.addContent(tourXML);
			
			Element couleurJoueurXML = new Element("couleurJoueur");
			couleurJoueurXML.setText(String.valueOf(couleurJoueur));
			tourXML.addContent(couleurJoueurXML);
		
			Element deSixFacesXML = new Element("deSixFaces");
			tourXML.addContent(deSixFacesXML);
			
			for(int i=0;i<deSixFaces.size();i++){
				deSixFaces.get(i).sauvegarder(deSixFacesXML);
			}
			
			Element deplacementsXML = new Element("deplacements");
			tourXML.addContent(deplacementsXML);
			
			for(int i=0;i<listDeplacement.size();i++){
				listDeplacement.get(i).sauvegarder(deplacementsXML);
			}
	}
	
	public void charger(Element partie)
	{
		partie.getChild("tour");
		
		switch(partie.getChild("tour").getChildText("couleurDame")){
			case "BLANC":couleurJoueur = CouleurCase.BLANC;
			case "NOIR":couleurJoueur = CouleurCase.NOIR;
			case "VIDE":couleurJoueur = CouleurCase.VIDE;
		}
		
		for(int i=0;i<deSixFaces.size();i++){
			deSixFaces.get(i).charger(partie.getChild("tour").getChild("deSixFaces"));
		}
		
		for(int i=0;i<listDeplacement.size();i++){
			listDeplacement.get(i).charger(partie.getChild("tour").getChild("deplacements"));
		}

	}
}
