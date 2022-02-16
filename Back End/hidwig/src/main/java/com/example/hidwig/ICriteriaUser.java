package com.example.hidwig;

import java.util.List;

public interface ICriteriaUser {
    public List<User> meetCriteria(List<User> contacts, String criteria);
}
