package br.unb.unbsolidaria;

import java.util.List;

import br.unb.unbsolidaria.entities.News;
import br.unb.unbsolidaria.entities.Opportunity;
import br.unb.unbsolidaria.entities.Organization;
import br.unb.unbsolidaria.entities.Voluntary;

/**
 * Created by eduar on 04/01/2017.
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    private Voluntary voluntary;
    private Organization organization;

    public static final String url = "http://164.41.209.169/users/";

    private List<Opportunity> opportunityList;
    private List<News> newsList;

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public Voluntary getVoluntary(){
        return this.voluntary;
    }

    public Organization getOrganization(){
        return this.organization;
    }

    public void setOrganization(Organization organization){
        this.organization = organization;
    }

    public void setVoluntary(Voluntary voluntary){
        this.voluntary = voluntary;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
