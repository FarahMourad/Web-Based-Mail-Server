package com.example.hidwig;

import java.util.List;

public interface ICriteria {
    public List<Mail> meetCriteria(List<Mail> mails, String criteria);
}
