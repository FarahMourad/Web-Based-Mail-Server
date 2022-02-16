package com.example.hidwig;

import java.util.List;

public class SearchDif  implements ICriteria{
    ICriteria criteria;
    ICriteria criteria2;
    ICriteria criteria3;
    ICriteria criteria4;
    ICriteria criteria5;
    ICriteria criteria6;
    ICriteria criteria7;
    public SearchDif(ICriteria criteria, ICriteria criteria2,ICriteria criteria3,ICriteria criteria4,ICriteria criteria5
            ,ICriteria criteria6,ICriteria criteria7){
        this.criteria = criteria;
        this.criteria2 = criteria2;
        this.criteria3 = criteria3;
        this.criteria4 = criteria4;
        this.criteria5 = criteria5;
        this.criteria6 = criteria6;
        this.criteria7 = criteria7;

    }
    @Override
    public List<Mail> meetCriteria(List<Mail> mails, String criteria) {
        List<Mail> first = this.criteria.meetCriteria( mails,criteria );
        List<Mail> second = criteria2.meetCriteria( mails,criteria );
        List<Mail> third = this.criteria3.meetCriteria( mails,criteria );
        List<Mail> fourth = criteria4.meetCriteria( mails,criteria );
        List<Mail> fifth = this.criteria5.meetCriteria( mails,criteria );
        List<Mail> sixth = criteria6.meetCriteria( mails,criteria );
        List<Mail> seventh = this.criteria7.meetCriteria( mails,criteria );
        for (Mail m :second) {
            if(!first.contains( m )){
                first.add( m );
            }
        }
        for (Mail m :third) {
            if(!first.contains( m )){
                first.add( m );
            }
        }
        for (Mail m :fourth) {
            if(!first.contains( m )){
                first.add( m );
            }
        }
        for (Mail m :fifth) {
            if(!first.contains( m )){
                first.add( m );
            }
        }
        for (Mail m :sixth) {
            if(!first.contains( m )){
                first.add( m );
            }
        }
        for (Mail m :seventh) {
            if(!first.contains( m )){
                first.add( m );
            }
        }
        return first;
    }
}
