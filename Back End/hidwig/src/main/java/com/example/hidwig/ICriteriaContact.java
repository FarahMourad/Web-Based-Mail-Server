package com.example.hidwig;

import java.util.List;

public interface ICriteriaContact {
    public List<Contacts> meetCriteria(List<Contacts> contacts, String criteria);
}
